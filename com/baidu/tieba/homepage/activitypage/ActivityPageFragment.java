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
import com.repackage.ay6;
import com.repackage.i75;
import com.repackage.ip4;
import com.repackage.jc6;
import com.repackage.kl4;
import com.repackage.ky6;
import com.repackage.mn4;
import com.repackage.om4;
import com.repackage.oy6;
import com.repackage.pa5;
import com.repackage.vx6;
import com.repackage.yq6;
import com.repackage.z85;
import com.repackage.zq6;
import com.repackage.zx6;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ActivityPageFragment extends BaseTemplateFragment implements jc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int d;
    public String e;
    public String f;
    public kl4<om4> g;

    /* loaded from: classes3.dex */
    public class a implements kl4<om4> {
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
        @Override // com.repackage.kl4
        /* renamed from: b */
        public void c(View view2, om4 om4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, om4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                vx6.p(om4Var, this.a.e);
                pa5.b("----曝光统计----position = " + i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.kl4
        /* renamed from: d */
        public void a(View view2, om4 om4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, om4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                vx6.j(view2, om4Var, this.a.e);
                pa5.b("----点击统计----position = " + i);
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

    @Override // com.repackage.jc6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.template.base.BaseTemplateFragment
    public z85 F0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ay6(getPageContext(), ip4.e));
            arrayList.add(new zx6(getPageContext(), mn4.b));
            arrayList.add(new ky6(getPageContext()));
            arrayList.add(new oy6(getPageContext()));
            z85.c cVar = new z85.c();
            cVar.m(309655);
            cVar.i(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
            cVar.j(TbConfig.URL_TAB_ACTIVITY_TAB);
            cVar.k(new yq6(this.e, this.f));
            cVar.l(new zq6());
            cVar.d(this.g);
            cVar.c(new ActivityPageHeaderView(getActivity(), this.e, this.f));
            cVar.b(arrayList);
            return cVar.e(viewGroup);
        }
        return (z85) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.f75
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
    public i75 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            i75 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.e;
            }
            return pageStayDurationItem;
        }
        return (i75) invokeV.objValue;
    }

    @Override // com.repackage.jc6
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            I0();
        }
    }

    @Override // com.repackage.jc6
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.repackage.jc6
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
