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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.h;
/* loaded from: classes5.dex */
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
    /* renamed from: aw */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(d.h.manito_item_member, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, f fVar) {
        super.onFillViewHolder(i, view, viewGroup, eVar, fVar);
        if (eVar != null && fVar != null) {
            if (fVar.mSkinType != this.mSkinType) {
                al.k(fVar.getView(), d.f.frs_member_manito_bg);
                al.d(fVar.dfp, d.C0277d.cp_cont_f, 1);
                al.d(fVar.eni, d.C0277d.cp_cont_d, 1);
                al.l(fVar.dividerLine, d.C0277d.cp_bg_line_c);
                al.d(fVar.eUW, d.C0277d.cp_cont_d, 1);
            }
            fVar.eUV.startLoad(eVar.baZ(), 12, false);
            fVar.dfp.setText(ab.ag(eVar.getNameShow(), 16));
            if (StringUtils.isNull(eVar.getIntro())) {
                fVar.eni.setText(d.j.god_intro_default);
            } else {
                fVar.eni.setText(ab.ag(eVar.getIntro(), 30));
            }
            int color = al.getColor(d.C0277d.cp_cont_h);
            String as = ap.as(eVar.getFansNum());
            fVar.eUW.setText(a(String.format(this.mContext.getResources().getString(d.j.fans_count), as), new String[]{as}, new int[]{color}));
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
