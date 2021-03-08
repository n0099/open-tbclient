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
    private RelativeLayout dYR;
    private String ePf;
    private LinearLayoutManager eso;
    private View fNw;
    private NoNetworkView gCe;
    private boolean isFullScreen;
    private h jOH;
    private BdTypeRecyclerView jPc;
    private f jPd;
    private List<BaseCardInfo> jPf;
    private com.baidu.tbadk.core.view.a jPg;
    private d jPh;
    private com.baidu.tieba.v.b jPl;
    private int jPm;
    private int jlH;
    private PbListView jqc;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jPe = true;
    private int jOY = -1;
    private boolean jPi = false;
    private boolean jPj = false;
    int jPn = 4;
    int jPo = 7;
    int jPp = 4;
    private CustomMessageListener jPq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.gCe != null) {
                        VideoMiddlePageFragment.this.gCe.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dSn().dSo()) {
                        if (VideoMiddlePageFragment.this.jPd == null || !VideoMiddlePageFragment.this.jPd.qZ()) {
                            if (VideoMiddlePageFragment.this.jPd != null && VideoMiddlePageFragment.this.jPd.cMn()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.gCe != null) {
                    VideoMiddlePageFragment.this.gCe.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jPd != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jPd.aO(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jOH.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jOH.bRp();
                    }
                    VideoMiddlePageFragment.this.h(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dMH().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jPd != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jPd.cFF() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jPd.cFF()) {
                        VideoMiddlePageFragment.this.jPd.cFG();
                    }
                }
            }
        }
    };
    private CustomMessageListener jjV = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jPd != null) {
                VideoMiddlePageFragment.this.jPd.notifyDataSetChanged();
            }
        }
    };
    private HashMap jPk = new HashMap();

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
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        this.jOH = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jOH.setId(stringExtra);
            this.jOH.setLocation(stringExtra3);
            this.jOH.Ky(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra("param_video_thread_info");
            if (videoSerializeVideoThreadInfo != null) {
                this.jPk.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jPk.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jOH.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.ePf = arguments.getString("PARAM_FID");
        }
        if (this.jOH != null) {
            this.jOH.setFrom(this.mFrom);
            this.jOH.cMD();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.fci);
        registerListener(this.jPq);
        registerListener(this.jjV);
        this.jPl = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.eso = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jPc = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jPc.addHeaderView(this.mHeaderView);
        this.jPc.setLayoutManager(this.eso);
        this.jPc.setFadingEdgeLength(0);
        this.jPc.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jPc.setOverScrollMode(2);
        this.jPc.setScrollable(this);
        this.dYR = (RelativeLayout) view.findViewById(R.id.container);
        this.gCe = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.gCe.setVisibility(0);
        }
        this.jqc = new PbListView(getPageContext().getPageActivity());
        this.jqc.setIsMoreViewVisible(false);
        this.jqc.createView();
        this.jqc.setLineGone();
        this.jqc.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.jqc.setText(getResources().getString(R.string.list_has_no_more));
        this.jqc.setTextColor(R.color.CAM_X0109);
        this.jqc.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jPc.setNextPage(this.jqc);
        this.jqc.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jPc.setOnScrollListener(this.mScrollListener);
        this.jPd = new f(getPageContext(), this.jPc, this, true, this.mFrom, this.ePf, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bse()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fNw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fNw.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jPf = new ArrayList();
        this.jPh = new d();
        this.jPh.a(this.jOH);
        com.baidu.tieba.frs.aggregation.g cMx = this.jPh.cMx();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cMx);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jPd != null) {
            this.jPd.rK(false);
        }
        if (!this.jPe) {
            zh(2);
            if (!this.jPd.cMn() && this.jPd != null && this.jOY != -1) {
                this.jPd.AU(this.jOY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jPd != null) {
            this.jPd.rK(true);
            this.jOY = this.jPd.cFF();
        }
        zh(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        if (this.jOH != null) {
            this.jOH.cFK();
        }
        if (this.jPd != null) {
            this.jPd.onDestroy();
        }
        if (this.jPh != null) {
            this.jPh.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jPg != null) {
            this.jPg.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void onLoadFail() {
    }

    public void zh(int i) {
        if (this.jPc != null && this.jPd != null) {
            if (i == 1) {
                if (this.jPd.cMn()) {
                    this.jPd.cMA();
                } else if (this.jPd.qZ()) {
                    this.jPd.qY();
                }
            }
            if (i == 2) {
                this.jPd.qY();
                if (this.jPd.cMn()) {
                    this.jPd.cMB();
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
                this.jPn = TbadkCoreApplication.getInst().getAdAdSense().frS;
                this.jPo = TbadkCoreApplication.getInst().getAdAdSense().frU;
                this.jPp = TbadkCoreApplication.getInst().getAdAdSense().frT;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jPn + (-1))) % (this.jPo + (-1)) == 0;
                boolean z5 = i - size == this.jPp;
                if (i <= this.jPp) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jOH != null ? this.jOH.getPageNum() : 0, 0, "", "", AV(size));
                    a2.u(this.jPk);
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
            if (!this.jPi && this.jPf.size() > 0 && this.jOH != null && this.jOH.cME() != null) {
                String str = this.jOH.cME().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || n(gVar)) {
                        if (!StringUtils.isNull(gVar.jpP.mcnLeadPage) || (gVar.jpP.jpZ != null && gVar.jpP.jpZ.isValid())) {
                            this.jPd.m(gVar);
                        }
                        if (this.jPf.get(0) != null) {
                            this.jPf.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jPi = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jPf.addAll(arrayList);
        }
        if (!this.jPj) {
            q(arrayList, z);
        }
    }

    private boolean n(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cME;
        return (!"0".equals(gVar.threadId) || this.jOH == null || this.jOH.cME() == null || (cME = this.jOH.cME()) == null || cME.video == null || !TextUtils.equals(cME.title, gVar.title) || !TextUtils.equals(cME.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void q(List<BaseCardInfo> list, boolean z) {
        if (this.jPd != null && !y.isEmpty(list)) {
            if (this.jPe) {
                this.jPd.setData(list, true);
                this.jPe = false;
            } else {
                this.jPd.setData(list, false);
            }
        }
        if (!z) {
            this.jqc.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gCe.onChangeSkinType(getPageContext(), i);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jPm = this.jPc.getFirstVisiblePosition();
            View childAt = this.jPc.getChildAt(0);
            this.jlH = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jPd != null) {
            this.jPd.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cMC() != null && this.jPm != this.jPc.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jPc.getLayoutManager()).scrollToPositionWithOffset(this.jPm, this.jlH);
        }
    }

    private int AV(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jPn - 1) {
            i2 = 1;
            int i4 = i3 - (this.jPn - 1);
            if (i4 >= this.jPn - 1) {
                i2 = (i4 % (this.jPo - 1)) + 1;
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
        if (!this.jPd.AT(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jPd.AS(firstVisiblePosition);
        }
        this.jPd.AU(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void AQ(int i) {
        if (this.jPd != null) {
            this.jPd.AR(i - 1);
        }
    }

    public boolean zg(int i) {
        if (this.jPd == null) {
            return false;
        }
        return this.jPd.zg(i);
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
        return this.jPc.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.f.dSn().dSo();
    }

    public a cMC() {
        if (this.jPd != null) {
            return this.jPd.cMC();
        }
        return null;
    }
}
