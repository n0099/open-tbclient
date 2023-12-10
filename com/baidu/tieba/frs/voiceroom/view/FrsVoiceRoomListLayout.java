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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.i88;
import com.baidu.tieba.it;
import com.baidu.tieba.j88;
import com.baidu.tieba.jt;
import com.baidu.tieba.n88;
import com.baidu.tieba.o88;
import com.baidu.tieba.r95;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsVoiceRoomListLayout extends LinearLayout implements jt, it<r95> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public RefreshView b;
    public PullLeftRefreshLayout c;
    public RecyclerView d;
    public HorizontalAdapter e;
    public r95 f;
    public PullLeftRefreshLayout.f g;
    public i88<j88> h;

    /* loaded from: classes6.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public ArrayList<j88> b;
        public i88<j88> c;

        /* loaded from: classes6.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public j88 b;
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
                this.f = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092ab4);
                this.g = (ImageOverlayView) view2.findViewById(R.id.obfuscated_res_0x7f092ab2);
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds58);
                this.g.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0402, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds28));
                this.g.setStrokeStyle(1);
                this.g.setLoadImageType(12);
                this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092ab1);
                this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092aae);
                this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092aab);
                this.itemView.setOnClickListener(this);
            }

            public void a(j88 j88Var, int i) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLI(1048576, this, j88Var, i) != null) || j88Var == null) {
                    return;
                }
                this.b = j88Var;
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
                        EMManager.from(this.itemView).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
                        EMManager.from(this.d).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0919);
                        EMManager.from(this.e).setTextColor(R.color.CAM_X0115);
                        EMManager.from(this.f).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
                        EMManager.from(this.j).setTextColor(R.color.CAM_X0115).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0919);
                        EMManager.from(this.h).setTextColor(R.color.CAM_X0108);
                        EMManager.from(this.i).setTextColor(R.color.CAM_X0108);
                    }
                    this.a = i;
                }
            }

            public final void c(j88 j88Var) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j88Var) != null) || j88Var == null) {
                    return;
                }
                this.f.setText(j88Var.a);
                this.g.setData(j88Var.b);
                this.h.setText(String.format(this.k.a.getResources().getString(R.string.voice_room_talking_num), j88Var.c));
                this.i.setText(String.format(this.k.a.getResources().getString(R.string.voice_room_online_num), j88Var.d));
                this.c.setRepeatCount(Integer.MAX_VALUE);
                this.c.setRepeatMode(1);
                this.c.playAnimation();
            }

            public final void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    Context context = this.itemView.getContext();
                    this.itemView.getLayoutParams().width = BdUtilHelper.getEquipmentWidth(context) - (BdUtilHelper.getDimens(context, R.dimen.M_W_X004) * 2);
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

        public void q(i88<j88> i88Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, i88Var) == null) {
                this.c = i88Var;
            }
        }

        public void setData(List<j88> list) {
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
                ArrayList<j88> arrayList = this.b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: o */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i) == null) {
                aVar.a((j88) ListUtils.getItem(this.b, i), getItemCount());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: p */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
                return new a(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03ce, viewGroup, false));
            }
            return (a) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
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
            ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoomList(this.a.getContext(), Frs$From.FRS, this.a.f.b(), this.a.f.c());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements i88<j88> {
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
        @Override // com.baidu.tieba.i88
        /* renamed from: c */
        public void a(View view2, j88 j88Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, j88Var, i) == null) && j88Var != null && this.a.f != null) {
                o88.a("c14457", this.a.f.b().longValue(), this.a.f.c(), j88Var, i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i88
        /* renamed from: d */
        public void b(View view2, j88 j88Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, view2, j88Var, i) == null) && j88Var != null && this.a.f != null) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(this.a.a, j88Var.e);
                o88.a("c14458", this.a.f.b().longValue(), this.a.f.c(), j88Var, i);
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
        c(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: d */
    public void onBindDataToView(r95 r95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r95Var) != null) || r95Var == null) {
            return;
        }
        this.e.setData(n88.a(r95Var.a()));
        this.d.setAdapter(this.e);
        this.f = r95Var;
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

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03cf, (ViewGroup) this, true);
            setOrientation(0);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.c = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.d = (RecyclerView) findViewById(R.id.recycler_view);
            this.e = new HorizontalAdapter(context);
            int dimens = BdUtilHelper.getDimens(context, R.dimen.M_W_X004);
            this.d.addItemDecoration(new SpaceItemDecoration(dimens, dimens, dimens));
            this.d.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.d.setAdapter(this.e);
            this.d.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.b = refreshView;
            this.c.setRefreshViewAndListener(refreshView);
            this.c.setCallback(this.g);
            this.e.q(this.h);
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.b.d();
            this.e.notifyDataSetChanged();
        }
    }
}
