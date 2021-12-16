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
import c.a.d.f.p.m;
import c.a.l.p;
import c.a.l.q;
import c.a.r0.s.v.c;
import c.a.r0.t.c.q0;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.f1;
import c.a.s0.d1.g1;
import c.a.s0.d1.i1;
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
/* loaded from: classes12.dex */
public class FrsVoiceRoomListLayout extends LinearLayout implements q, p<q0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f45396e;

    /* renamed from: f  reason: collision with root package name */
    public RefreshView f45397f;

    /* renamed from: g  reason: collision with root package name */
    public PullLeftRefreshLayout f45398g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f45399h;

    /* renamed from: i  reason: collision with root package name */
    public HorizontalAdapter f45400i;

    /* renamed from: j  reason: collision with root package name */
    public q0 f45401j;

    /* renamed from: k  reason: collision with root package name */
    public PullLeftRefreshLayout.f f45402k;
    public c.a.s0.d1.d3.f.a<c.a.s0.d1.d3.g.a> l;

    /* loaded from: classes12.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c.a.s0.d1.d3.g.a> f45403b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.s0.d1.d3.f.a<c.a.s0.d1.d3.g.a> f45404c;

        /* loaded from: classes12.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public int f45405e;

            /* renamed from: f  reason: collision with root package name */
            public c.a.s0.d1.d3.g.a f45406f;

            /* renamed from: g  reason: collision with root package name */
            public TBLottieAnimationView f45407g;

            /* renamed from: h  reason: collision with root package name */
            public LinearLayout f45408h;

            /* renamed from: i  reason: collision with root package name */
            public TextView f45409i;

            /* renamed from: j  reason: collision with root package name */
            public EMTextView f45410j;

            /* renamed from: k  reason: collision with root package name */
            public ImageOverlayView f45411k;
            public TextView l;
            public TextView m;
            public TextView n;
            public final /* synthetic */ HorizontalAdapter o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HorizontalAdapter horizontalAdapter, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {horizontalAdapter, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.o = horizontalAdapter;
                this.f45405e = 3;
                this.f45408h = (LinearLayout) view.findViewById(f1.voice_room_talking_layout);
                this.f45407g = (TBLottieAnimationView) view.findViewById(f1.voice_room_talking_lottie);
                this.f45409i = (TextView) view.findViewById(f1.voice_room_talking_text);
                this.f45410j = (EMTextView) view.findViewById(f1.voice_room_title);
                this.f45411k = (ImageOverlayView) view.findViewById(f1.voice_room_talking_portrait);
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds58);
                this.f45411k.init(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0402, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds28));
                this.f45411k.setStrokeStyle(1);
                this.f45411k.setLoadImageType(12);
                this.l = (TextView) view.findViewById(f1.voice_room_talking_num);
                this.m = (TextView) view.findViewById(f1.voice_room_online_num);
                this.n = (TextView) view.findViewById(f1.voice_room_join);
                this.itemView.setOnClickListener(this);
            }

            public void a(c.a.s0.d1.d3.g.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || aVar == null) {
                    return;
                }
                this.f45406f = aVar;
                if (this.o.f45404c != null) {
                    this.o.f45404c.a(this.itemView, this.f45406f, getAdapterPosition());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
                c(this.f45406f);
                if (i2 == 1) {
                    d();
                }
            }

            public final void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    if (this.f45405e != i2) {
                        SkinManager.setLottieAnimation(this.f45407g, R.raw.lottie_voice_room_voicing_icon);
                        c d2 = c.d(this.itemView);
                        d2.n(i1.J_X05);
                        d2.f(c1.CAM_X0201);
                        c d3 = c.d(this.f45408h);
                        d3.n(i1.J_X01);
                        d3.f(c1.CAM_X0919);
                        c.d(this.f45409i).v(c1.CAM_X0115);
                        c d4 = c.d(this.f45410j);
                        d4.A(i1.F_X02);
                        d4.v(c1.CAM_X0105);
                        c d5 = c.d(this.n);
                        d5.v(c1.CAM_X0115);
                        d5.n(i1.J_X01);
                        d5.f(c1.CAM_X0919);
                        c.d(this.l).v(c1.CAM_X0108);
                        c.d(this.m).v(c1.CAM_X0108);
                    }
                    this.f45405e = i2;
                }
            }

            public final void c(c.a.s0.d1.d3.g.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
                    return;
                }
                this.f45410j.setText(aVar.a);
                this.f45411k.setData(aVar.f15869b);
                this.l.setText(String.format(this.o.a.getResources().getString(i1.voice_room_talking_num), aVar.f15870c));
                this.m.setText(String.format(this.o.a.getResources().getString(i1.voice_room_online_num), aVar.f15871d));
                this.f45407g.setRepeatCount(Integer.MAX_VALUE);
                this.f45407g.setRepeatMode(1);
                this.f45407g.playAnimation();
            }

            public final void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    Context context = this.itemView.getContext();
                    this.itemView.getLayoutParams().width = m.k(context) - (m.f(context, d1.M_W_X004) * 2);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                    int adapterPosition = getAdapterPosition();
                    if (this.o.f45404c != null) {
                        this.o.f45404c.b(this.itemView, this.f45406f, adapterPosition);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45403b = new ArrayList<>();
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList<c.a.s0.d1.d3.g.a> arrayList = this.f45403b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        public void setData(List<c.a.s0.d1.d3.g.a> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
                return;
            }
            this.f45403b.clear();
            this.f45403b.addAll(list);
            notifyDataSetChanged();
        }

        public void setOnItemCoverListener(c.a.s0.d1.d3.f.a<c.a.s0.d1.d3.g.a> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                this.f45404c = aVar;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i2) == null) {
                aVar.a((c.a.s0.d1.d3.g.a) ListUtils.getItem(this.f45403b, i2), getItemCount());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(this.a).inflate(g1.frs_voice_room_card, viewGroup, false)) : (a) invokeLI.objValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f45401j == null) {
                return;
            }
            ((c.a.r0.j0.c.a) ServiceManager.getService(c.a.r0.j0.c.a.a.a())).b(this.a.getContext(), Frs$From.FRS, this.a.f45401j.b(), this.a.f45401j.c());
        }
    }

    /* loaded from: classes12.dex */
    public class b implements c.a.s0.d1.d3.f.a<c.a.s0.d1.d3.g.a> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsVoiceRoomListLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.d3.f.a
        /* renamed from: c */
        public void a(View view, c.a.s0.d1.d3.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, aVar, i2) == null) || aVar == null || this.a.f45401j == null) {
                return;
            }
            c.a.s0.d1.d3.h.b.a("c14457", this.a.f45401j.b().longValue(), this.a.f45401j.c(), aVar, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.d3.f.a
        /* renamed from: d */
        public void b(View view, c.a.s0.d1.d3.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, view, aVar, i2) == null) || aVar == null || this.a.f45401j == null) {
                return;
            }
            ((c.a.r0.j0.c.a) ServiceManager.getService(c.a.r0.j0.c.a.a.a())).a(this.a.f45396e, aVar.f15872e);
            c.a.s0.d1.d3.h.b.a("c14458", this.a.f45401j.b().longValue(), this.a.f45401j.c(), aVar, i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(getContext()).inflate(g1.frs_voice_room_group_pullleft_refresh_layout, (ViewGroup) this, true);
            setOrientation(0);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f45398g = (PullLeftRefreshLayout) findViewById(f1.refresh_layout);
            this.f45399h = (RecyclerView) findViewById(f1.recycler_view);
            this.f45400i = new HorizontalAdapter(context);
            int f2 = m.f(context, d1.M_W_X004);
            this.f45399h.addItemDecoration(new SpaceItemDecoration(f2, f2, f2));
            this.f45399h.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.f45399h.setAdapter(this.f45400i);
            this.f45399h.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.f45397f = refreshView;
            this.f45398g.setRefreshViewAndListener(refreshView);
            this.f45398g.setCallback(this.f45402k);
            this.f45400i.setOnItemCoverListener(this.l);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.f45397f.onChangeSkinType();
            this.f45400i.notifyDataSetChanged();
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.f45396e = tbPageContext;
        }
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.f45398g) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45402k = new a(this);
        this.l = new b(this);
        c(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q0Var) == null) || q0Var == null) {
            return;
        }
        this.f45400i.setData(c.a.s0.d1.d3.h.a.a(q0Var.a()));
        this.f45399h.setAdapter(this.f45400i);
        this.f45401j = q0Var;
    }
}
