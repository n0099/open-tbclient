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
import d.a.d.k.e.n;
import d.a.q0.e1.c.f.c;
import d.a.q0.e1.c.f.d;
import d.a.q0.e1.c.g.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f16560a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f16561b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f16562c;

    /* renamed from: d  reason: collision with root package name */
    public int f16563d;

    /* renamed from: e  reason: collision with root package name */
    public byte f16564e;

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16563d = 3;
        this.f16562c = tbPageContext;
        this.f16564e = b2;
        this.f16560a = new ArrayList(6);
        this.f16561b = new ArrayList(6);
        for (int i4 = 0; i4 < 6; i4++) {
            this.f16561b.add(new b(LayoutInflater.from(this.f16562c.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.f16562c, b2));
        }
    }

    public n b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f16560a) || i2 >= this.f16560a.size()) {
                return null;
            }
            return this.f16560a.get(i2);
        }
        return (n) invokeI.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f16563d == i2) {
            return;
        }
        this.f16563d = i2;
        List<b> list = this.f16561b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f16561b) {
            bVar.l(i2);
        }
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.c())) {
            return;
        }
        this.f16560a.clear();
        this.f16560a.addAll(cVar.c());
        for (int i2 = 0; i2 < this.f16560a.size() && i2 < this.f16561b.size(); i2++) {
            b bVar = this.f16561b.get(i2);
            bVar.m(!cVar.d());
            bVar.c((n) ListUtils.getItem(this.f16560a, i2));
        }
        notifyDataSetChanged();
        if (this.f16560a.get(0) instanceof d) {
            d dVar = (d) this.f16560a.get(0);
            StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f16564e).param("obj_param1", 0);
            if (!StringUtils.isNull(dVar.f55754e)) {
                param = param.param("obj_name", dVar.f55754e);
            }
            TiebaStatic.log(param);
            StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.b()).param("obj_locate", (int) this.f16564e);
            if (!StringUtils.isNull(dVar.f55754e)) {
                param2 = param2.param("obj_name", dVar.f55754e);
            }
            TiebaStatic.log(param2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView(this.f16561b.get(i2).b());
        }
    }

    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) || ListUtils.isEmpty(this.f16561b)) {
            return;
        }
        for (int i2 = 0; i2 < this.f16561b.size(); i2++) {
            b bVar = this.f16561b.get(i2);
            d j2 = bVar.j();
            if (j2 != null) {
                int i3 = 0;
                while (true) {
                    d.a[] aVarArr = j2.f55757h;
                    if (i3 < aVarArr.length) {
                        if (aVarArr[i3].h() == j) {
                            bVar.n(i3, z);
                        }
                        i3++;
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f16560a) : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            List<b> list = this.f16561b;
            if (list == null) {
                return super.instantiateItem(viewGroup, i2);
            }
            b bVar = (b) ListUtils.getItem(list, i2);
            if (bVar == null) {
                return super.instantiateItem(viewGroup, i2);
            }
            if (bVar.b().getParent() == null) {
                viewGroup.addView(bVar.b(), new ViewGroup.LayoutParams(-2, -2));
            }
            bVar.b().setTag(Integer.valueOf(i2));
            bVar.c((n) ListUtils.getItem(this.f16560a, i2));
            return bVar.b();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }
}
