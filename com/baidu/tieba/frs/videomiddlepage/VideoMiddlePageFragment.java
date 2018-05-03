package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.afd.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoMiddlePageFragment extends BaseFragment implements b, f.b {
    private String XM;
    private View aMS;
    private NoNetworkView bla;
    private BdTypeListView dby;
    private PbListView dbz;
    private RelativeLayout drN;
    private List<com.baidu.tieba.card.data.b> drP;
    private com.baidu.tbadk.core.view.a drQ;
    private c drR;
    private g dro;
    private e drq;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean drO = true;
    private int drJ = -1;
    private boolean drS = false;
    private boolean drT = false;
    int drV = 4;
    int drW = 7;
    int drX = 4;
    private CustomMessageListener drY = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921317 && customResponsedMessage.getmOrginalMessage() != null && customResponsedMessage.getmOrginalMessage().getExtra() != null) {
                String str = (String) customResponsedMessage.getmOrginalMessage().getExtra();
                if (VideoMiddlePageFragment.this.mBackImageView != null) {
                    if ("low".equals(str)) {
                        VideoMiddlePageFragment.this.mBackImageView.setAlpha(0.6f);
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
                if (j.gP()) {
                    if (VideoMiddlePageFragment.this.bla != null) {
                        VideoMiddlePageFragment.this.bla.setVisibility(8);
                    }
                    if (j.gR() && !com.baidu.tieba.video.f.bvW().bvX() && VideoMiddlePageFragment.this.drq != null && VideoMiddlePageFragment.this.drq.lC()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(d.k.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.bla != null) {
                    VideoMiddlePageFragment.this.bla.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.drq != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Aj) {
                VideoMiddlePageFragment.this.drq.C(data.toUid, data.isAttention);
            }
        }
    };
    private HashMap drU = new HashMap();

    public static VideoMiddlePageFragment aZ(String str, String str2) {
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
        this.dro = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dro.setId(stringExtra);
            this.dro.setLocation(stringExtra3);
            this.dro.lQ(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.drU.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.drU.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dro.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.XM = arguments.getString("PARAM_FID");
        }
        if (this.dro != null) {
            this.dro.avF();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.drY);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.i.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        int e = l.e(getPageContext().getPageActivity(), d.e.ds88) + l.e(getPageContext().getPageActivity(), d.e.tbds42);
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, e));
        this.dby = (BdTypeListView) view2.findViewById(d.g.video_middle_page_list_view);
        this.dby.addHeaderView(this.mHeaderView);
        this.drN = (RelativeLayout) view2.findViewById(d.g.container);
        this.bla = (NoNetworkView) view2.findViewById(d.g.no_network_view);
        if (!j.gP()) {
            this.bla.setVisibility(0);
        }
        this.dbz = new PbListView(getPageContext().getPageActivity());
        this.dbz.aN(false);
        this.dbz.kA();
        this.dbz.wO();
        this.dbz.du(d.C0126d.cp_cont_b);
        this.dbz.setText(getResources().getString(d.k.list_has_no_more));
        this.dbz.setTextColor(d.C0126d.cp_cont_d);
        this.dbz.dt(d.C0126d.cp_cont_d);
        this.dby.setNextPage(this.dbz);
        this.dby.setOnScrollListener(this);
        this.drq = new e(getPageContext(), this.dby, this, true, this.mFrom, this.XM);
        this.mNavigationBar = (NavigationBar) view2.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.aMS.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.drP = new ArrayList();
        this.drR = new c();
        if (this.dro.avG() != null) {
            this.drR.a(this.dro);
            com.baidu.tieba.frs.aggregation.g avB = this.drR.avB();
            ArrayList arrayList = new ArrayList();
            arrayList.add(avB);
            b(arrayList, true, false);
            int dividerHeight = this.dby.getDividerHeight() + e;
            this.drT = true;
            this.drR.a(getPageContext(), this.drN, dividerHeight, this.drq, new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void avD() {
                    VideoMiddlePageFragment.this.drT = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void avE() {
                    VideoMiddlePageFragment.this.drT = false;
                    if (VideoMiddlePageFragment.this.dro != null && VideoMiddlePageFragment.this.dro.avG() != null) {
                        ArrayList arrayList2 = new ArrayList(VideoMiddlePageFragment.this.drP);
                        String str = VideoMiddlePageFragment.this.dro.avG().threadId;
                        if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                            com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                            if (str.equals(gVar.threadId)) {
                                arrayList2.remove(gVar);
                            }
                        }
                        VideoMiddlePageFragment.this.h(arrayList2, VideoMiddlePageFragment.this.mHasMore);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.drq != null) {
            this.drq.ga(false);
        }
        if (!this.drO) {
            kr(2);
            if (this.drq != null && this.drJ != -1) {
                this.drq.lA(this.drJ);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.drq != null) {
            this.drq.ga(true);
            this.drJ = this.drq.arb();
        }
        kr(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dro != null) {
            this.dro.arg();
        }
        if (this.drq != null) {
            this.drq.onDestroy();
        }
        if (this.drR != null) {
            this.drR.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void Ou() {
        if (this.drQ != null) {
            this.drQ.aI(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void EM() {
    }

    public void kr(int i) {
        if (this.dby != null && this.drq != null) {
            if (i == 1 && this.drq.lC()) {
                this.drq.lA();
            }
            if (i == 2) {
                this.drq.lB();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void b(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        if (!v.w(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.drV = TbadkCoreApplication.getInst().getAdAdSense().first_floor;
                this.drW = TbadkCoreApplication.getInst().getAdAdSense().asM;
                this.drX = TbadkCoreApplication.getInst().getAdAdSense().asL;
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.drV + (-1))) % (this.drW + (-1)) == 0;
                boolean z5 = i2 - size == this.drX;
                if (i2 <= this.drX) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dro != null ? this.dro.getPageNum() : 0, 0, "", "", lB(size));
                    a.h(this.drU);
                    dVar = com.baidu.afd.d.a(a);
                    arrayList.add(0, dVar);
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
                arrayList.add(0, list.get(size - 1));
                size--;
                i2 = i;
                dVar2 = dVar;
            }
            if (!this.drS && this.drP.size() > 0 && this.dro.avG() != null) {
                String str = this.dro.avG().threadId;
                if (arrayList.size() > 0 && (arrayList.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.drP.get(0) != null) {
                            this.drP.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList.remove(gVar);
                    }
                    this.drS = true;
                }
            }
            this.drP.addAll(arrayList);
            this.mHasMore = z;
            if (!this.drT) {
                h(arrayList, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.drq != null) {
            if (this.drO) {
                this.drq.setData(list, true);
                this.drO = false;
            } else {
                this.drq.setData(list, false);
            }
        }
        if (!z) {
            this.dbz.wU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bla.onChangeSkinType(getPageContext(), i);
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
        if (this.drq != null) {
            this.drq.onConfigurationChanged(configuration);
        }
    }

    private int lB(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.drV - 1) {
            i2 = 1;
            int i4 = i3 - (this.drV - 1);
            if (i4 >= this.drV - 1) {
                i2 = (i4 % (this.drW - 1)) + 1;
            }
        }
        return i2 + i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2 = 0;
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dro.Po();
        }
        if (i == 0) {
            int headerViewsCount = ((BdTypeListView) absListView).getHeaderViewsCount();
            int firstVisiblePosition = absListView.getFirstVisiblePosition() - headerViewsCount;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            if (absListView.getChildCount() > 1) {
                if (absListView.getChildAt(0) instanceof FrameLayout) {
                    i2 = az(absListView.getChildAt(0));
                } else if (absListView.getChildAt(0) instanceof com.baidu.tieba.lego.card.view.e) {
                    i2 = az(absListView.getChildAt(0));
                } else {
                    i2 = az(absListView.getChildAt(1));
                }
            }
            if (i2 < 75) {
                firstVisiblePosition += this.drq.lz(firstVisiblePosition);
            }
            if (!this.mHasMore && this.drP.size() == absListView.getLastVisiblePosition() - headerViewsCount) {
                firstVisiblePosition = this.drP.size() - 1;
            }
            if (this.drq.arb() != firstVisiblePosition) {
                this.drq.lA(firstVisiblePosition);
            }
        }
        if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.drq != null) {
            if (i > this.drq.arb() || i + i2 < this.drq.arb()) {
                this.drq.arc();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void lx(int i) {
        if (this.drq != null) {
            this.drq.ly(i - 1);
        }
    }

    public boolean kq(int i) {
        if (this.drq == null) {
            return false;
        }
        return this.drq.kq(i);
    }

    public int az(View view2) {
        Rect rect = new Rect();
        view2.getLocalVisibleRect(rect);
        int height = view2.getHeight();
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
}
