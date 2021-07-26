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
import d.a.d.e.p.l;
import d.a.q0.h3.a0;
import d.a.q0.h3.b0;
import d.a.q0.u0.g2.b;
import d.a.q0.u0.g2.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiServiceViewController implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f16051a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f16052b;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f16053c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f16054d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f16055e;

    /* loaded from: classes4.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16056a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f16057b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f16058c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16059d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f16060e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f16061f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f16062g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f16063h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f16064e;

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
                this.f16064e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), this.f16064e.f16060e.f58487b) || this.f16064e.f16062g == null || this.f16064e.f16062g.getForum() == null || TextUtils.isEmpty(this.f16064e.f16062g.getForum().getId())) {
                        if (this.f16064e.f16060e != null && this.f16064e.f16060e.f58491f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f16064e.f16060e.f58492g).param("obj_source", "frs_card").param("obj_id", this.f16064e.f16060e.f58491f.f58496b).param("obj_name", this.f16064e.f16060e.f58491f.f58495a).param("obj_param1", this.f16064e.f16060e.f58491f.f58498d.intValue()));
                        }
                        d.a(view.getContext(), this.f16064e.f16060e);
                        d.b(this.f16064e.f16060e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.d.e.m.b.f(this.f16064e.f16062g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f16064e.f16062g.getForum().getId());
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
            this.f16061f = new ArrayList();
            this.f16063h = new a(this);
            Context context = view.getContext();
            this.f16062g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f16056a = linearLayout;
            linearLayout.setGravity(16);
            this.f16056a.setOrientation(0);
            this.f16057b = new FrameLayout(context);
            this.f16058c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f16058c.setDrawerType(1);
            this.f16058c.setIsRound(true);
            this.f16058c.setBorderWidth(R.dimen.L_X01);
            this.f16058c.setBorderColor(R.color.CAM_X0401);
            this.f16058c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16058c.setPlaceHolder(1);
            this.f16057b.addView(this.f16058c, new FrameLayout.LayoutParams(g2, g2));
            this.f16056a.addView(this.f16057b, new LinearLayout.LayoutParams(-2, l.g(this.f16058c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f16059d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f16056a.addView(this.f16059d, layoutParams);
            view.setOnClickListener(this.f16063h);
        }

        public void c(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b0Var) == null) || b0Var == null) {
                return;
            }
            this.f16060e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f58487b)) {
                this.f16058c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16058c.getLayoutParams();
                layoutParams.width = l.g(this.f16058c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f16058c.getContext(), R.dimen.tbds62);
            } else {
                this.f16058c.M(b0Var.f58487b, 10, false);
            }
            this.f16059d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f58488c, 10, ""));
            SkinManager.setViewTextColor(this.f16059d, R.color.CAM_X0105);
            if (this.f16061f.contains(b0Var.f58488c)) {
                return;
            }
            d.c(b0Var);
            this.f16061f.add(b0Var.f58488c);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiServiceViewController f16065a;

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
            this.f16065a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i2) == null) {
                serviceViewHolder.c((b0) this.f16065a.f16053c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.f16065a.f16054d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16065a.f16053c.size() : invokeV.intValue;
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
        this.f16053c = new ArrayList();
        this.f16055e = new a(this);
        this.f16051a = context;
        this.f16052b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f16052b.setLayoutManager(linearLayoutManager);
        this.f16052b.setAdapter(this.f16055e);
    }

    @Override // d.a.q0.u0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, a0Var, frsViewData) == null) || a0Var == null || ListUtils.isEmpty(a0Var.f58485b)) {
            return;
        }
        this.f16053c = a0Var.f58485b;
        this.f16054d = frsViewData;
        this.f16055e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f16052b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f16052b.setClipToPadding(false);
    }

    @Override // d.a.q0.u0.g2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16052b : (View) invokeV.objValue;
    }

    @Override // d.a.q0.u0.g2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f16055e.notifyDataSetChanged();
        }
    }
}
