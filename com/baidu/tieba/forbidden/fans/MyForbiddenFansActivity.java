package com.baidu.tieba.forbidden.fans;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.a.e.e.p.l;
import b.a.r0.u0.a.b;
import b.a.r0.u0.a.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MyForbiddenFansListAdapter mAdapter;
    public NavigationBarCoverTip mCoverTipNaviBar;
    public BdRecyclerView mListView;
    public PbListView mLoadMoreView;
    public b.a.r0.u0.a.b mModel;
    public NavigationBar mNavigationBar;
    public b.InterfaceC1163b mNetDataCallBack;
    public NoDataView mNoDataView;
    public View.OnClickListener mPersonClick;
    public View.OnClickListener mRemoveAllClick;
    public b.a.r0.u0.a.d mRemoveController;
    public View.OnClickListener mRemoveSingleClick;
    public TextView mRemoveView;
    public TextView mResultTipView;
    public LinearLayout mRootView;

    /* loaded from: classes9.dex */
    public class a implements b.InterfaceC1163b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyForbiddenFansActivity f48141a;

        public a(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48141a = myForbiddenFansActivity;
        }

        @Override // b.a.r0.u0.a.b.InterfaceC1163b
        public void a(int i2, String str, ArrayList<b.a.r0.u0.a.a> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, arrayList) == null) {
                if (this.f48141a.isProgressBarShown()) {
                    this.f48141a.hideProgressBar();
                }
                if (i2 != 0) {
                    this.f48141a.showToast(str);
                }
                if (ListUtils.isEmpty(arrayList)) {
                    this.f48141a.showNoDataView();
                } else if (i2 != 0) {
                } else {
                    this.f48141a.hideNoDataView();
                    this.f48141a.updateLoadMoreView(arrayList);
                    this.f48141a.mAdapter.setFansList(arrayList);
                    this.f48141a.mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyForbiddenFansActivity f48142e;

        public b(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48142e = myForbiddenFansActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.D()) {
                    if (view == this.f48142e.mRemoveView) {
                        TiebaStatic.log(new StatisticItem("c13104").param("obj_locate", 2));
                        this.f48142e.mRemoveController.e();
                        return;
                    }
                    return;
                }
                MyForbiddenFansActivity myForbiddenFansActivity = this.f48142e;
                myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyForbiddenFansActivity f48143e;

        public c(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48143e = myForbiddenFansActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!l.D()) {
                    MyForbiddenFansActivity myForbiddenFansActivity = this.f48143e;
                    myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.neterror));
                } else if (view.getTag() instanceof b.a.r0.u0.a.a) {
                    TiebaStatic.log(new StatisticItem("c13105"));
                    this.f48143e.mRemoveController.f(((b.a.r0.u0.a.a) view.getTag()).f23959a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyForbiddenFansActivity f48144e;

        public d(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48144e = myForbiddenFansActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof b.a.r0.u0.a.a)) {
                b.a.r0.u0.a.a aVar = (b.a.r0.u0.a.a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f48144e.getActivity(), String.valueOf(aVar.f23959a), aVar.f23960b)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyForbiddenFansActivity f48145e;

        public e(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48145e = myForbiddenFansActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48145e.mModel.f() && this.f48145e.mLoadMoreView != null && !this.f48145e.mLoadMoreView.m()) {
                    this.f48145e.mLoadMoreView.Q();
                }
                this.f48145e.mModel.h();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyForbiddenFansActivity f48146a;

        public f(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48146a = myForbiddenFansActivity;
        }

        @Override // b.a.r0.u0.a.d.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MyForbiddenFansActivity myForbiddenFansActivity = this.f48146a;
                myForbiddenFansActivity.showLoadingDialog(myForbiddenFansActivity.getString(R.string.remove_fans_loading));
            }
        }

        @Override // b.a.r0.u0.a.d.e
        public void b(int i2, String str, boolean z, int i3, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
                if (!z) {
                    if (i2 == 0 && i3 == 1 && this.f48146a.mAdapter.deleteRemovedUser(j)) {
                        if (this.f48146a.mAdapter.isListEmpty()) {
                            this.f48146a.showNoDataView();
                        } else if (this.f48146a.mAdapter.getItemCount() <= 20 && this.f48146a.mModel.f()) {
                            this.f48146a.mModel.h();
                        } else {
                            MyForbiddenFansActivity myForbiddenFansActivity = this.f48146a;
                            myForbiddenFansActivity.updateLoadMoreView(myForbiddenFansActivity.mAdapter.getFansList());
                            this.f48146a.mAdapter.notifyDataSetChanged();
                        }
                    }
                } else if (i3 == 0) {
                    this.f48146a.closeLoadingDialog();
                    if (i2 == 0) {
                        this.f48146a.showNoDataView();
                    } else if (i2 == 2260104) {
                        return;
                    }
                    if (this.f48146a.mResultTipView == null) {
                        this.f48146a.mResultTipView = new TextView(this.f48146a.getActivity());
                        this.f48146a.mResultTipView.setGravity(19);
                        this.f48146a.mResultTipView.setPadding(l.g(this.f48146a.getActivity(), R.dimen.ds34), 0, 0, 0);
                        this.f48146a.mResultTipView.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(this.f48146a.getActivity(), R.dimen.tbds112)));
                        this.f48146a.mResultTipView.setTextSize(0, l.g(this.f48146a.getActivity(), R.dimen.fontsize30));
                        this.f48146a.mResultTipView.setTextColor(this.f48146a.getResources().getColor(R.color.CAM_X0101));
                    }
                    this.f48146a.mResultTipView.setText(str);
                    if (i2 == 0) {
                        this.f48146a.mCoverTipNaviBar.setBackgroundColor(this.f48146a.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                    } else {
                        this.f48146a.mCoverTipNaviBar.setBackgroundColor(this.f48146a.getResources().getColor(R.color.nav_bar_tip_error));
                    }
                    this.f48146a.mCoverTipNaviBar.showTip(this.f48146a.getActivity(), this.f48146a.mResultTipView, 3000);
                } else if (i3 != 1 || i2 == 2260104) {
                } else {
                    if (i2 == 0) {
                        if (this.f48146a.mAdapter.deleteRemovedUser(j)) {
                            if (this.f48146a.mAdapter.isListEmpty()) {
                                this.f48146a.showNoDataView();
                                return;
                            } else if (this.f48146a.mAdapter.getItemCount() <= 20 && this.f48146a.mModel.f()) {
                                this.f48146a.mModel.h();
                                return;
                            } else {
                                MyForbiddenFansActivity myForbiddenFansActivity2 = this.f48146a;
                                myForbiddenFansActivity2.updateLoadMoreView(myForbiddenFansActivity2.mAdapter.getFansList());
                                this.f48146a.mAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                        return;
                    }
                    l.M(this.f48146a.getActivity(), str);
                }
            }
        }
    }

    public MyForbiddenFansActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNetDataCallBack = new a(this);
        this.mRemoveAllClick = new b(this);
        this.mRemoveSingleClick = new c(this);
        this.mPersonClick = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.mListView.setVisibility(0);
            this.mRemoveView.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.mNoDataView == null) {
                NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds120)), null, null);
                this.mNoDataView = a2;
                a2.setTextOption(NoDataViewFactory.e.a(R.string.no_forbidden_fans));
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
                this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            this.mRemoveView.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadMoreView(ArrayList<b.a.r0.u0.a.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.mListView.setNextPage(this.mLoadMoreView);
        if (this.mModel.f()) {
            this.mLoadMoreView.C(getString(R.string.pb_load_more));
            this.mLoadMoreView.f();
            return;
        }
        this.mLoadMoreView.C(getString(R.string.no_more_data_tip));
        this.mLoadMoreView.f();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.mRemoveView, R.color.color_remove_all_title);
            this.mAdapter.notifyDataSetChanged();
            this.mRemoveController.d();
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            this.mLoadMoreView.E(SkinManager.getColor(R.color.CAM_X0109));
            this.mLoadMoreView.d(i2);
            SkinManager.setViewTextColor(this.mResultTipView, R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.forbidden_fans_list_layout);
            this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
            this.mModel = new b.a.r0.u0.a.b();
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.showBottomLine();
            this.mRemoveView = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
            this.mCoverTipNaviBar = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
            this.mListView = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.mListView.setOnSrollToBottomListener(new e(this));
            PbListView pbListView = new PbListView(getActivity());
            this.mLoadMoreView = pbListView;
            pbListView.b();
            this.mLoadMoreView.p(R.color.CAM_X0205);
            this.mLoadMoreView.x();
            this.mLoadMoreView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.mLoadMoreView.G(R.dimen.tbfontsize33);
            this.mLoadMoreView.A(R.color.CAM_X0110);
            this.mLoadMoreView.s(l.g(getActivity(), R.dimen.tbds182));
            this.mLoadMoreView.r();
            MyForbiddenFansListAdapter myForbiddenFansListAdapter = new MyForbiddenFansListAdapter(this);
            this.mAdapter = myForbiddenFansListAdapter;
            this.mListView.setAdapter(myForbiddenFansListAdapter);
            this.mModel.j(this.mNetDataCallBack);
            this.mRemoveController = new b.a.r0.u0.a.d(getPageContext(), getUniqueId());
            this.mRemoveView.setOnClickListener(this.mRemoveAllClick);
            this.mAdapter.setPersonClickListener(this.mPersonClick);
            this.mAdapter.setRemoveClickListener(this.mRemoveSingleClick);
            this.mRemoveController.g(new f(this));
            showProgressBar(true, 0, 0);
            this.mModel.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mModel.i();
            this.mCoverTipNaviBar.onDestroy();
        }
    }
}
