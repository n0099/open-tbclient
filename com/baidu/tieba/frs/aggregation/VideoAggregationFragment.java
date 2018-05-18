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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, d {
    private FrameLayout blc;
    private NoNetworkView blp;
    private BdTypeListView dcG;
    private PbListView dcH;
    private f dcI;
    private i dcJ;
    private boolean isFullScreen;
    private String mFrom;
    private String mId;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.f mPullView;
    private String st_type;
    private String yuelaou_locate;
    private List<g> mListData = null;
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gP()) {
                if (VideoAggregationFragment.this.mNoDataView != null) {
                    VideoAggregationFragment.this.dcJ.are();
                } else if (j.gR() && VideoAggregationFragment.this.dcI != null && VideoAggregationFragment.this.dcI.lB()) {
                    VideoAggregationFragment.this.getPageContext().showToast(d.k.video_mobile_play_tips);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoAggregationFragment.this.dcI != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Ai) {
                VideoAggregationFragment.this.dcI.C(data.toUid, data.isAttention);
            }
        }
    };

    public static VideoAggregationFragment l(String str, String str2, String str3, String str4) {
        VideoAggregationFragment videoAggregationFragment = new VideoAggregationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FID", str);
        bundle.putString("PARAM_FROM", str2);
        bundle.putString("st_type", str3);
        bundle.putString("yuelaou_locate", str4);
        videoAggregationFragment.setArguments(bundle);
        return videoAggregationFragment;
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
        this.dcJ = new i(getPageContext(), this);
        this.dcJ.setId(this.mId);
        this.dcJ.setFrom(this.mFrom);
        this.dcJ.lT(this.st_type);
        this.dcJ.setLocation(this.yuelaou_locate);
        this.dcJ.are();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.i.fragment_video_aggregation, (ViewGroup) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.blc = (FrameLayout) view2.findViewById(d.g.container);
        this.mNavigationBar = (NavigationBar) view2.findViewById(d.g.navigation_bar);
        ard();
        this.blp = (NoNetworkView) view2.findViewById(d.g.no_network_view);
        if (!j.gP()) {
            this.blp.setVisibility(0);
        }
        this.dcG = (BdTypeListView) view2.findViewById(d.g.listView);
        this.mPullView = new com.baidu.tbadk.core.view.f(getPageContext());
        this.mPullView.kz();
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                VideoAggregationFragment.this.dcJ.are();
            }
        });
        this.mPullView.setTag(getUniqueId());
        this.dcG.setPullRefresh(this.mPullView);
        this.dcH = new PbListView(getPageContext().getPageActivity());
        this.dcH.kz();
        this.dcH.wM();
        this.dcH.setText(getResources().getString(d.k.list_has_no_more));
        this.dcH.wQ();
        this.dcG.setNextPage(this.dcH);
        this.dcG.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
                    VideoAggregationFragment.this.dcJ.arg();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (VideoAggregationFragment.this.dcI != null) {
                    if (i > VideoAggregationFragment.this.dcI.ara() || i + i2 < VideoAggregationFragment.this.dcI.ara()) {
                        VideoAggregationFragment.this.dcI.arb();
                    }
                }
            }
        });
        this.dcI = new f(getPageContext(), this.dcG, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom));
        showLoadingView();
    }

    private void i(View view2, boolean z) {
        if (this.mNoDataView == null) {
            if (z) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), view2, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, 0, l.e(getPageContext().getPageActivity(), d.e.ds480), l.e(getPageContext().getPageActivity(), d.e.ds360)), NoDataViewFactory.d.af(getPageContext().getPageActivity().getString(d.k.neterror), getPageContext().getPageActivity().getString(d.k.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getPageActivity().getString(d.k.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        VideoAggregationFragment.this.hideNoDataView();
                        VideoAggregationFragment.this.dcJ.are();
                    }
                })));
            } else {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.blc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds220)), NoDataViewFactory.d.dp(d.k.video_no_data), null);
            }
        }
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.dcG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.setVisibility(8);
            this.dcG.setVisibility(0);
        }
    }

    private void ard() {
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.mFrom)) {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.video_aggregation_title));
        } else {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.video_middle_page_title));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoAggregationFragment.this.getActivity() != null && !VideoAggregationFragment.this.getActivity().isFinishing()) {
                    VideoAggregationFragment.this.getActivity().finish();
                }
            }
        });
    }

    public void kq(int i) {
        if (this.dcG != null && this.dcI != null) {
            if (i == 1 && this.dcI.lB()) {
                this.dcI.lz();
            }
            if (i == 2) {
                this.dcI.lA();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blp.onChangeSkinType(getPageContext(), i);
        ak.j(this.blc, d.C0126d.cp_cont_g);
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
        if (this.dcI != null) {
            this.dcI.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kq(2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        kq(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dcJ != null) {
            this.dcJ.arf();
        }
        if (this.dcI != null) {
            this.dcI.onDestroy();
        }
    }

    public void showLoadingView() {
        if (getPageContext() != null && this.blc != null) {
            showLoadingView(this.blc, false, l.e(getPageContext().getPageActivity(), d.e.ds360));
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void Os() {
        if (this.blc != null) {
            this.dcG.completePullRefreshPostDelayed(2000L);
            hideLoadingView(this.blc);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void EK() {
        if (v.w(this.mListData)) {
            i(this.blc, true);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void b(List<g> list, boolean z, boolean z2) {
        if (list != null) {
            if (z) {
                this.mListData = list;
            } else {
                this.mListData.addAll(list);
            }
            if (z && list.size() == 0) {
                i(this.blc, false);
                return;
            }
            this.dcI.setData(list, z);
            if (!z2) {
                this.dcH.wR();
            }
            hideNoDataView();
            if (this.mNoDataView != null) {
                this.blc.removeView(this.mNoDataView);
                this.mNoDataView = null;
            }
        }
    }

    public boolean kp(int i) {
        if (this.dcI == null) {
            return false;
        }
        return this.dcI.kp(i);
    }
}
