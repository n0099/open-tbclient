package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity;
import com.baidu.tieba.ge6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class fe6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeamInfoActivity a;
    public BdListView b;
    public ge6 c;
    public NavigationBar d;
    public View e;
    public NoNetworkView f;
    public boolean g;
    public View h;
    public b35 i;
    public ge6.d j;
    public TextView k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ BawuTeamInfoActivity b;

        public a(fe6 fe6Var, long j, BawuTeamInfoActivity bawuTeamInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe6Var, Long.valueOf(j), bawuTeamInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = bawuTeamInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b, "", "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.a, true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ge6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe6 a;

        public b(fe6 fe6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fe6Var;
        }

        @Override // com.baidu.tieba.ge6.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
                } else {
                    this.a.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        }
    }

    public fe6(BawuTeamInfoActivity bawuTeamInfoActivity, long j) {
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
        this.a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0149, (ViewGroup) null);
        this.e = inflate;
        this.a.setContentView(inflate);
        this.h = this.e.findViewById(R.id.obfuscated_res_0x7f091c6d);
        NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.obfuscated_res_0x7f0925c2);
        this.d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f02fe));
        this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = new TextView(bawuTeamInfoActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ej.f(bawuTeamInfoActivity, R.dimen.tbds160), -2);
        layoutParams.rightMargin = ej.f(bawuTeamInfoActivity, R.dimen.M_W_X011);
        this.k.setText(R.string.obfuscated_res_0x7f0f0425);
        this.k.setTextColor(R.color.CAM_X0107);
        this.k.setLayoutParams(layoutParams);
        this.k.setOnClickListener(new a(this, j, bawuTeamInfoActivity));
        this.d.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).addView(this.k);
        this.d.showBottomLine();
        this.f = (NoNetworkView) this.e.findViewById(R.id.obfuscated_res_0x7f0925c4);
        this.b = (BdListView) this.e.findViewById(R.id.obfuscated_res_0x7f091334);
        ge6 ge6Var = new ge6(this.a.getPageContext());
        this.c = ge6Var;
        this.b.setAdapter((ListAdapter) ge6Var);
        b bVar = new b(this);
        this.j = bVar;
        this.c.f(bVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.e);
            this.b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.getLayoutMode().l(i == 1);
            this.a.getLayoutMode().k(this.e);
            this.d.onChangeSkinType(this.a.getPageContext(), i);
            this.f.d(this.a.getPageContext(), i);
            uu4 d = uu4.d(this.k);
            d.z(R.dimen.T_X07);
            d.v(R.color.CAM_X0107);
            this.c.notifyDataSetChanged();
        }
    }

    public void g() {
        b35 b35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (b35Var = this.i) == null) {
            return;
        }
        b35Var.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f.a(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.i == null) {
                this.i = new b35(this.a);
            }
            this.i.p();
            this.i.u(accountData);
            this.i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setVisibility(8);
            this.a.showNetRefreshView(this.e, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c73), true);
        }
    }

    public void k(ArrayList<he6> arrayList, xe6 xe6Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, xe6Var, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.g = false;
            } else {
                this.g = true;
            }
            if (z && this.g) {
                j();
                return;
            }
            c();
            this.c.d(arrayList);
            this.c.e(xe6Var);
            this.c.notifyDataSetChanged();
        }
    }
}
