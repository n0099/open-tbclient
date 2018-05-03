package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewEventCenter cGO;
    private com.baidu.tieba.enterForum.view.d cGP;
    private List<com.baidu.tieba.enterForum.data.c> mData = new ArrayList();
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.mPageContext = tbPageContext;
        this.cGO = viewEventCenter;
        this.cGP = new com.baidu.tieba.enterForum.view.d(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        com.baidu.tieba.enterForum.view.b bVar2;
        com.baidu.tieba.enterForum.data.a aVar;
        c cVar;
        com.baidu.tieba.enterForum.data.d dVar;
        C0128a c0128a;
        switch (getItemViewType(i)) {
            case 0:
                if (view2 == null || !(view2.getTag() instanceof c)) {
                    view2 = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.enter_forum_list_title_item, (ViewGroup) null);
                    cVar = new c();
                    cVar.mTitle = (TextView) view2.findViewById(d.g.title);
                    cVar.cGS = (ImageView) view2.findViewById(d.g.divide_line_enter);
                    view2.setTag(cVar);
                } else {
                    cVar = (c) view2.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = (com.baidu.tieba.enterForum.data.d) this.mData.get(i)) != null) {
                    cVar.mTitle.setText(dVar.mTitle);
                    ak.j(cVar.cGS, d.C0126d.cp_bg_line_c);
                    ak.h(cVar.mTitle, d.C0126d.cp_cont_d);
                    return view2;
                }
                return view2;
            case 1:
                if (view2 == null || !(view2.getTag() instanceof com.baidu.tieba.enterForum.view.b)) {
                    view2 = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.view.b bVar3 = new com.baidu.tieba.enterForum.view.b(this.mPageContext, view2, this.cGO);
                    view2.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (com.baidu.tieba.enterForum.view.b) view2.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) && (aVar = (com.baidu.tieba.enterForum.data.a) this.mData.get(i)) != null) {
                    bVar2.D(aVar);
                    return view2;
                }
                return view2;
            case 2:
                if (view2 == 0 || !(view2.getTag() instanceof C0128a)) {
                    view2 = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.enter_forum_list_footer_item, (ViewGroup) null);
                    C0128a c0128a2 = new C0128a();
                    c0128a2.mFooterText = (TextView) view2.findViewById(d.g.footer_text);
                    c0128a2.mImage = (ImageView) view2.findViewById(d.g.footer_icon);
                    c0128a2.cGR = view2.findViewById(d.g.container);
                    view2.setTag(c0128a2);
                    c0128a = c0128a2;
                } else {
                    c0128a = (C0128a) view2.getTag();
                }
                if (c0128a.cGR != null) {
                    c0128a.cGR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            if (a.this.cGO != null) {
                                a.this.cGO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ak.c(c0128a.mImage, d.f.btn_focus_cross_bg);
                ak.h(c0128a.mFooterText, d.f.enter_forum_bar_explore);
                return view2;
            case 3:
                if (view2 == null || !(view2.getTag() instanceof b)) {
                    view2 = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar4 = new b();
                    bVar4.mImage = (ImageView) view2.findViewById(d.g.image);
                    view2.setTag(bVar4);
                    bVar = bVar4;
                } else {
                    bVar = (b) view2.getTag();
                }
                ak.c(bVar.mImage, d.f.img_sign_xingqu);
                return view2;
            case 4:
                View view3 = this.cGP.getView();
                this.cGP.aly();
                return view3;
            default:
                return view2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return com.baidu.tieba.enterForum.data.c.cdA.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public boolean akq() {
        if (this.cGP == null) {
            return false;
        }
        return this.cGP.akq();
    }

    public void onDestroy() {
        if (this.cGP != null) {
            this.cGP.onDestroy();
        }
    }

    /* loaded from: classes2.dex */
    private class c {
        ImageView cGS;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0128a {
        View cGR;
        TextView mFooterText;
        ImageView mImage;

        private C0128a() {
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        ImageView mImage;

        private b() {
        }
    }
}
