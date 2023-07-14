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
import com.baidu.tieba.d85;
import com.baidu.tieba.mx7;
import com.baidu.tieba.nx7;
import com.baidu.tieba.qp5;
import com.baidu.tieba.rx7;
import com.baidu.tieba.ry;
import com.baidu.tieba.sx7;
import com.baidu.tieba.sy;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.ye5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsVoiceRoomListLayout extends LinearLayout implements sy, ry<ye5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public RefreshView b;
    public PullLeftRefreshLayout c;
    public RecyclerView d;
    public HorizontalAdapter e;
    public ye5 f;
    public PullLeftRefreshLayout.f g;
    public mx7<nx7> h;

    /* loaded from: classes5.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public ArrayList<nx7> b;
        public mx7<nx7> c;

        /* loaded from: classes5.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public nx7 b;
            public TBLottieAnimationView c;
            public LinearLayout d;
            public TextView e;
            public EMTextView f;
            public ImageOverlayView g;
            public TextView h;
            public TextView i;
            public TextView j;
            public final /* synthetic */ HorizontalAdapter k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HorizontalAdapter horizontalAdapter, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {horizontalAdapter, view2};
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
                this.d = (LinearLayout) view2.findViewById(R.id.voice_room_talking_layout);
                this.c = (TBLottieAnimationView) view2.findViewById(R.id.voice_room_talking_lottie);
                this.e = (TextView) view2.findViewById(R.id.voice_room_talking_text);
                this.f = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092986);
                this.g = (ImageOverlayView) view2.findViewById(R.id.obfuscated_res_0x7f092984);
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds58);
                this.g.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0402, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds28));
                this.g.setStrokeStyle(1);
                this.g.setLoadImageType(12);
                this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092983);
                this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092980);
                this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09297d);
                this.itemView.setOnClickListener(this);
            }

            public void b(nx7 nx7Var, int i) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLI(1048576, this, nx7Var, i) != null) || nx7Var == null) {
                    return;
                }
                this.b = nx7Var;
                if (this.k.c != null) {
                    this.k.c.a(this.itemView, this.b, getAdapterPosition());
                }
                c(TbadkCoreApplication.getInst().getSkinType());
                d(this.b);
                if (i == 1) {
                    e();
                }
            }

            public final void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    if (this.a != i) {
                        SkinManager.setLottieAnimation(this.c, R.raw.lottie_voice_room_voicing_icon);
                        d85 d = d85.d(this.itemView);
                        d.o(R.string.J_X05);
                        d.f(R.color.CAM_X0201);
                        d85 d2 = d85.d(this.d);
                        d2.o(R.string.J_X01);
                        d2.f(R.color.CAM_X0919);
                        d85.d(this.e).x(R.color.CAM_X0115);
                        d85 d3 = d85.d(this.f);
                        d3.D(R.string.F_X02);
                        d3.x(R.color.CAM_X0105);
                        d85 d4 = d85.d(this.j);
                        d4.x(R.color.CAM_X0115);
                        d4.o(R.string.J_X01);
                        d4.f(R.color.CAM_X0919);
                        d85.d(this.h).x(R.color.CAM_X0108);
                        d85.d(this.i).x(R.color.CAM_X0108);
                    }
                    this.a = i;
                }
            }

            public final void d(nx7 nx7Var) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nx7Var) != null) || nx7Var == null) {
                    return;
                }
                this.f.setText(nx7Var.a);
                this.g.setData(nx7Var.b);
                this.h.setText(String.format(this.k.a.getResources().getString(R.string.voice_room_talking_num), nx7Var.c));
                this.i.setText(String.format(this.k.a.getResources().getString(R.string.voice_room_online_num), nx7Var.d));
                this.c.setRepeatCount(Integer.MAX_VALUE);
                this.c.setRepeatMode(1);
                this.c.playAnimation();
            }

            public final void e() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    Context context = this.itemView.getContext();
                    this.itemView.getLayoutParams().width = yi.l(context) - (yi.g(context, R.dimen.M_W_X004) * 2);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
                    int adapterPosition = getAdapterPosition();
                    if (this.k.c != null) {
                        this.k.c.b(this.itemView, this.b, adapterPosition);
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
            this.b = new ArrayList<>();
            this.a = context;
        }

        public void p(mx7<nx7> mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mx7Var) == null) {
                this.c = mx7Var;
            }
        }

        public void setData(List<nx7> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || list == null) {
                return;
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList<nx7> arrayList = this.b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i) == null) {
                aVar.b((nx7) ListUtils.getItem(this.b, i), getItemCount());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: o */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                return new a(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03a4, viewGroup, false));
            }
            return (a) invokeLI.objValue;
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.f == null) {
                return;
            }
            ((qp5) ServiceManager.getService(qp5.a.a())).c(this.a.getContext(), Frs$From.FRS, this.a.f.b(), this.a.f.c());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mx7<nx7> {
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
        @Override // com.baidu.tieba.mx7
        /* renamed from: c */
        public void a(View view2, nx7 nx7Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, nx7Var, i) == null) && nx7Var != null && this.a.f != null) {
                sx7.a("c14457", this.a.f.b().longValue(), this.a.f.c(), nx7Var, i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mx7
        /* renamed from: d */
        public void b(View view2, nx7 nx7Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, view2, nx7Var, i) == null) && nx7Var != null && this.a.f != null) {
                ((qp5) ServiceManager.getService(qp5.a.a())).b(this.a.a, nx7Var.e);
                sx7.a("c14458", this.a.f.b().longValue(), this.a.f.c(), nx7Var, i);
            }
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
        this.g = new a(this);
        this.h = new b(this);
        d(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: e */
    public void b(ye5 ye5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ye5Var) != null) || ye5Var == null) {
            return;
        }
        this.e.setData(rx7.a(ye5Var.a()));
        this.d.setAdapter(this.e);
        this.f = ye5Var;
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
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (pullLeftRefreshLayout = this.c) != null) {
            pullLeftRefreshLayout.setEnablePull(z);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03a5, (ViewGroup) this, true);
            setOrientation(0);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.c = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.d = (RecyclerView) findViewById(R.id.recycler_view);
            this.e = new HorizontalAdapter(context);
            int g = yi.g(context, R.dimen.M_W_X004);
            this.d.addItemDecoration(new SpaceItemDecoration(g, g, g));
            this.d.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.d.setAdapter(this.e);
            this.d.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.b = refreshView;
            this.c.setRefreshViewAndListener(refreshView);
            this.c.setCallback(this.g);
            this.e.p(this.h);
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.b.d();
            this.e.notifyDataSetChanged();
        }
    }
}
