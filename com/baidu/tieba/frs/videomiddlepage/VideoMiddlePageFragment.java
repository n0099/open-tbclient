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
    private g dWO;
    private BdTypeRecyclerView dXf;
    private RelativeLayout dXg;
    private e dXh;
    private List<com.baidu.tieba.card.data.b> dXj;
    private c dXk;
    private com.baidu.tieba.t.a dXo;
    private com.baidu.tbadk.core.view.d dsB;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dXi = true;
    private int dXc = -1;
    private boolean dXl = false;
    private boolean dXm = false;
    int dXp = 4;
    int dXq = 7;
    int dXr = 4;
    private CustomMessageListener dXs = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (j.kZ() && !com.baidu.tieba.video.g.bGn().bGo() && VideoMiddlePageFragment.this.dXh != null && VideoMiddlePageFragment.this.dXh.pE()) {
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dXh != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jo) {
                VideoMiddlePageFragment.this.dXh.K(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.dWO.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.dWO.YK();
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
                if (VideoMiddlePageFragment.this.dXh != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.dXh.aBQ() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.dXh.aBQ()) {
                        VideoMiddlePageFragment.this.dXh.aBR();
                    }
                }
            }
        }
    };
    private HashMap dXn = new HashMap();

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
        this.dWO = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dWO.setId(stringExtra);
            this.dWO.setLocation(stringExtra3);
            this.dWO.nG(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dXn.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dXn.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dWO.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.amT = arguments.getString("PARAM_FID");
        }
        if (this.dWO != null) {
            this.dWO.setFrom(this.mFrom);
            this.dWO.aGA();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dXs);
        this.dXo = new com.baidu.tieba.t.a();
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
        this.dXf = (BdTypeRecyclerView) view.findViewById(e.g.video_middle_page_list_view);
        this.dXf.addHeaderView(this.mHeaderView);
        this.dXf.setLayoutManager(new LinearLayoutManager(getContext()));
        this.dXf.setFadingEdgeLength(0);
        this.dXf.setBackgroundColor(al.getColor(e.d.transparent));
        this.dXf.setOverScrollMode(2);
        this.dXf.setScrollable(this);
        this.dXg = (RelativeLayout) view.findViewById(e.g.container);
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
        this.dXf.setNextPage(this.dFQ);
        this.dFQ.dX(l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds804));
        this.dXf.setOnScrollListener(this.mScrollListener);
        this.dXh = new e(getPageContext(), this.dXf, this, true, this.mFrom, this.amT);
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
        this.dXj = new ArrayList();
        this.dXk = new c();
        this.dXk.a(this.dWO);
        com.baidu.tieba.frs.aggregation.g aGx = this.dXk.aGx();
        ArrayList arrayList = new ArrayList();
        arrayList.add(aGx);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dXh != null) {
            this.dXh.hi(false);
        }
        if (!this.dXi && this.dXo != null && !this.dXo.isKeyguardLocked()) {
            lN(2);
            if (this.dXh != null && this.dXc != -1) {
                this.dXh.nb(this.dXc);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dXh != null) {
            this.dXh.hi(true);
            this.dXc = this.dXh.aBQ();
        }
        lN(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dWO != null) {
            this.dWO.aBV();
        }
        if (this.dXh != null) {
            this.dXh.onDestroy();
        }
        if (this.dXk != null) {
            this.dXk.onDestroy();
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
        if (this.dXf != null && this.dXh != null) {
            if (i == 1 && this.dXh.pE()) {
                this.dXh.pD();
            }
            if (i == 2) {
                this.dXh.pD();
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
                this.dXp = TbadkCoreApplication.getInst().getAdAdSense().aJl;
                this.dXq = TbadkCoreApplication.getInst().getAdAdSense().aJn;
                this.dXr = TbadkCoreApplication.getInst().getAdAdSense().aJm;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dXp + (-1))) % (this.dXq + (-1)) == 0;
                boolean z5 = i2 - size == this.dXr;
                if (i2 <= this.dXr) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dWO != null ? this.dWO.getPageNum() : 0, 0, "", "", nc(size));
                    a.m(this.dXn);
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
            if (!this.dXl && this.dXj.size() > 0 && this.dWO != null && this.dWO.aGB() != null) {
                String str = this.dWO.aGB().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.dXj.get(0) != null) {
                            this.dXj.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.dXl = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.dXj.addAll(arrayList);
        }
        if (!this.dXm) {
            j(arrayList, z);
        }
    }

    private void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dXh != null && !v.J(list)) {
            if (this.dXi) {
                this.dXh.setData(list, true);
                this.dXi = false;
            } else {
                this.dXh.setData(list, false);
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
        if (this.dXh != null) {
            this.dXh.onConfigurationChanged(configuration);
        }
    }

    private int nc(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dXp - 1) {
            i2 = 1;
            int i4 = i3 - (this.dXp - 1);
            if (i4 >= this.dXp - 1) {
                i2 = (i4 % (this.dXq - 1)) + 1;
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
        if (!this.dXh.na(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.dXh.mZ(firstVisiblePosition);
        }
        this.dXh.nb(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void mX(int i) {
        if (this.dXh != null) {
            this.dXh.mY(i - 1);
        }
    }

    public boolean lM(int i) {
        if (this.dXh == null) {
            return false;
        }
        return this.dXh.lM(i);
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
        return this.dXf.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kY() || com.baidu.tieba.video.g.bGn().bGo();
    }
}
