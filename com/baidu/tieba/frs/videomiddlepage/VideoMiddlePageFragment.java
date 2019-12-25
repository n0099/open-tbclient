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
/* loaded from: classes6.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private String cKC;
    private LinearLayoutManager ctr;
    private View dBy;
    private NoNetworkView egT;
    private h gIF;
    private BdTypeRecyclerView gJa;
    private RelativeLayout gJb;
    private f gJc;
    private List<com.baidu.tieba.card.data.b> gJe;
    private com.baidu.tbadk.core.view.a gJf;
    private d gJg;
    private com.baidu.tieba.u.b gJk;
    private PbListView gpB;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean gJd = true;
    private int gIW = -1;
    private boolean gJh = false;
    private boolean gJi = false;
    int gJl = 4;
    int gJm = 7;
    int gJn = 4;
    private CustomMessageListener gJo = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener cHi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.egT != null) {
                        VideoMiddlePageFragment.this.egT.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.cMD().cME()) {
                        if (VideoMiddlePageFragment.this.gJc == null || !VideoMiddlePageFragment.this.gJc.kB()) {
                            if (VideoMiddlePageFragment.this.gJc != null && VideoMiddlePageFragment.this.gJc.bIE()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.egT != null) {
                    VideoMiddlePageFragment.this.egT.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.gJc != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.gJc.al(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.gIF.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.gIF.aZs();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.r.c.cHo().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.gJc != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.gJc.bDL() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.gJc.bDL()) {
                        VideoMiddlePageFragment.this.gJc.bDM();
                    }
                }
            }
        }
    };
    private CustomMessageListener gkx = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.gJc != null) {
                VideoMiddlePageFragment.this.gJc.notifyDataSetChanged();
            }
        }
    };
    private HashMap gJj = new HashMap();

    public static VideoMiddlePageFragment dk(String str, String str2) {
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
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
        this.gIF = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.gIF.setId(stringExtra);
            this.gIF.setLocation(stringExtra3);
            this.gIF.AK(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.gJj.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.gJj.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.gIF.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.cKC = arguments.getString("PARAM_FID");
        }
        if (this.gIF != null) {
            this.gIF.setFrom(this.mFrom);
            this.gIF.bIT();
        }
        registerListener(this.cHi);
        registerListener(this.cVS);
        registerListener(this.gJo);
        registerListener(this.gkx);
        this.gJk = new com.baidu.tieba.u.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.ctr = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.gJa = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.gJa.addHeaderView(this.mHeaderView);
        this.gJa.setLayoutManager(this.ctr);
        this.gJa.setFadingEdgeLength(0);
        this.gJa.setBackgroundColor(am.getColor(R.color.transparent));
        this.gJa.setOverScrollMode(2);
        this.gJa.setScrollable(this);
        this.gJb = (RelativeLayout) view.findViewById(R.id.container);
        this.egT = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.egT.setVisibility(0);
        }
        this.gpB = new PbListView(getPageContext().getPageActivity());
        this.gpB.setIsMoreViewVisible(false);
        this.gpB.createView();
        this.gpB.setLineGone();
        this.gpB.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.gpB.setText(getResources().getString(R.string.list_has_no_more));
        this.gpB.setTextColor(R.color.cp_cont_d);
        this.gpB.setNoMoreTextColorId(R.color.cp_cont_f);
        this.gJa.setNextPage(this.gpB);
        this.gpB.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.gJa.setOnScrollListener(this.mScrollListener);
        this.gJc = new f(getPageContext(), this.gJa, this, true, this.mFrom, this.cKC, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.dBy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.dBy.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.gJe = new ArrayList();
        this.gJg = new d();
        this.gJg.a(this.gIF);
        com.baidu.tieba.frs.aggregation.g bIO = this.gJg.bIO();
        ArrayList arrayList = new ArrayList();
        arrayList.add(bIO);
        e(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gJc != null) {
            this.gJc.ma(false);
        }
        if (!this.gJd) {
            sV(2);
            if (!this.gJc.bIE() && this.gJc != null && this.gIW != -1) {
                this.gJc.ur(this.gIW);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gJc != null) {
            this.gJc.ma(true);
            this.gIW = this.gJc.bDL();
        }
        sV(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        if (this.gIF != null) {
            this.gIF.bDP();
        }
        if (this.gJc != null) {
            this.gJc.onDestroy();
        }
        if (this.gJg != null) {
            this.gJg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.gJf != null) {
            this.gJf.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void Py() {
    }

    public void sV(int i) {
        if (this.gJa != null && this.gJc != null) {
            if (i == 1) {
                if (this.gJc.bIE()) {
                    this.gJc.bIR();
                } else if (this.gJc.kB()) {
                    this.gJc.kA();
                }
            }
            if (i == 2) {
                this.gJc.kA();
                if (this.gJc.bIE()) {
                    this.gJc.bIS();
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
                this.gJl = TbadkCoreApplication.getInst().getAdAdSense().dhB;
                this.gJm = TbadkCoreApplication.getInst().getAdAdSense().dhD;
                this.gJn = TbadkCoreApplication.getInst().getAdAdSense().dhC;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.gJl + (-1))) % (this.gJm + (-1)) == 0;
                boolean z5 = i2 - size == this.gJn;
                if (i2 <= this.gJn) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.gIF != null ? this.gIF.getPageNum() : 0, 0, "", "", us(size));
                    a.j(this.gJj);
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
            if (!this.gJh && this.gJe.size() > 0 && this.gIF != null && this.gIF.bIU() != null) {
                String str = this.gIF.bIU().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.gpn.mcnLeadPage) || (gVar.gpn.gpy != null && gVar.gpn.gpy.isValid())) {
                            this.gJc.l(gVar);
                        }
                        if (this.gJe.get(0) != null) {
                            this.gJe.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.gJh = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.gJe.addAll(arrayList);
        }
        if (!this.gJi) {
            m(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo bIU;
        return (!"0".equals(gVar.threadId) || this.gIF == null || this.gIF.bIU() == null || (bIU = this.gIF.bIU()) == null || bIU.video == null || !TextUtils.equals(bIU.title, gVar.title) || !TextUtils.equals(bIU.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void m(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.gJc != null && !v.isEmpty(list)) {
            if (this.gJd) {
                this.gJc.setData(list, true);
                this.gJd = false;
            } else {
                this.gJc.setData(list, false);
            }
        }
        if (!z) {
            this.gpB.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.egT.onChangeSkinType(getPageContext(), i);
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
        if (this.gJc != null) {
            this.gJc.onConfigurationChanged(configuration);
        }
    }

    private int us(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.gJl - 1) {
            i2 = 1;
            int i4 = i3 - (this.gJl - 1);
            if (i4 >= this.gJl - 1) {
                i2 = (i4 % (this.gJm - 1)) + 1;
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
            i = bR(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = bR(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.gJc.uq(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.gJc.up(firstVisiblePosition);
        }
        this.gJc.ur(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void un(int i) {
        if (this.gJc != null) {
            this.gJc.uo(i - 1);
        }
    }

    public boolean sU(int i) {
        if (this.gJc == null) {
            return false;
        }
        return this.gJc.sU(i);
    }

    public int bR(View view) {
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
        return this.gJa.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.cMD().cME();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rp("cyber_player_test");
    }
}
