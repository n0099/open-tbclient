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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private String bFQ;
    private LinearLayoutManager boW;
    private View cAO;
    private NoNetworkView dlX;
    private h fNZ;
    private com.baidu.tieba.t.b fOC;
    private BdTypeRecyclerView fOt;
    private RelativeLayout fOu;
    private f fOv;
    private List<com.baidu.tieba.card.data.b> fOx;
    private d fOy;
    private com.baidu.tbadk.core.view.b fgM;
    private PbListView fvh;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean fOw = true;
    private int fOp = -1;
    private boolean fOz = false;
    private boolean fOA = false;
    int fOD = 4;
    int fOE = 7;
    int fOF = 4;
    private CustomMessageListener fOG = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                if (j.jS()) {
                    if (VideoMiddlePageFragment.this.dlX != null) {
                        VideoMiddlePageFragment.this.dlX.setVisibility(8);
                    }
                    if (j.jU() && !com.baidu.tieba.video.g.cqT().cqU()) {
                        if (VideoMiddlePageFragment.this.fOv == null || !VideoMiddlePageFragment.this.fOv.oT()) {
                            if (VideoMiddlePageFragment.this.fOv != null && VideoMiddlePageFragment.this.fOv.bra()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.dlX != null) {
                    VideoMiddlePageFragment.this.dlX.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.fOv != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Hh) {
                VideoMiddlePageFragment.this.fOv.ah(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.fNZ.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.fNZ.aHt();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.clw().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.fOv != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.fOv.bmm() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.fOv.bmm()) {
                        VideoMiddlePageFragment.this.fOv.bmn();
                    }
                }
            }
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.fOv != null) {
                VideoMiddlePageFragment.this.fOv.notifyDataSetChanged();
            }
        }
    };
    private HashMap fOB = new HashMap();

    public static VideoMiddlePageFragment dd(String str, String str2) {
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
        com.baidu.tieba.q.c.clw().u(getUniqueId());
        this.fNZ = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.fNZ.setId(stringExtra);
            this.fNZ.setLocation(stringExtra3);
            this.fNZ.ww(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.fOB.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.fOB.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.fNZ.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.bFQ = arguments.getString("PARAM_FID");
        }
        if (this.fNZ != null) {
            this.fNZ.setFrom(this.mFrom);
            this.fNZ.brp();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.fOG);
        registerListener(this.fqu);
        this.fOC = new com.baidu.tieba.t.b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.boW = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(getPageContext().getPageActivity(), R.dimen.ds88) + l.g(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.fOt = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.fOt.addHeaderView(this.mHeaderView);
        this.fOt.setLayoutManager(this.boW);
        this.fOt.setFadingEdgeLength(0);
        this.fOt.setBackgroundColor(al.getColor(R.color.transparent));
        this.fOt.setOverScrollMode(2);
        this.fOt.setScrollable(this);
        this.fOu = (RelativeLayout) view.findViewById(R.id.container);
        this.dlX = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.jS()) {
            this.dlX.setVisibility(0);
        }
        this.fvh = new PbListView(getPageContext().getPageActivity());
        this.fvh.em(false);
        this.fvh.nG();
        this.fvh.ajv();
        this.fvh.iO(R.color.cp_cont_b);
        this.fvh.setText(getResources().getString(R.string.list_has_no_more));
        this.fvh.setTextColor(R.color.cp_cont_d);
        this.fvh.iN(R.color.cp_cont_f);
        this.fOt.setNextPage(this.fvh);
        this.fvh.iQ(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.fOt.setOnScrollListener(this.mScrollListener);
        this.fOv = new f(getPageContext(), this.fOt, this, true, this.mFrom, this.bFQ, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.cAO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.cAO.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.fOx = new ArrayList();
        this.fOy = new d();
        this.fOy.a(this.fNZ);
        com.baidu.tieba.frs.aggregation.g brk = this.fOy.brk();
        ArrayList arrayList = new ArrayList();
        arrayList.add(brk);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fOv != null) {
            this.fOv.kM(false);
        }
        if (!this.fOw) {
            rA(2);
            if (!this.fOv.bra() && this.fOv != null && this.fOp != -1) {
                this.fOv.sS(this.fOp);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fOv != null) {
            this.fOv.kM(true);
            this.fOp = this.fOv.bmm();
        }
        rA(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.clw().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.clw().v(getUniqueId());
        if (this.fNZ != null) {
            this.fNZ.bmr();
        }
        if (this.fOv != null) {
            this.fOv.onDestroy();
        }
        if (this.fOy != null) {
            this.fOy.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.fgM != null) {
            this.fgM.ef(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void asb() {
    }

    public void rA(int i) {
        if (this.fOt != null && this.fOv != null) {
            if (i == 1) {
                if (this.fOv.bra()) {
                    this.fOv.brn();
                } else if (this.fOv.oT()) {
                    this.fOv.oS();
                }
            }
            if (i == 2) {
                this.fOv.oS();
                if (this.fOv.bra()) {
                    this.fOv.bro();
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
        if (!v.aa(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.fOD = TbadkCoreApplication.getInst().getAdAdSense().ceF;
                this.fOE = TbadkCoreApplication.getInst().getAdAdSense().ceH;
                this.fOF = TbadkCoreApplication.getInst().getAdAdSense().ceG;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.fOD + (-1))) % (this.fOE + (-1)) == 0;
                boolean z5 = i2 - size == this.fOF;
                if (i2 <= this.fOF) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.fNZ != null ? this.fNZ.getPageNum() : 0, 0, "", "", sT(size));
                    a.k(this.fOB);
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
            if (!this.fOz && this.fOx.size() > 0 && this.fNZ != null && this.fNZ.brq() != null) {
                String str = this.fNZ.brq().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.fuU.mcnLeadPage) || (gVar.fuU.fve != null && gVar.fuU.fve.isValid())) {
                            this.fOv.j(gVar);
                        }
                        if (this.fOx.get(0) != null) {
                            this.fOx.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.fOz = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.fOx.addAll(arrayList);
        }
        if (!this.fOA) {
            k(arrayList, z);
        }
    }

    private void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.fOv != null && !v.aa(list)) {
            if (this.fOw) {
                this.fOv.setData(list, true);
                this.fOw = false;
            } else {
                this.fOv.setData(list, false);
            }
        }
        if (!z) {
            this.fvh.ajB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dlX.onChangeSkinType(getPageContext(), i);
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
        if (this.fOv != null) {
            this.fOv.onConfigurationChanged(configuration);
        }
    }

    private int sT(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.fOD - 1) {
            i2 = 1;
            int i4 = i3 - (this.fOD - 1);
            if (i4 >= this.fOD - 1) {
                i2 = (i4 % (this.fOE - 1)) + 1;
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
            i = bW(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = bW(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.fOv.sR(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.fOv.sQ(firstVisiblePosition);
        }
        this.fOv.sS(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void sO(int i) {
        if (this.fOv != null) {
            this.fOv.sP(i - 1);
        }
    }

    public boolean rz(int i) {
        if (this.fOv == null) {
            return false;
        }
        return this.fOv.rz(i);
    }

    public int bW(View view) {
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
        return this.fOt.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.jT() || com.baidu.tieba.video.g.cqT().cqU();
    }
}
