package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.od6;
import com.baidu.tieba.sd6;
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
    public ArrayList<od6> b;
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

    public final od6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new od6(this.a, this.e);
        }
        return (od6) invokeV.objValue;
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

    public void c(List<ThreadData> list, sd6 sd6Var) {
        od6 od6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, sd6Var) == null) && list != null && !list.isEmpty()) {
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
                    od6 od6Var2 = (od6) arrayList.get(i2);
                    if (od6Var2.c() != null && od6Var2.c().getParent() != null) {
                        ((ViewGroup) od6Var2.c().getParent()).removeView(od6Var2.c());
                    }
                    this.b.remove(od6Var2);
                }
                arrayList.clear();
            }
            for (int i3 = 0; i3 < size2; i3++) {
                if (i3 >= size) {
                    od6Var = b();
                    od6Var.g(this.a.getUniqueId());
                    od6Var.h(sd6Var);
                    this.b.add(od6Var);
                } else {
                    od6Var = this.b.get(i3);
                }
                if (this.c.get(i3) != null && od6Var != null) {
                    od6Var.f(this.c.get(i3), this.d);
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
            ArrayList<od6> arrayList = this.b;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i);
            }
            od6 od6Var = (od6) ListUtils.getItem(arrayList, i);
            if (od6Var == null) {
                return super.instantiateItem(viewGroup, i);
            }
            if (od6Var.c().getParent() == null) {
                viewGroup.addView(od6Var.c(), new ViewGroup.LayoutParams(-2, -2));
            }
            od6Var.e();
            od6Var.c().setTag(Integer.valueOf(i));
            return od6Var.c();
        }
        return invokeLI.objValue;
    }
}
