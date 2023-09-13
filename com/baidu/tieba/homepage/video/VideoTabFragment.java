package com.baidu.tieba.homepage.video;

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
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.bo5;
import com.baidu.tieba.ia8;
import com.baidu.tieba.lj7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoTabFragment extends BaseFragment implements lj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ia8 a;
    public boolean b;

    @Override // com.baidu.tieba.lj7
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a067" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lj7
    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public VideoTabFragment() {
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
        this.b = false;
    }

    @Override // com.baidu.tieba.lj7
    public void F() {
        ia8 ia8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ia8Var = this.a) != null) {
            ia8Var.p();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        ia8 ia8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ia8Var = this.a) != null) {
            ia8Var.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            ia8 ia8Var = this.a;
            if (ia8Var != null) {
                ia8Var.n();
            }
            bo5.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLazyLoad();
            ia8 ia8Var = this.a;
            if (ia8Var != null) {
                ia8Var.l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            ia8 ia8Var = this.a;
            if (ia8Var != null) {
                ia8Var.o();
            }
        }
    }

    @Override // com.baidu.tieba.lj7
    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
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
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (!this.b) {
                    this.b = true;
                    TiebaStatic.log(new StatisticItem("c13579"));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
            }
            ia8 ia8Var = this.a;
            if (ia8Var != null) {
                ia8Var.q(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            ia8 ia8Var = this.a;
            if (ia8Var != null) {
                ia8Var.g();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            if (this.a == null) {
                this.a = new ia8(this, getPageContext(), getUniqueId());
            }
            this.a.k();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_VIEW_START_STAMP_KEY);
            ia8 ia8Var = this.a;
            if (ia8Var != null && ia8Var.j() != null) {
                if (this.a.j().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.a.j().getParent()).removeView(this.a.j());
                }
                return this.a.j();
            }
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }
}
