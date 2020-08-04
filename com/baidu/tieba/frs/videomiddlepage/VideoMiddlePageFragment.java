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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private String dOV;
    private LinearLayoutManager dsC;
    private View eJG;
    private NoNetworkView fsB;
    private int hJa;
    private PbListView hMG;
    private BdTypeRecyclerView iiC;
    private RelativeLayout iiD;
    private f iiE;
    private List<com.baidu.tieba.card.data.b> iiG;
    private com.baidu.tbadk.core.view.a iiH;
    private d iiI;
    private com.baidu.tieba.v.b iiM;
    private int iiN;
    private h iih;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean iiF = true;
    private int iiy = -1;
    private boolean iiJ = false;
    private boolean iiK = false;
    int iiO = 4;
    int iiP = 7;
    int iiQ = 4;
    private CustomMessageListener iiR = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dLm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fsB != null) {
                        VideoMiddlePageFragment.this.fsB.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dpA().dpB()) {
                        if (VideoMiddlePageFragment.this.iiE == null || !VideoMiddlePageFragment.this.iiE.pT()) {
                            if (VideoMiddlePageFragment.this.iiE != null && VideoMiddlePageFragment.this.iiE.cjC()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fsB != null) {
                    VideoMiddlePageFragment.this.fsB.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.iiE != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.iiE.aE(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.iih.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.iih.bwE();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dkh().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.iiE != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.iiE.cem() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.iiE.cem()) {
                        VideoMiddlePageFragment.this.iiE.cen();
                    }
                }
            }
        }
    };
    private CustomMessageListener hHo = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.iiE != null) {
                VideoMiddlePageFragment.this.iiE.notifyDataSetChanged();
            }
        }
    };
    private HashMap iiL = new HashMap();

    public static VideoMiddlePageFragment er(String str, String str2) {
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
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        this.iih = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.iih.setId(stringExtra);
            this.iih.setLocation(stringExtra3);
            this.iih.FU(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.iiL.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.iiL.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.iih.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.dOV = arguments.getString("PARAM_FID");
        }
        if (this.iih != null) {
            this.iih.setFrom(this.mFrom);
            this.iih.cjS();
        }
        registerListener(this.dLm);
        registerListener(this.eaY);
        registerListener(this.iiR);
        registerListener(this.hHo);
        this.iiM = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dsC = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.iiC = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.iiC.addHeaderView(this.mHeaderView);
        this.iiC.setLayoutManager(this.dsC);
        this.iiC.setFadingEdgeLength(0);
        this.iiC.setBackgroundColor(ao.getColor(R.color.transparent));
        this.iiC.setOverScrollMode(2);
        this.iiC.setScrollable(this);
        this.iiD = (RelativeLayout) view.findViewById(R.id.container);
        this.fsB = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fsB.setVisibility(0);
        }
        this.hMG = new PbListView(getPageContext().getPageActivity());
        this.hMG.setIsMoreViewVisible(false);
        this.hMG.createView();
        this.hMG.setLineGone();
        this.hMG.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.hMG.setText(getResources().getString(R.string.list_has_no_more));
        this.hMG.setTextColor(R.color.cp_cont_d);
        this.hMG.setNoMoreTextColorId(R.color.cp_cont_f);
        this.iiC.setNextPage(this.hMG);
        this.hMG.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.iiC.setOnScrollListener(this.mScrollListener);
        this.iiE = new f(getPageContext(), this.iiC, this, true, this.mFrom, this.dOV, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bab()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.eJG.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.iiG = new ArrayList();
        this.iiI = new d();
        this.iiI.a(this.iih);
        com.baidu.tieba.frs.aggregation.g cjM = this.iiI.cjM();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cjM);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iiE != null) {
            this.iiE.oJ(false);
        }
        if (!this.iiF) {
            vk(2);
            if (!this.iiE.cjC() && this.iiE != null && this.iiy != -1) {
                this.iiE.wM(this.iiy);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iiE != null) {
            this.iiE.oJ(true);
            this.iiy = this.iiE.cem();
        }
        vk(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        if (this.iih != null) {
            this.iih.ceq();
        }
        if (this.iiE != null) {
            this.iiE.onDestroy();
        }
        if (this.iiI != null) {
            this.iiI.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.iiH != null) {
            this.iiH.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void afy() {
    }

    public void vk(int i) {
        if (this.iiC != null && this.iiE != null) {
            if (i == 1) {
                if (this.iiE.cjC()) {
                    this.iiE.cjP();
                } else if (this.iiE.pT()) {
                    this.iiE.pS();
                }
            }
            if (i == 2) {
                this.iiE.pS();
                if (this.iiE.cjC()) {
                    this.iiE.cjQ();
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
        if (!x.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.iiO = TbadkCoreApplication.getInst().getAdAdSense().epG;
                this.iiP = TbadkCoreApplication.getInst().getAdAdSense().epI;
                this.iiQ = TbadkCoreApplication.getInst().getAdAdSense().epH;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.iiO + (-1))) % (this.iiP + (-1)) == 0;
                boolean z5 = i2 - size == this.iiQ;
                if (i2 <= this.iiQ) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.iih != null ? this.iih.getPageNum() : 0, 0, "", "", wN(size));
                    a.w(this.iiL);
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
            if (!this.iiJ && this.iiG.size() > 0 && this.iih != null && this.iih.cjT() != null) {
                String str = this.iih.cjT().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.hMt.mcnLeadPage) || (gVar.hMt.hMD != null && gVar.hMt.hMD.isValid())) {
                            this.iiE.l(gVar);
                        }
                        if (this.iiG.get(0) != null) {
                            this.iiG.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.iiJ = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.iiG.addAll(arrayList);
        }
        if (!this.iiK) {
            m(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cjT;
        return (!"0".equals(gVar.threadId) || this.iih == null || this.iih.cjT() == null || (cjT = this.iih.cjT()) == null || cjT.video == null || !TextUtils.equals(cjT.title, gVar.title) || !TextUtils.equals(cjT.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void m(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.iiE != null && !x.isEmpty(list)) {
            if (this.iiF) {
                this.iiE.setData(list, true);
                this.iiF = false;
            } else {
                this.iiE.setData(list, false);
            }
        }
        if (!z) {
            this.hMG.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fsB.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.iiN = this.iiC.getFirstVisiblePosition();
            View childAt = this.iiC.getChildAt(0);
            this.hJa = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.iiE != null) {
            this.iiE.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cjR() != null && this.iiN != this.iiC.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.iiC.getLayoutManager()).scrollToPositionWithOffset(this.iiN, this.hJa);
        }
    }

    private int wN(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.iiO - 1) {
            i2 = 1;
            int i4 = i3 - (this.iiO - 1);
            if (i4 >= this.iiO - 1) {
                i2 = (i4 % (this.iiP - 1)) + 1;
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
            i = cl(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cl(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.iiE.wL(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.iiE.wK(firstVisiblePosition);
        }
        this.iiE.wM(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void wI(int i) {
        if (this.iiE != null) {
            this.iiE.wJ(i - 1);
        }
    }

    public boolean vj(int i) {
        if (this.iiE == null) {
            return false;
        }
        return this.iiE.vj(i);
    }

    public int cl(View view) {
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
        return this.iiC.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dpA().dpB();
    }

    public a cjR() {
        if (this.iiE != null) {
            return this.iiE.cjR();
        }
        return null;
    }
}
