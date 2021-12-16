package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.m;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.e1;
import c.a.s0.d1.i1;
import c.a.s0.d1.s2.b;
import c.a.s0.d1.s2.d;
import c.a.s0.v3.c0;
import c.a.s0.v3.d0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class MultiServiceViewController implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f45138b;

    /* renamed from: c  reason: collision with root package name */
    public List<d0> f45139c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f45140d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f45141e;

    /* loaded from: classes12.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f45142b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f45143c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f45144d;

        /* renamed from: e  reason: collision with root package name */
        public d0 f45145e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f45146f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f45147g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f45148h;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f45149e;

            public a(ServiceViewHolder serviceViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {serviceViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45149e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(i1.hot_user_rank), this.f45149e.f45145e.f24841b) || this.f45149e.f45147g == null || this.f45149e.f45147g.getForum() == null || TextUtils.isEmpty(this.f45149e.f45147g.getForum().getId())) {
                        if (this.f45149e.f45145e != null && this.f45149e.f45145e.f24845f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f45149e.f45145e.f24846g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f45149e.f45145e.f24845f.f24852b).param("obj_name", this.f45149e.f45145e.f24845f.a).param("obj_param1", this.f45149e.f45145e.f24845f.f24854d.intValue()));
                        }
                        d.b(view.getContext(), this.f45149e.f45145e);
                        d.c(this.f45149e.f45145e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.f45149e.f45147g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f45149e.f45147g.getForum().getId());
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, frsViewData};
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
            this.f45146f = new ArrayList();
            this.f45148h = new a(this);
            Context context = view.getContext();
            this.f45147g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.a = linearLayout;
            linearLayout.setGravity(16);
            this.a.setOrientation(0);
            this.f45142b = new FrameLayout(context);
            this.f45143c = new TbClipImageView(context);
            int f2 = m.f(context, d1.tbds57);
            this.f45143c.setDrawerType(1);
            this.f45143c.setIsRound(true);
            this.f45143c.setBorderWidth(d1.L_X01);
            this.f45143c.setBorderColor(c1.CAM_X0401);
            this.f45143c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f45143c.setPlaceHolder(1);
            this.f45142b.addView(this.f45143c, new FrameLayout.LayoutParams(f2, f2));
            this.a.addView(this.f45142b, new LinearLayout.LayoutParams(-2, m.f(this.f45143c.getContext(), d1.tbds62)));
            TextView textView = new TextView(context);
            this.f45144d = textView;
            textView.setTextSize(0, m.f(context, d1.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = m.f(context, d1.tbds10);
            layoutParams.rightMargin = m.f(context, d1.M_W_X008);
            this.a.addView(this.f45144d, layoutParams);
            view.setOnClickListener(this.f45148h);
        }

        public void bindData(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d0Var) == null) || d0Var == null) {
                return;
            }
            this.f45145e = d0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(i1.hot_user_rank), d0Var.f24841b)) {
                this.f45143c.setImageResource(e1.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f45143c.getLayoutParams();
                layoutParams.width = m.f(this.f45143c.getContext(), d1.tbds62);
                layoutParams.height = m.f(this.f45143c.getContext(), d1.tbds62);
            } else {
                this.f45143c.startLoad(d0Var.f24841b, 10, false);
            }
            this.f45144d.setText(StringHelper.cutChineseAndEnglishWithSuffix(d0Var.f24842c, 10, ""));
            SkinManager.setViewTextColor(this.f45144d, c1.CAM_X0105);
            if (this.f45146f.contains(d0Var.f24842c)) {
                return;
            }
            d.d(d0Var);
            this.f45146f.add(d0Var.f24842c);
        }
    }

    /* loaded from: classes12.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiServiceViewController a;

        public a(MultiServiceViewController multiServiceViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiServiceViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i2) == null) {
                serviceViewHolder.bindData((d0) this.a.f45139c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.a.f45140d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f45139c.size() : invokeV.intValue;
        }
    }

    public MultiServiceViewController(Context context) {
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
        this.f45139c = new ArrayList();
        this.f45141e = new a(this);
        this.a = context;
        this.f45138b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f45138b.setLayoutManager(linearLayoutManager);
        this.f45138b.setAdapter(this.f45141e);
    }

    @Override // c.a.s0.d1.s2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f24837b)) {
            return;
        }
        this.f45139c = c0Var.f24837b;
        this.f45140d = frsViewData;
        this.f45141e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f45138b;
        recyclerView.setPadding(m.f(recyclerView.getContext(), d1.M_W_X007), 0, 0, 0);
        this.f45138b.setClipToPadding(false);
    }

    @Override // c.a.s0.d1.s2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45138b : (View) invokeV.objValue;
    }

    @Override // c.a.s0.d1.s2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f45141e.notifyDataSetChanged();
        }
    }
}
