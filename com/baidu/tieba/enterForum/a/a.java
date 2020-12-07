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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private com.baidu.tieba.enterForum.view.b itA;
    private ViewEventCenter itu;
    private f itv;
    private com.baidu.tieba.enterForum.home.b itw;
    private EnterForumModel itx;
    private com.baidu.tieba.enterForum.data.c itz;
    private TbPageContext<?> mPageContext;
    private List<v> mData = new ArrayList();
    private boolean ity = true;
    private f.a itC = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void JK(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void cuG() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void JL(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> itB = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.itu = viewEventCenter;
        this.itA = bVar;
        this.itv = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.itv.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void cuF() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.itv.cxz());
                bVar.setRecentlyIsShow(a.this.itv.isShow());
            }
        });
        this.itx = enterForumModel;
        this.itw = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.itv);
        this.itw.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void yH(int i) {
                a.this.itx.B(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != this.itz) {
            this.itz = cVar;
            if (cVar.iub != this.itz.iub) {
            }
            if (cVar.iuc != this.itz.iuc) {
            }
            if (cVar.iud != this.itz.iud) {
            }
            notifyDataSetChanged();
        }
        if (this.itv != null) {
            this.itv.setAdState(cVar);
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
        C0728a c0728a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.itI = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.e) {
                    com.baidu.tieba.enterForum.data.e eVar2 = (com.baidu.tieba.enterForum.data.e) this.mData.get(i);
                    this.itw.k(cVar3.itI);
                    this.itw.cvV();
                    this.itw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        cVar3.mTitle.setText(eVar2.mTitle);
                        ap.setViewTextColor(cVar3.mTitle, R.color.CAM_X0105);
                        if (this.itz != null && this.itz.iub) {
                            ap.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            ap.setBackgroundColor(cVar3.mContainer, R.color.CAM_X0205);
                        }
                        if (cVar3.itI != null) {
                            if (eVar2.ium) {
                                cVar3.itI.setVisibility(0);
                            } else {
                                cVar3.itI.setVisibility(8);
                            }
                            ap.setBackgroundColor(cVar3.itI, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.itu);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof v) && (vVar = this.mData.get(i)) != null) {
                    cVar2.au(vVar);
                }
                cVar2.b(this.itz);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0728a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0728a c0728a2 = new C0728a();
                    c0728a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0728a2.duK = view.findViewById(R.id.container);
                    view.setTag(c0728a2);
                    c0728a = c0728a2;
                } else {
                    c0728a = (C0728a) view.getTag();
                }
                if (c0728a.duK != null) {
                    c0728a.duK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.itu != null) {
                                a.this.itu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ap.setViewTextColor(c0728a.mFooterText, R.color.CAM_X0304);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.fYY = (ImageView) view.findViewById(R.id.image);
                    bVar3.itG = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.itH = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.a aVar2 = new com.baidu.tbadk.core.view.commonBtn.a();
                    bVar3.itH.setTextSize(R.dimen.tbds42);
                    bVar3.itH.setConfig(aVar2);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.itG.setText(R.string.enter_forum_login_interest);
                    bVar2.itH.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    bVar2.itH.setTextHorizontalCenter(true);
                    ap.setImageResource(bVar2.fYY, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.itG.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.itH.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    ap.setImageResource(bVar2.fYY, R.drawable.new_pic_emotion_01);
                }
                ap.setViewTextColor(bVar2.itG, R.color.CAM_X0107);
                ap.setBackgroundColor(bVar2.mRoot, R.color.CAM_X0205);
                bVar2.itH.bvt();
                if (bVar2.itH != null) {
                    bVar2.itH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.itu != null) {
                                a.this.itu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.itv.getView();
                this.itv.cxB();
                return view2;
            case 5:
                cuE();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.d.a)) {
                    aVar = new com.baidu.tieba.enterForum.d.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.d.a) view.getTag();
                }
                aVar.aso();
                aVar.x(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String cuQ;
                        String cuQ2;
                        TiebaStatic.log("c13379");
                        if (a.this.itx.cwq()) {
                            if (a.this.itu != null) {
                                a.this.itu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData cuJ = a.this.itx.cwp().cuJ();
                        if (cuJ != null) {
                            switch (cuJ.cuP()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (au.isEmpty(cuJ.cuQ())) {
                                        cuQ2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        cuQ2 = cuJ.cuQ();
                                    }
                                    blockPopInfoData.block_info = cuQ2;
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
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.itC);
                                            aVar3.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            aVar3.dismiss();
                                        }
                                    }).brv();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (cuJ != null) {
                                if (au.isEmpty(cuJ.cuQ())) {
                                    cuQ = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    cuQ = cuJ.cuQ();
                                }
                                string = cuQ;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                    aVar3.dismiss();
                                }
                            }, (a.b) null).brv();
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
                if (this.mData.get(i) instanceof bm) {
                    eVar.a((bm) this.mData.get(i));
                }
                if (this.itx.cwp() != null && this.itx.cwp().cuH() != null && this.itx.cwp().cuH().cvd() != null) {
                    eVar.setHasLikeForum(this.itx.cwp().cuH().cvd().size() > 0);
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
                if (this.mData.get(i) instanceof bk) {
                    bk bkVar = (bk) this.mData.get(i);
                    fVar.a(bkVar);
                    if (this.itA.cxp().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.itB.contains(Long.valueOf(bkVar.getForumId()))) {
                        ar arVar = new ar("c13642");
                        arVar.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar.w("fid", bkVar.getForumId());
                        arVar.al("obj_locate", 1);
                        if (this.itx.cwp() != null && this.itx.cwp().cuH() != null && this.itx.cwp().cuH().cvd() != null) {
                            boolean z = this.itx.cwp().cuH().cvd().size() > 0;
                            arVar.al("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(arVar);
                        this.itB.add(Long.valueOf(bkVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof d)) {
                    d dVar2 = new d(this.mPageContext);
                    view = dVar2.cxE();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof bl) {
                    dVar.d((bl) this.mData.get(i));
                }
                ar arVar2 = new ar("c13641");
                arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                arVar2.al("obj_locate", 1);
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
                if (this.itx.cwp() != null && this.itx.cwp().cuH() != null && this.itx.cwp().cuH().cvd() != null) {
                    bVar.setHasLikeForum(this.itx.cwp().cuH().cvd().size() > 0);
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
                cVar.aso();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return v.eFF.length;
    }

    public void setData(List<v> list, boolean z) {
        if (this.itw != null) {
            this.itw.Wd();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.itA.pA(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.itv != null) {
            this.itv.setPageUniqueId(bdUniqueId);
        }
    }

    public void yG(int i) {
        if (this.itw != null) {
            this.itw.setSortType(i);
        }
    }

    public boolean cuD() {
        if (this.itv == null) {
            return false;
        }
        return this.itv.cuD();
    }

    public void onPrimary() {
        this.ity = true;
        this.itB.clear();
    }

    public void cuE() {
        if (this.ity) {
            TiebaStatic.log("c13378");
            this.ity = false;
        }
    }

    public void onDestroy() {
        if (this.itv != null) {
            this.itv.onDestroy();
        }
    }

    /* loaded from: classes22.dex */
    private class c {
        TextView itI;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private class C0728a {
        View duK;
        TextView mFooterText;

        private C0728a() {
        }
    }

    /* loaded from: classes22.dex */
    private class b {
        ImageView fYY;
        TextView itG;
        TBSpecificationBtn itH;
        View mRoot;

        private b() {
        }
    }
}
