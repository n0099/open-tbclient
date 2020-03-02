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
    private String cOR;
    private LinearLayoutManager cxF;
    private View dFK;
    private NoNetworkView eli;
    private h gNT;
    private BdTypeRecyclerView gOo;
    private RelativeLayout gOp;
    private f gOq;
    private List<com.baidu.tieba.card.data.b> gOs;
    private com.baidu.tbadk.core.view.a gOt;
    private d gOu;
    private com.baidu.tieba.v.b gOy;
    private int gOz;
    private PbListView guN;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean gOr = true;
    private int gOk = -1;
    private boolean gOv = false;
    private boolean gOw = false;
    int gOA = 4;
    int gOB = 7;
    int gOC = 4;
    private CustomMessageListener gOD = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener cLy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.eli != null) {
                        VideoMiddlePageFragment.this.eli.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.cPh().cPi()) {
                        if (VideoMiddlePageFragment.this.gOq == null || !VideoMiddlePageFragment.this.gOq.kR()) {
                            if (VideoMiddlePageFragment.this.gOq != null && VideoMiddlePageFragment.this.gOq.bLj()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.eli != null) {
                    VideoMiddlePageFragment.this.eli.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.gOq != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.gOq.al(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.gNT.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.gNT.bcf();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.cKa().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.gOq != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.gOq.bGr() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.gOq.bGr()) {
                        VideoMiddlePageFragment.this.gOq.bGs();
                    }
                }
            }
        }
    };
    private CustomMessageListener gpJ = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.gOq != null) {
                VideoMiddlePageFragment.this.gOq.notifyDataSetChanged();
            }
        }
    };
    private HashMap gOx = new HashMap();

    public static VideoMiddlePageFragment dv(String str, String str2) {
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
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
        this.gNT = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.gNT.setId(stringExtra);
            this.gNT.setLocation(stringExtra3);
            this.gNT.Bk(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.gOx.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.gOx.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.gNT.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.cOR = arguments.getString("PARAM_FID");
        }
        if (this.gNT != null) {
            this.gNT.setFrom(this.mFrom);
            this.gNT.bLz();
        }
        registerListener(this.cLy);
        registerListener(this.daf);
        registerListener(this.gOD);
        registerListener(this.gpJ);
        this.gOy = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cxF = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.gOo = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.gOo.addHeaderView(this.mHeaderView);
        this.gOo.setLayoutManager(this.cxF);
        this.gOo.setFadingEdgeLength(0);
        this.gOo.setBackgroundColor(am.getColor(R.color.transparent));
        this.gOo.setOverScrollMode(2);
        this.gOo.setScrollable(this);
        this.gOp = (RelativeLayout) view.findViewById(R.id.container);
        this.eli = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.eli.setVisibility(0);
        }
        this.guN = new PbListView(getPageContext().getPageActivity());
        this.guN.setIsMoreViewVisible(false);
        this.guN.createView();
        this.guN.setLineGone();
        this.guN.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.guN.setText(getResources().getString(R.string.list_has_no_more));
        this.guN.setTextColor(R.color.cp_cont_d);
        this.guN.setNoMoreTextColorId(R.color.cp_cont_f);
        this.gOo.setNextPage(this.guN);
        this.guN.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.gOo.setOnScrollListener(this.mScrollListener);
        this.gOq = new f(getPageContext(), this.gOo, this, true, this.mFrom, this.cOR, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.dFK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.dFK.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.gOs = new ArrayList();
        this.gOu = new d();
        this.gOu.a(this.gNT);
        com.baidu.tieba.frs.aggregation.g bLt = this.gOu.bLt();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bLt);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gOq != null) {
            this.gOq.mn(false);
        }
        if (!this.gOr) {
            tg(2);
            if (!this.gOq.bLj() && this.gOq != null && this.gOk != -1) {
                this.gOq.uC(this.gOk);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gOq != null) {
            this.gOq.mn(true);
            this.gOk = this.gOq.bGr();
        }
        tg(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cKa().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        if (this.gNT != null) {
            this.gNT.bGv();
        }
        if (this.gOq != null) {
            this.gOq.onDestroy();
        }
        if (this.gOu != null) {
            this.gOu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.gOt != null) {
            this.gOt.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void Sk() {
    }

    public void tg(int i) {
        if (this.gOo != null && this.gOq != null) {
            if (i == 1) {
                if (this.gOq.bLj()) {
                    this.gOq.bLw();
                } else if (this.gOq.kR()) {
                    this.gOq.kQ();
                }
            }
            if (i == 2) {
                this.gOq.kQ();
                if (this.gOq.bLj()) {
                    this.gOq.bLx();
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
                this.gOA = TbadkCoreApplication.getInst().getAdAdSense().dlU;
                this.gOB = TbadkCoreApplication.getInst().getAdAdSense().dlW;
                this.gOC = TbadkCoreApplication.getInst().getAdAdSense().dlV;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.gOA + (-1))) % (this.gOB + (-1)) == 0;
                boolean z5 = i2 - size == this.gOC;
                if (i2 <= this.gOC) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.gNT != null ? this.gNT.getPageNum() : 0, 0, "", "", uD(size));
                    a.j(this.gOx);
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
            if (!this.gOv && this.gOs.size() > 0 && this.gNT != null && this.gNT.bLA() != null) {
                String str = this.gNT.bLA().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.guz.mcnLeadPage) || (gVar.guz.guK != null && gVar.guz.guK.isValid())) {
                            this.gOq.l(gVar);
                        }
                        if (this.gOs.get(0) != null) {
                            this.gOs.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.gOv = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.gOs.addAll(arrayList);
        }
        if (!this.gOw) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo bLA;
        return (!"0".equals(gVar.threadId) || this.gNT == null || this.gNT.bLA() == null || (bLA = this.gNT.bLA()) == null || bLA.video == null || !TextUtils.equals(bLA.title, gVar.title) || !TextUtils.equals(bLA.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.gOq != null && !v.isEmpty(list)) {
            if (this.gOr) {
                this.gOq.setData(list, true);
                this.gOr = false;
            } else {
                this.gOq.setData(list, false);
            }
        }
        if (!z) {
            this.guN.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eli.onChangeSkinType(getPageContext(), i);
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
            if (bLy() != null) {
                this.gOz = bLy().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.gOq != null) {
            this.gOq.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && bLy() != null && (top2 = bLy().getView().getTop()) != this.gOz) {
            this.gOo.scrollBy(0, top2 - this.gOz);
            this.gOz = top2;
        }
    }

    private int uD(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.gOA - 1) {
            i2 = 1;
            int i4 = i3 - (this.gOA - 1);
            if (i4 >= this.gOA - 1) {
                i2 = (i4 % (this.gOB - 1)) + 1;
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
        if (!this.gOq.uB(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.gOq.uA(firstVisiblePosition);
        }
        this.gOq.uC(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void uy(int i) {
        if (this.gOq != null) {
            this.gOq.uz(i - 1);
        }
    }

    public boolean tf(int i) {
        if (this.gOq == null) {
            return false;
        }
        return this.gOq.tf(i);
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
        return this.gOo.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.cPh().cPi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test");
    }

    public a bLy() {
        if (this.gOq != null) {
            return this.gOq.bLy();
        }
        return null;
    }
}
