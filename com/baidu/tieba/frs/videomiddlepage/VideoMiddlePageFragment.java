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
/* loaded from: classes4.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private String bGR;
    private LinearLayoutManager bpJ;
    private View cCf;
    private NoNetworkView dnF;
    private PbListView fAd;
    private h fSW;
    private BdTypeRecyclerView fTq;
    private RelativeLayout fTr;
    private f fTs;
    private List<com.baidu.tieba.card.data.b> fTu;
    private d fTv;
    private com.baidu.tieba.t.b fTz;
    private com.baidu.tbadk.core.view.b flO;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean fTt = true;
    private int fTm = -1;
    private boolean fTw = false;
    private boolean fTx = false;
    int fTA = 4;
    int fTB = 7;
    int fTC = 4;
    private CustomMessageListener fTD = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                if (j.kc()) {
                    if (VideoMiddlePageFragment.this.dnF != null) {
                        VideoMiddlePageFragment.this.dnF.setVisibility(8);
                    }
                    if (j.ke() && !com.baidu.tieba.video.g.ctE().ctF()) {
                        if (VideoMiddlePageFragment.this.fTs == null || !VideoMiddlePageFragment.this.fTs.po()) {
                            if (VideoMiddlePageFragment.this.fTs != null && VideoMiddlePageFragment.this.fTs.btb()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.dnF != null) {
                    VideoMiddlePageFragment.this.dnF.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.fTs != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Hs) {
                VideoMiddlePageFragment.this.fTs.al(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.fSW.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.fSW.aIQ();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.coo().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.fTs != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.fTs.bon() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.fTs.bon()) {
                        VideoMiddlePageFragment.this.fTs.boo();
                    }
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.fTs != null) {
                VideoMiddlePageFragment.this.fTs.notifyDataSetChanged();
            }
        }
    };
    private HashMap fTy = new HashMap();

    public static VideoMiddlePageFragment de(String str, String str2) {
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
        com.baidu.tieba.q.c.coo().u(getUniqueId());
        this.fSW = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.fSW.setId(stringExtra);
            this.fSW.setLocation(stringExtra3);
            this.fSW.xb(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.fTy.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.fTy.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.fSW.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.bGR = arguments.getString("PARAM_FID");
        }
        if (this.fSW != null) {
            this.fSW.setFrom(this.mFrom);
            this.fSW.btq();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.fTD);
        registerListener(this.fvs);
        this.fTz = new com.baidu.tieba.t.b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.bpJ = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(getPageContext().getPageActivity(), R.dimen.ds88) + l.g(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.fTq = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.fTq.addHeaderView(this.mHeaderView);
        this.fTq.setLayoutManager(this.bpJ);
        this.fTq.setFadingEdgeLength(0);
        this.fTq.setBackgroundColor(am.getColor(R.color.transparent));
        this.fTq.setOverScrollMode(2);
        this.fTq.setScrollable(this);
        this.fTr = (RelativeLayout) view.findViewById(R.id.container);
        this.dnF = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.kc()) {
            this.dnF.setVisibility(0);
        }
        this.fAd = new PbListView(getPageContext().getPageActivity());
        this.fAd.eq(false);
        this.fAd.nZ();
        this.fAd.akA();
        this.fAd.iU(R.color.cp_cont_b);
        this.fAd.setText(getResources().getString(R.string.list_has_no_more));
        this.fAd.setTextColor(R.color.cp_cont_d);
        this.fAd.iT(R.color.cp_cont_f);
        this.fTq.setNextPage(this.fAd);
        this.fAd.iW(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.fTq.setOnScrollListener(this.mScrollListener);
        this.fTs = new f(getPageContext(), this.fTq, this, true, this.mFrom, this.bGR, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.cCf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.cCf.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.fTu = new ArrayList();
        this.fTv = new d();
        this.fTv.a(this.fSW);
        com.baidu.tieba.frs.aggregation.g btl = this.fTv.btl();
        ArrayList arrayList = new ArrayList();
        arrayList.add(btl);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fTs != null) {
            this.fTs.kW(false);
        }
        if (!this.fTt) {
            rS(2);
            if (!this.fTs.btb() && this.fTs != null && this.fTm != -1) {
                this.fTs.tk(this.fTm);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fTs != null) {
            this.fTs.kW(true);
            this.fTm = this.fTs.bon();
        }
        rS(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.coo().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        if (this.fSW != null) {
            this.fSW.bos();
        }
        if (this.fTs != null) {
            this.fTs.onDestroy();
        }
        if (this.fTv != null) {
            this.fTv.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.flO != null) {
            this.flO.ej(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void ati() {
    }

    public void rS(int i) {
        if (this.fTq != null && this.fTs != null) {
            if (i == 1) {
                if (this.fTs.btb()) {
                    this.fTs.bto();
                } else if (this.fTs.po()) {
                    this.fTs.pn();
                }
            }
            if (i == 2) {
                this.fTs.pn();
                if (this.fTs.btb()) {
                    this.fTs.btp();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void d(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!v.aa(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.fTA = TbadkCoreApplication.getInst().getAdAdSense().cfI;
                this.fTB = TbadkCoreApplication.getInst().getAdAdSense().cfK;
                this.fTC = TbadkCoreApplication.getInst().getAdAdSense().cfJ;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.fTA + (-1))) % (this.fTB + (-1)) == 0;
                boolean z5 = i2 - size == this.fTC;
                if (i2 <= this.fTC) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.fSW != null ? this.fSW.getPageNum() : 0, 0, "", "", tl(size));
                    a.k(this.fTy);
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
            if (!this.fTw && this.fTu.size() > 0 && this.fSW != null && this.fSW.btr() != null) {
                String str = this.fSW.btr().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.fzQ.mcnLeadPage) || (gVar.fzQ.fAa != null && gVar.fzQ.fAa.isValid())) {
                            this.fTs.j(gVar);
                        }
                        if (this.fTu.get(0) != null) {
                            this.fTu.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.fTw = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.fTu.addAll(arrayList);
        }
        if (!this.fTx) {
            l(arrayList, z);
        }
    }

    private void l(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.fTs != null && !v.aa(list)) {
            if (this.fTt) {
                this.fTs.setData(list, true);
                this.fTt = false;
            } else {
                this.fTs.setData(list, false);
            }
        }
        if (!z) {
            this.fAd.akG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dnF.onChangeSkinType(getPageContext(), i);
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
        if (this.fTs != null) {
            this.fTs.onConfigurationChanged(configuration);
        }
    }

    private int tl(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.fTA - 1) {
            i2 = 1;
            int i4 = i3 - (this.fTA - 1);
            if (i4 >= this.fTA - 1) {
                i2 = (i4 % (this.fTB - 1)) + 1;
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
            i = bY(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = bY(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.fTs.tj(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.fTs.ti(firstVisiblePosition);
        }
        this.fTs.tk(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void tg(int i) {
        if (this.fTs != null) {
            this.fTs.th(i - 1);
        }
    }

    public boolean rR(int i) {
        if (this.fTs == null) {
            return false;
        }
        return this.fTs.rR(i);
    }

    public int bY(View view) {
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
        return this.fTq.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.kd() || com.baidu.tieba.video.g.ctE().ctF();
    }
}
