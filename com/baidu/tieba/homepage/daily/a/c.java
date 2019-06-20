package com.baidu.tieba.homepage.daily.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.daily.b.c, v.a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected v.a onCreateViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        int g = l.g(context, R.dimen.tbds16);
        int g2 = l.g(context, R.dimen.tbds32);
        int g3 = l.g(context, R.dimen.tbds42);
        int g4 = l.g(context, R.dimen.tbds44);
        TextView textView = new TextView(context);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        textView.setPadding(g4, g, g4, g2);
        textView.setLayoutParams(generateLayoutParamsByParent);
        textView.setTextSize(0, g3);
        return new v.a(textView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.c cVar, v.a aVar) {
        if ((aVar.getView() instanceof TextView) && cVar != null) {
            TextView textView = (TextView) aVar.getView();
            textView.setText(cVar.btc());
            al.j(textView, R.color.cp_cont_j);
            al.l(textView, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }
}
