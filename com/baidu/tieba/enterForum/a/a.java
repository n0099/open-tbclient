package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ViewEventCenter cjP;
    private List<com.baidu.tieba.enterForum.data.c> mData = new ArrayList();
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cjP = viewEventCenter;
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
            return 4;
        }
        return this.mData.get(i).getType();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        com.baidu.tieba.enterForum.b.c cVar;
        com.baidu.tieba.enterForum.data.a aVar;
        c cVar2;
        d dVar;
        C0084a c0084a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_list_title_item, (ViewGroup) null);
                    c cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(d.g.title);
                    cVar3.aYG = (TextView) view.findViewById(d.g.edit);
                    cVar3.cjS = (TextView) view.findViewById(d.g.title_tip);
                    cVar3.cjT = (ImageView) view.findViewById(d.g.divide_line_enter);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = (com.baidu.tieba.enterForum.data.d) this.mData.get(i)) != null) {
                    cVar2.mTitle.setText(dVar.mTitle);
                    int f = dVar.ckc > 0 ? l.f(this.mPageContext.getPageActivity(), dVar.ckc) : 0;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar2.mTitle.getLayoutParams();
                    layoutParams.topMargin = f;
                    cVar2.mTitle.setLayoutParams(layoutParams);
                    aj.k(cVar2.cjT, d.C0080d.cp_bg_line_c);
                    aj.i(cVar2.mTitle, d.C0080d.cp_cont_d);
                    if (dVar.ckd) {
                        cVar2.aYG.setVisibility(0);
                        aj.i(cVar2.aYG, d.C0080d.btn_forum_focus_color);
                        cVar2.cjS.setVisibility(0);
                        aj.i(cVar2.cjS, d.C0080d.cp_cont_d);
                    } else {
                        cVar2.aYG.setVisibility(8);
                        cVar2.cjS.setVisibility(8);
                    }
                }
                cVar2.aYG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.cjP != null) {
                            a.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                        }
                    }
                });
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.b.c cVar4 = new com.baidu.tieba.enterForum.b.c(this.mPageContext, view, this.cjP);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (com.baidu.tieba.enterForum.b.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) && (aVar = (com.baidu.tieba.enterForum.data.a) this.mData.get(i)) != null) {
                    cVar.D(aVar);
                    break;
                }
                break;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0084a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_list_footer_item, (ViewGroup) null);
                    C0084a c0084a2 = new C0084a();
                    c0084a2.mFooterText = (TextView) view.findViewById(d.g.footer_text);
                    c0084a2.mImage = (ImageView) view.findViewById(d.g.footer_icon);
                    c0084a2.cjR = view.findViewById(d.g.container);
                    view.setTag(c0084a2);
                    c0084a = c0084a2;
                } else {
                    c0084a = (C0084a) view.getTag();
                }
                if (c0084a.cjR != null) {
                    c0084a.cjR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.cjP != null) {
                                a.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                aj.c(c0084a.mImage, d.f.btn_focus_cross_bg);
                aj.i(c0084a.mFooterText, d.f.enter_forum_bar_explore);
                break;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mImage = (ImageView) view.findViewById(d.g.image);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                aj.c(bVar.mImage, d.f.img_sign_xingqu);
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
        return com.baidu.tieba.enterForum.data.c.ckb.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    private class c {
        TextView aYG;
        TextView cjS;
        ImageView cjT;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0084a {
        View cjR;
        TextView mFooterText;
        ImageView mImage;

        private C0084a() {
        }
    }

    /* loaded from: classes.dex */
    private class b {
        ImageView mImage;

        private b() {
        }
    }
}
