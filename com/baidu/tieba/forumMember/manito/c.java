package com.baidu.tieba.forumMember.manito;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
/* loaded from: classes8.dex */
public class c extends k<d, ManitoMemberItemViewHolder> {
    private View.OnClickListener mOnItemClickListener;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.manito.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar = (d) view.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, dVar.getUserId(), dVar.getName(), "")));
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public ManitoMemberItemViewHolder e(ViewGroup viewGroup) {
        return new ManitoMemberItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.manito_item_member, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, d dVar, ManitoMemberItemViewHolder manitoMemberItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) dVar, (d) manitoMemberItemViewHolder);
        if (dVar != null && manitoMemberItemViewHolder != null) {
            if (manitoMemberItemViewHolder.mSkinType != this.mSkinType) {
                ao.setBackgroundResource(manitoMemberItemViewHolder.getView(), R.drawable.frs_member_manito_bg);
                ao.setViewTextColor(manitoMemberItemViewHolder.epX, R.color.CAM_X0106, 1);
                ao.setViewTextColor(manitoMemberItemViewHolder.jbd, R.color.CAM_X0109, 1);
                ao.setBackgroundColor(manitoMemberItemViewHolder.dividerLine, R.color.CAM_X0204);
                ao.setViewTextColor(manitoMemberItemViewHolder.jbe, R.color.CAM_X0109, 1);
            }
            manitoMemberItemViewHolder.jbc.startLoad(dVar.getHeadUrl(), 12, false);
            manitoMemberItemViewHolder.epX.setText(ad.interceptString(dVar.getNameShow(), 16));
            if (StringUtils.isNull(dVar.getIntro())) {
                manitoMemberItemViewHolder.jbd.setText(R.string.god_intro_default);
            } else {
                manitoMemberItemViewHolder.jbd.setText(ad.interceptString(dVar.getIntro(), 30));
            }
            int color = ao.getColor(R.color.CAM_X0301);
            String numberUniformFormat = at.numberUniformFormat(dVar.getFansNum());
            manitoMemberItemViewHolder.jbe.setText(a(String.format(this.mContext.getResources().getString(R.string.fans_count), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
            manitoMemberItemViewHolder.getView().setTag(dVar);
            manitoMemberItemViewHolder.getView().setOnClickListener(this.mOnItemClickListener);
            manitoMemberItemViewHolder.mSkinType = this.mSkinType;
        }
        return view;
    }

    private SpannableStringBuilder a(String str, String[] strArr, int[] iArr) {
        int indexOf;
        if (str == null || strArr == null || iArr == null || strArr.length <= 0 || iArr.length <= 0 || strArr.length != iArr.length) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(str);
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null && (indexOf = str.indexOf(strArr[i])) >= 0) {
                spannableString.setSpan(new ForegroundColorSpan(iArr[i]), indexOf, strArr[i].length() + indexOf, 17);
            }
        }
        spannableStringBuilder.append((CharSequence) spannableString);
        return spannableStringBuilder;
    }
}
