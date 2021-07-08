package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.p0.v.i.b.a;
import d.a.p0.v.i.d.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f14259a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f14260b;

    /* renamed from: c  reason: collision with root package name */
    public List<b2> f14261c;

    /* renamed from: d  reason: collision with root package name */
    public String f14262d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f14263e;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14260b = new ArrayList<>();
        this.f14261c = new ArrayList();
        this.f14259a = tbPageContext;
        this.f14263e = bdUniqueId;
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.f14259a, this.f14263e) : (a) invokeV.objValue;
    }

    public void c(List<b2> list, c cVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, cVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f14261c.clear();
        this.f14261c.addAll(list);
        int size = this.f14260b.size();
        int size2 = this.f14261c.size();
        if (size > size2) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = size2; i2 < size; i2++) {
                arrayList.add(this.f14260b.get(i2));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                a aVar2 = (a) arrayList.get(i3);
                if (aVar2.c() != null && aVar2.c().getParent() != null) {
                    ((ViewGroup) aVar2.c().getParent()).removeView(aVar2.c());
                }
                this.f14260b.remove(aVar2);
            }
            arrayList.clear();
        }
        for (int i4 = 0; i4 < size2; i4++) {
            if (i4 >= size) {
                aVar = b();
                aVar.g(this.f14259a.getUniqueId());
                aVar.h(cVar);
                this.f14260b.add(aVar);
            } else {
                aVar = this.f14260b.get(i4);
            }
            if (this.f14261c.get(i4) != null && aVar != null) {
                aVar.f(this.f14261c.get(i4), this.f14262d);
            }
        }
        notifyDataSetChanged();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f14262d = str;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView(this.f14260b.get(i2).c());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f14260b) : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            ArrayList<a> arrayList = this.f14260b;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i2);
            }
            a aVar = (a) ListUtils.getItem(arrayList, i2);
            if (aVar == null) {
                return super.instantiateItem(viewGroup, i2);
            }
            if (aVar.c().getParent() == null) {
                viewGroup.addView(aVar.c(), new ViewGroup.LayoutParams(-2, -2));
            }
            aVar.e();
            aVar.c().setTag(Integer.valueOf(i2));
            return aVar.c();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }
}
