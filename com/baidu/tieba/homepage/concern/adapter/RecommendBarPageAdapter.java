package com.baidu.tieba.homepage.concern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fv6;
import com.repackage.gv6;
import com.repackage.iv6;
import com.repackage.uo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<uo> a;
    public List<iv6> b;
    public TbPageContext<?> c;
    public int d;
    public byte e;

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
            this.b.add(new iv6(LayoutInflater.from(this.c.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0715, (ViewGroup) null, false), this.c, b));
        }
    }

    public uo b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (ListUtils.isEmpty(this.a) || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (uo) invokeI.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.d == i) {
            return;
        }
        this.d = i;
        List<iv6> list = this.b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (iv6 iv6Var : this.b) {
            iv6Var.l(i);
        }
    }

    public void d(fv6 fv6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fv6Var) == null) || fv6Var == null || ListUtils.isEmpty(fv6Var.g())) {
            return;
        }
        this.a.clear();
        this.a.addAll(fv6Var.g());
        for (int i = 0; i < this.a.size() && i < this.b.size(); i++) {
            iv6 iv6Var = this.b.get(i);
            iv6Var.m(!fv6Var.i());
            iv6Var.c((uo) ListUtils.getItem(this.a, i));
        }
        notifyDataSetChanged();
        if (this.a.get(0) instanceof gv6) {
            gv6 gv6Var = (gv6) this.a.get(0);
            StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.e).param("obj_param1", 0);
            if (!StringUtils.isNull(gv6Var.a)) {
                param = param.param("obj_name", gv6Var.a);
            }
            TiebaStatic.log(param);
            StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", gv6Var.a()).param("obj_locate", (int) this.e);
            if (!StringUtils.isNull(gv6Var.a)) {
                param2 = param2.param("obj_name", gv6Var.a);
            }
            TiebaStatic.log(param2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
            viewGroup.removeView(this.b.get(i).b());
        }
    }

    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) || ListUtils.isEmpty(this.b)) {
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            iv6 iv6Var = this.b.get(i);
            gv6 j2 = iv6Var.j();
            if (j2 != null) {
                int i2 = 0;
                while (true) {
                    gv6.a[] aVarArr = j2.d;
                    if (i2 < aVarArr.length) {
                        if (aVarArr[i2].g() == j) {
                            iv6Var.n(i2, z);
                        }
                        i2++;
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            List<iv6> list = this.b;
            if (list == null) {
                return super.instantiateItem(viewGroup, i);
            }
            iv6 iv6Var = (iv6) ListUtils.getItem(list, i);
            if (iv6Var == null) {
                return super.instantiateItem(viewGroup, i);
            }
            if (iv6Var.b().getParent() == null) {
                viewGroup.addView(iv6Var.b(), new ViewGroup.LayoutParams(-2, -2));
            }
            iv6Var.b().setTag(Integer.valueOf(i));
            iv6Var.c((uo) ListUtils.getItem(this.a, i));
            return iv6Var.b();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }
}
