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
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private ViewEventCenter iHa;
    private f iHb;
    private com.baidu.tieba.enterForum.home.b iHc;
    private EnterForumModel iHd;
    private com.baidu.tieba.enterForum.data.c iHf;
    private com.baidu.tieba.enterForum.view.b iHg;
    private TbPageContext<?> mPageContext;
    private List<w> mData = new ArrayList();
    private boolean iHe = true;
    private f.a iHi = new f.a() { // from class: com.baidu.tieba.enterForum.adapter.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Ji(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void cvc() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Jj(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> iHh = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.iHa = viewEventCenter;
        this.iHg = bVar;
        this.iHb = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.iHb.a(new f.a() { // from class: com.baidu.tieba.enterForum.adapter.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void cvb() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.iHb.cxV());
                bVar.setRecentlyIsShow(a.this.iHb.isShow());
            }
        });
        this.iHd = enterForumModel;
        this.iHc = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.iHb);
        this.iHc.a(new b.a() { // from class: com.baidu.tieba.enterForum.adapter.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void xy(int i) {
                a.this.iHd.A(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != this.iHf) {
            this.iHf = cVar;
            if (cVar.iHH != this.iHf.iHH) {
            }
            if (cVar.iHI != this.iHf.iHI) {
            }
            if (cVar.iHJ != this.iHf.iHJ) {
            }
            notifyDataSetChanged();
        }
        if (this.iHb != null) {
            this.iHb.setAdState(cVar);
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
        w wVar;
        c cVar3;
        C0704a c0704a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.iHo = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.e) {
                    com.baidu.tieba.enterForum.data.e eVar2 = (com.baidu.tieba.enterForum.data.e) this.mData.get(i);
                    this.iHc.m(cVar3.iHo);
                    this.iHc.cwr();
                    this.iHc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        cVar3.mTitle.setText(eVar2.mTitle);
                        ap.setViewTextColor(cVar3.mTitle, R.color.CAM_X0105);
                        if (this.iHf != null && this.iHf.iHH) {
                            ap.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            ap.setBackgroundColor(cVar3.mContainer, R.color.CAM_X0205);
                        }
                        if (cVar3.iHo != null) {
                            if (eVar2.iHS) {
                                cVar3.iHo.setVisibility(0);
                            } else {
                                cVar3.iHo.setVisibility(8);
                            }
                            ap.setBackgroundColor(cVar3.iHo, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.iHa);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof w) && (wVar = this.mData.get(i)) != null) {
                    cVar2.aw(wVar);
                }
                cVar2.b(this.iHf);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0704a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0704a c0704a2 = new C0704a();
                    c0704a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0704a2.dyo = view.findViewById(R.id.container);
                    view.setTag(c0704a2);
                    c0704a = c0704a2;
                } else {
                    c0704a = (C0704a) view.getTag();
                }
                if (c0704a.dyo != null) {
                    c0704a.dyo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.iHa != null) {
                                a.this.iHa.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ap.setViewTextColor(c0704a.mFooterText, R.color.CAM_X0304);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.ggs = (ImageView) view.findViewById(R.id.image);
                    bVar3.iHm = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.iHn = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.a aVar2 = new com.baidu.tbadk.core.view.commonBtn.a();
                    bVar3.iHn.setTextSize(R.dimen.tbds42);
                    bVar3.iHn.setConfig(aVar2);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.iHm.setText(R.string.enter_forum_login_interest);
                    bVar2.iHn.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    bVar2.iHn.setTextHorizontalCenter(true);
                    ap.setImageResource(bVar2.ggs, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.iHm.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.iHn.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    ap.setImageResource(bVar2.ggs, R.drawable.new_pic_emotion_01);
                }
                ap.setViewTextColor(bVar2.iHm, R.color.CAM_X0107);
                ap.setBackgroundColor(bVar2.mRoot, R.color.CAM_X0205);
                bVar2.iHn.bup();
                if (bVar2.iHn != null) {
                    bVar2.iHn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.iHa != null) {
                                a.this.iHa.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.iHb.getView();
                this.iHb.cxX();
                return view2;
            case 5:
                cva();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.c.a)) {
                    aVar = new com.baidu.tieba.enterForum.c.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.c.a) view.getTag();
                }
                aVar.aqj();
                aVar.y(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String cvm;
                        String cvm2;
                        TiebaStatic.log("c13379");
                        if (a.this.iHd.cwM()) {
                            if (a.this.iHa != null) {
                                a.this.iHa.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData cvf = a.this.iHd.cwL().cvf();
                        if (cvf != null) {
                            switch (cvf.cvl()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (au.isEmpty(cvf.cvm())) {
                                        cvm2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        cvm2 = cvf.cvm();
                                    }
                                    blockPopInfoData.block_info = cvm2;
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
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.iHi);
                                            aVar3.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.adapter.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            aVar3.dismiss();
                                        }
                                    }).bqx();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (cvf != null) {
                                if (au.isEmpty(cvf.cvm())) {
                                    cvm = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    cvm = cvf.cvm();
                                }
                                string = cvm;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.adapter.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                    aVar3.dismiss();
                                }
                            }, (a.b) null).bqx();
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
                if (this.mData.get(i) instanceof bp) {
                    eVar.a((bp) this.mData.get(i));
                }
                if (this.iHd.cwL() != null && this.iHd.cwL().cvd() != null && this.iHd.cwL().cvd().cvz() != null) {
                    eVar.setHasLikeForum(this.iHd.cwL().cvd().cvz().size() > 0);
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
                if (this.mData.get(i) instanceof bn) {
                    bn bnVar = (bn) this.mData.get(i);
                    fVar.a(bnVar);
                    if (this.iHg.cxL().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.iHh.contains(Long.valueOf(bnVar.getForumId()))) {
                        ar arVar = new ar("c13642");
                        arVar.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar.v("fid", bnVar.getForumId());
                        arVar.ap("obj_locate", 1);
                        if (this.iHd.cwL() != null && this.iHd.cwL().cvd() != null && this.iHd.cwL().cvd().cvz() != null) {
                            boolean z = this.iHd.cwL().cvd().cvz().size() > 0;
                            arVar.ap("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(arVar);
                        this.iHh.add(Long.valueOf(bnVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof d)) {
                    d dVar2 = new d(this.mPageContext);
                    view = dVar2.cya();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof bo) {
                    dVar.d((bo) this.mData.get(i));
                }
                ar arVar2 = new ar("c13641");
                arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                arVar2.ap("obj_locate", 1);
                TiebaStatic.log(arVar2);
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
                if (this.iHd.cwL() != null && this.iHd.cwL().cvd() != null && this.iHd.cwL().cvd().cvz() != null) {
                    bVar.setHasLikeForum(this.iHd.cwL().cvd().cvz().size() > 0);
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
                cVar.aqj();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return w.eMW.length;
    }

    public void setData(List<w> list, boolean z) {
        if (this.iHc != null) {
            this.iHc.UU();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.iHg.qd(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iHb != null) {
            this.iHb.setPageUniqueId(bdUniqueId);
        }
    }

    public void xx(int i) {
        if (this.iHc != null) {
            this.iHc.setSortType(i);
        }
    }

    public boolean cuZ() {
        if (this.iHb == null) {
            return false;
        }
        return this.iHb.cuZ();
    }

    public void onPrimary() {
        this.iHe = true;
        this.iHh.clear();
    }

    public void cva() {
        if (this.iHe) {
            TiebaStatic.log("c13378");
            this.iHe = false;
        }
    }

    public void onDestroy() {
        if (this.iHb != null) {
            this.iHb.onDestroy();
        }
    }

    /* loaded from: classes2.dex */
    private class c {
        TextView iHo;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0704a {
        View dyo;
        TextView mFooterText;

        private C0704a() {
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        ImageView ggs;
        TextView iHm;
        TBSpecificationBtn iHn;
        View mRoot;

        private b() {
        }
    }
}
