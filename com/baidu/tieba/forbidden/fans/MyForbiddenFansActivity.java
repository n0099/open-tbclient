package com.baidu.tieba.forbidden.fans;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.repackage.mi;
import com.repackage.u96;
import com.repackage.v96;
import com.repackage.x96;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MyForbiddenFansListAdapter mAdapter;
    public NavigationBarCoverTip mCoverTipNaviBar;
    public BdRecyclerView mListView;
    public PbListView mLoadMoreView;
    public v96 mModel;
    public NavigationBar mNavigationBar;
    public v96.b mNetDataCallBack;
    public NoDataView mNoDataView;
    public View.OnClickListener mPersonClick;
    public View.OnClickListener mRemoveAllClick;
    public x96 mRemoveController;
    public View.OnClickListener mRemoveSingleClick;
    public TextView mRemoveView;
    public TextView mResultTipView;
    public LinearLayout mRootView;

    /* loaded from: classes3.dex */
    public class a implements v96.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyForbiddenFansActivity a;

        public a(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myForbiddenFansActivity;
        }

        @Override // com.repackage.v96.b
        public void a(int i, String str, ArrayList<u96> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, arrayList) == null) {
                if (this.a.isProgressBarShown()) {
                    this.a.hideProgressBar();
                }
                if (i != 0) {
                    this.a.showToast(str);
                }
                if (ListUtils.isEmpty(arrayList)) {
                    this.a.showNoDataView();
                } else if (i != 0) {
                } else {
                    this.a.hideNoDataView();
                    this.a.updateLoadMoreView(arrayList);
                    this.a.mAdapter.k(arrayList);
                    this.a.mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyForbiddenFansActivity a;

        public b(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myForbiddenFansActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (mi.C()) {
                    if (view2 == this.a.mRemoveView) {
                        TiebaStatic.log(new StatisticItem("c13104").param("obj_locate", 2));
                        this.a.mRemoveController.e();
                        return;
                    }
                    return;
                }
                MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.obfuscated_res_0x7f0f0c2d));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyForbiddenFansActivity a;

        public c(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myForbiddenFansActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!mi.C()) {
                    MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                    myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.obfuscated_res_0x7f0f0c2d));
                } else if (view2.getTag() instanceof u96) {
                    TiebaStatic.log(new StatisticItem("c13105"));
                    this.a.mRemoveController.f(((u96) view2.getTag()).a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyForbiddenFansActivity a;

        public d(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myForbiddenFansActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof u96)) {
                u96 u96Var = (u96) view2.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getActivity(), String.valueOf(u96Var.a), u96Var.b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyForbiddenFansActivity a;

        public e(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myForbiddenFansActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.mModel.f() && this.a.mLoadMoreView != null && !this.a.mLoadMoreView.m()) {
                    this.a.mLoadMoreView.Q();
                }
                this.a.mModel.h();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements x96.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyForbiddenFansActivity a;

        public f(MyForbiddenFansActivity myForbiddenFansActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myForbiddenFansActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myForbiddenFansActivity;
        }

        @Override // com.repackage.x96.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                myForbiddenFansActivity.showLoadingDialog(myForbiddenFansActivity.getString(R.string.obfuscated_res_0x7f0f0f99));
            }
        }

        @Override // com.repackage.x96.e
        public void b(int i, String str, boolean z, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (!z) {
                    if (i == 0 && i2 == 1 && this.a.mAdapter.e(j)) {
                        if (this.a.mAdapter.h()) {
                            this.a.showNoDataView();
                        } else if (this.a.mAdapter.getItemCount() <= 20 && this.a.mModel.f()) {
                            this.a.mModel.h();
                        } else {
                            MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                            myForbiddenFansActivity.updateLoadMoreView(myForbiddenFansActivity.mAdapter.f());
                            this.a.mAdapter.notifyDataSetChanged();
                        }
                    }
                } else if (i2 == 0) {
                    this.a.closeLoadingDialog();
                    if (i == 0) {
                        this.a.showNoDataView();
                    } else if (i == 2260104) {
                        return;
                    }
                    if (this.a.mResultTipView == null) {
                        this.a.mResultTipView = new TextView(this.a.getActivity());
                        this.a.mResultTipView.setGravity(19);
                        this.a.mResultTipView.setPadding(mi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, 0, 0);
                        this.a.mResultTipView.setLayoutParams(new ViewGroup.LayoutParams(-1, mi.f(this.a.getActivity(), R.dimen.tbds112)));
                        this.a.mResultTipView.setTextSize(0, mi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070331));
                        this.a.mResultTipView.setTextColor(this.a.getResources().getColor(R.color.CAM_X0101));
                    }
                    this.a.mResultTipView.setText(str);
                    if (i == 0) {
                        this.a.mCoverTipNaviBar.setBackgroundColor(this.a.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                    } else {
                        this.a.mCoverTipNaviBar.setBackgroundColor(this.a.getResources().getColor(R.color.nav_bar_tip_error));
                    }
                    this.a.mCoverTipNaviBar.m(this.a.getActivity(), this.a.mResultTipView, 3000);
                } else if (i2 != 1 || i == 2260104) {
                } else {
                    if (i == 0) {
                        if (this.a.mAdapter.e(j)) {
                            if (this.a.mAdapter.h()) {
                                this.a.showNoDataView();
                                return;
                            } else if (this.a.mAdapter.getItemCount() <= 20 && this.a.mModel.f()) {
                                this.a.mModel.h();
                                return;
                            } else {
                                MyForbiddenFansActivity myForbiddenFansActivity2 = this.a;
                                myForbiddenFansActivity2.updateLoadMoreView(myForbiddenFansActivity2.mAdapter.f());
                                this.a.mAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                        return;
                    }
                    mi.N(this.a.getActivity(), str);
                }
            }
        }
    }

    public MyForbiddenFansActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, mi.f(getActivity(), R.dimen.obfuscated_res_0x7f07023f)), null, null);
                this.mNoDataView = a2;
                a2.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c4f));
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
                this.mNoDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            this.mRemoveView.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadMoreView(ArrayList<u96> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.mListView.setNextPage(this.mLoadMoreView);
        if (this.mModel.f()) {
            this.mLoadMoreView.C(getString(R.string.obfuscated_res_0x7f0f0dc3));
            this.mLoadMoreView.f();
            return;
        }
        this.mLoadMoreView.C(getString(R.string.obfuscated_res_0x7f0f0c5d));
        this.mLoadMoreView.f();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.mRemoveView, (int) R.color.color_remove_all_title);
            this.mAdapter.notifyDataSetChanged();
            this.mRemoveController.d();
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            this.mLoadMoreView.E(SkinManager.getColor(R.color.CAM_X0109));
            this.mLoadMoreView.d(i);
            SkinManager.setViewTextColor(this.mResultTipView, (int) R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d029e);
            this.mRootView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906d2);
            this.mModel = new v96();
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091517);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0642));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.showBottomLine();
            this.mRemoveView = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f0f93));
            this.mCoverTipNaviBar = (NavigationBarCoverTip) findViewById(R.id.obfuscated_res_0x7f091516);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f09128e);
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
            this.mLoadMoreView.t(mi.f(getActivity(), R.dimen.tbds182));
            this.mLoadMoreView.s();
            MyForbiddenFansListAdapter myForbiddenFansListAdapter = new MyForbiddenFansListAdapter(this);
            this.mAdapter = myForbiddenFansListAdapter;
            this.mListView.setAdapter(myForbiddenFansListAdapter);
            this.mModel.j(this.mNetDataCallBack);
            this.mRemoveController = new x96(getPageContext(), getUniqueId());
            this.mRemoveView.setOnClickListener(this.mRemoveAllClick);
            this.mAdapter.l(this.mPersonClick);
            this.mAdapter.m(this.mRemoveSingleClick);
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
            this.mCoverTipNaviBar.i();
        }
    }
}
