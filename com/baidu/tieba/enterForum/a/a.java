package com.baidu.tieba.enterForum.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.b.e;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.d;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.data.k;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.data.m;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.b;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ViewEventCenter gyO;
    private f gyP;
    private com.baidu.tieba.enterForum.home.b gyQ;
    private EnterForumModel gyR;
    private d gyT;
    private com.baidu.tieba.enterForum.view.b gyU;
    private TbPageContext<?> mPageContext;
    private List<com.baidu.tieba.enterForum.data.f> mData = new ArrayList();
    private boolean gyS = true;
    private f.a gyW = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void BV(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bHy() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void BW(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> gyV = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.gyO = viewEventCenter;
        this.gyU = bVar;
        this.gyP = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.gyP.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bHx() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.gyP.bKh());
                bVar.setRecentlyIsShow(a.this.gyP.isShow());
            }
        });
        this.gyR = enterForumModel;
        this.gyQ = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.gyP);
        this.gyQ.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void se(int i) {
                a.this.gyR.t(true, i);
            }
        });
    }

    public void setAdState(d dVar) {
        if (dVar != this.gyT) {
            this.gyT = dVar;
            if (dVar.gzE != this.gyT.gzE) {
            }
            if (dVar.gzF != this.gyT.gzF) {
            }
            if (dVar.gzG != this.gyT.gzG) {
            }
            notifyDataSetChanged();
        }
        if (this.gyP != null) {
            this.gyP.setAdState(dVar);
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
        com.baidu.tieba.enterForum.b.a aVar;
        com.baidu.tieba.enterForum.b.b bVar;
        com.baidu.tieba.enterForum.b.d dVar;
        com.baidu.tieba.enterForum.b.f fVar;
        e eVar;
        com.baidu.tieba.enterForum.b.c cVar;
        b bVar2;
        com.baidu.tieba.enterForum.view.c cVar2;
        com.baidu.tieba.enterForum.data.f fVar2;
        c cVar3;
        C0528a c0528a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.gzc = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof g) {
                    g gVar = (g) this.mData.get(i);
                    this.gyQ.f(cVar3.gzc);
                    this.gyQ.bIB();
                    this.gyQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (gVar != null) {
                        cVar3.mTitle.setText(gVar.mTitle);
                        am.setViewTextColor(cVar3.mTitle, (int) R.color.cp_cont_b);
                        if (this.gyT != null && this.gyT.gzE) {
                            am.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            am.setBackgroundColor(cVar3.mContainer, R.color.cp_bg_line_e);
                        }
                        if (cVar3.gzc != null) {
                            if (gVar.gzP) {
                                cVar3.gzc.setVisibility(0);
                            } else {
                                cVar3.gzc.setVisibility(8);
                            }
                            am.setBackgroundColor(cVar3.gzc, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.gyO);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.f) && (fVar2 = this.mData.get(i)) != null) {
                    cVar2.ai(fVar2);
                }
                cVar2.b(this.gyT);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0528a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0528a c0528a2 = new C0528a();
                    c0528a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0528a2.ckF = view.findViewById(R.id.container);
                    view.setTag(c0528a2);
                    c0528a = c0528a2;
                } else {
                    c0528a = (C0528a) view.getTag();
                }
                if (c0528a.ckF != null) {
                    c0528a.ckF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.gyO != null) {
                                a.this.gyO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                am.setViewTextColor(c0528a.mFooterText, (int) R.color.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.eyE = (ImageView) view.findViewById(R.id.image);
                    bVar3.gza = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.gzb = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.b bVar4 = new com.baidu.tbadk.core.view.commonBtn.b();
                    bVar3.gzb.setTextSize(R.dimen.tbds42);
                    bVar3.gzb.setConfig(bVar4);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.gza.setText(R.string.enter_forum_login_interest);
                    bVar2.gzb.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    am.setImageResource(bVar2.eyE, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.gza.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.gzb.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    am.setImageResource(bVar2.eyE, R.drawable.new_pic_emotion_01);
                }
                am.setViewTextColor(bVar2.gza, (int) R.color.cp_cont_j);
                am.setBackgroundColor(bVar2.mRoot, R.color.cp_bg_line_e);
                bVar2.gzb.aQp();
                if (bVar2.gzb != null) {
                    bVar2.gzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.gyO != null) {
                                a.this.gyO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.gyP.getView();
                this.gyP.bKj();
                return view2;
            case 5:
                bHw();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.a)) {
                    aVar = new com.baidu.tieba.enterForum.b.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.b.a) view.getTag();
                }
                aVar.WT();
                aVar.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String bHH;
                        String bHH2;
                        TiebaStatic.log("c13379");
                        if (a.this.gyR.bJa()) {
                            if (a.this.gyO != null) {
                                a.this.gyO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData bHB = a.this.gyR.bIZ().bHB();
                        if (bHB != null) {
                            switch (bHB.bHG()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (aq.isEmpty(bHB.bHH())) {
                                        bHH2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        bHH2 = bHB.bHH();
                                    }
                                    blockPopInfoData.block_info = bHH2;
                                    blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(R.string.create_forum_feed);
                                    blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(R.string.know);
                                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                                    AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                                    z = true;
                                    break;
                                case 2121002:
                                    com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.mPageContext.getResources().getString(R.string.to_binding), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.gyW);
                                            aVar2.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    }).aMU();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (bHB != null) {
                                if (aq.isEmpty(bHB.bHH())) {
                                    bHH = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bHH = bHB.bHH();
                                }
                                string = bHH;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            }, (a.b) null).aMU();
                        }
                    }
                });
                return view;
            case 6:
            default:
                return view;
            case 7:
                if (view == null || !(view.getTag() instanceof e)) {
                    e eVar2 = new e(this.mPageContext);
                    view = eVar2.getView();
                    view.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    eVar = (e) view.getTag();
                }
                if (this.mData.get(i) instanceof m) {
                    eVar.a((m) this.mData.get(i));
                }
                if (this.gyR.bIZ() != null && this.gyR.bIZ().bHz() != null && this.gyR.bIZ().bHz().bHU() != null) {
                    eVar.setHasLikeForum(this.gyR.bIZ().bHz().bHU().size() > 0);
                    return view;
                }
                return view;
            case 8:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.f)) {
                    com.baidu.tieba.enterForum.b.f fVar3 = new com.baidu.tieba.enterForum.b.f(this.mPageContext);
                    view = fVar3.getView();
                    view.setTag(fVar3);
                    fVar = fVar3;
                } else {
                    fVar = (com.baidu.tieba.enterForum.b.f) view.getTag();
                }
                if (this.mData.get(i) instanceof k) {
                    k kVar = (k) this.mData.get(i);
                    fVar.a(kVar);
                    if (this.gyU.bJX().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.gyV.contains(Long.valueOf(kVar.getForumId()))) {
                        an anVar = new an("c13642");
                        anVar.t("uid", TbadkApplication.getCurrentAccountId());
                        anVar.t("fid", kVar.getForumId());
                        anVar.af("obj_locate", 1);
                        if (this.gyR.bIZ() != null && this.gyR.bIZ().bHz() != null && this.gyR.bIZ().bHz().bHU() != null) {
                            boolean z = this.gyR.bIZ().bHz().bHU().size() > 0;
                            anVar.af("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(anVar);
                        this.gyV.add(Long.valueOf(kVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.d)) {
                    com.baidu.tieba.enterForum.b.d dVar2 = new com.baidu.tieba.enterForum.b.d(this.mPageContext);
                    view = dVar2.bKt();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (com.baidu.tieba.enterForum.b.d) view.getTag();
                }
                if (this.mData.get(i) instanceof l) {
                    dVar.c((l) this.mData.get(i));
                }
                an anVar2 = new an("c13641");
                anVar2.t("uid", TbadkApplication.getCurrentAccountId());
                anVar2.af("obj_locate", 1);
                TiebaStatic.log(anVar2);
                return view;
            case 10:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.b)) {
                    com.baidu.tieba.enterForum.b.b bVar5 = new com.baidu.tieba.enterForum.b.b(this.mPageContext);
                    view = bVar5.getView();
                    view.setTag(bVar5);
                    bVar = bVar5;
                } else {
                    bVar = (com.baidu.tieba.enterForum.b.b) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.b) {
                    bVar.a((com.baidu.tieba.enterForum.data.b) this.mData.get(i));
                }
                if (this.gyR.bIZ() != null && this.gyR.bIZ().bHz() != null && this.gyR.bIZ().bHz().bHU() != null) {
                    bVar.setHasLikeForum(this.gyR.bIZ().bHz().bHU().size() > 0);
                    return view;
                }
                return view;
            case 11:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.c)) {
                    cVar = new com.baidu.tieba.enterForum.b.c(this.mPageContext);
                    view = cVar.getView();
                    view.setTag(cVar);
                } else {
                    cVar = (com.baidu.tieba.enterForum.b.c) view.getTag();
                }
                cVar.WT();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return com.baidu.tieba.enterForum.data.f.gzO.length;
    }

    public void setData(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        if (this.gyQ != null) {
            this.gyQ.FY();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.gyU.lY(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gyP != null) {
            this.gyP.setPageUniqueId(bdUniqueId);
        }
    }

    public void sd(int i) {
        if (this.gyQ != null) {
            this.gyQ.setSortType(i);
        }
    }

    public boolean bHv() {
        if (this.gyP == null) {
            return false;
        }
        return this.gyP.bHv();
    }

    public void onPrimary() {
        this.gyS = true;
        this.gyV.clear();
    }

    public void bHw() {
        if (this.gyS) {
            TiebaStatic.log("c13378");
            this.gyS = false;
        }
    }

    public void onDestroy() {
        if (this.gyP != null) {
            this.gyP.onDestroy();
        }
    }

    /* loaded from: classes9.dex */
    private class c {
        TextView gzc;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0528a {
        View ckF;
        TextView mFooterText;

        private C0528a() {
        }
    }

    /* loaded from: classes9.dex */
    private class b {
        ImageView eyE;
        TextView gza;
        TBSpecificationBtn gzb;
        View mRoot;

        private b() {
        }
    }
}
