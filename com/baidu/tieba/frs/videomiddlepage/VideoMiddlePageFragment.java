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
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private RelativeLayout dZU;
    private String eQd;
    private LinearLayoutManager etu;
    private View fOs;
    private NoNetworkView gCe;
    private boolean isFullScreen;
    private h jLM;
    private BdTypeRecyclerView jMh;
    private f jMi;
    private List<BaseCardInfo> jMk;
    private com.baidu.tbadk.core.view.a jMl;
    private d jMm;
    private com.baidu.tieba.v.b jMq;
    private int jMr;
    private int jiL;
    private PbListView jnf;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jMj = true;
    private int jMd = -1;
    private boolean jMn = false;
    private boolean jMo = false;
    int jMs = 4;
    int jMt = 7;
    int jMu = 4;
    private CustomMessageListener jMv = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dTE().dTF()) {
                        if (VideoMiddlePageFragment.this.jMi == null || !VideoMiddlePageFragment.this.jMi.rb()) {
                            if (VideoMiddlePageFragment.this.jMi != null && VideoMiddlePageFragment.this.jMi.cOE()) {
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
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jMi != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jMi.aP(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jLM.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jLM.bUq();
                    }
                    VideoMiddlePageFragment.this.h(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dNY().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jMi != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jMi.cHY() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jMi.cHY()) {
                        VideoMiddlePageFragment.this.jMi.cHZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener jgY = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jMi != null) {
                VideoMiddlePageFragment.this.jMi.notifyDataSetChanged();
            }
        }
    };
    private HashMap jMp = new HashMap();

    public static VideoMiddlePageFragment fo(String str, String str2) {
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
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
        this.jLM = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jLM.setId(stringExtra);
            this.jLM.setLocation(stringExtra3);
            this.jLM.KN(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.jMp.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jMp.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jLM.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eQd = arguments.getString("PARAM_FID");
        }
        if (this.jLM != null) {
            this.jLM.setFrom(this.mFrom);
            this.jLM.cOU();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.fdd);
        registerListener(this.jMv);
        registerListener(this.jgY);
        this.jMq = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.etu = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jMh = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jMh.addHeaderView(this.mHeaderView);
        this.jMh.setLayoutManager(this.etu);
        this.jMh.setFadingEdgeLength(0);
        this.jMh.setBackgroundColor(ao.getColor(R.color.transparent));
        this.jMh.setOverScrollMode(2);
        this.jMh.setScrollable(this);
        this.dZU = (RelativeLayout) view.findViewById(R.id.container);
        this.gCe = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.gCe.setVisibility(0);
        }
        this.jnf = new PbListView(getPageContext().getPageActivity());
        this.jnf.setIsMoreViewVisible(false);
        this.jnf.createView();
        this.jnf.setLineGone();
        this.jnf.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.jnf.setText(getResources().getString(R.string.list_has_no_more));
        this.jnf.setTextColor(R.color.CAM_X0109);
        this.jnf.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jMh.setNextPage(this.jnf);
        this.jnf.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jMh.setOnScrollListener(this.mScrollListener);
        this.jMi = new f(getPageContext(), this.jMh, this, true, this.mFrom, this.eQd, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bvD()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fOs.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jMk = new ArrayList();
        this.jMm = new d();
        this.jMm.a(this.jLM);
        com.baidu.tieba.frs.aggregation.g cOO = this.jMm.cOO();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cOO);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jMi != null) {
            this.jMi.rE(false);
        }
        if (!this.jMj) {
            AC(2);
            if (!this.jMi.cOE() && this.jMi != null && this.jMd != -1) {
                this.jMi.Cp(this.jMd);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jMi != null) {
            this.jMi.rE(true);
            this.jMd = this.jMi.cHY();
        }
        AC(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        if (this.jLM != null) {
            this.jLM.cIc();
        }
        if (this.jMi != null) {
            this.jMi.onDestroy();
        }
        if (this.jMm != null) {
            this.jMm.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jMl != null) {
            this.jMl.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void onLoadFail() {
    }

    public void AC(int i) {
        if (this.jMh != null && this.jMi != null) {
            if (i == 1) {
                if (this.jMi.cOE()) {
                    this.jMi.cOR();
                } else if (this.jMi.rb()) {
                    this.jMi.ra();
                }
            }
            if (i == 2) {
                this.jMi.ra();
                if (this.jMi.cOE()) {
                    this.jMi.cOS();
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
        if (!x.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.jMs = TbadkCoreApplication.getInst().getAdAdSense().fsJ;
                this.jMt = TbadkCoreApplication.getInst().getAdAdSense().fsL;
                this.jMu = TbadkCoreApplication.getInst().getAdAdSense().fsK;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jMs + (-1))) % (this.jMt + (-1)) == 0;
                boolean z5 = i - size == this.jMu;
                if (i <= this.jMu) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jLM != null ? this.jLM.getPageNum() : 0, 0, "", "", Cq(size));
                    a2.u(this.jMp);
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
            if (!this.jMn && this.jMk.size() > 0 && this.jLM != null && this.jLM.cOV() != null) {
                String str = this.jLM.cOV().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.jmS.mcnLeadPage) || (gVar.jmS.jnc != null && gVar.jmS.jnc.isValid())) {
                            this.jMi.l(gVar);
                        }
                        if (this.jMk.get(0) != null) {
                            this.jMk.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jMn = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jMk.addAll(arrayList);
        }
        if (!this.jMo) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cOV;
        return (!"0".equals(gVar.threadId) || this.jLM == null || this.jLM.cOV() == null || (cOV = this.jLM.cOV()) == null || cOV.video == null || !TextUtils.equals(cOV.title, gVar.title) || !TextUtils.equals(cOV.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<BaseCardInfo> list, boolean z) {
        if (this.jMi != null && !x.isEmpty(list)) {
            if (this.jMj) {
                this.jMi.setData(list, true);
                this.jMj = false;
            } else {
                this.jMi.setData(list, false);
            }
        }
        if (!z) {
            this.jnf.showEndLoadData();
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
            this.jMr = this.jMh.getFirstVisiblePosition();
            View childAt = this.jMh.getChildAt(0);
            this.jiL = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jMi != null) {
            this.jMi.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cOT() != null && this.jMr != this.jMh.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jMh.getLayoutManager()).scrollToPositionWithOffset(this.jMr, this.jiL);
        }
    }

    private int Cq(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jMs - 1) {
            i2 = 1;
            int i4 = i3 - (this.jMs - 1);
            if (i4 >= this.jMs - 1) {
                i2 = (i4 % (this.jMt - 1)) + 1;
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
            i = de(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = de(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.jMi.Co(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jMi.Cn(firstVisiblePosition);
        }
        this.jMi.Cp(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void Cl(int i) {
        if (this.jMi != null) {
            this.jMi.Cm(i - 1);
        }
    }

    public boolean AB(int i) {
        if (this.jMi == null) {
            return false;
        }
        return this.jMi.AB(i);
    }

    public int de(View view) {
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
        return this.jMh.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.f.dTE().dTF();
    }

    public a cOT() {
        if (this.jMi != null) {
            return this.jMi.cOT();
        }
        return null;
    }
}
