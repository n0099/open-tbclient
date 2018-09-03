package com.baidu.tieba.homepage.daily.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.daily.b.c, q.a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected q.a onCreateViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        int f = l.f(context, f.e.tbds16);
        int f2 = l.f(context, f.e.tbds32);
        int f3 = l.f(context, f.e.tbds42);
        int f4 = l.f(context, f.e.tbds44);
        TextView textView = new TextView(context);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        textView.setPadding(f4, f, f4, f2);
        textView.setLayoutParams(generateLayoutParamsByParent);
        textView.setTextSize(0, f3);
        return new q.a(textView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.daily.b.c cVar, q.a aVar) {
        if ((aVar.getView() instanceof TextView) && cVar != null) {
            TextView textView = (TextView) aVar.getView();
            textView.setText(cVar.aDw());
            am.h(textView, f.d.cp_cont_j);
            am.j(textView, f.d.cp_bg_line_e);
        }
        return aVar.getView();
    }
}
