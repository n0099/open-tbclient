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
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.enterForum.view.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ViewEventCenter eVo;
    private f eVp;
    private com.baidu.tieba.enterForum.home.b eVq;
    private EnterForumModel eVr;
    private com.baidu.tieba.enterForum.data.b eVt;
    private com.baidu.tieba.enterForum.view.b eVu;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.d> mData = new ArrayList();
    private boolean eVs = true;
    private f.a eVv = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.8
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void vW(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bfe() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void vX(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.eVo = viewEventCenter;
        this.eVu = bVar;
        this.eVp = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.eVp.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bfd() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.eVp.bhb());
                bVar.setRecentlyIsShow(a.this.eVp.isShow());
            }
        });
        this.eVr = enterForumModel;
        this.eVq = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.eVp);
        this.eVq.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void qu(int i) {
                a.this.eVr.m(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar != this.eVt) {
            this.eVt = bVar;
            if (bVar.eVV != this.eVt.eVV) {
            }
            if (bVar.eVW != this.eVt.eVW) {
            }
            if (bVar.eVX != this.eVt.eVX) {
            }
            notifyDataSetChanged();
        }
        if (this.eVp != null) {
            this.eVp.setAdState(bVar);
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
        C0294a c0294a;
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
                    dVar2.eVE = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    dVar2.cWd = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(dVar2);
                    dVar2.cWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!a.this.eVp.bhb() || !a.this.eVp.isShow()) {
                                EnterForumAdView.a(a.this.mPageContext.getUniqueId(), a.this.mPageContext.getPageActivity());
                            }
                        }
                    });
                } else {
                    dVar2 = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof e) {
                    e eVar = (e) this.mData.get(i);
                    this.eVq.h(dVar2.eVE);
                    this.eVq.bfT();
                    if (eVar != null) {
                        dVar2.mTitle.setText(eVar.mTitle);
                        if (this.eVt != null && this.eVt.eVV) {
                            if (this.eVp.isShow()) {
                                if (this.eVp.bhb()) {
                                    am.j(dVar2.mTitle, R.color.cp_cont_b);
                                    am.l(dVar2.cWd, R.color.cp_bg_line_f);
                                } else {
                                    am.j(dVar2.mTitle, R.color.cp_btn_a);
                                    dVar2.cWd.setBackgroundColor(0);
                                }
                            } else {
                                am.j(dVar2.mTitle, R.color.cp_btn_a);
                                dVar2.cWd.setBackgroundColor(0);
                            }
                        } else {
                            am.j(dVar2.mTitle, R.color.cp_cont_b);
                            am.l(dVar2.cWd, R.color.cp_bg_line_f);
                        }
                        if (dVar2.eVE != null) {
                            if (eVar.eWg) {
                                dVar2.eVE.setVisibility(0);
                            } else {
                                dVar2.eVE.setVisibility(8);
                            }
                            am.l(dVar2.eVE, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar3 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.eVo);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = this.mData.get(i)) != null) {
                    cVar2.af(dVar);
                }
                cVar2.b(this.eVt);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    bVar2.aKO = view.findViewById(R.id.container);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (bVar.aKO != null) {
                    bVar.aKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eVo != null) {
                                a.this.eVo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
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
                    cVar4.eVC = (TextView) view.findViewById(R.id.hint_text);
                    cVar4.eVD = (TextView) view.findViewById(R.id.footer_text);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    cVar.eVC.setVisibility(8);
                    cVar.eVD.setText(R.string.enter_forum_login_interest);
                } else {
                    cVar.eVC.setVisibility(0);
                    cVar.eVD.setText(R.string.enter_forum_explore_interest);
                }
                am.c(cVar.mImage, (int) R.drawable.new_pic_emotion_gray_01);
                am.j(cVar.eVD, R.color.cp_link_tip_c);
                am.j(cVar.eVC, R.color.cp_cont_d);
                am.l(cVar.mRoot, R.color.cp_bg_line_d);
                if (cVar.eVD != null) {
                    cVar.eVD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eVo != null) {
                                a.this.eVo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.eVp.getView();
                this.eVp.bhd();
                return view2;
            case 5:
                bfc();
                if (view == null || !(view.getTag() instanceof C0294a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
                    C0294a c0294a2 = new C0294a();
                    c0294a2.mRoot = view.findViewById(R.id.container);
                    c0294a2.mCloseButton = (ImageView) view.findViewById(R.id.creator_close);
                    c0294a2.mImage = (ImageView) view.findViewById(R.id.creator_image);
                    c0294a2.eVA = (TextView) view.findViewById(R.id.create_forum_label);
                    c0294a2.eVB = (ImageView) view.findViewById(R.id.arrow_image);
                    view.setTag(c0294a2);
                    c0294a = c0294a2;
                } else {
                    c0294a = (C0294a) view.getTag();
                }
                am.c(c0294a.mImage, (int) R.drawable.pic_setup_entry);
                am.c(c0294a.mCloseButton, (int) R.drawable.icon_home_card_delete);
                am.j(c0294a.eVA, R.color.cp_btn_a);
                am.c(c0294a.eVB, (int) R.drawable.icon_arrow12_white_right);
                am.l(c0294a.mRoot, R.color.cp_bg_line_d);
                if (c0294a.mCloseButton != null) {
                    c0294a.mCloseButton.setVisibility(TbadkApplication.isLogin() ? 0 : 8);
                    l.b(this.mPageContext.getPageActivity(), c0294a.mCloseButton, 20, 20, 20, 20);
                    c0294a.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.6
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
                                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("enter_forum_create_forum", false);
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
                            }).agI();
                        }
                    });
                }
                if (c0294a.mImage != null) {
                    c0294a.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            String bfm;
                            String bfm2;
                            TiebaStatic.log("c13379");
                            if (a.this.eVr.bgo()) {
                                if (a.this.eVo != null) {
                                    a.this.eVo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                    return;
                                }
                                return;
                            }
                            boolean z = false;
                            ForumCreateInfoData bfh = a.this.eVr.bgn().bfh();
                            if (bfh != null) {
                                switch (bfh.bfl()) {
                                    case 220012:
                                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                        if (aq.isEmpty(bfh.bfm())) {
                                            bfm2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                        } else {
                                            bfm2 = bfh.bfm();
                                        }
                                        blockPopInfoData.block_info = bfm2;
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
                                                com.baidu.tieba.tbadkCore.util.f.a(2121002, "", a.this.eVv);
                                                aVar.dismiss();
                                            }
                                        }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.7.2
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                aVar.dismiss();
                                            }
                                        }).agI();
                                        z = true;
                                        break;
                                }
                            }
                            if (!z) {
                                if (aq.isEmpty(bfh.bfm())) {
                                    bfm = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bfm = bfh.bfm();
                                }
                                com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, bfm, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.7.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                    }
                                }, (a.b) null).agI();
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
        return com.baidu.tieba.enterForum.data.d.eWf.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.d> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eVp != null) {
            this.eVp.setPageUniqueId(bdUniqueId);
        }
    }

    public void qt(int i) {
        if (this.eVq != null) {
            this.eVq.setSortType(i);
        }
    }

    public boolean bfb() {
        if (this.eVp == null) {
            return false;
        }
        return this.eVp.bfb();
    }

    public void onPrimary() {
        this.eVs = true;
    }

    public void bfc() {
        if (this.eVs) {
            TiebaStatic.log("c13378");
            this.eVs = false;
        }
    }

    public void onDestroy() {
        if (this.eVp != null) {
            this.eVp.onDestroy();
        }
    }

    /* loaded from: classes4.dex */
    private class d {
        RelativeLayout cWd;
        TextView eVE;
        TextView mTitle;

        private d() {
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        View aKO;
        TextView mFooterText;

        private b() {
        }
    }

    /* loaded from: classes4.dex */
    private class c {
        TextView eVC;
        TextView eVD;
        ImageView mImage;
        View mRoot;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0294a {
        TextView eVA;
        ImageView eVB;
        ImageView mCloseButton;
        ImageView mImage;
        View mRoot;

        private C0294a() {
        }
    }
}
