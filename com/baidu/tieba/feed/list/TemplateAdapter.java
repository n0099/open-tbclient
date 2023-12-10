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
import com.baidu.tieba.db7;
import com.baidu.tieba.eb7;
import com.baidu.tieba.gb7;
import com.baidu.tieba.hb7;
import com.baidu.tieba.ib7;
import com.baidu.tieba.jb7;
import com.baidu.tieba.kd7;
import com.baidu.tieba.lb7;
import com.baidu.tieba.nb7;
import com.baidu.tieba.ob7;
import com.baidu.tieba.rb7;
import com.baidu.tieba.sb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class TemplateAdapter extends RecyclerView.Adapter<e> implements ib7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<? extends sb7<?>> a;
    public final Map<String, rb7<?, ?>> b;
    public final Map<String, Integer> c;
    public final Map<Integer, rb7<?, ?>> d;
    public RecyclerView e;
    public boolean f;
    public gb7.a g;
    public gb7.d h;
    public gb7.c i;
    public gb7.b j;
    public gb7.e k;
    public final RecyclerView.OnScrollListener l;

    /* loaded from: classes5.dex */
    public static class e extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final rb7<?, ?> a;
        public final View b;
        public sb7<?> c;
        public gb7.a d;
        public gb7.d e;
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
                    kd7.o(this.a, motionEvent);
                    return this.b.f.onTouchEvent(motionEvent);
                }
                return invokeLL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NonNull rb7<?, ?> rb7Var, @NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb7Var, view2};
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
            this.a = rb7Var;
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

        public void c(sb7<?> sb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb7Var) == null) {
                this.c = sb7Var;
                this.a.b(this.b, sb7Var.b());
            }
        }

        public void d(gb7.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.d = aVar;
            }
        }

        public void e(gb7.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                this.e = dVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            gb7.a aVar;
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
                gb7.d dVar = this.e;
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
                    if (childAt instanceof nb7) {
                        ((nb7) childAt).b();
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
        public final /* synthetic */ e a;
        public final /* synthetic */ TemplateAdapter b;

        public b(TemplateAdapter templateAdapter, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, eVar};
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
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int adapterPosition;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (adapterPosition = this.a.getAdapterPosition()) != -1) {
                this.b.notifyItemChanged(adapterPosition);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ob7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ sb7 b;
        public final /* synthetic */ TemplateAdapter c;

        public c(TemplateAdapter templateAdapter, e eVar, sb7 sb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, eVar, sb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = templateAdapter;
            this.a = eVar;
            this.b = sb7Var;
        }

        @Override // com.baidu.tieba.ob7
        public void a() {
            int adapterPosition;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.j != null && (adapterPosition = this.a.getAdapterPosition()) != -1) {
                this.c.j.a(this.b, adapterPosition);
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
        this.l = new a(this);
    }

    @Override // com.baidu.tieba.gb7
    public final void b(gb7.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // com.baidu.tieba.gb7
    public void d(gb7.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.i = cVar;
        }
    }

    @Override // com.baidu.tieba.fb7
    public final void e(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, recyclerView) == null) {
            c(recyclerView, false);
        }
    }

    @Override // com.baidu.tieba.qi
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            List<? extends sb7<?>> list = this.a;
            if (list != null && i >= 0 && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.c.get(this.a.get(i).a()).intValue();
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.gb7
    public void i(gb7.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.g = aVar;
        }
    }

    @Override // com.baidu.tieba.fb7
    public final void j(jb7 jb7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jb7Var) == null) && jb7Var != null) {
            p(jb7Var.a());
        }
    }

    @Override // com.baidu.tieba.gb7
    public void k(gb7.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public final void p(List<rb7<?, ?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, list) == null) && list != null) {
            for (rb7<?, ?> rb7Var : list) {
                o(rb7Var);
            }
        }
    }

    @Override // com.baidu.tieba.fb7
    @SuppressLint({"NotifyDataSetChanged"})
    public void setList(List<? extends sb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.a = list;
            super.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.fb7
    public final void c(@NonNull RecyclerView recyclerView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, z) == null) {
            RecyclerView recyclerView2 = this.e;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(null);
                this.e.removeOnScrollListener(this.l);
            }
            this.f = z;
            this.e = recyclerView;
            recyclerView.setAdapter(this);
            this.e.addOnScrollListener(this.l);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public final e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, viewGroup, i)) == null) {
            rb7<?, ?> rb7Var = this.d.get(Integer.valueOf(i));
            return new e(rb7Var, rb7Var.a(viewGroup));
        }
        return (e) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.lb7
    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.e != null) {
            for (int i = 0; i < this.e.getChildCount(); i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt instanceof lb7) {
                    ((lb7) childAt).f();
                }
            }
        }
    }

    @Override // com.baidu.tieba.qi
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getItemCount();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<? extends sb7<?>> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final void o(rb7<?, ?> rb7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rb7Var) == null) {
            String c2 = rb7Var.c();
            if (!this.b.containsKey(c2) && !TextUtils.isEmpty(c2)) {
                int size = this.b.size();
                this.b.put(rb7Var.c(), rb7Var);
                this.c.put(rb7Var.c(), Integer.valueOf(size));
                this.d.put(Integer.valueOf(size), rb7Var);
                return;
            }
            throw new IllegalStateException("template name is unique，please check it！+【" + c2 + "】");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public final void onBindViewHolder(@NonNull e eVar, int i) {
        gb7.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, eVar, i) == null) {
            sb7<?> sb7Var = this.a.get(i);
            eVar.d(this.g);
            eVar.e(this.h);
            if (this.f) {
                eVar.b(this.e);
            }
            if (sb7Var.b() instanceof db7) {
                ((db7) sb7Var.b()).a(new b(this, eVar));
            }
            eVar.c(sb7Var);
            gb7.c cVar = this.i;
            if (cVar != null) {
                cVar.a(sb7Var, this.b.get(sb7Var.a()), i);
            }
            View view2 = eVar.itemView;
            if (view2 instanceof hb7) {
                ((hb7) view2).setOnTemplateClickListener(new c(this, eVar, sb7Var));
            }
            View view3 = eVar.itemView;
            if ((view3 instanceof eb7) && (eVar2 = this.k) != null) {
                eVar2.a(((eb7) view3).getVideoHolder());
            }
        }
    }
}
