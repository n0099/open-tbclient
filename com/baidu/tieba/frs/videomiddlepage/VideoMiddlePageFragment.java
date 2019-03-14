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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private String byA;
    private View csB;
    private NoNetworkView dbm;
    private com.baidu.tbadk.core.view.b eQQ;
    private PbListView fff;
    private BdTypeRecyclerView fxI;
    private RelativeLayout fxJ;
    private f fxK;
    private List<com.baidu.tieba.card.data.b> fxM;
    private d fxN;
    private com.baidu.tieba.t.b fxR;
    private h fxq;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean fxL = true;
    private int fxF = -1;
    private boolean fxO = false;
    private boolean fxP = false;
    int fxS = 4;
    int fxT = 7;
    int fxU = 4;
    private CustomMessageListener fxV = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.kY()) {
                    if (VideoMiddlePageFragment.this.dbm != null) {
                        VideoMiddlePageFragment.this.dbm.setVisibility(8);
                    }
                    if (j.la() && !com.baidu.tieba.video.g.ciP().ciQ()) {
                        if (VideoMiddlePageFragment.this.fxK == null || !VideoMiddlePageFragment.this.fxK.pY()) {
                            if (VideoMiddlePageFragment.this.fxK != null && VideoMiddlePageFragment.this.fxK.bjF()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.dbm != null) {
                    VideoMiddlePageFragment.this.dbm.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.fxK != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jy) {
                VideoMiddlePageFragment.this.fxK.af(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.fxq.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.fxq.aBc();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.cdt().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.fxK != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.fxK.beT() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.fxK.beT()) {
                        VideoMiddlePageFragment.this.fxK.beU();
                    }
                }
            }
        }
    };
    private HashMap fxQ = new HashMap();

    public static VideoMiddlePageFragment cP(String str, String str2) {
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
        com.baidu.tieba.q.c.cdt().s(getUniqueId());
        this.fxq = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.fxq.setId(stringExtra);
            this.fxq.setLocation(stringExtra3);
            this.fxq.ve(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.fxQ.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.fxQ.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.fxq.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.byA = arguments.getString("PARAM_FID");
        }
        if (this.fxq != null) {
            this.fxq.setFrom(this.mFrom);
            this.fxq.bjU();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.fxV);
        this.fxR = new com.baidu.tieba.t.b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(getPageContext().getPageActivity(), d.e.ds88) + l.h(getPageContext().getPageActivity(), d.e.tbds42)));
        this.fxI = (BdTypeRecyclerView) view.findViewById(d.g.video_middle_page_list_view);
        this.fxI.addHeaderView(this.mHeaderView);
        this.fxI.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fxI.setFadingEdgeLength(0);
        this.fxI.setBackgroundColor(al.getColor(d.C0277d.transparent));
        this.fxI.setOverScrollMode(2);
        this.fxI.setScrollable(this);
        this.fxJ = (RelativeLayout) view.findViewById(d.g.container);
        this.dbm = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.kY()) {
            this.dbm.setVisibility(0);
        }
        this.fff = new PbListView(getPageContext().getPageActivity());
        this.fff.dQ(false);
        this.fff.oM();
        this.fff.aez();
        this.fff.ib(d.C0277d.cp_cont_b);
        this.fff.setText(getResources().getString(d.j.list_has_no_more));
        this.fff.setTextColor(d.C0277d.cp_cont_d);
        this.fff.ia(d.C0277d.cp_cont_f);
        this.fxI.setNextPage(this.fff);
        this.fff.id(l.h(TbadkCoreApplication.getInst(), d.e.tbds804));
        this.fxI.setOnScrollListener(this.mScrollListener);
        this.fxK = new f(getPageContext(), this.fxI, this, true, this.mFrom, this.byA, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.csB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.csB.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.fxM = new ArrayList();
        this.fxN = new d();
        this.fxN.a(this.fxq);
        com.baidu.tieba.frs.aggregation.g bjP = this.fxN.bjP();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bjP);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fxK != null) {
            this.fxK.jW(false);
        }
        if (!this.fxL) {
            qx(2);
            if (!this.fxK.bjF() && this.fxK != null && this.fxF != -1) {
                this.fxK.rO(this.fxF);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fxK != null) {
            this.fxK.jW(true);
            this.fxF = this.fxK.beT();
        }
        qx(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.cdt().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.cdt().t(getUniqueId());
        if (this.fxq != null) {
            this.fxq.beY();
        }
        if (this.fxK != null) {
            this.fxK.onDestroy();
        }
        if (this.fxN != null) {
            this.fxN.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.eQQ != null) {
            this.eQQ.dJ(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void anb() {
    }

    public void qx(int i) {
        if (this.fxI != null && this.fxK != null) {
            if (i == 1) {
                if (this.fxK.bjF()) {
                    this.fxK.bjS();
                } else if (this.fxK.pY()) {
                    this.fxK.pX();
                }
            }
            if (i == 2) {
                this.fxK.pX();
                if (this.fxK.bjF()) {
                    this.fxK.bjT();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void c(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!v.T(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.fxS = TbadkCoreApplication.getInst().getAdAdSense().bWG;
                this.fxT = TbadkCoreApplication.getInst().getAdAdSense().bWI;
                this.fxU = TbadkCoreApplication.getInst().getAdAdSense().bWH;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.fxS + (-1))) % (this.fxT + (-1)) == 0;
                boolean z5 = i2 - size == this.fxU;
                if (i2 <= this.fxU) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.fxq != null ? this.fxq.getPageNum() : 0, 0, "", "", rP(size));
                    a.l(this.fxQ);
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
            if (!this.fxO && this.fxM.size() > 0 && this.fxq != null && this.fxq.bjV() != null) {
                String str = this.fxq.bjV().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.feS.mcnLeadPage) || (gVar.feS.ffc != null && gVar.feS.ffc.isValid())) {
                            this.fxK.j(gVar);
                        }
                        if (this.fxM.get(0) != null) {
                            this.fxM.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.fxO = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.fxM.addAll(arrayList);
        }
        if (!this.fxP) {
            l(arrayList, z);
        }
    }

    private void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.fxK != null && !v.T(list)) {
            if (this.fxL) {
                this.fxK.setData(list, true);
                this.fxL = false;
            } else {
                this.fxK.setData(list, false);
            }
        }
        if (!z) {
            this.fff.aeF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbm.onChangeSkinType(getPageContext(), i);
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
        if (this.fxK != null) {
            this.fxK.onConfigurationChanged(configuration);
        }
    }

    private int rP(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.fxS - 1) {
            i2 = 1;
            int i4 = i3 - (this.fxS - 1);
            if (i4 >= this.fxS - 1) {
                i2 = (i4 % (this.fxT - 1)) + 1;
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
            i = bO(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = bO(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.fxK.rN(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.fxK.rM(firstVisiblePosition);
        }
        this.fxK.rO(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void rK(int i) {
        if (this.fxK != null) {
            this.fxK.rL(i - 1);
        }
    }

    public boolean qw(int i) {
        if (this.fxK == null) {
            return false;
        }
        return this.fxK.qw(i);
    }

    public int bO(View view) {
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
        return this.fxI.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kZ() || com.baidu.tieba.video.g.ciP().ciQ();
    }
}
