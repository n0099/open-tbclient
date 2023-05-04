package com.baidu.tieba.homepage.activitypage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.template.base.BaseTemplateFragment;
import com.baidu.tieba.ax4;
import com.baidu.tieba.co5;
import com.baidu.tieba.im5;
import com.baidu.tieba.jv7;
import com.baidu.tieba.nv7;
import com.baidu.tieba.pn7;
import com.baidu.tieba.qn7;
import com.baidu.tieba.qv4;
import com.baidu.tieba.sp5;
import com.baidu.tieba.uu7;
import com.baidu.tieba.uz4;
import com.baidu.tieba.v77;
import com.baidu.tieba.yu7;
import com.baidu.tieba.zu7;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ActivityPageFragment extends BaseTemplateFragment implements v77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int d;
    public String e;
    public String f;
    public qv4<ax4> g;

    @Override // com.baidu.tieba.v77
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.v77
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements qv4<ax4> {
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
        @Override // com.baidu.tieba.qv4
        /* renamed from: a */
        public void c(View view2, ax4 ax4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ax4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                uu7.r(ax4Var, this.a.e);
                sp5.b("----曝光统计----position = " + i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qv4
        /* renamed from: b */
        public void d(View view2, ax4 ax4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, ax4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                uu7.k(view2, ax4Var, this.a.e);
                sp5.b("----点击统计----position = " + i);
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

    @Override // com.baidu.tieba.v77
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            J1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.fm5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public im5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            im5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.e;
            }
            return pageStayDurationItem;
        }
        return (im5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v77
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.template.base.BaseTemplateFragment
    public co5 G1(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new zu7(getPageContext(), uz4.e));
            arrayList.add(new yu7(getPageContext(), zx4.b));
            arrayList.add(new jv7(getPageContext()));
            arrayList.add(new nv7(getPageContext()));
            co5.c cVar = new co5.c();
            cVar.m(309655);
            cVar.i(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
            cVar.j(TbConfig.URL_TAB_ACTIVITY_TAB);
            cVar.k(new pn7(this.e, this.f));
            cVar.l(new qn7());
            cVar.d(this.g);
            cVar.c(new ActivityPageHeaderView(getActivity(), this.e, this.f));
            cVar.b(arrayList);
            return cVar.e(viewGroup);
        }
        return (co5) invokeL.objValue;
    }
}
