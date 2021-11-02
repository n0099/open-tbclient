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
    public final Context f48941a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f48942b;

    /* renamed from: c  reason: collision with root package name */
    public List<d0> f48943c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f48944d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f48945e;

    /* loaded from: classes9.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f48946a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f48947b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f48948c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f48949d;

        /* renamed from: e  reason: collision with root package name */
        public d0 f48950e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f48951f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f48952g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f48953h;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f48954e;

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
                this.f48954e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(h1.hot_user_rank), this.f48954e.f48950e.f20534b) || this.f48954e.f48952g == null || this.f48954e.f48952g.getForum() == null || TextUtils.isEmpty(this.f48954e.f48952g.getForum().getId())) {
                        if (this.f48954e.f48950e != null && this.f48954e.f48950e.f20538f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f48954e.f48950e.f20539g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f48954e.f48950e.f20538f.f20547b).param("obj_name", this.f48954e.f48950e.f20538f.f20546a).param("obj_param1", this.f48954e.f48950e.f20538f.f20549d.intValue()));
                        }
                        d.b(view.getContext(), this.f48954e.f48950e);
                        d.c(this.f48954e.f48950e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(b.a.e.e.m.b.g(this.f48954e.f48952g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f48954e.f48952g.getForum().getId());
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
            this.f48951f = new ArrayList();
            this.f48953h = new a(this);
            Context context = view.getContext();
            this.f48952g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f48946a = linearLayout;
            linearLayout.setGravity(16);
            this.f48946a.setOrientation(0);
            this.f48947b = new FrameLayout(context);
            this.f48948c = new TbClipImageView(context);
            int g2 = l.g(context, c1.tbds57);
            this.f48948c.setDrawerType(1);
            this.f48948c.setIsRound(true);
            this.f48948c.setBorderWidth(c1.L_X01);
            this.f48948c.setBorderColor(b1.CAM_X0401);
            this.f48948c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f48948c.setPlaceHolder(1);
            this.f48947b.addView(this.f48948c, new FrameLayout.LayoutParams(g2, g2));
            this.f48946a.addView(this.f48947b, new LinearLayout.LayoutParams(-2, l.g(this.f48948c.getContext(), c1.tbds62)));
            TextView textView = new TextView(context);
            this.f48949d = textView;
            textView.setTextSize(0, l.g(context, c1.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, c1.tbds10);
            layoutParams.rightMargin = l.g(context, c1.M_W_X008);
            this.f48946a.addView(this.f48949d, layoutParams);
            view.setOnClickListener(this.f48953h);
        }

        public void bindData(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d0Var) == null) || d0Var == null) {
                return;
            }
            this.f48950e = d0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(h1.hot_user_rank), d0Var.f20534b)) {
                this.f48948c.setImageResource(d1.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f48948c.getLayoutParams();
                layoutParams.width = l.g(this.f48948c.getContext(), c1.tbds62);
                layoutParams.height = l.g(this.f48948c.getContext(), c1.tbds62);
            } else {
                this.f48948c.startLoad(d0Var.f20534b, 10, false);
            }
            this.f48949d.setText(StringHelper.cutChineseAndEnglishWithSuffix(d0Var.f20535c, 10, ""));
            SkinManager.setViewTextColor(this.f48949d, b1.CAM_X0105);
            if (this.f48951f.contains(d0Var.f20535c)) {
                return;
            }
            d.d(d0Var);
            this.f48951f.add(d0Var.f20535c);
        }
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiServiceViewController f48955a;

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
            this.f48955a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i2) == null) {
                serviceViewHolder.bindData((d0) this.f48955a.f48943c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.f48955a.f48944d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48955a.f48943c.size() : invokeV.intValue;
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
        this.f48943c = new ArrayList();
        this.f48945e = new a(this);
        this.f48941a = context;
        this.f48942b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f48942b.setLayoutManager(linearLayoutManager);
        this.f48942b.setAdapter(this.f48945e);
    }

    @Override // b.a.r0.x0.r2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f20528b)) {
            return;
        }
        this.f48943c = c0Var.f20528b;
        this.f48944d = frsViewData;
        this.f48945e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f48942b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), c1.M_W_X007), 0, 0, 0);
        this.f48942b.setClipToPadding(false);
    }

    @Override // b.a.r0.x0.r2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48942b : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.r2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f48945e.notifyDataSetChanged();
        }
    }
}
