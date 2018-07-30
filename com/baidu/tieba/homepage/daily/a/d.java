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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
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
    /* renamed from: aN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        this.tbds42 = l.f(context, d.e.tbds42);
        this.tbds34 = l.f(context, d.e.tbds34);
        View inflate = LayoutInflater.from(context).inflate(d.h.daily_title_view, (ViewGroup) null);
        inflate.setLayoutParams(generateLayoutParamsByParent(viewGroup));
        a aVar = new a(inflate);
        aVar.bkE = inflate.findViewById(d.g.divider_line);
        aVar.dUH = (TextView) inflate.findViewById(d.g.daily_title);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.d dVar, a aVar) {
        if (aVar != null && dVar != null) {
            String aDB = !StringUtils.isNull(dVar.aDB()) ? dVar.aDB() : this.mContext.getString(d.j.daily_default_title);
            String aDA = !StringUtils.isNull(dVar.aDA()) ? dVar.aDA() : "";
            int length = aDB.length();
            int length2 = aDA.length();
            int color = am.getColor(d.C0140d.cp_cont_b);
            int color2 = am.getColor(d.C0140d.cp_cont_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDB + aDA);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds42), 0, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, length, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds34), length, length + length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color2), length, length + length2, 33);
            aVar.dUH.setText(spannableStringBuilder);
            am.h(aVar.dUH, d.C0140d.cp_cont_b);
            am.j(aVar.dUH, d.C0140d.cp_bg_line_d);
            if (dVar.aDC()) {
                aVar.bkE.setVisibility(0);
                am.j(aVar.bkE, d.C0140d.cp_bg_line_e);
            } else {
                aVar.bkE.setVisibility(8);
            }
            return aVar.getView();
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public View bkE;
        public TextView dUH;

        public a(View view) {
            super(view);
        }
    }
}
