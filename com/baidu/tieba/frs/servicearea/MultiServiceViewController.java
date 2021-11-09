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
import b.a.e.e.p.l;
import b.a.r0.l3.c0;
import b.a.r0.l3.d0;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.h1;
import b.a.r0.x0.r2.b;
import b.a.r0.x0.r2.d;
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
/* loaded from: classes9.dex */
public class MultiServiceViewController implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f48940a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f48941b;

    /* renamed from: c  reason: collision with root package name */
    public List<d0> f48942c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f48943d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f48944e;

    /* loaded from: classes9.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f48945a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f48946b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f48947c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f48948d;

        /* renamed from: e  reason: collision with root package name */
        public d0 f48949e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f48950f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f48951g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f48952h;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f48953e;

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
                this.f48953e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(h1.hot_user_rank), this.f48953e.f48949e.f20534b) || this.f48953e.f48951g == null || this.f48953e.f48951g.getForum() == null || TextUtils.isEmpty(this.f48953e.f48951g.getForum().getId())) {
                        if (this.f48953e.f48949e != null && this.f48953e.f48949e.f20538f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f48953e.f48949e.f20539g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f48953e.f48949e.f20538f.f20547b).param("obj_name", this.f48953e.f48949e.f20538f.f20546a).param("obj_param1", this.f48953e.f48949e.f20538f.f20549d.intValue()));
                        }
                        d.b(view.getContext(), this.f48953e.f48949e);
                        d.c(this.f48953e.f48949e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(b.a.e.e.m.b.g(this.f48953e.f48951g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f48953e.f48951g.getForum().getId());
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
            this.f48950f = new ArrayList();
            this.f48952h = new a(this);
            Context context = view.getContext();
            this.f48951g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f48945a = linearLayout;
            linearLayout.setGravity(16);
            this.f48945a.setOrientation(0);
            this.f48946b = new FrameLayout(context);
            this.f48947c = new TbClipImageView(context);
            int g2 = l.g(context, c1.tbds57);
            this.f48947c.setDrawerType(1);
            this.f48947c.setIsRound(true);
            this.f48947c.setBorderWidth(c1.L_X01);
            this.f48947c.setBorderColor(b1.CAM_X0401);
            this.f48947c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f48947c.setPlaceHolder(1);
            this.f48946b.addView(this.f48947c, new FrameLayout.LayoutParams(g2, g2));
            this.f48945a.addView(this.f48946b, new LinearLayout.LayoutParams(-2, l.g(this.f48947c.getContext(), c1.tbds62)));
            TextView textView = new TextView(context);
            this.f48948d = textView;
            textView.setTextSize(0, l.g(context, c1.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, c1.tbds10);
            layoutParams.rightMargin = l.g(context, c1.M_W_X008);
            this.f48945a.addView(this.f48948d, layoutParams);
            view.setOnClickListener(this.f48952h);
        }

        public void bindData(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d0Var) == null) || d0Var == null) {
                return;
            }
            this.f48949e = d0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(h1.hot_user_rank), d0Var.f20534b)) {
                this.f48947c.setImageResource(d1.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f48947c.getLayoutParams();
                layoutParams.width = l.g(this.f48947c.getContext(), c1.tbds62);
                layoutParams.height = l.g(this.f48947c.getContext(), c1.tbds62);
            } else {
                this.f48947c.startLoad(d0Var.f20534b, 10, false);
            }
            this.f48948d.setText(StringHelper.cutChineseAndEnglishWithSuffix(d0Var.f20535c, 10, ""));
            SkinManager.setViewTextColor(this.f48948d, b1.CAM_X0105);
            if (this.f48950f.contains(d0Var.f20535c)) {
                return;
            }
            d.d(d0Var);
            this.f48950f.add(d0Var.f20535c);
        }
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiServiceViewController f48954a;

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
            this.f48954a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i2) == null) {
                serviceViewHolder.bindData((d0) this.f48954a.f48942c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.f48954a.f48943d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48954a.f48942c.size() : invokeV.intValue;
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
        this.f48942c = new ArrayList();
        this.f48944e = new a(this);
        this.f48940a = context;
        this.f48941b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f48941b.setLayoutManager(linearLayoutManager);
        this.f48941b.setAdapter(this.f48944e);
    }

    @Override // b.a.r0.x0.r2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f20528b)) {
            return;
        }
        this.f48942c = c0Var.f20528b;
        this.f48943d = frsViewData;
        this.f48944e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f48941b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), c1.M_W_X007), 0, 0, 0);
        this.f48941b.setClipToPadding(false);
    }

    @Override // b.a.r0.x0.r2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48941b : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.r2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f48944e.notifyDataSetChanged();
        }
    }
}
