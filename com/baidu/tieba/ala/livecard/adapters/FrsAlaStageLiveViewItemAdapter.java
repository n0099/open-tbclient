package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.te6;
import com.baidu.tieba.xe6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ArrayList<te6> b;
    public List<ThreadData> c;
    public String d;
    public BdUniqueId e;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

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

    public final te6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new te6(this.a, this.e);
        }
        return (te6) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public void c(List<ThreadData> list, xe6 xe6Var) {
        te6 te6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, xe6Var) == null) && list != null && !list.isEmpty()) {
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
                    te6 te6Var2 = (te6) arrayList.get(i2);
                    if (te6Var2.c() != null && te6Var2.c().getParent() != null) {
                        ((ViewGroup) te6Var2.c().getParent()).removeView(te6Var2.c());
                    }
                    this.b.remove(te6Var2);
                }
                arrayList.clear();
            }
            for (int i3 = 0; i3 < size2; i3++) {
                if (i3 >= size) {
                    te6Var = b();
                    te6Var.g(this.a.getUniqueId());
                    te6Var.h(xe6Var);
                    this.b.add(te6Var);
                } else {
                    te6Var = this.b.get(i3);
                }
                if (this.c.get(i3) != null && te6Var != null) {
                    te6Var.f(this.c.get(i3), this.d);
                }
            }
            notifyDataSetChanged();
        }
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
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            ArrayList<te6> arrayList = this.b;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i);
            }
            te6 te6Var = (te6) ListUtils.getItem(arrayList, i);
            if (te6Var == null) {
                return super.instantiateItem(viewGroup, i);
            }
            if (te6Var.c().getParent() == null) {
                viewGroup.addView(te6Var.c(), new ViewGroup.LayoutParams(-2, -2));
            }
            te6Var.e();
            te6Var.c().setTag(Integer.valueOf(i));
            return te6Var.c();
        }
        return invokeLI.objValue;
    }
}
