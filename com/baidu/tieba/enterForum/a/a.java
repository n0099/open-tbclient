package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ViewEventCenter cbt;
    private List<com.baidu.tieba.enterForum.b.c> mData = new ArrayList();
    private TbPageContext<?> mF;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mF = tbPageContext;
        this.cbt = viewEventCenter;
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
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.b.a aVar;
        c cVar2;
        d dVar;
        C0085a c0085a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mF.getPageActivity().getLayoutInflater().inflate(d.j.enter_forum_list_title_item, (ViewGroup) null);
                    c cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(d.h.title);
                    cVar3.aWJ = (TextView) view.findViewById(d.h.edit);
                    cVar3.cbw = (TextView) view.findViewById(d.h.title_tip);
                    cVar3.cbx = (ImageView) view.findViewById(d.h.divide_line_enter);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.b.d) && (dVar = (com.baidu.tieba.enterForum.b.d) this.mData.get(i)) != null) {
                    cVar2.mTitle.setText(dVar.mTitle);
                    int g = dVar.cbJ > 0 ? k.g(this.mF.getPageActivity(), dVar.cbJ) : 0;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar2.mTitle.getLayoutParams();
                    layoutParams.topMargin = g;
                    cVar2.mTitle.setLayoutParams(layoutParams);
                    aj.k(cVar2.cbx, d.e.cp_bg_line_c);
                    aj.i(cVar2.mTitle, d.e.cp_cont_d);
                    if (dVar.cbK) {
                        cVar2.aWJ.setVisibility(0);
                        aj.i(cVar2.aWJ, d.e.btn_forum_focus_color);
                        cVar2.cbw.setVisibility(0);
                        aj.i(cVar2.cbw, d.e.cp_cont_d);
                    } else {
                        cVar2.aWJ.setVisibility(8);
                        cVar2.cbw.setVisibility(8);
                    }
                }
                cVar2.aWJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.cbt != null) {
                            a.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                        }
                    }
                });
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.c)) {
                    view = this.mF.getPageActivity().getLayoutInflater().inflate(d.j.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.c.c cVar4 = new com.baidu.tieba.enterForum.c.c(this.mF, view, this.cbt);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (com.baidu.tieba.enterForum.c.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.b.a) && (aVar = (com.baidu.tieba.enterForum.b.a) this.mData.get(i)) != null) {
                    cVar.D(aVar);
                    break;
                }
                break;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0085a)) {
                    view = this.mF.getPageActivity().getLayoutInflater().inflate(d.j.enter_forum_list_footer_item, (ViewGroup) null);
                    C0085a c0085a2 = new C0085a();
                    c0085a2.mFooterText = (TextView) view.findViewById(d.h.footer_text);
                    c0085a2.mImage = (ImageView) view.findViewById(d.h.footer_icon);
                    c0085a2.cbv = view.findViewById(d.h.container);
                    view.setTag(c0085a2);
                    c0085a = c0085a2;
                } else {
                    c0085a = (C0085a) view.getTag();
                }
                if (c0085a.cbv != null) {
                    c0085a.cbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.cbt != null) {
                                a.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                aj.c(c0085a.mImage, d.g.btn_focus_cross_bg);
                aj.i(c0085a.mFooterText, d.g.enter_forum_bar_explore);
                break;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mF.getPageActivity().getLayoutInflater().inflate(d.j.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mImage = (ImageView) view.findViewById(d.h.image);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                aj.c(bVar.mImage, d.g.img_sign_xingqu);
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
        return com.baidu.tieba.enterForum.b.c.cbI.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.b.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    private class c {
        TextView aWJ;
        TextView cbw;
        ImageView cbx;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0085a {
        View cbv;
        TextView mFooterText;
        ImageView mImage;

        private C0085a() {
        }
    }

    /* loaded from: classes.dex */
    private class b {
        ImageView mImage;

        private b() {
        }
    }
}
