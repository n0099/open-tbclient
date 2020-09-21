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
/* loaded from: classes21.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private LinearLayoutManager dEH;
    private RelativeLayout dlm;
    private View eXg;
    private String eaC;
    private NoNetworkView fHl;
    private h iDO;
    private BdTypeRecyclerView iEj;
    private f iEk;
    private List<com.baidu.tieba.card.data.b> iEm;
    private com.baidu.tbadk.core.view.a iEn;
    private d iEo;
    private com.baidu.tieba.v.b iEs;
    private int iEt;
    private int idA;
    private PbListView ihW;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean iEl = true;
    private int iEf = -1;
    private boolean iEp = false;
    private boolean iEq = false;
    int iEu = 4;
    int iEv = 7;
    int iEw = 4;
    private CustomMessageListener iEx = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dWI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fHl != null) {
                        VideoMiddlePageFragment.this.fHl.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dEY().dEZ()) {
                        if (VideoMiddlePageFragment.this.iEk == null || !VideoMiddlePageFragment.this.iEk.rx()) {
                            if (VideoMiddlePageFragment.this.iEk != null && VideoMiddlePageFragment.this.iEk.cxA()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fHl != null) {
                    VideoMiddlePageFragment.this.fHl.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.iEk != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.iEk.aI(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.iDO.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.iDO.bGU();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dzC().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.iEk != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.iEk.cse() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.iEk.cse()) {
                        VideoMiddlePageFragment.this.iEk.csf();
                    }
                }
            }
        }
    };
    private CustomMessageListener ibK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.iEk != null) {
                VideoMiddlePageFragment.this.iEk.notifyDataSetChanged();
            }
        }
    };
    private HashMap iEr = new HashMap();

    public static VideoMiddlePageFragment eW(String str, String str2) {
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
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
        this.iDO = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.iDO.setId(stringExtra);
            this.iDO.setLocation(stringExtra3);
            this.iDO.IU(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.iEr.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.iEr.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.iDO.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eaC = arguments.getString("PARAM_FID");
        }
        if (this.iDO != null) {
            this.iDO.setFrom(this.mFrom);
            this.iDO.cxQ();
        }
        registerListener(this.dWI);
        registerListener(this.ena);
        registerListener(this.iEx);
        registerListener(this.ibK);
        this.iEs = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.dEH = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.iEj = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.iEj.addHeaderView(this.mHeaderView);
        this.iEj.setLayoutManager(this.dEH);
        this.iEj.setFadingEdgeLength(0);
        this.iEj.setBackgroundColor(ap.getColor(R.color.transparent));
        this.iEj.setOverScrollMode(2);
        this.iEj.setScrollable(this);
        this.dlm = (RelativeLayout) view.findViewById(R.id.container);
        this.fHl = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fHl.setVisibility(0);
        }
        this.ihW = new PbListView(getPageContext().getPageActivity());
        this.ihW.setIsMoreViewVisible(false);
        this.ihW.createView();
        this.ihW.setLineGone();
        this.ihW.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.ihW.setText(getResources().getString(R.string.list_has_no_more));
        this.ihW.setTextColor(R.color.cp_cont_d);
        this.ihW.setNoMoreTextColorId(R.color.cp_cont_f);
        this.iEj.setNextPage(this.ihW);
        this.ihW.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.iEj.setOnScrollListener(this.mScrollListener);
        this.iEk = new f(getPageContext(), this.iEj, this, true, this.mFrom, this.eaC, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bjr()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.eXg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.eXg.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.iEm = new ArrayList();
        this.iEo = new d();
        this.iEo.a(this.iDO);
        com.baidu.tieba.frs.aggregation.g cxK = this.iEo.cxK();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cxK);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iEk != null) {
            this.iEk.pv(false);
        }
        if (!this.iEl) {
            yb(2);
            if (!this.iEk.cxA() && this.iEk != null && this.iEf != -1) {
                this.iEk.zE(this.iEf);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iEk != null) {
            this.iEk.pv(true);
            this.iEf = this.iEk.cse();
        }
        yb(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        if (this.iDO != null) {
            this.iDO.csi();
        }
        if (this.iEk != null) {
            this.iEk.onDestroy();
        }
        if (this.iEo != null) {
            this.iEo.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.iEn != null) {
            this.iEn.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void anp() {
    }

    public void yb(int i) {
        if (this.iEj != null && this.iEk != null) {
            if (i == 1) {
                if (this.iEk.cxA()) {
                    this.iEk.cxN();
                } else if (this.iEk.rx()) {
                    this.iEk.rw();
                }
            }
            if (i == 2) {
                this.iEk.rw();
                if (this.iEk.cxA()) {
                    this.iEk.cxO();
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
                this.iEu = TbadkCoreApplication.getInst().getAdAdSense().eCa;
                this.iEv = TbadkCoreApplication.getInst().getAdAdSense().eCc;
                this.iEw = TbadkCoreApplication.getInst().getAdAdSense().eCb;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.iEu + (-1))) % (this.iEv + (-1)) == 0;
                boolean z5 = i2 - size == this.iEw;
                if (i2 <= this.iEw) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.iDO != null ? this.iDO.getPageNum() : 0, 0, "", "", zF(size));
                    a.u(this.iEr);
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
            if (!this.iEp && this.iEm.size() > 0 && this.iDO != null && this.iDO.cxR() != null) {
                String str = this.iDO.cxR().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.ihJ.mcnLeadPage) || (gVar.ihJ.ihT != null && gVar.ihJ.ihT.isValid())) {
                            this.iEk.l(gVar);
                        }
                        if (this.iEm.get(0) != null) {
                            this.iEm.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.iEp = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.iEm.addAll(arrayList);
        }
        if (!this.iEq) {
            m(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cxR;
        return (!"0".equals(gVar.threadId) || this.iDO == null || this.iDO.cxR() == null || (cxR = this.iDO.cxR()) == null || cxR.video == null || !TextUtils.equals(cxR.title, gVar.title) || !TextUtils.equals(cxR.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void m(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.iEk != null && !y.isEmpty(list)) {
            if (this.iEl) {
                this.iEk.setData(list, true);
                this.iEl = false;
            } else {
                this.iEk.setData(list, false);
            }
        }
        if (!z) {
            this.ihW.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fHl.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.iEt = this.iEj.getFirstVisiblePosition();
            View childAt = this.iEj.getChildAt(0);
            this.idA = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.iEk != null) {
            this.iEk.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cxP() != null && this.iEt != this.iEj.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.iEj.getLayoutManager()).scrollToPositionWithOffset(this.iEt, this.idA);
        }
    }

    private int zF(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.iEu - 1) {
            i2 = 1;
            int i4 = i3 - (this.iEu - 1);
            if (i4 >= this.iEu - 1) {
                i2 = (i4 % (this.iEv - 1)) + 1;
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
            i = cw(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cw(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.iEk.zD(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.iEk.zC(firstVisiblePosition);
        }
        this.iEk.zE(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void zA(int i) {
        if (this.iEk != null) {
            this.iEk.zB(i - 1);
        }
    }

    public boolean ya(int i) {
        if (this.iEk == null) {
            return false;
        }
        return this.iEk.ya(i);
    }

    public int cw(View view) {
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
        return this.iEj.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dEY().dEZ();
    }

    public a cxP() {
        if (this.iEk != null) {
            return this.iEk.cxP();
        }
        return null;
    }
}
