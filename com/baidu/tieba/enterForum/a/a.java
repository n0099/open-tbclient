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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.b.d;
import com.baidu.tieba.enterForum.b.e;
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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ViewEventCenter haL;
    private f haM;
    private com.baidu.tieba.enterForum.home.b haN;
    private EnterForumModel haO;
    private com.baidu.tieba.enterForum.data.c haQ;
    private com.baidu.tieba.enterForum.view.b haR;
    private TbPageContext<?> mPageContext;
    private List<t> mData = new ArrayList();
    private boolean haP = true;
    private f.a haT = new f.a() { // from class: com.baidu.tieba.enterForum.a.a.6
        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Ei(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void bQX() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void Ej(String str) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.f.a
        public void onFail() {
        }
    };
    private HashSet<Long> haS = new HashSet<>();

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, final com.baidu.tieba.enterForum.view.b bVar) {
        this.mPageContext = tbPageContext;
        this.haL = viewEventCenter;
        this.haR = bVar;
        this.haM = new com.baidu.tieba.enterForum.view.f(this.mPageContext, recentlyVisitedForumModel, viewEventCenter);
        this.haM.a(new f.a() { // from class: com.baidu.tieba.enterForum.a.a.1
            @Override // com.baidu.tieba.enterForum.view.f.a
            public void bQW() {
                a.this.notifyDataSetChanged();
                bVar.setRecentlyIsExtend(a.this.haM.bTG());
                bVar.setRecentlyIsShow(a.this.haM.isShow());
            }
        });
        this.haO = enterForumModel;
        this.haN = new com.baidu.tieba.enterForum.home.b(this.mPageContext.getPageActivity(), Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.haM);
        this.haN.a(new b.a() { // from class: com.baidu.tieba.enterForum.a.a.2
            @Override // com.baidu.tieba.enterForum.home.b.a
            public void tm(int i) {
                a.this.haO.y(true, i);
            }
        });
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != this.haQ) {
            this.haQ = cVar;
            if (cVar.hbs != this.haQ.hbs) {
            }
            if (cVar.hbt != this.haQ.hbt) {
            }
            if (cVar.hbu != this.haQ.hbu) {
            }
            notifyDataSetChanged();
        }
        if (this.haM != null) {
            this.haM.setAdState(cVar);
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
        com.baidu.tieba.enterForum.b.a aVar;
        com.baidu.tieba.enterForum.b.b bVar;
        d dVar;
        com.baidu.tieba.enterForum.b.f fVar;
        e eVar;
        com.baidu.tieba.enterForum.b.c cVar;
        b bVar2;
        com.baidu.tieba.enterForum.view.c cVar2;
        t tVar;
        c cVar3;
        C0607a c0607a;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    cVar3 = new c();
                    cVar3.mTitle = (TextView) view.findViewById(R.id.title);
                    cVar3.haZ = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    cVar3.mContainer = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(cVar3);
                } else {
                    cVar3 = (c) view.getTag();
                }
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.e) {
                    com.baidu.tieba.enterForum.data.e eVar2 = (com.baidu.tieba.enterForum.data.e) this.mData.get(i);
                    this.haN.f(cVar3.haZ);
                    this.haN.bRY();
                    this.haN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        cVar3.mTitle.setText(eVar2.mTitle);
                        an.setViewTextColor(cVar3.mTitle, (int) R.color.cp_cont_b);
                        if (this.haQ != null && this.haQ.hbs) {
                            an.setBackgroundResource(cVar3.mContainer, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            an.setBackgroundColor(cVar3.mContainer, R.color.cp_bg_line_e);
                        }
                        if (cVar3.haZ != null) {
                            if (eVar2.hbC) {
                                cVar3.haZ.setVisibility(0);
                            } else {
                                cVar3.haZ.setVisibility(8);
                            }
                            an.setBackgroundColor(cVar3.haZ, R.color.transparent);
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
                    com.baidu.tieba.enterForum.view.c cVar4 = new com.baidu.tieba.enterForum.view.c(this.mPageContext, view, this.haL);
                    view.setTag(cVar4);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (com.baidu.tieba.enterForum.view.c) view.getTag();
                }
                if ((this.mData.get(i) instanceof t) && (tVar = this.mData.get(i)) != null) {
                    cVar2.ao(tVar);
                }
                cVar2.b(this.haQ);
                return view;
            case 2:
                if (view == 0 || !(view.getTag() instanceof C0607a)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    C0607a c0607a2 = new C0607a();
                    c0607a2.mFooterText = (TextView) view.findViewById(R.id.footer_text);
                    c0607a2.cAZ = view.findViewById(R.id.container);
                    view.setTag(c0607a2);
                    c0607a = c0607a2;
                } else {
                    c0607a = (C0607a) view.getTag();
                }
                if (c0607a.cAZ != null) {
                    c0607a.cAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.haL != null) {
                                a.this.haL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                }
                an.setViewTextColor(c0607a.mFooterText, (int) R.color.cp_link_tip_c);
                return view;
            case 3:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    b bVar3 = new b();
                    bVar3.mRoot = view.findViewById(R.id.root);
                    bVar3.eXF = (ImageView) view.findViewById(R.id.image);
                    bVar3.haX = (TextView) view.findViewById(R.id.hint_text);
                    bVar3.haY = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    com.baidu.tbadk.core.view.commonBtn.b bVar4 = new com.baidu.tbadk.core.view.commonBtn.b();
                    bVar3.haY.setTextSize(R.dimen.tbds42);
                    bVar3.haY.setConfig(bVar4);
                    view.setTag(bVar3);
                    bVar2 = bVar3;
                } else {
                    bVar2 = (b) view.getTag();
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bVar2.haX.setText(R.string.enter_forum_login_interest);
                    bVar2.haY.setText(this.mPageContext.getResources().getString(R.string.click_here_to_login_in));
                    bVar2.haY.setTextHorizontalCenter(true);
                    an.setImageResource(bVar2.eXF, R.drawable.new_pic_emotion_09);
                } else {
                    bVar2.haX.setText(R.string.forum_waiting_for_your_attention);
                    bVar2.haY.setText(this.mPageContext.getResources().getString(R.string.click_here_to_explore_more_forum));
                    an.setImageResource(bVar2.eXF, R.drawable.new_pic_emotion_01);
                }
                an.setViewTextColor(bVar2.haX, (int) R.color.cp_cont_j);
                an.setBackgroundColor(bVar2.mRoot, R.color.cp_bg_line_e);
                bVar2.haY.aYj();
                if (bVar2.haY != null) {
                    bVar2.haY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.haL != null) {
                                a.this.haL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
                            }
                        }
                    });
                    return view;
                }
                return view;
            case 4:
                View view2 = this.haM.getView();
                this.haM.bTI();
                return view2;
            case 5:
                bQV();
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.a)) {
                    aVar = new com.baidu.tieba.enterForum.b.a(this.mPageContext);
                    view = aVar.getView();
                    view.setTag(aVar);
                } else {
                    aVar = (com.baidu.tieba.enterForum.b.a) view.getTag();
                }
                aVar.aaK();
                aVar.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        String bRh;
                        String bRh2;
                        TiebaStatic.log("c13379");
                        if (a.this.haO.bSx()) {
                            if (a.this.haL != null) {
                                a.this.haL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
                                return;
                            }
                            return;
                        }
                        boolean z = false;
                        ForumCreateInfoData bRa = a.this.haO.bSw().bRa();
                        if (bRa != null) {
                            switch (bRa.bRg()) {
                                case NetWorkErr.ERROR_FORBID_POST_LIVE /* 220012 */:
                                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                                    if (ar.isEmpty(bRa.bRh())) {
                                        bRh2 = a.this.mPageContext.getResources().getString(R.string.create_forum_block_tip);
                                    } else {
                                        bRh2 = bRa.bRh();
                                    }
                                    blockPopInfoData.block_info = bRh2;
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
                                            com.baidu.tieba.tbadkCore.util.f.a(3250017, "", a.this.haT);
                                            aVar2.dismiss();
                                        }
                                    }, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    }).aUN();
                                    z = true;
                                    break;
                            }
                        }
                        if (!z) {
                            String string = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                            if (bRa != null) {
                                if (ar.isEmpty(bRa.bRh())) {
                                    bRh = a.this.mPageContext.getResources().getString(R.string.create_forum_err);
                                } else {
                                    bRh = bRa.bRh();
                                }
                                string = bRh;
                            }
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, (String) null, string, a.this.mPageContext.getResources().getString(R.string.know), (String) null, new a.b() { // from class: com.baidu.tieba.enterForum.a.a.5.3
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                    aVar2.dismiss();
                                }
                            }, (a.b) null).aUN();
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
                if (this.mData.get(i) instanceof bi) {
                    eVar.a((bi) this.mData.get(i));
                }
                if (this.haO.bSw() != null && this.haO.bSw().bQY() != null && this.haO.bSw().bQY().bRu() != null) {
                    eVar.setHasLikeForum(this.haO.bSw().bQY().bRu().size() > 0);
                    return view;
                }
                return view;
            case 8:
                if (view == null || !(view.getTag() instanceof com.baidu.tieba.enterForum.b.f)) {
                    com.baidu.tieba.enterForum.b.f fVar2 = new com.baidu.tieba.enterForum.b.f(this.mPageContext);
                    view = fVar2.getView();
                    view.setTag(fVar2);
                    fVar = fVar2;
                } else {
                    fVar = (com.baidu.tieba.enterForum.b.f) view.getTag();
                }
                if (this.mData.get(i) instanceof bg) {
                    bg bgVar = (bg) this.mData.get(i);
                    fVar.a(bgVar);
                    if (this.haR.bTw().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.haS.contains(Long.valueOf(bgVar.getForumId()))) {
                        ao aoVar = new ao("c13642");
                        aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                        aoVar.s("fid", bgVar.getForumId());
                        aoVar.ag("obj_locate", 1);
                        if (this.haO.bSw() != null && this.haO.bSw().bQY() != null && this.haO.bSw().bQY().bRu() != null) {
                            boolean z = this.haO.bSw().bQY().bRu().size() > 0;
                            aoVar.ag("obj_type", z ? 3 : 1);
                            fVar.setHasLikeForum(z);
                        }
                        TiebaStatic.log(aoVar);
                        this.haS.add(Long.valueOf(bgVar.getForumId()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view == null || !(view.getTag() instanceof d)) {
                    d dVar2 = new d(this.mPageContext);
                    view = dVar2.bTL();
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                if (this.mData.get(i) instanceof bh) {
                    dVar.d((bh) this.mData.get(i));
                }
                ao aoVar2 = new ao("c13641");
                aoVar2.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar2.ag("obj_locate", 1);
                TiebaStatic.log(aoVar2);
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
                if (this.mData.get(i) instanceof com.baidu.tieba.enterForum.data.a) {
                    bVar.a((com.baidu.tieba.enterForum.data.a) this.mData.get(i));
                }
                if (this.haO.bSw() != null && this.haO.bSw().bQY() != null && this.haO.bSw().bQY().bRu() != null) {
                    bVar.setHasLikeForum(this.haO.bSw().bQY().bRu().size() > 0);
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
                cVar.aaK();
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return t.dIc.length;
    }

    public void setData(List<t> list, boolean z) {
        if (this.haN != null) {
            this.haN.Jd();
        }
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        this.haR.mE(z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.haM != null) {
            this.haM.setPageUniqueId(bdUniqueId);
        }
    }

    public void tl(int i) {
        if (this.haN != null) {
            this.haN.setSortType(i);
        }
    }

    public boolean bQU() {
        if (this.haM == null) {
            return false;
        }
        return this.haM.bQU();
    }

    public void onPrimary() {
        this.haP = true;
        this.haS.clear();
    }

    public void bQV() {
        if (this.haP) {
            TiebaStatic.log("c13378");
            this.haP = false;
        }
    }

    public void onDestroy() {
        if (this.haM != null) {
            this.haM.onDestroy();
        }
    }

    /* loaded from: classes9.dex */
    private class c {
        TextView haZ;
        RelativeLayout mContainer;
        TextView mTitle;

        private c() {
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0607a {
        View cAZ;
        TextView mFooterText;

        private C0607a() {
        }
    }

    /* loaded from: classes9.dex */
    private class b {
        ImageView eXF;
        TextView haX;
        TBSpecificationBtn haY;
        View mRoot;

        private b() {
        }
    }
}
