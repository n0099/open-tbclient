package com.baidu.tieba.homepage.concern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import c.a.d.o.e.n;
import c.a.p0.q1.d.f.c;
import c.a.p0.q1.d.f.d;
import c.a.p0.q1.d.g.b;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f33209b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f33210c;

    /* renamed from: d  reason: collision with root package name */
    public int f33211d;

    /* renamed from: e  reason: collision with root package name */
    public byte f33212e;

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33211d = 3;
        this.f33210c = tbPageContext;
        this.f33212e = b2;
        this.a = new ArrayList(6);
        this.f33209b = new ArrayList(6);
        for (int i3 = 0; i3 < 6; i3++) {
            this.f33209b.add(new b(LayoutInflater.from(this.f33210c.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d071e, (ViewGroup) null, false), this.f33210c, b2));
        }
    }

    public n b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (ListUtils.isEmpty(this.a) || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (n) invokeI.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.f33211d == i) {
            return;
        }
        this.f33211d = i;
        List<b> list = this.f33209b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f33209b) {
            bVar.l(i);
        }
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.g())) {
            return;
        }
        this.a.clear();
        this.a.addAll(cVar.g());
        for (int i = 0; i < this.a.size() && i < this.f33209b.size(); i++) {
            b bVar = this.f33209b.get(i);
            bVar.m(!cVar.i());
            bVar.c((n) ListUtils.getItem(this.a, i));
        }
        notifyDataSetChanged();
        if (this.a.get(0) instanceof d) {
            d dVar = (d) this.a.get(0);
            StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f33212e).param("obj_param1", 0);
            if (!StringUtils.isNull(dVar.a)) {
                param = param.param("obj_name", dVar.a);
            }
            TiebaStatic.log(param);
            StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.a()).param("obj_locate", (int) this.f33212e);
            if (!StringUtils.isNull(dVar.a)) {
                param2 = param2.param("obj_name", dVar.a);
            }
            TiebaStatic.log(param2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
            viewGroup.removeView(this.f33209b.get(i).b());
        }
    }

    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) || ListUtils.isEmpty(this.f33209b)) {
            return;
        }
        for (int i = 0; i < this.f33209b.size(); i++) {
            b bVar = this.f33209b.get(i);
            d j2 = bVar.j();
            if (j2 != null) {
                int i2 = 0;
                while (true) {
                    d.a[] aVarArr = j2.f17205d;
                    if (i2 < aVarArr.length) {
                        if (aVarArr[i2].g() == j) {
                            bVar.n(i2, z);
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
            List<b> list = this.f33209b;
            if (list == null) {
                return super.instantiateItem(viewGroup, i);
            }
            b bVar = (b) ListUtils.getItem(list, i);
            if (bVar == null) {
                return super.instantiateItem(viewGroup, i);
            }
            if (bVar.b().getParent() == null) {
                viewGroup.addView(bVar.b(), new ViewGroup.LayoutParams(-2, -2));
            }
            bVar.b().setTag(Integer.valueOf(i));
            bVar.c((n) ListUtils.getItem(this.a, i));
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
