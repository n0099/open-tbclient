package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private String cOS;
    private LinearLayoutManager cxG;
    private View dFX;
    private NoNetworkView elv;
    private BdTypeRecyclerView gOA;
    private RelativeLayout gOB;
    private f gOC;
    private List<com.baidu.tieba.card.data.b> gOE;
    private com.baidu.tbadk.core.view.a gOF;
    private d gOG;
    private com.baidu.tieba.v.b gOK;
    private int gOL;
    private h gOf;
    private PbListView guZ;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean gOD = true;
    private int gOw = -1;
    private boolean gOH = false;
    private boolean gOI = false;
    int gOM = 4;
    int gON = 7;
    int gOO = 4;
    private CustomMessageListener gOP = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener cLz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.elv != null) {
                        VideoMiddlePageFragment.this.elv.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.cPi().cPj()) {
                        if (VideoMiddlePageFragment.this.gOC == null || !VideoMiddlePageFragment.this.gOC.kR()) {
                            if (VideoMiddlePageFragment.this.gOC != null && VideoMiddlePageFragment.this.gOC.bLk()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.elv != null) {
                    VideoMiddlePageFragment.this.elv.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.gOC != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.gOC.al(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.gOf.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.gOf.bcg();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.cKb().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.gOC != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.gOC.bGs() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.gOC.bGs()) {
                        VideoMiddlePageFragment.this.gOC.bGt();
                    }
                }
            }
        }
    };
    private CustomMessageListener gpW = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.gOC != null) {
                VideoMiddlePageFragment.this.gOC.notifyDataSetChanged();
            }
        }
    };
    private HashMap gOJ = new HashMap();

    public static VideoMiddlePageFragment dv(String str, String str2) {
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
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
        this.gOf = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.gOf.setId(stringExtra);
            this.gOf.setLocation(stringExtra3);
            this.gOf.Bl(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.gOJ.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.gOJ.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.gOf.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.cOS = arguments.getString("PARAM_FID");
        }
        if (this.gOf != null) {
            this.gOf.setFrom(this.mFrom);
            this.gOf.bLA();
        }
        registerListener(this.cLz);
        registerListener(this.dag);
        registerListener(this.gOP);
        registerListener(this.gpW);
        this.gOK = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cxG = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.gOA = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.gOA.addHeaderView(this.mHeaderView);
        this.gOA.setLayoutManager(this.cxG);
        this.gOA.setFadingEdgeLength(0);
        this.gOA.setBackgroundColor(am.getColor(R.color.transparent));
        this.gOA.setOverScrollMode(2);
        this.gOA.setScrollable(this);
        this.gOB = (RelativeLayout) view.findViewById(R.id.container);
        this.elv = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.elv.setVisibility(0);
        }
        this.guZ = new PbListView(getPageContext().getPageActivity());
        this.guZ.setIsMoreViewVisible(false);
        this.guZ.createView();
        this.guZ.setLineGone();
        this.guZ.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.guZ.setText(getResources().getString(R.string.list_has_no_more));
        this.guZ.setTextColor(R.color.cp_cont_d);
        this.guZ.setNoMoreTextColorId(R.color.cp_cont_f);
        this.gOA.setNextPage(this.guZ);
        this.guZ.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.gOA.setOnScrollListener(this.mScrollListener);
        this.gOC = new f(getPageContext(), this.gOA, this, true, this.mFrom, this.cOS, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.dFX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.dFX.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.gOE = new ArrayList();
        this.gOG = new d();
        this.gOG.a(this.gOf);
        com.baidu.tieba.frs.aggregation.g bLu = this.gOG.bLu();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bLu);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gOC != null) {
            this.gOC.mn(false);
        }
        if (!this.gOD) {
            tg(2);
            if (!this.gOC.bLk() && this.gOC != null && this.gOw != -1) {
                this.gOC.uC(this.gOw);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gOC != null) {
            this.gOC.mn(true);
            this.gOw = this.gOC.bGs();
        }
        tg(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        if (this.gOf != null) {
            this.gOf.bGw();
        }
        if (this.gOC != null) {
            this.gOC.onDestroy();
        }
        if (this.gOG != null) {
            this.gOG.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.gOF != null) {
            this.gOF.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void Sk() {
    }

    public void tg(int i) {
        if (this.gOA != null && this.gOC != null) {
            if (i == 1) {
                if (this.gOC.bLk()) {
                    this.gOC.bLx();
                } else if (this.gOC.kR()) {
                    this.gOC.kQ();
                }
            }
            if (i == 2) {
                this.gOC.kQ();
                if (this.gOC.bLk()) {
                    this.gOC.bLy();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void e(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!v.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.gOM = TbadkCoreApplication.getInst().getAdAdSense().dmh;
                this.gON = TbadkCoreApplication.getInst().getAdAdSense().dmj;
                this.gOO = TbadkCoreApplication.getInst().getAdAdSense().dmi;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.gOM + (-1))) % (this.gON + (-1)) == 0;
                boolean z5 = i2 - size == this.gOO;
                if (i2 <= this.gOO) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.gOf != null ? this.gOf.getPageNum() : 0, 0, "", "", uD(size));
                    a.j(this.gOJ);
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
            if (!this.gOH && this.gOE.size() > 0 && this.gOf != null && this.gOf.bLB() != null) {
                String str = this.gOf.bLB().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.guL.mcnLeadPage) || (gVar.guL.guW != null && gVar.guL.guW.isValid())) {
                            this.gOC.l(gVar);
                        }
                        if (this.gOE.get(0) != null) {
                            this.gOE.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.gOH = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.gOE.addAll(arrayList);
        }
        if (!this.gOI) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo bLB;
        return (!"0".equals(gVar.threadId) || this.gOf == null || this.gOf.bLB() == null || (bLB = this.gOf.bLB()) == null || bLB.video == null || !TextUtils.equals(bLB.title, gVar.title) || !TextUtils.equals(bLB.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.gOC != null && !v.isEmpty(list)) {
            if (this.gOD) {
                this.gOC.setData(list, true);
                this.gOD = false;
            } else {
                this.gOC.setData(list, false);
            }
        }
        if (!z) {
            this.guZ.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.elv.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        int top2;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            if (bLz() != null) {
                this.gOL = bLz().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.gOC != null) {
            this.gOC.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && bLz() != null && (top2 = bLz().getView().getTop()) != this.gOL) {
            this.gOA.scrollBy(0, top2 - this.gOL);
            this.gOL = top2;
        }
    }

    private int uD(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.gOM - 1) {
            i2 = 1;
            int i4 = i3 - (this.gOM - 1);
            if (i4 >= this.gOM - 1) {
                i2 = (i4 % (this.gON - 1)) + 1;
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
            i = bW(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = bW(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.gOC.uB(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.gOC.uA(firstVisiblePosition);
        }
        this.gOC.uC(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void uy(int i) {
        if (this.gOC != null) {
            this.gOC.uz(i - 1);
        }
    }

    public boolean tf(int i) {
        if (this.gOC == null) {
            return false;
        }
        return this.gOC.tf(i);
    }

    public int bW(View view) {
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
        return this.gOA.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.cPi().cPj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test");
    }

    public a bLz() {
        if (this.gOC != null) {
            return this.gOC.bLz();
        }
        return null;
    }
}
