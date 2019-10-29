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
    private ViewEventCenter eZN;
    private f eZO;
    private com.baidu.tieba.enterForum.home.b eZP;
    private EnterForumModel eZQ;
    private com.baidu.tieba.enterForum.data.b eZS;
    private com.baidu.tieba.enterForum.view.b eZT;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.d> mData = new ArrayList();
    private boolean eZR = true;
    private f.a eZU = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.7
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void uU(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bdE() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void uV(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.eZN = viewEventCenter;
        this.eZT = bVar;
        this.eZO = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.eZO.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bdD() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.eZO.bfL());
                bVar.setRecentlyIsShow(a.this.eZO.isShow());
            }
        });
        this.eZQ = enterForumModel;
        this.eZP = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.eZO);
        this.eZP.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void pu(int i) {
                a.this.eZQ.n(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar != this.eZS) {
            this.eZS = bVar;
            if (bVar.fax != this.eZS.fax) {
            }
            if (bVar.fay != this.eZS.fay) {
            }
            if (bVar.faz != this.eZS.faz) {
            }
            notifyDataSetChanged();
        }
        if (this.eZO != null) {
            this.eZO.setAdState(bVar);
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
        C0398a c0398a;
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
                    dVar2.fad = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    dVar2.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(dVar2);
                } else {
                    dVar2 = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof e) {
                    e eVar = (e) this.mData.get(i);
                    this.eZP.f(dVar2.fad);
                    this.eZP.bet();
                    this.eZP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar != null) {
                        dVar2.mTitle.setText(eVar.mTitle);
                        am.setViewTextColor(dVar2.mTitle, (int) R.color.cp_cont_b);
                        if (this.eZS != null && this.eZS.fax) {
                            am.setBackgroundResource(dVar2.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            am.setBackgroundColor(dVar2.mContainer, R.color.cp_bg_line_e);
                        }
                        if (dVar2.fad != null) {
                            if (eVar.faI) {
                                dVar2.fad.setVisibility(0);
                            } else {
                                dVar2.fad.setVisibility(8);
                            }
                            am.setBackgroundColor(dVar2.fad, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar3 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.eZN);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = this.mData.get(i)) != null) {
                    cVar2.ab(dVar);
                }
                cVar2.b(this.eZS);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    bVar2.bez = view.findViewById(R.id.container);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (bVar.bez != null) {
                    bVar.bez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eZN != null) {
                                a.this.eZN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
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
                    cVar4.dgU = (ImageView) view.findViewById(R.id.image);
                    cVar4.fab = (TextView) view.findViewById(R.id.hint_text);
                    cVar4.fac = (TextView) view.findViewById(R.id.footer_text);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    cVar.fab.setVisibility(8);
                    cVar.fac.setText(R.string.enter_forum_login_interest);
                } else {
                    cVar.fab.setVisibility(0);
                    cVar.fac.setText(R.string.enter_forum_explore_interest);
                }
                am.setImageResource(cVar.dgU, R.drawable.new_pic_emotion_gray_01);
                am.setViewTextColor(cVar.fac, (int) R.color.cp_link_tip_c);
                am.setViewTextColor(cVar.fab, (int) R.color.cp_cont_d);
                am.setBackgroundColor(cVar.mRoot, R.color.cp_bg_line_e);
                if (cVar.fac != null) {
                    cVar.fac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eZN != null) {
                                a.this.eZN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.eZO.getView();
                this.eZO.bfN();
                return view2;
            case 5:
                bdC();
                if (view == null || !(view.getTag() instanceof C0398a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
                    C0398a c0398a2 = new C0398a();
                    c0398a2.mRoot = view.findViewById(R.id.container);
                    c0398a2.mCloseButton = (ImageView) view.findViewById(R.id.creator_close);
                    c0398a2.dgU = (ImageView) view.findViewById(R.id.creator_image);
                    c0398a2.eZZ = (TextView) view.findViewById(R.id.create_forum_label);
                    c0398a2.faa = (ImageView) view.findViewById(R.id.arrow_image);
                    view.setTag(c0398a2);
                    c0398a = c0398a2;
                } else {
                    c0398a = (C0398a) view.getTag();
                }
                am.setImageResource(c0398a.dgU, R.drawable.pic_setup_entry);
                am.setImageResource(c0398a.mCloseButton, R.drawable.icon_home_card_delete);
                am.setViewTextColor(c0398a.eZZ, (int) R.color.cp_cont_a);
                am.setImageResource(c0398a.faa, R.drawable.icon_arrow12_white_right);
                am.setBackgroundColor(c0398a.mRoot, R.color.cp_bg_line_e);
                if (c0398a.mCloseButton != null) {
                    c0398a.mCloseButton.setVisibility(TbadkApplication.isLogin() ? 0 : 8);
                    l.addToParentArea(this.mPageContext.getPageActivity(), c0398a.mCloseButton, 20, 20, 20, 20);
                    c0398a.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
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
                                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("enter_forum_create_forum", false);
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
                            }).akO();
                        }
                    });
                }
                if (c0398a.dgU != null) {
                    c0398a.dgU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            String bdM;
                            String bdM2;
                            TiebaStatic.log("c13379");
                            if (a.this.eZQ.beQ()) {
                                if (a.this.eZN != null) {
                                    a.this.eZN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                    return;
                                }
                                return;
                            }
                            boolean z = false;
                            ForumCreateInfoData bdH = a.this.eZQ.beP().bdH();
                            if (bdH != null) {
                                switch (bdH.bdL()) {
                                    case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                        if (aq.isEmpty(bdH.bdM())) {
                                            bdM2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                        } else {
                                            bdM2 = bdH.bdM();
                                        }
                                        blockPopInfoData.block_info = bdM2;
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
                                                com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.eZU);
                                                aVar.dismiss();
                                            }
                                        }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.2
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                aVar.dismiss();
                                            }
                                        }).akO();
                                        z = true;
                                        break;
                                }
                            }
                            if (!z) {
                                if (aq.isEmpty(bdH.bdM())) {
                                    bdM = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bdM = bdH.bdM();
                                }
                                com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, bdM, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                    }
                                }, (a.b) null).akO();
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
        return com.baidu.tieba.enterForum.data.d.faH.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.d> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eZO != null) {
            this.eZO.setPageUniqueId(bdUniqueId);
        }
    }

    public void pt(int i) {
        if (this.eZP != null) {
            this.eZP.setSortType(i);
        }
    }

    public boolean bdB() {
        if (this.eZO == null) {
            return false;
        }
        return this.eZO.bdB();
    }

    public void onPrimary() {
        this.eZR = true;
    }

    public void bdC() {
        if (this.eZR) {
            TiebaStatic.log("c13378");
            this.eZR = false;
        }
    }

    public void onDestroy() {
        if (this.eZO != null) {
            this.eZO.onDestroy();
        }
    }

    /* loaded from: classes4.dex */
    private class d {
        TextView fad;
        RelativeLayout mContainer;
        TextView mTitle;

        private d() {
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        View bez;
        TextView mFooterText;

        private b() {
        }
    }

    /* loaded from: classes4.dex */
    private class c {
        ImageView dgU;
        TextView fab;
        TextView fac;
        View mRoot;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0398a {
        ImageView dgU;
        TextView eZZ;
        ImageView faa;
        ImageView mCloseButton;
        View mRoot;

        private C0398a() {
        }
    }
}
