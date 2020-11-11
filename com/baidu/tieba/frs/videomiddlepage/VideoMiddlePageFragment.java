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
/* loaded from: classes22.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private RelativeLayout dLH;
    private String eAX;
    private LinearLayoutManager eeV;
    private View fxJ;
    private NoNetworkView gjn;
    private int iKQ;
    private PbListView iPm;
    private boolean isFullScreen;
    private h jkY;
    private com.baidu.tieba.v.b jlC;
    private int jlD;
    private BdTypeRecyclerView jlt;
    private f jlu;
    private List<com.baidu.tieba.card.data.b> jlw;
    private com.baidu.tbadk.core.view.a jlx;
    private d jly;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jlv = true;
    private int jlp = -1;
    private boolean jlz = false;
    private boolean jlA = false;
    int jlE = 4;
    int jlF = 7;
    int jlG = 4;
    private CustomMessageListener jlH = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.gjn != null) {
                        VideoMiddlePageFragment.this.gjn.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dOu().dOv()) {
                        if (VideoMiddlePageFragment.this.jlu == null || !VideoMiddlePageFragment.this.jlu.rx()) {
                            if (VideoMiddlePageFragment.this.jlu != null && VideoMiddlePageFragment.this.jlu.cGF()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.gjn != null) {
                    VideoMiddlePageFragment.this.gjn.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jlu != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jlu.aO(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jkY.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jkY.bOI();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dIX().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jlu != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jlu.cBj() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jlu.cBj()) {
                        VideoMiddlePageFragment.this.jlu.cBk();
                    }
                }
            }
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jlu != null) {
                VideoMiddlePageFragment.this.jlu.notifyDataSetChanged();
            }
        }
    };
    private HashMap jlB = new HashMap();

    public static VideoMiddlePageFragment fh(String str, String str2) {
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
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        this.jkY = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jkY.setId(stringExtra);
            this.jkY.setLocation(stringExtra3);
            this.jkY.Kx(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.jlB.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jlB.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jkY.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eAX = arguments.getString("PARAM_FID");
        }
        if (this.jkY != null) {
            this.jkY.setFrom(this.mFrom);
            this.jkY.cGV();
        }
        registerListener(this.exb);
        registerListener(this.eNv);
        registerListener(this.jlH);
        registerListener(this.iJe);
        this.jlC = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.eeV = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jlt = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jlt.addHeaderView(this.mHeaderView);
        this.jlt.setLayoutManager(this.eeV);
        this.jlt.setFadingEdgeLength(0);
        this.jlt.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jlt.setOverScrollMode(2);
        this.jlt.setScrollable(this);
        this.dLH = (RelativeLayout) view.findViewById(R.id.container);
        this.gjn = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.gjn.setVisibility(0);
        }
        this.iPm = new PbListView(getPageContext().getPageActivity());
        this.iPm.setIsMoreViewVisible(false);
        this.iPm.createView();
        this.iPm.setLineGone();
        this.iPm.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.iPm.setText(getResources().getString(R.string.list_has_no_more));
        this.iPm.setTextColor(R.color.cp_cont_d);
        this.iPm.setNoMoreTextColorId(R.color.cp_cont_f);
        this.jlt.setNextPage(this.iPm);
        this.iPm.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jlt.setOnScrollListener(this.mScrollListener);
        this.jlu = new f(getPageContext(), this.jlt, this, true, this.mFrom, this.eAX, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bqt()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fxJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fxJ.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jlw = new ArrayList();
        this.jly = new d();
        this.jly.a(this.jkY);
        com.baidu.tieba.frs.aggregation.g cGP = this.jly.cGP();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cGP);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jlu != null) {
            this.jlu.qB(false);
        }
        if (!this.jlv) {
            zn(2);
            if (!this.jlu.cGF() && this.jlu != null && this.jlp != -1) {
                this.jlu.AQ(this.jlp);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jlu != null) {
            this.jlu.qB(true);
            this.jlp = this.jlu.cBj();
        }
        zn(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        if (this.jkY != null) {
            this.jkY.cBn();
        }
        if (this.jlu != null) {
            this.jlu.onDestroy();
        }
        if (this.jly != null) {
            this.jly.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jlx != null) {
            this.jlx.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void auw() {
    }

    public void zn(int i) {
        if (this.jlt != null && this.jlu != null) {
            if (i == 1) {
                if (this.jlu.cGF()) {
                    this.jlu.cGS();
                } else if (this.jlu.rx()) {
                    this.jlu.rw();
                }
            }
            if (i == 2) {
                this.jlu.rw();
                if (this.jlu.cGF()) {
                    this.jlu.cGT();
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
                this.jlE = TbadkCoreApplication.getInst().getAdAdSense().fct;
                this.jlF = TbadkCoreApplication.getInst().getAdAdSense().fcv;
                this.jlG = TbadkCoreApplication.getInst().getAdAdSense().fcu;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jlE + (-1))) % (this.jlF + (-1)) == 0;
                boolean z5 = i2 - size == this.jlG;
                if (i2 <= this.jlG) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a2 = com.baidu.afd.c.a(3, this.jkY != null ? this.jkY.getPageNum() : 0, 0, "", "", AR(size));
                    a2.u(this.jlB);
                    dVar = com.baidu.afd.d.a(a2);
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
            if (!this.jlz && this.jlw.size() > 0 && this.jkY != null && this.jkY.cGW() != null) {
                String str = this.jkY.cGW().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.iOZ.mcnLeadPage) || (gVar.iOZ.iPj != null && gVar.iOZ.iPj.isValid())) {
                            this.jlu.l(gVar);
                        }
                        if (this.jlw.get(0) != null) {
                            this.jlw.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jlz = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jlw.addAll(arrayList);
        }
        if (!this.jlA) {
            o(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cGW;
        return (!"0".equals(gVar.threadId) || this.jkY == null || this.jkY.cGW() == null || (cGW = this.jkY.cGW()) == null || cGW.video == null || !TextUtils.equals(cGW.title, gVar.title) || !TextUtils.equals(cGW.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.jlu != null && !y.isEmpty(list)) {
            if (this.jlv) {
                this.jlu.setData(list, true);
                this.jlv = false;
            } else {
                this.jlu.setData(list, false);
            }
        }
        if (!z) {
            this.iPm.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gjn.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jlD = this.jlt.getFirstVisiblePosition();
            View childAt = this.jlt.getChildAt(0);
            this.iKQ = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jlu != null) {
            this.jlu.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cGU() != null && this.jlD != this.jlt.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jlt.getLayoutManager()).scrollToPositionWithOffset(this.jlD, this.iKQ);
        }
    }

    private int AR(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jlE - 1) {
            i2 = 1;
            int i4 = i3 - (this.jlE - 1);
            if (i4 >= this.jlE - 1) {
                i2 = (i4 % (this.jlF - 1)) + 1;
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
            i = cJ(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cJ(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.jlu.AP(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jlu.AO(firstVisiblePosition);
        }
        this.jlu.AQ(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void AM(int i) {
        if (this.jlu != null) {
            this.jlu.AN(i - 1);
        }
    }

    public boolean zm(int i) {
        if (this.jlu == null) {
            return false;
        }
        return this.jlu.zm(i);
    }

    public int cJ(View view) {
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
        return this.jlt.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dOu().dOv();
    }

    public a cGU() {
        if (this.jlu != null) {
            return this.jlu.cGU();
        }
        return null;
    }
}
