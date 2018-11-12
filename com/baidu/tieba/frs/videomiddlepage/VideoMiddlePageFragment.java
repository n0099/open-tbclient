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
    private String anG;
    private NoNetworkView bKI;
    private View bes;
    private PbListView dHf;
    private com.baidu.tieba.t.a dYD;
    private g dYc;
    private BdTypeRecyclerView dYu;
    private RelativeLayout dYv;
    private e dYw;
    private List<com.baidu.tieba.card.data.b> dYy;
    private c dYz;
    private com.baidu.tbadk.core.view.d dtG;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dYx = true;
    private int dYr = -1;
    private boolean dYA = false;
    private boolean dYB = false;
    int dYE = 4;
    int dYF = 7;
    int dYG = 4;
    private CustomMessageListener dYH = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.bKI != null) {
                        VideoMiddlePageFragment.this.bKI.setVisibility(8);
                    }
                    if (j.kX() && !com.baidu.tieba.video.g.bFM().bFN() && VideoMiddlePageFragment.this.dYw != null && VideoMiddlePageFragment.this.dYw.pC()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(e.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.bKI != null) {
                    VideoMiddlePageFragment.this.bKI.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dYw != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jr) {
                VideoMiddlePageFragment.this.dYw.K(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.dYc.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.dYc.YV();
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
                if (VideoMiddlePageFragment.this.dYw != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.dYw.aBo() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.dYw.aBo()) {
                        VideoMiddlePageFragment.this.dYw.aBp();
                    }
                }
            }
        }
    };
    private HashMap dYC = new HashMap();

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
        this.dYc = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dYc.setId(stringExtra);
            this.dYc.setLocation(stringExtra3);
            this.dYc.nH(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dYC.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dYC.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dYc.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.anG = arguments.getString("PARAM_FID");
        }
        if (this.dYc != null) {
            this.dYc.setFrom(this.mFrom);
            this.dYc.aFY();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dYH);
        this.dYD = new com.baidu.tieba.t.a();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(e.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(getPageContext().getPageActivity(), e.C0200e.ds88) + l.h(getPageContext().getPageActivity(), e.C0200e.tbds42)));
        this.dYu = (BdTypeRecyclerView) view.findViewById(e.g.video_middle_page_list_view);
        this.dYu.addHeaderView(this.mHeaderView);
        this.dYu.setLayoutManager(new LinearLayoutManager(getContext()));
        this.dYu.setFadingEdgeLength(0);
        this.dYu.setBackgroundColor(al.getColor(e.d.transparent));
        this.dYu.setOverScrollMode(2);
        this.dYu.setScrollable(this);
        this.dYv = (RelativeLayout) view.findViewById(e.g.container);
        this.bKI = (NoNetworkView) view.findViewById(e.g.no_network_view);
        if (!j.kV()) {
            this.bKI.setVisibility(0);
        }
        this.dHf = new PbListView(getPageContext().getPageActivity());
        this.dHf.bF(false);
        this.dHf.oE();
        this.dHf.DV();
        this.dHf.ej(e.d.cp_cont_b);
        this.dHf.setText(getResources().getString(e.j.list_has_no_more));
        this.dHf.setTextColor(e.d.cp_cont_d);
        this.dHf.ei(e.d.cp_cont_f);
        this.dYu.setNextPage(this.dHf);
        this.dHf.el(l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds804));
        this.dYu.setOnScrollListener(this.mScrollListener);
        this.dYw = new e(getPageContext(), this.dYu, this, true, this.mFrom, this.anG);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.bes = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.bes.findViewById(e.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(e.f.icon_return_bg));
        this.dYy = new ArrayList();
        this.dYz = new c();
        this.dYz.a(this.dYc);
        com.baidu.tieba.frs.aggregation.g aFV = this.dYz.aFV();
        ArrayList arrayList = new ArrayList();
        arrayList.add(aFV);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dYw != null) {
            this.dYw.hs(false);
        }
        if (!this.dYx && this.dYD != null && !this.dYD.isKeyguardLocked()) {
            mf(2);
            if (this.dYw != null && this.dYr != -1) {
                this.dYw.nt(this.dYr);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dYw != null) {
            this.dYw.hs(true);
            this.dYr = this.dYw.aBo();
        }
        mf(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dYc != null) {
            this.dYc.aBt();
        }
        if (this.dYw != null) {
            this.dYw.onDestroy();
        }
        if (this.dYz != null) {
            this.dYz.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.dtG != null) {
            this.dtG.bz(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void Mb() {
    }

    public void mf(int i) {
        if (this.dYu != null && this.dYw != null) {
            if (i == 1 && this.dYw.pC()) {
                this.dYw.pB();
            }
            if (i == 2) {
                this.dYw.pB();
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
                this.dYE = TbadkCoreApplication.getInst().getAdAdSense().aKb;
                this.dYF = TbadkCoreApplication.getInst().getAdAdSense().aKd;
                this.dYG = TbadkCoreApplication.getInst().getAdAdSense().aKc;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dYE + (-1))) % (this.dYF + (-1)) == 0;
                boolean z5 = i2 - size == this.dYG;
                if (i2 <= this.dYG) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dYc != null ? this.dYc.getPageNum() : 0, 0, "", "", nu(size));
                    a.m(this.dYC);
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
            if (!this.dYA && this.dYy.size() > 0 && this.dYc != null && this.dYc.aFZ() != null) {
                String str = this.dYc.aFZ().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.dHa.mcnLeadPage)) {
                            this.dYw.j(gVar);
                        }
                        if (this.dYy.get(0) != null) {
                            this.dYy.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.dYA = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.dYy.addAll(arrayList);
        }
        if (!this.dYB) {
            j(arrayList, z);
        }
    }

    private void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dYw != null && !v.I(list)) {
            if (this.dYx) {
                this.dYw.setData(list, true);
                this.dYx = false;
            } else {
                this.dYw.setData(list, false);
            }
        }
        if (!z) {
            this.dHf.Eb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKI.onChangeSkinType(getPageContext(), i);
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
        if (this.dYw != null) {
            this.dYw.onConfigurationChanged(configuration);
        }
    }

    private int nu(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dYE - 1) {
            i2 = 1;
            int i4 = i3 - (this.dYE - 1);
            if (i4 >= this.dYE - 1) {
                i2 = (i4 % (this.dYF - 1)) + 1;
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
            i = aU(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = aU(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.dYw.ns(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.dYw.nr(firstVisiblePosition);
        }
        this.dYw.nt(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void np(int i) {
        if (this.dYw != null) {
            this.dYw.nq(i - 1);
        }
    }

    public boolean me(int i) {
        if (this.dYw == null) {
            return false;
        }
        return this.dYw.me(i);
    }

    public int aU(View view) {
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
        return this.dYu.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kW() || com.baidu.tieba.video.g.bFM().bFN();
    }
}
