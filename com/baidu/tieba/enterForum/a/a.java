package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private EnterForumModel fTA;
    private com.baidu.tieba.enterForum.data.b fTC;
    private com.baidu.tieba.enterForum.view.b fTD;
    private ViewEventCenter fTx;
    private f fTy;
    private com.baidu.tieba.enterForum.home.b fTz;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.d> mData = new ArrayList();
    private boolean fTB = true;
    private f.a fTE = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.7
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void An(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bxH() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Ao(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.fTx = viewEventCenter;
        this.fTD = bVar;
        this.fTy = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.fTy.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bxG() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.fTy.bzL());
                bVar.setRecentlyIsShow(a.this.fTy.isShow());
            }
        });
        this.fTA = enterForumModel;
        this.fTz = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.fTy);
        this.fTz.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void rL(int i) {
                a.this.fTA.s(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar != this.fTC) {
            this.fTC = bVar;
            if (bVar.fUg != this.fTC.fUg) {
            }
            if (bVar.fUh != this.fTC.fUh) {
            }
            if (bVar.fUi != this.fTC.fUi) {
            }
            notifyDataSetChanged();
        }
        if (this.fTy != null) {
            this.fTy.setAdState(bVar);
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
        C0493a c0493a;
        c cVar;
        com.baidu.tieba.enterForum.view.c cVar2;
        com.baidu.tieba.enterForum.data.d dVar;
        d dVar2;
        b bVar;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof d)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    dVar2 = new d();
                    dVar2.mTitle = (TextView) view.findViewById(R.id.title);
                    dVar2.fTN = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    dVar2.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(dVar2);
                } else {
                    dVar2 = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof e) {
                    e eVar = (e) this.mData.get(i);
                    this.fTz.e(dVar2.fTN);
                    this.fTz.byw();
                    this.fTz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar != null) {
                        dVar2.mTitle.setText(eVar.mTitle);
                        am.setViewTextColor(dVar2.mTitle, (int) R.color.cp_cont_b);
                        if (this.fTC != null && this.fTC.fUg) {
                            am.setBackgroundResource(dVar2.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            am.setBackgroundColor(dVar2.mContainer, R.color.cp_bg_line_e);
                        }
                        if (dVar2.fTN != null) {
                            if (eVar.fUq) {
                                dVar2.fTN.setVisibility(0);
                            } else {
                                dVar2.fTN.setVisibility(8);
                            }
                            am.setBackgroundColor(dVar2.fTN, R.color.transparent);
                            return view;
                        }
                        return view;
                    }
                    return view;
                }
                return view;
            case 1:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.view.c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                    com.baidu.tieba.enterForum.view.c cVar3 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.fTx);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = this.mData.get(i)) != null) {
                    cVar2.ai(dVar);
                }
                cVar2.b(this.fTC);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    bVar2.bLK = view.findViewById(R.id.container);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (bVar.bLK != null) {
                    bVar.bLK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.fTx != null) {
                                a.this.fTx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                am.setViewTextColor(bVar.mFooterText, (int) R.color.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    c cVar4 = new c();
                    cVar4.mRoot = view.findViewById(R.id.root);
                    cVar4.dYr = (ImageView) view.findViewById(R.id.image);
                    cVar4.fTL = (TextView) view.findViewById(R.id.hint_text);
                    cVar4.fTM = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.b bVar3 = new com.baidu.tbadk.core.view.commonBtn.b();
                    cVar4.fTM.setTextSize(R.dimen.tbds42);
                    cVar4.fTM.setConfig(bVar3);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    cVar.fTL.setText(R.string.enter_forum_login_interest);
                    cVar.fTM.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    am.setImageResource(cVar.dYr, R.drawable.new_pic_emotion_09);
                } else {
                    cVar.fTL.setText(R.string.forum_waiting_for_your_attention);
                    cVar.fTM.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    am.setImageResource(cVar.dYr, R.drawable.new_pic_emotion_01);
                }
                am.setViewTextColor(cVar.fTL, (int) R.color.cp_cont_j);
                am.setBackgroundColor(cVar.mRoot, R.color.cp_bg_line_e);
                cVar.fTM.aHO();
                if (cVar.fTM != null) {
                    cVar.fTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.fTx != null) {
                                a.this.fTx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.fTy.getView();
                this.fTy.bzN();
                return view2;
            case 5:
                bxF();
                if (view == null || !(view.getTag() instanceof C0493a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
                    C0493a c0493a2 = new C0493a();
                    c0493a2.mRoot = view.findViewById(R.id.container);
                    c0493a2.mCloseButton = (ImageView) view.findViewById(R.id.creator_close);
                    c0493a2.dYr = (ImageView) view.findViewById(R.id.creator_image);
                    c0493a2.fTJ = (TextView) view.findViewById(R.id.create_forum_label);
                    c0493a2.fTK = (ImageView) view.findViewById(R.id.arrow_image);
                    view.setTag(c0493a2);
                    c0493a = c0493a2;
                } else {
                    c0493a = (C0493a) view.getTag();
                }
                am.setImageResource(c0493a.dYr, R.drawable.pic_setup_entry);
                am.setImageResource(c0493a.mCloseButton, R.drawable.icon_home_card_delete);
                am.setViewTextColor(c0493a.fTJ, (int) R.color.cp_cont_a);
                SvgManager.aGC().a(c0493a.fTK, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundColor(c0493a.mRoot, R.color.cp_bg_line_e);
                if (c0493a.mCloseButton != null) {
                    c0493a.mCloseButton.setVisibility(TbadkApplication.isLogin() ? 0 : 8);
                    l.addToParentArea(this.mPageContext.getPageActivity(), c0493a.mCloseButton, 20, 20, 20, 20);
                    c0493a.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            TiebaStatic.log("c13380");
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.close_create_forum_tip), a.this.mPageContext.getResources().getString(R.string.close_creator), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    r0 = null;
                                    for (com.baidu.tieba.enterForum.data.d dVar3 : a.this.mData) {
                                        if (dVar3.getType() == 5) {
                                            break;
                                        }
                                    }
                                    if (dVar3 != null) {
                                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("enter_forum_create_forum", false);
                                        a.this.mData.remove(dVar3);
                                        a.this.fTD.kO(false);
                                    }
                                    aVar.dismiss();
                                }
                            }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            }).aEC();
                        }
                    });
                }
                if (c0493a.dYr != null) {
                    c0493a.dYr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            String bxO;
                            String bxO2;
                            TiebaStatic.log("c13379");
                            if (a.this.fTA.byS()) {
                                if (a.this.fTx != null) {
                                    a.this.fTx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                    return;
                                }
                                return;
                            }
                            boolean z = false;
                            ForumCreateInfoData bxJ = a.this.fTA.byR().bxJ();
                            if (bxJ != null) {
                                switch (bxJ.bxN()) {
                                    case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                        if (aq.isEmpty(bxJ.bxO())) {
                                            bxO2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                        } else {
                                            bxO2 = bxJ.bxO();
                                        }
                                        blockPopInfoData.block_info = bxO2;
                                        blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(R.string.create_forum_feed);
                                        blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(R.string.know);
                                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                                        AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                                        z = true;
                                        break;
                                    case 2121002:
                                        com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.mPageContext.getResources().getString(R.string.to_binding), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.fTE);
                                                aVar.dismiss();
                                            }
                                        }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.2
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                aVar.dismiss();
                                            }
                                        }).aEC();
                                        z = true;
                                        break;
                                }
                            }
                            if (!z) {
                                if (aq.isEmpty(bxJ.bxO())) {
                                    bxO = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bxO = bxJ.bxO();
                                }
                                com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, bxO, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                    }
                                }, (a.b) null).aEC();
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
        return com.baidu.tieba.enterForum.data.d.fUp.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.d> list, boolean z) {
        if (this.fTz != null) {
            this.fTz.AT();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.fTD.kO(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fTy != null) {
            this.fTy.setPageUniqueId(bdUniqueId);
        }
    }

    public void rK(int i) {
        if (this.fTz != null) {
            this.fTz.setSortType(i);
        }
    }

    public boolean bxE() {
        if (this.fTy == null) {
            return false;
        }
        return this.fTy.bxE();
    }

    public void onPrimary() {
        this.fTB = true;
    }

    public void bxF() {
        if (this.fTB) {
            TiebaStatic.log("c13378");
            this.fTB = false;
        }
    }

    public void onDestroy() {
        if (this.fTy != null) {
            this.fTy.onDestroy();
        }
    }

    /* loaded from: classes9.dex */
    private class d {
        TextView fTN;
        RelativeLayout mContainer;
        TextView mTitle;

        private d() {
        }
    }

    /* loaded from: classes9.dex */
    private class b {
        View bLK;
        TextView mFooterText;

        private b() {
        }
    }

    /* loaded from: classes9.dex */
    private class c {
        ImageView dYr;
        TextView fTL;
        TBSpecificationBtn fTM;
        View mRoot;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0493a {
        ImageView dYr;
        TextView fTJ;
        ImageView fTK;
        ImageView mCloseButton;
        View mRoot;

        private C0493a() {
        }
    }
}
