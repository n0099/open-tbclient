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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private ViewEventCenter ibM;
    private f ibN;
    private com.baidu.tieba.enterForum.home.b ibO;
    private EnterForumModel ibP;
    private com.baidu.tieba.enterForum.data.c ibR;
    private com.baidu.tieba.enterForum.view.b ibS;
    private TbPageContext<?> mPageContext;
    private List<u> mData = new ArrayList();
    private boolean ibQ = true;
    private f.a ibU = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Jc(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void coo() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Jd(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> ibT = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.ibM = viewEventCenter;
        this.ibS = bVar;
        this.ibN = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.ibN.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void con() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.ibN.crg());
                bVar.setRecentlyIsShow(a.this.ibN.isShow());
            }
        });
        this.ibP = enterForumModel;
        this.ibO = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.ibN);
        this.ibO.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void xr(int i) {
                a.this.ibP.B(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != this.ibR) {
            this.ibR = cVar;
            if (cVar.ict != this.ibR.ict) {
            }
            if (cVar.icu != this.ibR.icu) {
            }
            if (cVar.icv != this.ibR.icv) {
            }
            notifyDataSetChanged();
        }
        if (this.ibN != null) {
            this.ibN.setAdState(cVar);
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
        u uVar;
        c cVar3;
        C0697a c0697a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.ica = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.e) {
                    com.baidu.tieba.enterForum.data.e eVar2 = (com.baidu.tieba.enterForum.data.e) this.mData.get(i);
                    this.ibO.g(cVar3.ica);
                    this.ibO.cpC();
                    this.ibO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        cVar3.mTitle.setText(eVar2.mTitle);
                        ap.setViewTextColor(cVar3.mTitle, R.color.cp_cont_b);
                        if (this.ibR != null && this.ibR.ict) {
                            ap.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            ap.setBackgroundColor(cVar3.mContainer, R.color.cp_bg_line_e);
                        }
                        if (cVar3.ica != null) {
                            if (eVar2.icE) {
                                cVar3.ica.setVisibility(0);
                            } else {
                                cVar3.ica.setVisibility(8);
                            }
                            ap.setBackgroundColor(cVar3.ica, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.ibM);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof u) && (uVar = this.mData.get(i)) != null) {
                    cVar2.au(uVar);
                }
                cVar2.b(this.ibR);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0697a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0697a c0697a2 = new C0697a();
                    c0697a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0697a2.djv = view.findViewById(R.id.container);
                    view.setTag(c0697a2);
                    c0697a = c0697a2;
                } else {
                    c0697a = (C0697a) view.getTag();
                }
                if (c0697a.djv != null) {
                    c0697a.djv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.ibM != null) {
                                a.this.ibM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                ap.setViewTextColor(c0697a.mFooterText, R.color.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.fLr = (ImageView) view.findViewById(R.id.image);
                    bVar3.ibY = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.ibZ = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.a aVar2 = new com.baidu.tbadk.core.view.commonBtn.a();
                    bVar3.ibZ.setTextSize(R.dimen.tbds42);
                    bVar3.ibZ.setConfig(aVar2);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.ibY.setText(R.string.enter_forum_login_interest);
                    bVar2.ibZ.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    bVar2.ibZ.setTextHorizontalCenter(true);
                    ap.setImageResource(bVar2.fLr, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.ibY.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.ibZ.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    ap.setImageResource(bVar2.fLr, R.drawable.new_pic_emotion_01);
                }
                ap.setViewTextColor(bVar2.ibY, R.color.cp_cont_j);
                ap.setBackgroundColor(bVar2.mRoot, R.color.cp_bg_line_e);
                bVar2.ibZ.bqd();
                if (bVar2.ibZ != null) {
                    bVar2.ibZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.ibM != null) {
                                a.this.ibM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.ibN.getView();
                this.ibN.cri();
                return view2;
            case 5:
                com();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.d.a)) {
                    aVar = new com.baidu.tieba.enterForum.d.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.d.a) view.getTag();
                }
                aVar.ann();
                aVar.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String coy;
                        String coy2;
                        TiebaStatic.log("c13379");
                        if (a.this.ibP.cpX()) {
                            if (a.this.ibM != null) {
                                a.this.ibM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData cor = a.this.ibP.cpW().cor();
                        if (cor != null) {
                            switch (cor.cox()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (at.isEmpty(cor.coy())) {
                                        coy2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        coy2 = cor.coy();
                                    }
                                    blockPopInfoData.block_info = coy2;
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
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.ibU);
                                            aVar3.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            aVar3.dismiss();
                                        }
                                    }).bmC();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (cor != null) {
                                if (at.isEmpty(cor.coy())) {
                                    coy = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    coy = cor.coy();
                                }
                                string = coy;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                    aVar3.dismiss();
                                }
                            }, (a.b) null).bmC();
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
                if (this.mData.get(i) instanceof bk) {
                    eVar.a((bk) this.mData.get(i));
                }
                if (this.ibP.cpW() != null && this.ibP.cpW().cop() != null && this.ibP.cpW().cop().coL() != null) {
                    eVar.setHasLikeForum(this.ibP.cpW().cop().coL().size() > 0);
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
                if (this.mData.get(i) instanceof bi) {
                    bi biVar = (bi) this.mData.get(i);
                    fVar.a(biVar);
                    if (this.ibS.cqW().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.ibT.contains(Long.valueOf(biVar.getForumId()))) {
                        aq aqVar = new aq("c13642");
                        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar.w("fid", biVar.getForumId());
                        aqVar.aj("obj_locate", 1);
                        if (this.ibP.cpW() != null && this.ibP.cpW().cop() != null && this.ibP.cpW().cop().coL() != null) {
                            boolean z = this.ibP.cpW().cop().coL().size() > 0;
                            aqVar.aj("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(aqVar);
                        this.ibT.add(Long.valueOf(biVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof d)) {
                    d dVar2 = new d(this.mPageContext);
                    view = dVar2.crl();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof bj) {
                    dVar.d((bj) this.mData.get(i));
                }
                aq aqVar2 = new aq("c13641");
                aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.aj("obj_locate", 1);
                TiebaStatic.log(aqVar2);
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
                if (this.ibP.cpW() != null && this.ibP.cpW().cop() != null && this.ibP.cpW().cop().coL() != null) {
                    bVar.setHasLikeForum(this.ibP.cpW().cop().coL().size() > 0);
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
                cVar.ann();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return u.euw.length;
    }

    public void setData(List<u> list, boolean z) {
        if (this.ibO != null) {
            this.ibO.RE();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.ibS.oS(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ibN != null) {
            this.ibN.setPageUniqueId(bdUniqueId);
        }
    }

    public void xq(int i) {
        if (this.ibO != null) {
            this.ibO.setSortType(i);
        }
    }

    public boolean col() {
        if (this.ibN == null) {
            return false;
        }
        return this.ibN.col();
    }

    public void onPrimary() {
        this.ibQ = true;
        this.ibT.clear();
    }

    public void com() {
        if (this.ibQ) {
            TiebaStatic.log("c13378");
            this.ibQ = false;
        }
    }

    public void onDestroy() {
        if (this.ibN != null) {
            this.ibN.onDestroy();
        }
    }

    /* loaded from: classes22.dex */
    private class c {
        TextView ica;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private class C0697a {
        View djv;
        TextView mFooterText;

        private C0697a() {
        }
    }

    /* loaded from: classes22.dex */
    private class b {
        ImageView fLr;
        TextView ibY;
        TBSpecificationBtn ibZ;
        View mRoot;

        private b() {
        }
    }
}
