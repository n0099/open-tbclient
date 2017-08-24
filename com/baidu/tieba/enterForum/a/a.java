package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ViewEventCenter bYx;
    private List<com.baidu.tieba.enterForum.b.c> mData = new ArrayList();
    private TbPageContext<?> oW;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.oW = tbPageContext;
        this.bYx = viewEventCenter;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size = this.mData.size();
        if (size <= 0 || i >= size) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mData == null || (i < this.mData.size() && i >= 0)) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i >= this.mData.size() || i < 0) {
            return 3;
        }
        return this.mData.get(i).getType();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.b.a aVar;
        b bVar;
        d dVar;
        C0083a c0083a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.oW.getPageActivity().getLayoutInflater().inflate(d.j.enter_forum_list_title_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mTitle = (TextView) view.findViewById(d.h.title);
                    bVar2.aWY = (TextView) view.findViewById(d.h.edit);
                    bVar2.bYA = (TextView) view.findViewById(d.h.title_tip);
                    bVar2.bYB = (ImageView) view.findViewById(d.h.divide_line_enter);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.b.d) && (dVar = (com.baidu.tieba.enterForum.b.d) this.mData.get(i)) != null) {
                    bVar.mTitle.setText(dVar.mTitle);
                    int g = dVar.bYM > 0 ? k.g(this.oW.getPageActivity(), dVar.bYM) : 0;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.mTitle.getLayoutParams();
                    layoutParams.topMargin = g;
                    bVar.mTitle.setLayoutParams(layoutParams);
                    ai.k(bVar.bYB, d.e.cp_bg_line_c);
                    ai.i(bVar.mTitle, d.e.cp_cont_d);
                    if (dVar.bYN) {
                        bVar.aWY.setVisibility(0);
                        ai.i(bVar.aWY, d.e.btn_forum_focus_color);
                        bVar.bYA.setVisibility(0);
                        ai.i(bVar.bYA, d.e.cp_cont_d);
                    } else {
                        bVar.aWY.setVisibility(8);
                        bVar.bYA.setVisibility(8);
                    }
                }
                bVar.aWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.bYx != null) {
                            a.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                        }
                    }
                });
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.c)) {
                    view = this.oW.getPageActivity().getLayoutInflater().inflate(d.j.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.c.c cVar2 = new com.baidu.tieba.enterForum.c.c(this.oW, view, this.bYx);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (com.baidu.tieba.enterForum.c.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.b.a) && (aVar = (com.baidu.tieba.enterForum.b.a) this.mData.get(i)) != null) {
                    cVar.E(aVar);
                    break;
                }
                break;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0083a)) {
                    view = this.oW.getPageActivity().getLayoutInflater().inflate(d.j.enter_forum_list_footer_item, (ViewGroup) null);
                    C0083a c0083a2 = new C0083a();
                    c0083a2.mFooterText = (TextView) view.findViewById(d.h.footer_text);
                    c0083a2.mImage = (ImageView) view.findViewById(d.h.footer_icon);
                    c0083a2.bYz = view.findViewById(d.h.container);
                    view.setTag(c0083a2);
                    c0083a = c0083a2;
                } else {
                    c0083a = (C0083a) view.getTag();
                }
                if (c0083a.bYz != null) {
                    c0083a.bYz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.bYx != null) {
                                a.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ai.c(c0083a.mImage, d.g.btn_focus_cross_bg);
                ai.i(c0083a.mFooterText, d.g.enter_forum_bar_explore);
                break;
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    public void setData(List<com.baidu.tieba.enterForum.b.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    private class b {
        TextView aWY;
        TextView bYA;
        ImageView bYB;
        TextView mTitle;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0083a {
        View bYz;
        TextView mFooterText;
        ImageView mImage;

        private C0083a() {
        }
    }
}
