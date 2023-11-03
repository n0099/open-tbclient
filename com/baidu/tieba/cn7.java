package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.dn7;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class cn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeamInfoActivity a;
    public BdListView b;
    public dn7 c;
    public NavigationBar d;
    public View e;
    public NoNetworkView f;
    public boolean g;
    public View h;
    public vb5 i;
    public dn7.d j;
    public TextView k;
    public String l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements dn7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cn7 a;

        public a(cn7 cn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cn7Var;
        }

        @Override // com.baidu.tieba.dn7.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.a.k(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cn7 a;

        public b(cn7 cn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cn7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 == this.a.k && !qd.isEmpty(this.a.l)) {
                UrlManager.getInstance().dealOneLink(this.a.l);
            }
        }
    }

    public cn7(BawuTeamInfoActivity bawuTeamInfoActivity, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bawuTeamInfoActivity, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.m = new b(this);
        this.a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d015a, (ViewGroup) null);
        this.e = inflate;
        this.a.setContentView(inflate);
        this.h = this.e.findViewById(R.id.obfuscated_res_0x7f091ff5);
        NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f033c));
        this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = new TextView(bawuTeamInfoActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(bawuTeamInfoActivity, R.dimen.tbds160), -2);
        layoutParams.rightMargin = BdUtilHelper.getDimens(bawuTeamInfoActivity, R.dimen.M_W_X011);
        this.k.setText(R.string.obfuscated_res_0x7f0f04ba);
        this.k.setTextColor(R.color.CAM_X0107);
        this.k.setLayoutParams(layoutParams);
        this.k.setOnClickListener(this.m);
        this.d.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).addView(this.k);
        this.d.showBottomLine();
        this.f = (NoNetworkView) this.e.findViewById(R.id.view_no_network);
        this.b = (BdListView) this.e.findViewById(R.id.obfuscated_res_0x7f0915a8);
        dn7 dn7Var = new dn7(this.a.getPageContext());
        this.c = dn7Var;
        this.b.setAdapter((ListAdapter) dn7Var);
        a aVar = new a(this);
        this.j = aVar;
        this.c.f(aVar);
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f.addNetworkChangeListener(bVar);
        }
    }

    public final void k(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.i == null) {
                this.i = new vb5(this.a);
            }
            this.i.p();
            this.i.u(accountData);
            this.i.z(1);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.e);
            this.b.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        vb5 vb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (vb5Var = this.i) != null) {
            vb5Var.s();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setVisibility(8);
            this.a.showNetRefreshView(this.e, this.a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void h(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.e);
            this.d.onChangeSkinType(this.a.getPageContext(), i);
            this.f.onChangeSkinType(this.a.getPageContext(), i);
            EMManager.from(this.k).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0107);
            this.c.notifyDataSetChanged();
        }
    }

    public void m(ArrayList<en7> arrayList, un7 un7Var, kn7 kn7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{arrayList, un7Var, kn7Var, Boolean.valueOf(z)}) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.g = false;
            } else {
                this.g = true;
            }
            if (kn7Var != null && kn7Var.b() != null) {
                this.l = kn7Var.b();
            }
            if (z && this.g) {
                l();
                return;
            }
            e();
            this.c.d(arrayList);
            this.c.e(un7Var);
            this.c.notifyDataSetChanged();
        }
    }
}
