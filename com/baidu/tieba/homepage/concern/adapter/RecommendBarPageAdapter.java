package com.baidu.tieba.homepage.concern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.k18;
import com.baidu.tieba.n18;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yn> a;
    public List<n18> b;
    public TbPageContext<?> c;
    public int d;
    public byte e;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Byte.valueOf(b)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 3;
        this.c = tbPageContext;
        this.e = b;
        this.a = new ArrayList(6);
        this.b = new ArrayList(6);
        for (int i3 = 0; i3 < 6; i3++) {
            this.b.add(new n18(LayoutInflater.from(this.c.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d083f, (ViewGroup) null, false), this.c, b));
        }
    }

    public yn b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (!ListUtils.isEmpty(this.a) && i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (yn) invokeI.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.d == i) {
            return;
        }
        this.d = i;
        List<n18> list = this.b;
        if (list != null && list.size() > 0) {
            for (n18 n18Var : this.b) {
                n18Var.o(i);
            }
        }
    }

    public final void e(k18 k18Var) {
        k18.a[] aVarArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, k18Var) != null) || k18Var == null) {
            return;
        }
        for (k18.a aVar : k18Var.g) {
            if (aVar != null) {
                TiebaStatic.log(new StatisticItem("c15342").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", aVar.e()));
            }
        }
    }

    public final void d(yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ynVar) == null) && (ynVar instanceof k18)) {
            k18 k18Var = (k18) ynVar;
            if (k18Var.f() && !k18Var.e()) {
                int b = k18Var.b();
                for (int i = 0; i < b; i++) {
                    k18.a[] aVarArr = k18Var.g;
                    if (aVarArr[i] != null) {
                        k18.a aVar = aVarArr[i];
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_HOMEPAGE_RECFORUM_CARD_INNERFORUM_SHOW);
                        statisticItem.addParam("fid", aVar.e());
                        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(statisticItem);
                    }
                }
                k18Var.i(true);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
            viewGroup.removeView(this.b.get(i).b());
        }
    }

    public void f(RecommendBarCardModel recommendBarCardModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, recommendBarCardModel) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.h())) {
            this.a.clear();
            this.a.addAll(recommendBarCardModel.h());
            for (int i = 0; i < this.a.size() && i < this.b.size(); i++) {
                n18 n18Var = this.b.get(i);
                n18Var.r(!recommendBarCardModel.k());
                n18Var.c((yn) ListUtils.getItem(this.a, i));
                d((yn) ListUtils.getItem(this.a, i));
            }
            notifyDataSetChanged();
            if (this.a.get(0) instanceof k18) {
                k18 k18Var = (k18) this.a.get(0);
                StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.e).param("obj_param1", 0);
                if (!StringUtils.isNull(k18Var.a)) {
                    param = param.param("obj_name", k18Var.a);
                }
                TiebaStatic.log(param);
                StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", k18Var.a()).param("obj_locate", (int) this.e);
                if (!StringUtils.isNull(k18Var.a)) {
                    param2 = param2.param("obj_name", k18Var.a);
                }
                TiebaStatic.log(param2);
                e(k18Var);
            }
        }
    }

    public void g(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) != null) || ListUtils.isEmpty(this.b)) {
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            n18 n18Var = this.b.get(i);
            k18 l = n18Var.l();
            if (l != null) {
                int i2 = 0;
                while (true) {
                    k18.a[] aVarArr = l.g;
                    if (i2 < aVarArr.length) {
                        if (aVarArr[i2].e() == j) {
                            n18Var.s(i2, z);
                        }
                        i2++;
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
            List<n18> list = this.b;
            if (list == null) {
                return super.instantiateItem(viewGroup, i);
            }
            n18 n18Var = (n18) ListUtils.getItem(list, i);
            if (n18Var == null) {
                return super.instantiateItem(viewGroup, i);
            }
            if (n18Var.b().getParent() == null) {
                viewGroup.addView(n18Var.b(), new ViewGroup.LayoutParams(-2, -2));
            }
            n18Var.b().setTag(Integer.valueOf(i));
            n18Var.c((yn) ListUtils.getItem(this.a, i));
            return n18Var.b();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }
}
