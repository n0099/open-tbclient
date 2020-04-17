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
/* loaded from: classes9.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private LinearLayoutManager cWO;
    private String dol;
    private NoNetworkView ePl;
    private View efU;
    private PbListView heO;
    private BdTypeRecyclerView hzG;
    private RelativeLayout hzH;
    private f hzI;
    private List<com.baidu.tieba.card.data.b> hzK;
    private com.baidu.tbadk.core.view.a hzL;
    private d hzM;
    private com.baidu.tieba.v.b hzQ;
    private int hzR;
    private h hzl;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean hzJ = true;
    private int hzC = -1;
    private boolean hzN = false;
    private boolean hzO = false;
    int hzS = 4;
    int hzT = 7;
    int hzU = 4;
    private CustomMessageListener hzV = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dkS = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.ePl != null) {
                        VideoMiddlePageFragment.this.ePl.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.day().daz()) {
                        if (VideoMiddlePageFragment.this.hzI == null || !VideoMiddlePageFragment.this.hzI.pv()) {
                            if (VideoMiddlePageFragment.this.hzI != null && VideoMiddlePageFragment.this.hzI.bWe()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.ePl != null) {
                    VideoMiddlePageFragment.this.ePl.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.hzI != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.hzI.ar(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.hzl.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.hzl.blb();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.cVr().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.hzI != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.hzI.bRf() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.hzI.bRf()) {
                        VideoMiddlePageFragment.this.hzI.bRg();
                    }
                }
            }
        }
    };
    private CustomMessageListener gZO = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.hzI != null) {
                VideoMiddlePageFragment.this.hzI.notifyDataSetChanged();
            }
        }
    };
    private HashMap hzP = new HashMap();

    public static VideoMiddlePageFragment dI(String str, String str2) {
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
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        this.hzl = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.hzl.setId(stringExtra);
            this.hzl.setLocation(stringExtra3);
            this.hzl.CW(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.hzP.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.hzP.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.hzl.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.dol = arguments.getString("PARAM_FID");
        }
        if (this.hzl != null) {
            this.hzl.setFrom(this.mFrom);
            this.hzl.bWu();
        }
        registerListener(this.dkS);
        registerListener(this.dzH);
        registerListener(this.hzV);
        registerListener(this.gZO);
        this.hzQ = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cWO = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.hzG = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.hzG.addHeaderView(this.mHeaderView);
        this.hzG.setLayoutManager(this.cWO);
        this.hzG.setFadingEdgeLength(0);
        this.hzG.setBackgroundColor(am.getColor(R.color.transparent));
        this.hzG.setOverScrollMode(2);
        this.hzG.setScrollable(this);
        this.hzH = (RelativeLayout) view.findViewById(R.id.container);
        this.ePl = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.ePl.setVisibility(0);
        }
        this.heO = new PbListView(getPageContext().getPageActivity());
        this.heO.setIsMoreViewVisible(false);
        this.heO.createView();
        this.heO.setLineGone();
        this.heO.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.heO.setText(getResources().getString(R.string.list_has_no_more));
        this.heO.setTextColor(R.color.cp_cont_d);
        this.heO.setNoMoreTextColorId(R.color.cp_cont_f);
        this.hzG.setNextPage(this.heO);
        this.heO.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.hzG.setOnScrollListener(this.mScrollListener);
        this.hzI = new f(getPageContext(), this.hzG, this, true, this.mFrom, this.dol, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.efU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.efU.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.hzK = new ArrayList();
        this.hzM = new d();
        this.hzM.a(this.hzl);
        com.baidu.tieba.frs.aggregation.g bWo = this.hzM.bWo();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bWo);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hzI != null) {
            this.hzI.nx(false);
        }
        if (!this.hzJ) {
            tG(2);
            if (!this.hzI.bWe() && this.hzI != null && this.hzC != -1) {
                this.hzI.vh(this.hzC);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hzI != null) {
            this.hzI.nx(true);
            this.hzC = this.hzI.bRf();
        }
        tG(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        if (this.hzl != null) {
            this.hzl.bRj();
        }
        if (this.hzI != null) {
            this.hzI.onDestroy();
        }
        if (this.hzM != null) {
            this.hzM.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.hzL != null) {
            this.hzL.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void aac() {
    }

    public void tG(int i) {
        if (this.hzG != null && this.hzI != null) {
            if (i == 1) {
                if (this.hzI.bWe()) {
                    this.hzI.bWr();
                } else if (this.hzI.pv()) {
                    this.hzI.pu();
                }
            }
            if (i == 2) {
                this.hzI.pu();
                if (this.hzI.bWe()) {
                    this.hzI.bWs();
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
                this.hzS = TbadkCoreApplication.getInst().getAdAdSense().dMp;
                this.hzT = TbadkCoreApplication.getInst().getAdAdSense().dMr;
                this.hzU = TbadkCoreApplication.getInst().getAdAdSense().dMq;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.hzS + (-1))) % (this.hzT + (-1)) == 0;
                boolean z5 = i2 - size == this.hzU;
                if (i2 <= this.hzU) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.hzl != null ? this.hzl.getPageNum() : 0, 0, "", "", vi(size));
                    a.w(this.hzP);
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
            if (!this.hzN && this.hzK.size() > 0 && this.hzl != null && this.hzl.bWv() != null) {
                String str = this.hzl.bWv().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.heA.mcnLeadPage) || (gVar.heA.heL != null && gVar.heA.heL.isValid())) {
                            this.hzI.l(gVar);
                        }
                        if (this.hzK.get(0) != null) {
                            this.hzK.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.hzN = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.hzK.addAll(arrayList);
        }
        if (!this.hzO) {
            o(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo bWv;
        return (!"0".equals(gVar.threadId) || this.hzl == null || this.hzl.bWv() == null || (bWv = this.hzl.bWv()) == null || bWv.video == null || !TextUtils.equals(bWv.title, gVar.title) || !TextUtils.equals(bWv.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.hzI != null && !v.isEmpty(list)) {
            if (this.hzJ) {
                this.hzI.setData(list, true);
                this.hzJ = false;
            } else {
                this.hzI.setData(list, false);
            }
        }
        if (!z) {
            this.heO.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ePl.onChangeSkinType(getPageContext(), i);
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
            if (bWt() != null) {
                this.hzR = bWt().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.hzI != null) {
            this.hzI.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && bWt() != null && (top2 = bWt().getView().getTop()) != this.hzR) {
            this.hzG.scrollBy(0, top2 - this.hzR);
            this.hzR = top2;
        }
    }

    private int vi(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.hzS - 1) {
            i2 = 1;
            int i4 = i3 - (this.hzS - 1);
            if (i4 >= this.hzS - 1) {
                i2 = (i4 % (this.hzT - 1)) + 1;
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
        if (!this.hzI.vg(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.hzI.vf(firstVisiblePosition);
        }
        this.hzI.vh(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void vd(int i) {
        if (this.hzI != null) {
            this.hzI.ve(i - 1);
        }
    }

    public boolean tF(int i) {
        if (this.hzI == null) {
            return false;
        }
        return this.hzI.tF(i);
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
    public p onGetPreLoadListView() {
        return this.hzG.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.day().daz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.sV("cyber_player_test") || com.baidu.tbadk.a.b.sU("cyber_player_test");
    }

    public a bWt() {
        if (this.hzI != null) {
            return this.hzI.bWt();
        }
        return null;
    }
}
