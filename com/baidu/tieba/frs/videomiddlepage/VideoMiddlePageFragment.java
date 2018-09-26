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
    private View aZe;
    private String ahY;
    private NoNetworkView bBq;
    private g dOT;
    private BdTypeRecyclerView dPk;
    private RelativeLayout dPl;
    private e dPm;
    private List<com.baidu.tieba.card.data.b> dPo;
    private c dPp;
    private com.baidu.tieba.t.a dPt;
    private com.baidu.tbadk.core.view.d dkx;
    private PbListView dxP;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dPn = true;
    private int dPh = -1;
    private boolean dPq = false;
    private boolean dPr = false;
    int dPu = 4;
    int dPv = 7;
    int dPw = 4;
    private CustomMessageListener dPx = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                if (j.kK()) {
                    if (VideoMiddlePageFragment.this.bBq != null) {
                        VideoMiddlePageFragment.this.bBq.setVisibility(8);
                    }
                    if (j.kM() && !com.baidu.tieba.video.g.bCZ().bDa() && VideoMiddlePageFragment.this.dPm != null && VideoMiddlePageFragment.this.dPm.pw()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(e.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.bBq != null) {
                    VideoMiddlePageFragment.this.bBq.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dPm != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.IM) {
                VideoMiddlePageFragment.this.dPm.D(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.dOT.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.dOT.Vd();
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
                if (VideoMiddlePageFragment.this.dPm != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.dPm.ayx() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.dPm.ayx()) {
                        VideoMiddlePageFragment.this.dPm.ayy();
                    }
                }
            }
        }
    };
    private HashMap dPs = new HashMap();

    public static VideoMiddlePageFragment bq(String str, String str2) {
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
        this.dOT = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dOT.setId(stringExtra);
            this.dOT.setLocation(stringExtra3);
            this.dOT.ne(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dPs.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dPs.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dOT.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.ahY = arguments.getString("PARAM_FID");
        }
        if (this.dOT != null) {
            this.dOT.setFrom(this.mFrom);
            this.dOT.aDi();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dPx);
        this.dPt = new com.baidu.tieba.t.a();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(e.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(getPageContext().getPageActivity(), e.C0141e.ds88) + l.h(getPageContext().getPageActivity(), e.C0141e.tbds42)));
        this.dPk = (BdTypeRecyclerView) view.findViewById(e.g.video_middle_page_list_view);
        this.dPk.addHeaderView(this.mHeaderView);
        this.dPk.setLayoutManager(new LinearLayoutManager(getContext()));
        this.dPk.setFadingEdgeLength(0);
        this.dPk.setBackgroundColor(al.getColor(e.d.transparent));
        this.dPk.setOverScrollMode(2);
        this.dPk.setScrollable(this);
        this.dPl = (RelativeLayout) view.findViewById(e.g.container);
        this.bBq = (NoNetworkView) view.findViewById(e.g.no_network_view);
        if (!j.kK()) {
            this.bBq.setVisibility(0);
        }
        this.dxP = new PbListView(getPageContext().getPageActivity());
        this.dxP.be(false);
        this.dxP.ov();
        this.dxP.BF();
        this.dxP.dL(e.d.cp_cont_b);
        this.dxP.setText(getResources().getString(e.j.list_has_no_more));
        this.dxP.setTextColor(e.d.cp_cont_d);
        this.dxP.dK(e.d.cp_cont_f);
        this.dPk.setNextPage(this.dxP);
        this.dxP.dN(l.h(TbadkCoreApplication.getInst(), e.C0141e.tbds804));
        this.dPk.setOnScrollListener(this.mScrollListener);
        this.dPm = new e(getPageContext(), this.dPk, this, true, this.mFrom, this.ahY);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.aZe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.aZe.findViewById(e.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(e.f.icon_return_bg));
        this.dPo = new ArrayList();
        this.dPp = new c();
        this.dPp.a(this.dOT);
        com.baidu.tieba.frs.aggregation.g aDf = this.dPp.aDf();
        ArrayList arrayList = new ArrayList();
        arrayList.add(aDf);
        b(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dPm != null) {
            this.dPm.gQ(false);
        }
        if (!this.dPn && this.dPt != null && !this.dPt.isKeyguardLocked()) {
            lp(2);
            if (this.dPm != null && this.dPh != -1) {
                this.dPm.mD(this.dPh);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dPm != null) {
            this.dPm.gQ(true);
            this.dPh = this.dPm.ayx();
        }
        lp(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dOT != null) {
            this.dOT.ayC();
        }
        if (this.dPm != null) {
            this.dPm.onDestroy();
        }
        if (this.dPp != null) {
            this.dPp.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.dkx != null) {
            this.dkx.aZ(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void JR() {
    }

    public void lp(int i) {
        if (this.dPk != null && this.dPm != null) {
            if (i == 1 && this.dPm.pw()) {
                this.dPm.pv();
            }
            if (i == 2) {
                this.dPm.pv();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void b(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!v.z(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.dPu = TbadkCoreApplication.getInst().getAdAdSense().aEH;
                this.dPv = TbadkCoreApplication.getInst().getAdAdSense().aEJ;
                this.dPw = TbadkCoreApplication.getInst().getAdAdSense().aEI;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dPu + (-1))) % (this.dPv + (-1)) == 0;
                boolean z5 = i2 - size == this.dPw;
                if (i2 <= this.dPw) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dOT != null ? this.dOT.getPageNum() : 0, 0, "", "", mE(size));
                    a.m(this.dPs);
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
            if (!this.dPq && this.dPo.size() > 0 && this.dOT != null && this.dOT.aDj() != null) {
                String str = this.dOT.aDj().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.dPo.get(0) != null) {
                            this.dPo.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.dPq = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.dPo.addAll(arrayList);
        }
        if (!this.dPr) {
            i(arrayList, z);
        }
    }

    private void i(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dPm != null && !v.z(list)) {
            if (this.dPn) {
                this.dPm.setData(list, true);
                this.dPn = false;
            } else {
                this.dPm.setData(list, false);
            }
        }
        if (!z) {
            this.dxP.BL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bBq.onChangeSkinType(getPageContext(), i);
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
        if (this.dPm != null) {
            this.dPm.onConfigurationChanged(configuration);
        }
    }

    private int mE(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dPu - 1) {
            i2 = 1;
            int i4 = i3 - (this.dPu - 1);
            if (i4 >= this.dPu - 1) {
                i2 = (i4 % (this.dPv - 1)) + 1;
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
        if (!this.dPm.mC(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.dPm.mB(firstVisiblePosition);
        }
        this.dPm.mD(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void mz(int i) {
        if (this.dPm != null) {
            this.dPm.mA(i - 1);
        }
    }

    public boolean lo(int i) {
        if (this.dPm == null) {
            return false;
        }
        return this.dPm.lo(i);
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
        return this.dPk.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kL() || com.baidu.tieba.video.g.bCZ().bDa();
    }
}
