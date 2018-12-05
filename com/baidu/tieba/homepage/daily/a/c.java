package com.baidu.tieba.homepage.daily.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.daily.b.c, q.a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected q.a onCreateViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        int h = l.h(context, e.C0210e.tbds16);
        int h2 = l.h(context, e.C0210e.tbds32);
        int h3 = l.h(context, e.C0210e.tbds42);
        int h4 = l.h(context, e.C0210e.tbds44);
        TextView textView = new TextView(context);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        textView.setPadding(h4, h, h4, h2);
        textView.setLayoutParams(generateLayoutParamsByParent);
        textView.setTextSize(0, h3);
        return new q.a(textView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.c cVar, q.a aVar) {
        if ((aVar.getView() instanceof TextView) && cVar != null) {
            TextView textView = (TextView) aVar.getView();
            textView.setText(cVar.aKq());
            al.h(textView, e.d.cp_cont_j);
            al.j(textView, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }
}
