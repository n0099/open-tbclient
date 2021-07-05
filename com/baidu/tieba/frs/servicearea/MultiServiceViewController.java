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
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.h3.a0;
import d.a.s0.h3.b0;
import d.a.s0.u0.g2.b;
import d.a.s0.u0.g2.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MultiServiceViewController implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f15957a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f15958b;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f15959c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f15960d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f15961e;

    /* loaded from: classes5.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15962a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f15963b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f15964c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15965d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f15966e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f15967f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f15968g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f15969h;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f15970e;

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
                this.f15970e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), this.f15970e.f15966e.f61156b) || this.f15970e.f15968g == null || this.f15970e.f15968g.getForum() == null || TextUtils.isEmpty(this.f15970e.f15968g.getForum().getId())) {
                        if (this.f15970e.f15966e != null && this.f15970e.f15966e.f61160f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f15970e.f15966e.f61161g).param("obj_source", "frs_card").param("obj_id", this.f15970e.f15966e.f61160f.f61165b).param("obj_name", this.f15970e.f15966e.f61160f.f61164a).param("obj_param1", this.f15970e.f15966e.f61160f.f61167d.intValue()));
                        }
                        d.a(view.getContext(), this.f15970e.f15966e);
                        d.b(this.f15970e.f15966e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(this.f15970e.f15968g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f15970e.f15968g.getForum().getId());
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
            this.f15967f = new ArrayList();
            this.f15969h = new a(this);
            Context context = view.getContext();
            this.f15968g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f15962a = linearLayout;
            linearLayout.setGravity(16);
            this.f15962a.setOrientation(0);
            this.f15963b = new FrameLayout(context);
            this.f15964c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f15964c.setDrawerType(1);
            this.f15964c.setIsRound(true);
            this.f15964c.setBorderWidth(R.dimen.L_X01);
            this.f15964c.setBorderColor(R.color.CAM_X0401);
            this.f15964c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f15964c.setPlaceHolder(1);
            this.f15963b.addView(this.f15964c, new FrameLayout.LayoutParams(g2, g2));
            this.f15962a.addView(this.f15963b, new LinearLayout.LayoutParams(-2, l.g(this.f15964c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f15965d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f15962a.addView(this.f15965d, layoutParams);
            view.setOnClickListener(this.f15969h);
        }

        public void c(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b0Var) == null) || b0Var == null) {
                return;
            }
            this.f15966e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f61156b)) {
                this.f15964c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15964c.getLayoutParams();
                layoutParams.width = l.g(this.f15964c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f15964c.getContext(), R.dimen.tbds62);
            } else {
                this.f15964c.M(b0Var.f61156b, 10, false);
            }
            this.f15965d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f61157c, 10, ""));
            SkinManager.setViewTextColor(this.f15965d, R.color.CAM_X0105);
            if (this.f15967f.contains(b0Var.f61157c)) {
                return;
            }
            d.c(b0Var);
            this.f15967f.add(b0Var.f61157c);
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiServiceViewController f15971a;

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
            this.f15971a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i2) == null) {
                serviceViewHolder.c((b0) this.f15971a.f15959c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.f15971a.f15960d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15971a.f15959c.size() : invokeV.intValue;
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
        this.f15959c = new ArrayList();
        this.f15961e = new a(this);
        this.f15957a = context;
        this.f15958b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f15958b.setLayoutManager(linearLayoutManager);
        this.f15958b.setAdapter(this.f15961e);
    }

    @Override // d.a.s0.u0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, a0Var, frsViewData) == null) || a0Var == null || ListUtils.isEmpty(a0Var.f61154b)) {
            return;
        }
        this.f15959c = a0Var.f61154b;
        this.f15960d = frsViewData;
        this.f15961e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f15958b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f15958b.setClipToPadding(false);
    }

    @Override // d.a.s0.u0.g2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15958b : (View) invokeV.objValue;
    }

    @Override // d.a.s0.u0.g2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f15961e.notifyDataSetChanged();
        }
    }
}
