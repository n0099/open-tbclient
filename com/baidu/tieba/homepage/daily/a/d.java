package com.baidu.tieba.homepage.daily.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.daily.b.d, a> {
    private int tbds34;
    private int tbds42;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        this.tbds42 = l.h(context, d.e.tbds42);
        this.tbds34 = l.h(context, d.e.tbds34);
        View inflate = LayoutInflater.from(context).inflate(d.h.daily_title_view, (ViewGroup) null);
        inflate.setLayoutParams(generateLayoutParamsByParent(viewGroup));
        a aVar = new a(inflate);
        aVar.cKN = inflate.findViewById(d.g.divider_line);
        aVar.fIa = (TextView) inflate.findViewById(d.g.daily_title);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.d dVar, a aVar) {
        if (aVar != null && dVar != null) {
            String blI = !StringUtils.isNull(dVar.blI()) ? dVar.blI() : this.mContext.getString(d.j.daily_default_title);
            String blH = !StringUtils.isNull(dVar.blH()) ? dVar.blH() : "";
            int length = blI.length();
            int length2 = blH.length();
            int color = al.getColor(d.C0236d.cp_cont_b);
            int color2 = al.getColor(d.C0236d.cp_cont_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(blI + blH);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds42), 0, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, length, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds34), length, length + length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color2), length, length + length2, 33);
            aVar.fIa.setText(spannableStringBuilder);
            al.j(aVar.fIa, d.C0236d.cp_cont_b);
            al.l(aVar.fIa, d.C0236d.cp_bg_line_d);
            if (dVar.blJ()) {
                aVar.cKN.setVisibility(0);
                al.l(aVar.cKN, d.C0236d.cp_bg_line_e);
            } else {
                aVar.cKN.setVisibility(8);
            }
            return aVar.getView();
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public View cKN;
        public TextView fIa;

        public a(View view) {
            super(view);
        }
    }
}
