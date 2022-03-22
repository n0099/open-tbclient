package com.baidu.tieba.frs.voiceroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.l.q;
import c.a.o0.r.v.c;
import c.a.o0.s.c.o0;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsVoiceRoomListLayout extends LinearLayout implements q, p<o0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public RefreshView f33048b;

    /* renamed from: c  reason: collision with root package name */
    public PullLeftRefreshLayout f33049c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f33050d;

    /* renamed from: e  reason: collision with root package name */
    public HorizontalAdapter f33051e;

    /* renamed from: f  reason: collision with root package name */
    public o0 f33052f;

    /* renamed from: g  reason: collision with root package name */
    public PullLeftRefreshLayout.f f33053g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f1.w2.f.a<c.a.p0.f1.w2.g.a> f33054h;

    /* loaded from: classes5.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c.a.p0.f1.w2.g.a> f33055b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.p0.f1.w2.f.a<c.a.p0.f1.w2.g.a> f33056c;

        /* loaded from: classes5.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public c.a.p0.f1.w2.g.a f33057b;

            /* renamed from: c  reason: collision with root package name */
            public TBLottieAnimationView f33058c;

            /* renamed from: d  reason: collision with root package name */
            public LinearLayout f33059d;

            /* renamed from: e  reason: collision with root package name */
            public TextView f33060e;

            /* renamed from: f  reason: collision with root package name */
            public EMTextView f33061f;

            /* renamed from: g  reason: collision with root package name */
            public ImageOverlayView f33062g;

            /* renamed from: h  reason: collision with root package name */
            public TextView f33063h;
            public TextView i;
            public TextView j;
            public final /* synthetic */ HorizontalAdapter k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HorizontalAdapter horizontalAdapter, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {horizontalAdapter, view};
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
                this.k = horizontalAdapter;
                this.a = 3;
                this.f33059d = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f092407);
                this.f33058c = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f092408);
                this.f33060e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09240b);
                this.f33061f = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f09240c);
                this.f33062g = (ImageOverlayView) view.findViewById(R.id.obfuscated_res_0x7f09240a);
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds58);
                this.f33062g.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0402, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds28));
                this.f33062g.setStrokeStyle(1);
                this.f33062g.setLoadImageType(12);
                this.f33063h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092409);
                this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092406);
                this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092403);
                this.itemView.setOnClickListener(this);
            }

            public void a(c.a.p0.f1.w2.g.a aVar, int i) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) || aVar == null) {
                    return;
                }
                this.f33057b = aVar;
                if (this.k.f33056c != null) {
                    this.k.f33056c.a(this.itemView, this.f33057b, getAdapterPosition());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
                c(this.f33057b);
                if (i == 1) {
                    d();
                }
            }

            public final void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    if (this.a != i) {
                        SkinManager.setLottieAnimation(this.f33058c, R.raw.lottie_voice_room_voicing_icon);
                        c d2 = c.d(this.itemView);
                        d2.n(R.string.J_X05);
                        d2.f(R.color.CAM_X0201);
                        c d3 = c.d(this.f33059d);
                        d3.n(R.string.J_X01);
                        d3.f(R.color.CAM_X0919);
                        c.d(this.f33060e).v(R.color.CAM_X0115);
                        c d4 = c.d(this.f33061f);
                        d4.A(R.string.F_X02);
                        d4.v(R.color.CAM_X0105);
                        c d5 = c.d(this.j);
                        d5.v(R.color.CAM_X0115);
                        d5.n(R.string.J_X01);
                        d5.f(R.color.CAM_X0919);
                        c.d(this.f33063h).v(R.color.CAM_X0108);
                        c.d(this.i).v(R.color.CAM_X0108);
                    }
                    this.a = i;
                }
            }

            public final void c(c.a.p0.f1.w2.g.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
                    return;
                }
                this.f33061f.setText(aVar.a);
                this.f33062g.setData(aVar.f14831b);
                this.f33063h.setText(String.format(this.k.a.getResources().getString(R.string.obfuscated_res_0x7f0f152a), aVar.f14832c));
                this.i.setText(String.format(this.k.a.getResources().getString(R.string.obfuscated_res_0x7f0f1528), aVar.f14833d));
                this.f33058c.setRepeatCount(Integer.MAX_VALUE);
                this.f33058c.setRepeatMode(1);
                this.f33058c.playAnimation();
            }

            public final void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    Context context = this.itemView.getContext();
                    this.itemView.getLayoutParams().width = n.k(context) - (n.f(context, R.dimen.M_W_X004) * 2);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                    int adapterPosition = getAdapterPosition();
                    if (this.k.f33056c != null) {
                        this.k.f33056c.b(this.itemView, this.f33057b, adapterPosition);
                    }
                }
            }
        }

        public HorizontalAdapter(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33055b = new ArrayList<>();
            this.a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) {
                aVar.a((c.a.p0.f1.w2.g.a) ListUtils.getItem(this.f33055b, i), getItemCount());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: g */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new a(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d035e, viewGroup, false)) : (a) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList<c.a.p0.f1.w2.g.a> arrayList = this.f33055b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        public void h(c.a.p0.f1.w2.f.a<c.a.p0.f1.w2.g.a> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f33056c = aVar;
            }
        }

        public void setData(List<c.a.p0.f1.w2.g.a> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || list == null) {
                return;
            }
            this.f33055b.clear();
            this.f33055b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsVoiceRoomListLayout a;

        public a(FrsVoiceRoomListLayout frsVoiceRoomListLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsVoiceRoomListLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsVoiceRoomListLayout;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f33052f == null) {
                return;
            }
            ((c.a.o0.i0.c.a) ServiceManager.getService(c.a.o0.i0.c.a.a.a())).b(this.a.getContext(), Frs$From.FRS, this.a.f33052f.b(), this.a.f33052f.c());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.f1.w2.f.a<c.a.p0.f1.w2.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsVoiceRoomListLayout a;

        public b(FrsVoiceRoomListLayout frsVoiceRoomListLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsVoiceRoomListLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsVoiceRoomListLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.f1.w2.f.a
        /* renamed from: c */
        public void a(View view, c.a.p0.f1.w2.g.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, aVar, i) == null) || aVar == null || this.a.f33052f == null) {
                return;
            }
            c.a.p0.f1.w2.h.b.a("c14457", this.a.f33052f.b().longValue(), this.a.f33052f.c(), aVar, i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.f1.w2.f.a
        /* renamed from: d */
        public void b(View view, c.a.p0.f1.w2.g.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, view, aVar, i) == null) || aVar == null || this.a.f33052f == null) {
                return;
            }
            ((c.a.o0.i0.c.a) ServiceManager.getService(c.a.o0.i0.c.a.a.a())).a(this.a.a, aVar.f14834e);
            c.a.p0.f1.w2.h.b.a("c14458", this.a.f33052f.b().longValue(), this.a.f33052f.c(), aVar, i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsVoiceRoomListLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d035f, (ViewGroup) this, true);
            setOrientation(0);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f33049c = (PullLeftRefreshLayout) findViewById(R.id.obfuscated_res_0x7f091a2e);
            this.f33050d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a27);
            this.f33051e = new HorizontalAdapter(context);
            int f2 = n.f(context, R.dimen.M_W_X004);
            this.f33050d.addItemDecoration(new SpaceItemDecoration(f2, f2, f2));
            this.f33050d.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.f33050d.setAdapter(this.f33051e);
            this.f33050d.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.f33048b = refreshView;
            this.f33049c.setRefreshViewAndListener(refreshView);
            this.f33049c.setCallback(this.f33053g);
            this.f33051e.h(this.f33054h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: e */
    public void a(o0 o0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o0Var) == null) || o0Var == null) {
            return;
        }
        this.f33051e.setData(c.a.p0.f1.w2.h.a.a(o0Var.a()));
        this.f33050d.setAdapter(this.f33051e);
        this.f33052f = o0Var;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.f33048b.d();
            this.f33051e.notifyDataSetChanged();
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.a = tbPageContext;
        }
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.f33049c) == null) {
            return;
        }
        pullLeftRefreshLayout.setEnablePull(z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVoiceRoomListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33053g = new a(this);
        this.f33054h = new b(this);
        d(context);
    }
}
