package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i95;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class iia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleListActivity a;
    public View b;
    public NavigationBar c;
    public MemberRecommendView d;
    public BdListView e;
    public j95 f;
    public hia g;
    public int h;

    public iia(BubbleListActivity bubbleListActivity, dia diaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleListActivity, diaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = null;
        this.h = 0;
        this.a = bubbleListActivity;
        this.h = BdUtilHelper.getDimens(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070364);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d018a, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.setTitleText(R.string.obfuscated_res_0x7f0f03a7);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f092951);
        this.d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.e = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091548);
        j95 j95Var = new j95(this.a.getPageContext());
        this.f = j95Var;
        this.e.setPullRefresh(j95Var);
        TextView textView = new TextView(this.a.getActivity());
        textView.setHeight(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0701d5));
        this.e.addFooterView(textView);
        hia hiaVar = new hia(this.a.getPageContext(), diaVar);
        this.g = hiaVar;
        this.e.setAdapter((ListAdapter) hiaVar);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i = i + 1 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 2; i2++) {
                    int i3 = i + i2;
                    if (i3 < size) {
                        arrayList2.add(list.get(i3));
                    }
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean f(ria riaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, riaVar)) == null) {
            if (riaVar != null && !StringUtils.isNull(riaVar.c())) {
                this.d.setVisibility(0);
                this.d.e(riaVar);
                return true;
            }
            this.d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.b);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.b.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e.z(0L);
        }
    }

    public void d() {
        hia hiaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ks5.a(this.a.getPageContext(), this.b);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.e;
            if (bdListView != null && bdListView.getVisibility() == 0 && (hiaVar = this.g) != null) {
                hiaVar.notifyDataSetChanged();
            }
            j95 j95Var = this.f;
            if (j95Var != null) {
                j95Var.C(TbadkApplication.getInst().getSkinType());
            }
            this.d.d();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.b.setVisibility(8);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(this.h);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.e.setVisibility(0);
                this.g.b(list);
                this.g.notifyDataSetChanged();
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public void g(BdListView.p pVar, i95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.e.setOnSrollToBottomListener(pVar);
            this.f.a(gVar);
        }
    }

    public void i(ria riaVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, riaVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                f(riaVar);
                e(a(list));
                return;
            }
            h();
        }
    }
}
