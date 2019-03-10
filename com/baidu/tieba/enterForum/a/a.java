package com.baidu.tieba.enterForum.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.b;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ViewEventCenter eBd;
    private e eBe;
    private com.baidu.tieba.enterForum.home.b eBf;
    private EnterForumModel eBg;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.b> mData = new ArrayList();
    private boolean eBh = true;
    private f.a eBi = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void ub(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void aVZ() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void uc(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.mPageContext = tbPageContext;
        this.eBd = viewEventCenter;
        this.eBe = new e(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.eBg = enterForumModel;
        this.eBf = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.eBe);
        this.eBf.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void pc(int i) {
                a.this.eBg.m(true, i);
            }
        });
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
            return 6;
        }
        return this.mData.get(i).getType();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0238a c0238a;
        c cVar;
        com.baidu.tieba.enterForum.view.c cVar2;
        com.baidu.tieba.enterForum.data.b bVar;
        d dVar;
        b bVar2;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof d)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_list_title_item, (ViewGroup) null);
                    dVar = new d();
                    dVar.mTitle = (TextView) view.findViewById(d.g.title);
                    dVar.eBq = (TextView) view.findViewById(d.g.sort_tab_menu_button);
                    dVar.cMu = (RelativeLayout) view.findViewById(d.g.container);
                    view.setTag(dVar);
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.c) {
                    com.baidu.tieba.enterForum.data.c cVar3 = (com.baidu.tieba.enterForum.data.c) this.mData.get(i);
                    this.eBf.h(dVar.eBq);
                    this.eBf.aWG();
                    if (cVar3 != null) {
                        dVar.mTitle.setText(cVar3.mTitle);
                        al.j(dVar.mTitle, d.C0236d.cp_cont_b);
                        al.l(dVar.cMu, d.C0236d.cp_bg_line_f);
                        if (dVar.eBq != null) {
                            if (cVar3.eBM) {
                                dVar.eBq.setVisibility(0);
                            } else {
                                dVar.eBq.setVisibility(8);
                            }
                            al.j(dVar.eBq, d.C0236d.cp_cont_j);
                            al.l(dVar.eBq, d.C0236d.transparent);
                            dVar.eBq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow_down_n), (Drawable) null);
                            return view;
                        }
                        return view;
                    }
                    return view;
                }
                return view;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.view.c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.home_like_list_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.eBd);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.b) && (bVar = this.mData.get(i)) != null) {
                    cVar2.af(bVar);
                    return view;
                }
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_list_footer_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mFooterText = (TextView) view.findViewById(d.g.footer_text);
                    bVar3.aIi = view.findViewById(d.g.container);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (bVar2.aIi != null) {
                    bVar2.aIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eBd != null) {
                                a.this.eBd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                al.j(bVar2.mFooterText, d.C0236d.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_interest_image_item, (ViewGroup) null);
                    c cVar5 = new c();
                    cVar5.mImage = (ImageView) view.findViewById(d.g.image);
                    cVar5.eBo = (TextView) view.findViewById(d.g.hint_text);
                    cVar5.eBp = (TextView) view.findViewById(d.g.footer_text);
                    view.setTag(cVar5);
                    cVar = cVar5;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    cVar.eBo.setVisibility(8);
                    cVar.eBp.setText(d.j.enter_forum_login_interest);
                } else {
                    cVar.eBo.setVisibility(0);
                    cVar.eBp.setText(d.j.enter_forum_explore_interest);
                }
                al.c(cVar.mImage, d.f.new_pic_emotion_gray_01);
                al.j(cVar.eBp, d.C0236d.cp_link_tip_c);
                al.j(cVar.eBo, d.C0236d.cp_cont_d);
                if (cVar.eBp != null) {
                    cVar.eBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eBd != null) {
                                a.this.eBd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.eBe.getView();
                this.eBe.aXJ();
                return view2;
            case 5:
                aVY();
                if (view == null || !(view.getTag() instanceof C0238a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.enter_forum_list_bar_creator_item, (ViewGroup) null);
                    C0238a c0238a2 = new C0238a();
                    c0238a2.mCloseButton = (ImageView) view.findViewById(d.g.creator_close);
                    c0238a2.mImage = (ImageView) view.findViewById(d.g.creator_image);
                    c0238a2.eBm = (TextView) view.findViewById(d.g.create_forum_label);
                    c0238a2.eBn = (ImageView) view.findViewById(d.g.arrow_image);
                    view.setTag(c0238a2);
                    c0238a = c0238a2;
                } else {
                    c0238a = (C0238a) view.getTag();
                }
                al.c(c0238a.mImage, d.f.pic_setup_entry);
                al.c(c0238a.mCloseButton, d.f.icon_home_card_delete);
                al.j(c0238a.eBm, d.C0236d.cp_btn_a);
                al.c(c0238a.eBn, d.f.icon_arrow12_white_right);
                if (c0238a.mCloseButton != null) {
                    c0238a.mCloseButton.setVisibility(TbadkApplication.isLogin() ? 0 : 8);
                    l.b(this.mPageContext.getPageActivity(), c0238a.mCloseButton, 20, 20, 20, 20);
                    c0238a.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            TiebaStatic.log("c13380");
                            com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(d.j.close_create_forum_tip), a.this.mPageContext.getResources().getString(d.j.close_creator), a.this.mPageContext.getResources().getString(d.j.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.4.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    r0 = null;
                                    for (com.baidu.tieba.enterForum.data.b bVar4 : a.this.mData) {
                                        if (bVar4.getType() == 5) {
                                            break;
                                        }
                                    }
                                    if (bVar4 != null) {
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_create_forum", false);
                                        a.this.mData.remove(bVar4);
                                        a.this.notifyDataSetChanged();
                                    }
                                    aVar.dismiss();
                                }
                            }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.4.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            }).aaZ();
                        }
                    });
                }
                if (c0238a.mImage != null) {
                    c0238a.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            String aWi;
                            String aWi2;
                            TiebaStatic.log("c13379");
                            if (a.this.eBg.aWX()) {
                                if (a.this.eBd != null) {
                                    a.this.eBd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                    return;
                                }
                                return;
                            }
                            boolean z = false;
                            ForumCreateInfoData aWc = a.this.eBg.aWW().aWc();
                            if (aWc != null) {
                                switch (aWc.aWh()) {
                                    case 220012:
                                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                        if (ap.isEmpty(aWc.aWi())) {
                                            aWi2 = a.this.mPageContext.getResources().getString(d.j.create_forum_block_tip);
                                        } else {
                                            aWi2 = aWc.aWi();
                                        }
                                        blockPopInfoData.block_info = aWi2;
                                        blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(d.j.create_forum_feed);
                                        blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(d.j.know);
                                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                                        AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                                        z = true;
                                        break;
                                    case 2121002:
                                        com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(d.j.create_forum_register_mobile_tip), a.this.mPageContext.getResources().getString(d.j.to_binding), a.this.mPageContext.getResources().getString(d.j.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                f.a(2121002, "", a.this.eBi);
                                                aVar.dismiss();
                                            }
                                        }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                aVar.dismiss();
                                            }
                                        }).aaZ();
                                        z = true;
                                        break;
                                }
                            }
                            if (!z) {
                                if (ap.isEmpty(aWc.aWi())) {
                                    aWi = a.this.mPageContext.getResources().getString(d.j.create_forum_err);
                                } else {
                                    aWi = aWc.aWi();
                                }
                                com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, aWi, a.this.mPageContext.getResources().getString(d.j.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                    }
                                }, (a.b) null).aaZ();
                            }
                        }
                    });
                    return view;
                }
                return view;
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
        return com.baidu.tieba.enterForum.data.b.eBL.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.b> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eBe != null) {
            this.eBe.setPageUniqueId(bdUniqueId);
        }
    }

    public void pb(int i) {
        if (this.eBf != null) {
            this.eBf.setSortType(i);
        }
    }

    public int aVW() {
        if (this.eBe == null || this.eBe.getView() == null) {
            return 0;
        }
        return this.eBe.getView().getHeight();
    }

    public boolean aVX() {
        if (this.eBe == null) {
            return false;
        }
        return this.eBe.aVX();
    }

    public void onPrimary() {
        this.eBh = true;
    }

    public void aVY() {
        if (this.eBh) {
            TiebaStatic.log("c13378");
            this.eBh = false;
        }
    }

    public void onDestroy() {
        if (this.eBe != null) {
            this.eBe.onDestroy();
        }
    }

    /* loaded from: classes4.dex */
    private class d {
        RelativeLayout cMu;
        TextView eBq;
        TextView mTitle;

        private d() {
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        View aIi;
        TextView mFooterText;

        private b() {
        }
    }

    /* loaded from: classes4.dex */
    private class c {
        TextView eBo;
        TextView eBp;
        ImageView mImage;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0238a {
        TextView eBm;
        ImageView eBn;
        ImageView mCloseButton;
        ImageView mImage;

        private C0238a() {
        }
    }
}
