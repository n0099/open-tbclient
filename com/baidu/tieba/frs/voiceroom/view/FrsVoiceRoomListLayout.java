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
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br6;
import com.repackage.cr6;
import com.repackage.gs4;
import com.repackage.hy4;
import com.repackage.mi;
import com.repackage.n55;
import com.repackage.oy;
import com.repackage.py;
import com.repackage.wq6;
import com.repackage.xq6;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsVoiceRoomListLayout extends LinearLayout implements py, oy<hy4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public RefreshView b;
    public PullLeftRefreshLayout c;
    public RecyclerView d;
    public HorizontalAdapter e;
    public hy4 f;
    public PullLeftRefreshLayout.f g;
    public wq6<xq6> h;

    /* loaded from: classes3.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public ArrayList<xq6> b;
        public wq6<xq6> c;

        /* loaded from: classes3.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public xq6 b;
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
                this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092434);
                this.c = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f092435);
                this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092438);
                this.f = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092439);
                this.g = (ImageOverlayView) view2.findViewById(R.id.obfuscated_res_0x7f092437);
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds58);
                this.g.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0402, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds28));
                this.g.setStrokeStyle(1);
                this.g.setLoadImageType(12);
                this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092436);
                this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092433);
                this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092430);
                this.itemView.setOnClickListener(this);
            }

            public void a(xq6 xq6Var, int i) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLI(1048576, this, xq6Var, i) == null) || xq6Var == null) {
                    return;
                }
                this.b = xq6Var;
                if (this.k.c != null) {
                    this.k.c.a(this.itemView, this.b, getAdapterPosition());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
                c(this.b);
                if (i == 1) {
                    d();
                }
            }

            public final void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    if (this.a != i) {
                        SkinManager.setLottieAnimation(this.c, R.raw.lottie_voice_room_voicing_icon);
                        gs4 d = gs4.d(this.itemView);
                        d.n(R.string.J_X05);
                        d.f(R.color.CAM_X0201);
                        gs4 d2 = gs4.d(this.d);
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0919);
                        gs4.d(this.e).v(R.color.CAM_X0115);
                        gs4 d3 = gs4.d(this.f);
                        d3.A(R.string.F_X02);
                        d3.v(R.color.CAM_X0105);
                        gs4 d4 = gs4.d(this.j);
                        d4.v(R.color.CAM_X0115);
                        d4.n(R.string.J_X01);
                        d4.f(R.color.CAM_X0919);
                        gs4.d(this.h).v(R.color.CAM_X0108);
                        gs4.d(this.i).v(R.color.CAM_X0108);
                    }
                    this.a = i;
                }
            }

            public final void c(xq6 xq6Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xq6Var) == null) || xq6Var == null) {
                    return;
                }
                this.f.setText(xq6Var.a);
                this.g.setData(xq6Var.b);
                this.h.setText(String.format(this.k.a.getResources().getString(R.string.obfuscated_res_0x7f0f155d), xq6Var.c));
                this.i.setText(String.format(this.k.a.getResources().getString(R.string.obfuscated_res_0x7f0f155b), xq6Var.d));
                this.c.setRepeatCount(Integer.MAX_VALUE);
                this.c.setRepeatMode(1);
                this.c.playAnimation();
            }

            public final void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    Context context = this.itemView.getContext();
                    this.itemView.getLayoutParams().width = mi.k(context) - (mi.f(context, R.dimen.M_W_X004) * 2);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) {
                aVar.a((xq6) ListUtils.getItem(this.b, i), getItemCount());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: g */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new a(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0357, viewGroup, false)) : (a) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList<xq6> arrayList = this.b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        public void h(wq6<xq6> wq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, wq6Var) == null) {
                this.c = wq6Var;
            }
        }

        public void setData(List<xq6> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || list == null) {
                return;
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f == null) {
                return;
            }
            ((n55) ServiceManager.getService(n55.a.a())).b(this.a.getContext(), Frs$From.FRS, this.a.f.b(), this.a.f.c());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements wq6<xq6> {
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
        @Override // com.repackage.wq6
        /* renamed from: c */
        public void a(View view2, xq6 xq6Var, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, xq6Var, i) == null) || xq6Var == null || this.a.f == null) {
                return;
            }
            cr6.a("c14457", this.a.f.b().longValue(), this.a.f.c(), xq6Var, i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wq6
        /* renamed from: d */
        public void b(View view2, xq6 xq6Var, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, view2, xq6Var, i) == null) || xq6Var == null || this.a.f == null) {
                return;
            }
            ((n55) ServiceManager.getService(n55.a.a())).a(this.a.a, xq6Var.e);
            cr6.a("c14458", this.a.f.b().longValue(), this.a.f.c(), xq6Var, i);
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0358, (ViewGroup) this, true);
            setOrientation(0);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.c = (PullLeftRefreshLayout) findViewById(R.id.obfuscated_res_0x7f091a71);
            this.d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a6a);
            this.e = new HorizontalAdapter(context);
            int f = mi.f(context, R.dimen.M_W_X004);
            this.d.addItemDecoration(new SpaceItemDecoration(f, f, f));
            this.d.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.d.setAdapter(this.e);
            this.d.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.b = refreshView;
            this.c.setRefreshViewAndListener(refreshView);
            this.c.setCallback(this.g);
            this.e.h(this.h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: e */
    public void a(hy4 hy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hy4Var) == null) || hy4Var == null) {
            return;
        }
        this.e.setData(br6.a(hy4Var.a()));
        this.d.setAdapter(this.e);
        this.f = hy4Var;
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.b.d();
            this.e.notifyDataSetChanged();
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
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.c) == null) {
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
        this.g = new a(this);
        this.h = new b(this);
        d(context);
    }
}
