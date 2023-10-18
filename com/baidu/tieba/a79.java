package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a79 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public d79 b;
    public List<Object> c;
    public f d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public View.OnClickListener g;
    public o79<Void> h;
    public o79<Integer> i;

    /* loaded from: classes5.dex */
    public interface f {
        void callback();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a79 a;

        public a(a79 a79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.h();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a79 a;

        public b(a79 a79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TailData c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || view2.getTag() == null || (c = ((c79) view2.getTag()).c()) == null || this.a.b.g()) {
                return;
            }
            this.a.i(c.getId(), c.getContent(), c.getFontColor());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a79 a;

        public c(a79 a79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c79 c79Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && (c79Var = (c79) view2.getTag()) != null && c79Var.c() != null) {
                this.a.b.e(c79Var.c().getId());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements o79<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a79 a;

        public d(a79 a79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o79
        /* renamed from: b */
        public void a(boolean z, String str, Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, r7}) == null) {
                if (z) {
                    this.a.a.showToast(str);
                    return;
                }
                a79 a79Var = this.a;
                a79Var.l(a79Var.b.h());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements o79<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a79 a;

        public e(a79 a79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o79
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) == null) {
                if (z) {
                    this.a.a.showToast(str);
                    return;
                }
                TailData tailData = new TailData();
                tailData.setId(num.intValue());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, new q69(3, tailData)));
            }
        }
    }

    public a79(TbPageContext<?> tbPageContext, d79 d79Var, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, d79Var, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.f = new b(this);
        this.g = new c(this);
        this.h = new d(this);
        this.i = new e(this);
        this.a = tbPageContext;
        this.b = d79Var;
        this.c = new ArrayList();
        this.b.m(this.h);
        this.b.k(this.i);
        this.d = fVar;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.c.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            Object obj = this.c.get(i);
            if (obj instanceof TailData) {
                return 0;
            }
            if (obj instanceof m69) {
                return 1;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final void l(List<TailData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.b.n(list);
            j();
        }
    }

    public final View f(View view2) {
        InterceptResult invokeL;
        View view3;
        b79 b79Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null) {
                b79Var = new b79();
                view3 = b79Var.b(this.a.getPageActivity());
                b79Var.c(this.e);
                b79Var.a(this.a);
            } else {
                view3 = view2;
                b79Var = (b79) view2.getTag();
            }
            b79Var.d(this.b.f());
            return view3;
        }
        return (View) invokeL.objValue;
    }

    public final View g(Object obj, View view2) {
        InterceptResult invokeLL;
        View view3;
        c79 c79Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, view2)) == null) {
            if (obj != null && (obj instanceof TailData)) {
                TailData tailData = (TailData) obj;
                if (view2 == null) {
                    c79Var = new c79();
                    view3 = c79Var.b(this.a.getPageActivity());
                    c79Var.h(this.f);
                    c79Var.f(this.g);
                    c79Var.a(this.a);
                } else {
                    view3 = view2;
                    c79Var = (c79) view2.getTag();
                }
                c79Var.i(tailData);
                c79Var.g(Boolean.valueOf(this.b.g()));
                return view3;
            }
            return null;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.a.getPageActivity(), this.b.h().isEmpty())));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 0) {
                return g(getItem(i), view2);
            }
            if (getItemViewType(i) == 1) {
                return f(view2);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    public final void i(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i, str, str2) == null) {
            this.a.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.a.getPageActivity(), i, str, str2)));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            f fVar = this.d;
            if (fVar != null) {
                fVar.callback();
            }
            this.c.clear();
            this.c.addAll(this.b.h());
            if (!this.b.g() && this.b.h().size() < 3) {
                this.c.add(new m69(this.b.f()));
            }
        }
    }
}
