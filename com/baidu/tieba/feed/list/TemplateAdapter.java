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
import com.baidu.tieba.a77;
import com.baidu.tieba.c77;
import com.baidu.tieba.d77;
import com.baidu.tieba.g77;
import com.baidu.tieba.h77;
import com.baidu.tieba.s67;
import com.baidu.tieba.t67;
import com.baidu.tieba.v67;
import com.baidu.tieba.v87;
import com.baidu.tieba.w67;
import com.baidu.tieba.x67;
import com.baidu.tieba.y67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class TemplateAdapter extends RecyclerView.Adapter<e> implements x67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<? extends h77<?>> a;
    public final Map<String, g77<?, ?>> b;
    public final Map<String, Integer> c;
    public final Map<Integer, g77<?, ?>> d;
    public RecyclerView e;
    public boolean f;
    public v67.a g;
    public v67.d h;
    public v67.c i;
    public v67.b j;
    public v67.e k;
    public final RecyclerView.OnScrollListener l;

    /* loaded from: classes5.dex */
    public static class e extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g77<?, ?> a;
        public final View b;
        public h77<?> c;
        public v67.a d;
        public v67.d e;
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
                    v87.o(this.a, motionEvent);
                    return this.b.f.onTouchEvent(motionEvent);
                }
                return invokeLL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NonNull g77<?, ?> g77Var, @NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g77Var, view2};
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
            this.a = g77Var;
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

        public void c(h77<?> h77Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h77Var) == null) {
                this.c = h77Var;
                this.a.b(this.b, h77Var.b());
            }
        }

        public void d(v67.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.d = aVar;
            }
        }

        public void e(v67.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                this.e = dVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            v67.a aVar;
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
                v67.d dVar = this.e;
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
                    if (childAt instanceof c77) {
                        ((c77) childAt).c();
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
    public class c implements d77 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ h77 b;
        public final /* synthetic */ TemplateAdapter c;

        public c(TemplateAdapter templateAdapter, e eVar, h77 h77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, eVar, h77Var};
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
            this.b = h77Var;
        }

        @Override // com.baidu.tieba.d77
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

    @Override // com.baidu.tieba.v67
    public final void c(v67.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // com.baidu.tieba.v67
    public void e(v67.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.i = cVar;
        }
    }

    @Override // com.baidu.tieba.u67
    public final void f(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, recyclerView) == null) {
            d(recyclerView, false);
        }
    }

    @Override // com.baidu.tieba.zh
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            List<? extends h77<?>> list = this.a;
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

    @Override // com.baidu.tieba.v67
    public void i(v67.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.g = aVar;
        }
    }

    @Override // com.baidu.tieba.u67
    public final void j(y67 y67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, y67Var) == null) && y67Var != null) {
            o(y67Var.a());
        }
    }

    @Override // com.baidu.tieba.v67
    public void k(v67.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public final void o(List<g77<?, ?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && list != null) {
            for (g77<?, ?> g77Var : list) {
                n(g77Var);
            }
        }
    }

    @Override // com.baidu.tieba.u67
    @SuppressLint({"NotifyDataSetChanged"})
    public void setList(List<? extends h77<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.a = list;
            super.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.a77
    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.e != null) {
            for (int i = 0; i < this.e.getChildCount(); i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt instanceof a77) {
                    ((a77) childAt).b();
                }
            }
        }
    }

    @Override // com.baidu.tieba.zh
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
            List<? extends h77<?>> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.u67
    public final void d(@NonNull RecyclerView recyclerView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, recyclerView, z) == null) {
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
    /* renamed from: q */
    public final e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, viewGroup, i)) == null) {
            g77<?, ?> g77Var = this.d.get(Integer.valueOf(i));
            return new e(g77Var, g77Var.a(viewGroup));
        }
        return (e) invokeLI.objValue;
    }

    public final void n(g77<?, ?> g77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, g77Var) == null) {
            String c2 = g77Var.c();
            if (!this.b.containsKey(c2) && !TextUtils.isEmpty(c2)) {
                int size = this.b.size();
                this.b.put(g77Var.c(), g77Var);
                this.c.put(g77Var.c(), Integer.valueOf(size));
                this.d.put(Integer.valueOf(size), g77Var);
                return;
            }
            throw new IllegalStateException("template name is unique，please check it！+【" + c2 + "】");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public final void onBindViewHolder(@NonNull e eVar, int i) {
        v67.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, eVar, i) == null) {
            h77<?> h77Var = this.a.get(i);
            eVar.d(this.g);
            eVar.e(this.h);
            if (this.f) {
                eVar.b(this.e);
            }
            if (h77Var.b() instanceof s67) {
                ((s67) h77Var.b()).a(new b(this, eVar));
            }
            eVar.c(h77Var);
            v67.c cVar = this.i;
            if (cVar != null) {
                cVar.a(h77Var, this.b.get(h77Var.a()), i);
            }
            View view2 = eVar.itemView;
            if (view2 instanceof w67) {
                ((w67) view2).setOnTemplateClickListener(new c(this, eVar, h77Var));
            }
            View view3 = eVar.itemView;
            if ((view3 instanceof t67) && (eVar2 = this.k) != null) {
                eVar2.a(((t67) view3).getVideoHolder());
            }
        }
    }
}
