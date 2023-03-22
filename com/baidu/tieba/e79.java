package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumProgressView;
import com.baidu.tieba.v35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class e79 extends y8<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;
    public SignAllForumActivity a;
    public NavigationBar b;
    public RelativeLayout c;
    public SignAllForumProgressView d;
    public ProgressBar e;
    public BdListView f;
    public w35 g;
    public b79 h;
    public x69 i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e79 a;

        public a(e79 e79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e79(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.obfuscated_res_0x7f0d0833);
        this.c = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09209e);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.signallforum));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.b.showBottomLine();
        BdListView bdListView = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f0920be);
        this.f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        w35 w35Var = new w35(signAllForumActivity.getPageContext());
        this.g = w35Var;
        this.f.setPullRefresh(w35Var);
        TextView textView = (TextView) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0831, (ViewGroup) null);
        this.n = textView;
        this.f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.a.getPageContext().getPageActivity());
        this.d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.e = progressBar;
        progressBar.setOnClickListener(this.a);
        this.f.addHeaderView(this.d);
        this.d.setVisibility(8);
        this.j = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090e5b);
        this.m = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090e5d);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090e5e);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090e5c);
        this.m.setOnClickListener(this.a);
        b79 b79Var = new b79(this.a, null);
        this.h = b79Var;
        this.f.setAdapter((ListAdapter) b79Var);
        this.f.setOnScrollListener(this.h);
    }

    public void x(v35.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.g.f(gVar);
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f.setSelection(i);
        }
    }

    public void z(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            this.f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.E();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.z(0L);
        }
    }

    public b79 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (b79) invokeV.objValue;
    }

    public x69 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (x69) invokeV.objValue;
    }

    public LinearLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public BdListView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (BdListView) invokeV.objValue;
    }

    public ProgressBar r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final void m() {
        x69 x69Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (x69Var = this.i) == null) {
            return;
        }
        this.d.setHasPrivilege(x69Var.B());
        this.d.setmCurrentStatus(this.i.q());
        TextView message1 = this.d.getMessage1();
        SpannableString spannableString = new SpannableString(this.i.v() + this.i.t() + this.i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.i.t().length() + length, 33);
        message1.setText(spannableString);
        this.d.getMessage2().setText(this.i.w());
        this.k.setText(this.i.h());
        if (TextUtils.isEmpty(this.i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.i.g());
        }
        this.d.setVisibility(0);
        if (!this.i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            fv4 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.c);
            this.a.getLayoutMode().k(this.n);
            this.a.getLayoutMode().k(this.d);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            this.b.onChangeSkinType(getPageContext(), i);
            SignAllForumProgressView signAllForumProgressView = this.d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.k();
            }
            this.g.H(i);
            this.h.notifyDataSetChanged();
        }
    }

    public void u(x69 x69Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048587, this, x69Var, z) != null) || x69Var == null) {
            return;
        }
        this.i = x69Var;
        m();
        ArrayList<y69> k = x69Var.k();
        this.h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(x69Var.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.i.y();
        if (!StringUtils.isNull(y)) {
            this.d.l(this.a, y, this.i.z());
            return;
        }
        this.d.i();
    }
}
