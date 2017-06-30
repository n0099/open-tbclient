package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.i;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tieba.enterForum.b.c> aUW = new ArrayList();
    private TbPageContext<?> ajP;
    private ViewEventCenter bSq;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.ajP = tbPageContext;
        this.bSq = viewEventCenter;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size = this.aUW.size();
        if (size <= 0 || i >= size) {
            return null;
        }
        return this.aUW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aUW == null || (i < this.aUW.size() && i >= 0)) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i >= this.aUW.size() || i < 0) {
            return 3;
        }
        return this.aUW.get(i).getType();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar;
        com.baidu.tieba.enterForum.b.a aVar;
        b bVar;
        com.baidu.tieba.enterForum.b.d dVar;
        C0063a c0063a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.ajP.getPageActivity().getLayoutInflater().inflate(w.j.enter_forum_list_title_item, (ViewGroup) null);
                    b bVar2 = new b(this, null);
                    bVar2.mTitle = (TextView) view.findViewById(w.h.title);
                    bVar2.aUJ = (TextView) view.findViewById(w.h.edit);
                    bVar2.bSt = (TextView) view.findViewById(w.h.title_tip);
                    bVar2.bSu = (ImageView) view.findViewById(w.h.divide_line_enter);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if ((this.aUW.get(i) instanceof com.baidu.tieba.enterForum.b.d) && (dVar = (com.baidu.tieba.enterForum.b.d) this.aUW.get(i)) != null) {
                    bVar.mTitle.setText(dVar.mTitle);
                    int g = dVar.bSF > 0 ? k.g(this.ajP.getPageActivity(), dVar.bSF) : 0;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.mTitle.getLayoutParams();
                    layoutParams.topMargin = g;
                    bVar.mTitle.setLayoutParams(layoutParams);
                    as.k(bVar.bSu, w.e.cp_bg_line_c);
                    as.i(bVar.mTitle, w.e.cp_cont_d);
                    if (dVar.bSG) {
                        bVar.aUJ.setVisibility(0);
                        as.i(bVar.aUJ, w.e.btn_forum_focus_color);
                        bVar.bSt.setVisibility(0);
                        as.i(bVar.bSt, w.e.cp_cont_d);
                    } else {
                        bVar.aUJ.setVisibility(8);
                        bVar.bSt.setVisibility(8);
                    }
                }
                bVar.aUJ.setOnClickListener(new c(this));
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof i)) {
                    view = this.ajP.getPageActivity().getLayoutInflater().inflate(w.j.home_like_two_column_item, (ViewGroup) null);
                    i iVar2 = new i(this.ajP, view, this.bSq);
                    view.setTag(iVar2);
                    iVar = iVar2;
                } else {
                    iVar = (i) view.getTag();
                }
                if ((this.aUW.get(i) instanceof com.baidu.tieba.enterForum.b.a) && (aVar = (com.baidu.tieba.enterForum.b.a) this.aUW.get(i)) != null) {
                    iVar.E(aVar);
                    break;
                }
                break;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0063a)) {
                    view = this.ajP.getPageActivity().getLayoutInflater().inflate(w.j.enter_forum_list_footer_item, (ViewGroup) null);
                    C0063a c0063a2 = new C0063a(this, null);
                    c0063a2.mFooterText = (TextView) view.findViewById(w.h.footer_text);
                    c0063a2.mImage = (ImageView) view.findViewById(w.h.footer_icon);
                    c0063a2.bSs = view.findViewById(w.h.container);
                    view.setTag(c0063a2);
                    c0063a = c0063a2;
                } else {
                    c0063a = (C0063a) view.getTag();
                }
                if (c0063a.bSs != null) {
                    c0063a.bSs.setOnClickListener(new com.baidu.tieba.enterForum.a.b(this));
                }
                as.c(c0063a.mImage, w.g.btn_focus_cross_bg);
                as.i(c0063a.mFooterText, w.g.enter_forum_bar_explore);
                break;
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aUW.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    public void setData(List<com.baidu.tieba.enterForum.b.c> list) {
        this.aUW.clear();
        if (list != null) {
            this.aUW.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    private class b {
        TextView aUJ;
        TextView bSt;
        ImageView bSu;
        TextView mTitle;

        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0063a {
        View bSs;
        TextView mFooterText;
        ImageView mImage;

        private C0063a() {
        }

        /* synthetic */ C0063a(a aVar, C0063a c0063a) {
            this();
        }
    }
}
