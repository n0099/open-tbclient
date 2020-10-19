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
    private LinearLayoutManager dQI;
    private RelativeLayout dxs;
    private String emE;
    private NoNetworkView fTu;
    private View fjs;
    private h iSE;
    private BdTypeRecyclerView iSZ;
    private f iTa;
    private List<com.baidu.tieba.card.data.b> iTc;
    private com.baidu.tbadk.core.view.a iTd;
    private d iTe;
    private com.baidu.tieba.v.b iTi;
    private int iTj;
    private boolean isFullScreen;
    private int isx;
    private PbListView iwT;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean iTb = true;
    private int iSV = -1;
    private boolean iTf = false;
    private boolean iTg = false;
    int iTk = 4;
    int iTl = 7;
    int iTm = 4;
    private CustomMessageListener iTn = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener eiK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fTu != null) {
                        VideoMiddlePageFragment.this.fTu.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dIK().dIL()) {
                        if (VideoMiddlePageFragment.this.iTa == null || !VideoMiddlePageFragment.this.iTa.rx()) {
                            if (VideoMiddlePageFragment.this.iTa != null && VideoMiddlePageFragment.this.iTa.cAX()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fTu != null) {
                    VideoMiddlePageFragment.this.fTu.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.iTa != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.iTa.aM(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.iSE.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.iSE.bJG();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dDn().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.iTa != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.iTa.cvB() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.iTa.cvB()) {
                        VideoMiddlePageFragment.this.iTa.cvC();
                    }
                }
            }
        }
    };
    private CustomMessageListener iqL = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.iTa != null) {
                VideoMiddlePageFragment.this.iTa.notifyDataSetChanged();
            }
        }
    };
    private HashMap iTh = new HashMap();

    public static VideoMiddlePageFragment fc(String str, String str2) {
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
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        this.iSE = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.iSE.setId(stringExtra);
            this.iSE.setLocation(stringExtra3);
            this.iSE.JH(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.iTh.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.iTh.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.iSE.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.emE = arguments.getString("PARAM_FID");
        }
        if (this.iSE != null) {
            this.iSE.setFrom(this.mFrom);
            this.iSE.cBn();
        }
        registerListener(this.eiK);
        registerListener(this.ezk);
        registerListener(this.iTn);
        registerListener(this.iqL);
        this.iTi = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.dQI = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.iSZ = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.iSZ.addHeaderView(this.mHeaderView);
        this.iSZ.setLayoutManager(this.dQI);
        this.iSZ.setFadingEdgeLength(0);
        this.iSZ.setBackgroundColor(ap.getColor(R.color.transparent));
        this.iSZ.setOverScrollMode(2);
        this.iSZ.setScrollable(this);
        this.dxs = (RelativeLayout) view.findViewById(R.id.container);
        this.fTu = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fTu.setVisibility(0);
        }
        this.iwT = new PbListView(getPageContext().getPageActivity());
        this.iwT.setIsMoreViewVisible(false);
        this.iwT.createView();
        this.iwT.setLineGone();
        this.iwT.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.iwT.setText(getResources().getString(R.string.list_has_no_more));
        this.iwT.setTextColor(R.color.cp_cont_d);
        this.iwT.setNoMoreTextColorId(R.color.cp_cont_f);
        this.iSZ.setNextPage(this.iwT);
        this.iwT.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.iSZ.setOnScrollListener(this.mScrollListener);
        this.iTa = new f(getPageContext(), this.iSZ, this, true, this.mFrom, this.emE, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bma()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fjs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fjs.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.iTc = new ArrayList();
        this.iTe = new d();
        this.iTe.a(this.iSE);
        com.baidu.tieba.frs.aggregation.g cBh = this.iTe.cBh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cBh);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iTa != null) {
            this.iTa.qa(false);
        }
        if (!this.iTb) {
            yH(2);
            if (!this.iTa.cAX() && this.iTa != null && this.iSV != -1) {
                this.iTa.Ak(this.iSV);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iTa != null) {
            this.iTa.qa(true);
            this.iSV = this.iTa.cvB();
        }
        yH(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        if (this.iSE != null) {
            this.iSE.cvF();
        }
        if (this.iTa != null) {
            this.iTa.onDestroy();
        }
        if (this.iTe != null) {
            this.iTe.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.iTd != null) {
            this.iTd.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void aqb() {
    }

    public void yH(int i) {
        if (this.iSZ != null && this.iTa != null) {
            if (i == 1) {
                if (this.iTa.cAX()) {
                    this.iTa.cBk();
                } else if (this.iTa.rx()) {
                    this.iTa.rw();
                }
            }
            if (i == 2) {
                this.iTa.rw();
                if (this.iTa.cAX()) {
                    this.iTa.cBl();
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
                this.iTk = TbadkCoreApplication.getInst().getAdAdSense().eOh;
                this.iTl = TbadkCoreApplication.getInst().getAdAdSense().eOj;
                this.iTm = TbadkCoreApplication.getInst().getAdAdSense().eOi;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.iTk + (-1))) % (this.iTl + (-1)) == 0;
                boolean z5 = i2 - size == this.iTm;
                if (i2 <= this.iTm) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a2 = com.baidu.afd.c.a(3, this.iSE != null ? this.iSE.getPageNum() : 0, 0, "", "", Al(size));
                    a2.u(this.iTh);
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
            if (!this.iTf && this.iTc.size() > 0 && this.iSE != null && this.iSE.cBo() != null) {
                String str = this.iSE.cBo().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.iwG.mcnLeadPage) || (gVar.iwG.iwQ != null && gVar.iwG.iwQ.isValid())) {
                            this.iTa.l(gVar);
                        }
                        if (this.iTc.get(0) != null) {
                            this.iTc.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.iTf = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.iTc.addAll(arrayList);
        }
        if (!this.iTg) {
            n(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cBo;
        return (!"0".equals(gVar.threadId) || this.iSE == null || this.iSE.cBo() == null || (cBo = this.iSE.cBo()) == null || cBo.video == null || !TextUtils.equals(cBo.title, gVar.title) || !TextUtils.equals(cBo.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void n(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.iTa != null && !y.isEmpty(list)) {
            if (this.iTb) {
                this.iTa.setData(list, true);
                this.iTb = false;
            } else {
                this.iTa.setData(list, false);
            }
        }
        if (!z) {
            this.iwT.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fTu.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.iTj = this.iSZ.getFirstVisiblePosition();
            View childAt = this.iSZ.getChildAt(0);
            this.isx = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.iTa != null) {
            this.iTa.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cBm() != null && this.iTj != this.iSZ.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.iSZ.getLayoutManager()).scrollToPositionWithOffset(this.iTj, this.isx);
        }
    }

    private int Al(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.iTk - 1) {
            i2 = 1;
            int i4 = i3 - (this.iTk - 1);
            if (i4 >= this.iTk - 1) {
                i2 = (i4 % (this.iTl - 1)) + 1;
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
            i = cA(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cA(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.iTa.Aj(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.iTa.Ai(firstVisiblePosition);
        }
        this.iTa.Ak(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void Ag(int i) {
        if (this.iTa != null) {
            this.iTa.Ah(i - 1);
        }
    }

    public boolean yG(int i) {
        if (this.iTa == null) {
            return false;
        }
        return this.iTa.yG(i);
    }

    public int cA(View view) {
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
        return this.iSZ.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dIK().dIL();
    }

    public a cBm() {
        if (this.iTa != null) {
            return this.iTa.cBm();
        }
        return null;
    }
}
