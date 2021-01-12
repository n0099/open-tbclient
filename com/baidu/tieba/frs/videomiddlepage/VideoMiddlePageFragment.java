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
    private RelativeLayout dVi;
    private String eLs;
    private LinearLayoutManager eoG;
    private View fJL;
    private NoNetworkView gxx;
    private boolean isFullScreen;
    private BdTypeRecyclerView jHB;
    private f jHC;
    private List<BaseCardInfo> jHE;
    private com.baidu.tbadk.core.view.a jHF;
    private d jHG;
    private com.baidu.tieba.v.b jHK;
    private int jHL;
    private h jHg;
    private int jed;
    private PbListView jiy;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jHD = true;
    private int jHx = -1;
    private boolean jHH = false;
    private boolean jHI = false;
    int jHM = 4;
    int jHN = 7;
    int jHO = 4;
    private CustomMessageListener jHP = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.gxx != null) {
                        VideoMiddlePageFragment.this.gxx.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dPM().dPN()) {
                        if (VideoMiddlePageFragment.this.jHC == null || !VideoMiddlePageFragment.this.jHC.rb()) {
                            if (VideoMiddlePageFragment.this.jHC != null && VideoMiddlePageFragment.this.jHC.cKM()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.gxx != null) {
                    VideoMiddlePageFragment.this.gxx.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jHC != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jHC.aP(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jHg.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jHg.bQy();
                    }
                    VideoMiddlePageFragment.this.h(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dKg().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jHC != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jHC.cEg() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jHC.cEg()) {
                        VideoMiddlePageFragment.this.jHC.cEh();
                    }
                }
            }
        }
    };
    private CustomMessageListener jcr = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jHC != null) {
                VideoMiddlePageFragment.this.jHC.notifyDataSetChanged();
            }
        }
    };
    private HashMap jHJ = new HashMap();

    public static VideoMiddlePageFragment fn(String str, String str2) {
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
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        this.jHg = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jHg.setId(stringExtra);
            this.jHg.setLocation(stringExtra3);
            this.jHg.JD(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.jHJ.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jHJ.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jHg.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eLs = arguments.getString("PARAM_FID");
        }
        if (this.jHg != null) {
            this.jHg.setFrom(this.mFrom);
            this.jHg.cLc();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.eYu);
        registerListener(this.jHP);
        registerListener(this.jcr);
        this.jHK = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.eoG = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jHB = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jHB.addHeaderView(this.mHeaderView);
        this.jHB.setLayoutManager(this.eoG);
        this.jHB.setFadingEdgeLength(0);
        this.jHB.setBackgroundColor(ao.getColor(R.color.transparent));
        this.jHB.setOverScrollMode(2);
        this.jHB.setScrollable(this);
        this.dVi = (RelativeLayout) view.findViewById(R.id.container);
        this.gxx = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.gxx.setVisibility(0);
        }
        this.jiy = new PbListView(getPageContext().getPageActivity());
        this.jiy.setIsMoreViewVisible(false);
        this.jiy.createView();
        this.jiy.setLineGone();
        this.jiy.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.jiy.setText(getResources().getString(R.string.list_has_no_more));
        this.jiy.setTextColor(R.color.CAM_X0109);
        this.jiy.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jHB.setNextPage(this.jiy);
        this.jiy.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jHB.setOnScrollListener(this.mScrollListener);
        this.jHC = new f(getPageContext(), this.jHB, this, true, this.mFrom, this.eLs, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.brJ()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fJL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fJL.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jHE = new ArrayList();
        this.jHG = new d();
        this.jHG.a(this.jHg);
        com.baidu.tieba.frs.aggregation.g cKW = this.jHG.cKW();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cKW);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jHC != null) {
            this.jHC.rA(false);
        }
        if (!this.jHD) {
            yW(2);
            if (!this.jHC.cKM() && this.jHC != null && this.jHx != -1) {
                this.jHC.AJ(this.jHx);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jHC != null) {
            this.jHC.rA(true);
            this.jHx = this.jHC.cEg();
        }
        yW(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        if (this.jHg != null) {
            this.jHg.cEk();
        }
        if (this.jHC != null) {
            this.jHC.onDestroy();
        }
        if (this.jHG != null) {
            this.jHG.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jHF != null) {
            this.jHF.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void onLoadFail() {
    }

    public void yW(int i) {
        if (this.jHB != null && this.jHC != null) {
            if (i == 1) {
                if (this.jHC.cKM()) {
                    this.jHC.cKZ();
                } else if (this.jHC.rb()) {
                    this.jHC.ra();
                }
            }
            if (i == 2) {
                this.jHC.ra();
                if (this.jHC.cKM()) {
                    this.jHC.cLa();
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
                this.jHM = TbadkCoreApplication.getInst().getAdAdSense().fnY;
                this.jHN = TbadkCoreApplication.getInst().getAdAdSense().foa;
                this.jHO = TbadkCoreApplication.getInst().getAdAdSense().fnZ;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jHM + (-1))) % (this.jHN + (-1)) == 0;
                boolean z5 = i - size == this.jHO;
                if (i <= this.jHO) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jHg != null ? this.jHg.getPageNum() : 0, 0, "", "", AK(size));
                    a2.u(this.jHJ);
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
            if (!this.jHH && this.jHE.size() > 0 && this.jHg != null && this.jHg.cLd() != null) {
                String str = this.jHg.cLd().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.jil.mcnLeadPage) || (gVar.jil.jiv != null && gVar.jil.jiv.isValid())) {
                            this.jHC.l(gVar);
                        }
                        if (this.jHE.get(0) != null) {
                            this.jHE.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jHH = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jHE.addAll(arrayList);
        }
        if (!this.jHI) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cLd;
        return (!"0".equals(gVar.threadId) || this.jHg == null || this.jHg.cLd() == null || (cLd = this.jHg.cLd()) == null || cLd.video == null || !TextUtils.equals(cLd.title, gVar.title) || !TextUtils.equals(cLd.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<BaseCardInfo> list, boolean z) {
        if (this.jHC != null && !x.isEmpty(list)) {
            if (this.jHD) {
                this.jHC.setData(list, true);
                this.jHD = false;
            } else {
                this.jHC.setData(list, false);
            }
        }
        if (!z) {
            this.jiy.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxx.onChangeSkinType(getPageContext(), i);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jHL = this.jHB.getFirstVisiblePosition();
            View childAt = this.jHB.getChildAt(0);
            this.jed = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jHC != null) {
            this.jHC.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cLb() != null && this.jHL != this.jHB.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jHB.getLayoutManager()).scrollToPositionWithOffset(this.jHL, this.jed);
        }
    }

    private int AK(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jHM - 1) {
            i2 = 1;
            int i4 = i3 - (this.jHM - 1);
            if (i4 >= this.jHM - 1) {
                i2 = (i4 % (this.jHN - 1)) + 1;
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
        if (!this.jHC.AI(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jHC.AH(firstVisiblePosition);
        }
        this.jHC.AJ(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void AF(int i) {
        if (this.jHC != null) {
            this.jHC.AG(i - 1);
        }
    }

    public boolean yV(int i) {
        if (this.jHC == null) {
            return false;
        }
        return this.jHC.yV(i);
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
        return this.jHB.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.f.dPM().dPN();
    }

    public a cLb() {
        if (this.jHC != null) {
            return this.jHC.cLb();
        }
        return null;
    }
}
