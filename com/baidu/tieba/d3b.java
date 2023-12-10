package com.baidu.tieba;

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
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public PersonalCardCategoryActivity b;
    public View c;
    public NavigationBar d;
    public NoNetworkView e;
    public MemberRecommendView f;
    public BdListView g;
    public c3b h;
    public View i;
    public TextView j;
    public int k;

    public d3b(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.k = 0;
        this.b = personalCardCategoryActivity;
        this.k = BdUtilHelper.getDimens(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070365);
        View inflate = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01fd, (ViewGroup) null);
        this.c = inflate;
        this.b.setContentView(inflate);
        this.i = this.c.findViewById(R.id.obfuscated_res_0x7f090444);
        NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f10ea);
        this.e = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.c.findViewById(R.id.obfuscated_res_0x7f09069b);
        this.f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.b.getActivity());
        this.j = textView;
        textView.setHeight(BdUtilHelper.getDimens(this.b.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        this.g = (BdListView) this.c.findViewById(R.id.obfuscated_res_0x7f09069a);
        c3b c3bVar = new c3b(this.b.getPageContext());
        this.h = c3bVar;
        this.g.setAdapter((ListAdapter) c3bVar);
    }

    public final List<Object> a(List<b3b> list) {
        InterceptResult invokeL;
        int size;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (b3b b3bVar : list) {
                ArrayList<e2b> a = b3bVar.a();
                if (a != null && (size = a.size()) != 0) {
                    arrayList.add(b3bVar.b());
                    if (size > 6) {
                        size = 6;
                    }
                    int i2 = 0;
                    while (i2 < size) {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (true) {
                            i = this.a;
                            if (i3 < i) {
                                int i4 = i2 + i3;
                                if (i4 < size) {
                                    arrayList2.add(a.get(i4));
                                }
                                i3++;
                            }
                        }
                        arrayList.add(arrayList2);
                        i2 = i2 + (i - 1) + 1;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.hideNetRefreshView(this.c);
            this.i.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        boolean z;
        c3b c3bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BDLayoutMode layoutMode = this.b.getLayoutMode();
            if (TbadkApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.b.getLayoutMode().onModeChanged(this.c);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.g;
            if (bdListView != null && bdListView.getVisibility() == 0 && (c3bVar = this.h) != null) {
                c3bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f.d();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        }
    }

    public final void e(List<b3b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.g.setVisibility(0);
                this.h.b(a(list));
                this.h.notifyDataSetChanged();
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final boolean f(j3b j3bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, j3bVar)) == null) {
            if (j3bVar != null && !StringUtils.isNull(j3bVar.c())) {
                this.f.setVisibility(0);
                this.f.e(j3bVar);
                return true;
            }
            this.f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PersonalCardItemView.b bVar) {
        c3b c3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (c3bVar = this.h) != null) {
            c3bVar.a(bVar);
        }
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.g.setOnSrollToBottomListener(pVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i.setVisibility(8);
            String string = this.b.getPageContext().getResources().getString(R.string.no_data_text);
            this.b.setNetRefreshViewTopMargin(this.k);
            this.b.showNetRefreshView(this.c, string, false);
        }
    }

    public void j(int i, j3b j3bVar, List<b3b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), j3bVar, list, Boolean.valueOf(z)}) == null) {
            if ((j3bVar != null && !StringUtils.isNull(j3bVar.c())) || (list != null && list.size() > 0)) {
                if (i != 0) {
                    return;
                }
                b();
                if (f(j3bVar)) {
                    this.g.removeHeaderView(this.j);
                    this.g.addHeaderView(this.j);
                } else {
                    this.g.removeHeaderView(this.j);
                }
                e(list);
                return;
            }
            i();
        }
    }
}
