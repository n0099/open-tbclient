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
    private LinearLayoutManager bIT;
    private String bZb;
    private View cOr;
    private NoNetworkView dwI;
    private PbListView fBV;
    private h fUX;
    private com.baidu.tieba.t.b fVB;
    private BdTypeRecyclerView fVr;
    private RelativeLayout fVs;
    private f fVt;
    private List<com.baidu.tieba.card.data.b> fVv;
    private com.baidu.tbadk.core.view.b fVw;
    private d fVx;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean fVu = true;
    private int fVn = -1;
    private boolean fVy = false;
    private boolean fVz = false;
    int fVC = 4;
    int fVD = 7;
    int fVE = 4;
    private CustomMessageListener fVF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener bVI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.dwI != null) {
                        VideoMiddlePageFragment.this.dwI.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.csD().csE()) {
                        if (VideoMiddlePageFragment.this.fVt == null || !VideoMiddlePageFragment.this.fVt.kk()) {
                            if (VideoMiddlePageFragment.this.fVt != null && VideoMiddlePageFragment.this.fVt.brf()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.dwI != null) {
                    VideoMiddlePageFragment.this.dwI.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.fVt != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.fVt.ah(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.fUX.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.fUX.aIW();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.cnk().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.fVt != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.fVt.bmq() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.fVt.bmq()) {
                        VideoMiddlePageFragment.this.fVt.bmr();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.fVt != null) {
                VideoMiddlePageFragment.this.fVt.notifyDataSetChanged();
            }
        }
    };
    private HashMap fVA = new HashMap();

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
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
        this.fUX = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.fUX.setId(stringExtra);
            this.fUX.setLocation(stringExtra3);
            this.fUX.vT(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.fVA.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.fVA.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.fUX.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.bZb = arguments.getString("PARAM_FID");
        }
        if (this.fUX != null) {
            this.fUX.setFrom(this.mFrom);
            this.fUX.brt();
        }
        registerListener(this.bVI);
        registerListener(this.cjZ);
        registerListener(this.fVF);
        registerListener(this.fwS);
        this.fVB = new com.baidu.tieba.t.b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.bIT = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.fVr = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.fVr.addHeaderView(this.mHeaderView);
        this.fVr.setLayoutManager(this.bIT);
        this.fVr.setFadingEdgeLength(0);
        this.fVr.setBackgroundColor(am.getColor(R.color.transparent));
        this.fVr.setOverScrollMode(2);
        this.fVr.setScrollable(this);
        this.fVs = (RelativeLayout) view.findViewById(R.id.container);
        this.dwI = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.dwI.setVisibility(0);
        }
        this.fBV = new PbListView(getPageContext().getPageActivity());
        this.fBV.setIsMoreViewVisible(false);
        this.fBV.createView();
        this.fBV.setLineGone();
        this.fBV.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.fBV.setText(getResources().getString(R.string.list_has_no_more));
        this.fBV.setTextColor(R.color.cp_cont_d);
        this.fBV.setNoMoreTextColorId(R.color.cp_cont_f);
        this.fVr.setNextPage(this.fBV);
        this.fBV.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.fVr.setOnScrollListener(this.mScrollListener);
        this.fVt = new f(getPageContext(), this.fVr, this, true, this.mFrom, this.bZb, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.cOr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.cOr.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.fVv = new ArrayList();
        this.fVx = new d();
        this.fVx.a(this.fUX);
        com.baidu.tieba.frs.aggregation.g brp = this.fVx.brp();
        ArrayList arrayList = new ArrayList();
        arrayList.add(brp);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fVt != null) {
            this.fVt.kM(false);
        }
        if (!this.fVu) {
            qQ(2);
            if (!this.fVt.brf() && this.fVt != null && this.fVn != -1) {
                this.fVt.sk(this.fVn);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fVt != null) {
            this.fVt.kM(true);
            this.fVn = this.fVt.bmq();
        }
        qQ(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cnk().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        if (this.fUX != null) {
            this.fUX.bmv();
        }
        if (this.fVt != null) {
            this.fVt.onDestroy();
        }
        if (this.fVx != null) {
            this.fVx.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.fVw != null) {
            this.fVw.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void avg() {
    }

    public void qQ(int i) {
        if (this.fVr != null && this.fVt != null) {
            if (i == 1) {
                if (this.fVt.brf()) {
                    this.fVt.brr();
                } else if (this.fVt.kk()) {
                    this.fVt.kj();
                }
            }
            if (i == 2) {
                this.fVt.kj();
                if (this.fVt.brf()) {
                    this.fVt.brs();
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
                this.fVC = TbadkCoreApplication.getInst().getAdAdSense().cuH;
                this.fVD = TbadkCoreApplication.getInst().getAdAdSense().cuJ;
                this.fVE = TbadkCoreApplication.getInst().getAdAdSense().cuI;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.fVC + (-1))) % (this.fVD + (-1)) == 0;
                boolean z5 = i2 - size == this.fVE;
                if (i2 <= this.fVE) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.fUX != null ? this.fUX.getPageNum() : 0, 0, "", "", sl(size));
                    a.k(this.fVA);
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
            if (!this.fVy && this.fVv.size() > 0 && this.fUX != null && this.fUX.bru() != null) {
                String str = this.fUX.bru().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.fBI.mcnLeadPage) || (gVar.fBI.fBS != null && gVar.fBI.fBS.isValid())) {
                            this.fVt.j(gVar);
                        }
                        if (this.fVv.get(0) != null) {
                            this.fVv.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.fVy = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.fVv.addAll(arrayList);
        }
        if (!this.fVz) {
            l(arrayList, z);
        }
    }

    private void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.fVt != null && !v.isEmpty(list)) {
            if (this.fVu) {
                this.fVt.setData(list, true);
                this.fVu = false;
            } else {
                this.fVt.setData(list, false);
            }
        }
        if (!z) {
            this.fBV.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dwI.onChangeSkinType(getPageContext(), i);
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
        if (this.fVt != null) {
            this.fVt.onConfigurationChanged(configuration);
        }
    }

    private int sl(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.fVC - 1) {
            i2 = 1;
            int i4 = i3 - (this.fVC - 1);
            if (i4 >= this.fVC - 1) {
                i2 = (i4 % (this.fVD - 1)) + 1;
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
        if (!this.fVt.sj(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.fVt.si(firstVisiblePosition);
        }
        this.fVt.sk(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void sg(int i) {
        if (this.fVt != null) {
            this.fVt.sh(i - 1);
        }
    }

    public boolean qP(int i) {
        if (this.fVt == null) {
            return false;
        }
        return this.fVt.qP(i);
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
        return this.fVr.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.csD().csE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.mb("cyber_player_test");
    }
}
