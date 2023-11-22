package com.baidu.tieba.homepage.activitypage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.template.base.BaseTemplateFragment;
import com.baidu.tieba.ag8;
import com.baidu.tieba.bw4;
import com.baidu.tieba.bx4;
import com.baidu.tieba.eg8;
import com.baidu.tieba.fg8;
import com.baidu.tieba.fq5;
import com.baidu.tieba.pg8;
import com.baidu.tieba.t78;
import com.baidu.tieba.tg8;
import com.baidu.tieba.u78;
import com.baidu.tieba.vr5;
import com.baidu.tieba.vu4;
import com.baidu.tieba.wq7;
import com.baidu.tieba.wy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ActivityPageFragment extends BaseTemplateFragment implements wq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int d;
    public String e;
    public String f;
    public vu4<bw4> g;

    @Override // com.baidu.tieba.wq7
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.wq7
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements vu4<bw4> {
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
        @Override // com.baidu.tieba.vu4
        /* renamed from: a */
        public void d(View view2, bw4 bw4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bw4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ag8.r(bw4Var, this.a.e);
                vr5.b("----曝光统计----position = " + i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vu4
        /* renamed from: c */
        public void b(View view2, bw4 bw4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, bw4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ag8.k(view2, bw4Var, this.a.e);
                vr5.b("----点击统计----position = " + i);
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

    @Override // com.baidu.tieba.wq7
    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.wq7
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            y2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.resourceId = this.e;
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.template.base.BaseTemplateFragment
    public fq5 v2(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new fg8(getPageContext(), wy4.e));
            arrayList.add(new eg8(getPageContext(), bx4.b));
            arrayList.add(new pg8(getPageContext()));
            arrayList.add(new tg8(getPageContext()));
            fq5.c cVar = new fq5.c();
            cVar.m(309655);
            cVar.i(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
            cVar.j(TbConfig.URL_TAB_ACTIVITY_TAB);
            cVar.k(new t78(this.e, this.f));
            cVar.l(new u78());
            cVar.d(this.g);
            cVar.c(new ActivityPageHeaderView(getActivity(), this.e, this.f));
            cVar.b(arrayList);
            return cVar.e(viewGroup);
        }
        return (fq5) invokeL.objValue;
    }
}
