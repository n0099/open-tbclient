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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes22.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private RelativeLayout dQX;
    private String eGn;
    private LinearLayoutManager ekp;
    private View fEN;
    private NoNetworkView grd;
    private int iWw;
    private boolean isFullScreen;
    private PbListView jaQ;
    private BdTypeRecyclerView jzG;
    private f jzH;
    private List<BaseCardInfo> jzJ;
    private com.baidu.tbadk.core.view.a jzK;
    private d jzL;
    private com.baidu.tieba.w.b jzP;
    private int jzQ;
    private h jzl;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jzI = true;
    private int jzC = -1;
    private boolean jzM = false;
    private boolean jzN = false;
    int jzR = 4;
    int jzS = 7;
    int jzT = 4;
    private CustomMessageListener jzU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.grd != null) {
                        VideoMiddlePageFragment.this.grd.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dTL().dTM()) {
                        if (VideoMiddlePageFragment.this.jzH == null || !VideoMiddlePageFragment.this.jzH.rz()) {
                            if (VideoMiddlePageFragment.this.jzH != null && VideoMiddlePageFragment.this.jzH.cLz()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.grd != null) {
                    VideoMiddlePageFragment.this.grd.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jzH != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jzH.aP(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jzl.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jzl.bRM();
                    }
                    VideoMiddlePageFragment.this.h(bdTypeRecyclerView);
                    com.baidu.tieba.t.c.dOe().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jzH != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jzH.cFc() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jzH.cFc()) {
                        VideoMiddlePageFragment.this.jzH.cFd();
                    }
                }
            }
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jzH != null) {
                VideoMiddlePageFragment.this.jzH.notifyDataSetChanged();
            }
        }
    };
    private HashMap jzO = new HashMap();

    public static VideoMiddlePageFragment fn(String str, String str2) {
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
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
        this.jzl = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jzl.setId(stringExtra);
            this.jzl.setLocation(stringExtra3);
            this.jzl.KP(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.jzO.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jzO.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jzl.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eGn = arguments.getString("PARAM_FID");
        }
        if (this.jzl != null) {
            this.jzl.setFrom(this.mFrom);
            this.jzl.cLP();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.eTG);
        registerListener(this.jzU);
        registerListener(this.iUK);
        this.jzP = new com.baidu.tieba.w.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.ekp = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jzG = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jzG.addHeaderView(this.mHeaderView);
        this.jzG.setLayoutManager(this.ekp);
        this.jzG.setFadingEdgeLength(0);
        this.jzG.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jzG.setOverScrollMode(2);
        this.jzG.setScrollable(this);
        this.dQX = (RelativeLayout) view.findViewById(R.id.container);
        this.grd = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.grd.setVisibility(0);
        }
        this.jaQ = new PbListView(getPageContext().getPageActivity());
        this.jaQ.setIsMoreViewVisible(false);
        this.jaQ.createView();
        this.jaQ.setLineGone();
        this.jaQ.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.jaQ.setText(getResources().getString(R.string.list_has_no_more));
        this.jaQ.setTextColor(R.color.CAM_X0109);
        this.jaQ.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jzG.setNextPage(this.jaQ);
        this.jaQ.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jzG.setOnScrollListener(this.mScrollListener);
        this.jzH = new f(getPageContext(), this.jzG, this, true, this.mFrom, this.eGn, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bta()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fEN.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jzJ = new ArrayList();
        this.jzL = new d();
        this.jzL.a(this.jzl);
        com.baidu.tieba.frs.aggregation.g cLJ = this.jzL.cLJ();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cLJ);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jzH != null) {
            this.jzH.rf(false);
        }
        if (!this.jzI) {
            Aq(2);
            if (!this.jzH.cLz() && this.jzH != null && this.jzC != -1) {
                this.jzH.Cd(this.jzC);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jzH != null) {
            this.jzH.rf(true);
            this.jzC = this.jzH.cFc();
        }
        Aq(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        if (this.jzl != null) {
            this.jzl.cFg();
        }
        if (this.jzH != null) {
            this.jzH.onDestroy();
        }
        if (this.jzL != null) {
            this.jzL.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jzK != null) {
            this.jzK.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void awW() {
    }

    public void Aq(int i) {
        if (this.jzG != null && this.jzH != null) {
            if (i == 1) {
                if (this.jzH.cLz()) {
                    this.jzH.cLM();
                } else if (this.jzH.rz()) {
                    this.jzH.ry();
                }
            }
            if (i == 2) {
                this.jzH.ry();
                if (this.jzH.cLz()) {
                    this.jzH.cLN();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void d(List<BaseCardInfo> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!y.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.jzR = TbadkCoreApplication.getInst().getAdAdSense().fja;
                this.jzS = TbadkCoreApplication.getInst().getAdAdSense().fjc;
                this.jzT = TbadkCoreApplication.getInst().getAdAdSense().fjb;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jzR + (-1))) % (this.jzS + (-1)) == 0;
                boolean z5 = i2 - size == this.jzT;
                if (i2 <= this.jzT) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jzl != null ? this.jzl.getPageNum() : 0, 0, "", "", Ce(size));
                    a2.u(this.jzO);
                    dVar = com.baidu.afd.d.a(a2);
                    com.baidu.tieba.lego.card.d.a.a(arrayList2, dVar, 0);
                    i = size + 1;
                } else {
                    dVar = dVar2;
                    i = i2;
                }
                if (z3) {
                    BaseCardInfo baseCardInfo = list.get(size - 1);
                    if (dVar != null && baseCardInfo != null) {
                        baseCardInfo.setTrigger(new com.baidu.afd.g(dVar));
                    }
                }
                arrayList2.add(0, list.get(size - 1));
                size--;
                i2 = i;
                dVar2 = dVar;
            }
            if (!this.jzM && this.jzJ.size() > 0 && this.jzl != null && this.jzl.cLQ() != null) {
                String str = this.jzl.cLQ().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.jaD.mcnLeadPage) || (gVar.jaD.jaN != null && gVar.jaD.jaN.isValid())) {
                            this.jzH.l(gVar);
                        }
                        if (this.jzJ.get(0) != null) {
                            this.jzJ.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jzM = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jzJ.addAll(arrayList);
        }
        if (!this.jzN) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cLQ;
        return (!"0".equals(gVar.threadId) || this.jzl == null || this.jzl.cLQ() == null || (cLQ = this.jzl.cLQ()) == null || cLQ.video == null || !TextUtils.equals(cLQ.title, gVar.title) || !TextUtils.equals(cLQ.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<BaseCardInfo> list, boolean z) {
        if (this.jzH != null && !y.isEmpty(list)) {
            if (this.jzI) {
                this.jzH.setData(list, true);
                this.jzI = false;
            } else {
                this.jzH.setData(list, false);
            }
        }
        if (!z) {
            this.jaQ.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.grd.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jzQ = this.jzG.getFirstVisiblePosition();
            View childAt = this.jzG.getChildAt(0);
            this.iWw = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jzH != null) {
            this.jzH.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cLO() != null && this.jzQ != this.jzG.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jzG.getLayoutManager()).scrollToPositionWithOffset(this.jzQ, this.iWw);
        }
    }

    private int Ce(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jzR - 1) {
            i2 = 1;
            int i4 = i3 - (this.jzR - 1);
            if (i4 >= this.jzR - 1) {
                i2 = (i4 % (this.jzS - 1)) + 1;
            }
        }
        return i2 + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition() - bdTypeRecyclerView.getHeaderViewsCount();
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        if (bdTypeRecyclerView.getChildCount() > 0 && ((bdTypeRecyclerView.getChildAt(0) instanceof RelativeLayout) || (bdTypeRecyclerView.getChildAt(0) instanceof com.baidu.tieba.lego.card.view.e))) {
            i = cU(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cU(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.jzH.Cc(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jzH.Cb(firstVisiblePosition);
        }
        this.jzH.Cd(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void BZ(int i) {
        if (this.jzH != null) {
            this.jzH.Ca(i - 1);
        }
    }

    public boolean Ap(int i) {
        if (this.jzH == null) {
            return false;
        }
        return this.jzH.Ap(i);
    }

    public int cU(View view) {
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
        return this.jzG.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dTL().dTM();
    }

    public a cLO() {
        if (this.jzH != null) {
            return this.jzH.cLO();
        }
        return null;
    }
}
