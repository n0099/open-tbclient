package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class fk8 extends y8<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public ViewGroup b;
    public GridView c;
    public View d;
    public ek8 e;
    public BubbleChooseActivity f;
    public ProgressBar g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fk8(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f = orignalPage;
        orignalPage.setContentView(R.layout.obfuscated_res_0x7f0d0175);
        NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.lay_title_bar);
        this.a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.setTitleText(R.string.editor_privilege);
        this.d = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0176, this.f);
        this.b = (ViewGroup) this.f.findViewById(R.id.obfuscated_res_0x7f090772);
        this.c = (GridView) this.f.findViewById(R.id.obfuscated_res_0x7f090e60);
        ek8 ek8Var = new ek8(tbPageContext);
        this.e = ek8Var;
        this.c.setAdapter((ListAdapter) ek8Var);
        this.g = (ProgressBar) this.f.findViewById(R.id.obfuscated_res_0x7f0904e7);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.setVisibility(8);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setVisibility(0);
        }
    }

    public ek8 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (ek8) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public GridView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (GridView) invokeV.objValue;
    }

    public void B(List<BubbleListData.BubbleData> list, boolean z) {
        ek8 ek8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) && (ek8Var = this.e) != null) {
            ek8Var.d(z);
            this.e.c(list);
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.onChangeSkinType((TbPageContext) getPageContext(), i);
            hv4 layoutMode = this.f.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.f.getLayoutMode().k(this.b);
        }
    }

    public BubbleListData.BubbleData z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ek8 ek8Var = this.e;
            if (ek8Var == null) {
                return null;
            }
            return ek8Var.getItem(i);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }
}
