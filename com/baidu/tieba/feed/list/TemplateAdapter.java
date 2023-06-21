package com.baidu.tieba.feed.list;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a87;
import com.baidu.tieba.c87;
import com.baidu.tieba.d87;
import com.baidu.tieba.e87;
import com.baidu.tieba.f87;
import com.baidu.tieba.h87;
import com.baidu.tieba.j87;
import com.baidu.tieba.k87;
import com.baidu.tieba.n87;
import com.baidu.tieba.o87;
import com.baidu.tieba.v97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class TemplateAdapter extends RecyclerView.Adapter<e> implements e87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<? extends o87<?>> a;
    public final Map<String, n87<?, ?>> b;
    public final Map<String, Integer> c;
    public final Map<Integer, n87<?, ?>> d;
    public RecyclerView e;
    public boolean f;
    public c87.a g;
    public c87.d h;
    public c87.c i;
    public c87.b j;
    public final RecyclerView.OnScrollListener k;

    /* loaded from: classes5.dex */
    public static class e extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final n87<?, ?> a;
        public final View b;
        public o87<?> c;
        public c87.a d;
        public c87.d e;
        public GestureDetector f;
        public d g;

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewGroup a;
            public final /* synthetic */ e b;

            public a(e eVar, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = viewGroup;
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    v97.o(this.a, motionEvent);
                    return this.b.f.onTouchEvent(motionEvent);
                }
                return invokeLL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NonNull n87<?, ?> n87Var, @NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n87Var, view2};
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
            this.a = n87Var;
            this.g = new d(this, view2);
            GestureDetector gestureDetector = new GestureDetector(view2.getContext(), this.g);
            this.f = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
        }

        public void b(@NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                this.itemView.setOnClickListener(this);
                this.itemView.setOnTouchListener(new a(this, viewGroup));
            }
        }

        public void c(o87<?> o87Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o87Var) == null) {
                this.c = o87Var;
                this.a.b(this.b, o87Var.b());
            }
        }

        public void d(c87.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.d = aVar;
            }
        }

        public void e(c87.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                this.e = dVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c87.a aVar;
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
                c87.d dVar = this.e;
                if (dVar != null) {
                    return dVar.a(view2, this.c, this.a);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
                    if (childAt instanceof j87) {
                        ((j87) childAt).d();
                    }
                }
                if (this.a.i != null) {
                    this.a.i.b(recyclerView);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o87 a;
        public final /* synthetic */ TemplateAdapter b;

        public b(TemplateAdapter templateAdapter, o87 o87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, o87Var};
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
            this.a = o87Var;
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

    /* loaded from: classes5.dex */
    public class c implements k87 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o87 a;
        public final /* synthetic */ TemplateAdapter b;

        public c(TemplateAdapter templateAdapter, o87 o87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, o87Var};
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
            this.a = o87Var;
        }

        @Override // com.baidu.tieba.k87
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.j != null) {
                this.b.j.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View.OnClickListener a;
        public final View b;

        public d(View.OnClickListener onClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
            this.b = view2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null && (view2 = this.b) != null) {
                    onClickListener.onClick(view2);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
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

    @Override // com.baidu.tieba.c87
    public final void c(c87.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // com.baidu.tieba.c87
    public void e(c87.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.i = cVar;
        }
    }

    @Override // com.baidu.tieba.b87
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

    @Override // com.baidu.tieba.c87
    public void i(c87.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.g = aVar;
        }
    }

    @Override // com.baidu.tieba.b87
    public final void j(f87 f87Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f87Var) == null) && f87Var != null) {
            n(f87Var.a());
        }
    }

    public final void n(List<n87<?, ?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, list) == null) && list != null) {
            for (n87<?, ?> n87Var : list) {
                m(n87Var);
            }
        }
    }

    @Override // com.baidu.tieba.b87
    @SuppressLint({"NotifyDataSetChanged"})
    public void setList(List<? extends o87<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.a = list;
            super.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.h87
    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.e != null) {
            for (int i = 0; i < this.e.getChildCount(); i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt instanceof h87) {
                    ((h87) childAt).b();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<? extends o87<?>> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.b87
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
    public final e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, viewGroup, i)) == null) {
            n87<?, ?> n87Var = this.d.get(Integer.valueOf(i));
            return new e(n87Var, n87Var.a(viewGroup));
        }
        return (e) invokeLI.objValue;
    }

    public final void m(n87<?, ?> n87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, n87Var) == null) {
            String c2 = n87Var.c();
            if (!this.b.containsKey(c2) && !TextUtils.isEmpty(c2)) {
                int size = this.b.size();
                this.b.put(n87Var.c(), n87Var);
                this.c.put(n87Var.c(), Integer.valueOf(size));
                this.d.put(Integer.valueOf(size), n87Var);
                return;
            }
            throw new IllegalStateException("template name is unique，please check it！+【" + c2 + "】");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public final void onBindViewHolder(@NonNull e eVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, eVar, i) == null) {
            o87<?> o87Var = this.a.get(i);
            eVar.d(this.g);
            eVar.e(this.h);
            if (this.f) {
                eVar.b(this.e);
            }
            if (o87Var.b() instanceof a87) {
                ((a87) o87Var.b()).a(new b(this, o87Var));
            }
            eVar.c(o87Var);
            c87.c cVar = this.i;
            if (cVar != null) {
                cVar.a(o87Var, this.b.get(o87Var.a()), i);
            }
            View view2 = eVar.itemView;
            if (view2 instanceof d87) {
                ((d87) view2).setOnTemplateClickListener(new c(this, o87Var));
            }
        }
    }
}
