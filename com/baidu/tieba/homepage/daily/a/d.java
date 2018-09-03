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
import com.baidu.tieba.f;
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
        this.tbds42 = l.f(context, f.e.tbds42);
        this.tbds34 = l.f(context, f.e.tbds34);
        View inflate = LayoutInflater.from(context).inflate(f.h.daily_title_view, (ViewGroup) null);
        inflate.setLayoutParams(generateLayoutParamsByParent(viewGroup));
        a aVar = new a(inflate);
        aVar.bkJ = inflate.findViewById(f.g.divider_line);
        aVar.dUC = (TextView) inflate.findViewById(f.g.daily_title);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.d dVar, a aVar) {
        if (aVar != null && dVar != null) {
            String aDy = !StringUtils.isNull(dVar.aDy()) ? dVar.aDy() : this.mContext.getString(f.j.daily_default_title);
            String aDx = !StringUtils.isNull(dVar.aDx()) ? dVar.aDx() : "";
            int length = aDy.length();
            int length2 = aDx.length();
            int color = am.getColor(f.d.cp_cont_b);
            int color2 = am.getColor(f.d.cp_cont_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDy + aDx);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds42), 0, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, length, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds34), length, length + length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color2), length, length + length2, 33);
            aVar.dUC.setText(spannableStringBuilder);
            am.h(aVar.dUC, f.d.cp_cont_b);
            am.j(aVar.dUC, f.d.cp_bg_line_d);
            if (dVar.aDz()) {
                aVar.bkJ.setVisibility(0);
                am.j(aVar.bkJ, f.d.cp_bg_line_e);
            } else {
                aVar.bkJ.setVisibility(8);
            }
            return aVar.getView();
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public View bkJ;
        public TextView dUC;

        public a(View view) {
            super(view);
        }
    }
}
