package com.baidu.tieba;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public BaseActivity<?> b;
    public NavigationBar c;
    public View d;
    public NoNetworkView e;
    public TextView f;
    public TextView g;

    public b69(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity;
        this.d = baseActivity.findViewById(R.id.obfuscated_res_0x7f09240b);
        this.a = (BdListView) baseActivity.findViewById(R.id.obfuscated_res_0x7f092407);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f092408);
        this.c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f15cb));
        this.f = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.b.getString(R.string.obfuscated_res_0x7f0f03ce), onClickListener);
        TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f060e), onClickListener);
        this.g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.leftMargin = BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f0701be);
        this.f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams2.rightMargin = BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f0701be);
        this.g.setLayoutParams(layoutParams2);
        int dimens = BdUtilHelper.getDimens(this.b, R.dimen.tbds27);
        this.g.setPadding(dimens, 0, dimens, 0);
        this.e = (NoNetworkView) baseActivity.findViewById(R.id.obfuscated_res_0x7f09241a);
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070266)));
        View view3 = new View(baseActivity.getPageContext().getPageActivity());
        view3.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9)));
        this.a.addFooterView(view2);
        this.a.addHeaderView(view3);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public void c(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            BDLayoutMode layoutMode = this.b.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.b.getLayoutMode().onModeChanged(this.d);
            this.e.onChangeSkinType(this.b.getPageContext(), i);
            this.c.onChangeSkinType(this.b.getPageContext(), i);
            SkinManager.setViewTextColor(this.g, (int) R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f, (int) R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.g, R.drawable.s_navbar_button_bg);
        }
    }

    public void d(x59 x59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, x59Var) == null) {
            this.a.setAdapter((ListAdapter) x59Var);
        }
    }

    public void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.g.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f05a7));
                return;
            }
            this.g.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f060e));
            this.g.setEnabled(!z2);
        }
    }
}
