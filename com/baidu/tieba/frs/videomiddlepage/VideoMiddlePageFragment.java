package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.baidu.adp.widget.ListView.p;
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
/* loaded from: classes4.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private LinearLayoutManager bIc;
    private String bYk;
    private View cNA;
    private NoNetworkView dvR;
    private PbListView fBe;
    private BdTypeRecyclerView fUA;
    private RelativeLayout fUB;
    private f fUC;
    private List<com.baidu.tieba.card.data.b> fUE;
    private com.baidu.tbadk.core.view.b fUF;
    private d fUG;
    private com.baidu.tieba.t.b fUK;
    private h fUg;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean fUD = true;
    private int fUw = -1;
    private boolean fUH = false;
    private boolean fUI = false;
    int fUL = 4;
    int fUM = 7;
    int fUN = 4;
    private CustomMessageListener fUO = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener bUR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.dvR != null) {
                        VideoMiddlePageFragment.this.dvR.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.csB().csC()) {
                        if (VideoMiddlePageFragment.this.fUC == null || !VideoMiddlePageFragment.this.fUC.kk()) {
                            if (VideoMiddlePageFragment.this.fUC != null && VideoMiddlePageFragment.this.fUC.brd()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.dvR != null) {
                    VideoMiddlePageFragment.this.dvR.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.fUC != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.fUC.ah(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.fUg.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.fUg.aIU();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.cni().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.fUC != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.fUC.bmo() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.fUC.bmo()) {
                        VideoMiddlePageFragment.this.fUC.bmp();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwb = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.fUC != null) {
                VideoMiddlePageFragment.this.fUC.notifyDataSetChanged();
            }
        }
    };
    private HashMap fUJ = new HashMap();

    public static VideoMiddlePageFragment cR(String str, String str2) {
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
        com.baidu.tieba.q.c.cni().v(getUniqueId());
        this.fUg = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.fUg.setId(stringExtra);
            this.fUg.setLocation(stringExtra3);
            this.fUg.vT(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.fUJ.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.fUJ.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.fUg.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.bYk = arguments.getString("PARAM_FID");
        }
        if (this.fUg != null) {
            this.fUg.setFrom(this.mFrom);
            this.fUg.brr();
        }
        registerListener(this.bUR);
        registerListener(this.cji);
        registerListener(this.fUO);
        registerListener(this.fwb);
        this.fUK = new com.baidu.tieba.t.b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.bIc = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.fUA = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.fUA.addHeaderView(this.mHeaderView);
        this.fUA.setLayoutManager(this.bIc);
        this.fUA.setFadingEdgeLength(0);
        this.fUA.setBackgroundColor(am.getColor(R.color.transparent));
        this.fUA.setOverScrollMode(2);
        this.fUA.setScrollable(this);
        this.fUB = (RelativeLayout) view.findViewById(R.id.container);
        this.dvR = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.dvR.setVisibility(0);
        }
        this.fBe = new PbListView(getPageContext().getPageActivity());
        this.fBe.setIsMoreViewVisible(false);
        this.fBe.createView();
        this.fBe.setLineGone();
        this.fBe.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.fBe.setText(getResources().getString(R.string.list_has_no_more));
        this.fBe.setTextColor(R.color.cp_cont_d);
        this.fBe.setNoMoreTextColorId(R.color.cp_cont_f);
        this.fUA.setNextPage(this.fBe);
        this.fBe.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.fUA.setOnScrollListener(this.mScrollListener);
        this.fUC = new f(getPageContext(), this.fUA, this, true, this.mFrom, this.bYk, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.cNA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.cNA.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.fUE = new ArrayList();
        this.fUG = new d();
        this.fUG.a(this.fUg);
        com.baidu.tieba.frs.aggregation.g brn = this.fUG.brn();
        ArrayList arrayList = new ArrayList();
        arrayList.add(brn);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fUC != null) {
            this.fUC.kM(false);
        }
        if (!this.fUD) {
            qP(2);
            if (!this.fUC.brd() && this.fUC != null && this.fUw != -1) {
                this.fUC.sj(this.fUw);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fUC != null) {
            this.fUC.kM(true);
            this.fUw = this.fUC.bmo();
        }
        qP(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cni().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        if (this.fUg != null) {
            this.fUg.bmt();
        }
        if (this.fUC != null) {
            this.fUC.onDestroy();
        }
        if (this.fUG != null) {
            this.fUG.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.fUF != null) {
            this.fUF.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void ave() {
    }

    public void qP(int i) {
        if (this.fUA != null && this.fUC != null) {
            if (i == 1) {
                if (this.fUC.brd()) {
                    this.fUC.brp();
                } else if (this.fUC.kk()) {
                    this.fUC.kj();
                }
            }
            if (i == 2) {
                this.fUC.kj();
                if (this.fUC.brd()) {
                    this.fUC.brq();
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
                this.fUL = TbadkCoreApplication.getInst().getAdAdSense().ctP;
                this.fUM = TbadkCoreApplication.getInst().getAdAdSense().ctR;
                this.fUN = TbadkCoreApplication.getInst().getAdAdSense().ctQ;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.fUL + (-1))) % (this.fUM + (-1)) == 0;
                boolean z5 = i2 - size == this.fUN;
                if (i2 <= this.fUN) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.fUg != null ? this.fUg.getPageNum() : 0, 0, "", "", sk(size));
                    a.k(this.fUJ);
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
            if (!this.fUH && this.fUE.size() > 0 && this.fUg != null && this.fUg.brs() != null) {
                String str = this.fUg.brs().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.fAR.mcnLeadPage) || (gVar.fAR.fBb != null && gVar.fAR.fBb.isValid())) {
                            this.fUC.j(gVar);
                        }
                        if (this.fUE.get(0) != null) {
                            this.fUE.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.fUH = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.fUE.addAll(arrayList);
        }
        if (!this.fUI) {
            l(arrayList, z);
        }
    }

    private void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.fUC != null && !v.isEmpty(list)) {
            if (this.fUD) {
                this.fUC.setData(list, true);
                this.fUD = false;
            } else {
                this.fUC.setData(list, false);
            }
        }
        if (!z) {
            this.fBe.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dvR.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
        } else {
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.fUC != null) {
            this.fUC.onConfigurationChanged(configuration);
        }
    }

    private int sk(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.fUL - 1) {
            i2 = 1;
            int i4 = i3 - (this.fUL - 1);
            if (i4 >= this.fUL - 1) {
                i2 = (i4 % (this.fUM - 1)) + 1;
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
            i = bW(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = bW(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.fUC.si(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.fUC.sh(firstVisiblePosition);
        }
        this.fUC.sj(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void sf(int i) {
        if (this.fUC != null) {
            this.fUC.sg(i - 1);
        }
    }

    public boolean qO(int i) {
        if (this.fUC == null) {
            return false;
        }
        return this.fUC.qO(i);
    }

    public int bW(View view) {
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
    public p onGetPreLoadListView() {
        return this.fUA.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.csB().csC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.mb("cyber_player_test");
    }
}
