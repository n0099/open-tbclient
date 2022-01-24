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
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.e1;
import c.a.t0.e1.i1;
import c.a.t0.e1.t2.b;
import c.a.t0.e1.t2.d;
import c.a.t0.x3.c0;
import c.a.t0.x3.d0;
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
    public RecyclerView f43701b;

    /* renamed from: c  reason: collision with root package name */
    public List<d0> f43702c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f43703d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f43704e;

    /* loaded from: classes12.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f43705b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f43706c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f43707d;

        /* renamed from: e  reason: collision with root package name */
        public d0 f43708e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f43709f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f43710g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f43711h;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f43712e;

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
                this.f43712e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f43712e.f43708e != null && "tiebaclient://accelerator".equals(this.f43712e.f43708e.f25043d)) {
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.t0.e1.q1.b.a(3));
                        CustomMessage customMessage = new CustomMessage(2921662);
                        customMessage.setTag(this.f43712e.f43710g.getFrsFragmentTag());
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                    if (!TextUtils.equals(view.getResources().getString(i1.hot_user_rank), this.f43712e.f43708e.f25041b) || this.f43712e.f43710g == null || this.f43712e.f43710g.getForum() == null || TextUtils.isEmpty(this.f43712e.f43710g.getForum().getId())) {
                        if (this.f43712e.f43708e != null && this.f43712e.f43708e.f25045f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f43712e.f43708e.f25046g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f43712e.f43708e.f25045f.f25052b).param("obj_name", this.f43712e.f43708e.f25045f.a).param("obj_param1", this.f43712e.f43708e.f25045f.f25054d.intValue()));
                        }
                        if (this.f43712e.f43708e != null && !"tiebaclient://accelerator".equals(this.f43712e.f43708e.f25043d)) {
                            d.b(view.getContext(), this.f43712e.f43708e);
                        }
                        d.c(this.f43712e.f43708e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.f43712e.f43710g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f43712e.f43710g.getForum().getId());
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
            this.f43709f = new ArrayList();
            this.f43711h = new a(this);
            Context context = view.getContext();
            this.f43710g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.a = linearLayout;
            linearLayout.setGravity(16);
            this.a.setOrientation(0);
            this.f43705b = new FrameLayout(context);
            this.f43706c = new TbClipImageView(context);
            int f2 = n.f(context, d1.tbds57);
            this.f43706c.setDrawerType(1);
            this.f43706c.setIsRound(true);
            this.f43706c.setBorderWidth(d1.L_X01);
            this.f43706c.setBorderColor(c1.CAM_X0401);
            this.f43706c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f43706c.setPlaceHolder(1);
            this.f43705b.addView(this.f43706c, new FrameLayout.LayoutParams(f2, f2));
            this.a.addView(this.f43705b, new LinearLayout.LayoutParams(-2, n.f(this.f43706c.getContext(), d1.tbds62)));
            TextView textView = new TextView(context);
            this.f43707d = textView;
            textView.setTextSize(0, n.f(context, d1.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = n.f(context, d1.tbds10);
            layoutParams.rightMargin = n.f(context, d1.M_W_X008);
            this.a.addView(this.f43707d, layoutParams);
            view.setOnClickListener(this.f43711h);
        }

        public void bindData(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d0Var) == null) || d0Var == null) {
                return;
            }
            this.f43708e = d0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(i1.hot_user_rank), d0Var.f25041b)) {
                this.f43706c.setImageResource(e1.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f43706c.getLayoutParams();
                layoutParams.width = n.f(this.f43706c.getContext(), d1.tbds62);
                layoutParams.height = n.f(this.f43706c.getContext(), d1.tbds62);
            } else {
                this.f43706c.startLoad(d0Var.f25041b, 10, false);
            }
            this.f43707d.setText(StringHelper.cutChineseAndEnglishWithSuffix(d0Var.f25042c, 10, ""));
            SkinManager.setViewTextColor(this.f43707d, c1.CAM_X0105);
            if (this.f43709f.contains(d0Var.f25042c)) {
                return;
            }
            d.d(d0Var);
            this.f43709f.add(d0Var.f25042c);
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
                serviceViewHolder.bindData((d0) this.a.f43702c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.a.f43703d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f43702c.size() : invokeV.intValue;
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
        this.f43702c = new ArrayList();
        this.f43704e = new a(this);
        this.a = context;
        this.f43701b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f43701b.setLayoutManager(linearLayoutManager);
        this.f43701b.setAdapter(this.f43704e);
    }

    @Override // c.a.t0.e1.t2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f25037b)) {
            return;
        }
        this.f43702c = c0Var.f25037b;
        this.f43703d = frsViewData;
        this.f43704e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f43701b;
        recyclerView.setPadding(n.f(recyclerView.getContext(), d1.M_W_X007), 0, 0, 0);
        this.f43701b.setClipToPadding(false);
    }

    @Override // c.a.t0.e1.t2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43701b : (View) invokeV.objValue;
    }

    @Override // c.a.t0.e1.t2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f43704e.notifyDataSetChanged();
        }
    }
}
