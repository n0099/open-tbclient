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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private String dIK;
    private LinearLayoutManager dmG;
    private View eDr;
    private NoNetworkView fns;
    private PbListView hGJ;
    private f icA;
    private List<com.baidu.tieba.card.data.b> icC;
    private com.baidu.tbadk.core.view.a icD;
    private d icE;
    private com.baidu.tieba.v.b icI;
    private int icJ;
    private h icd;
    private BdTypeRecyclerView icy;
    private RelativeLayout icz;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean icB = true;
    private int icu = -1;
    private boolean icF = false;
    private boolean icG = false;
    int icK = 4;
    int icL = 7;
    int icM = 4;
    private CustomMessageListener icN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fns != null) {
                        VideoMiddlePageFragment.this.fns.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.h.dmo().dmp()) {
                        if (VideoMiddlePageFragment.this.icA == null || !VideoMiddlePageFragment.this.icA.pS()) {
                            if (VideoMiddlePageFragment.this.icA != null && VideoMiddlePageFragment.this.icA.cgd()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fns != null) {
                    VideoMiddlePageFragment.this.fns.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.icA != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.icA.aG(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.icd.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.icd.btv();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dgY().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.icA != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.icA.caO() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.icA.caO()) {
                        VideoMiddlePageFragment.this.icA.caP();
                    }
                }
            }
        }
    };
    private CustomMessageListener hBt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.icA != null) {
                VideoMiddlePageFragment.this.icA.notifyDataSetChanged();
            }
        }
    };
    private HashMap icH = new HashMap();

    public static VideoMiddlePageFragment ep(String str, String str2) {
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
        com.baidu.tieba.s.c.dgY().z(getUniqueId());
        this.icd = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.icd.setId(stringExtra);
            this.icd.setLocation(stringExtra3);
            this.icd.Fj(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.icH.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.icH.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.icd.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.dIK = arguments.getString("PARAM_FID");
        }
        if (this.icd != null) {
            this.icd.setFrom(this.mFrom);
            this.icd.cgt();
        }
        registerListener(this.dFp);
        registerListener(this.dUF);
        registerListener(this.icN);
        registerListener(this.hBt);
        this.icI = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dmG = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.icy = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.icy.addHeaderView(this.mHeaderView);
        this.icy.setLayoutManager(this.dmG);
        this.icy.setFadingEdgeLength(0);
        this.icy.setBackgroundColor(an.getColor(R.color.transparent));
        this.icy.setOverScrollMode(2);
        this.icy.setScrollable(this);
        this.icz = (RelativeLayout) view.findViewById(R.id.container);
        this.fns = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fns.setVisibility(0);
        }
        this.hGJ = new PbListView(getPageContext().getPageActivity());
        this.hGJ.setIsMoreViewVisible(false);
        this.hGJ.createView();
        this.hGJ.setLineGone();
        this.hGJ.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.hGJ.setText(getResources().getString(R.string.list_has_no_more));
        this.hGJ.setTextColor(R.color.cp_cont_d);
        this.hGJ.setNoMoreTextColorId(R.color.cp_cont_f);
        this.icy.setNextPage(this.hGJ);
        this.hGJ.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.icy.setOnScrollListener(this.mScrollListener);
        this.icA = new f(getPageContext(), this.icy, this, true, this.mFrom, this.dIK, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.aWb()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.eDr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.eDr.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.icC = new ArrayList();
        this.icE = new d();
        this.icE.a(this.icd);
        com.baidu.tieba.frs.aggregation.g cgn = this.icE.cgn();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cgn);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.icA != null) {
            this.icA.oe(false);
        }
        if (!this.icB) {
            uS(2);
            if (!this.icA.cgd() && this.icA != null && this.icu != -1) {
                this.icA.wu(this.icu);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.icA != null) {
            this.icA.oe(true);
            this.icu = this.icA.caO();
        }
        uS(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dgY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dgY().A(getUniqueId());
        if (this.icd != null) {
            this.icd.caS();
        }
        if (this.icA != null) {
            this.icA.onDestroy();
        }
        if (this.icE != null) {
            this.icE.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.icD != null) {
            this.icD.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void aeh() {
    }

    public void uS(int i) {
        if (this.icy != null && this.icA != null) {
            if (i == 1) {
                if (this.icA.cgd()) {
                    this.icA.cgq();
                } else if (this.icA.pS()) {
                    this.icA.pR();
                }
            }
            if (i == 2) {
                this.icA.pR();
                if (this.icA.cgd()) {
                    this.icA.cgr();
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
        if (!w.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.icK = TbadkCoreApplication.getInst().getAdAdSense().eju;
                this.icL = TbadkCoreApplication.getInst().getAdAdSense().ejw;
                this.icM = TbadkCoreApplication.getInst().getAdAdSense().ejv;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.icK + (-1))) % (this.icL + (-1)) == 0;
                boolean z5 = i2 - size == this.icM;
                if (i2 <= this.icM) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.icd != null ? this.icd.getPageNum() : 0, 0, "", "", wv(size));
                    a.w(this.icH);
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
            if (!this.icF && this.icC.size() > 0 && this.icd != null && this.icd.cgu() != null) {
                String str = this.icd.cgu().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.hGv.mcnLeadPage) || (gVar.hGv.hGG != null && gVar.hGv.hGG.isValid())) {
                            this.icA.l(gVar);
                        }
                        if (this.icC.get(0) != null) {
                            this.icC.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.icF = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.icC.addAll(arrayList);
        }
        if (!this.icG) {
            o(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cgu;
        return (!"0".equals(gVar.threadId) || this.icd == null || this.icd.cgu() == null || (cgu = this.icd.cgu()) == null || cgu.video == null || !TextUtils.equals(cgu.title, gVar.title) || !TextUtils.equals(cgu.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.icA != null && !w.isEmpty(list)) {
            if (this.icB) {
                this.icA.setData(list, true);
                this.icB = false;
            } else {
                this.icA.setData(list, false);
            }
        }
        if (!z) {
            this.hGJ.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fns.onChangeSkinType(getPageContext(), i);
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
            if (cgs() != null) {
                this.icJ = cgs().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.icA != null) {
            this.icA.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cgs() != null && (top2 = cgs().getView().getTop()) != this.icJ) {
            this.icy.scrollBy(0, top2 - this.icJ);
            this.icJ = top2;
        }
    }

    private int wv(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.icK - 1) {
            i2 = 1;
            int i4 = i3 - (this.icK - 1);
            if (i4 >= this.icK - 1) {
                i2 = (i4 % (this.icL - 1)) + 1;
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
            i = cf(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cf(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.icA.wt(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.icA.ws(firstVisiblePosition);
        }
        this.icA.wu(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void wq(int i) {
        if (this.icA != null) {
            this.icA.wr(i - 1);
        }
    }

    public boolean uR(int i) {
        if (this.icA == null) {
            return false;
        }
        return this.icA.uR(i);
    }

    public int cf(View view) {
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
        return this.icy.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.h.dmo().dmp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test");
    }

    public a cgs() {
        if (this.icA != null) {
            return this.icA.cgs();
        }
        return null;
    }
}
