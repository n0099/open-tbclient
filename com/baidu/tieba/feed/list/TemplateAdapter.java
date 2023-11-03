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
import com.baidu.tieba.ka7;
import com.baidu.tieba.la7;
import com.baidu.tieba.na7;
import com.baidu.tieba.oa7;
import com.baidu.tieba.pa7;
import com.baidu.tieba.qa7;
import com.baidu.tieba.rc7;
import com.baidu.tieba.sa7;
import com.baidu.tieba.ua7;
import com.baidu.tieba.va7;
import com.baidu.tieba.ya7;
import com.baidu.tieba.za7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class TemplateAdapter extends RecyclerView.Adapter<e> implements pa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<? extends za7<?>> a;
    public final Map<String, ya7<?, ?>> b;
    public final Map<String, Integer> c;
    public final Map<Integer, ya7<?, ?>> d;
    public RecyclerView e;
    public boolean f;
    public na7.a g;
    public na7.d h;
    public na7.c i;
    public na7.b j;
    public na7.e k;
    public final RecyclerView.OnScrollListener l;

    /* loaded from: classes5.dex */
    public static class e extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ya7<?, ?> a;
        public final View b;
        public za7<?> c;
        public na7.a d;
        public na7.d e;
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
                    rc7.o(this.a, motionEvent);
                    return this.b.f.onTouchEvent(motionEvent);
                }
                return invokeLL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NonNull ya7<?, ?> ya7Var, @NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya7Var, view2};
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
            this.a = ya7Var;
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

        public void c(za7<?> za7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, za7Var) == null) {
                this.c = za7Var;
                this.a.b(this.b, za7Var.b());
            }
        }

        public void d(na7.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.d = aVar;
            }
        }

        public void e(na7.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                this.e = dVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            na7.a aVar;
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
                na7.d dVar = this.e;
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
                    if (childAt instanceof ua7) {
                        ((ua7) childAt).b();
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
    public class c implements va7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ za7 b;
        public final /* synthetic */ TemplateAdapter c;

        public c(TemplateAdapter templateAdapter, e eVar, za7 za7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {templateAdapter, eVar, za7Var};
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
            this.b = za7Var;
        }

        @Override // com.baidu.tieba.va7
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

    @Override // com.baidu.tieba.na7
    public final void b(na7.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // com.baidu.tieba.na7
    public void d(na7.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.i = cVar;
        }
    }

    @Override // com.baidu.tieba.ma7
    public final void e(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, recyclerView) == null) {
            c(recyclerView, false);
        }
    }

    @Override // com.baidu.tieba.pi
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            List<? extends za7<?>> list = this.a;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.c.get(this.a.get(i).a()).intValue();
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.na7
    public void h(na7.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.g = aVar;
        }
    }

    @Override // com.baidu.tieba.ma7
    public final void i(qa7 qa7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, qa7Var) == null) && qa7Var != null) {
            o(qa7Var.a());
        }
    }

    @Override // com.baidu.tieba.na7
    public void k(na7.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public final void o(List<ya7<?, ?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && list != null) {
            for (ya7<?, ?> ya7Var : list) {
                n(ya7Var);
            }
        }
    }

    @Override // com.baidu.tieba.ma7
    @SuppressLint({"NotifyDataSetChanged"})
    public void setList(List<? extends za7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.a = list;
            super.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ma7
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
    /* renamed from: q */
    public final e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, viewGroup, i)) == null) {
            ya7<?, ?> ya7Var = this.d.get(Integer.valueOf(i));
            return new e(ya7Var, ya7Var.a(viewGroup));
        }
        return (e) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.pi
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getItemCount();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<? extends za7<?>> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.sa7
    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.e != null) {
            for (int i = 0; i < this.e.getChildCount(); i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt instanceof sa7) {
                    ((sa7) childAt).r();
                }
            }
        }
    }

    public final void n(ya7<?, ?> ya7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ya7Var) == null) {
            String c2 = ya7Var.c();
            if (!this.b.containsKey(c2) && !TextUtils.isEmpty(c2)) {
                int size = this.b.size();
                this.b.put(ya7Var.c(), ya7Var);
                this.c.put(ya7Var.c(), Integer.valueOf(size));
                this.d.put(Integer.valueOf(size), ya7Var);
                return;
            }
            throw new IllegalStateException("template name is unique，please check it！+【" + c2 + "】");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public final void onBindViewHolder(@NonNull e eVar, int i) {
        na7.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, eVar, i) == null) {
            za7<?> za7Var = this.a.get(i);
            eVar.d(this.g);
            eVar.e(this.h);
            if (this.f) {
                eVar.b(this.e);
            }
            if (za7Var.b() instanceof ka7) {
                ((ka7) za7Var.b()).a(new b(this, eVar));
            }
            eVar.c(za7Var);
            na7.c cVar = this.i;
            if (cVar != null) {
                cVar.a(za7Var, this.b.get(za7Var.a()), i);
            }
            View view2 = eVar.itemView;
            if (view2 instanceof oa7) {
                ((oa7) view2).setOnTemplateClickListener(new c(this, eVar, za7Var));
            }
            View view3 = eVar.itemView;
            if ((view3 instanceof la7) && (eVar2 = this.k) != null) {
                eVar2.a(((la7) view3).getVideoHolder());
            }
        }
    }
}
