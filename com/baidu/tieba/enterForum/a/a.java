package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewEventCenter cXw;
    private com.baidu.tieba.enterForum.view.d cXx;
    private List<com.baidu.tieba.enterForum.data.c> mData = new ArrayList();
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.mPageContext = tbPageContext;
        this.cXw = viewEventCenter;
        this.cXx = new com.baidu.tieba.enterForum.view.d(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
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
        C0142a c0142a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.enter_forum_list_title_item, (ViewGroup) null);
                    cVar = new c();
                    cVar.mTitle = (TextView) view.findViewById(e.g.title);
                    cVar.cXA = (ImageView) view.findViewById(e.g.divide_line_enter);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = (com.baidu.tieba.enterForum.data.d) this.mData.get(i)) != null) {
                    cVar.mTitle.setText(dVar.mTitle);
                    al.j(cVar.cXA, e.d.cp_bg_line_c);
                    al.h(cVar.mTitle, e.d.cp_cont_d);
                    return view;
                }
                return view;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.view.b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.view.b bVar3 = new com.baidu.tieba.enterForum.view.b(this.mPageContext, view, this.cXw);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (com.baidu.tieba.enterForum.view.b) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) && (aVar = (com.baidu.tieba.enterForum.data.a) this.mData.get(i)) != null) {
                    bVar2.H(aVar);
                    return view;
                }
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0142a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.enter_forum_list_footer_item, (ViewGroup) null);
                    C0142a c0142a2 = new C0142a();
                    c0142a2.mFooterText = (TextView) view.findViewById(e.g.footer_text);
                    c0142a2.mImage = (ImageView) view.findViewById(e.g.footer_icon);
                    c0142a2.cXz = view.findViewById(e.g.container);
                    view.setTag(c0142a2);
                    c0142a = c0142a2;
                } else {
                    c0142a = (C0142a) view.getTag();
                }
                if (c0142a.cXz != null) {
                    c0142a.cXz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.cXw != null) {
                                a.this.cXw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                al.c(c0142a.mImage, e.f.btn_focus_cross_bg);
                al.h(c0142a.mFooterText, e.f.enter_forum_bar_explore);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar4 = new b();
                    bVar4.mImage = (ImageView) view.findViewById(e.g.image);
                    view.setTag(bVar4);
                    bVar = bVar4;
                } else {
                    bVar = (b) view.getTag();
                }
                al.c(bVar.mImage, e.f.img_sign_xingqu);
                return view;
            case 4:
                View view2 = this.cXx.getView();
                this.cXx.arn();
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
        return com.baidu.tieba.enterForum.data.c.cXS.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cXx != null) {
            this.cXx.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean aqe() {
        if (this.cXx == null) {
            return false;
        }
        return this.cXx.aqe();
    }

    public void onDestroy() {
        if (this.cXx != null) {
            this.cXx.onDestroy();
        }
    }

    /* loaded from: classes2.dex */
    private class c {
        ImageView cXA;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0142a {
        View cXz;
        TextView mFooterText;
        ImageView mImage;

        private C0142a() {
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        ImageView mImage;

        private b() {
        }
    }
}
