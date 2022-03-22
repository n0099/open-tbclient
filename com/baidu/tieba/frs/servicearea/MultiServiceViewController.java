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
import c.a.p0.a4.d0;
import c.a.p0.a4.e0;
import c.a.p0.f1.k2.b;
import c.a.p0.f1.k2.d;
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
    public RecyclerView f32818b;

    /* renamed from: c  reason: collision with root package name */
    public List<e0> f32819c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f32820d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f32821e;

    /* loaded from: classes5.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f32822b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f32823c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f32824d;

        /* renamed from: e  reason: collision with root package name */
        public e0 f32825e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f32826f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f32827g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f32828h;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ServiceViewHolder a;

            public a(ServiceViewHolder serviceViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {serviceViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.a.f32825e != null && "tiebaclient://accelerator".equals(this.a.f32825e.f12183d)) {
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.p0.f1.g1.b.a(3));
                        CustomMessage customMessage = new CustomMessage(2921662);
                        customMessage.setTag(this.a.f32827g.getFrsFragmentTag());
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                    if (!TextUtils.equals(view.getResources().getString(R.string.obfuscated_res_0x7f0f0886), this.a.f32825e.f12181b) || this.a.f32827g == null || this.a.f32827g.getForum() == null || TextUtils.isEmpty(this.a.f32827g.getForum().getId())) {
                        if (this.a.f32825e != null && this.a.f32825e.f12185f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.f32825e.f12186g).param("obj_source", "frs_card").param("obj_id", this.a.f32825e.f12185f.f12192b).param("obj_name", this.a.f32825e.f12185f.a).param("obj_param1", this.a.f32825e.f12185f.f12194d.intValue()));
                        }
                        if (this.a.f32825e != null && !"tiebaclient://accelerator".equals(this.a.f32825e.f12183d)) {
                            d.b(view.getContext(), this.a.f32825e);
                        }
                        d.c(this.a.f32825e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.a.f32827g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.a.f32827g.getForum().getId());
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32826f = new ArrayList();
            this.f32828h = new a(this);
            Context context = view.getContext();
            this.f32827g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.a = linearLayout;
            linearLayout.setGravity(16);
            this.a.setOrientation(0);
            this.f32822b = new FrameLayout(context);
            this.f32823c = new TbClipImageView(context);
            int f2 = n.f(context, R.dimen.tbds57);
            this.f32823c.setDrawerType(1);
            this.f32823c.setIsRound(true);
            this.f32823c.setBorderWidth(R.dimen.L_X01);
            this.f32823c.setBorderColor(R.color.CAM_X0401);
            this.f32823c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f32823c.setPlaceHolder(1);
            this.f32822b.addView(this.f32823c, new FrameLayout.LayoutParams(f2, f2));
            this.a.addView(this.f32822b, new LinearLayout.LayoutParams(-2, n.f(this.f32823c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f32824d = textView;
            textView.setTextSize(0, n.f(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = n.f(context, R.dimen.tbds10);
            layoutParams.rightMargin = n.f(context, R.dimen.M_W_X008);
            this.a.addView(this.f32824d, layoutParams);
            view.setOnClickListener(this.f32828h);
        }

        public void c(e0 e0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, e0Var) == null) || e0Var == null) {
                return;
            }
            this.f32825e = e0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.obfuscated_res_0x7f0f0886), e0Var.f12181b)) {
                this.f32823c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f32823c.getLayoutParams();
                layoutParams.width = n.f(this.f32823c.getContext(), R.dimen.tbds62);
                layoutParams.height = n.f(this.f32823c.getContext(), R.dimen.tbds62);
            } else {
                this.f32823c.J(e0Var.f12181b, 10, false);
            }
            this.f32824d.setText(StringHelper.cutChineseAndEnglishWithSuffix(e0Var.f12182c, 10, ""));
            SkinManager.setViewTextColor(this.f32824d, (int) R.color.CAM_X0105);
            if (this.f32826f.contains(e0Var.f12182c)) {
                return;
            }
            d.d(e0Var);
            this.f32826f.add(e0Var.f12182c);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i) == null) {
                serviceViewHolder.c((e0) this.a.f32819c.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.a.f32820d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f32819c.size() : invokeV.intValue;
        }
    }

    public MultiServiceViewController(Context context) {
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
        this.f32819c = new ArrayList();
        this.f32821e = new a(this);
        this.a = context;
        this.f32818b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f32818b.setLayoutManager(linearLayoutManager);
        this.f32818b.setAdapter(this.f32821e);
    }

    @Override // c.a.p0.f1.k2.b
    public void a(d0 d0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d0Var, frsViewData) == null) || d0Var == null || ListUtils.isEmpty(d0Var.f12177b)) {
            return;
        }
        this.f32819c = d0Var.f12177b;
        this.f32820d = frsViewData;
        this.f32821e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f32818b;
        recyclerView.setPadding(n.f(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f32818b.setClipToPadding(false);
    }

    @Override // c.a.p0.f1.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32818b : (View) invokeV.objValue;
    }

    @Override // c.a.p0.f1.k2.b
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f32821e.notifyDataSetChanged();
        }
    }
}
