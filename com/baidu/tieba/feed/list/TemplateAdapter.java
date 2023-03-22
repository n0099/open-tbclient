package com.baidu.tieba.feed.list;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gs6;
import com.baidu.tieba.hs6;
import com.baidu.tieba.is6;
import com.baidu.tieba.js6;
import com.baidu.tieba.ks6;
import com.baidu.tieba.ls6;
import com.baidu.tieba.ms6;
import com.baidu.tieba.ns6;
import com.baidu.tieba.ps6;
import com.baidu.tieba.qs6;
import com.baidu.tieba.ss6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class TemplateAdapter extends RecyclerView.Adapter<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<? extends qs6<?>> a;
    public final Map<String, ps6<?, ?>> b;
    public final Map<String, Integer> c;
    public final Map<Integer, ps6<?, ?>> d;
    public RecyclerView e;
    public boolean f;
    public is6 g;
    public ks6 h;
    public js6 i;

    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ps6<?, ?> a;
        public final View b;
        public qs6<?> c;
        public is6 d;
        public ks6 e;

        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewGroup a;

            public a(c cVar, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = viewGroup;
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    ss6.a(this.a, motionEvent);
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NonNull ps6<?, ?> ps6Var, @NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps6Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = view2;
            this.a = ps6Var;
            if (view2 instanceof gs6) {
                ((gs6) view2).a(this, this);
            }
        }

        public void a(@NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                this.itemView.setOnClickListener(this);
                this.itemView.setOnTouchListener(new a(this, viewGroup));
            }
        }

        public void b(qs6<?> qs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qs6Var) == null) {
                this.c = qs6Var;
                this.a.b(this.b, qs6Var.b());
            }
        }

        public void c(is6 is6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, is6Var) == null) {
                this.d = is6Var;
            }
        }

        public void d(ks6 ks6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ks6Var) == null) {
                this.e = ks6Var;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            is6 is6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (is6Var = this.d) != null) {
                is6Var.a(view2, this.c, this.a);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
                ks6 ks6Var = this.e;
                if (ks6Var != null) {
                    return ks6Var.a(view2, this.c, this.a);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs6 a;
        public final /* synthetic */ TemplateAdapter b;

        public a(TemplateAdapter templateAdapter, qs6 qs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, qs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = templateAdapter;
            this.a = qs6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int indexOf;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (indexOf = this.b.a.indexOf(this.a)) != -1) {
                this.b.notifyItemChanged(indexOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ns6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(TemplateAdapter templateAdapter, qs6 qs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, qs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public TemplateAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.f = false;
    }

    public final void d(ms6 ms6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ms6Var) == null) && ms6Var != null) {
            f(ms6Var.a());
        }
    }

    public final void f(List<ps6<?, ?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && list != null) {
            for (ps6<?, ?> ps6Var : list) {
                e(ps6Var);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.c.get(this.a.get(i).a()).intValue();
        }
        return invokeI.intValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setList(List<? extends qs6<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.a = list;
            super.notifyDataSetChanged();
        }
    }

    public final void e(ps6<?, ?> ps6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ps6Var) == null) {
            String c2 = ps6Var.c();
            if (!this.b.containsKey(c2) && !TextUtils.isEmpty(c2)) {
                int size = this.b.size();
                this.b.put(ps6Var.c(), ps6Var);
                this.c.put(ps6Var.c(), Integer.valueOf(size));
                this.d.put(Integer.valueOf(size), ps6Var);
                return;
            }
            throw new IllegalStateException("template name is unique，please check it！+【" + c2 + "】");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public final void onBindViewHolder(@NonNull c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, cVar, i) == null) {
            qs6<?> qs6Var = this.a.get(i);
            cVar.c(this.g);
            cVar.d(this.h);
            if (this.f) {
                cVar.a(this.e);
            }
            if (qs6Var.b() instanceof hs6) {
                ((hs6) qs6Var.b()).a(new a(this, qs6Var));
            }
            cVar.b(qs6Var);
            js6 js6Var = this.i;
            if (js6Var != null) {
                js6Var.a(qs6Var, this.b.get(qs6Var.a()), i);
            }
            View view2 = cVar.itemView;
            if (view2 instanceof ls6) {
                ((ls6) view2).a(new b(this, qs6Var));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<? extends qs6<?>> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: h */
    public final c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            ps6<?, ?> ps6Var = this.d.get(Integer.valueOf(i));
            return new c(ps6Var, ps6Var.a(viewGroup));
        }
        return (c) invokeLI.objValue;
    }
}
