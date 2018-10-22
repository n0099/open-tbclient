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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.k;
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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoMiddlePageFragment extends BaseFragment implements b, f.b {
    private String amT;
    private NoNetworkView bJX;
    private View bdE;
    private PbListView dFQ;
    private g dWP;
    private BdTypeRecyclerView dXg;
    private RelativeLayout dXh;
    private e dXi;
    private List<com.baidu.tieba.card.data.b> dXk;
    private c dXl;
    private com.baidu.tieba.t.a dXp;
    private com.baidu.tbadk.core.view.d dsB;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dXj = true;
    private int dXd = -1;
    private boolean dXm = false;
    private boolean dXn = false;
    int dXq = 4;
    int dXr = 7;
    int dXs = 4;
    private CustomMessageListener dXt = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                if (j.kX()) {
                    if (VideoMiddlePageFragment.this.bJX != null) {
                        VideoMiddlePageFragment.this.bJX.setVisibility(8);
                    }
                    if (j.kZ() && !com.baidu.tieba.video.g.bGn().bGo() && VideoMiddlePageFragment.this.dXi != null && VideoMiddlePageFragment.this.dXi.pE()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(e.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.bJX != null) {
                    VideoMiddlePageFragment.this.bJX.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dXi != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jo) {
                VideoMiddlePageFragment.this.dXi.K(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.dWP.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.dWP.YL();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.dXi != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.dXi.aBR() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.dXi.aBR()) {
                        VideoMiddlePageFragment.this.dXi.aBS();
                    }
                }
            }
        }
    };
    private HashMap dXo = new HashMap();

    public static VideoMiddlePageFragment bC(String str, String str2) {
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
        this.dWP = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dWP.setId(stringExtra);
            this.dWP.setLocation(stringExtra3);
            this.dWP.nG(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dXo.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dXo.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dWP.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.amT = arguments.getString("PARAM_FID");
        }
        if (this.dWP != null) {
            this.dWP.setFrom(this.mFrom);
            this.dWP.aGA();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dXt);
        this.dXp = new com.baidu.tieba.t.a();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(e.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(getPageContext().getPageActivity(), e.C0175e.ds88) + l.h(getPageContext().getPageActivity(), e.C0175e.tbds42)));
        this.dXg = (BdTypeRecyclerView) view.findViewById(e.g.video_middle_page_list_view);
        this.dXg.addHeaderView(this.mHeaderView);
        this.dXg.setLayoutManager(new LinearLayoutManager(getContext()));
        this.dXg.setFadingEdgeLength(0);
        this.dXg.setBackgroundColor(al.getColor(e.d.transparent));
        this.dXg.setOverScrollMode(2);
        this.dXg.setScrollable(this);
        this.dXh = (RelativeLayout) view.findViewById(e.g.container);
        this.bJX = (NoNetworkView) view.findViewById(e.g.no_network_view);
        if (!j.kX()) {
            this.bJX.setVisibility(0);
        }
        this.dFQ = new PbListView(getPageContext().getPageActivity());
        this.dFQ.bo(false);
        this.dFQ.oG();
        this.dFQ.DL();
        this.dFQ.dV(e.d.cp_cont_b);
        this.dFQ.setText(getResources().getString(e.j.list_has_no_more));
        this.dFQ.setTextColor(e.d.cp_cont_d);
        this.dFQ.dU(e.d.cp_cont_f);
        this.dXg.setNextPage(this.dFQ);
        this.dFQ.dX(l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds804));
        this.dXg.setOnScrollListener(this.mScrollListener);
        this.dXi = new e(getPageContext(), this.dXg, this, true, this.mFrom, this.amT);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.bdE.findViewById(e.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(e.f.icon_return_bg));
        this.dXk = new ArrayList();
        this.dXl = new c();
        this.dXl.a(this.dWP);
        com.baidu.tieba.frs.aggregation.g aGx = this.dXl.aGx();
        ArrayList arrayList = new ArrayList();
        arrayList.add(aGx);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dXi != null) {
            this.dXi.hi(false);
        }
        if (!this.dXj && this.dXp != null && !this.dXp.isKeyguardLocked()) {
            lN(2);
            if (this.dXi != null && this.dXd != -1) {
                this.dXi.nb(this.dXd);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dXi != null) {
            this.dXi.hi(true);
            this.dXd = this.dXi.aBR();
        }
        lN(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dWP != null) {
            this.dWP.aBW();
        }
        if (this.dXi != null) {
            this.dXi.onDestroy();
        }
        if (this.dXl != null) {
            this.dXl.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.dsB != null) {
            this.dsB.bj(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void LP() {
    }

    public void lN(int i) {
        if (this.dXg != null && this.dXi != null) {
            if (i == 1 && this.dXi.pE()) {
                this.dXi.pD();
            }
            if (i == 2) {
                this.dXi.pD();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void c(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!v.J(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.dXq = TbadkCoreApplication.getInst().getAdAdSense().aJl;
                this.dXr = TbadkCoreApplication.getInst().getAdAdSense().aJn;
                this.dXs = TbadkCoreApplication.getInst().getAdAdSense().aJm;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dXq + (-1))) % (this.dXr + (-1)) == 0;
                boolean z5 = i2 - size == this.dXs;
                if (i2 <= this.dXs) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dWP != null ? this.dWP.getPageNum() : 0, 0, "", "", nc(size));
                    a.m(this.dXo);
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
            if (!this.dXm && this.dXk.size() > 0 && this.dWP != null && this.dWP.aGB() != null) {
                String str = this.dWP.aGB().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.dXk.get(0) != null) {
                            this.dXk.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.dXm = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.dXk.addAll(arrayList);
        }
        if (!this.dXn) {
            j(arrayList, z);
        }
    }

    private void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dXi != null && !v.J(list)) {
            if (this.dXj) {
                this.dXi.setData(list, true);
                this.dXj = false;
            } else {
                this.dXi.setData(list, false);
            }
        }
        if (!z) {
            this.dFQ.DR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bJX.onChangeSkinType(getPageContext(), i);
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
        if (this.dXi != null) {
            this.dXi.onConfigurationChanged(configuration);
        }
    }

    private int nc(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dXq - 1) {
            i2 = 1;
            int i4 = i3 - (this.dXq - 1);
            if (i4 >= this.dXq - 1) {
                i2 = (i4 % (this.dXr - 1)) + 1;
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
            i = aS(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = aS(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.dXi.na(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.dXi.mZ(firstVisiblePosition);
        }
        this.dXi.nb(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void mX(int i) {
        if (this.dXi != null) {
            this.dXi.mY(i - 1);
        }
    }

    public boolean lM(int i) {
        if (this.dXi == null) {
            return false;
        }
        return this.dXi.lM(i);
    }

    public int aS(View view) {
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
    public k onGetPreLoadListView() {
        return this.dXg.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kY() || com.baidu.tieba.video.g.bGn().bGo();
    }
}
