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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes21.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private RelativeLayout dJZ;
    private LinearLayoutManager edo;
    private String ezo;
    private View fwY;
    private NoNetworkView giU;
    private int iLD;
    private PbListView iPZ;
    private boolean isFullScreen;
    private h jlI;
    private BdTypeRecyclerView jmd;
    private f jme;
    private List<BaseCardInfo> jmg;
    private com.baidu.tbadk.core.view.a jmh;
    private d jmi;
    private com.baidu.tieba.w.b jmm;
    private int jmn;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jmf = true;
    private int jlZ = -1;
    private boolean jmj = false;
    private boolean jmk = false;
    int jmo = 4;
    int jmq = 7;
    int jmr = 4;
    private CustomMessageListener jms = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener evs = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.giU != null) {
                        VideoMiddlePageFragment.this.giU.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dOt().dOu()) {
                        if (VideoMiddlePageFragment.this.jme == null || !VideoMiddlePageFragment.this.jme.rx()) {
                            if (VideoMiddlePageFragment.this.jme != null && VideoMiddlePageFragment.this.jme.cGk()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.giU != null) {
                    VideoMiddlePageFragment.this.giU.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jme != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jme.aO(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jlI.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jlI.bOb();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.t.c.dIO().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jme != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jme.cAM() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jme.cAM()) {
                        VideoMiddlePageFragment.this.jme.cAN();
                    }
                }
            }
        }
    };
    private CustomMessageListener iJS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jme != null) {
                VideoMiddlePageFragment.this.jme.notifyDataSetChanged();
            }
        }
    };
    private HashMap jml = new HashMap();

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
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
        this.jlI = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jlI.setId(stringExtra);
            this.jlI.setLocation(stringExtra3);
            this.jlI.JY(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.jml.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jml.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jlI.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.ezo = arguments.getString("PARAM_FID");
        }
        if (this.jlI != null) {
            this.jlI.setFrom(this.mFrom);
            this.jlI.cGA();
        }
        registerListener(this.evs);
        registerListener(this.eMu);
        registerListener(this.jms);
        registerListener(this.iJS);
        this.jmm = new com.baidu.tieba.w.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.edo = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jmd = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jmd.addHeaderView(this.mHeaderView);
        this.jmd.setLayoutManager(this.edo);
        this.jmd.setFadingEdgeLength(0);
        this.jmd.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jmd.setOverScrollMode(2);
        this.jmd.setScrollable(this);
        this.dJZ = (RelativeLayout) view.findViewById(R.id.container);
        this.giU = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.giU.setVisibility(0);
        }
        this.iPZ = new PbListView(getPageContext().getPageActivity());
        this.iPZ.setIsMoreViewVisible(false);
        this.iPZ.createView();
        this.iPZ.setLineGone();
        this.iPZ.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.iPZ.setText(getResources().getString(R.string.list_has_no_more));
        this.iPZ.setTextColor(R.color.CAM_X0109);
        this.iPZ.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jmd.setNextPage(this.iPZ);
        this.iPZ.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jmd.setOnScrollListener(this.mScrollListener);
        this.jme = new f(getPageContext(), this.jmd, this, true, this.mFrom, this.ezo, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bpG()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fwY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fwY.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jmg = new ArrayList();
        this.jmi = new d();
        this.jmi.a(this.jlI);
        com.baidu.tieba.frs.aggregation.g cGu = this.jmi.cGu();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cGu);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jme != null) {
            this.jme.qE(false);
        }
        if (!this.jmf) {
            zL(2);
            if (!this.jme.cGk() && this.jme != null && this.jlZ != -1) {
                this.jme.Bo(this.jlZ);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jme != null) {
            this.jme.qE(true);
            this.jlZ = this.jme.cAM();
        }
        zL(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        if (this.jlI != null) {
            this.jlI.cAQ();
        }
        if (this.jme != null) {
            this.jme.onDestroy();
        }
        if (this.jmi != null) {
            this.jmi.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jmh != null) {
            this.jmh.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void atO() {
    }

    public void zL(int i) {
        if (this.jmd != null && this.jme != null) {
            if (i == 1) {
                if (this.jme.cGk()) {
                    this.jme.cGx();
                } else if (this.jme.rx()) {
                    this.jme.rw();
                }
            }
            if (i == 2) {
                this.jme.rw();
                if (this.jme.cGk()) {
                    this.jme.cGy();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void d(List<BaseCardInfo> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!y.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.jmo = TbadkCoreApplication.getInst().getAdAdSense().fbA;
                this.jmq = TbadkCoreApplication.getInst().getAdAdSense().fbC;
                this.jmr = TbadkCoreApplication.getInst().getAdAdSense().fbB;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jmo + (-1))) % (this.jmq + (-1)) == 0;
                boolean z5 = i2 - size == this.jmr;
                if (i2 <= this.jmr) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jlI != null ? this.jlI.getPageNum() : 0, 0, "", "", Bp(size));
                    a2.u(this.jml);
                    dVar = com.baidu.afd.d.a(a2);
                    com.baidu.tieba.lego.card.d.a.a(arrayList2, dVar, 0);
                    i = size + 1;
                } else {
                    dVar = dVar2;
                    i = i2;
                }
                if (z3) {
                    BaseCardInfo baseCardInfo = list.get(size - 1);
                    if (dVar != null && baseCardInfo != null) {
                        baseCardInfo.setTrigger(new com.baidu.afd.g(dVar));
                    }
                }
                arrayList2.add(0, list.get(size - 1));
                size--;
                i2 = i;
                dVar2 = dVar;
            }
            if (!this.jmj && this.jmg.size() > 0 && this.jlI != null && this.jlI.cGB() != null) {
                String str = this.jlI.cGB().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.iPM.mcnLeadPage) || (gVar.iPM.iPW != null && gVar.iPM.iPW.isValid())) {
                            this.jme.l(gVar);
                        }
                        if (this.jmg.get(0) != null) {
                            this.jmg.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jmj = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jmg.addAll(arrayList);
        }
        if (!this.jmk) {
            o(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cGB;
        return (!"0".equals(gVar.threadId) || this.jlI == null || this.jlI.cGB() == null || (cGB = this.jlI.cGB()) == null || cGB.video == null || !TextUtils.equals(cGB.title, gVar.title) || !TextUtils.equals(cGB.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void o(List<BaseCardInfo> list, boolean z) {
        if (this.jme != null && !y.isEmpty(list)) {
            if (this.jmf) {
                this.jme.setData(list, true);
                this.jmf = false;
            } else {
                this.jme.setData(list, false);
            }
        }
        if (!z) {
            this.iPZ.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.giU.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jmn = this.jmd.getFirstVisiblePosition();
            View childAt = this.jmd.getChildAt(0);
            this.iLD = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jme != null) {
            this.jme.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cGz() != null && this.jmn != this.jmd.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jmd.getLayoutManager()).scrollToPositionWithOffset(this.jmn, this.iLD);
        }
    }

    private int Bp(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jmo - 1) {
            i2 = 1;
            int i4 = i3 - (this.jmo - 1);
            if (i4 >= this.jmo - 1) {
                i2 = (i4 % (this.jmq - 1)) + 1;
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
            i = cN(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cN(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.jme.Bn(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jme.Bm(firstVisiblePosition);
        }
        this.jme.Bo(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void Bk(int i) {
        if (this.jme != null) {
            this.jme.Bl(i - 1);
        }
    }

    public boolean zK(int i) {
        if (this.jme == null) {
            return false;
        }
        return this.jme.zK(i);
    }

    public int cN(View view) {
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
        return this.jmd.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dOt().dOu();
    }

    public a cGz() {
        if (this.jme != null) {
            return this.jme.cGz();
        }
        return null;
    }
}
