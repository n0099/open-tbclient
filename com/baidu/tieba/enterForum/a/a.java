package com.baidu.tieba.enterForum.a;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.b;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ViewEventCenter eXb;
    private f eXc;
    private com.baidu.tieba.enterForum.home.b eXd;
    private EnterForumModel eXe;
    private com.baidu.tieba.enterForum.data.b eXg;
    private com.baidu.tieba.enterForum.view.b eXh;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.d> mData = new ArrayList();
    private boolean eXf = true;
    private f.a eXi = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.7
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void ww(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bfK() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void wx(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.eXb = viewEventCenter;
        this.eXh = bVar;
        this.eXc = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.eXc.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bfJ() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.eXc.bhT());
                bVar.setRecentlyIsShow(a.this.eXc.isShow());
            }
        });
        this.eXe = enterForumModel;
        this.eXd = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.eXc);
        this.eXd.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void qy(int i) {
                a.this.eXe.m(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar != this.eXg) {
            this.eXg = bVar;
            if (bVar.eXL != this.eXg.eXL) {
            }
            if (bVar.eXM != this.eXg.eXM) {
            }
            if (bVar.eXN != this.eXg.eXN) {
            }
            notifyDataSetChanged();
        }
        if (this.eXc != null) {
            this.eXc.setAdState(bVar);
        }
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
        C0309a c0309a;
        c cVar;
        com.baidu.tieba.enterForum.view.c cVar2;
        com.baidu.tieba.enterForum.data.d dVar;
        d dVar2;
        b bVar;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof d)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, (ViewGroup) null);
                    dVar2 = new d();
                    dVar2.mTitle = (TextView) view.findViewById(R.id.title);
                    dVar2.eXr = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    dVar2.cXd = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(dVar2);
                } else {
                    dVar2 = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof e) {
                    e eVar = (e) this.mData.get(i);
                    this.eXd.h(dVar2.eXr);
                    this.eXd.bgA();
                    this.eXd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar != null) {
                        dVar2.mTitle.setText(eVar.mTitle);
                        am.j(dVar2.mTitle, R.color.cp_cont_b);
                        if (this.eXg != null && this.eXg.eXL) {
                            am.k(dVar2.cXd, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            am.l(dVar2.cXd, R.color.cp_bg_line_e);
                        }
                        if (dVar2.eXr != null) {
                            if (eVar.eXW) {
                                dVar2.eXr.setVisibility(0);
                            } else {
                                dVar2.eXr.setVisibility(8);
                            }
                            am.l(dVar2.eXr, R.color.transparent);
                            return view;
                        }
                        return view;
                    }
                    return view;
                }
                return view;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.view.c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, (ViewGroup) null);
                    com.baidu.tieba.enterForum.view.c cVar3 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.eXb);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = this.mData.get(i)) != null) {
                    cVar2.af(dVar);
                }
                cVar2.b(this.eXg);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    bVar2.aLm = view.findViewById(R.id.container);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (bVar.aLm != null) {
                    bVar.aLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eXb != null) {
                                a.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                am.j(bVar.mFooterText, R.color.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    c cVar4 = new c();
                    cVar4.mRoot = view.findViewById(R.id.root);
                    cVar4.mImage = (ImageView) view.findViewById(R.id.image);
                    cVar4.eXp = (TextView) view.findViewById(R.id.hint_text);
                    cVar4.eXq = (TextView) view.findViewById(R.id.footer_text);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    cVar.eXp.setVisibility(8);
                    cVar.eXq.setText(R.string.enter_forum_login_interest);
                } else {
                    cVar.eXp.setVisibility(0);
                    cVar.eXq.setText(R.string.enter_forum_explore_interest);
                }
                am.c(cVar.mImage, (int) R.drawable.new_pic_emotion_gray_01);
                am.j(cVar.eXq, R.color.cp_link_tip_c);
                am.j(cVar.eXp, R.color.cp_cont_d);
                am.l(cVar.mRoot, R.color.cp_bg_line_e);
                if (cVar.eXq != null) {
                    cVar.eXq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eXb != null) {
                                a.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.eXc.getView();
                this.eXc.bhV();
                return view2;
            case 5:
                bfI();
                if (view == null || !(view.getTag() instanceof C0309a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
                    C0309a c0309a2 = new C0309a();
                    c0309a2.mRoot = view.findViewById(R.id.container);
                    c0309a2.mCloseButton = (ImageView) view.findViewById(R.id.creator_close);
                    c0309a2.mImage = (ImageView) view.findViewById(R.id.creator_image);
                    c0309a2.eXn = (TextView) view.findViewById(R.id.create_forum_label);
                    c0309a2.eXo = (ImageView) view.findViewById(R.id.arrow_image);
                    view.setTag(c0309a2);
                    c0309a = c0309a2;
                } else {
                    c0309a = (C0309a) view.getTag();
                }
                am.c(c0309a.mImage, (int) R.drawable.pic_setup_entry);
                am.c(c0309a.mCloseButton, (int) R.drawable.icon_home_card_delete);
                am.j(c0309a.eXn, R.color.cp_cont_a);
                am.c(c0309a.eXo, (int) R.drawable.icon_arrow12_white_right);
                am.l(c0309a.mRoot, R.color.cp_bg_line_e);
                if (c0309a.mCloseButton != null) {
                    c0309a.mCloseButton.setVisibility(TbadkApplication.isLogin() ? 0 : 8);
                    l.b(this.mPageContext.getPageActivity(), c0309a.mCloseButton, 20, 20, 20, 20);
                    c0309a.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            TiebaStatic.log("c13380");
                            com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.close_create_forum_tip), a.this.mPageContext.getResources().getString(R.string.close_creator), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    r0 = null;
                                    for (com.baidu.tieba.enterForum.data.d dVar3 : a.this.mData) {
                                        if (dVar3.getType() == 5) {
                                            break;
                                        }
                                    }
                                    if (dVar3 != null) {
                                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("enter_forum_create_forum", false);
                                        a.this.mData.remove(dVar3);
                                        a.this.notifyDataSetChanged();
                                    }
                                    aVar.dismiss();
                                }
                            }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            }).agO();
                        }
                    });
                }
                if (c0309a.mImage != null) {
                    c0309a.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            String bfS;
                            String bfS2;
                            TiebaStatic.log("c13379");
                            if (a.this.eXe.bgX()) {
                                if (a.this.eXb != null) {
                                    a.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                    return;
                                }
                                return;
                            }
                            boolean z = false;
                            ForumCreateInfoData bfN = a.this.eXe.bgW().bfN();
                            if (bfN != null) {
                                switch (bfN.bfR()) {
                                    case 220012:
                                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                        if (aq.isEmpty(bfN.bfS())) {
                                            bfS2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                        } else {
                                            bfS2 = bfN.bfS();
                                        }
                                        blockPopInfoData.block_info = bfS2;
                                        blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(R.string.create_forum_feed);
                                        blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(R.string.know);
                                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                                        AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                                        z = true;
                                        break;
                                    case 2121002:
                                        com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.mPageContext.getResources().getString(R.string.to_binding), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.eXi);
                                                aVar.dismiss();
                                            }
                                        }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.2
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                aVar.dismiss();
                                            }
                                        }).agO();
                                        z = true;
                                        break;
                                }
                            }
                            if (!z) {
                                if (aq.isEmpty(bfN.bfS())) {
                                    bfS = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bfS = bfN.bfS();
                                }
                                com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, bfS, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                    }
                                }, (a.b) null).agO();
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
        return com.baidu.tieba.enterForum.data.d.eXV.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.d> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eXc != null) {
            this.eXc.setPageUniqueId(bdUniqueId);
        }
    }

    public void qx(int i) {
        if (this.eXd != null) {
            this.eXd.setSortType(i);
        }
    }

    public boolean bfH() {
        if (this.eXc == null) {
            return false;
        }
        return this.eXc.bfH();
    }

    public void onPrimary() {
        this.eXf = true;
    }

    public void bfI() {
        if (this.eXf) {
            TiebaStatic.log("c13378");
            this.eXf = false;
        }
    }

    public void onDestroy() {
        if (this.eXc != null) {
            this.eXc.onDestroy();
        }
    }

    /* loaded from: classes4.dex */
    private class d {
        RelativeLayout cXd;
        TextView eXr;
        TextView mTitle;

        private d() {
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        View aLm;
        TextView mFooterText;

        private b() {
        }
    }

    /* loaded from: classes4.dex */
    private class c {
        TextView eXp;
        TextView eXq;
        ImageView mImage;
        View mRoot;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0309a {
        TextView eXn;
        ImageView eXo;
        ImageView mCloseButton;
        ImageView mImage;
        View mRoot;

        private C0309a() {
        }
    }
}
