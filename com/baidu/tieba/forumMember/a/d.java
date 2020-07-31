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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.j;
/* loaded from: classes17.dex */
public class d extends j<e, f> {
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
    public f b(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(R.layout.manito_item_member, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) eVar, (e) fVar);
        if (eVar != null && fVar != null) {
            if (fVar.mSkinType != this.mSkinType) {
                ao.setBackgroundResource(fVar.getView(), R.drawable.frs_member_manito_bg);
                ao.setViewTextColor(fVar.dpg, R.color.cp_cont_f, 1);
                ao.setViewTextColor(fVar.hBu, R.color.cp_cont_d, 1);
                ao.setBackgroundColor(fVar.dividerLine, R.color.cp_bg_line_c);
                ao.setViewTextColor(fVar.hBv, R.color.cp_cont_d, 1);
            }
            fVar.hBt.startLoad(eVar.getHeadUrl(), 12, false);
            fVar.dpg.setText(ae.interceptString(eVar.getNameShow(), 16));
            if (StringUtils.isNull(eVar.getIntro())) {
                fVar.hBu.setText(R.string.god_intro_default);
            } else {
                fVar.hBu.setText(ae.interceptString(eVar.getIntro(), 30));
            }
            int color = ao.getColor(R.color.cp_cont_h);
            String numberUniformFormat = as.numberUniformFormat(eVar.getFansNum());
            fVar.hBv.setText(a(String.format(this.mContext.getResources().getString(R.string.fans_count), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
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
