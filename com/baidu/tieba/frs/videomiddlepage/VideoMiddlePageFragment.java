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
    private String arh;
    private NoNetworkView bOA;
    private View bhV;
    private com.baidu.tbadk.core.view.d dCS;
    private PbListView dQs;
    private BdTypeRecyclerView ehO;
    private RelativeLayout ehP;
    private e ehQ;
    private List<com.baidu.tieba.card.data.b> ehS;
    private c ehT;
    private com.baidu.tieba.u.a ehX;
    private g ehw;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean ehR = true;
    private int ehL = -1;
    private boolean ehU = false;
    private boolean ehV = false;
    int ehY = 4;
    int ehZ = 7;
    int eia = 4;
    private CustomMessageListener eib = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                if (j.kV()) {
                    if (VideoMiddlePageFragment.this.bOA != null) {
                        VideoMiddlePageFragment.this.bOA.setVisibility(8);
                    }
                    if (j.kX() && !com.baidu.tieba.video.g.bIG().bIH() && VideoMiddlePageFragment.this.ehQ != null && VideoMiddlePageFragment.this.ehQ.pB()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(e.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.bOA != null) {
                    VideoMiddlePageFragment.this.bOA.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.ehQ != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jr) {
                VideoMiddlePageFragment.this.ehQ.M(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.ehw.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.ehw.aad();
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
                if (VideoMiddlePageFragment.this.ehQ != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.ehQ.aDN() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.ehQ.aDN()) {
                        VideoMiddlePageFragment.this.ehQ.aDO();
                    }
                }
            }
        }
    };
    private HashMap ehW = new HashMap();

    public static VideoMiddlePageFragment bH(String str, String str2) {
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
        this.ehw = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.ehw.setId(stringExtra);
            this.ehw.setLocation(stringExtra3);
            this.ehw.ok(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.ehW.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.ehW.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.ehw.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.arh = arguments.getString("PARAM_FID");
        }
        if (this.ehw != null) {
            this.ehw.setFrom(this.mFrom);
            this.ehw.aIz();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.eib);
        this.ehX = new com.baidu.tieba.u.a();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(e.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(getPageContext().getPageActivity(), e.C0210e.ds88) + l.h(getPageContext().getPageActivity(), e.C0210e.tbds42)));
        this.ehO = (BdTypeRecyclerView) view.findViewById(e.g.video_middle_page_list_view);
        this.ehO.addHeaderView(this.mHeaderView);
        this.ehO.setLayoutManager(new LinearLayoutManager(getContext()));
        this.ehO.setFadingEdgeLength(0);
        this.ehO.setBackgroundColor(al.getColor(e.d.transparent));
        this.ehO.setOverScrollMode(2);
        this.ehO.setScrollable(this);
        this.ehP = (RelativeLayout) view.findViewById(e.g.container);
        this.bOA = (NoNetworkView) view.findViewById(e.g.no_network_view);
        if (!j.kV()) {
            this.bOA.setVisibility(0);
        }
        this.dQs = new PbListView(getPageContext().getPageActivity());
        this.dQs.bG(false);
        this.dQs.oD();
        this.dQs.EZ();
        this.dQs.ex(e.d.cp_cont_b);
        this.dQs.setText(getResources().getString(e.j.list_has_no_more));
        this.dQs.setTextColor(e.d.cp_cont_d);
        this.dQs.ew(e.d.cp_cont_f);
        this.ehO.setNextPage(this.dQs);
        this.dQs.ez(l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds804));
        this.ehO.setOnScrollListener(this.mScrollListener);
        this.ehQ = new e(getPageContext(), this.ehO, this, true, this.mFrom, this.arh);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.bhV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.bhV.findViewById(e.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(e.f.icon_return_bg));
        this.ehS = new ArrayList();
        this.ehT = new c();
        this.ehT.a(this.ehw);
        com.baidu.tieba.frs.aggregation.g aIw = this.ehT.aIw();
        ArrayList arrayList = new ArrayList();
        arrayList.add(aIw);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ehQ != null) {
            this.ehQ.hx(false);
        }
        if (!this.ehR && this.ehX != null && !this.ehX.isKeyguardLocked()) {
            mI(2);
            if (this.ehQ != null && this.ehL != -1) {
                this.ehQ.nW(this.ehL);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ehQ != null) {
            this.ehQ.hx(true);
            this.ehL = this.ehQ.aDN();
        }
        mI(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ehw != null) {
            this.ehw.aDS();
        }
        if (this.ehQ != null) {
            this.ehQ.onDestroy();
        }
        if (this.ehT != null) {
            this.ehT.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.dCS != null) {
            this.dCS.bA(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void Ng() {
    }

    public void mI(int i) {
        if (this.ehO != null && this.ehQ != null) {
            if (i == 1 && this.ehQ.pB()) {
                this.ehQ.pA();
            }
            if (i == 2) {
                this.ehQ.pA();
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
        if (!v.I(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.ehY = TbadkCoreApplication.getInst().getAdAdSense().aND;
                this.ehZ = TbadkCoreApplication.getInst().getAdAdSense().aNF;
                this.eia = TbadkCoreApplication.getInst().getAdAdSense().aNE;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.ehY + (-1))) % (this.ehZ + (-1)) == 0;
                boolean z5 = i2 - size == this.eia;
                if (i2 <= this.eia) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.ehw != null ? this.ehw.getPageNum() : 0, 0, "", "", nX(size));
                    a.m(this.ehW);
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
            if (!this.ehU && this.ehS.size() > 0 && this.ehw != null && this.ehw.aIA() != null) {
                String str = this.ehw.aIA().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.dQn.mcnLeadPage)) {
                            this.ehQ.j(gVar);
                        }
                        if (this.ehS.get(0) != null) {
                            this.ehS.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.ehU = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.ehS.addAll(arrayList);
        }
        if (!this.ehV) {
            j(arrayList, z);
        }
    }

    private void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.ehQ != null && !v.I(list)) {
            if (this.ehR) {
                this.ehQ.setData(list, true);
                this.ehR = false;
            } else {
                this.ehQ.setData(list, false);
            }
        }
        if (!z) {
            this.dQs.Ff();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bOA.onChangeSkinType(getPageContext(), i);
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
        if (this.ehQ != null) {
            this.ehQ.onConfigurationChanged(configuration);
        }
    }

    private int nX(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.ehY - 1) {
            i2 = 1;
            int i4 = i3 - (this.ehY - 1);
            if (i4 >= this.ehY - 1) {
                i2 = (i4 % (this.ehZ - 1)) + 1;
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
            i = aX(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = aX(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.ehQ.nV(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.ehQ.nU(firstVisiblePosition);
        }
        this.ehQ.nW(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void nS(int i) {
        if (this.ehQ != null) {
            this.ehQ.nT(i - 1);
        }
    }

    public boolean mH(int i) {
        if (this.ehQ == null) {
            return false;
        }
        return this.ehQ.mH(i);
    }

    public int aX(View view) {
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
        return this.ehO.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kW() || com.baidu.tieba.video.g.bIG().bIH();
    }
}
