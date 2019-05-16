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
    private String bFP;
    private LinearLayoutManager boW;
    private View cAN;
    private NoNetworkView dlW;
    private h fNW;
    private BdTypeRecyclerView fOq;
    private RelativeLayout fOr;
    private f fOs;
    private List<com.baidu.tieba.card.data.b> fOu;
    private d fOv;
    private com.baidu.tieba.t.b fOz;
    private com.baidu.tbadk.core.view.b fgL;
    private PbListView fvg;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean fOt = true;
    private int fOm = -1;
    private boolean fOw = false;
    private boolean fOx = false;
    int fOA = 4;
    int fOB = 7;
    int fOC = 4;
    private CustomMessageListener fOD = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.dlW != null) {
                        VideoMiddlePageFragment.this.dlW.setVisibility(8);
                    }
                    if (j.jU() && !com.baidu.tieba.video.g.cqQ().cqR()) {
                        if (VideoMiddlePageFragment.this.fOs == null || !VideoMiddlePageFragment.this.fOs.oT()) {
                            if (VideoMiddlePageFragment.this.fOs != null && VideoMiddlePageFragment.this.fOs.bqV()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.dlW != null) {
                    VideoMiddlePageFragment.this.dlW.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.fOs != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Hi) {
                VideoMiddlePageFragment.this.fOs.ah(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.fNW.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.fNW.aHq();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.q.c.clt().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.fOs != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.fOs.bmj() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.fOs.bmj()) {
                        VideoMiddlePageFragment.this.fOs.bmk();
                    }
                }
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.fOs != null) {
                VideoMiddlePageFragment.this.fOs.notifyDataSetChanged();
            }
        }
    };
    private HashMap fOy = new HashMap();

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
        com.baidu.tieba.q.c.clt().u(getUniqueId());
        this.fNW = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.fNW.setId(stringExtra);
            this.fNW.setLocation(stringExtra3);
            this.fNW.wx(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.fOy.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.fOy.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.fNW.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.bFP = arguments.getString("PARAM_FID");
        }
        if (this.fNW != null) {
            this.fNW.setFrom(this.mFrom);
            this.fNW.brk();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.fOD);
        registerListener(this.fqt);
        this.fOz = new com.baidu.tieba.t.b();
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
        this.fOq = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.fOq.addHeaderView(this.mHeaderView);
        this.fOq.setLayoutManager(this.boW);
        this.fOq.setFadingEdgeLength(0);
        this.fOq.setBackgroundColor(al.getColor(R.color.transparent));
        this.fOq.setOverScrollMode(2);
        this.fOq.setScrollable(this);
        this.fOr = (RelativeLayout) view.findViewById(R.id.container);
        this.dlW = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.jS()) {
            this.dlW.setVisibility(0);
        }
        this.fvg = new PbListView(getPageContext().getPageActivity());
        this.fvg.em(false);
        this.fvg.nG();
        this.fvg.ajv();
        this.fvg.iO(R.color.cp_cont_b);
        this.fvg.setText(getResources().getString(R.string.list_has_no_more));
        this.fvg.setTextColor(R.color.cp_cont_d);
        this.fvg.iN(R.color.cp_cont_f);
        this.fOq.setNextPage(this.fvg);
        this.fvg.iQ(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.fOq.setOnScrollListener(this.mScrollListener);
        this.fOs = new f(getPageContext(), this.fOq, this, true, this.mFrom, this.bFP, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.cAN.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.fOu = new ArrayList();
        this.fOv = new d();
        this.fOv.a(this.fNW);
        com.baidu.tieba.frs.aggregation.g brf = this.fOv.brf();
        ArrayList arrayList = new ArrayList();
        arrayList.add(brf);
        c(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fOs != null) {
            this.fOs.kL(false);
        }
        if (!this.fOt) {
            rA(2);
            if (!this.fOs.bqV() && this.fOs != null && this.fOm != -1) {
                this.fOs.sS(this.fOm);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fOs != null) {
            this.fOs.kL(true);
            this.fOm = this.fOs.bmj();
        }
        rA(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.q.c.clt().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        if (this.fNW != null) {
            this.fNW.bmo();
        }
        if (this.fOs != null) {
            this.fOs.onDestroy();
        }
        if (this.fOv != null) {
            this.fOv.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.fgL != null) {
            this.fgL.ef(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void asb() {
    }

    public void rA(int i) {
        if (this.fOq != null && this.fOs != null) {
            if (i == 1) {
                if (this.fOs.bqV()) {
                    this.fOs.bri();
                } else if (this.fOs.oT()) {
                    this.fOs.oS();
                }
            }
            if (i == 2) {
                this.fOs.oS();
                if (this.fOs.bqV()) {
                    this.fOs.brj();
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
                this.fOA = TbadkCoreApplication.getInst().getAdAdSense().ceE;
                this.fOB = TbadkCoreApplication.getInst().getAdAdSense().ceG;
                this.fOC = TbadkCoreApplication.getInst().getAdAdSense().ceF;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.fOA + (-1))) % (this.fOB + (-1)) == 0;
                boolean z5 = i2 - size == this.fOC;
                if (i2 <= this.fOC) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.fNW != null ? this.fNW.getPageNum() : 0, 0, "", "", sT(size));
                    a.k(this.fOy);
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
            if (!this.fOw && this.fOu.size() > 0 && this.fNW != null && this.fNW.brl() != null) {
                String str = this.fNW.brl().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (!StringUtils.isNull(gVar.fuT.mcnLeadPage) || (gVar.fuT.fvd != null && gVar.fuT.fvd.isValid())) {
                            this.fOs.j(gVar);
                        }
                        if (this.fOu.get(0) != null) {
                            this.fOu.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.fOw = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.fOu.addAll(arrayList);
        }
        if (!this.fOx) {
            k(arrayList, z);
        }
    }

    private void k(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.fOs != null && !v.aa(list)) {
            if (this.fOt) {
                this.fOs.setData(list, true);
                this.fOt = false;
            } else {
                this.fOs.setData(list, false);
            }
        }
        if (!z) {
            this.fvg.ajB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dlW.onChangeSkinType(getPageContext(), i);
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
        if (this.fOs != null) {
            this.fOs.onConfigurationChanged(configuration);
        }
    }

    private int sT(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.fOA - 1) {
            i2 = 1;
            int i4 = i3 - (this.fOA - 1);
            if (i4 >= this.fOA - 1) {
                i2 = (i4 % (this.fOB - 1)) + 1;
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
        if (!this.fOs.sR(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.fOs.sQ(firstVisiblePosition);
        }
        this.fOs.sS(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void sO(int i) {
        if (this.fOs != null) {
            this.fOs.sP(i - 1);
        }
    }

    public boolean rz(int i) {
        if (this.fOs == null) {
            return false;
        }
        return this.fOs.rz(i);
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
        return this.fOq.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return j.jT() || com.baidu.tieba.video.g.cqQ().cqR();
    }
}
