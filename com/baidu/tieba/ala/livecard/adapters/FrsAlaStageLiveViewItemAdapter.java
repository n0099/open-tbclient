package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs5;
import com.repackage.xr5;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ArrayList<xr5> b;
    public List<ThreadData> c;
    public String d;
    public BdUniqueId e;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.c = new ArrayList();
        this.a = tbPageContext;
        this.e = bdUniqueId;
    }

    public final xr5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new xr5(this.a, this.e) : (xr5) invokeV.objValue;
    }

    public void c(List<ThreadData> list, bs5 bs5Var) {
        xr5 xr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, bs5Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.c.clear();
        this.c.addAll(list);
        int size = this.b.size();
        int size2 = this.c.size();
        if (size > size2) {
            ArrayList arrayList = new ArrayList();
            for (int i = size2; i < size; i++) {
                arrayList.add(this.b.get(i));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                xr5 xr5Var2 = (xr5) arrayList.get(i2);
                if (xr5Var2.c() != null && xr5Var2.c().getParent() != null) {
                    ((ViewGroup) xr5Var2.c().getParent()).removeView(xr5Var2.c());
                }
                this.b.remove(xr5Var2);
            }
            arrayList.clear();
        }
        for (int i3 = 0; i3 < size2; i3++) {
            if (i3 >= size) {
                xr5Var = b();
                xr5Var.g(this.a.getUniqueId());
                xr5Var.h(bs5Var);
                this.b.add(xr5Var);
            } else {
                xr5Var = this.b.get(i3);
            }
            if (this.c.get(i3) != null && xr5Var != null) {
                xr5Var.f(this.c.get(i3), this.d);
            }
        }
        notifyDataSetChanged();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d = str;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
            viewGroup.removeView(this.b.get(i).c());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.b) : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            ArrayList<xr5> arrayList = this.b;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i);
            }
            xr5 xr5Var = (xr5) ListUtils.getItem(arrayList, i);
            if (xr5Var == null) {
                return super.instantiateItem(viewGroup, i);
            }
            if (xr5Var.c().getParent() == null) {
                viewGroup.addView(xr5Var.c(), new ViewGroup.LayoutParams(-2, -2));
            }
            xr5Var.e();
            xr5Var.c().setTag(Integer.valueOf(i));
            return xr5Var.c();
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }
}
