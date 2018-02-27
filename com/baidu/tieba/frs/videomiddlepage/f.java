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
    private String aMq;
    private View bCp;
    private NoNetworkView caX;
    private BdTypeListView dIH;
    private PbListView dII;
    private RelativeLayout dWK;
    private List<com.baidu.tieba.frs.aggregation.f> dWM;
    private com.baidu.tbadk.core.view.b dWN;
    private b dWO;
    private g dWk;
    private d dWm;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dWL = true;
    private int dWH = -1;
    private boolean dWP = false;
    private boolean dWQ = false;
    private CustomMessageListener dWR = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    if (f.this.caX != null) {
                        f.this.caX.setVisibility(8);
                    }
                    if (j.oL() && f.this.dWm != null && f.this.dWm.awG()) {
                        f.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                    }
                } else if (f.this.caX != null) {
                    f.this.caX.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.dWm != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.apG) {
                f.this.dWm.F(data.toUid, data.isAttention);
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
        this.dWk = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dWk.setId(stringExtra);
            this.dWk.setLocation(stringExtra3);
            this.dWk.lN(stringExtra2);
            this.dWk.a((VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.aMq = arguments.getString("PARAM_FID");
        }
        if (this.dWk != null) {
            this.dWk.aAH();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dWR);
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
        this.dIH = (BdTypeListView) view.findViewById(d.g.video_middle_page_list_view);
        this.dIH.addHeaderView(this.IS);
        this.dWK = (RelativeLayout) view.findViewById(d.g.container);
        this.caX = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.oJ()) {
            this.caX.setVisibility(0);
        }
        this.dII = new PbListView(getPageContext().getPageActivity());
        this.dII.bv(false);
        this.dII.st();
        this.dII.Ec();
        this.dII.gw(d.C0141d.cp_cont_b);
        this.dII.setText(getResources().getString(d.j.list_has_no_more));
        this.dII.setTextColor(d.C0141d.cp_cont_d);
        this.dII.gv(d.C0141d.cp_cont_d);
        this.dIH.setNextPage(this.dII);
        this.dIH.setOnScrollListener(this);
        this.dWm = new d(getPageContext(), this.dIH, this, true, this.mFrom, this.aMq);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.bCp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                f.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.bCp.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.dWM = new ArrayList();
        this.dWO = new b();
        if (this.dWk.aAI() != null) {
            this.dWO.a(this.dWk);
            com.baidu.tieba.frs.aggregation.f aAD = this.dWO.aAD();
            ArrayList arrayList = new ArrayList();
            arrayList.add(aAD);
            setData(arrayList, true);
            int dividerHeight = this.dIH.getDividerHeight() + t;
            this.dWQ = true;
            this.dWO.a(getPageContext(), this.dWK, dividerHeight, this.dWm, new b.a() { // from class: com.baidu.tieba.frs.videomiddlepage.f.5
                @Override // com.baidu.tieba.frs.videomiddlepage.b.a
                public void aAF() {
                    f.this.dWQ = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.b.a
                public void aAG() {
                    f.this.dWQ = false;
                    if (f.this.dWk != null && f.this.dWk.aAI() != null) {
                        ArrayList arrayList2 = new ArrayList(f.this.dWM);
                        String str = f.this.dWk.aAI().threadId;
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
        if (!this.dWL) {
            ne(2);
            if (this.dWm != null && this.dWH != -1) {
                this.dWm.ob(this.dWH);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dWm != null) {
            this.dWH = this.dWm.awJ();
        }
        ne(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dWk != null) {
            this.dWk.awO();
        }
        if (this.dWm != null) {
            this.dWm.onDestroy();
        }
        if (this.dWO != null) {
            this.dWO.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void a(e.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void VU() {
        if (this.dWN != null) {
            this.dWN.bq(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void Mi() {
    }

    public void ne(int i) {
        if (this.dIH != null && this.dWm != null) {
            if (i == 1 && this.dWm.awG()) {
                this.dWm.awH();
            }
            if (i == 2) {
                this.dWm.awI();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.e.b
    public void setData(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (!v.E(list)) {
            if (!this.dWP && this.dWM.size() > 0 && this.dWk.aAI() != null) {
                String str = this.dWk.aAI().threadId;
                com.baidu.tieba.frs.aggregation.f fVar = list.get(0);
                if (str.equals(fVar.threadId)) {
                    list.remove(fVar);
                }
                this.dWP = true;
            }
            this.dWM.addAll(list);
            this.mHasMore = z;
            if (!this.dWQ) {
                j(list, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (this.dWm != null) {
            if (this.dWL) {
                this.dWm.setData(list, true);
                this.dWL = false;
            } else {
                this.dWm.setData(list, false);
            }
        }
        if (!z) {
            this.dII.Eh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.caX.onChangeSkinType(getPageContext(), i);
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
        if (this.dWm != null) {
            this.dWm.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2 = 0;
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dWk.WN();
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
            if (!this.mHasMore && this.dWM.size() == absListView.getLastVisiblePosition() - headerViewsCount) {
                firstVisiblePosition = this.dWM.size() - 1;
            }
            if (this.dWm.awJ() != firstVisiblePosition) {
                this.dWm.ob(firstVisiblePosition);
            }
        }
        if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dWm != null) {
            if (i > this.dWm.awJ() || i + i2 < this.dWm.awJ()) {
                this.dWm.awK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.a.InterfaceC0159a
    public void nZ(int i) {
        if (this.dWm != null) {
            this.dWm.oa(i - 1);
        }
    }

    public boolean nc(int i) {
        if (this.dWm == null) {
            return false;
        }
        return this.dWm.nc(i);
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
