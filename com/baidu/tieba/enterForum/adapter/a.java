package com.baidu.tieba.enterForum.adapter;

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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewEventCenter iBc;
    private f iBd;
    private com.baidu.tieba.enterForum.home.b iBe;
    private EnterForumModel iBf;
    private com.baidu.tieba.enterForum.data.c iBh;
    private com.baidu.tieba.enterForum.view.b iBi;
    private TbPageContext<?> mPageContext;
    private List<v> mData = new ArrayList();
    private boolean iBg = true;
    private f.a iBk = new f.a() { // from class: com.baidu.tieba.enterForum.adapter.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Iw(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void ctJ() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Ix(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> iBj = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.iBc = viewEventCenter;
        this.iBi = bVar;
        this.iBd = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.iBd.a(new f.a() { // from class: com.baidu.tieba.enterForum.adapter.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void ctI() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.iBd.cwC());
                bVar.setRecentlyIsShow(a.this.iBd.isShow());
            }
        });
        this.iBf = enterForumModel;
        this.iBe = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.iBd);
        this.iBe.a(new b.a() { // from class: com.baidu.tieba.enterForum.adapter.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void xo(int i) {
                a.this.iBf.A(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != this.iBh) {
            this.iBh = cVar;
            if (cVar.iBJ != this.iBh.iBJ) {
            }
            if (cVar.iBK != this.iBh.iBK) {
            }
            if (cVar.iBL != this.iBh.iBL) {
            }
            notifyDataSetChanged();
        }
        if (this.iBd != null) {
            this.iBd.setAdState(cVar);
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
        v vVar;
        c cVar3;
        C0703a c0703a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.iBq = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.e) {
                    com.baidu.tieba.enterForum.data.e eVar2 = (com.baidu.tieba.enterForum.data.e) this.mData.get(i);
                    this.iBe.m(cVar3.iBq);
                    this.iBe.cuY();
                    this.iBe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        cVar3.mTitle.setText(eVar2.mTitle);
                        ao.setViewTextColor(cVar3.mTitle, R.color.CAM_X0105);
                        if (this.iBh != null && this.iBh.iBJ) {
                            ao.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            ao.setBackgroundColor(cVar3.mContainer, R.color.CAM_X0205);
                        }
                        if (cVar3.iBq != null) {
                            if (eVar2.iBU) {
                                cVar3.iBq.setVisibility(0);
                            } else {
                                cVar3.iBq.setVisibility(8);
                            }
                            ao.setBackgroundColor(cVar3.iBq, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.iBc);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof v) && (vVar = this.mData.get(i)) != null) {
                    cVar2.aw(vVar);
                }
                cVar2.b(this.iBh);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0703a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0703a c0703a2 = new C0703a();
                    c0703a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0703a2.dwh = view.findViewById(R.id.container);
                    view.setTag(c0703a2);
                    c0703a = c0703a2;
                } else {
                    c0703a = (C0703a) view.getTag();
                }
                if (c0703a.dwh != null) {
                    c0703a.dwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.iBc != null) {
                                a.this.iBc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ao.setViewTextColor(c0703a.mFooterText, R.color.CAM_X0304);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.gdY = (ImageView) view.findViewById(R.id.image);
                    bVar3.iBo = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.iBp = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.a aVar2 = new com.baidu.tbadk.core.view.commonBtn.a();
                    bVar3.iBp.setTextSize(R.dimen.tbds42);
                    bVar3.iBp.setConfig(aVar2);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.iBo.setText(R.string.enter_forum_login_interest);
                    bVar2.iBp.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    bVar2.iBp.setTextHorizontalCenter(true);
                    ao.setImageResource(bVar2.gdY, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.iBo.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.iBp.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    ao.setImageResource(bVar2.gdY, R.drawable.new_pic_emotion_01);
                }
                ao.setViewTextColor(bVar2.iBo, R.color.CAM_X0107);
                ao.setBackgroundColor(bVar2.mRoot, R.color.CAM_X0205);
                bVar2.iBp.btV();
                if (bVar2.iBp != null) {
                    bVar2.iBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.iBc != null) {
                                a.this.iBc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.iBd.getView();
                this.iBd.cwE();
                return view2;
            case 5:
                ctH();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.a)) {
                    aVar = new com.baidu.tieba.enterForum.c.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.c.a) view.getTag();
                }
                aVar.apL();
                aVar.y(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String ctT;
                        String ctT2;
                        TiebaStatic.log("c13379");
                        if (a.this.iBf.cvt()) {
                            if (a.this.iBc != null) {
                                a.this.iBc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData ctM = a.this.iBf.cvs().ctM();
                        if (ctM != null) {
                            switch (ctM.ctS()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (at.isEmpty(ctM.ctT())) {
                                        ctT2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        ctT2 = ctM.ctT();
                                    }
                                    blockPopInfoData.block_info = ctT2;
                                    blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(R.string.create_forum_feed);
                                    blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(R.string.know);
                                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                                    AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                                    z = true;
                                    break;
                                case 2121002:
                                    com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.mPageContext.getResources().getString(R.string.to_binding), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.adapter.a.5.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.iBk);
                                            aVar3.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.adapter.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            aVar3.dismiss();
                                        }
                                    }).bqe();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (ctM != null) {
                                if (at.isEmpty(ctM.ctT())) {
                                    ctT = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    ctT = ctM.ctT();
                                }
                                string = ctT;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.adapter.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                    aVar3.dismiss();
                                }
                            }, (a.b) null).bqe();
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
                if (this.mData.get(i) instanceof bn) {
                    eVar.a((bn) this.mData.get(i));
                }
                if (this.iBf.cvs() != null && this.iBf.cvs().ctK() != null && this.iBf.cvs().ctK().cug() != null) {
                    eVar.setHasLikeForum(this.iBf.cvs().ctK().cug().size() > 0);
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
                if (this.mData.get(i) instanceof bl) {
                    bl blVar = (bl) this.mData.get(i);
                    fVar.a(blVar);
                    if (this.iBi.cws().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.iBj.contains(Long.valueOf(blVar.getForumId()))) {
                        aq aqVar = new aq("c13642");
                        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar.w("fid", blVar.getForumId());
                        aqVar.an("obj_locate", 1);
                        if (this.iBf.cvs() != null && this.iBf.cvs().ctK() != null && this.iBf.cvs().ctK().cug() != null) {
                            boolean z = this.iBf.cvs().ctK().cug().size() > 0;
                            aqVar.an("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(aqVar);
                        this.iBj.add(Long.valueOf(blVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof d)) {
                    d dVar2 = new d(this.mPageContext);
                    view = dVar2.cwH();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof bm) {
                    dVar.d((bm) this.mData.get(i));
                }
                aq aqVar2 = new aq("c13641");
                aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.an("obj_locate", 1);
                TiebaStatic.log(aqVar2);
                return view;
            case 10:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.b)) {
                    com.baidu.tieba.enterForum.c.b bVar4 = new com.baidu.tieba.enterForum.c.b(this.mPageContext);
                    view = bVar4.getView();
                    view.setTag(bVar4);
                    bVar = bVar4;
                } else {
                    bVar = (com.baidu.tieba.enterForum.c.b) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) {
                    bVar.a((com.baidu.tieba.enterForum.data.a) this.mData.get(i));
                }
                if (this.iBf.cvs() != null && this.iBf.cvs().ctK() != null && this.iBf.cvs().ctK().cug() != null) {
                    bVar.setHasLikeForum(this.iBf.cvs().ctK().cug().size() > 0);
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
                cVar.apL();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return v.eKK.length;
    }

    public void setData(List<v> list, boolean z) {
        if (this.iBe != null) {
            this.iBe.Tn();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.iBi.pT(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iBd != null) {
            this.iBd.setPageUniqueId(bdUniqueId);
        }
    }

    public void xn(int i) {
        if (this.iBe != null) {
            this.iBe.setSortType(i);
        }
    }

    public boolean ctG() {
        if (this.iBd == null) {
            return false;
        }
        return this.iBd.ctG();
    }

    public void onPrimary() {
        this.iBg = true;
        this.iBj.clear();
    }

    public void ctH() {
        if (this.iBg) {
            TiebaStatic.log("c13378");
            this.iBg = false;
        }
    }

    public void onDestroy() {
        if (this.iBd != null) {
            this.iBd.onDestroy();
        }
    }

    /* loaded from: classes2.dex */
    private class c {
        TextView iBq;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0703a {
        View dwh;
        TextView mFooterText;

        private C0703a() {
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        ImageView gdY;
        TextView iBo;
        TBSpecificationBtn iBp;
        View mRoot;

        private b() {
        }
    }
}
