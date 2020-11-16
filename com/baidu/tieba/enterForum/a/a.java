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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.d.d;
import com.baidu.tieba.enterForum.d.e;
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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private ViewEventCenter iiB;
    private f iiC;
    private com.baidu.tieba.enterForum.home.b iiD;
    private EnterForumModel iiE;
    private com.baidu.tieba.enterForum.data.c iiG;
    private com.baidu.tieba.enterForum.view.b iiH;
    private TbPageContext<?> mPageContext;
    private List<v> mData = new ArrayList();
    private boolean iiF = true;
    private f.a iiJ = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void IU(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void cqs() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void IV(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> iiI = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.iiB = viewEventCenter;
        this.iiH = bVar;
        this.iiC = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.iiC.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void cqr() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.iiC.ctk());
                bVar.setRecentlyIsShow(a.this.iiC.isShow());
            }
        });
        this.iiE = enterForumModel;
        this.iiD = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.iiC);
        this.iiD.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void yc(int i) {
                a.this.iiE.B(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != this.iiG) {
            this.iiG = cVar;
            if (cVar.iji != this.iiG.iji) {
            }
            if (cVar.ijj != this.iiG.ijj) {
            }
            if (cVar.ijk != this.iiG.ijk) {
            }
            notifyDataSetChanged();
        }
        if (this.iiC != null) {
            this.iiC.setAdState(cVar);
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
        com.baidu.tieba.enterForum.d.a aVar;
        com.baidu.tieba.enterForum.d.b bVar;
        d dVar;
        com.baidu.tieba.enterForum.d.f fVar;
        e eVar;
        com.baidu.tieba.enterForum.d.c cVar;
        b bVar2;
        com.baidu.tieba.enterForum.view.c cVar2;
        v vVar;
        c cVar3;
        C0714a c0714a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.iiP = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.e) {
                    com.baidu.tieba.enterForum.data.e eVar2 = (com.baidu.tieba.enterForum.data.e) this.mData.get(i);
                    this.iiD.k(cVar3.iiP);
                    this.iiD.crG();
                    this.iiD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        cVar3.mTitle.setText(eVar2.mTitle);
                        ap.setViewTextColor(cVar3.mTitle, R.color.CAM_X0105);
                        if (this.iiG != null && this.iiG.iji) {
                            ap.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            ap.setBackgroundColor(cVar3.mContainer, R.color.CAM_X0205);
                        }
                        if (cVar3.iiP != null) {
                            if (eVar2.ijt) {
                                cVar3.iiP.setVisibility(0);
                            } else {
                                cVar3.iiP.setVisibility(8);
                            }
                            ap.setBackgroundColor(cVar3.iiP, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.iiB);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof v) && (vVar = this.mData.get(i)) != null) {
                    cVar2.au(vVar);
                }
                cVar2.b(this.iiG);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0714a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0714a c0714a2 = new C0714a();
                    c0714a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0714a2.dnH = view.findViewById(R.id.container);
                    view.setTag(c0714a2);
                    c0714a = c0714a2;
                } else {
                    c0714a = (C0714a) view.getTag();
                }
                if (c0714a.dnH != null) {
                    c0714a.dnH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.iiB != null) {
                                a.this.iiB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ap.setViewTextColor(c0714a.mFooterText, R.color.CAM_X0304);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.fQP = (ImageView) view.findViewById(R.id.image);
                    bVar3.iiN = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.iiO = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.a aVar2 = new com.baidu.tbadk.core.view.commonBtn.a();
                    bVar3.iiO.setTextSize(R.dimen.tbds42);
                    bVar3.iiO.setConfig(aVar2);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.iiN.setText(R.string.enter_forum_login_interest);
                    bVar2.iiO.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    bVar2.iiO.setTextHorizontalCenter(true);
                    ap.setImageResource(bVar2.fQP, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.iiN.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.iiO.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    ap.setImageResource(bVar2.fQP, R.drawable.new_pic_emotion_01);
                }
                ap.setViewTextColor(bVar2.iiN, R.color.CAM_X0107);
                ap.setBackgroundColor(bVar2.mRoot, R.color.CAM_X0205);
                bVar2.iiO.brT();
                if (bVar2.iiO != null) {
                    bVar2.iiO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.iiB != null) {
                                a.this.iiB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.iiC.getView();
                this.iiC.ctm();
                return view2;
            case 5:
                cqq();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.d.a)) {
                    aVar = new com.baidu.tieba.enterForum.d.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.d.a) view.getTag();
                }
                aVar.apf();
                aVar.x(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String cqC;
                        String cqC2;
                        TiebaStatic.log("c13379");
                        if (a.this.iiE.csb()) {
                            if (a.this.iiB != null) {
                                a.this.iiB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData cqv = a.this.iiE.csa().cqv();
                        if (cqv != null) {
                            switch (cqv.cqB()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (au.isEmpty(cqv.cqC())) {
                                        cqC2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        cqC2 = cqv.cqC();
                                    }
                                    blockPopInfoData.block_info = cqC2;
                                    blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(R.string.create_forum_feed);
                                    blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(R.string.know);
                                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                                    AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                                    z = true;
                                    break;
                                case 2121002:
                                    com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, a.this.mPageContext.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.mPageContext.getResources().getString(R.string.to_binding), a.this.mPageContext.getResources().getString(R.string.think_more), new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.iiJ);
                                            aVar3.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            aVar3.dismiss();
                                        }
                                    }).bog();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (cqv != null) {
                                if (au.isEmpty(cqv.cqC())) {
                                    cqC = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    cqC = cqv.cqC();
                                }
                                string = cqC;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                    aVar3.dismiss();
                                }
                            }, (a.b) null).bog();
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
                if (this.mData.get(i) instanceof bl) {
                    eVar.a((bl) this.mData.get(i));
                }
                if (this.iiE.csa() != null && this.iiE.csa().cqt() != null && this.iiE.csa().cqt().cqP() != null) {
                    eVar.setHasLikeForum(this.iiE.csa().cqt().cqP().size() > 0);
                    return view;
                }
                return view;
            case 8:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.d.f)) {
                    com.baidu.tieba.enterForum.d.f fVar2 = new com.baidu.tieba.enterForum.d.f(this.mPageContext);
                    view = fVar2.getView();
                    view.setTag(fVar2);
                    fVar = fVar2;
                } else {
                    fVar = (com.baidu.tieba.enterForum.d.f) view.getTag();
                }
                if (this.mData.get(i) instanceof bj) {
                    bj bjVar = (bj) this.mData.get(i);
                    fVar.a(bjVar);
                    if (this.iiH.cta().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.iiI.contains(Long.valueOf(bjVar.getForumId()))) {
                        ar arVar = new ar("c13642");
                        arVar.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar.w("fid", bjVar.getForumId());
                        arVar.ak("obj_locate", 1);
                        if (this.iiE.csa() != null && this.iiE.csa().cqt() != null && this.iiE.csa().cqt().cqP() != null) {
                            boolean z = this.iiE.csa().cqt().cqP().size() > 0;
                            arVar.ak("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(arVar);
                        this.iiI.add(Long.valueOf(bjVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof d)) {
                    d dVar2 = new d(this.mPageContext);
                    view = dVar2.ctp();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof bk) {
                    dVar.d((bk) this.mData.get(i));
                }
                ar arVar2 = new ar("c13641");
                arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                arVar2.ak("obj_locate", 1);
                TiebaStatic.log(arVar2);
                return view;
            case 10:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.d.b)) {
                    com.baidu.tieba.enterForum.d.b bVar4 = new com.baidu.tieba.enterForum.d.b(this.mPageContext);
                    view = bVar4.getView();
                    view.setTag(bVar4);
                    bVar = bVar4;
                } else {
                    bVar = (com.baidu.tieba.enterForum.d.b) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) {
                    bVar.a((com.baidu.tieba.enterForum.data.a) this.mData.get(i));
                }
                if (this.iiE.csa() != null && this.iiE.csa().cqt() != null && this.iiE.csa().cqt().cqP() != null) {
                    bVar.setHasLikeForum(this.iiE.csa().cqt().cqP().size() > 0);
                    return view;
                }
                return view;
            case 11:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.d.c)) {
                    cVar = new com.baidu.tieba.enterForum.d.c(this.mPageContext);
                    view = cVar.getView();
                    view.setTag(cVar);
                } else {
                    cVar = (com.baidu.tieba.enterForum.d.c) view.getTag();
                }
                cVar.apf();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return v.eyG.length;
    }

    public void setData(List<v> list, boolean z) {
        if (this.iiD != null) {
            this.iiD.TD();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.iiH.pe(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iiC != null) {
            this.iiC.setPageUniqueId(bdUniqueId);
        }
    }

    public void yb(int i) {
        if (this.iiD != null) {
            this.iiD.setSortType(i);
        }
    }

    public boolean cqp() {
        if (this.iiC == null) {
            return false;
        }
        return this.iiC.cqp();
    }

    public void onPrimary() {
        this.iiF = true;
        this.iiI.clear();
    }

    public void cqq() {
        if (this.iiF) {
            TiebaStatic.log("c13378");
            this.iiF = false;
        }
    }

    public void onDestroy() {
        if (this.iiC != null) {
            this.iiC.onDestroy();
        }
    }

    /* loaded from: classes21.dex */
    private class c {
        TextView iiP;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0714a {
        View dnH;
        TextView mFooterText;

        private C0714a() {
        }
    }

    /* loaded from: classes21.dex */
    private class b {
        ImageView fQP;
        TextView iiN;
        TBSpecificationBtn iiO;
        View mRoot;

        private b() {
        }
    }
}
