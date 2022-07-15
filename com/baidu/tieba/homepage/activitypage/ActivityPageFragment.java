package com.baidu.tieba.homepage.activitypage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.template.base.BaseTemplateFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fc5;
import com.repackage.ge6;
import com.repackage.hq4;
import com.repackage.j07;
import com.repackage.jm4;
import com.repackage.lo4;
import com.repackage.n07;
import com.repackage.nn4;
import com.repackage.pa5;
import com.repackage.ps6;
import com.repackage.qs6;
import com.repackage.uz6;
import com.repackage.y85;
import com.repackage.yz6;
import com.repackage.zz6;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ActivityPageFragment extends BaseTemplateFragment implements ge6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int d;
    public String e;
    public String f;
    public jm4<nn4> g;

    /* loaded from: classes3.dex */
    public class a implements jm4<nn4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageFragment a;

        public a(ActivityPageFragment activityPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jm4
        /* renamed from: a */
        public void d(View view2, nn4 nn4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nn4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                uz6.t(nn4Var, this.a.e);
                fc5.b("----曝光统计----position = " + i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jm4
        /* renamed from: b */
        public void c(View view2, nn4 nn4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, nn4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                uz6.m(view2, nn4Var, this.a.e);
                fc5.b("----点击统计----position = " + i);
            }
        }
    }

    public ActivityPageFragment() {
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
        this.d = 101;
        this.e = "高考";
        this.f = "gaokao";
        this.g = new a(this);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public y85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            y85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.e;
            }
            return pageStayDurationItem;
        }
        return (y85) invokeV.objValue;
    }

    @Override // com.repackage.ge6
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w1();
        }
    }

    @Override // com.baidu.tbadk.template.base.BaseTemplateFragment
    public pa5 t1(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new zz6(getPageContext(), hq4.e));
            arrayList.add(new yz6(getPageContext(), lo4.b));
            arrayList.add(new j07(getPageContext()));
            arrayList.add(new n07(getPageContext()));
            pa5.c cVar = new pa5.c();
            cVar.m(309655);
            cVar.i(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
            cVar.j(TbConfig.URL_TAB_ACTIVITY_TAB);
            cVar.k(new ps6(this.e, this.f));
            cVar.l(new qs6());
            cVar.d(this.g);
            cVar.c(new ActivityPageHeaderView(getActivity(), this.e, this.f));
            cVar.b(arrayList);
            return cVar.e(viewGroup);
        }
        return (pa5) invokeL.objValue;
    }

    @Override // com.repackage.ge6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
