package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.j;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tieba.enterForum.b.c> aTD = new ArrayList();
    private TbPageContext<?> ajh;
    private ViewEventCenter bLQ;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.ajh = tbPageContext;
        this.bLQ = viewEventCenter;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size = this.aTD.size();
        if (size <= 0 || i >= size) {
            return null;
        }
        return this.aTD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aTD == null || (i < this.aTD.size() && i >= 0)) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i >= this.aTD.size() || i < 0) {
            return 3;
        }
        return this.aTD.get(i).getType();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        com.baidu.tieba.enterForum.b.a aVar;
        b bVar;
        com.baidu.tieba.enterForum.b.d dVar;
        C0060a c0060a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.ajh.getPageActivity().getLayoutInflater().inflate(w.j.enter_forum_list_title_item, (ViewGroup) null);
                    b bVar2 = new b(this, null);
                    bVar2.mTitle = (TextView) view.findViewById(w.h.title);
                    bVar2.aTq = (TextView) view.findViewById(w.h.edit);
                    bVar2.bLT = (TextView) view.findViewById(w.h.title_tip);
                    bVar2.bLU = (ImageView) view.findViewById(w.h.divide_line_enter);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if ((this.aTD.get(i) instanceof com.baidu.tieba.enterForum.b.d) && (dVar = (com.baidu.tieba.enterForum.b.d) this.aTD.get(i)) != null) {
                    bVar.mTitle.setText(dVar.mTitle);
                    int g = dVar.bMe > 0 ? k.g(this.ajh.getPageActivity(), dVar.bMe) : 0;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.mTitle.getLayoutParams();
                    layoutParams.topMargin = g;
                    bVar.mTitle.setLayoutParams(layoutParams);
                    aq.k(bVar.bLU, w.e.cp_bg_line_c);
                    aq.i(bVar.mTitle, w.e.cp_cont_d);
                    if (dVar.bMf) {
                        bVar.aTq.setVisibility(0);
                        aq.i(bVar.aTq, w.e.btn_forum_focus_color);
                        bVar.bLT.setVisibility(0);
                        aq.i(bVar.bLT, w.e.cp_cont_d);
                    } else {
                        bVar.aTq.setVisibility(8);
                        bVar.bLT.setVisibility(8);
                    }
                }
                bVar.aTq.setOnClickListener(new c(this));
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof j)) {
                    view = this.ajh.getPageActivity().getLayoutInflater().inflate(w.j.home_like_two_column_item, (ViewGroup) null);
                    j jVar2 = new j(this.ajh, view, this.bLQ);
                    view.setTag(jVar2);
                    jVar = jVar2;
                } else {
                    jVar = (j) view.getTag();
                }
                if ((this.aTD.get(i) instanceof com.baidu.tieba.enterForum.b.a) && (aVar = (com.baidu.tieba.enterForum.b.a) this.aTD.get(i)) != null) {
                    jVar.E(aVar);
                    break;
                }
                break;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0060a)) {
                    view = this.ajh.getPageActivity().getLayoutInflater().inflate(w.j.enter_forum_list_footer_item, (ViewGroup) null);
                    C0060a c0060a2 = new C0060a(this, null);
                    c0060a2.mFooterText = (TextView) view.findViewById(w.h.footer_text);
                    c0060a2.mImage = (ImageView) view.findViewById(w.h.footer_icon);
                    c0060a2.bLS = view.findViewById(w.h.container);
                    view.setTag(c0060a2);
                    c0060a = c0060a2;
                } else {
                    c0060a = (C0060a) view.getTag();
                }
                if (c0060a.bLS != null) {
                    c0060a.bLS.setOnClickListener(new com.baidu.tieba.enterForum.a.b(this));
                }
                aq.c(c0060a.mImage, w.g.btn_focus_cross_bg);
                aq.i(c0060a.mFooterText, w.g.enter_forum_bar_explore);
                break;
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aTD.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    public void setData(List<com.baidu.tieba.enterForum.b.c> list) {
        this.aTD.clear();
        if (list != null) {
            this.aTD.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    private class b {
        TextView aTq;
        TextView bLT;
        ImageView bLU;
        TextView mTitle;

        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0060a {
        View bLS;
        TextView mFooterText;
        ImageView mImage;

        private C0060a() {
        }

        /* synthetic */ C0060a(a aVar, C0060a c0060a) {
            this();
        }
    }
}
