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
import com.baidu.tieba.ay7;
import com.baidu.tieba.by7;
import com.baidu.tieba.de5;
import com.baidu.tieba.fy7;
import com.baidu.tieba.gy7;
import com.baidu.tieba.ux;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.vx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsVoiceRoomListLayout extends LinearLayout implements vx, ux<de5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public RefreshView b;
    public PullLeftRefreshLayout c;
    public RecyclerView d;
    public HorizontalAdapter e;
    public de5 f;
    public PullLeftRefreshLayout.f g;
    public ay7<by7> h;

    /* loaded from: classes5.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public ArrayList<by7> b;
        public ay7<by7> c;

        /* loaded from: classes5.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public by7 b;
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
                this.f = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092a0d);
                this.g = (ImageOverlayView) view2.findViewById(R.id.obfuscated_res_0x7f092a0b);
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds58);
                this.g.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0402, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds28));
                this.g.setStrokeStyle(1);
                this.g.setLoadImageType(12);
                this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a0a);
                this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a07);
                this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a04);
                this.itemView.setOnClickListener(this);
            }

            public void a(by7 by7Var, int i) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLI(1048576, this, by7Var, i) != null) || by7Var == null) {
                    return;
                }
                this.b = by7Var;
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

            public final void c(by7 by7Var) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, by7Var) != null) || by7Var == null) {
                    return;
                }
                this.f.setText(by7Var.a);
                this.g.setData(by7Var.b);
                this.h.setText(String.format(this.k.a.getResources().getString(R.string.voice_room_talking_num), by7Var.c));
                this.i.setText(String.format(this.k.a.getResources().getString(R.string.voice_room_online_num), by7Var.d));
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

        public void p(ay7<by7> ay7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ay7Var) == null) {
                this.c = ay7Var;
            }
        }

        public void setData(List<by7> list) {
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
                ArrayList<by7> arrayList = this.b;
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
                aVar.a((by7) ListUtils.getItem(this.b, i), getItemCount());
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
                return new a(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03b2, viewGroup, false));
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
            ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoomList(this.a.getContext(), Frs$From.FRS, this.a.f.b(), this.a.f.c());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ay7<by7> {
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
        @Override // com.baidu.tieba.ay7
        /* renamed from: c */
        public void a(View view2, by7 by7Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, by7Var, i) == null) && by7Var != null && this.a.f != null) {
                gy7.a("c14457", this.a.f.b().longValue(), this.a.f.c(), by7Var, i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ay7
        /* renamed from: d */
        public void b(View view2, by7 by7Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, view2, by7Var, i) == null) && by7Var != null && this.a.f != null) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(this.a.a, by7Var.e);
                gy7.a("c14458", this.a.f.b().longValue(), this.a.f.c(), by7Var, i);
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
    @Override // com.baidu.tieba.ux
    /* renamed from: d */
    public void onBindDataToView(de5 de5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, de5Var) != null) || de5Var == null) {
            return;
        }
        this.e.setData(fy7.a(de5Var.a()));
        this.d.setAdapter(this.e);
        this.f = de5Var;
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b3, (ViewGroup) this, true);
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
            this.e.p(this.h);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.b.d();
            this.e.notifyDataSetChanged();
        }
    }
}
