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
    private NoNetworkView grf;
    private int iWy;
    private boolean isFullScreen;
    private PbListView jaS;
    private BdTypeRecyclerView jzI;
    private f jzJ;
    private List<BaseCardInfo> jzL;
    private com.baidu.tbadk.core.view.a jzM;
    private d jzN;
    private com.baidu.tieba.w.b jzR;
    private int jzS;
    private h jzn;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jzK = true;
    private int jzE = -1;
    private boolean jzO = false;
    private boolean jzP = false;
    int jzT = 4;
    int jzU = 7;
    int jzV = 4;
    private CustomMessageListener jzW = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.grf != null) {
                        VideoMiddlePageFragment.this.grf.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dTM().dTN()) {
                        if (VideoMiddlePageFragment.this.jzJ == null || !VideoMiddlePageFragment.this.jzJ.rz()) {
                            if (VideoMiddlePageFragment.this.jzJ != null && VideoMiddlePageFragment.this.jzJ.cLA()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.grf != null) {
                    VideoMiddlePageFragment.this.grf.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jzJ != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jzJ.aP(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jzn.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jzn.bRN();
                    }
                    VideoMiddlePageFragment.this.h(bdTypeRecyclerView);
                    com.baidu.tieba.t.c.dOf().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jzJ != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jzJ.cFd() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jzJ.cFd()) {
                        VideoMiddlePageFragment.this.jzJ.cFe();
                    }
                }
            }
        }
    };
    private CustomMessageListener iUM = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jzJ != null) {
                VideoMiddlePageFragment.this.jzJ.notifyDataSetChanged();
            }
        }
    };
    private HashMap jzQ = new HashMap();

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
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        this.jzn = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jzn.setId(stringExtra);
            this.jzn.setLocation(stringExtra3);
            this.jzn.KP(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.jzQ.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jzQ.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jzn.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eGn = arguments.getString("PARAM_FID");
        }
        if (this.jzn != null) {
            this.jzn.setFrom(this.mFrom);
            this.jzn.cLQ();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.eTG);
        registerListener(this.jzW);
        registerListener(this.iUM);
        this.jzR = new com.baidu.tieba.w.b();
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
        this.jzI = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jzI.addHeaderView(this.mHeaderView);
        this.jzI.setLayoutManager(this.ekp);
        this.jzI.setFadingEdgeLength(0);
        this.jzI.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jzI.setOverScrollMode(2);
        this.jzI.setScrollable(this);
        this.dQX = (RelativeLayout) view.findViewById(R.id.container);
        this.grf = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.grf.setVisibility(0);
        }
        this.jaS = new PbListView(getPageContext().getPageActivity());
        this.jaS.setIsMoreViewVisible(false);
        this.jaS.createView();
        this.jaS.setLineGone();
        this.jaS.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.jaS.setText(getResources().getString(R.string.list_has_no_more));
        this.jaS.setTextColor(R.color.CAM_X0109);
        this.jaS.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jzI.setNextPage(this.jaS);
        this.jaS.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jzI.setOnScrollListener(this.mScrollListener);
        this.jzJ = new f(getPageContext(), this.jzI, this, true, this.mFrom, this.eGn, getUniqueId());
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
        this.jzL = new ArrayList();
        this.jzN = new d();
        this.jzN.a(this.jzn);
        com.baidu.tieba.frs.aggregation.g cLK = this.jzN.cLK();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cLK);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jzJ != null) {
            this.jzJ.rf(false);
        }
        if (!this.jzK) {
            Aq(2);
            if (!this.jzJ.cLA() && this.jzJ != null && this.jzE != -1) {
                this.jzJ.Cd(this.jzE);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jzJ != null) {
            this.jzJ.rf(true);
            this.jzE = this.jzJ.cFd();
        }
        Aq(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        if (this.jzn != null) {
            this.jzn.cFh();
        }
        if (this.jzJ != null) {
            this.jzJ.onDestroy();
        }
        if (this.jzN != null) {
            this.jzN.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jzM != null) {
            this.jzM.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void awW() {
    }

    public void Aq(int i) {
        if (this.jzI != null && this.jzJ != null) {
            if (i == 1) {
                if (this.jzJ.cLA()) {
                    this.jzJ.cLN();
                } else if (this.jzJ.rz()) {
                    this.jzJ.ry();
                }
            }
            if (i == 2) {
                this.jzJ.ry();
                if (this.jzJ.cLA()) {
                    this.jzJ.cLO();
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
                this.jzT = TbadkCoreApplication.getInst().getAdAdSense().fja;
                this.jzU = TbadkCoreApplication.getInst().getAdAdSense().fjc;
                this.jzV = TbadkCoreApplication.getInst().getAdAdSense().fjb;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jzT + (-1))) % (this.jzU + (-1)) == 0;
                boolean z5 = i2 - size == this.jzV;
                if (i2 <= this.jzV) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jzn != null ? this.jzn.getPageNum() : 0, 0, "", "", Ce(size));
                    a2.u(this.jzQ);
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
            if (!this.jzO && this.jzL.size() > 0 && this.jzn != null && this.jzn.cLR() != null) {
                String str = this.jzn.cLR().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.jaF.mcnLeadPage) || (gVar.jaF.jaP != null && gVar.jaF.jaP.isValid())) {
                            this.jzJ.l(gVar);
                        }
                        if (this.jzL.get(0) != null) {
                            this.jzL.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jzO = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jzL.addAll(arrayList);
        }
        if (!this.jzP) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cLR;
        return (!"0".equals(gVar.threadId) || this.jzn == null || this.jzn.cLR() == null || (cLR = this.jzn.cLR()) == null || cLR.video == null || !TextUtils.equals(cLR.title, gVar.title) || !TextUtils.equals(cLR.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<BaseCardInfo> list, boolean z) {
        if (this.jzJ != null && !y.isEmpty(list)) {
            if (this.jzK) {
                this.jzJ.setData(list, true);
                this.jzK = false;
            } else {
                this.jzJ.setData(list, false);
            }
        }
        if (!z) {
            this.jaS.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.grf.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jzS = this.jzI.getFirstVisiblePosition();
            View childAt = this.jzI.getChildAt(0);
            this.iWy = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jzJ != null) {
            this.jzJ.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cLP() != null && this.jzS != this.jzI.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jzI.getLayoutManager()).scrollToPositionWithOffset(this.jzS, this.iWy);
        }
    }

    private int Ce(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jzT - 1) {
            i2 = 1;
            int i4 = i3 - (this.jzT - 1);
            if (i4 >= this.jzT - 1) {
                i2 = (i4 % (this.jzU - 1)) + 1;
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
        if (!this.jzJ.Cc(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jzJ.Cb(firstVisiblePosition);
        }
        this.jzJ.Cd(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void BZ(int i) {
        if (this.jzJ != null) {
            this.jzJ.Ca(i - 1);
        }
    }

    public boolean Ap(int i) {
        if (this.jzJ == null) {
            return false;
        }
        return this.jzJ.Ap(i);
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
        return this.jzI.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dTM().dTN();
    }

    public a cLP() {
        if (this.jzJ != null) {
            return this.jzJ.cLP();
        }
        return null;
    }
}
