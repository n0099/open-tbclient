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
import c.a.e.e.p.l;
import c.a.p0.i3.a0;
import c.a.p0.i3.b0;
import c.a.p0.v0.g2.b;
import c.a.p0.v0.g2.d;
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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MultiServiceViewController implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f51236a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f51237b;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f51238c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f51239d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f51240e;

    /* loaded from: classes7.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f51241a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f51242b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f51243c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f51244d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f51245e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f51246f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f51247g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f51248h;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f51249e;

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
                this.f51249e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), this.f51249e.f51245e.f19878b) || this.f51249e.f51247g == null || this.f51249e.f51247g.getForum() == null || TextUtils.isEmpty(this.f51249e.f51247g.getForum().getId())) {
                        if (this.f51249e.f51245e != null && this.f51249e.f51245e.f19882f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f51249e.f51245e.f19883g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f51249e.f51245e.f19882f.f19887b).param("obj_name", this.f51249e.f51245e.f19882f.f19886a).param("obj_param1", this.f51249e.f51245e.f19882f.f19889d.intValue()));
                        }
                        d.a(view.getContext(), this.f51249e.f51245e);
                        d.b(this.f51249e.f51245e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.e.e.m.b.f(this.f51249e.f51247g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f51249e.f51247g.getForum().getId());
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
            this.f51246f = new ArrayList();
            this.f51248h = new a(this);
            Context context = view.getContext();
            this.f51247g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f51241a = linearLayout;
            linearLayout.setGravity(16);
            this.f51241a.setOrientation(0);
            this.f51242b = new FrameLayout(context);
            this.f51243c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f51243c.setDrawerType(1);
            this.f51243c.setIsRound(true);
            this.f51243c.setBorderWidth(R.dimen.L_X01);
            this.f51243c.setBorderColor(R.color.CAM_X0401);
            this.f51243c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f51243c.setPlaceHolder(1);
            this.f51242b.addView(this.f51243c, new FrameLayout.LayoutParams(g2, g2));
            this.f51241a.addView(this.f51242b, new LinearLayout.LayoutParams(-2, l.g(this.f51243c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f51244d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f51241a.addView(this.f51244d, layoutParams);
            view.setOnClickListener(this.f51248h);
        }

        public void bindData(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b0Var) == null) || b0Var == null) {
                return;
            }
            this.f51245e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f19878b)) {
                this.f51243c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f51243c.getLayoutParams();
                layoutParams.width = l.g(this.f51243c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f51243c.getContext(), R.dimen.tbds62);
            } else {
                this.f51243c.startLoad(b0Var.f19878b, 10, false);
            }
            this.f51244d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f19879c, 10, ""));
            SkinManager.setViewTextColor(this.f51244d, R.color.CAM_X0105);
            if (this.f51246f.contains(b0Var.f19879c)) {
                return;
            }
            d.c(b0Var);
            this.f51246f.add(b0Var.f19879c);
        }
    }

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiServiceViewController f51250a;

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
            this.f51250a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i2) == null) {
                serviceViewHolder.bindData((b0) this.f51250a.f51238c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.f51250a.f51239d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51250a.f51238c.size() : invokeV.intValue;
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
        this.f51238c = new ArrayList();
        this.f51240e = new a(this);
        this.f51236a = context;
        this.f51237b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f51237b.setLayoutManager(linearLayoutManager);
        this.f51237b.setAdapter(this.f51240e);
    }

    @Override // c.a.p0.v0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, a0Var, frsViewData) == null) || a0Var == null || ListUtils.isEmpty(a0Var.f19876b)) {
            return;
        }
        this.f51238c = a0Var.f19876b;
        this.f51239d = frsViewData;
        this.f51240e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f51237b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f51237b.setClipToPadding(false);
    }

    @Override // c.a.p0.v0.g2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51237b : (View) invokeV.objValue;
    }

    @Override // c.a.p0.v0.g2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f51240e.notifyDataSetChanged();
        }
    }
}
