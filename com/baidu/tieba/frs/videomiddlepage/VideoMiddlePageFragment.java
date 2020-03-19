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
    private String cPf;
    private LinearLayoutManager cxR;
    private View dGn;
    private NoNetworkView elL;
    private BdTypeRecyclerView gPH;
    private RelativeLayout gPI;
    private f gPJ;
    private List<com.baidu.tieba.card.data.b> gPL;
    private com.baidu.tbadk.core.view.a gPM;
    private d gPN;
    private com.baidu.tieba.v.b gPR;
    private int gPS;
    private h gPm;
    private PbListView gvD;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean gPK = true;
    private int gPD = -1;
    private boolean gPO = false;
    private boolean gPP = false;
    int gPT = 4;
    int gPU = 7;
    int gPV = 4;
    private CustomMessageListener gPW = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.elL != null) {
                        VideoMiddlePageFragment.this.elL.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.cPC().cPD()) {
                        if (VideoMiddlePageFragment.this.gPJ == null || !VideoMiddlePageFragment.this.gPJ.kR()) {
                            if (VideoMiddlePageFragment.this.gPJ != null && VideoMiddlePageFragment.this.gPJ.bLy()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.elL != null) {
                    VideoMiddlePageFragment.this.elL.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.gPJ != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.gPJ.al(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.gPm.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.gPm.bck();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.cKv().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.gPJ != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.gPJ.bGE() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.gPJ.bGE()) {
                        VideoMiddlePageFragment.this.gPJ.bGF();
                    }
                }
            }
        }
    };
    private CustomMessageListener gqG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.gPJ != null) {
                VideoMiddlePageFragment.this.gPJ.notifyDataSetChanged();
            }
        }
    };
    private HashMap gPQ = new HashMap();

    public static VideoMiddlePageFragment dt(String str, String str2) {
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
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        this.gPm = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.gPm.setId(stringExtra);
            this.gPm.setLocation(stringExtra3);
            this.gPm.Bm(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.gPQ.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.gPQ.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.gPm.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.cPf = arguments.getString("PARAM_FID");
        }
        if (this.gPm != null) {
            this.gPm.setFrom(this.mFrom);
            this.gPm.bLO();
        }
        registerListener(this.cLK);
        registerListener(this.dat);
        registerListener(this.gPW);
        registerListener(this.gqG);
        this.gPR = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cxR = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.gPH = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.gPH.addHeaderView(this.mHeaderView);
        this.gPH.setLayoutManager(this.cxR);
        this.gPH.setFadingEdgeLength(0);
        this.gPH.setBackgroundColor(am.getColor(R.color.transparent));
        this.gPH.setOverScrollMode(2);
        this.gPH.setScrollable(this);
        this.gPI = (RelativeLayout) view.findViewById(R.id.container);
        this.elL = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.elL.setVisibility(0);
        }
        this.gvD = new PbListView(getPageContext().getPageActivity());
        this.gvD.setIsMoreViewVisible(false);
        this.gvD.createView();
        this.gvD.setLineGone();
        this.gvD.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.gvD.setText(getResources().getString(R.string.list_has_no_more));
        this.gvD.setTextColor(R.color.cp_cont_d);
        this.gvD.setNoMoreTextColorId(R.color.cp_cont_f);
        this.gPH.setNextPage(this.gvD);
        this.gvD.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.gPH.setOnScrollListener(this.mScrollListener);
        this.gPJ = new f(getPageContext(), this.gPH, this, true, this.mFrom, this.cPf, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.dGn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.dGn.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.gPL = new ArrayList();
        this.gPN = new d();
        this.gPN.a(this.gPm);
        com.baidu.tieba.frs.aggregation.g bLI = this.gPN.bLI();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bLI);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gPJ != null) {
            this.gPJ.mt(false);
        }
        if (!this.gPK) {
            ti(2);
            if (!this.gPJ.bLy() && this.gPJ != null && this.gPD != -1) {
                this.gPJ.uJ(this.gPD);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gPJ != null) {
            this.gPJ.mt(true);
            this.gPD = this.gPJ.bGE();
        }
        ti(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        if (this.gPm != null) {
            this.gPm.bGI();
        }
        if (this.gPJ != null) {
            this.gPJ.onDestroy();
        }
        if (this.gPN != null) {
            this.gPN.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.gPM != null) {
            this.gPM.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void Sn() {
    }

    public void ti(int i) {
        if (this.gPH != null && this.gPJ != null) {
            if (i == 1) {
                if (this.gPJ.bLy()) {
                    this.gPJ.bLL();
                } else if (this.gPJ.kR()) {
                    this.gPJ.kQ();
                }
            }
            if (i == 2) {
                this.gPJ.kQ();
                if (this.gPJ.bLy()) {
                    this.gPJ.bLM();
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
                this.gPT = TbadkCoreApplication.getInst().getAdAdSense().dmu;
                this.gPU = TbadkCoreApplication.getInst().getAdAdSense().dmw;
                this.gPV = TbadkCoreApplication.getInst().getAdAdSense().dmv;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.gPT + (-1))) % (this.gPU + (-1)) == 0;
                boolean z5 = i2 - size == this.gPV;
                if (i2 <= this.gPV) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.gPm != null ? this.gPm.getPageNum() : 0, 0, "", "", uK(size));
                    a.j(this.gPQ);
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
            if (!this.gPO && this.gPL.size() > 0 && this.gPm != null && this.gPm.bLP() != null) {
                String str = this.gPm.bLP().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.gvp.mcnLeadPage) || (gVar.gvp.gvA != null && gVar.gvp.gvA.isValid())) {
                            this.gPJ.l(gVar);
                        }
                        if (this.gPL.get(0) != null) {
                            this.gPL.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.gPO = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.gPL.addAll(arrayList);
        }
        if (!this.gPP) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo bLP;
        return (!"0".equals(gVar.threadId) || this.gPm == null || this.gPm.bLP() == null || (bLP = this.gPm.bLP()) == null || bLP.video == null || !TextUtils.equals(bLP.title, gVar.title) || !TextUtils.equals(bLP.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.gPJ != null && !v.isEmpty(list)) {
            if (this.gPK) {
                this.gPJ.setData(list, true);
                this.gPK = false;
            } else {
                this.gPJ.setData(list, false);
            }
        }
        if (!z) {
            this.gvD.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.elL.onChangeSkinType(getPageContext(), i);
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
            if (bLN() != null) {
                this.gPS = bLN().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.gPJ != null) {
            this.gPJ.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && bLN() != null && (top2 = bLN().getView().getTop()) != this.gPS) {
            this.gPH.scrollBy(0, top2 - this.gPS);
            this.gPS = top2;
        }
    }

    private int uK(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.gPT - 1) {
            i2 = 1;
            int i4 = i3 - (this.gPT - 1);
            if (i4 >= this.gPT - 1) {
                i2 = (i4 % (this.gPU - 1)) + 1;
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
        if (!this.gPJ.uI(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.gPJ.uH(firstVisiblePosition);
        }
        this.gPJ.uJ(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void uF(int i) {
        if (this.gPJ != null) {
            this.gPJ.uG(i - 1);
        }
    }

    public boolean th(int i) {
        if (this.gPJ == null) {
            return false;
        }
        return this.gPJ.th(i);
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
        return this.gPH.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.cPC().cPD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test") || com.baidu.tbadk.a.b.rG("cyber_player_test");
    }

    public a bLN() {
        if (this.gPJ != null) {
            return this.gPJ.bLN();
        }
        return null;
    }
}
