package com.baidu.tieba.homepage.activitypage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.b1.b;
import c.a.t0.n.f;
import c.a.t0.q0.d;
import c.a.t0.s.r.v1;
import c.a.t0.s.r.x;
import c.a.u0.e1.o0;
import c.a.u0.p1.k.c;
import c.a.u0.p1.k.g.l;
import c.a.u0.p1.k.g.p;
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
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class ActivityPageFragment extends BaseTemplateFragment implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f44348h;

    /* renamed from: i  reason: collision with root package name */
    public String f44349i;

    /* renamed from: j  reason: collision with root package name */
    public String f44350j;
    public f<c.a.t0.s.r.a> k;

    /* loaded from: classes12.dex */
    public class a implements f<c.a.t0.s.r.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ActivityPageFragment f44351e;

        public a(ActivityPageFragment activityPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44351e = activityPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.n.f
        /* renamed from: b */
        public void c(View view, c.a.t0.s.r.a aVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, aVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c.p(aVar, this.f44351e.f44349i);
                c.a.t0.b1.h.a.b("----曝光统计----position = " + i2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.n.f
        /* renamed from: d */
        public void a(View view, c.a.t0.s.r.a aVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, aVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c.j(view, aVar, this.f44351e.f44349i);
                c.a.t0.b1.h.a.b("----点击统计----position = " + i2);
            }
        }
    }

    public ActivityPageFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44348h = 101;
        this.f44349i = "高考";
        this.f44350j = "gaokao";
        this.k = new a(this);
    }

    @Override // c.a.u0.e1.o0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.t0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f44348h == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.f44349i;
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    public String getTabCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44350j : (String) invokeV.objValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44349i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.template.base.BaseTemplateFragment
    public b onCreatePageLoader(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.a.u0.p1.k.g.b(getPageContext(), v1.f13975i));
            arrayList.add(new c.a.u0.p1.k.g.a(getPageContext(), x.f13988f));
            arrayList.add(new l(getPageContext()));
            arrayList.add(new p(getPageContext()));
            b.c cVar = new b.c();
            cVar.m(309655);
            cVar.i(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
            cVar.j(TbConfig.URL_TAB_ACTIVITY_TAB);
            cVar.k(new c.a.u0.p1.b.a(this.f44349i, this.f44350j));
            cVar.l(new c.a.u0.p1.b.b());
            cVar.d(this.k);
            cVar.c(new ActivityPageHeaderView(getActivity(), this.f44349i, this.f44350j));
            cVar.b(arrayList);
            return cVar.e(viewGroup);
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.u0.e1.o0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.u0.e1.o0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.u0.e1.o0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sendReq();
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }
}
