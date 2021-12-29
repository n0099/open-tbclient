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
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.i1;
import c.a.t0.d1.s2.b;
import c.a.t0.d1.s2.d;
import c.a.t0.w3.c0;
import c.a.t0.w3.d0;
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
    public RecyclerView f45325b;

    /* renamed from: c  reason: collision with root package name */
    public List<d0> f45326c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f45327d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f45328e;

    /* loaded from: classes12.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f45329b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f45330c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f45331d;

        /* renamed from: e  reason: collision with root package name */
        public d0 f45332e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f45333f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f45334g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f45335h;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f45336e;

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
                this.f45336e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(i1.hot_user_rank), this.f45336e.f45332e.f25496b) || this.f45336e.f45334g == null || this.f45336e.f45334g.getForum() == null || TextUtils.isEmpty(this.f45336e.f45334g.getForum().getId())) {
                        if (this.f45336e.f45332e != null && this.f45336e.f45332e.f25500f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f45336e.f45332e.f25501g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f45336e.f45332e.f25500f.f25507b).param("obj_name", this.f45336e.f45332e.f25500f.a).param("obj_param1", this.f45336e.f45332e.f25500f.f25509d.intValue()));
                        }
                        d.b(view.getContext(), this.f45336e.f45332e);
                        d.c(this.f45336e.f45332e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.f45336e.f45334g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f45336e.f45334g.getForum().getId());
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
            this.f45333f = new ArrayList();
            this.f45335h = new a(this);
            Context context = view.getContext();
            this.f45334g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.a = linearLayout;
            linearLayout.setGravity(16);
            this.a.setOrientation(0);
            this.f45329b = new FrameLayout(context);
            this.f45330c = new TbClipImageView(context);
            int f2 = n.f(context, d1.tbds57);
            this.f45330c.setDrawerType(1);
            this.f45330c.setIsRound(true);
            this.f45330c.setBorderWidth(d1.L_X01);
            this.f45330c.setBorderColor(c1.CAM_X0401);
            this.f45330c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f45330c.setPlaceHolder(1);
            this.f45329b.addView(this.f45330c, new FrameLayout.LayoutParams(f2, f2));
            this.a.addView(this.f45329b, new LinearLayout.LayoutParams(-2, n.f(this.f45330c.getContext(), d1.tbds62)));
            TextView textView = new TextView(context);
            this.f45331d = textView;
            textView.setTextSize(0, n.f(context, d1.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = n.f(context, d1.tbds10);
            layoutParams.rightMargin = n.f(context, d1.M_W_X008);
            this.a.addView(this.f45331d, layoutParams);
            view.setOnClickListener(this.f45335h);
        }

        public void bindData(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d0Var) == null) || d0Var == null) {
                return;
            }
            this.f45332e = d0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(i1.hot_user_rank), d0Var.f25496b)) {
                this.f45330c.setImageResource(e1.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f45330c.getLayoutParams();
                layoutParams.width = n.f(this.f45330c.getContext(), d1.tbds62);
                layoutParams.height = n.f(this.f45330c.getContext(), d1.tbds62);
            } else {
                this.f45330c.startLoad(d0Var.f25496b, 10, false);
            }
            this.f45331d.setText(StringHelper.cutChineseAndEnglishWithSuffix(d0Var.f25497c, 10, ""));
            SkinManager.setViewTextColor(this.f45331d, c1.CAM_X0105);
            if (this.f45333f.contains(d0Var.f25497c)) {
                return;
            }
            d.d(d0Var);
            this.f45333f.add(d0Var.f25497c);
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
                serviceViewHolder.bindData((d0) this.a.f45326c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.a.f45327d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f45326c.size() : invokeV.intValue;
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
        this.f45326c = new ArrayList();
        this.f45328e = new a(this);
        this.a = context;
        this.f45325b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f45325b.setLayoutManager(linearLayoutManager);
        this.f45325b.setAdapter(this.f45328e);
    }

    @Override // c.a.t0.d1.s2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f25492b)) {
            return;
        }
        this.f45326c = c0Var.f25492b;
        this.f45327d = frsViewData;
        this.f45328e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f45325b;
        recyclerView.setPadding(n.f(recyclerView.getContext(), d1.M_W_X007), 0, 0, 0);
        this.f45325b.setClipToPadding(false);
    }

    @Override // c.a.t0.d1.s2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45325b : (View) invokeV.objValue;
    }

    @Override // c.a.t0.d1.s2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f45328e.notifyDataSetChanged();
        }
    }
}
