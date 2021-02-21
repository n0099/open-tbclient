package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes2.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private RelativeLayout dXq;
    private String eNE;
    private LinearLayoutManager eqM;
    private View fLW;
    private NoNetworkView gAv;
    private boolean isFullScreen;
    private h jMY;
    private com.baidu.tieba.v.b jNC;
    private int jND;
    private BdTypeRecyclerView jNt;
    private f jNu;
    private List<BaseCardInfo> jNw;
    private com.baidu.tbadk.core.view.a jNx;
    private d jNy;
    private int jjY;
    private PbListView jot;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jNv = true;
    private int jNp = -1;
    private boolean jNz = false;
    private boolean jNA = false;
    int jNE = 4;
    int jNF = 7;
    int jNG = 4;
    private CustomMessageListener jNH = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.gAv != null) {
                        VideoMiddlePageFragment.this.gAv.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dSf().dSg()) {
                        if (VideoMiddlePageFragment.this.jNu == null || !VideoMiddlePageFragment.this.jNu.qZ()) {
                            if (VideoMiddlePageFragment.this.jNu != null && VideoMiddlePageFragment.this.jNu.cMh()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.gAv != null) {
                    VideoMiddlePageFragment.this.gAv.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jNu != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jNu.aO(data.toUid, data.isAttention);
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                VideoMiddlePageFragment.this.mScrollState = i;
                if (i == 0) {
                    if (bdTypeRecyclerView.getLastVisiblePosition() > bdTypeRecyclerView.getCount() - 2 && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                        VideoMiddlePageFragment.this.jMY.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jMY.bRj();
                    }
                    VideoMiddlePageFragment.this.h(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dMz().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jNu != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jNu.cFz() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jNu.cFz()) {
                        VideoMiddlePageFragment.this.jNu.cFA();
                    }
                }
            }
        }
    };
    private CustomMessageListener jim = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jNu != null) {
                VideoMiddlePageFragment.this.jNu.notifyDataSetChanged();
            }
        }
    };
    private HashMap jNB = new HashMap();

    public static VideoMiddlePageFragment fn(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FROM", str);
        bundle.putString("PARAM_FID", str2);
        VideoMiddlePageFragment videoMiddlePageFragment = new VideoMiddlePageFragment();
        videoMiddlePageFragment.setArguments(bundle);
        return videoMiddlePageFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        this.jMY = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jMY.setId(stringExtra);
            this.jMY.setLocation(stringExtra3);
            this.jMY.Kp(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra("param_video_thread_info");
            if (videoSerializeVideoThreadInfo != null) {
                this.jNB.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jNB.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jMY.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eNE = arguments.getString("PARAM_FID");
        }
        if (this.jMY != null) {
            this.jMY.setFrom(this.mFrom);
            this.jMY.cMx();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.faJ);
        registerListener(this.jNH);
        registerListener(this.jim);
        this.jNC = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.eqM = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jNt = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jNt.addHeaderView(this.mHeaderView);
        this.jNt.setLayoutManager(this.eqM);
        this.jNt.setFadingEdgeLength(0);
        this.jNt.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jNt.setOverScrollMode(2);
        this.jNt.setScrollable(this);
        this.dXq = (RelativeLayout) view.findViewById(R.id.container);
        this.gAv = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.gAv.setVisibility(0);
        }
        this.jot = new PbListView(getPageContext().getPageActivity());
        this.jot.setIsMoreViewVisible(false);
        this.jot.createView();
        this.jot.setLineGone();
        this.jot.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.jot.setText(getResources().getString(R.string.list_has_no_more));
        this.jot.setTextColor(R.color.CAM_X0109);
        this.jot.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jNt.setNextPage(this.jot);
        this.jot.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jNt.setOnScrollListener(this.mScrollListener);
        this.jNu = new f(getPageContext(), this.jNt, this, true, this.mFrom, this.eNE, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bsd()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jNw = new ArrayList();
        this.jNy = new d();
        this.jNy.a(this.jMY);
        com.baidu.tieba.frs.aggregation.g cMr = this.jNy.cMr();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cMr);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jNu != null) {
            this.jNu.rK(false);
        }
        if (!this.jNv) {
            zg(2);
            if (!this.jNu.cMh() && this.jNu != null && this.jNp != -1) {
                this.jNu.AT(this.jNp);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jNu != null) {
            this.jNu.rK(true);
            this.jNp = this.jNu.cFz();
        }
        zg(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        if (this.jMY != null) {
            this.jMY.cFE();
        }
        if (this.jNu != null) {
            this.jNu.onDestroy();
        }
        if (this.jNy != null) {
            this.jNy.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jNx != null) {
            this.jNx.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void onLoadFail() {
    }

    public void zg(int i) {
        if (this.jNt != null && this.jNu != null) {
            if (i == 1) {
                if (this.jNu.cMh()) {
                    this.jNu.cMu();
                } else if (this.jNu.qZ()) {
                    this.jNu.qY();
                }
            }
            if (i == 2) {
                this.jNu.qY();
                if (this.jNu.cMh()) {
                    this.jNu.cMv();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void d(List<BaseCardInfo> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!y.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.jNE = TbadkCoreApplication.getInst().getAdAdSense().fqr;
                this.jNF = TbadkCoreApplication.getInst().getAdAdSense().fqt;
                this.jNG = TbadkCoreApplication.getInst().getAdAdSense().fqs;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jNE + (-1))) % (this.jNF + (-1)) == 0;
                boolean z5 = i - size == this.jNG;
                if (i <= this.jNG) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jMY != null ? this.jMY.getPageNum() : 0, 0, "", "", AU(size));
                    a2.u(this.jNB);
                    dVar = com.baidu.afd.d.a(a2);
                    com.baidu.tieba.lego.card.c.a.a(arrayList2, dVar, 0);
                    i = size + 1;
                } else {
                    dVar = dVar2;
                }
                if (z3) {
                    BaseCardInfo baseCardInfo = list.get(size - 1);
                    if (dVar != null && baseCardInfo != null) {
                        baseCardInfo.setTrigger(new com.baidu.afd.g(dVar));
                    }
                }
                arrayList2.add(0, list.get(size - 1));
                size--;
                dVar2 = dVar;
            }
            if (!this.jNz && this.jNw.size() > 0 && this.jMY != null && this.jMY.cMy() != null) {
                String str = this.jMY.cMy().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || n(gVar)) {
                        if (!StringUtils.isNull(gVar.jog.mcnLeadPage) || (gVar.jog.joq != null && gVar.jog.joq.isValid())) {
                            this.jNu.m(gVar);
                        }
                        if (this.jNw.get(0) != null) {
                            this.jNw.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jNz = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jNw.addAll(arrayList);
        }
        if (!this.jNA) {
            q(arrayList, z);
        }
    }

    private boolean n(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cMy;
        return (!"0".equals(gVar.threadId) || this.jMY == null || this.jMY.cMy() == null || (cMy = this.jMY.cMy()) == null || cMy.video == null || !TextUtils.equals(cMy.title, gVar.title) || !TextUtils.equals(cMy.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void q(List<BaseCardInfo> list, boolean z) {
        if (this.jNu != null && !y.isEmpty(list)) {
            if (this.jNv) {
                this.jNu.setData(list, true);
                this.jNv = false;
            } else {
                this.jNu.setData(list, false);
            }
        }
        if (!z) {
            this.jot.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAv.onChangeSkinType(getPageContext(), i);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jND = this.jNt.getFirstVisiblePosition();
            View childAt = this.jNt.getChildAt(0);
            this.jjY = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jNu != null) {
            this.jNu.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cMw() != null && this.jND != this.jNt.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jNt.getLayoutManager()).scrollToPositionWithOffset(this.jND, this.jjY);
        }
    }

    private int AU(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jNE - 1) {
            i2 = 1;
            int i4 = i3 - (this.jNE - 1);
            if (i4 >= this.jNE - 1) {
                i2 = (i4 % (this.jNF - 1)) + 1;
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
            i = dc(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = dc(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.jNu.AS(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jNu.AR(firstVisiblePosition);
        }
        this.jNu.AT(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void AP(int i) {
        if (this.jNu != null) {
            this.jNu.AQ(i - 1);
        }
    }

    public boolean zf(int i) {
        if (this.jNu == null) {
            return false;
        }
        return this.jNu.zf(i);
    }

    public int dc(View view) {
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
    public q onGetPreLoadListView() {
        return this.jNt.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.f.dSf().dSg();
    }

    public a cMw() {
        if (this.jNu != null) {
            return this.jNu.cMw();
        }
        return null;
    }
}
