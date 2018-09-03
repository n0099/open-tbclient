package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewEventCenter cRF;
    private com.baidu.tieba.enterForum.view.d cRG;
    private List<com.baidu.tieba.enterForum.data.c> mData = new ArrayList();
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.mPageContext = tbPageContext;
        this.cRF = viewEventCenter;
        this.cRG = new com.baidu.tieba.enterForum.view.d(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
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
        C0141a c0141a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(f.h.enter_forum_list_title_item, (ViewGroup) null);
                    cVar = new c();
                    cVar.mTitle = (TextView) view.findViewById(f.g.title);
                    cVar.cRJ = (ImageView) view.findViewById(f.g.divide_line_enter);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = (com.baidu.tieba.enterForum.data.d) this.mData.get(i)) != null) {
                    cVar.mTitle.setText(dVar.mTitle);
                    am.j(cVar.cRJ, f.d.cp_bg_line_c);
                    am.h(cVar.mTitle, f.d.cp_cont_d);
                    return view;
                }
                return view;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.view.b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(f.h.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.view.b bVar3 = new com.baidu.tieba.enterForum.view.b(this.mPageContext, view, this.cRF);
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
                if (view == 0 || !(view.getTag() instanceof C0141a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(f.h.enter_forum_list_footer_item, (ViewGroup) null);
                    C0141a c0141a2 = new C0141a();
                    c0141a2.mFooterText = (TextView) view.findViewById(f.g.footer_text);
                    c0141a2.mImage = (ImageView) view.findViewById(f.g.footer_icon);
                    c0141a2.cRI = view.findViewById(f.g.container);
                    view.setTag(c0141a2);
                    c0141a = c0141a2;
                } else {
                    c0141a = (C0141a) view.getTag();
                }
                if (c0141a.cRI != null) {
                    c0141a.cRI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.cRF != null) {
                                a.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                am.c(c0141a.mImage, f.C0146f.btn_focus_cross_bg);
                am.h(c0141a.mFooterText, f.C0146f.enter_forum_bar_explore);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(f.h.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar4 = new b();
                    bVar4.mImage = (ImageView) view.findViewById(f.g.image);
                    view.setTag(bVar4);
                    bVar = bVar4;
                } else {
                    bVar = (b) view.getTag();
                }
                am.c(bVar.mImage, f.C0146f.img_sign_xingqu);
                return view;
            case 4:
                View view2 = this.cRG.getView();
                this.cRG.apz();
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
        return com.baidu.tieba.enterForum.data.c.cSb.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cRG != null) {
            this.cRG.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean aop() {
        if (this.cRG == null) {
            return false;
        }
        return this.cRG.aop();
    }

    public void onDestroy() {
        if (this.cRG != null) {
            this.cRG.onDestroy();
        }
    }

    /* loaded from: classes2.dex */
    private class c {
        ImageView cRJ;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0141a {
        View cRI;
        TextView mFooterText;
        ImageView mImage;

        private C0141a() {
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        ImageView mImage;

        private b() {
        }
    }
}
