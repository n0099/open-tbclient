package com.baidu.tieba.frs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ot7;
import com.baidu.tieba.qs7;
import com.baidu.tieba.xo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FrsAllThreadFragment extends BaseFragment implements ot7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public RecyclerView b;
    public String c;

    @Override // com.baidu.tieba.ot7
    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    public FrsAllThreadFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ot7
    public void F() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (recyclerView = this.b) != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public xo5 getTbPageExtra() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity == null) {
                intent = null;
            } else {
                intent = baseFragmentActivity.getIntent();
            }
            return new xo5(getUniqueId(), "a006", this.mTbPageExtraPageTabName, intent);
        }
        return (xo5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ot7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            F();
            qs7 qs7Var = new qs7();
            qs7Var.a = 1;
            qs7Var.b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, qs7Var));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                G2(2, "4");
            } else {
                G2(2, "5");
            }
        }
    }

    public final void G2(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.c).param("obj_type", str).param("obj_locate", i).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void H2() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (view2 = this.a) != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
            this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void I2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.a = view2;
            this.b = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090d88);
            H2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.c = arguments.getString("forum_id", "");
            }
            H2();
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }
}
