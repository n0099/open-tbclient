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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, d {
    private FrameLayout buH;
    private NoNetworkView buT;
    private BdTypeListView doH;
    private PbListView doI;
    private f doJ;
    private i doK;
    private boolean isFullScreen;
    private String mFrom;
    private String mId;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private String st_type;
    private String yuelaou_locate;
    private List<g> mListData = null;
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jD()) {
                if (VideoAggregationFragment.this.mNoDataView != null) {
                    VideoAggregationFragment.this.doK.avM();
                } else if (j.jF() && VideoAggregationFragment.this.doJ != null && VideoAggregationFragment.this.doJ.or()) {
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoAggregationFragment.this.doJ != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Gr) {
                VideoAggregationFragment.this.doJ.D(data.toUid, data.isAttention);
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
        this.doK = new i(getPageContext(), this);
        this.doK.setId(this.mId);
        this.doK.setFrom(this.mFrom);
        this.doK.mA(this.st_type);
        this.doK.setLocation(this.yuelaou_locate);
        this.doK.avM();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.i.fragment_video_aggregation, (ViewGroup) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.buH = (FrameLayout) view.findViewById(d.g.container);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        arI();
        this.buT = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.jD()) {
            this.buT.setVisibility(0);
        }
        this.doH = (BdTypeListView) view.findViewById(d.g.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.mPullView.nn();
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                VideoAggregationFragment.this.doK.avM();
            }
        });
        this.mPullView.setTag(getUniqueId());
        this.doH.setPullRefresh(this.mPullView);
        this.doI = new PbListView(getPageContext().getPageActivity());
        this.doI.nn();
        this.doI.AD();
        this.doI.setText(getResources().getString(d.k.list_has_no_more));
        this.doI.AH();
        this.doH.setNextPage(this.doI);
        this.doH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
                    VideoAggregationFragment.this.doK.avO();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (VideoAggregationFragment.this.doJ != null) {
                    if (i > VideoAggregationFragment.this.doJ.avJ() || i + i2 < VideoAggregationFragment.this.doJ.avJ()) {
                        VideoAggregationFragment.this.doJ.avK();
                    }
                }
            }
        });
        this.doJ = new f(getPageContext(), this.doH, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom));
        showLoadingView();
    }

    private void i(View view, boolean z) {
        if (this.mNoDataView == null) {
            if (z) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, 0, l.e(getPageContext().getPageActivity(), d.e.ds480), l.e(getPageContext().getPageActivity(), d.e.ds360)), NoDataViewFactory.d.aj(getPageContext().getPageActivity().getString(d.k.neterror), getPageContext().getPageActivity().getString(d.k.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getPageActivity().getString(d.k.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        VideoAggregationFragment.this.hideNoDataView();
                        VideoAggregationFragment.this.doK.avM();
                    }
                })));
            } else {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.buH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds220)), NoDataViewFactory.d.ds(d.k.video_no_data), null);
            }
        }
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.doH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.setVisibility(8);
            this.doH.setVisibility(0);
        }
    }

    private void arI() {
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.mFrom)) {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.video_aggregation_title));
        } else {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.video_middle_page_title));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoAggregationFragment.this.getActivity() != null && !VideoAggregationFragment.this.getActivity().isFinishing()) {
                    VideoAggregationFragment.this.getActivity().finish();
                }
            }
        });
    }

    public void kC(int i) {
        if (this.doH != null && this.doJ != null) {
            if (i == 1 && this.doJ.or()) {
                this.doJ.op();
            }
            if (i == 2) {
                this.doJ.oq();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.buT.onChangeSkinType(getPageContext(), i);
        am.j(this.buH, d.C0142d.cp_cont_g);
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
        if (this.doJ != null) {
            this.doJ.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kC(2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        kC(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.doK != null) {
            this.doK.avN();
        }
        if (this.doJ != null) {
            this.doJ.onDestroy();
        }
    }

    public void showLoadingView() {
        if (getPageContext() != null && this.buH != null) {
            showLoadingView(this.buH, false, l.e(getPageContext().getPageActivity(), d.e.ds360));
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void hideLoadingView() {
        if (this.buH != null) {
            this.doH.completePullRefreshPostDelayed(2000L);
            hideLoadingView(this.buH);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void IG() {
        if (w.A(this.mListData)) {
            i(this.buH, true);
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
                i(this.buH, false);
                return;
            }
            this.doJ.setData(list, z);
            if (!z2) {
                this.doI.AI();
            }
            hideNoDataView();
            if (this.mNoDataView != null) {
                this.buH.removeView(this.mNoDataView);
                this.mNoDataView = null;
            }
        }
    }

    public boolean kB(int i) {
        if (this.doJ == null) {
            return false;
        }
        return this.doJ.kB(i);
    }
}
