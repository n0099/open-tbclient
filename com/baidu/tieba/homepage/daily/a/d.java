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
    /* renamed from: bc */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        this.tbds42 = l.g(context, R.dimen.tbds42);
        this.tbds34 = l.g(context, R.dimen.tbds34);
        View inflate = LayoutInflater.from(context).inflate(R.layout.daily_title_view, (ViewGroup) null);
        inflate.setLayoutParams(generateLayoutParamsByParent(viewGroup));
        a aVar = new a(inflate);
        aVar.cSZ = inflate.findViewById(R.id.divider_line);
        aVar.fYJ = (TextView) inflate.findViewById(R.id.daily_title);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.d dVar, a aVar) {
        if (aVar != null && dVar != null) {
            String btd = !StringUtils.isNull(dVar.btd()) ? dVar.btd() : this.mContext.getString(R.string.daily_default_title);
            String btc = !StringUtils.isNull(dVar.btc()) ? dVar.btc() : "";
            int length = btd.length();
            int length2 = btc.length();
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_cont_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(btd + btc);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds42), 0, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, length, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.tbds34), length, length + length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color2), length, length + length2, 33);
            aVar.fYJ.setText(spannableStringBuilder);
            al.j(aVar.fYJ, R.color.cp_cont_b);
            al.l(aVar.fYJ, R.color.cp_bg_line_d);
            if (dVar.bte()) {
                aVar.cSZ.setVisibility(0);
                al.l(aVar.cSZ, R.color.cp_bg_line_e);
            } else {
                aVar.cSZ.setVisibility(8);
            }
            return aVar.getView();
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public View cSZ;
        public TextView fYJ;

        public a(View view) {
            super(view);
        }
    }
}
