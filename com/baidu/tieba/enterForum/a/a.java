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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.b;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.enterForum.view.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ViewEventCenter eQo;
    private f eQp;
    private com.baidu.tieba.enterForum.home.b eQq;
    private EnterForumModel eQr;
    private com.baidu.tieba.enterForum.data.b eQt;
    private com.baidu.tieba.enterForum.view.b eQu;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.d> mData = new ArrayList();
    private boolean eQs = true;
    private f.a eQv = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.8
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void vr(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bdc() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void vs(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.eQo = viewEventCenter;
        this.eQu = bVar;
        this.eQp = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.eQp.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bdb() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.eQp.beY());
                bVar.setRecentlyIsShow(a.this.eQp.isShow());
            }
        });
        this.eQr = enterForumModel;
        this.eQq = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.eQp);
        this.eQq.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void qc(int i) {
                a.this.eQr.m(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar != this.eQt) {
            this.eQt = bVar;
            if (bVar.eQV != this.eQt.eQV) {
            }
            if (bVar.eQW != this.eQt.eQW) {
            }
            if (bVar.eQX != this.eQt.eQX) {
            }
            notifyDataSetChanged();
        }
        if (this.eQp != null) {
            this.eQp.setAdState(bVar);
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
        C0297a c0297a;
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
                    dVar2.eQE = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    dVar2.cUH = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(dVar2);
                    dVar2.cUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!a.this.eQp.beY() || !a.this.eQp.isShow()) {
                                EnterForumAdView.a(a.this.mPageContext.getUniqueId(), a.this.mPageContext.getPageActivity());
                            }
                        }
                    });
                } else {
                    dVar2 = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof e) {
                    e eVar = (e) this.mData.get(i);
                    this.eQq.h(dVar2.eQE);
                    this.eQq.bdR();
                    if (eVar != null) {
                        dVar2.mTitle.setText(eVar.mTitle);
                        if (this.eQt != null && this.eQt.eQV) {
                            if (this.eQp.isShow()) {
                                if (this.eQp.beY()) {
                                    al.j(dVar2.mTitle, R.color.cp_cont_b);
                                    al.l(dVar2.cUH, R.color.cp_bg_line_f);
                                } else {
                                    al.j(dVar2.mTitle, R.color.cp_btn_a);
                                    dVar2.cUH.setBackgroundColor(0);
                                }
                            } else {
                                al.j(dVar2.mTitle, R.color.cp_btn_a);
                                dVar2.cUH.setBackgroundColor(0);
                            }
                        } else {
                            al.j(dVar2.mTitle, R.color.cp_cont_b);
                            al.l(dVar2.cUH, R.color.cp_bg_line_f);
                        }
                        if (dVar2.eQE != null) {
                            if (eVar.eRg) {
                                dVar2.eQE.setVisibility(0);
                            } else {
                                dVar2.eQE.setVisibility(8);
                            }
                            al.l(dVar2.eQE, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar3 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.eQo);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = this.mData.get(i)) != null) {
                    cVar2.af(dVar);
                }
                cVar2.b(this.eQt);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    bVar2.aKg = view.findViewById(R.id.container);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (bVar.aKg != null) {
                    bVar.aKg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eQo != null) {
                                a.this.eQo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                al.j(bVar.mFooterText, R.color.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    c cVar4 = new c();
                    cVar4.bBg = view.findViewById(R.id.root);
                    cVar4.mImage = (ImageView) view.findViewById(R.id.image);
                    cVar4.eQC = (TextView) view.findViewById(R.id.hint_text);
                    cVar4.eQD = (TextView) view.findViewById(R.id.footer_text);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    cVar.eQC.setVisibility(8);
                    cVar.eQD.setText(R.string.enter_forum_login_interest);
                } else {
                    cVar.eQC.setVisibility(0);
                    cVar.eQD.setText(R.string.enter_forum_explore_interest);
                }
                al.c(cVar.mImage, (int) R.drawable.new_pic_emotion_gray_01);
                al.j(cVar.eQD, R.color.cp_link_tip_c);
                al.j(cVar.eQC, R.color.cp_cont_d);
                al.l(cVar.bBg, R.color.cp_bg_line_d);
                if (cVar.eQD != null) {
                    cVar.eQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eQo != null) {
                                a.this.eQo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.eQp.getView();
                this.eQp.bfa();
                return view2;
            case 5:
                bda();
                if (view == null || !(view.getTag() instanceof C0297a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
                    C0297a c0297a2 = new C0297a();
                    c0297a2.bBg = view.findViewById(R.id.container);
                    c0297a2.mCloseButton = (ImageView) view.findViewById(R.id.creator_close);
                    c0297a2.mImage = (ImageView) view.findViewById(R.id.creator_image);
                    c0297a2.eQA = (TextView) view.findViewById(R.id.create_forum_label);
                    c0297a2.eQB = (ImageView) view.findViewById(R.id.arrow_image);
                    view.setTag(c0297a2);
                    c0297a = c0297a2;
                } else {
                    c0297a = (C0297a) view.getTag();
                }
                al.c(c0297a.mImage, (int) R.drawable.pic_setup_entry);
                al.c(c0297a.mCloseButton, (int) R.drawable.icon_home_card_delete);
                al.j(c0297a.eQA, R.color.cp_btn_a);
                al.c(c0297a.eQB, (int) R.drawable.icon_arrow12_white_right);
                al.l(c0297a.bBg, R.color.cp_bg_line_d);
                if (c0297a.mCloseButton != null) {
                    c0297a.mCloseButton.setVisibility(TbadkApplication.isLogin() ? 0 : 8);
                    l.b(this.mPageContext.getPageActivity(), c0297a.mCloseButton, 20, 20, 20, 20);
                    c0297a.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            TiebaStatic.log("c13380");
                            com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.close_create_forum_tip), a.this.mPageContext.getResources().getString(R.string.close_creator), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    r0 = null;
                                    for (com.baidu.tieba.enterForum.data.d dVar3 : a.this.mData) {
                                        if (dVar3.getType() == 5) {
                                            break;
                                        }
                                    }
                                    if (dVar3 != null) {
                                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_create_forum", false);
                                        a.this.mData.remove(dVar3);
                                        a.this.notifyDataSetChanged();
                                    }
                                    aVar.dismiss();
                                }
                            }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            }).afG();
                        }
                    });
                }
                if (c0297a.mImage != null) {
                    c0297a.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            String bdk;
                            String bdk2;
                            TiebaStatic.log("c13379");
                            if (a.this.eQr.bel()) {
                                if (a.this.eQo != null) {
                                    a.this.eQo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                    return;
                                }
                                return;
                            }
                            boolean z = false;
                            ForumCreateInfoData bdf = a.this.eQr.bek().bdf();
                            if (bdf != null) {
                                switch (bdf.bdj()) {
                                    case 220012:
                                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                        if (ap.isEmpty(bdf.bdk())) {
                                            bdk2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                        } else {
                                            bdk2 = bdf.bdk();
                                        }
                                        blockPopInfoData.block_info = bdk2;
                                        blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(R.string.create_forum_feed);
                                        blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(R.string.know);
                                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                                        AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                                        z = true;
                                        break;
                                    case 2121002:
                                        com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.mPageContext.getResources().getString(R.string.to_binding), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                com.baidu.tieba.tbadkCore.util.f.a(2121002, "", a.this.eQv);
                                                aVar.dismiss();
                                            }
                                        }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.7.2
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                aVar.dismiss();
                                            }
                                        }).afG();
                                        z = true;
                                        break;
                                }
                            }
                            if (!z) {
                                if (ap.isEmpty(bdf.bdk())) {
                                    bdk = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bdk = bdf.bdk();
                                }
                                com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, bdk, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.7.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                    }
                                }, (a.b) null).afG();
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
        return com.baidu.tieba.enterForum.data.d.eRf.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.d> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eQp != null) {
            this.eQp.setPageUniqueId(bdUniqueId);
        }
    }

    public void qb(int i) {
        if (this.eQq != null) {
            this.eQq.setSortType(i);
        }
    }

    public boolean bcZ() {
        if (this.eQp == null) {
            return false;
        }
        return this.eQp.bcZ();
    }

    public void onPrimary() {
        this.eQs = true;
    }

    public void bda() {
        if (this.eQs) {
            TiebaStatic.log("c13378");
            this.eQs = false;
        }
    }

    public void onDestroy() {
        if (this.eQp != null) {
            this.eQp.onDestroy();
        }
    }

    /* loaded from: classes4.dex */
    private class d {
        RelativeLayout cUH;
        TextView eQE;
        TextView mTitle;

        private d() {
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        View aKg;
        TextView mFooterText;

        private b() {
        }
    }

    /* loaded from: classes4.dex */
    private class c {
        View bBg;
        TextView eQC;
        TextView eQD;
        ImageView mImage;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0297a {
        View bBg;
        TextView eQA;
        ImageView eQB;
        ImageView mCloseButton;
        ImageView mImage;

        private C0297a() {
        }
    }
}
