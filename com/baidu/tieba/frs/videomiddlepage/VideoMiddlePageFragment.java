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
import com.baidu.adp.widget.ListView.t;
import com.baidu.afd.i;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes16.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private LinearLayoutManager dCC;
    private String dYo;
    private RelativeLayout djg;
    private View eUm;
    private NoNetworkView fDV;
    private int hWq;
    private PbListView iaL;
    private boolean isFullScreen;
    private BdTypeRecyclerView iwH;
    private f iwI;
    private List<com.baidu.tieba.card.data.b> iwK;
    private com.baidu.tbadk.core.view.a iwL;
    private d iwM;
    private com.baidu.tieba.v.b iwQ;
    private int iwR;
    private h iwm;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean iwJ = true;
    private int iwD = -1;
    private boolean iwN = false;
    private boolean iwO = false;
    int iwS = 4;
    int iwT = 7;
    int iwU = 4;
    private CustomMessageListener iwV = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fDV != null) {
                        VideoMiddlePageFragment.this.fDV.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dAV().dAW()) {
                        if (VideoMiddlePageFragment.this.iwI == null || !VideoMiddlePageFragment.this.iwI.rs()) {
                            if (VideoMiddlePageFragment.this.iwI != null && VideoMiddlePageFragment.this.iwI.cug()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fDV != null) {
                    VideoMiddlePageFragment.this.fDV.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.iwI != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.iwI.aI(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.iwm.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.iwm.bFD();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dvE().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.iwI != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.iwI.coQ() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.iwI.coQ()) {
                        VideoMiddlePageFragment.this.iwI.coR();
                    }
                }
            }
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.iwI != null) {
                VideoMiddlePageFragment.this.iwI.notifyDataSetChanged();
            }
        }
    };
    private HashMap iwP = new HashMap();

    public static VideoMiddlePageFragment eI(String str, String str2) {
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
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
        this.iwm = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.iwm.setId(stringExtra);
            this.iwm.setLocation(stringExtra3);
            this.iwm.Iw(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.iwP.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.iwP.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.iwm.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.dYo = arguments.getString("PARAM_FID");
        }
        if (this.iwm != null) {
            this.iwm.setFrom(this.mFrom);
            this.iwm.cuw();
        }
        registerListener(this.dUu);
        registerListener(this.ekH);
        registerListener(this.iwV);
        registerListener(this.hUE);
        this.iwQ = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.dCC = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.iwH = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.iwH.addHeaderView(this.mHeaderView);
        this.iwH.setLayoutManager(this.dCC);
        this.iwH.setFadingEdgeLength(0);
        this.iwH.setBackgroundColor(ap.getColor(R.color.transparent));
        this.iwH.setOverScrollMode(2);
        this.iwH.setScrollable(this);
        this.djg = (RelativeLayout) view.findViewById(R.id.container);
        this.fDV = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fDV.setVisibility(0);
        }
        this.iaL = new PbListView(getPageContext().getPageActivity());
        this.iaL.setIsMoreViewVisible(false);
        this.iaL.createView();
        this.iaL.setLineGone();
        this.iaL.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.iaL.setText(getResources().getString(R.string.list_has_no_more));
        this.iaL.setTextColor(R.color.cp_cont_d);
        this.iaL.setNoMoreTextColorId(R.color.cp_cont_f);
        this.iwH.setNextPage(this.iaL);
        this.iaL.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.iwH.setOnScrollListener(this.mScrollListener);
        this.iwI = new f(getPageContext(), this.iwH, this, true, this.mFrom, this.dYo, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.biw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.eUm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.eUm.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.iwK = new ArrayList();
        this.iwM = new d();
        this.iwM.a(this.iwm);
        com.baidu.tieba.frs.aggregation.g cuq = this.iwM.cuq();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cuq);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iwI != null) {
            this.iwI.pn(false);
        }
        if (!this.iwJ) {
            xC(2);
            if (!this.iwI.cug() && this.iwI != null && this.iwD != -1) {
                this.iwI.zg(this.iwD);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iwI != null) {
            this.iwI.pn(true);
            this.iwD = this.iwI.coQ();
        }
        xC(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        if (this.iwm != null) {
            this.iwm.coU();
        }
        if (this.iwI != null) {
            this.iwI.onDestroy();
        }
        if (this.iwM != null) {
            this.iwM.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.iwL != null) {
            this.iwL.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void amF() {
    }

    public void xC(int i) {
        if (this.iwH != null && this.iwI != null) {
            if (i == 1) {
                if (this.iwI.cug()) {
                    this.iwI.cut();
                } else if (this.iwI.rs()) {
                    this.iwI.rr();
                }
            }
            if (i == 2) {
                this.iwI.rr();
                if (this.iwI.cug()) {
                    this.iwI.cuu();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void d(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!y.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.iwS = TbadkCoreApplication.getInst().getAdAdSense().ezS;
                this.iwT = TbadkCoreApplication.getInst().getAdAdSense().ezU;
                this.iwU = TbadkCoreApplication.getInst().getAdAdSense().ezT;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.iwS + (-1))) % (this.iwT + (-1)) == 0;
                boolean z5 = i2 - size == this.iwU;
                if (i2 <= this.iwU) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.iwm != null ? this.iwm.getPageNum() : 0, 0, "", "", zh(size));
                    a.u(this.iwP);
                    dVar = com.baidu.afd.d.a(a);
                    com.baidu.tieba.lego.card.d.a.a(arrayList2, dVar, 0);
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
            if (!this.iwN && this.iwK.size() > 0 && this.iwm != null && this.iwm.cux() != null) {
                String str = this.iwm.cux().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.iay.mcnLeadPage) || (gVar.iay.iaI != null && gVar.iay.iaI.isValid())) {
                            this.iwI.l(gVar);
                        }
                        if (this.iwK.get(0) != null) {
                            this.iwK.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.iwN = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.iwK.addAll(arrayList);
        }
        if (!this.iwO) {
            m(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cux;
        return (!"0".equals(gVar.threadId) || this.iwm == null || this.iwm.cux() == null || (cux = this.iwm.cux()) == null || cux.video == null || !TextUtils.equals(cux.title, gVar.title) || !TextUtils.equals(cux.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void m(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.iwI != null && !y.isEmpty(list)) {
            if (this.iwJ) {
                this.iwI.setData(list, true);
                this.iwJ = false;
            } else {
                this.iwI.setData(list, false);
            }
        }
        if (!z) {
            this.iaL.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fDV.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.iwR = this.iwH.getFirstVisiblePosition();
            View childAt = this.iwH.getChildAt(0);
            this.hWq = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.iwI != null) {
            this.iwI.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cuv() != null && this.iwR != this.iwH.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.iwH.getLayoutManager()).scrollToPositionWithOffset(this.iwR, this.hWq);
        }
    }

    private int zh(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.iwS - 1) {
            i2 = 1;
            int i4 = i3 - (this.iwS - 1);
            if (i4 >= this.iwS - 1) {
                i2 = (i4 % (this.iwT - 1)) + 1;
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
            i = cn(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cn(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.iwI.zf(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.iwI.ze(firstVisiblePosition);
        }
        this.iwI.zg(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void zc(int i) {
        if (this.iwI != null) {
            this.iwI.zd(i - 1);
        }
    }

    public boolean xB(int i) {
        if (this.iwI == null) {
            return false;
        }
        return this.iwI.xB(i);
    }

    public int cn(View view) {
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
    public t onGetPreLoadListView() {
        return this.iwH.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dAV().dAW();
    }

    public a cuv() {
        if (this.iwI != null) {
            return this.iwI.cuv();
        }
        return null;
    }
}
