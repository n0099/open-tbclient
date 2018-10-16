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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
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
        this.tbds42 = l.h(context, e.C0175e.tbds42);
        this.tbds34 = l.h(context, e.C0175e.tbds34);
        View inflate = LayoutInflater.from(context).inflate(e.h.daily_title_view, (ViewGroup) null);
        inflate.setLayoutParams(generateLayoutParamsByParent(viewGroup));
        a aVar = new a(inflate);
        aVar.buH = inflate.findViewById(e.g.divider_line);
        aVar.ejO = (TextView) inflate.findViewById(e.g.daily_title);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.d dVar, a aVar) {
        if (aVar != null && dVar != null) {
            String aJd = !StringUtils.isNull(dVar.aJd()) ? dVar.aJd() : this.mContext.getString(e.j.daily_default_title);
            String aJc = !StringUtils.isNull(dVar.aJc()) ? dVar.aJc() : "";
            int length = aJd.length();
            int length2 = aJc.length();
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aJd + aJc);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds42), 0, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, length, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds34), length, length + length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color2), length, length + length2, 33);
            aVar.ejO.setText(spannableStringBuilder);
            al.h(aVar.ejO, e.d.cp_cont_b);
            al.j(aVar.ejO, e.d.cp_bg_line_d);
            if (dVar.aJe()) {
                aVar.buH.setVisibility(0);
                al.j(aVar.buH, e.d.cp_bg_line_e);
            } else {
                aVar.buH.setVisibility(8);
            }
            return aVar.getView();
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public View buH;
        public TextView ejO;

        public a(View view) {
            super(view);
        }
    }
}
