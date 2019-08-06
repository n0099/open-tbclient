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
    private com.baidu.tieba.enterForum.data.b eVA;
    private com.baidu.tieba.enterForum.view.b eVB;
    private ViewEventCenter eVv;
    private f eVw;
    private com.baidu.tieba.enterForum.home.b eVx;
    private EnterForumModel eVy;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.d> mData = new ArrayList();
    private boolean eVz = true;
    private f.a eVC = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.7
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void vX(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bfg() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void vY(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.eVv = viewEventCenter;
        this.eVB = bVar;
        this.eVw = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.eVw.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bff() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.eVw.bhi());
                bVar.setRecentlyIsShow(a.this.eVw.isShow());
            }
        });
        this.eVy = enterForumModel;
        this.eVx = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.eVw);
        this.eVx.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void qv(int i) {
                a.this.eVy.m(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        if (bVar != this.eVA) {
            this.eVA = bVar;
            if (bVar.eWf != this.eVA.eWf) {
            }
            if (bVar.eWg != this.eVA.eWg) {
            }
            if (bVar.eWh != this.eVA.eWh) {
            }
            notifyDataSetChanged();
        }
        if (this.eVw != null) {
            this.eVw.setAdState(bVar);
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
        C0300a c0300a;
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
                    dVar2.eVL = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    dVar2.cWk = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(dVar2);
                } else {
                    dVar2 = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof e) {
                    e eVar = (e) this.mData.get(i);
                    this.eVx.h(dVar2.eVL);
                    this.eVx.bfV();
                    if (eVar != null) {
                        dVar2.mTitle.setText(eVar.mTitle);
                        am.j(dVar2.mTitle, R.color.cp_cont_b);
                        if (this.eVA != null && this.eVA.eWf) {
                            am.k(dVar2.cWk, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            am.l(dVar2.cWk, R.color.cp_bg_line_d);
                        }
                        if (dVar2.eVL != null) {
                            if (eVar.eWq) {
                                dVar2.eVL.setVisibility(0);
                            } else {
                                dVar2.eVL.setVisibility(8);
                            }
                            am.l(dVar2.eVL, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar3 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.eVv);
                    view.setTag(cVar3);
                    cVar2 = cVar3;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.d) && (dVar = this.mData.get(i)) != null) {
                    cVar2.af(dVar);
                }
                cVar2.b(this.eVA);
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
                            if (a.this.eVv != null) {
                                a.this.eVv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
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
                    cVar4.eVJ = (TextView) view.findViewById(R.id.hint_text);
                    cVar4.eVK = (TextView) view.findViewById(R.id.footer_text);
                    view.setTag(cVar4);
                    cVar = cVar4;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    cVar.eVJ.setVisibility(8);
                    cVar.eVK.setText(R.string.enter_forum_login_interest);
                } else {
                    cVar.eVJ.setVisibility(0);
                    cVar.eVK.setText(R.string.enter_forum_explore_interest);
                }
                am.c(cVar.mImage, (int) R.drawable.new_pic_emotion_gray_01);
                am.j(cVar.eVK, R.color.cp_link_tip_c);
                am.j(cVar.eVJ, R.color.cp_cont_d);
                am.l(cVar.mRoot, R.color.cp_bg_line_d);
                if (cVar.eVK != null) {
                    cVar.eVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.eVv != null) {
                                a.this.eVv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.eVw.getView();
                this.eVw.bhk();
                return view2;
            case 5:
                bfe();
                if (view == null || !(view.getTag() instanceof C0300a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
                    C0300a c0300a2 = new C0300a();
                    c0300a2.mRoot = view.findViewById(R.id.container);
                    c0300a2.mCloseButton = (ImageView) view.findViewById(R.id.creator_close);
                    c0300a2.mImage = (ImageView) view.findViewById(R.id.creator_image);
                    c0300a2.eVH = (TextView) view.findViewById(R.id.create_forum_label);
                    c0300a2.eVI = (ImageView) view.findViewById(R.id.arrow_image);
                    view.setTag(c0300a2);
                    c0300a = c0300a2;
                } else {
                    c0300a = (C0300a) view.getTag();
                }
                am.c(c0300a.mImage, (int) R.drawable.pic_setup_entry);
                am.c(c0300a.mCloseButton, (int) R.drawable.icon_home_card_delete);
                am.j(c0300a.eVH, R.color.cp_btn_a);
                am.c(c0300a.eVI, (int) R.drawable.icon_arrow12_white_right);
                am.l(c0300a.mRoot, R.color.cp_bg_line_d);
                if (c0300a.mCloseButton != null) {
                    c0300a.mCloseButton.setVisibility(TbadkApplication.isLogin() ? 0 : 8);
                    l.b(this.mPageContext.getPageActivity(), c0300a.mCloseButton, 20, 20, 20, 20);
                    c0300a.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
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
                                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("enter_forum_create_forum", false);
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
                            }).agK();
                        }
                    });
                }
                if (c0300a.mImage != null) {
                    c0300a.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            String bfo;
                            String bfo2;
                            TiebaStatic.log("c13379");
                            if (a.this.eVy.bgr()) {
                                if (a.this.eVv != null) {
                                    a.this.eVv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                    return;
                                }
                                return;
                            }
                            boolean z = false;
                            ForumCreateInfoData bfj = a.this.eVy.bgq().bfj();
                            if (bfj != null) {
                                switch (bfj.bfn()) {
                                    case 220012:
                                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                        if (aq.isEmpty(bfj.bfo())) {
                                            bfo2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                        } else {
                                            bfo2 = bfj.bfo();
                                        }
                                        blockPopInfoData.block_info = bfo2;
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
                                                com.baidu.tieba.tbadkCore.util.f.a(2121002, "", a.this.eVC);
                                                aVar.dismiss();
                                            }
                                        }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.2
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                aVar.dismiss();
                                            }
                                        }).agK();
                                        z = true;
                                        break;
                                }
                            }
                            if (!z) {
                                if (aq.isEmpty(bfj.bfo())) {
                                    bfo = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bfo = bfj.bfo();
                                }
                                com.baidu.tbadk.coreExtra.d.a.a(a.this.mPageContext, (String) null, bfo, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.6.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                    }
                                }, (a.b) null).agK();
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
        return com.baidu.tieba.enterForum.data.d.eWp.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.d> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eVw != null) {
            this.eVw.setPageUniqueId(bdUniqueId);
        }
    }

    public void qu(int i) {
        if (this.eVx != null) {
            this.eVx.setSortType(i);
        }
    }

    public boolean bfd() {
        if (this.eVw == null) {
            return false;
        }
        return this.eVw.bfd();
    }

    public void onPrimary() {
        this.eVz = true;
    }

    public void bfe() {
        if (this.eVz) {
            TiebaStatic.log("c13378");
            this.eVz = false;
        }
    }

    public void onDestroy() {
        if (this.eVw != null) {
            this.eVw.onDestroy();
        }
    }

    /* loaded from: classes4.dex */
    private class d {
        RelativeLayout cWk;
        TextView eVL;
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
        TextView eVJ;
        TextView eVK;
        ImageView mImage;
        View mRoot;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0300a {
        TextView eVH;
        ImageView eVI;
        ImageView mCloseButton;
        ImageView mImage;
        View mRoot;

        private C0300a() {
        }
    }
}
