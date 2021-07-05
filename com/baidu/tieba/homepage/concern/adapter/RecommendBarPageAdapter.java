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
import d.a.c.k.e.n;
import d.a.s0.e1.c.f.c;
import d.a.s0.e1.c.f.d;
import d.a.s0.e1.c.g.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f16465a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f16466b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f16467c;

    /* renamed from: d  reason: collision with root package name */
    public int f16468d;

    /* renamed from: e  reason: collision with root package name */
    public byte f16469e;

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
        this.f16468d = 3;
        this.f16467c = tbPageContext;
        this.f16469e = b2;
        this.f16465a = new ArrayList(6);
        this.f16466b = new ArrayList(6);
        for (int i4 = 0; i4 < 6; i4++) {
            this.f16466b.add(new b(LayoutInflater.from(this.f16467c.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.f16467c, b2));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView(this.f16466b.get(i2).b());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.f16465a) : invokeV.intValue;
    }

    public n i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f16465a) || i2 >= this.f16465a.size()) {
                return null;
            }
            return this.f16465a.get(i2);
        }
        return (n) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            List<b> list = this.f16466b;
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
            bVar.c((n) ListUtils.getItem(this.f16465a, i2));
            return bVar.b();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f16468d == i2) {
            return;
        }
        this.f16468d = i2;
        List<b> list = this.f16466b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f16466b) {
            bVar.l(i2);
        }
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.c())) {
            return;
        }
        this.f16465a.clear();
        this.f16465a.addAll(cVar.c());
        for (int i2 = 0; i2 < this.f16465a.size() && i2 < this.f16466b.size(); i2++) {
            b bVar = this.f16466b.get(i2);
            bVar.m(!cVar.d());
            bVar.c((n) ListUtils.getItem(this.f16465a, i2));
        }
        notifyDataSetChanged();
        if (this.f16465a.get(0) instanceof d) {
            d dVar = (d) this.f16465a.get(0);
            StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f16469e).param("obj_param1", 0);
            if (!StringUtils.isNull(dVar.f58465e)) {
                param = param.param("obj_name", dVar.f58465e);
            }
            TiebaStatic.log(param);
            StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.b()).param("obj_locate", (int) this.f16469e);
            if (!StringUtils.isNull(dVar.f58465e)) {
                param2 = param2.param("obj_name", dVar.f58465e);
            }
            TiebaStatic.log(param2);
        }
    }

    public void l(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) || ListUtils.isEmpty(this.f16466b)) {
            return;
        }
        for (int i2 = 0; i2 < this.f16466b.size(); i2++) {
            b bVar = this.f16466b.get(i2);
            d j2 = bVar.j();
            if (j2 != null) {
                int i3 = 0;
                while (true) {
                    d.a[] aVarArr = j2.f58468h;
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
}
