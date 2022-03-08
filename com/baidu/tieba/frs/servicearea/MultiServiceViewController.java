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
import c.a.d.f.p.n;
import c.a.r0.d1.k2.b;
import c.a.r0.d1.k2.d;
import c.a.r0.y3.d0;
import c.a.r0.y3.e0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MultiServiceViewController implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f42349b;

    /* renamed from: c  reason: collision with root package name */
    public List<e0> f42350c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f42351d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f42352e;

    /* loaded from: classes5.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f42353b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f42354c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f42355d;

        /* renamed from: e  reason: collision with root package name */
        public e0 f42356e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f42357f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f42358g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f42359h;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f42360e;

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
                this.f42360e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f42360e.f42356e != null && "tiebaclient://accelerator".equals(this.f42360e.f42356e.f24976d)) {
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.r0.d1.g1.b.a(3));
                        CustomMessage customMessage = new CustomMessage(2921662);
                        customMessage.setTag(this.f42360e.f42358g.getFrsFragmentTag());
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                    if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), this.f42360e.f42356e.f24974b) || this.f42360e.f42358g == null || this.f42360e.f42358g.getForum() == null || TextUtils.isEmpty(this.f42360e.f42358g.getForum().getId())) {
                        if (this.f42360e.f42356e != null && this.f42360e.f42356e.f24978f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f42360e.f42356e.f24979g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f42360e.f42356e.f24978f.f24986b).param("obj_name", this.f42360e.f42356e.f24978f.a).param("obj_param1", this.f42360e.f42356e.f24978f.f24988d.intValue()));
                        }
                        if (this.f42360e.f42356e != null && !"tiebaclient://accelerator".equals(this.f42360e.f42356e.f24976d)) {
                            d.b(view.getContext(), this.f42360e.f42356e);
                        }
                        d.c(this.f42360e.f42356e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.f42360e.f42358g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f42360e.f42358g.getForum().getId());
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
            this.f42357f = new ArrayList();
            this.f42359h = new a(this);
            Context context = view.getContext();
            this.f42358g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.a = linearLayout;
            linearLayout.setGravity(16);
            this.a.setOrientation(0);
            this.f42353b = new FrameLayout(context);
            this.f42354c = new TbClipImageView(context);
            int f2 = n.f(context, R.dimen.tbds57);
            this.f42354c.setDrawerType(1);
            this.f42354c.setIsRound(true);
            this.f42354c.setBorderWidth(R.dimen.L_X01);
            this.f42354c.setBorderColor(R.color.CAM_X0401);
            this.f42354c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f42354c.setPlaceHolder(1);
            this.f42353b.addView(this.f42354c, new FrameLayout.LayoutParams(f2, f2));
            this.a.addView(this.f42353b, new LinearLayout.LayoutParams(-2, n.f(this.f42354c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f42355d = textView;
            textView.setTextSize(0, n.f(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = n.f(context, R.dimen.tbds10);
            layoutParams.rightMargin = n.f(context, R.dimen.M_W_X008);
            this.a.addView(this.f42355d, layoutParams);
            view.setOnClickListener(this.f42359h);
        }

        public void bindData(e0 e0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, e0Var) == null) || e0Var == null) {
                return;
            }
            this.f42356e = e0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), e0Var.f24974b)) {
                this.f42354c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f42354c.getLayoutParams();
                layoutParams.width = n.f(this.f42354c.getContext(), R.dimen.tbds62);
                layoutParams.height = n.f(this.f42354c.getContext(), R.dimen.tbds62);
            } else {
                this.f42354c.startLoad(e0Var.f24974b, 10, false);
            }
            this.f42355d.setText(StringHelper.cutChineseAndEnglishWithSuffix(e0Var.f24975c, 10, ""));
            SkinManager.setViewTextColor(this.f42355d, (int) R.color.CAM_X0105);
            if (this.f42357f.contains(e0Var.f24975c)) {
                return;
            }
            d.d(e0Var);
            this.f42357f.add(e0Var.f24975c);
        }
    }

    /* loaded from: classes5.dex */
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
                serviceViewHolder.bindData((e0) this.a.f42350c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.a.f42351d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f42350c.size() : invokeV.intValue;
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
        this.f42350c = new ArrayList();
        this.f42352e = new a(this);
        this.a = context;
        this.f42349b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f42349b.setLayoutManager(linearLayoutManager);
        this.f42349b.setAdapter(this.f42352e);
    }

    @Override // c.a.r0.d1.k2.b
    public void a(d0 d0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d0Var, frsViewData) == null) || d0Var == null || ListUtils.isEmpty(d0Var.f24970b)) {
            return;
        }
        this.f42350c = d0Var.f24970b;
        this.f42351d = frsViewData;
        this.f42352e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f42349b;
        recyclerView.setPadding(n.f(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f42349b.setClipToPadding(false);
    }

    @Override // c.a.r0.d1.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42349b : (View) invokeV.objValue;
    }

    @Override // c.a.r0.d1.k2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f42352e.notifyDataSetChanged();
        }
    }
}
