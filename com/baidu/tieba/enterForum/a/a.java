package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewEventCenter cRe;
    private com.baidu.tieba.enterForum.view.d cRf;
    private List<com.baidu.tieba.enterForum.data.c> mData = new ArrayList();
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.mPageContext = tbPageContext;
        this.cRe = viewEventCenter;
        this.cRf = new com.baidu.tieba.enterForum.view.d(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
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
            return 5;
        }
        return this.mData.get(i).getType();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        com.baidu.tieba.enterForum.view.b bVar2;
        com.baidu.tieba.enterForum.data.a aVar;
        c cVar;
        com.baidu.tieba.enterForum.data.d dVar;
        C0143a c0143a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.enter_forum_list_title_item, (ViewGroup) null);
                    cVar = new c();
                    cVar.mTitle = (TextView) view.findViewById(d.g.title);
                    cVar.cRi = (ImageView) view.findViewById(d.g.divide_line_enter);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = (com.baidu.tieba.enterForum.data.d) this.mData.get(i)) != null) {
                    cVar.mTitle.setText(dVar.mTitle);
                    al.j(cVar.cRi, d.C0141d.cp_bg_line_c);
                    al.h(cVar.mTitle, d.C0141d.cp_cont_d);
                    return view;
                }
                return view;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.view.b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.view.b bVar3 = new com.baidu.tieba.enterForum.view.b(this.mPageContext, view, this.cRe);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (com.baidu.tieba.enterForum.view.b) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) && (aVar = (com.baidu.tieba.enterForum.data.a) this.mData.get(i)) != null) {
                    bVar2.G(aVar);
                    return view;
                }
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0143a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.enter_forum_list_footer_item, (ViewGroup) null);
                    C0143a c0143a2 = new C0143a();
                    c0143a2.mFooterText = (TextView) view.findViewById(d.g.footer_text);
                    c0143a2.mImage = (ImageView) view.findViewById(d.g.footer_icon);
                    c0143a2.cRh = view.findViewById(d.g.container);
                    view.setTag(c0143a2);
                    c0143a = c0143a2;
                } else {
                    c0143a = (C0143a) view.getTag();
                }
                if (c0143a.cRh != null) {
                    c0143a.cRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.cRe != null) {
                                a.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                al.c(c0143a.mImage, d.f.btn_focus_cross_bg);
                al.h(c0143a.mFooterText, d.f.enter_forum_bar_explore);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar4 = new b();
                    bVar4.mImage = (ImageView) view.findViewById(d.g.image);
                    view.setTag(bVar4);
                    bVar = bVar4;
                } else {
                    bVar = (b) view.getTag();
                }
                al.c(bVar.mImage, d.f.img_sign_xingqu);
                return view;
            case 4:
                View view2 = this.cRf.getView();
                this.cRf.apE();
                return view2;
            default:
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return com.baidu.tieba.enterForum.data.c.cmA.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public boolean aow() {
        if (this.cRf == null) {
            return false;
        }
        return this.cRf.aow();
    }

    public void onDestroy() {
        if (this.cRf != null) {
            this.cRf.onDestroy();
        }
    }

    /* loaded from: classes2.dex */
    private class c {
        ImageView cRi;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0143a {
        View cRh;
        TextView mFooterText;
        ImageView mImage;

        private C0143a() {
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        ImageView mImage;

        private b() {
        }
    }
}
