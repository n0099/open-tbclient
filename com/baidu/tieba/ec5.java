package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.dc5;
import com.baidu.tieba.yb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class ec5<D, S extends yb5, H extends dc5<D, S>> extends BaseAdapter implements hm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<D> a;
    public final List<H> b;
    public final SparseArray<H> c;
    public final TbPageContext<?> d;
    public S e;
    public final ViewEventCenter f;
    public boolean g;
    public NoDataView h;
    public FrameLayout i;
    public NoDataViewFactory.e j;
    public NoDataViewFactory.d k;
    public NoDataViewFactory.c l;
    public FrameLayout.LayoutParams m;

    public ec5(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = new SparseArray<>();
        this.g = true;
        this.d = tbPageContext;
        this.f = viewEventCenter;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.i == null) {
                this.i = new FrameLayout(this.d.getPageActivity());
            }
            if (this.h == null) {
                this.h = NoDataViewFactory.a(this.d.getPageActivity(), this.i, this.k, this.j, this.l);
            }
            this.h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = this.m;
            if (layoutParams != null) {
                this.h.setLayoutParams(layoutParams);
            }
            this.i.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.h.f(this.d, TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frameLayout = this.i) == null || (noDataView = this.h) == null) {
            return;
        }
        frameLayout.removeView(noDataView);
        this.h = null;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<D> list = this.a;
            return list != null && list.size() == 0;
        }
        return invokeV.booleanValue;
    }

    public final View d(View view2, int i, Class<?> cls, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{view2, Integer.valueOf(i), cls, Integer.valueOf(i2)})) == null) {
            H e = e(view2, cls, i2);
            if (this.c.indexOfValue(e) >= 0) {
                this.c.remove(e.i());
            }
            this.c.put(i, e);
            i(e, i);
            return e.c();
        }
        return (View) invokeCommon.objValue;
    }

    public final H e(View view2, Class<?> cls, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, view2, cls, i)) == null) {
            if (view2 != null && view2.getTag() != null) {
                return (H) view2.getTag();
            }
            View inflate = this.d.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.d, inflate, this.f);
                h.onChangeSkinType(this.d, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.b.add(h);
                return h;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw e2;
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException(e4);
            } catch (SecurityException e5) {
                throw e5;
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6);
            }
        }
        return (H) invokeLLI.objValue;
    }

    public void f(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, dVar, eVar, cVar, layoutParams) == null) {
            this.k = dVar;
            this.j = eVar;
            this.l = cVar;
            this.m = layoutParams;
            NoDataView noDataView = this.h;
            if (noDataView != null) {
                noDataView.setTextOption(eVar);
                this.h.setImgOption(dVar);
                this.h.setButtonOption(cVar);
                if (layoutParams != null) {
                    this.h.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void g(List<D> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            h(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<D> list = this.a;
            if (list == null) {
                return 0;
            }
            if (list.size() == 0 && this.g) {
                return 1;
            }
            return this.a.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            List<D> list = this.a;
            if (list != null && list.size() != 0 && i >= 0 && i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (D) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            List<D> list = this.a;
            if (list != null && list.size() != 0 && i >= 0 && i < this.a.size()) {
                return i;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public void h(List<D> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        this.a.addAll(list);
        this.c.clear();
    }

    public final void i(H h, int i) {
        D item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, h, i) == null) || (item = getItem(i)) == null) {
            return;
        }
        h.e = i;
        h.g(item, this.e);
    }

    @Override // com.baidu.tieba.hm8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, tbPageContext, i)) == null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                H h = this.b.get(i2);
                if (h != null) {
                    h.onChangeSkinType(tbPageContext, i);
                }
            }
            NoDataView noDataView = this.h;
            if (noDataView != null) {
                noDataView.f(this.d, i);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
