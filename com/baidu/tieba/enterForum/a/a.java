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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.c.d;
import com.baidu.tieba.enterForum.c.e;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.b;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes16.dex */
public class a extends BaseAdapter {
    private ViewEventCenter hgq;
    private f hgr;
    private com.baidu.tieba.enterForum.home.b hgs;
    private EnterForumModel hgt;
    private com.baidu.tieba.enterForum.data.c hgv;
    private com.baidu.tieba.enterForum.view.b hgw;
    private TbPageContext<?> mPageContext;
    private List<t> mData = new ArrayList();
    private boolean hgu = true;
    private f.a hgy = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void ET(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bUj() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void EU(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> hgx = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.hgq = viewEventCenter;
        this.hgw = bVar;
        this.hgr = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.hgr.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bUi() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.hgr.bXa());
                bVar.setRecentlyIsShow(a.this.hgr.isShow());
            }
        });
        this.hgt = enterForumModel;
        this.hgs = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.hgr);
        this.hgs.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void tE(int i) {
                a.this.hgt.y(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != this.hgv) {
            this.hgv = cVar;
            if (cVar.hgX != this.hgv.hgX) {
            }
            if (cVar.hgY != this.hgv.hgY) {
            }
            if (cVar.hgZ != this.hgv.hgZ) {
            }
            notifyDataSetChanged();
        }
        if (this.hgr != null) {
            this.hgr.setAdState(cVar);
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
        return this.mData.get(i).getItemViewType();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.c.a aVar;
        com.baidu.tieba.enterForum.c.b bVar;
        d dVar;
        com.baidu.tieba.enterForum.c.f fVar;
        e eVar;
        com.baidu.tieba.enterForum.c.c cVar;
        b bVar2;
        com.baidu.tieba.enterForum.view.c cVar2;
        t tVar;
        c cVar3;
        C0616a c0616a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.hgE = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.e) {
                    com.baidu.tieba.enterForum.data.e eVar2 = (com.baidu.tieba.enterForum.data.e) this.mData.get(i);
                    this.hgs.h(cVar3.hgE);
                    this.hgs.bVq();
                    this.hgs.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        cVar3.mTitle.setText(eVar2.mTitle);
                        ao.setViewTextColor(cVar3.mTitle, R.color.cp_cont_b);
                        if (this.hgv != null && this.hgv.hgX) {
                            ao.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            ao.setBackgroundColor(cVar3.mContainer, R.color.cp_bg_line_e);
                        }
                        if (cVar3.hgE != null) {
                            if (eVar2.hhi) {
                                cVar3.hgE.setVisibility(0);
                            } else {
                                cVar3.hgE.setVisibility(8);
                            }
                            ao.setBackgroundColor(cVar3.hgE, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.hgq);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof t) && (tVar = this.mData.get(i)) != null) {
                    cVar2.ao(tVar);
                }
                cVar2.b(this.hgv);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0616a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0616a c0616a2 = new C0616a();
                    c0616a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0616a2.cDM = view.findViewById(R.id.container);
                    view.setTag(c0616a2);
                    c0616a = c0616a2;
                } else {
                    c0616a = (C0616a) view.getTag();
                }
                if (c0616a.cDM != null) {
                    c0616a.cDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.hgq != null) {
                                a.this.hgq.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ao.setViewTextColor(c0616a.mFooterText, R.color.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.fcg = (ImageView) view.findViewById(R.id.image);
                    bVar3.hgC = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.hgD = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.b bVar4 = new com.baidu.tbadk.core.view.commonBtn.b();
                    bVar3.hgD.setTextSize(R.dimen.tbds42);
                    bVar3.hgD.setConfig(bVar4);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.hgC.setText(R.string.enter_forum_login_interest);
                    bVar2.hgD.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    bVar2.hgD.setTextHorizontalCenter(true);
                    ao.setImageResource(bVar2.fcg, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.hgC.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.hgD.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    ao.setImageResource(bVar2.fcg, R.drawable.new_pic_emotion_01);
                }
                ao.setViewTextColor(bVar2.hgC, R.color.cp_cont_j);
                ao.setBackgroundColor(bVar2.mRoot, R.color.cp_bg_line_e);
                bVar2.hgD.bci();
                if (bVar2.hgD != null) {
                    bVar2.hgD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.hgq != null) {
                                a.this.hgq.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.hgr.getView();
                this.hgr.bXc();
                return view2;
            case 5:
                bUh();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.a)) {
                    aVar = new com.baidu.tieba.enterForum.c.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.c.a) view.getTag();
                }
                aVar.abM();
                aVar.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String bUu;
                        String bUu2;
                        TiebaStatic.log("c13379");
                        if (a.this.hgt.bVP()) {
                            if (a.this.hgq != null) {
                                a.this.hgq.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData bUm = a.this.hgt.bVO().bUm();
                        if (bUm != null) {
                            switch (bUm.bUt()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (as.isEmpty(bUm.bUu())) {
                                        bUu2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        bUu2 = bUm.bUu();
                                    }
                                    blockPopInfoData.block_info = bUu2;
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
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.hgy);
                                            aVar2.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    }).aYL();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (bUm != null) {
                                if (as.isEmpty(bUm.bUu())) {
                                    bUu = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bUu = bUm.bUu();
                                }
                                string = bUu;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            }, (a.b) null).aYL();
                        }
                    }
                });
                return view;
            case 6:
            default:
                return view;
            case 7:
                if (view == null || !(view.getTag() instanceof e)) {
                    e eVar3 = new e(this.mPageContext);
                    view = eVar3.getView();
                    view.setTag(eVar3);
                    eVar = eVar3;
                } else {
                    eVar = (e) view.getTag();
                }
                if (this.mData.get(i) instanceof bj) {
                    eVar.a((bj) this.mData.get(i));
                }
                if (this.hgt.bVO() != null && this.hgt.bVO().bUk() != null && this.hgt.bVO().bUk().bUH() != null) {
                    eVar.setHasLikeForum(this.hgt.bVO().bUk().bUH().size() > 0);
                    return view;
                }
                return view;
            case 8:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.f)) {
                    com.baidu.tieba.enterForum.c.f fVar2 = new com.baidu.tieba.enterForum.c.f(this.mPageContext);
                    view = fVar2.getView();
                    view.setTag(fVar2);
                    fVar = fVar2;
                } else {
                    fVar = (com.baidu.tieba.enterForum.c.f) view.getTag();
                }
                if (this.mData.get(i) instanceof bh) {
                    bh bhVar = (bh) this.mData.get(i);
                    fVar.a(bhVar);
                    if (this.hgw.bWQ().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.hgx.contains(Long.valueOf(bhVar.getForumId()))) {
                        ap apVar = new ap("c13642");
                        apVar.t("uid", TbadkApplication.getCurrentAccountId());
                        apVar.t("fid", bhVar.getForumId());
                        apVar.ah("obj_locate", 1);
                        if (this.hgt.bVO() != null && this.hgt.bVO().bUk() != null && this.hgt.bVO().bUk().bUH() != null) {
                            boolean z = this.hgt.bVO().bUk().bUH().size() > 0;
                            apVar.ah("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(apVar);
                        this.hgx.add(Long.valueOf(bhVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof d)) {
                    d dVar2 = new d(this.mPageContext);
                    view = dVar2.bXf();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof bi) {
                    dVar.d((bi) this.mData.get(i));
                }
                ap apVar2 = new ap("c13641");
                apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                apVar2.ah("obj_locate", 1);
                TiebaStatic.log(apVar2);
                return view;
            case 10:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.b)) {
                    com.baidu.tieba.enterForum.c.b bVar5 = new com.baidu.tieba.enterForum.c.b(this.mPageContext);
                    view = bVar5.getView();
                    view.setTag(bVar5);
                    bVar = bVar5;
                } else {
                    bVar = (com.baidu.tieba.enterForum.c.b) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) {
                    bVar.a((com.baidu.tieba.enterForum.data.a) this.mData.get(i));
                }
                if (this.hgt.bVO() != null && this.hgt.bVO().bUk() != null && this.hgt.bVO().bUk().bUH() != null) {
                    bVar.setHasLikeForum(this.hgt.bVO().bUk().bUH().size() > 0);
                    return view;
                }
                return view;
            case 11:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.c)) {
                    cVar = new com.baidu.tieba.enterForum.c.c(this.mPageContext);
                    view = cVar.getView();
                    view.setTag(cVar);
                } else {
                    cVar = (com.baidu.tieba.enterForum.c.c) view.getTag();
                }
                cVar.abM();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return t.dOn.length;
    }

    public void setData(List<t> list, boolean z) {
        if (this.hgs != null) {
            this.hgs.Jj();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.hgw.nj(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hgr != null) {
            this.hgr.setPageUniqueId(bdUniqueId);
        }
    }

    public void tD(int i) {
        if (this.hgs != null) {
            this.hgs.setSortType(i);
        }
    }

    public boolean bUg() {
        if (this.hgr == null) {
            return false;
        }
        return this.hgr.bUg();
    }

    public void onPrimary() {
        this.hgu = true;
        this.hgx.clear();
    }

    public void bUh() {
        if (this.hgu) {
            TiebaStatic.log("c13378");
            this.hgu = false;
        }
    }

    public void onDestroy() {
        if (this.hgr != null) {
            this.hgr.onDestroy();
        }
    }

    /* loaded from: classes16.dex */
    private class c {
        TextView hgE;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    private class C0616a {
        View cDM;
        TextView mFooterText;

        private C0616a() {
        }
    }

    /* loaded from: classes16.dex */
    private class b {
        ImageView fcg;
        TextView hgC;
        TBSpecificationBtn hgD;
        View mRoot;

        private b() {
        }
    }
}
