package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewEventCenter doJ;
    private List<com.baidu.tieba.enterForum.data.c> mData = new ArrayList();
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.doJ = viewEventCenter;
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
        C0145a c0145a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_list_title_item, (ViewGroup) null);
                    cVar2 = new c();
                    cVar2.mTitle = (TextView) view.findViewById(d.g.title);
                    cVar2.bRT = (TextView) view.findViewById(d.g.edit);
                    cVar2.doM = (TextView) view.findViewById(d.g.title_tip);
                    cVar2.doN = (ImageView) view.findViewById(d.g.divide_line_enter);
                    view.setTag(cVar2);
                } else {
                    cVar2 = (c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = (com.baidu.tieba.enterForum.data.d) this.mData.get(i)) != null) {
                    cVar2.mTitle.setText(dVar.mTitle);
                    aj.t(cVar2.doN, d.C0141d.cp_bg_line_c);
                    aj.r(cVar2.mTitle, d.C0141d.cp_cont_d);
                    if (dVar.doV) {
                        cVar2.bRT.setVisibility(0);
                        aj.r(cVar2.bRT, d.C0141d.btn_forum_focus_color);
                        cVar2.doM.setVisibility(0);
                        aj.r(cVar2.doM, d.C0141d.cp_cont_d);
                    } else {
                        cVar2.bRT.setVisibility(8);
                        cVar2.doM.setVisibility(8);
                    }
                }
                cVar2.bRT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.doJ != null) {
                            a.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                        }
                    }
                });
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.home_like_two_column_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.b.c cVar3 = new com.baidu.tieba.enterForum.b.c(this.mPageContext, view, this.doJ);
                    view.setTag(cVar3);
                    cVar = cVar3;
                } else {
                    cVar = (com.baidu.tieba.enterForum.b.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) && (aVar = (com.baidu.tieba.enterForum.data.a) this.mData.get(i)) != null) {
                    cVar.aI(aVar);
                    break;
                }
                break;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0145a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_list_footer_item, (ViewGroup) null);
                    C0145a c0145a2 = new C0145a();
                    c0145a2.mFooterText = (TextView) view.findViewById(d.g.footer_text);
                    c0145a2.mImage = (ImageView) view.findViewById(d.g.footer_icon);
                    c0145a2.doL = view.findViewById(d.g.container);
                    view.setTag(c0145a2);
                    c0145a = c0145a2;
                } else {
                    c0145a = (C0145a) view.getTag();
                }
                if (c0145a.doL != null) {
                    c0145a.doL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.doJ != null) {
                                a.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                aj.c(c0145a.mImage, d.f.btn_focus_cross_bg);
                aj.r(c0145a.mFooterText, d.f.enter_forum_bar_explore);
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
        return com.baidu.tieba.enterForum.data.c.cNq.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.c> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes2.dex */
    private class c {
        TextView bRT;
        TextView doM;
        ImageView doN;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0145a {
        View doL;
        TextView mFooterText;
        ImageView mImage;

        private C0145a() {
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        ImageView mImage;

        private b() {
        }
    }
}
