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
public class f extends BaseFragment implements a.InterfaceC0159a, e.b {
    private View IS;
    private String aMr;
    private View bCs;
    private NoNetworkView cba;
    private BdTypeListView dIM;
    private PbListView dIN;
    private RelativeLayout dWQ;
    private List<com.baidu.tieba.frs.aggregation.f> dWS;
    private com.baidu.tbadk.core.view.b dWT;
    private b dWU;
    private g dWq;
    private d dWs;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dWR = true;
    private int dWN = -1;
    private boolean dWV = false;
    private boolean dWW = false;
    private CustomMessageListener dWX = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    if (f.this.cba != null) {
                        f.this.cba.setVisibility(8);
                    }
                    if (j.oL() && f.this.dWs != null && f.this.dWs.awI()) {
                        f.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                    }
                } else if (f.this.cba != null) {
                    f.this.cba.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.dWs != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.apH) {
                f.this.dWs.F(data.toUid, data.isAttention);
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
        this.dWq = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dWq.setId(stringExtra);
            this.dWq.setLocation(stringExtra3);
            this.dWq.lN(stringExtra2);
            this.dWq.a((VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.aMr = arguments.getString("PARAM_FID");
        }
        if (this.dWq != null) {
            this.dWq.aAJ();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dWX);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.IS = new View(getPageContext().getPageActivity());
        int t = l.t(getPageContext().getPageActivity(), d.e.ds88) + l.t(getPageContext().getPageActivity(), d.e.tbds42);
        this.IS.setLayoutParams(new AbsListView.LayoutParams(-1, t));
        this.dIM = (BdTypeListView) view.findViewById(d.g.video_middle_page_list_view);
        this.dIM.addHeaderView(this.IS);
        this.dWQ = (RelativeLayout) view.findViewById(d.g.container);
        this.cba = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.oJ()) {
            this.cba.setVisibility(0);
        }
        this.dIN = new PbListView(getPageContext().getPageActivity());
        this.dIN.bv(false);
        this.dIN.st();
        this.dIN.Ed();
        this.dIN.gw(d.C0141d.cp_cont_b);
        this.dIN.setText(getResources().getString(d.j.list_has_no_more));
        this.dIN.setTextColor(d.C0141d.cp_cont_d);
        this.dIN.gv(d.C0141d.cp_cont_d);
        this.dIM.setNextPage(this.dIN);
        this.dIM.setOnScrollListener(this);
        this.dWs = new d(getPageContext(), this.dIM, this, true, this.mFrom, this.aMr);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.bCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                f.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.bCs.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.dWS = new ArrayList();
        this.dWU = new b();
        if (this.dWq.aAK() != null) {
            this.dWU.a(this.dWq);
            com.baidu.tieba.frs.aggregation.f aAF = this.dWU.aAF();
            ArrayList arrayList = new ArrayList();
            arrayList.add(aAF);
            setData(arrayList, true);
            int dividerHeight = this.dIM.getDividerHeight() + t;
            this.dWW = true;
            this.dWU.a(getPageContext(), this.dWQ, dividerHeight, this.dWs, new b.a() { // from class: com.baidu.tieba.frs.videomiddlepage.f.5
                @Override // com.baidu.tieba.frs.videomiddlepage.b.a
                public void aAH() {
                    f.this.dWW = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.b.a
                public void aAI() {
                    f.this.dWW = false;
                    if (f.this.dWq != null && f.this.dWq.aAK() != null) {
                        ArrayList arrayList2 = new ArrayList(f.this.dWS);
                        String str = f.this.dWq.aAK().threadId;
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
        if (!this.dWR) {
            ne(2);
            if (this.dWs != null && this.dWN != -1) {
                this.dWs.ob(this.dWN);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dWs != null) {
            this.dWN = this.dWs.awL();
        }
        ne(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dWq != null) {
            this.dWq.awQ();
        }
        if (this.dWs != null) {
            this.dWs.onDestroy();
        }
        if (this.dWU != null) {
            this.dWU.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void a(e.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void VV() {
        if (this.dWT != null) {
            this.dWT.bq(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void Mj() {
    }

    public void ne(int i) {
        if (this.dIM != null && this.dWs != null) {
            if (i == 1 && this.dWs.awI()) {
                this.dWs.awJ();
            }
            if (i == 2) {
                this.dWs.awK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void setData(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (!v.E(list)) {
            if (!this.dWV && this.dWS.size() > 0 && this.dWq.aAK() != null) {
                String str = this.dWq.aAK().threadId;
                com.baidu.tieba.frs.aggregation.f fVar = list.get(0);
                if (str.equals(fVar.threadId)) {
                    list.remove(fVar);
                }
                this.dWV = true;
            }
            this.dWS.addAll(list);
            this.mHasMore = z;
            if (!this.dWW) {
                j(list, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (this.dWs != null) {
            if (this.dWR) {
                this.dWs.setData(list, true);
                this.dWR = false;
            } else {
                this.dWs.setData(list, false);
            }
        }
        if (!z) {
            this.dIN.Ei();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cba.onChangeSkinType(getPageContext(), i);
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
        if (this.dWs != null) {
            this.dWs.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2 = 0;
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dWq.WO();
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
            if (!this.mHasMore && this.dWS.size() == absListView.getLastVisiblePosition() - headerViewsCount) {
                firstVisiblePosition = this.dWS.size() - 1;
            }
            if (this.dWs.awL() != firstVisiblePosition) {
                this.dWs.ob(firstVisiblePosition);
            }
        }
        if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dWs != null) {
            if (i > this.dWs.awL() || i + i2 < this.dWs.awL()) {
                this.dWs.awM();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.a.InterfaceC0159a
    public void nZ(int i) {
        if (this.dWs != null) {
            this.dWs.oa(i - 1);
        }
    }

    public boolean nc(int i) {
        if (this.dWs == null) {
            return false;
        }
        return this.dWs.nc(i);
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
