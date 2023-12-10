package com.baidu.tieba.forbidden.fans;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.re7;
import com.baidu.tieba.se7;
import com.baidu.tieba.ue7;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public NavigationBar b;
    public NavigationBarCoverTip c;
    public TextView d;
    public BdRecyclerView e;
    public NoDataView f;
    public MyForbiddenFansListAdapter g;
    public se7 h;
    public ue7 i;
    public PbListView j;
    public TextView k;
    public se7.b l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public View.OnClickListener o;

    /* loaded from: classes5.dex */
    public class a implements se7.b {
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

        @Override // com.baidu.tieba.se7.b
        public void a(int i, String str, ArrayList<re7> arrayList) {
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
                } else if (i == 0) {
                    this.a.hideNoDataView();
                    this.a.W0(arrayList);
                    this.a.g.t(arrayList);
                    this.a.g.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (!BdUtilHelper.isNetOk()) {
                    MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                    myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.obfuscated_res_0x7f0f0e70));
                } else if (view2 == this.a.d) {
                    TiebaStatic.log(new StatisticItem("c13104").param("obj_locate", 2));
                    this.a.i.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (!BdUtilHelper.isNetOk()) {
                    MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                    myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.obfuscated_res_0x7f0f0e70));
                } else if (!(view2.getTag() instanceof re7)) {
                } else {
                    TiebaStatic.log(new StatisticItem("c13105"));
                    this.a.i.f(((re7) view2.getTag()).a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof re7)) {
                return;
            }
            re7 re7Var = (re7) view2.getTag();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getActivity(), String.valueOf(re7Var.a), re7Var.b)));
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.h.f() && this.a.j != null && !this.a.j.p()) {
                    this.a.j.U();
                }
                this.a.h.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ue7.e {
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

        @Override // com.baidu.tieba.ue7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                myForbiddenFansActivity.showLoadingDialog(myForbiddenFansActivity.getString(R.string.remove_fans_loading));
            }
        }

        @Override // com.baidu.tieba.ue7.e
        public void b(int i, String str, boolean z, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (z) {
                    if (i2 == 0) {
                        this.a.closeLoadingDialog();
                        if (i == 0) {
                            this.a.showNoDataView();
                        } else if (i == 2260104) {
                            return;
                        }
                        if (this.a.k == null) {
                            this.a.k = new TextView(this.a.getActivity());
                            this.a.k.setGravity(19);
                            this.a.k.setPadding(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, 0, 0);
                            this.a.k.setLayoutParams(new ViewGroup.LayoutParams(-1, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds112)));
                            this.a.k.setTextSize(0, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07045a));
                            this.a.k.setTextColor(this.a.getResources().getColor(R.color.CAM_X0101));
                        }
                        this.a.k.setText(str);
                        if (i == 0) {
                            this.a.c.setBackgroundColor(this.a.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            this.a.c.setBackgroundColor(this.a.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        this.a.c.k(this.a.getActivity(), this.a.k, 3000);
                    } else if (i2 != 1 || i == 2260104) {
                    } else {
                        if (i != 0) {
                            BdUtilHelper.showToast(this.a.getActivity(), str);
                        } else if (this.a.g.n(j)) {
                            if (this.a.g.q()) {
                                this.a.showNoDataView();
                            } else if (this.a.g.getItemCount() <= 20 && this.a.h.f()) {
                                this.a.h.h();
                            } else {
                                MyForbiddenFansActivity myForbiddenFansActivity = this.a;
                                myForbiddenFansActivity.W0(myForbiddenFansActivity.g.o());
                                this.a.g.notifyDataSetChanged();
                            }
                        }
                    }
                } else if (i == 0 && i2 == 1 && this.a.g.n(j)) {
                    if (this.a.g.q()) {
                        this.a.showNoDataView();
                    } else if (this.a.g.getItemCount() <= 20 && this.a.h.f()) {
                        this.a.h.h();
                    } else {
                        MyForbiddenFansActivity myForbiddenFansActivity2 = this.a;
                        myForbiddenFansActivity2.W0(myForbiddenFansActivity2.g.o());
                        this.a.g.notifyDataSetChanged();
                    }
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
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this);
        this.o = new d(this);
    }

    public final void W0(ArrayList<re7> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, arrayList) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.e.setNextPage(this.j);
        if (this.h.f()) {
            this.j.H(getString(R.string.pb_load_more));
            this.j.g();
            return;
        }
        this.j.H(getString(R.string.no_more_data_tip));
        this.j.g();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.d, (int) R.color.color_remove_all_title);
            this.g.notifyDataSetChanged();
            this.i.d();
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            this.j.J(SkinManager.getColor(R.color.CAM_X0109));
            this.j.e(i);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
        }
    }

    public final void hideNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.e.setVisibility(0);
            this.d.setEnabled(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.h.i();
            this.c.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d02ff);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0907fc);
            this.h = new se7();
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0919c4);
            this.b = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0786));
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.b.showBottomLine();
            this.d = this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f1268));
            this.c = (NavigationBarCoverTip) findViewById(R.id.obfuscated_res_0x7f0919bf);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f091622);
            this.e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.e.setOnSrollToBottomListener(new e(this));
            PbListView pbListView = new PbListView(getActivity());
            this.j = pbListView;
            pbListView.c();
            this.j.s(R.color.CAM_X0205);
            this.j.B();
            this.j.J(SkinManager.getColor(R.color.CAM_X0107));
            this.j.L(R.dimen.tbfontsize33);
            this.j.F(R.color.CAM_X0110);
            this.j.w(BdUtilHelper.getDimens(getActivity(), R.dimen.tbds182));
            this.j.v();
            MyForbiddenFansListAdapter myForbiddenFansListAdapter = new MyForbiddenFansListAdapter(this);
            this.g = myForbiddenFansListAdapter;
            this.e.setAdapter(myForbiddenFansListAdapter);
            this.h.j(this.l);
            this.i = new ue7(getPageContext(), getUniqueId());
            this.d.setOnClickListener(this.m);
            this.g.u(this.o);
            this.g.x(this.n);
            this.i.g(new f(this));
            showProgressBar(true, 0, 0);
            this.h.g();
        }
    }

    public final void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f == null) {
                NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.a, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070365)), null, null);
                this.f = a2;
                a2.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0e9b));
                this.f.setSubTitleTextColor(R.color.CAM_X0106);
                this.f.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setVisibility(0);
            this.e.setVisibility(8);
            this.d.setEnabled(false);
        }
    }
}
