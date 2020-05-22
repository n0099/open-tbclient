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
import com.baidu.adp.widget.ListView.r;
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
    private String dCp;
    private LinearLayoutManager dhU;
    private View eun;
    private NoNetworkView fbX;
    private RelativeLayout hOA;
    private f hOB;
    private List<com.baidu.tieba.card.data.b> hOD;
    private com.baidu.tbadk.core.view.a hOE;
    private d hOF;
    private com.baidu.tieba.v.b hOJ;
    private int hOK;
    private h hOe;
    private BdTypeRecyclerView hOz;
    private PbListView htI;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean hOC = true;
    private int hOv = -1;
    private boolean hOG = false;
    private boolean hOH = false;
    int hOL = 4;
    int hOM = 7;
    int hON = 4;
    private CustomMessageListener hOO = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fbX != null) {
                        VideoMiddlePageFragment.this.fbX.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dhK().dhL()) {
                        if (VideoMiddlePageFragment.this.hOB == null || !VideoMiddlePageFragment.this.hOB.pB()) {
                            if (VideoMiddlePageFragment.this.hOB != null && VideoMiddlePageFragment.this.hOB.ccB()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fbX != null) {
                    VideoMiddlePageFragment.this.fbX.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.hOB != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.hOB.aE(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.hOe.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.hOe.bqv();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dct().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.hOB != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.hOB.bXA() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.hOB.bXA()) {
                        VideoMiddlePageFragment.this.hOB.bXB();
                    }
                }
            }
        }
    };
    private CustomMessageListener hoI = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.hOB != null) {
                VideoMiddlePageFragment.this.hOB.notifyDataSetChanged();
            }
        }
    };
    private HashMap hOI = new HashMap();

    public static VideoMiddlePageFragment ej(String str, String str2) {
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
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        this.hOe = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.hOe.setId(stringExtra);
            this.hOe.setLocation(stringExtra3);
            this.hOe.EI(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.hOI.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.hOI.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.hOe.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.dCp = arguments.getString("PARAM_FID");
        }
        if (this.hOe != null) {
            this.hOe.setFrom(this.mFrom);
            this.hOe.ccR();
        }
        registerListener(this.dyW);
        registerListener(this.dNP);
        registerListener(this.hOO);
        registerListener(this.hoI);
        this.hOJ = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dhU = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.hOz = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.hOz.addHeaderView(this.mHeaderView);
        this.hOz.setLayoutManager(this.dhU);
        this.hOz.setFadingEdgeLength(0);
        this.hOz.setBackgroundColor(am.getColor(R.color.transparent));
        this.hOz.setOverScrollMode(2);
        this.hOz.setScrollable(this);
        this.hOA = (RelativeLayout) view.findViewById(R.id.container);
        this.fbX = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fbX.setVisibility(0);
        }
        this.htI = new PbListView(getPageContext().getPageActivity());
        this.htI.setIsMoreViewVisible(false);
        this.htI.createView();
        this.htI.setLineGone();
        this.htI.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.htI.setText(getResources().getString(R.string.list_has_no_more));
        this.htI.setTextColor(R.color.cp_cont_d);
        this.htI.setNoMoreTextColorId(R.color.cp_cont_f);
        this.hOz.setNextPage(this.htI);
        this.htI.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.hOz.setOnScrollListener(this.mScrollListener);
        this.hOB = new f(getPageContext(), this.hOz, this, true, this.mFrom, this.dCp, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.eun.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.hOD = new ArrayList();
        this.hOF = new d();
        this.hOF.a(this.hOe);
        com.baidu.tieba.frs.aggregation.g ccL = this.hOF.ccL();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ccL);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hOB != null) {
            this.hOB.nS(false);
        }
        if (!this.hOC) {
            ul(2);
            if (!this.hOB.ccB() && this.hOB != null && this.hOv != -1) {
                this.hOB.vN(this.hOv);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hOB != null) {
            this.hOB.nS(true);
            this.hOv = this.hOB.bXA();
        }
        ul(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        if (this.hOe != null) {
            this.hOe.bXE();
        }
        if (this.hOB != null) {
            this.hOB.onDestroy();
        }
        if (this.hOF != null) {
            this.hOF.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.hOE != null) {
            this.hOE.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void adb() {
    }

    public void ul(int i) {
        if (this.hOz != null && this.hOB != null) {
            if (i == 1) {
                if (this.hOB.ccB()) {
                    this.hOB.ccO();
                } else if (this.hOB.pB()) {
                    this.hOB.pA();
                }
            }
            if (i == 2) {
                this.hOB.pA();
                if (this.hOB.ccB()) {
                    this.hOB.ccP();
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
                this.hOL = TbadkCoreApplication.getInst().getAdAdSense().eaK;
                this.hOM = TbadkCoreApplication.getInst().getAdAdSense().eaM;
                this.hON = TbadkCoreApplication.getInst().getAdAdSense().eaL;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.hOL + (-1))) % (this.hOM + (-1)) == 0;
                boolean z5 = i2 - size == this.hON;
                if (i2 <= this.hON) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.hOe != null ? this.hOe.getPageNum() : 0, 0, "", "", vO(size));
                    a.w(this.hOI);
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
            if (!this.hOG && this.hOD.size() > 0 && this.hOe != null && this.hOe.ccS() != null) {
                String str = this.hOe.ccS().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.htu.mcnLeadPage) || (gVar.htu.htF != null && gVar.htu.htF.isValid())) {
                            this.hOB.l(gVar);
                        }
                        if (this.hOD.get(0) != null) {
                            this.hOD.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.hOG = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.hOD.addAll(arrayList);
        }
        if (!this.hOH) {
            o(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo ccS;
        return (!"0".equals(gVar.threadId) || this.hOe == null || this.hOe.ccS() == null || (ccS = this.hOe.ccS()) == null || ccS.video == null || !TextUtils.equals(ccS.title, gVar.title) || !TextUtils.equals(ccS.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.hOB != null && !v.isEmpty(list)) {
            if (this.hOC) {
                this.hOB.setData(list, true);
                this.hOC = false;
            } else {
                this.hOB.setData(list, false);
            }
        }
        if (!z) {
            this.htI.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fbX.onChangeSkinType(getPageContext(), i);
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
            if (ccQ() != null) {
                this.hOK = ccQ().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.hOB != null) {
            this.hOB.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && ccQ() != null && (top2 = ccQ().getView().getTop()) != this.hOK) {
            this.hOz.scrollBy(0, top2 - this.hOK);
            this.hOK = top2;
        }
    }

    private int vO(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.hOL - 1) {
            i2 = 1;
            int i4 = i3 - (this.hOL - 1);
            if (i4 >= this.hOL - 1) {
                i2 = (i4 % (this.hOM - 1)) + 1;
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
            i = ce(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = ce(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.hOB.vM(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.hOB.vL(firstVisiblePosition);
        }
        this.hOB.vN(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void vJ(int i) {
        if (this.hOB != null) {
            this.hOB.vK(i - 1);
        }
    }

    public boolean uk(int i) {
        if (this.hOB == null) {
            return false;
        }
        return this.hOB.uk(i);
    }

    public int ce(View view) {
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
    public r onGetPreLoadListView() {
        return this.hOz.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dhK().dhL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
    }

    public a ccQ() {
        if (this.hOB != null) {
            return this.hOB.ccQ();
        }
        return null;
    }
}
