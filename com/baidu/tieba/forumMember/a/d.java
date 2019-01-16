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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class d extends h<e, f> {
    private View.OnClickListener mOnItemClickListener;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = (e) view.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.mContext, eVar.getUserId(), eVar.getName(), "")));
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(e.h.manito_item_member, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, f fVar) {
        super.onFillViewHolder(i, view, viewGroup, eVar, fVar);
        if (eVar != null && fVar != null) {
            if (fVar.mSkinType != this.mSkinType) {
                al.i(fVar.getView(), e.f.frs_member_manito_bg);
                al.c(fVar.bPV, e.d.cp_cont_b, 1);
                al.c(fVar.ddy, e.d.cp_cont_c, 1);
                al.j(fVar.dividerLine, e.d.cp_bg_line_c);
                al.c(fVar.dHV, e.d.cp_cont_c, 1);
            }
            fVar.dHU.startLoad(eVar.aAC(), 12, false);
            fVar.bPV.setText(z.J(eVar.getNameShow(), 16));
            if (StringUtils.isNull(eVar.getIntro())) {
                fVar.ddy.setText(e.j.god_intro_default);
            } else {
                fVar.ddy.setText(z.J(eVar.getIntro(), 30));
            }
            int color = al.getColor(e.d.cp_cont_h);
            String Q = ao.Q(eVar.getFansNum());
            fVar.dHV.setText(a(String.format(this.mContext.getResources().getString(e.j.fans_count), Q), new String[]{Q}, new int[]{color}));
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
