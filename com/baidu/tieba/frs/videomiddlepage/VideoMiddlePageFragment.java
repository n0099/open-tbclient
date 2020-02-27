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
    private String cOQ;
    private LinearLayoutManager cxE;
    private View dFJ;
    private NoNetworkView elh;
    private h gNR;
    private BdTypeRecyclerView gOm;
    private RelativeLayout gOn;
    private f gOo;
    private List<com.baidu.tieba.card.data.b> gOq;
    private com.baidu.tbadk.core.view.a gOr;
    private d gOs;
    private com.baidu.tieba.v.b gOw;
    private int gOx;
    private PbListView guL;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean gOp = true;
    private int gOi = -1;
    private boolean gOt = false;
    private boolean gOu = false;
    int gOy = 4;
    int gOz = 7;
    int gOA = 4;
    private CustomMessageListener gOB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener cLx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.elh != null) {
                        VideoMiddlePageFragment.this.elh.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.cPf().cPg()) {
                        if (VideoMiddlePageFragment.this.gOo == null || !VideoMiddlePageFragment.this.gOo.kR()) {
                            if (VideoMiddlePageFragment.this.gOo != null && VideoMiddlePageFragment.this.gOo.bLh()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.elh != null) {
                    VideoMiddlePageFragment.this.elh.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.gOo != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.gOo.al(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.gNR.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.gNR.bcd();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.cJY().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.gOo != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.gOo.bGp() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.gOo.bGp()) {
                        VideoMiddlePageFragment.this.gOo.bGq();
                    }
                }
            }
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.gOo != null) {
                VideoMiddlePageFragment.this.gOo.notifyDataSetChanged();
            }
        }
    };
    private HashMap gOv = new HashMap();

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
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
        this.gNR = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.gNR.setId(stringExtra);
            this.gNR.setLocation(stringExtra3);
            this.gNR.Bk(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.gOv.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.gOv.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.gNR.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.cOQ = arguments.getString("PARAM_FID");
        }
        if (this.gNR != null) {
            this.gNR.setFrom(this.mFrom);
            this.gNR.bLx();
        }
        registerListener(this.cLx);
        registerListener(this.dae);
        registerListener(this.gOB);
        registerListener(this.gpH);
        this.gOw = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cxE = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.gOm = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.gOm.addHeaderView(this.mHeaderView);
        this.gOm.setLayoutManager(this.cxE);
        this.gOm.setFadingEdgeLength(0);
        this.gOm.setBackgroundColor(am.getColor(R.color.transparent));
        this.gOm.setOverScrollMode(2);
        this.gOm.setScrollable(this);
        this.gOn = (RelativeLayout) view.findViewById(R.id.container);
        this.elh = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.elh.setVisibility(0);
        }
        this.guL = new PbListView(getPageContext().getPageActivity());
        this.guL.setIsMoreViewVisible(false);
        this.guL.createView();
        this.guL.setLineGone();
        this.guL.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.guL.setText(getResources().getString(R.string.list_has_no_more));
        this.guL.setTextColor(R.color.cp_cont_d);
        this.guL.setNoMoreTextColorId(R.color.cp_cont_f);
        this.gOm.setNextPage(this.guL);
        this.guL.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.gOm.setOnScrollListener(this.mScrollListener);
        this.gOo = new f(getPageContext(), this.gOm, this, true, this.mFrom, this.cOQ, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.dFJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.dFJ.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.gOq = new ArrayList();
        this.gOs = new d();
        this.gOs.a(this.gNR);
        com.baidu.tieba.frs.aggregation.g bLr = this.gOs.bLr();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bLr);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gOo != null) {
            this.gOo.mn(false);
        }
        if (!this.gOp) {
            tg(2);
            if (!this.gOo.bLh() && this.gOo != null && this.gOi != -1) {
                this.gOo.uC(this.gOi);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gOo != null) {
            this.gOo.mn(true);
            this.gOi = this.gOo.bGp();
        }
        tg(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        if (this.gNR != null) {
            this.gNR.bGt();
        }
        if (this.gOo != null) {
            this.gOo.onDestroy();
        }
        if (this.gOs != null) {
            this.gOs.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.gOr != null) {
            this.gOr.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void Si() {
    }

    public void tg(int i) {
        if (this.gOm != null && this.gOo != null) {
            if (i == 1) {
                if (this.gOo.bLh()) {
                    this.gOo.bLu();
                } else if (this.gOo.kR()) {
                    this.gOo.kQ();
                }
            }
            if (i == 2) {
                this.gOo.kQ();
                if (this.gOo.bLh()) {
                    this.gOo.bLv();
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
                this.gOy = TbadkCoreApplication.getInst().getAdAdSense().dlT;
                this.gOz = TbadkCoreApplication.getInst().getAdAdSense().dlV;
                this.gOA = TbadkCoreApplication.getInst().getAdAdSense().dlU;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.gOy + (-1))) % (this.gOz + (-1)) == 0;
                boolean z5 = i2 - size == this.gOA;
                if (i2 <= this.gOA) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.gNR != null ? this.gNR.getPageNum() : 0, 0, "", "", uD(size));
                    a.j(this.gOv);
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
            if (!this.gOt && this.gOq.size() > 0 && this.gNR != null && this.gNR.bLy() != null) {
                String str = this.gNR.bLy().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.gux.mcnLeadPage) || (gVar.gux.guI != null && gVar.gux.guI.isValid())) {
                            this.gOo.l(gVar);
                        }
                        if (this.gOq.get(0) != null) {
                            this.gOq.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.gOt = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.gOq.addAll(arrayList);
        }
        if (!this.gOu) {
            p(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo bLy;
        return (!"0".equals(gVar.threadId) || this.gNR == null || this.gNR.bLy() == null || (bLy = this.gNR.bLy()) == null || bLy.video == null || !TextUtils.equals(bLy.title, gVar.title) || !TextUtils.equals(bLy.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void p(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.gOo != null && !v.isEmpty(list)) {
            if (this.gOp) {
                this.gOo.setData(list, true);
                this.gOp = false;
            } else {
                this.gOo.setData(list, false);
            }
        }
        if (!z) {
            this.guL.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.elh.onChangeSkinType(getPageContext(), i);
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
            if (bLw() != null) {
                this.gOx = bLw().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.gOo != null) {
            this.gOo.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && bLw() != null && (top2 = bLw().getView().getTop()) != this.gOx) {
            this.gOm.scrollBy(0, top2 - this.gOx);
            this.gOx = top2;
        }
    }

    private int uD(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.gOy - 1) {
            i2 = 1;
            int i4 = i3 - (this.gOy - 1);
            if (i4 >= this.gOy - 1) {
                i2 = (i4 % (this.gOz - 1)) + 1;
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
        if (!this.gOo.uB(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.gOo.uA(firstVisiblePosition);
        }
        this.gOo.uC(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void uy(int i) {
        if (this.gOo != null) {
            this.gOo.uz(i - 1);
        }
    }

    public boolean tf(int i) {
        if (this.gOo == null) {
            return false;
        }
        return this.gOo.tf(i);
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
        return this.gOm.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.cPf().cPg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test");
    }

    public a bLw() {
        if (this.gOo != null) {
            return this.gOo.bLw();
        }
        return null;
    }
}
