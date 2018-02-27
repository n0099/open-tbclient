package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends BaseFragment implements View.OnClickListener, c {
    private FrameLayout caK;
    private NoNetworkView caX;
    private BdTypeListView dIH;
    private PbListView dII;
    private e dIJ;
    private i dIK;
    private boolean isFullScreen;
    private String mFrom;
    private String mId;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private k mPullView;
    private String st_type;
    private String yuelaou_locate;
    private List<f> mListData = null;
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.aggregation.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oJ()) {
                if (g.this.mNoDataView != null) {
                    g.this.dIK.awN();
                } else if (j.oL() && g.this.dIJ != null && g.this.dIJ.awG()) {
                    g.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && g.this.dIJ != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.apG) {
                g.this.dIJ.F(data.toUid, data.isAttention);
            }
        }
    };

    public static g l(String str, String str2, String str3, String str4) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FID", str);
        bundle.putString("PARAM_FROM", str2);
        bundle.putString("st_type", str3);
        bundle.putString("yuelaou_locate", str4);
        gVar.setArguments(bundle);
        return gVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mId = arguments.getString("PARAM_FID");
            this.mFrom = arguments.getString("PARAM_FROM");
            this.st_type = arguments.getString("st_type");
            this.yuelaou_locate = arguments.getString("yuelaou_locate");
        }
        this.dIK = new i(getPageContext(), this);
        this.dIK.setId(this.mId);
        this.dIK.setFrom(this.mFrom);
        this.dIK.lN(this.st_type);
        this.dIK.setLocation(this.yuelaou_locate);
        this.dIK.awN();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.h.fragment_video_aggregation, (ViewGroup) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.caK = (FrameLayout) view.findViewById(d.g.container);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        awM();
        this.caX = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.oJ()) {
            this.caX.setVisibility(0);
        }
        this.dIH = (BdTypeListView) view.findViewById(d.g.listView);
        this.mPullView = new k(getPageContext());
        this.mPullView.st();
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.frs.aggregation.g.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                g.this.dIK.awN();
            }
        });
        this.mPullView.setTag(getUniqueId());
        this.dIH.setPullRefresh(this.mPullView);
        this.dII = new PbListView(getPageContext().getPageActivity());
        this.dII.st();
        this.dII.Eb();
        this.dII.setText(getResources().getString(d.j.list_has_no_more));
        this.dII.Ef();
        this.dIH.setNextPage(this.dII);
        this.dIH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.aggregation.g.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
                    g.this.dIK.awP();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (g.this.dIJ != null) {
                    if (i > g.this.dIJ.awJ() || i + i2 < g.this.dIJ.awJ()) {
                        g.this.dIJ.awK();
                    }
                }
            }
        });
        this.dIJ = new e(getPageContext(), this.dIH, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom));
        VT();
    }

    private void o(View view, boolean z) {
        if (this.mNoDataView == null) {
            if (z) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, 0, l.t(getPageContext().getPageActivity(), d.e.ds480), l.t(getPageContext().getPageActivity(), d.e.ds360)), NoDataViewFactory.d.ae(getPageContext().getPageActivity().getString(d.j.neterror), getPageContext().getPageActivity().getString(d.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getPageActivity().getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.g.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        g.this.hideNoDataView();
                        g.this.dIK.awN();
                    }
                })));
            } else {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.caK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds220)), NoDataViewFactory.d.gp(d.j.video_no_data), null);
            }
        }
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.dIH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.setVisibility(8);
            this.dIH.setVisibility(0);
        }
    }

    private void awM() {
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.mFrom)) {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.video_aggregation_title));
        } else {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.video_middle_page_title));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.getActivity() != null && !g.this.getActivity().isFinishing()) {
                    g.this.getActivity().finish();
                }
            }
        });
    }

    public void ne(int i) {
        if (this.dIH != null && this.dIJ != null) {
            if (i == 1 && this.dIJ.awG()) {
                this.dIJ.awH();
            }
            if (i == 2) {
                this.dIJ.awI();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.caX.onChangeSkinType(getPageContext(), i);
        aj.t(this.caK, d.C0141d.cp_cont_g);
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
        if (this.dIJ != null) {
            this.dIJ.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ne(2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        ne(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dIK != null) {
            this.dIK.awO();
        }
        if (this.dIJ != null) {
            this.dIJ.onDestroy();
        }
    }

    public void VT() {
        if (getPageContext() != null && this.caK != null) {
            showLoadingView(this.caK, false, l.t(getPageContext().getPageActivity(), d.e.ds360));
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void VU() {
        if (this.caK != null) {
            this.dIH.completePullRefreshPostDelayed(2000L);
            hideLoadingView(this.caK);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void Mi() {
        if (v.E(this.mListData)) {
            o(this.caK, true);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void a(List<f> list, boolean z, boolean z2) {
        if (list != null) {
            if (z) {
                this.mListData = list;
            } else {
                this.mListData.addAll(list);
            }
            if (z && list.size() == 0) {
                o(this.caK, false);
                return;
            }
            this.dIJ.setData(list, z);
            if (!z2) {
                this.dII.Eg();
            }
            hideNoDataView();
            if (this.mNoDataView != null) {
                this.caK.removeView(this.mNoDataView);
                this.mNoDataView = null;
            }
        }
    }

    public boolean nc(int i) {
        if (this.dIJ == null) {
            return false;
        }
        return this.dIJ.nc(i);
    }
}
