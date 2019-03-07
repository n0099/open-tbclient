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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.daily.b.c, v.a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected v.a onCreateViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        int h = l.h(context, d.e.tbds16);
        int h2 = l.h(context, d.e.tbds32);
        int h3 = l.h(context, d.e.tbds42);
        int h4 = l.h(context, d.e.tbds44);
        TextView textView = new TextView(context);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        textView.setPadding(h4, h, h4, h2);
        textView.setLayoutParams(generateLayoutParamsByParent);
        textView.setTextSize(0, h3);
        return new v.a(textView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.c cVar, v.a aVar) {
        if ((aVar.getView() instanceof TextView) && cVar != null) {
            TextView textView = (TextView) aVar.getView();
            textView.setText(cVar.blF());
            al.j(textView, d.C0236d.cp_cont_j);
            al.l(textView, d.C0236d.cp_bg_line_e);
        }
        return aVar.getView();
    }
}
