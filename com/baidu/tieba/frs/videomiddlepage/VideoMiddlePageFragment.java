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
import com.baidu.adp.widget.ListView.t;
import com.baidu.afd.i;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes22.dex */
public class VideoMiddlePageFragment extends BaseFragment implements c, g.b {
    private RelativeLayout dFP;
    private LinearLayoutManager dZe;
    private String eve;
    private View frR;
    private NoNetworkView gdx;
    private int iET;
    private PbListView iJp;
    private boolean isFullScreen;
    private d jfA;
    private com.baidu.tieba.v.b jfE;
    private int jfF;
    private h jfa;
    private BdTypeRecyclerView jfv;
    private f jfw;
    private List<com.baidu.tieba.card.data.b> jfy;
    private com.baidu.tbadk.core.view.a jfz;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean jfx = true;
    private int jfr = -1;
    private boolean jfB = false;
    private boolean jfC = false;
    int jfG = 4;
    int jfH = 7;
    int jfI = 4;
    private CustomMessageListener jfJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_MIDDLE_PAGE_NAVIGATION_BAR_ICON) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
    private CustomMessageListener eri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isNetWorkAvailable()) {
                    if (VideoMiddlePageFragment.this.gdx != null) {
                        VideoMiddlePageFragment.this.gdx.setVisibility(8);
                    }
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dLS().dLT()) {
                        if (VideoMiddlePageFragment.this.jfw == null || !VideoMiddlePageFragment.this.jfw.rx()) {
                            if (VideoMiddlePageFragment.this.jfw != null && VideoMiddlePageFragment.this.jfw.cEe()) {
                                VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                                return;
                            }
                            return;
                        }
                        VideoMiddlePageFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.gdx != null) {
                    VideoMiddlePageFragment.this.gdx.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.jfw != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoMiddlePageFragment.this.jfw.aO(data.toUid, data.isAttention);
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
                        VideoMiddlePageFragment.this.jfa.setFrom(VideoMiddlePageFragment.this.mFrom);
                        VideoMiddlePageFragment.this.jfa.bMi();
                    }
                    VideoMiddlePageFragment.this.c(bdTypeRecyclerView);
                    com.baidu.tieba.s.c.dGv().b(VideoMiddlePageFragment.this.getUniqueId(), true);
                } else if (i == 1) {
                    VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.jfw != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.jfw.cyI() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.jfw.cyI()) {
                        VideoMiddlePageFragment.this.jfw.cyJ();
                    }
                }
            }
        }
    };
    private CustomMessageListener iDh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoMiddlePageFragment.this.jfw != null) {
                VideoMiddlePageFragment.this.jfw.notifyDataSetChanged();
            }
        }
    };
    private HashMap jfD = new HashMap();

    public static VideoMiddlePageFragment fh(String str, String str2) {
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
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
        this.jfa = new h(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.jfa.setId(stringExtra);
            this.jfa.setLocation(stringExtra3);
            this.jfa.Kg(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.jfD.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.jfD.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.jfa.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.eve = arguments.getString("PARAM_FID");
        }
        if (this.jfa != null) {
            this.jfa.setFrom(this.mFrom);
            this.jfa.cEu();
        }
        registerListener(this.eri);
        registerListener(this.eHG);
        registerListener(this.jfJ);
        registerListener(this.iDh);
        this.jfE = new com.baidu.tieba.v.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.dZe = new LinearLayoutManager(getContext());
        this.mHeaderView = new View(getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds88) + l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds42)));
        this.jfv = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.jfv.addHeaderView(this.mHeaderView);
        this.jfv.setLayoutManager(this.dZe);
        this.jfv.setFadingEdgeLength(0);
        this.jfv.setBackgroundColor(ap.getColor(R.color.transparent));
        this.jfv.setOverScrollMode(2);
        this.jfv.setScrollable(this);
        this.dFP = (RelativeLayout) view.findViewById(R.id.container);
        this.gdx = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.gdx.setVisibility(0);
        }
        this.iJp = new PbListView(getPageContext().getPageActivity());
        this.iJp.setIsMoreViewVisible(false);
        this.iJp.createView();
        this.iJp.setLineGone();
        this.iJp.setContainerBackgroundColorResId(R.color.cp_cont_b);
        this.iJp.setText(getResources().getString(R.string.list_has_no_more));
        this.iJp.setTextColor(R.color.cp_cont_d);
        this.iJp.setNoMoreTextColorId(R.color.cp_cont_f);
        this.jfv.setNextPage(this.iJp);
        this.iJp.showEmptyView(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.jfv.setOnScrollListener(this.mScrollListener);
        this.jfw = new f(getPageContext(), this.jfv, this, true, this.mFrom, this.eve, getUniqueId());
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        if (com.baidu.tbadk.core.util.g.bnT()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNavigationBar.getLayoutParams();
            layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.mNavigationBar.setLayoutParams(layoutParams);
        }
        this.frR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.frR.findViewById(R.id.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.jfy = new ArrayList();
        this.jfA = new d();
        this.jfA.a(this.jfa);
        com.baidu.tieba.frs.aggregation.g cEo = this.jfA.cEo();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cEo);
        d(arrayList, true, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jfw != null) {
            this.jfw.qs(false);
        }
        if (!this.jfx) {
            za(2);
            if (!this.jfw.cEe() && this.jfw != null && this.jfr != -1) {
                this.jfw.AD(this.jfr);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jfw != null) {
            this.jfw.qs(true);
            this.jfr = this.jfw.cyI();
        }
        za(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        if (this.jfa != null) {
            this.jfa.cyM();
        }
        if (this.jfw != null) {
            this.jfw.onDestroy();
        }
        if (this.jfA != null) {
            this.jfA.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void a(g.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void hideLoadingView() {
        if (this.jfz != null) {
            this.jfz.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.g.b
    public void arV() {
    }

    public void za(int i) {
        if (this.jfv != null && this.jfw != null) {
            if (i == 1) {
                if (this.jfw.cEe()) {
                    this.jfw.cEr();
                } else if (this.jfw.rx()) {
                    this.jfw.rw();
                }
            }
            if (i == 2) {
                this.jfw.rw();
                if (this.jfw.cEe()) {
                    this.jfw.cEs();
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
        if (!y.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.jfG = TbadkCoreApplication.getInst().getAdAdSense().eWD;
                this.jfH = TbadkCoreApplication.getInst().getAdAdSense().eWF;
                this.jfI = TbadkCoreApplication.getInst().getAdAdSense().eWE;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.jfG + (-1))) % (this.jfH + (-1)) == 0;
                boolean z5 = i2 - size == this.jfI;
                if (i2 <= this.jfI) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a2 = com.baidu.afd.c.a(3, this.jfa != null ? this.jfa.getPageNum() : 0, 0, "", "", AE(size));
                    a2.u(this.jfD);
                    dVar = com.baidu.afd.d.a(a2);
                    com.baidu.tieba.lego.card.d.a.a(arrayList2, dVar, 0);
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
            if (!this.jfB && this.jfy.size() > 0 && this.jfa != null && this.jfa.cEv() != null) {
                String str = this.jfa.cEv().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId) || m(gVar)) {
                        if (!StringUtils.isNull(gVar.iJc.mcnLeadPage) || (gVar.iJc.iJm != null && gVar.iJc.iJm.isValid())) {
                            this.jfw.l(gVar);
                        }
                        if (this.jfy.get(0) != null) {
                            this.jfy.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.jfB = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.jfy.addAll(arrayList);
        }
        if (!this.jfC) {
            o(arrayList, z);
        }
    }

    private boolean m(com.baidu.tieba.frs.aggregation.g gVar) {
        VideoSerializeVideoThreadInfo cEv;
        return (!"0".equals(gVar.threadId) || this.jfa == null || this.jfa.cEv() == null || (cEv = this.jfa.cEv()) == null || cEv.video == null || !TextUtils.equals(cEv.title, gVar.title) || !TextUtils.equals(cEv.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    private void o(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.jfw != null && !y.isEmpty(list)) {
            if (this.jfx) {
                this.jfw.setData(list, true);
                this.jfx = false;
            } else {
                this.jfw.setData(list, false);
            }
        }
        if (!z) {
            this.iJp.showEndLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gdx.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.isFullScreen;
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
            this.jfF = this.jfv.getFirstVisiblePosition();
            View childAt = this.jfv.getChildAt(0);
            this.iET = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.isFullScreen;
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.jfw != null) {
            this.jfw.onConfigurationChanged(configuration);
        }
        if (z && !this.isFullScreen && cEt() != null && this.jfF != this.jfv.getFirstVisiblePosition()) {
            ((LinearLayoutManager) this.jfv.getLayoutManager()).scrollToPositionWithOffset(this.jfF, this.iET);
        }
    }

    private int AE(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.jfG - 1) {
            i2 = 1;
            int i4 = i3 - (this.jfG - 1);
            if (i4 >= this.jfG - 1) {
                i2 = (i4 % (this.jfH - 1)) + 1;
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
            i = cE(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i = cE(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.jfw.AC(firstVisiblePosition) || i < 95) {
            firstVisiblePosition += this.jfw.AB(firstVisiblePosition);
        }
        this.jfw.AD(firstVisiblePosition);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.c
    public void Az(int i) {
        if (this.jfw != null) {
            this.jfw.AA(i - 1);
        }
    }

    public boolean yZ(int i) {
        if (this.jfw == null) {
            return false;
        }
        return this.jfw.yZ(i);
    }

    public int cE(View view) {
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
    public t onGetPreLoadListView() {
        return this.jfv.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return j.isWifiNet() || com.baidu.tieba.video.g.dLS().dLT();
    }

    public a cEt() {
        if (this.jfw != null) {
            return this.jfw.cEt();
        }
        return null;
    }
}
