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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.videomiddlepage.a;
import com.baidu.tieba.frs.videomiddlepage.b;
import com.baidu.tieba.frs.videomiddlepage.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseFragment implements a.InterfaceC0158a, e.b {
    private View IY;
    private String aMB;
    private View bCC;
    private NoNetworkView cbj;
    private BdTypeListView dIT;
    private PbListView dIU;
    private RelativeLayout dWW;
    private List<com.baidu.tieba.frs.aggregation.f> dWY;
    private com.baidu.tbadk.core.view.b dWZ;
    private g dWw;
    private d dWy;
    private b dXa;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dWX = true;
    private int dWT = -1;
    private boolean dXb = false;
    private boolean dXc = false;
    private CustomMessageListener dXd = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921317 && customResponsedMessage.getmOrginalMessage() != null && customResponsedMessage.getmOrginalMessage().getExtra() != null) {
                String str = (String) customResponsedMessage.getmOrginalMessage().getExtra();
                if (f.this.mBackImageView != null) {
                    if ("low".equals(str)) {
                        f.this.mBackImageView.setAlpha(0.6f);
                    } else if ("high".equals(str)) {
                        f.this.mBackImageView.setAlpha(1.0f);
                    }
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.videomiddlepage.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.oJ()) {
                    if (f.this.cbj != null) {
                        f.this.cbj.setVisibility(8);
                    }
                    if (j.oL() && f.this.dWy != null && f.this.dWy.awH()) {
                        f.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                    }
                } else if (f.this.cbj != null) {
                    f.this.cbj.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.dWy != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.apP) {
                f.this.dWy.G(data.toUid, data.isAttention);
            }
        }
    };

    public static f aZ(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FROM", str);
        bundle.putString("PARAM_FID", str2);
        f fVar = new f();
        fVar.setArguments(bundle);
        return fVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dWw = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dWw.setId(stringExtra);
            this.dWw.setLocation(stringExtra3);
            this.dWw.lN(stringExtra2);
            this.dWw.a((VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.aMB = arguments.getString("PARAM_FID");
        }
        if (this.dWw != null) {
            this.dWw.aAI();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dXd);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.IY = new View(getPageContext().getPageActivity());
        int t = l.t(getPageContext().getPageActivity(), d.e.ds88) + l.t(getPageContext().getPageActivity(), d.e.tbds42);
        this.IY.setLayoutParams(new AbsListView.LayoutParams(-1, t));
        this.dIT = (BdTypeListView) view.findViewById(d.g.video_middle_page_list_view);
        this.dIT.addHeaderView(this.IY);
        this.dWW = (RelativeLayout) view.findViewById(d.g.container);
        this.cbj = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.oJ()) {
            this.cbj.setVisibility(0);
        }
        this.dIU = new PbListView(getPageContext().getPageActivity());
        this.dIU.bv(false);
        this.dIU.st();
        this.dIU.Ed();
        this.dIU.gw(d.C0140d.cp_cont_b);
        this.dIU.setText(getResources().getString(d.j.list_has_no_more));
        this.dIU.setTextColor(d.C0140d.cp_cont_d);
        this.dIU.gv(d.C0140d.cp_cont_d);
        this.dIT.setNextPage(this.dIU);
        this.dIT.setOnScrollListener(this);
        this.dWy = new d(getPageContext(), this.dIT, this, true, this.mFrom, this.aMB);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                f.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.bCC.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.dWY = new ArrayList();
        this.dXa = new b();
        if (this.dWw.aAJ() != null) {
            this.dXa.a(this.dWw);
            com.baidu.tieba.frs.aggregation.f aAE = this.dXa.aAE();
            ArrayList arrayList = new ArrayList();
            arrayList.add(aAE);
            setData(arrayList, true);
            int dividerHeight = this.dIT.getDividerHeight() + t;
            this.dXc = true;
            this.dXa.a(getPageContext(), this.dWW, dividerHeight, this.dWy, new b.a() { // from class: com.baidu.tieba.frs.videomiddlepage.f.5
                @Override // com.baidu.tieba.frs.videomiddlepage.b.a
                public void aAG() {
                    f.this.dXc = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.b.a
                public void aAH() {
                    f.this.dXc = false;
                    if (f.this.dWw != null && f.this.dWw.aAJ() != null) {
                        ArrayList arrayList2 = new ArrayList(f.this.dWY);
                        String str = f.this.dWw.aAJ().threadId;
                        com.baidu.tieba.frs.aggregation.f fVar = (com.baidu.tieba.frs.aggregation.f) arrayList2.get(0);
                        if (str.equals(fVar.threadId)) {
                            arrayList2.remove(fVar);
                        }
                        f.this.j(arrayList2, f.this.mHasMore);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.dWX) {
            ne(2);
            if (this.dWy != null && this.dWT != -1) {
                this.dWy.ob(this.dWT);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dWy != null) {
            this.dWT = this.dWy.awK();
        }
        ne(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dWw != null) {
            this.dWw.awP();
        }
        if (this.dWy != null) {
            this.dWy.onDestroy();
        }
        if (this.dXa != null) {
            this.dXa.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void a(e.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void VV() {
        if (this.dWZ != null) {
            this.dWZ.bq(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void Mj() {
    }

    public void ne(int i) {
        if (this.dIT != null && this.dWy != null) {
            if (i == 1 && this.dWy.awH()) {
                this.dWy.awI();
            }
            if (i == 2) {
                this.dWy.awJ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void setData(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (!v.E(list)) {
            if (!this.dXb && this.dWY.size() > 0 && this.dWw.aAJ() != null) {
                String str = this.dWw.aAJ().threadId;
                com.baidu.tieba.frs.aggregation.f fVar = list.get(0);
                if (str.equals(fVar.threadId)) {
                    list.remove(fVar);
                }
                this.dXb = true;
            }
            this.dWY.addAll(list);
            this.mHasMore = z;
            if (!this.dXc) {
                j(list, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (this.dWy != null) {
            if (this.dWX) {
                this.dWy.setData(list, true);
                this.dWX = false;
            } else {
                this.dWy.setData(list, false);
            }
        }
        if (!z) {
            this.dIU.Ei();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cbj.onChangeSkinType(getPageContext(), i);
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
        if (this.dWy != null) {
            this.dWy.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2 = 0;
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dWw.WO();
        }
        if (i == 0) {
            int headerViewsCount = ((BdTypeListView) absListView).getHeaderViewsCount();
            int firstVisiblePosition = absListView.getFirstVisiblePosition() - headerViewsCount;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            if (absListView.getChildCount() > 1) {
                if (absListView.getChildAt(0) instanceof FrameLayout) {
                    i2 = bT(absListView.getChildAt(0));
                } else {
                    i2 = bT(absListView.getChildAt(1));
                }
            }
            if (i2 < 75) {
                firstVisiblePosition++;
            }
            if (!this.mHasMore && this.dWY.size() == absListView.getLastVisiblePosition() - headerViewsCount) {
                firstVisiblePosition = this.dWY.size() - 1;
            }
            if (this.dWy.awK() != firstVisiblePosition) {
                this.dWy.ob(firstVisiblePosition);
            }
        }
        if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dWy != null) {
            if (i > this.dWy.awK() || i + i2 < this.dWy.awK()) {
                this.dWy.awL();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.a.InterfaceC0158a
    public void nZ(int i) {
        if (this.dWy != null) {
            this.dWy.oa(i - 1);
        }
    }

    public boolean nc(int i) {
        if (this.dWy == null) {
            return false;
        }
        return this.dWy.nc(i);
    }

    public int bT(View view) {
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
}
