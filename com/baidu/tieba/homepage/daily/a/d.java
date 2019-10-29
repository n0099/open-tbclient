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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
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
    /* renamed from: bi */
    public a b(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        this.tbds42 = l.getDimens(context, R.dimen.tbds42);
        this.tbds34 = l.getDimens(context, R.dimen.tbds34);
        View inflate = LayoutInflater.from(context).inflate(R.layout.daily_title_view, (ViewGroup) null);
        inflate.setLayoutParams(generateLayoutParamsByParent(viewGroup));
        a aVar = new a(inflate);
        aVar.deR = inflate.findViewById(R.id.divider_line);
        aVar.gfN = (TextView) inflate.findViewById(R.id.daily_title);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.d dVar, a aVar) {
        if (aVar != null && dVar != null) {
            String btm = !StringUtils.isNull(dVar.btm()) ? dVar.btm() : this.mContext.getString(R.string.daily_default_title);
            String btl = !StringUtils.isNull(dVar.btl()) ? dVar.btl() : "";
            int length = btm.length();
            int length2 = btl.length();
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(btm + btl);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds42), 0, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, length, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds34), length, length + length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color2), length, length + length2, 33);
            aVar.gfN.setText(spannableStringBuilder);
            am.setViewTextColor(aVar.gfN, (int) R.color.cp_cont_b);
            am.setBackgroundColor(aVar.gfN, R.color.cp_bg_line_d);
            if (dVar.btn()) {
                aVar.deR.setVisibility(0);
                am.setBackgroundColor(aVar.deR, R.color.cp_bg_line_e);
            } else {
                aVar.deR.setVisibility(8);
            }
            return aVar.getView();
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public View deR;
        public TextView gfN;

        public a(View view) {
            super(view);
        }
    }
}
