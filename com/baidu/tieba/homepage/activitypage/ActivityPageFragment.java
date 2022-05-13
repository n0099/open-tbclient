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
import com.repackage.fa5;
import com.repackage.g07;
import com.repackage.k07;
import com.repackage.p85;
import com.repackage.rz6;
import com.repackage.td6;
import com.repackage.tq4;
import com.repackage.us6;
import com.repackage.vb5;
import com.repackage.vm4;
import com.repackage.vs6;
import com.repackage.vz6;
import com.repackage.wz6;
import com.repackage.xo4;
import com.repackage.zn4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ActivityPageFragment extends BaseTemplateFragment implements td6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int d;
    public String e;
    public String f;
    public vm4<zn4> g;

    /* loaded from: classes3.dex */
    public class a implements vm4<zn4> {
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
        @Override // com.repackage.vm4
        /* renamed from: b */
        public void c(View view2, zn4 zn4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, zn4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                rz6.p(zn4Var, this.a.e);
                vb5.b("----曝光统计----position = " + i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vm4
        /* renamed from: d */
        public void a(View view2, zn4 zn4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, zn4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                rz6.j(view2, zn4Var, this.a.e);
                vb5.b("----点击统计----position = " + i);
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

    @Override // com.repackage.td6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.template.base.BaseTemplateFragment
    public fa5 D0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new wz6(getPageContext(), tq4.e));
            arrayList.add(new vz6(getPageContext(), xo4.b));
            arrayList.add(new g07(getPageContext()));
            arrayList.add(new k07(getPageContext()));
            fa5.c cVar = new fa5.c();
            cVar.m(309655);
            cVar.i(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
            cVar.j(TbConfig.URL_TAB_ACTIVITY_TAB);
            cVar.k(new us6(this.e, this.f));
            cVar.l(new vs6());
            cVar.d(this.g);
            cVar.c(new ActivityPageHeaderView(getActivity(), this.e, this.f));
            cVar.b(arrayList);
            return cVar.e(viewGroup);
        }
        return (fa5) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.m85
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
    public p85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            p85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.e;
            }
            return pageStayDurationItem;
        }
        return (p85) invokeV.objValue;
    }

    @Override // com.repackage.td6
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            G0();
        }
    }

    @Override // com.repackage.td6
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.repackage.td6
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
