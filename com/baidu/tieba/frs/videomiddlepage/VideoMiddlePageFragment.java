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
    private String arJ;
    private NoNetworkView bPl;
    private View biG;
    private com.baidu.tbadk.core.view.d dDB;
    private PbListView dRb;
    private com.baidu.tieba.u.a eiD;
    private g eic;
    private BdTypeRecyclerView eiu;
    private RelativeLayout eiv;
    private e eiw;
    private List<com.baidu.tieba.card.data.b> eiy;
    private c eiz;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean eix = true;
    private int eir = -1;
    private boolean eiA = false;
    private boolean eiB = false;
    int eiE = 4;
    int eiF = 7;
    int eiG = 4;
    private CustomMessageListener eiH = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.bPl != null) {
                        VideoMiddlePageFragment.this.bPl.setVisibility(8);
                    }
                    if (j.kX() && !com.baidu.tieba.video.g.bJp().bJq() && VideoMiddlePageFragment.this.eiw != null && VideoMiddlePageFragment.this.eiw.pF()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(e.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.bPl != null) {
                    VideoMiddlePageFragment.this.bPl.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.eiw != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jr) {
                VideoMiddlePageFragment.this.eiw.L(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.eic.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.eic.aaA();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.bCC().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.eiw != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.eiw.aEk() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.eiw.aEk()) {
                        VideoMiddlePageFragment.this.eiw.aEl();
                    }
                }
            }
        }
    };
    private HashMap eiC = new HashMap();

    public static VideoMiddlePageFragment bI(String str, String str2) {
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
        com.baidu.tieba.q.c.bCC().r(getUniqueId());
        this.eic = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.eic.setId(stringExtra);
            this.eic.setLocation(stringExtra3);
            this.eic.oB(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.eiC.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.eiC.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.eic.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.arJ = arguments.getString("PARAM_FID");
        }
        if (this.eic != null) {
            this.eic.setFrom(this.mFrom);
            this.eic.aIX();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.eiH);
        this.eiD = new com.baidu.tieba.u.a();
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
        this.eiu = (BdTypeRecyclerView) view.findViewById(e.g.video_middle_page_list_view);
        this.eiu.addHeaderView(this.mHeaderView);
        this.eiu.setLayoutManager(new LinearLayoutManager(getContext()));
        this.eiu.setFadingEdgeLength(0);
        this.eiu.setBackgroundColor(al.getColor(e.d.transparent));
        this.eiu.setOverScrollMode(2);
        this.eiu.setScrollable(this);
        this.eiv = (RelativeLayout) view.findViewById(e.g.container);
        this.bPl = (NoNetworkView) view.findViewById(e.g.no_network_view);
        if (!j.kV()) {
            this.bPl.setVisibility(0);
        }
        this.dRb = new PbListView(getPageContext().getPageActivity());
        this.dRb.bH(false);
        this.dRb.oH();
        this.dRb.Fm();
        this.dRb.ex(e.d.cp_cont_b);
        this.dRb.setText(getResources().getString(e.j.list_has_no_more));
        this.dRb.setTextColor(e.d.cp_cont_d);
        this.dRb.ew(e.d.cp_cont_f);
        this.eiu.setNextPage(this.dRb);
        this.dRb.ez(l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds804));
        this.eiu.setOnScrollListener(this.mScrollListener);
        this.eiw = new e(getPageContext(), this.eiu, this, true, this.mFrom, this.arJ, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.biG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.biG.findViewById(e.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(e.f.icon_return_bg));
        this.eiy = new ArrayList();
        this.eiz = new c();
        this.eiz.a(this.eic);
        com.baidu.tieba.frs.aggregation.g aIU = this.eiz.aIU();
        ArrayList arrayList = new ArrayList();
        arrayList.add(aIU);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eiw != null) {
            this.eiw.hA(false);
        }
        if (!this.eix && this.eiD != null && !this.eiD.isKeyguardLocked()) {
            mJ(2);
            if (this.eiw != null && this.eir != -1) {
                this.eiw.nX(this.eir);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eiw != null) {
            this.eiw.hA(true);
            this.eir = this.eiw.aEk();
        }
        mJ(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.bCC().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.bCC().s(getUniqueId());
        if (this.eic != null) {
            this.eic.aEp();
        }
        if (this.eiw != null) {
            this.eiw.onDestroy();
        }
        if (this.eiz != null) {
            this.eiz.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.dDB != null) {
            this.dDB.bB(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void Nx() {
    }

    public void mJ(int i) {
        if (this.eiu != null && this.eiw != null) {
            if (i == 1 && this.eiw.pF()) {
                this.eiw.pE();
            }
            if (i == 2) {
                this.eiw.pE();
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
                this.eiE = TbadkCoreApplication.getInst().getAdAdSense().aOf;
                this.eiF = TbadkCoreApplication.getInst().getAdAdSense().aOh;
                this.eiG = TbadkCoreApplication.getInst().getAdAdSense().aOg;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.eiE + (-1))) % (this.eiF + (-1)) == 0;
                boolean z5 = i2 - size == this.eiG;
                if (i2 <= this.eiG) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.eic != null ? this.eic.getPageNum() : 0, 0, "", "", nY(size));
                    a.m(this.eiC);
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
            if (!this.eiA && this.eiy.size() > 0 && this.eic != null && this.eic.aIY() != null) {
                String str = this.eic.aIY().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.dQW.mcnLeadPage)) {
                            this.eiw.j(gVar);
                        }
                        if (this.eiy.get(0) != null) {
                            this.eiy.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.eiA = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.eiy.addAll(arrayList);
        }
        if (!this.eiB) {
            j(arrayList, z);
        }
    }

    private void j(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.eiw != null && !v.I(list)) {
            if (this.eix) {
                this.eiw.setData(list, true);
                this.eix = false;
            } else {
                this.eiw.setData(list, false);
            }
        }
        if (!z) {
            this.dRb.Fs();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPl.onChangeSkinType(getPageContext(), i);
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
        if (this.eiw != null) {
            this.eiw.onConfigurationChanged(configuration);
        }
    }

    private int nY(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.eiE - 1) {
            i2 = 1;
            int i4 = i3 - (this.eiE - 1);
            if (i4 >= this.eiE - 1) {
                i2 = (i4 % (this.eiF - 1)) + 1;
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
        if (!this.eiw.nW(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.eiw.nV(firstVisiblePosition);
        }
        this.eiw.nX(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void nT(int i) {
        if (this.eiw != null) {
            this.eiw.nU(i - 1);
        }
    }

    public boolean mI(int i) {
        if (this.eiw == null) {
            return false;
        }
        return this.eiw.mI(i);
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
        return this.eiu.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kW() || com.baidu.tieba.video.g.bJp().bJq();
    }
}
