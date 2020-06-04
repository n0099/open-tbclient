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
import com.baidu.adp.widget.ListView.r;
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
    private String dCp;
    private LinearLayoutManager dhU;
    private View eun;
    private NoNetworkView fci;
    private h hOR;
    private BdTypeRecyclerView hPm;
    private RelativeLayout hPn;
    private f hPo;
    private List<com.baidu.tieba.card.data.b> hPq;
    private com.baidu.tbadk.core.view.a hPr;
    private d hPs;
    private com.baidu.tieba.v.b hPw;
    private int hPx;
    private PbListView htT;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean hPp = true;
    private int hPi = -1;
    private boolean hPt = false;
    private boolean hPu = false;
    int hPy = 4;
    int hPz = 7;
    int hPA = 4;
    private CustomMessageListener hPB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.fci != null) {
                        VideoMiddlePageFragment.this.fci.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dhZ().dia()) {
                        if (VideoMiddlePageFragment.this.hPo == null || !VideoMiddlePageFragment.this.hPo.pB()) {
                            if (VideoMiddlePageFragment.this.hPo != null && VideoMiddlePageFragment.this.hPo.ccJ()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.fci != null) {
                    VideoMiddlePageFragment.this.fci.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.hPo != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.hPo.aE(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.hOR.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.hOR.bqx();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dcI().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.hPo != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.hPo.bXC() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.hPo.bXC()) {
                        VideoMiddlePageFragment.this.hPo.bXD();
                    }
                }
            }
        }
    };
    private CustomMessageListener hoT = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.hPo != null) {
                VideoMiddlePageFragment.this.hPo.notifyDataSetChanged();
            }
        }
    };
    private HashMap hPv = new HashMap();

    public static VideoMiddlePageFragment ej(String str, String str2) {
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
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
        this.hOR = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.hOR.setId(stringExtra);
            this.hOR.setLocation(stringExtra3);
            this.hOR.EI(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.hPv.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.hPv.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.hOR.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.dCp = arguments.getString("PARAM_FID");
        }
        if (this.hOR != null) {
            this.hOR.setFrom(this.mFrom);
            this.hOR.ccZ();
        }
        registerListener(this.dyW);
        registerListener(this.dNP);
        registerListener(this.hPB);
        registerListener(this.hoT);
        this.hPw = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dhU = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.hPm = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.hPm.addHeaderView(this.mHeaderView);
        this.hPm.setLayoutManager(this.dhU);
        this.hPm.setFadingEdgeLength(0);
        this.hPm.setBackgroundColor(am.getColor(R.color.transparent));
        this.hPm.setOverScrollMode(2);
        this.hPm.setScrollable(this);
        this.hPn = (RelativeLayout) view.findViewById(R.id.container);
        this.fci = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.fci.setVisibility(0);
        }
        this.htT = new PbListView(getPageContext().getPageActivity());
        this.htT.setIsMoreViewVisible(false);
        this.htT.createView();
        this.htT.setLineGone();
        this.htT.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.htT.setText(getResources().getString(R.string.list_has_no_more));
        this.htT.setTextColor(R.color.cp_cont_d);
        this.htT.setNoMoreTextColorId(R.color.cp_cont_f);
        this.hPm.setNextPage(this.htT);
        this.htT.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.hPm.setOnScrollListener(this.mScrollListener);
        this.hPo = new f(getPageContext(), this.hPm, this, true, this.mFrom, this.dCp, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.eun.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.hPq = new ArrayList();
        this.hPs = new d();
        this.hPs.a(this.hOR);
        com.baidu.tieba.frs.aggregation.g ccT = this.hPs.ccT();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ccT);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hPo != null) {
            this.hPo.nS(false);
        }
        if (!this.hPp) {
            un(2);
            if (!this.hPo.ccJ() && this.hPo != null && this.hPi != -1) {
                this.hPo.vP(this.hPi);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hPo != null) {
            this.hPo.nS(true);
            this.hPi = this.hPo.bXC();
        }
        un(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        if (this.hOR != null) {
            this.hOR.bXG();
        }
        if (this.hPo != null) {
            this.hPo.onDestroy();
        }
        if (this.hPs != null) {
            this.hPs.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.hPr != null) {
            this.hPr.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void adb() {
    }

    public void un(int i) {
        if (this.hPm != null && this.hPo != null) {
            if (i == 1) {
                if (this.hPo.ccJ()) {
                    this.hPo.ccW();
                } else if (this.hPo.pB()) {
                    this.hPo.pA();
                }
            }
            if (i == 2) {
                this.hPo.pA();
                if (this.hPo.ccJ()) {
                    this.hPo.ccX();
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
                this.hPy = TbadkCoreApplication.getInst().getAdAdSense().eaK;
                this.hPz = TbadkCoreApplication.getInst().getAdAdSense().eaM;
                this.hPA = TbadkCoreApplication.getInst().getAdAdSense().eaL;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.hPy + (-1))) % (this.hPz + (-1)) == 0;
                boolean z5 = i2 - size == this.hPA;
                if (i2 <= this.hPA) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.hOR != null ? this.hOR.getPageNum() : 0, 0, "", "", vQ(size));
                    a.w(this.hPv);
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
            if (!this.hPt && this.hPq.size() > 0 && this.hOR != null && this.hOR.cda() != null) {
                String str = this.hOR.cda().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.htF.mcnLeadPage) || (gVar.htF.htQ != null && gVar.htF.htQ.isValid())) {
                            this.hPo.l(gVar);
                        }
                        if (this.hPq.get(0) != null) {
                            this.hPq.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.hPt = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.hPq.addAll(arrayList);
        }
        if (!this.hPu) {
            o(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cda;
        return (!"0".equals(gVar.threadId) || this.hOR == null || this.hOR.cda() == null || (cda = this.hOR.cda()) == null || cda.video == null || !TextUtils.equals(cda.title, gVar.title) || !TextUtils.equals(cda.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.hPo != null && !v.isEmpty(list)) {
            if (this.hPp) {
                this.hPo.setData(list, true);
                this.hPp = false;
            } else {
                this.hPo.setData(list, false);
            }
        }
        if (!z) {
            this.htT.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fci.onChangeSkinType(getPageContext(), i);
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
            if (ccY() != null) {
                this.hPx = ccY().getView().getTop();
            }
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.hPo != null) {
            this.hPo.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && ccY() != null && (top2 = ccY().getView().getTop()) != this.hPx) {
            this.hPm.scrollBy(0, top2 - this.hPx);
            this.hPx = top2;
        }
    }

    private int vQ(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.hPy - 1) {
            i2 = 1;
            int i4 = i3 - (this.hPy - 1);
            if (i4 >= this.hPy - 1) {
                i2 = (i4 % (this.hPz - 1)) + 1;
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
            i = ce(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = ce(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.hPo.vO(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.hPo.vN(firstVisiblePosition);
        }
        this.hPo.vP(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void vL(int i) {
        if (this.hPo != null) {
            this.hPo.vM(i - 1);
        }
    }

    public boolean um(int i) {
        if (this.hPo == null) {
            return false;
        }
        return this.hPo.um(i);
    }

    public int ce(View view) {
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
    public r onGetPreLoadListView() {
        return this.hPm.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dhZ().dia();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
    }

    public a ccY() {
        if (this.hPo != null) {
            return this.hPo.ccY();
        }
        return null;
    }
}
