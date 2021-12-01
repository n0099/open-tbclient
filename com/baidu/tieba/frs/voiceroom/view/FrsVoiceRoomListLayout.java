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
import c.a.d.f.p.l;
import c.a.k.p;
import c.a.k.q;
import c.a.q0.s.u.c;
import c.a.q0.t.c.p0;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
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
/* loaded from: classes10.dex */
public class FrsVoiceRoomListLayout extends LinearLayout implements q, p<p0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f44905e;

    /* renamed from: f  reason: collision with root package name */
    public RefreshView f44906f;

    /* renamed from: g  reason: collision with root package name */
    public PullLeftRefreshLayout f44907g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f44908h;

    /* renamed from: i  reason: collision with root package name */
    public HorizontalAdapter f44909i;

    /* renamed from: j  reason: collision with root package name */
    public p0 f44910j;

    /* renamed from: k  reason: collision with root package name */
    public PullLeftRefreshLayout.f f44911k;
    public c.a.r0.d1.d3.f.a<c.a.r0.d1.d3.g.a> l;

    /* loaded from: classes10.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c.a.r0.d1.d3.g.a> f44912b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r0.d1.d3.f.a<c.a.r0.d1.d3.g.a> f44913c;

        /* loaded from: classes10.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public int f44914e;

            /* renamed from: f  reason: collision with root package name */
            public c.a.r0.d1.d3.g.a f44915f;

            /* renamed from: g  reason: collision with root package name */
            public TBLottieAnimationView f44916g;

            /* renamed from: h  reason: collision with root package name */
            public LinearLayout f44917h;

            /* renamed from: i  reason: collision with root package name */
            public TextView f44918i;

            /* renamed from: j  reason: collision with root package name */
            public EMTextView f44919j;

            /* renamed from: k  reason: collision with root package name */
            public ImageOverlayView f44920k;
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
                this.f44914e = 3;
                this.f44917h = (LinearLayout) view.findViewById(f1.voice_room_talking_layout);
                this.f44916g = (TBLottieAnimationView) view.findViewById(f1.voice_room_talking_lottie);
                this.f44918i = (TextView) view.findViewById(f1.voice_room_talking_text);
                this.f44919j = (EMTextView) view.findViewById(f1.voice_room_title);
                this.f44920k = (ImageOverlayView) view.findViewById(f1.voice_room_talking_portrait);
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds58);
                this.f44920k.init(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0402, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds28));
                this.f44920k.setStrokeStyle(1);
                this.f44920k.setLoadImageType(12);
                this.l = (TextView) view.findViewById(f1.voice_room_talking_num);
                this.m = (TextView) view.findViewById(f1.voice_room_online_num);
                this.n = (TextView) view.findViewById(f1.voice_room_join);
                this.itemView.setOnClickListener(this);
            }

            public void a(c.a.r0.d1.d3.g.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                this.f44915f = aVar;
                if (this.o.f44913c != null) {
                    this.o.f44913c.a(this.itemView, this.f44915f, getAdapterPosition());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
                c(this.f44915f);
            }

            public final void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    if (this.f44914e != i2) {
                        SkinManager.setLottieAnimation(this.f44916g, R.raw.lottie_voice_room_voicing_icon);
                        c d2 = c.d(this.itemView);
                        d2.n(i1.J_X05);
                        d2.f(c1.CAM_X0201);
                        c d3 = c.d(this.f44917h);
                        d3.n(i1.J_X01);
                        d3.f(c1.CAM_X0919);
                        c.d(this.f44918i).v(c1.CAM_X0115);
                        c d4 = c.d(this.f44919j);
                        d4.A(i1.F_X02);
                        d4.v(c1.CAM_X0105);
                        c d5 = c.d(this.n);
                        d5.v(c1.CAM_X0115);
                        d5.n(i1.J_X01);
                        d5.f(c1.CAM_X0919);
                        c.d(this.l).v(c1.CAM_X0108);
                        c.d(this.m).v(c1.CAM_X0108);
                    }
                    this.f44914e = i2;
                }
            }

            public final void c(c.a.r0.d1.d3.g.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
                    return;
                }
                this.f44919j.setText(aVar.a);
                this.f44920k.setData(aVar.f15459b);
                this.l.setText(String.format(this.o.a.getResources().getString(i1.voice_room_talking_num), aVar.f15460c));
                this.m.setText(String.format(this.o.a.getResources().getString(i1.voice_room_online_num), aVar.f15461d));
                this.f44916g.setRepeatCount(Integer.MAX_VALUE);
                this.f44916g.setRepeatMode(1);
                this.f44916g.playAnimation();
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
                    int adapterPosition = getAdapterPosition();
                    if (this.o.f44913c != null) {
                        this.o.f44913c.b(this.itemView, this.f44915f, adapterPosition);
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
            this.f44912b = new ArrayList<>();
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList<c.a.r0.d1.d3.g.a> arrayList = this.f44912b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        public void setData(List<c.a.r0.d1.d3.g.a> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
                return;
            }
            this.f44912b.clear();
            this.f44912b.addAll(list);
            notifyDataSetChanged();
        }

        public void setOnItemCoverListener(c.a.r0.d1.d3.f.a<c.a.r0.d1.d3.g.a> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                this.f44913c = aVar;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i2) == null) {
                aVar.a((c.a.r0.d1.d3.g.a) ListUtils.getItem(this.f44912b, i2));
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

    /* loaded from: classes10.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f44910j == null) {
                return;
            }
            ((c.a.q0.j0.c.a) ServiceManager.getService(c.a.q0.j0.c.a.a.a())).b(this.a.getContext(), Frs$From.FRS, this.a.f44910j.b(), this.a.f44910j.c());
        }
    }

    /* loaded from: classes10.dex */
    public class b implements c.a.r0.d1.d3.f.a<c.a.r0.d1.d3.g.a> {
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
        @Override // c.a.r0.d1.d3.f.a
        /* renamed from: c */
        public void a(View view, c.a.r0.d1.d3.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, aVar, i2) == null) || aVar == null || this.a.f44910j == null) {
                return;
            }
            c.a.r0.d1.d3.h.b.a("c14457", this.a.f44910j.b().longValue(), this.a.f44910j.c(), aVar, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.d3.f.a
        /* renamed from: d */
        public void b(View view, c.a.r0.d1.d3.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, view, aVar, i2) == null) || aVar == null || this.a.f44910j == null) {
                return;
            }
            ((c.a.q0.j0.c.a) ServiceManager.getService(c.a.q0.j0.c.a.a.a())).a(this.a.f44905e, aVar.f15462e);
            c.a.r0.d1.d3.h.b.a("c14458", this.a.f44910j.b().longValue(), this.a.f44910j.c(), aVar, i2);
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
            this.f44907g = (PullLeftRefreshLayout) findViewById(f1.refresh_layout);
            this.f44908h = (RecyclerView) findViewById(f1.recycler_view);
            this.f44909i = new HorizontalAdapter(context);
            int f2 = l.f(context, d1.M_W_X004);
            this.f44908h.addItemDecoration(new SpaceItemDecoration(f2, f2, f2));
            this.f44908h.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.f44908h.setAdapter(this.f44909i);
            this.f44908h.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.f44906f = refreshView;
            this.f44907g.setRefreshViewAndListener(refreshView);
            this.f44907g.setCallback(this.f44911k);
            this.f44909i.setOnItemCoverListener(this.l);
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.f44906f.onChangeSkinType();
            this.f44909i.notifyDataSetChanged();
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.f44905e = tbPageContext;
        }
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.f44907g) == null) {
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
        this.f44911k = new a(this);
        this.l = new b(this);
        c(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.k.p
    public void onBindDataToView(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0Var) == null) || p0Var == null) {
            return;
        }
        this.f44909i.setData(c.a.r0.d1.d3.h.a.a(p0Var.a()));
        this.f44908h.setAdapter(this.f44909i);
        this.f44910j = p0Var;
    }
}
