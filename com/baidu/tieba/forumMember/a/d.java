package com.baidu.tieba.forumMember.a;

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
/* loaded from: classes23.dex */
public class d extends k<e, f> {
    private View.OnClickListener mOnItemClickListener;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = (e) view.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, eVar.getUserId(), eVar.getName(), "")));
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public f c(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(R.layout.manito_item_member, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) eVar, (e) fVar);
        if (eVar != null && fVar != null) {
            if (fVar.mSkinType != this.mSkinType) {
                ap.setBackgroundResource(fVar.getView(), R.drawable.frs_member_manito_bg);
                ap.setViewTextColor(fVar.egV, R.color.CAM_X0106, 1);
                ap.setViewTextColor(fVar.iOR, R.color.CAM_X0109, 1);
                ap.setBackgroundColor(fVar.dividerLine, R.color.CAM_X0204);
                ap.setViewTextColor(fVar.iOS, R.color.CAM_X0109, 1);
            }
            fVar.iOQ.startLoad(eVar.getHeadUrl(), 12, false);
            fVar.egV.setText(ae.interceptString(eVar.getNameShow(), 16));
            if (StringUtils.isNull(eVar.getIntro())) {
                fVar.iOR.setText(R.string.god_intro_default);
            } else {
                fVar.iOR.setText(ae.interceptString(eVar.getIntro(), 30));
            }
            int color = ap.getColor(R.color.CAM_X0301);
            String numberUniformFormat = au.numberUniformFormat(eVar.getFansNum());
            fVar.iOS.setText(a(String.format(this.mContext.getResources().getString(R.string.fans_count), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
            fVar.getView().setTag(eVar);
            fVar.getView().setOnClickListener(this.mOnItemClickListener);
            fVar.mSkinType = this.mSkinType;
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
