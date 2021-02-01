package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private RelativeLayout dXq;
    private String eNE;
    private LinearLayoutManager eqM;
    private View fLW;
    private NoNetworkView gAh;
    private boolean isFullScreen;
    private h jMK;
    private BdTypeRecyclerView jNf;
    private f jNg;
    private List<BaseCardInfo> jNi;
    private com.baidu.tbadk.core.view.a jNj;
    private d jNk;
    private com.baidu.tieba.v.b jNo;
    private int jNp;
    private int jjK;
    private PbListView jof;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jNh = true;
    private int jNb = -1;
    private boolean jNl = false;
    private boolean jNm = false;
    int jNq = 4;
    int jNr = 7;
    int jNs = 4;
    private CustomMessageListener jNt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.gAh != null) {
                        VideoMiddlePageFragment.this.gAh.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dRX().dRY()) {
                        if (VideoMiddlePageFragment.this.jNg == null || !VideoMiddlePageFragment.this.jNg.qZ()) {
                            if (VideoMiddlePageFragment.this.jNg != null && VideoMiddlePageFragment.this.jNg.cMa()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.gAh != null) {
                    VideoMiddlePageFragment.this.gAh.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jNg != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jNg.aO(data.toUid, data.isAttention);
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                VideoMiddlePageFragment.this.mScrollState = i;
                if (i == 0) {
                    if (bdTypeRecyclerView.getLastVisiblePosition() > bdTypeRecyclerView.getCount() - 2 && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                        VideoMiddlePageFragment.this.jMK.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jMK.bRc();
                    }
                    VideoMiddlePageFragment.this.h(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dMr().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jNg != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jNg.cFs() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jNg.cFs()) {
                        VideoMiddlePageFragment.this.jNg.cFt();
                    }
                }
            }
        }
    };
    private CustomMessageListener jhX = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jNg != null) {
                VideoMiddlePageFragment.this.jNg.notifyDataSetChanged();
            }
        }
    };
    private HashMap jNn = new HashMap();

    public static VideoMiddlePageFragment fn(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FROM", str);
        bundle.putString("PARAM_FID", str2);
        VideoMiddlePageFragment videoMiddlePageFragment = new VideoMiddlePageFragment();
        videoMiddlePageFragment.setArguments(bundle);
        return videoMiddlePageFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        this.jMK = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jMK.setId(stringExtra);
            this.jMK.setLocation(stringExtra3);
            this.jMK.Ko(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra("param_video_thread_info");
            if (videoSerializeVideoThreadInfo != null) {
                this.jNn.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jNn.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jMK.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eNE = arguments.getString("PARAM_FID");
        }
        if (this.jMK != null) {
            this.jMK.setFrom(this.mFrom);
            this.jMK.cMq();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.faJ);
        registerListener(this.jNt);
        registerListener(this.jhX);
        this.jNo = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.eqM = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jNf = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jNf.addHeaderView(this.mHeaderView);
        this.jNf.setLayoutManager(this.eqM);
        this.jNf.setFadingEdgeLength(0);
        this.jNf.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jNf.setOverScrollMode(2);
        this.jNf.setScrollable(this);
        this.dXq = (RelativeLayout) view.findViewById(R.id.container);
        this.gAh = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.gAh.setVisibility(0);
        }
        this.jof = new PbListView(getPageContext().getPageActivity());
        this.jof.setIsMoreViewVisible(false);
        this.jof.createView();
        this.jof.setLineGone();
        this.jof.setContainerBackgroundColorResId(R.color.CAM_X0105);
        this.jof.setText(getResources().getString(R.string.list_has_no_more));
        this.jof.setTextColor(R.color.CAM_X0109);
        this.jof.setNoMoreTextColorId(R.color.CAM_X0106);
        this.jNf.setNextPage(this.jof);
        this.jof.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jNf.setOnScrollListener(this.mScrollListener);
        this.jNg = new f(getPageContext(), this.jNf, this, true, this.mFrom, this.eNE, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bsd()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jNi = new ArrayList();
        this.jNk = new d();
        this.jNk.a(this.jMK);
        com.baidu.tieba.frs.aggregation.g cMk = this.jNk.cMk();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cMk);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jNg != null) {
            this.jNg.rK(false);
        }
        if (!this.jNh) {
            zg(2);
            if (!this.jNg.cMa() && this.jNg != null && this.jNb != -1) {
                this.jNg.AT(this.jNb);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jNg != null) {
            this.jNg.rK(true);
            this.jNb = this.jNg.cFs();
        }
        zg(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        if (this.jMK != null) {
            this.jMK.cFx();
        }
        if (this.jNg != null) {
            this.jNg.onDestroy();
        }
        if (this.jNk != null) {
            this.jNk.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jNj != null) {
            this.jNj.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void onLoadFail() {
    }

    public void zg(int i) {
        if (this.jNf != null && this.jNg != null) {
            if (i == 1) {
                if (this.jNg.cMa()) {
                    this.jNg.cMn();
                } else if (this.jNg.qZ()) {
                    this.jNg.qY();
                }
            }
            if (i == 2) {
                this.jNg.qY();
                if (this.jNg.cMa()) {
                    this.jNg.cMo();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void d(List<BaseCardInfo> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!y.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.jNq = TbadkCoreApplication.getInst().getAdAdSense().fqr;
                this.jNr = TbadkCoreApplication.getInst().getAdAdSense().fqt;
                this.jNs = TbadkCoreApplication.getInst().getAdAdSense().fqs;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jNq + (-1))) % (this.jNr + (-1)) == 0;
                boolean z5 = i - size == this.jNs;
                if (i <= this.jNs) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.h a2 = com.baidu.afd.c.a(3, this.jMK != null ? this.jMK.getPageNum() : 0, 0, "", "", AU(size));
                    a2.u(this.jNn);
                    dVar = com.baidu.afd.d.a(a2);
                    com.baidu.tieba.lego.card.c.a.a(arrayList2, dVar, 0);
                    i = size + 1;
                } else {
                    dVar = dVar2;
                }
                if (z3) {
                    BaseCardInfo baseCardInfo = list.get(size - 1);
                    if (dVar != null && baseCardInfo != null) {
                        baseCardInfo.setTrigger(new com.baidu.afd.g(dVar));
                    }
                }
                arrayList2.add(0, list.get(size - 1));
                size--;
                dVar2 = dVar;
            }
            if (!this.jNl && this.jNi.size() > 0 && this.jMK != null && this.jMK.cMr() != null) {
                String str = this.jMK.cMr().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || n(gVar)) {
                        if (!StringUtils.isNull(gVar.jnS.mcnLeadPage) || (gVar.jnS.joc != null && gVar.jnS.joc.isValid())) {
                            this.jNg.m(gVar);
                        }
                        if (this.jNi.get(0) != null) {
                            this.jNi.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jNl = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jNi.addAll(arrayList);
        }
        if (!this.jNm) {
            q(arrayList, z);
        }
    }

    private boolean n(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cMr;
        return (!"0".equals(gVar.threadId) || this.jMK == null || this.jMK.cMr() == null || (cMr = this.jMK.cMr()) == null || cMr.video == null || !TextUtils.equals(cMr.title, gVar.title) || !TextUtils.equals(cMr.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void q(List<BaseCardInfo> list, boolean z) {
        if (this.jNg != null && !y.isEmpty(list)) {
            if (this.jNh) {
                this.jNg.setData(list, true);
                this.jNh = false;
            } else {
                this.jNg.setData(list, false);
            }
        }
        if (!z) {
            this.jof.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAh.onChangeSkinType(getPageContext(), i);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jNp = this.jNf.getFirstVisiblePosition();
            View childAt = this.jNf.getChildAt(0);
            this.jjK = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jNg != null) {
            this.jNg.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cMp() != null && this.jNp != this.jNf.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jNf.getLayoutManager()).scrollToPositionWithOffset(this.jNp, this.jjK);
        }
    }

    private int AU(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jNq - 1) {
            i2 = 1;
            int i4 = i3 - (this.jNq - 1);
            if (i4 >= this.jNq - 1) {
                i2 = (i4 % (this.jNr - 1)) + 1;
            }
        }
        return i2 + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition() - bdTypeRecyclerView.getHeaderViewsCount();
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        if (bdTypeRecyclerView.getChildCount() > 0 && ((bdTypeRecyclerView.getChildAt(0) instanceof RelativeLayout) || (bdTypeRecyclerView.getChildAt(0) instanceof com.baidu.tieba.lego.card.view.e))) {
            i = dc(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = dc(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.jNg.AS(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jNg.AR(firstVisiblePosition);
        }
        this.jNg.AT(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void AP(int i) {
        if (this.jNg != null) {
            this.jNg.AQ(i - 1);
        }
    }

    public boolean zf(int i) {
        if (this.jNg == null) {
            return false;
        }
        return this.jNg.zf(i);
    }

    public int dc(View view) {
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
    public q onGetPreLoadListView() {
        return this.jNf.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.f.dRX().dRY();
    }

    public a cMp() {
        if (this.jNg != null) {
            return this.jNg.cMp();
        }
        return null;
    }
}
