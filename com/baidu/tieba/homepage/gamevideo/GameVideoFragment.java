package com.baidu.tieba.homepage.gamevideo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bv6;
import com.repackage.ge6;
import com.repackage.s55;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class GameVideoFragment extends BaseFragment implements ge6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bv6 a;

    public GameVideoFragment() {
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

    @Override // com.repackage.ge6
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.ge6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a066" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v85
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (super.getCurrentPageSourceKeyList() != null) {
                arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
            } else {
                arrayList = new ArrayList();
            }
            if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
                arrayList.add("a001");
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        bv6 bv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bv6Var = this.a) == null) {
            return;
        }
        bv6Var.v();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            bv6 bv6Var = this.a;
            if (bv6Var != null) {
                bv6Var.n();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5042);
            super.onCreate(bundle);
            if (this.a == null) {
                this.a = new bv6(this, getPageContext(), getUniqueId());
            }
            this.a.s();
            SpeedStatsManager.getInstance().addStatsTimeStamp(5043);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5044);
            bv6 bv6Var = this.a;
            if (bv6Var == null || bv6Var.r() == null) {
                view2 = null;
            } else {
                if (this.a.r().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.a.r().getParent()).removeView(this.a.r());
                }
                view2 = this.a.r();
            }
            if (view2 == null) {
                view2 = super.onCreateView(layoutInflater, viewGroup, bundle);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5045);
            return view2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            bv6 bv6Var = this.a;
            if (bv6Var != null) {
                bv6Var.w();
            }
            s55.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onLazyLoad();
            bv6 bv6Var = this.a;
            if (bv6Var != null) {
                bv6Var.t();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            bv6 bv6Var = this.a;
            if (bv6Var != null) {
                bv6Var.x();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
            }
            bv6 bv6Var = this.a;
            if (bv6Var != null) {
                bv6Var.z(isPrimary());
            }
        }
    }

    @Override // com.repackage.ge6
    public void t() {
        bv6 bv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bv6Var = this.a) == null) {
            return;
        }
        bv6Var.y();
    }

    @Override // com.repackage.ge6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}
