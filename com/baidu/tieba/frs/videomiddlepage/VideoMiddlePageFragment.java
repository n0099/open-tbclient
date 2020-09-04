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
    private LinearLayoutManager dCG;
    private String dYs;
    private RelativeLayout djk;
    private View eUq;
    private NoNetworkView fDZ;
    private int hWw;
    private PbListView iaR;
    private boolean isFullScreen;
    private BdTypeRecyclerView iwN;
    private f iwO;
    private List<com.baidu.tieba.card.data.b> iwQ;
    private com.baidu.tbadk.core.view.a iwR;
    private d iwS;
    private com.baidu.tieba.v.b iwW;
    private int iwX;
    private h iws;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean iwP = true;
    private int iwJ = -1;
    private boolean iwT = false;
    private boolean iwU = false;
    int iwY = 4;
    int iwZ = 7;
    int ixa = 4;
    private CustomMessageListener ixb = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dUy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fDZ != null) {
                        VideoMiddlePageFragment.this.fDZ.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dBe().dBf()) {
                        if (VideoMiddlePageFragment.this.iwO == null || !VideoMiddlePageFragment.this.iwO.rs()) {
                            if (VideoMiddlePageFragment.this.iwO != null && VideoMiddlePageFragment.this.iwO.cuh()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fDZ != null) {
                    VideoMiddlePageFragment.this.fDZ.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.iwO != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.iwO.aI(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.iws.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.iws.bFE();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dvJ().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.iwO != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.iwO.coR() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.iwO.coR()) {
                        VideoMiddlePageFragment.this.iwO.coS();
                    }
                }
            }
        }
    };
    private CustomMessageListener hUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.iwO != null) {
                VideoMiddlePageFragment.this.iwO.notifyDataSetChanged();
            }
        }
    };
    private HashMap iwV = new HashMap();

    public static VideoMiddlePageFragment eJ(String str, String str2) {
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
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
        this.iws = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.iws.setId(stringExtra);
            this.iws.setLocation(stringExtra3);
            this.iws.Ix(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.iwV.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.iwV.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.iws.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.dYs = arguments.getString("PARAM_FID");
        }
        if (this.iws != null) {
            this.iws.setFrom(this.mFrom);
            this.iws.cux();
        }
        registerListener(this.dUy);
        registerListener(this.ekL);
        registerListener(this.ixb);
        registerListener(this.hUK);
        this.iwW = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.dCG = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.iwN = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.iwN.addHeaderView(this.mHeaderView);
        this.iwN.setLayoutManager(this.dCG);
        this.iwN.setFadingEdgeLength(0);
        this.iwN.setBackgroundColor(ap.getColor(R.color.transparent));
        this.iwN.setOverScrollMode(2);
        this.iwN.setScrollable(this);
        this.djk = (RelativeLayout) view.findViewById(R.id.container);
        this.fDZ = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fDZ.setVisibility(0);
        }
        this.iaR = new PbListView(getPageContext().getPageActivity());
        this.iaR.setIsMoreViewVisible(false);
        this.iaR.createView();
        this.iaR.setLineGone();
        this.iaR.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.iaR.setText(getResources().getString(R.string.list_has_no_more));
        this.iaR.setTextColor(R.color.cp_cont_d);
        this.iaR.setNoMoreTextColorId(R.color.cp_cont_f);
        this.iwN.setNextPage(this.iaR);
        this.iaR.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.iwN.setOnScrollListener(this.mScrollListener);
        this.iwO = new f(getPageContext(), this.iwN, this, true, this.mFrom, this.dYs, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.biw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.eUq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.eUq.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.iwQ = new ArrayList();
        this.iwS = new d();
        this.iwS.a(this.iws);
        com.baidu.tieba.frs.aggregation.g cur = this.iwS.cur();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cur);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iwO != null) {
            this.iwO.pp(false);
        }
        if (!this.iwP) {
            xC(2);
            if (!this.iwO.cuh() && this.iwO != null && this.iwJ != -1) {
                this.iwO.zg(this.iwJ);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iwO != null) {
            this.iwO.pp(true);
            this.iwJ = this.iwO.coR();
        }
        xC(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        if (this.iws != null) {
            this.iws.coV();
        }
        if (this.iwO != null) {
            this.iwO.onDestroy();
        }
        if (this.iwS != null) {
            this.iwS.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.iwR != null) {
            this.iwR.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void amF() {
    }

    public void xC(int i) {
        if (this.iwN != null && this.iwO != null) {
            if (i == 1) {
                if (this.iwO.cuh()) {
                    this.iwO.cuu();
                } else if (this.iwO.rs()) {
                    this.iwO.rr();
                }
            }
            if (i == 2) {
                this.iwO.rr();
                if (this.iwO.cuh()) {
                    this.iwO.cuv();
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
                this.iwY = TbadkCoreApplication.getInst().getAdAdSense().ezW;
                this.iwZ = TbadkCoreApplication.getInst().getAdAdSense().ezY;
                this.ixa = TbadkCoreApplication.getInst().getAdAdSense().ezX;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.iwY + (-1))) % (this.iwZ + (-1)) == 0;
                boolean z5 = i2 - size == this.ixa;
                if (i2 <= this.ixa) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.iws != null ? this.iws.getPageNum() : 0, 0, "", "", zh(size));
                    a.u(this.iwV);
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
            if (!this.iwT && this.iwQ.size() > 0 && this.iws != null && this.iws.cuy() != null) {
                String str = this.iws.cuy().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.iaE.mcnLeadPage) || (gVar.iaE.iaO != null && gVar.iaE.iaO.isValid())) {
                            this.iwO.l(gVar);
                        }
                        if (this.iwQ.get(0) != null) {
                            this.iwQ.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.iwT = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.iwQ.addAll(arrayList);
        }
        if (!this.iwU) {
            m(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cuy;
        return (!"0".equals(gVar.threadId) || this.iws == null || this.iws.cuy() == null || (cuy = this.iws.cuy()) == null || cuy.video == null || !TextUtils.equals(cuy.title, gVar.title) || !TextUtils.equals(cuy.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void m(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.iwO != null && !y.isEmpty(list)) {
            if (this.iwP) {
                this.iwO.setData(list, true);
                this.iwP = false;
            } else {
                this.iwO.setData(list, false);
            }
        }
        if (!z) {
            this.iaR.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fDZ.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.iwX = this.iwN.getFirstVisiblePosition();
            View childAt = this.iwN.getChildAt(0);
            this.hWw = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.iwO != null) {
            this.iwO.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cuw() != null && this.iwX != this.iwN.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.iwN.getLayoutManager()).scrollToPositionWithOffset(this.iwX, this.hWw);
        }
    }

    private int zh(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.iwY - 1) {
            i2 = 1;
            int i4 = i3 - (this.iwY - 1);
            if (i4 >= this.iwY - 1) {
                i2 = (i4 % (this.iwZ - 1)) + 1;
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
        if (!this.iwO.zf(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.iwO.ze(firstVisiblePosition);
        }
        this.iwO.zg(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void zc(int i) {
        if (this.iwO != null) {
            this.iwO.zd(i - 1);
        }
    }

    public boolean xB(int i) {
        if (this.iwO == null) {
            return false;
        }
        return this.iwO.xB(i);
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
        return this.iwN.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dBe().dBf();
    }

    public a cuw() {
        if (this.iwO != null) {
            return this.iwO.cuw();
        }
        return null;
    }
}
