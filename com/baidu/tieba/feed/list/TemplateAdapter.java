package com.baidu.tieba.feed.list;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e17;
import com.baidu.tieba.g17;
import com.baidu.tieba.h17;
import com.baidu.tieba.i17;
import com.baidu.tieba.j17;
import com.baidu.tieba.l17;
import com.baidu.tieba.n17;
import com.baidu.tieba.o17;
import com.baidu.tieba.r17;
import com.baidu.tieba.s17;
import com.baidu.tieba.z27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class TemplateAdapter extends RecyclerView.Adapter<d> implements i17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<? extends s17<?>> a;
    public final Map<String, r17<?, ?>> b;
    public final Map<String, Integer> c;
    public final Map<Integer, r17<?, ?>> d;
    public RecyclerView e;
    public boolean f;
    public g17.a g;
    public g17.d h;
    public g17.c i;
    public g17.b j;
    public final RecyclerView.OnScrollListener k;

    /* loaded from: classes4.dex */
    public static class d extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final r17<?, ?> a;
        public final View b;
        public s17<?> c;
        public g17.a d;
        public g17.d e;

        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewGroup a;

            public a(d dVar, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, viewGroup};
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
                    z27.o(this.a, motionEvent);
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull r17<?, ?> r17Var, @NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r17Var, view2};
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
            this.a = r17Var;
        }

        public void a(@NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                this.itemView.setOnClickListener(this);
                this.itemView.setOnTouchListener(new a(this, viewGroup));
            }
        }

        public void b(s17<?> s17Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s17Var) == null) {
                this.c = s17Var;
                this.a.b(this.b, s17Var.b());
            }
        }

        public void c(g17.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.d = aVar;
            }
        }

        public void d(g17.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                this.e = dVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            g17.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (aVar = this.d) != null) {
                aVar.a(view2, this.c, this.a);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
                g17.d dVar = this.e;
                if (dVar != null) {
                    return dVar.a(view2, this.c, this.a);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TemplateAdapter a;

        public a(TemplateAdapter templateAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = templateAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                for (int i2 = 0; i2 < recyclerView.getChildCount(); i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt instanceof n17) {
                        ((n17) childAt).e();
                    }
                }
                if (this.a.i != null) {
                    this.a.i.b(recyclerView);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s17 a;
        public final /* synthetic */ TemplateAdapter b;

        public b(TemplateAdapter templateAdapter, s17 s17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, s17Var};
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
            this.a = s17Var;
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
    public class c implements o17 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s17 a;
        public final /* synthetic */ TemplateAdapter b;

        public c(TemplateAdapter templateAdapter, s17 s17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, s17Var};
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
            this.a = s17Var;
        }

        @Override // com.baidu.tieba.o17
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.j != null) {
                this.b.j.a(this.a);
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
        this.k = new a(this);
    }

    @Override // com.baidu.tieba.g17
    public final void c(g17.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // com.baidu.tieba.g17
    public void e(g17.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.i = cVar;
        }
    }

    @Override // com.baidu.tieba.f17
    public final void f(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, recyclerView) == null) {
            d(recyclerView, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.c.get(this.a.get(i).a()).intValue();
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.g17
    public void i(g17.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.g = aVar;
        }
    }

    @Override // com.baidu.tieba.f17
    public final void j(j17 j17Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j17Var) == null) && j17Var != null) {
            n(j17Var.a());
        }
    }

    public final void n(List<r17<?, ?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, list) == null) && list != null) {
            for (r17<?, ?> r17Var : list) {
                m(r17Var);
            }
        }
    }

    @Override // com.baidu.tieba.f17
    @SuppressLint({"NotifyDataSetChanged"})
    public void setList(List<? extends s17<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.a = list;
            super.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.l17
    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.e != null) {
            for (int i = 0; i < this.e.getChildCount(); i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt instanceof l17) {
                    ((l17) childAt).b();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<? extends s17<?>> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.f17
    public final void d(@NonNull RecyclerView recyclerView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, recyclerView, z) == null) {
            RecyclerView recyclerView2 = this.e;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(null);
                this.e.removeOnScrollListener(this.k);
            }
            this.f = z;
            this.e = recyclerView;
            recyclerView.setAdapter(this);
            this.e.addOnScrollListener(this.k);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p */
    public final d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, viewGroup, i)) == null) {
            r17<?, ?> r17Var = this.d.get(Integer.valueOf(i));
            return new d(r17Var, r17Var.a(viewGroup));
        }
        return (d) invokeLI.objValue;
    }

    public final void m(r17<?, ?> r17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, r17Var) == null) {
            String c2 = r17Var.c();
            if (!this.b.containsKey(c2) && !TextUtils.isEmpty(c2)) {
                int size = this.b.size();
                this.b.put(r17Var.c(), r17Var);
                this.c.put(r17Var.c(), Integer.valueOf(size));
                this.d.put(Integer.valueOf(size), r17Var);
                return;
            }
            throw new IllegalStateException("template name is unique，please check it！+【" + c2 + "】");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public final void onBindViewHolder(@NonNull d dVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, dVar, i) == null) {
            s17<?> s17Var = this.a.get(i);
            dVar.c(this.g);
            dVar.d(this.h);
            if (this.f) {
                dVar.a(this.e);
            }
            if (s17Var.b() instanceof e17) {
                ((e17) s17Var.b()).a(new b(this, s17Var));
            }
            dVar.b(s17Var);
            g17.c cVar = this.i;
            if (cVar != null) {
                cVar.a(s17Var, this.b.get(s17Var.a()), i);
            }
            View view2 = dVar.itemView;
            if (view2 instanceof h17) {
                ((h17) view2).setOnTemplateClickListener(new c(this, s17Var));
            }
        }
    }
}
