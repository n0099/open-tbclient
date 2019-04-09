package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.p;
import com.baidu.afd.i;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private String byE;
    private View csE;
    private NoNetworkView dbr;
    private com.baidu.tbadk.core.view.b eQD;
    private PbListView feS;
    private List<com.baidu.tieba.card.data.b> fxA;
    private d fxB;
    private com.baidu.tieba.t.b fxF;
    private h fxe;
    private BdTypeRecyclerView fxw;
    private RelativeLayout fxx;
    private f fxy;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean fxz = true;
    private int fxt = -1;
    private boolean fxC = false;
    private boolean fxD = false;
    int fxG = 4;
    int fxH = 7;
    int fxI = 4;
    private CustomMessageListener fxJ = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921317 && customResponsedMessage.getmOrginalMessage() != null && customResponsedMessage.getmOrginalMessage().getExtra() != null) {
                String str = (String) customResponsedMessage.getmOrginalMessage().getExtra();
                if (VideoMiddlePageFragment.this.mBackImageView != null) {
                    if (Config.EXCEPTION_MEMORY_LOW.equals(str)) {
                        VideoMiddlePageFragment.this.mBackImageView.setAlpha(0.2f);
                    } else if ("high".equals(str)) {
                        VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                    }
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.kY()) {
                    if (VideoMiddlePageFragment.this.dbr != null) {
                        VideoMiddlePageFragment.this.dbr.setVisibility(8);
                    }
                    if (j.la() && !com.baidu.tieba.video.g.ciN().ciO()) {
                        if (VideoMiddlePageFragment.this.fxy == null || !VideoMiddlePageFragment.this.fxy.pY()) {
                            if (VideoMiddlePageFragment.this.fxy != null && VideoMiddlePageFragment.this.fxy.bjD()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.dbr != null) {
                    VideoMiddlePageFragment.this.dbr.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.fxy != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jy) {
                VideoMiddlePageFragment.this.fxy.af(data.toUid, data.isAttention);
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                VideoMiddlePageFragment.this.mScrollState = i;
                if (i == 0) {
                    if (bdTypeRecyclerView.getLastVisiblePosition() > bdTypeRecyclerView.getCount() - 2 && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                        VideoMiddlePageFragment.this.fxe.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.fxe.aAZ();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.cdp().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.fxy != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.fxy.beR() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.fxy.beR()) {
                        VideoMiddlePageFragment.this.fxy.beS();
                    }
                }
            }
        }
    };
    private HashMap fxE = new HashMap();

    public static VideoMiddlePageFragment cQ(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FROM", str);
        bundle.putString("PARAM_FID", str2);
        VideoMiddlePageFragment videoMiddlePageFragment = new VideoMiddlePageFragment();
        videoMiddlePageFragment.setArguments(bundle);
        return videoMiddlePageFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdp().s(getUniqueId());
        this.fxe = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.fxe.setId(stringExtra);
            this.fxe.setLocation(stringExtra3);
            this.fxe.vd(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.fxE.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.fxE.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.fxe.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.byE = arguments.getString("PARAM_FID");
        }
        if (this.fxe != null) {
            this.fxe.setFrom(this.mFrom);
            this.fxe.bjS();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.fxJ);
        this.fxF = new com.baidu.tieba.t.b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(getPageContext().getPageActivity(), d.e.ds88) + l.h(getPageContext().getPageActivity(), d.e.tbds42)));
        this.fxw = (BdTypeRecyclerView) view.findViewById(d.g.video_middle_page_list_view);
        this.fxw.addHeaderView(this.mHeaderView);
        this.fxw.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fxw.setFadingEdgeLength(0);
        this.fxw.setBackgroundColor(al.getColor(d.C0277d.transparent));
        this.fxw.setOverScrollMode(2);
        this.fxw.setScrollable(this);
        this.fxx = (RelativeLayout) view.findViewById(d.g.container);
        this.dbr = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.kY()) {
            this.dbr.setVisibility(0);
        }
        this.feS = new PbListView(getPageContext().getPageActivity());
        this.feS.dQ(false);
        this.feS.oM();
        this.feS.aew();
        this.feS.ia(d.C0277d.cp_cont_b);
        this.feS.setText(getResources().getString(d.j.list_has_no_more));
        this.feS.setTextColor(d.C0277d.cp_cont_d);
        this.feS.hZ(d.C0277d.cp_cont_f);
        this.fxw.setNextPage(this.feS);
        this.feS.ic(l.h(TbadkCoreApplication.getInst(), d.e.tbds804));
        this.fxw.setOnScrollListener(this.mScrollListener);
        this.fxy = new f(getPageContext(), this.fxw, this, true, this.mFrom, this.byE, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.csE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.csE.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.fxA = new ArrayList();
        this.fxB = new d();
        this.fxB.a(this.fxe);
        com.baidu.tieba.frs.aggregation.g bjN = this.fxB.bjN();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bjN);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fxy != null) {
            this.fxy.jW(false);
        }
        if (!this.fxz) {
            qt(2);
            if (!this.fxy.bjD() && this.fxy != null && this.fxt != -1) {
                this.fxy.rK(this.fxt);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fxy != null) {
            this.fxy.jW(true);
            this.fxt = this.fxy.beR();
        }
        qt(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cdp().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.cdp().t(getUniqueId());
        if (this.fxe != null) {
            this.fxe.beW();
        }
        if (this.fxy != null) {
            this.fxy.onDestroy();
        }
        if (this.fxB != null) {
            this.fxB.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.eQD != null) {
            this.eQD.dJ(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void amY() {
    }

    public void qt(int i) {
        if (this.fxw != null && this.fxy != null) {
            if (i == 1) {
                if (this.fxy.bjD()) {
                    this.fxy.bjQ();
                } else if (this.fxy.pY()) {
                    this.fxy.pX();
                }
            }
            if (i == 2) {
                this.fxy.pX();
                if (this.fxy.bjD()) {
                    this.fxy.bjR();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void c(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!v.T(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.fxG = TbadkCoreApplication.getInst().getAdAdSense().bWJ;
                this.fxH = TbadkCoreApplication.getInst().getAdAdSense().bWL;
                this.fxI = TbadkCoreApplication.getInst().getAdAdSense().bWK;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.fxG + (-1))) % (this.fxH + (-1)) == 0;
                boolean z5 = i2 - size == this.fxI;
                if (i2 <= this.fxI) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.fxe != null ? this.fxe.getPageNum() : 0, 0, "", "", rL(size));
                    a.l(this.fxE);
                    dVar = com.baidu.afd.d.a(a);
                    arrayList2.add(0, dVar);
                    i = size + 1;
                } else {
                    dVar = dVar2;
                    i = i2;
                }
                if (z3) {
                    com.baidu.tieba.card.data.b bVar = list.get(size - 1);
                    if (dVar != null && bVar != null) {
                        bVar.setTrigger(new i.a(dVar));
                    }
                }
                arrayList2.add(0, list.get(size - 1));
                size--;
                i2 = i;
                dVar2 = dVar;
            }
            if (!this.fxC && this.fxA.size() > 0 && this.fxe != null && this.fxe.bjT() != null) {
                String str = this.fxe.bjT().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.feF.mcnLeadPage) || (gVar.feF.feP != null && gVar.feF.feP.isValid())) {
                            this.fxy.j(gVar);
                        }
                        if (this.fxA.get(0) != null) {
                            this.fxA.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.fxC = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.fxA.addAll(arrayList);
        }
        if (!this.fxD) {
            l(arrayList, z);
        }
    }

    private void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.fxy != null && !v.T(list)) {
            if (this.fxz) {
                this.fxy.setData(list, true);
                this.fxz = false;
            } else {
                this.fxy.setData(list, false);
            }
        }
        if (!z) {
            this.feS.aeC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbr.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
        } else {
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.fxy != null) {
            this.fxy.onConfigurationChanged(configuration);
        }
    }

    private int rL(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.fxG - 1) {
            i2 = 1;
            int i4 = i3 - (this.fxG - 1);
            if (i4 >= this.fxG - 1) {
                i2 = (i4 % (this.fxH - 1)) + 1;
            }
        }
        return i2 + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition() - bdTypeRecyclerView.getHeaderViewsCount();
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        if (bdTypeRecyclerView.getChildCount() > 0 && ((bdTypeRecyclerView.getChildAt(0) instanceof RelativeLayout) || (bdTypeRecyclerView.getChildAt(0) instanceof com.baidu.tieba.lego.card.view.e))) {
            i = bO(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = bO(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.fxy.rJ(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.fxy.rI(firstVisiblePosition);
        }
        this.fxy.rK(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void rG(int i) {
        if (this.fxy != null) {
            this.fxy.rH(i - 1);
        }
    }

    public boolean qs(int i) {
        if (this.fxy == null) {
            return false;
        }
        return this.fxy.qs(i);
    }

    public int bO(View view) {
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int height = view.getHeight();
        if (rect.top == 0 && rect.bottom == height) {
            return 100;
        }
        if (rect.top > 0) {
            return ((height - rect.top) * 100) / height;
        }
        if (rect.bottom <= 0 || rect.bottom >= height) {
            return 100;
        }
        return (rect.bottom * 100) / height;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return this.fxw.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kZ() || com.baidu.tieba.video.g.ciN().ciO();
    }
}
