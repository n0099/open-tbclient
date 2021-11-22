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
import b.a.e.f.p.l;
import b.a.r0.m3.c0;
import b.a.r0.m3.d0;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.i1;
import b.a.r0.x0.s2.b;
import b.a.r0.x0.s2.d;
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
    public final Context f49804a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f49805b;

    /* renamed from: c  reason: collision with root package name */
    public List<d0> f49806c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f49807d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f49808e;

    /* loaded from: classes9.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f49809a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f49810b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f49811c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f49812d;

        /* renamed from: e  reason: collision with root package name */
        public d0 f49813e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f49814f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f49815g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f49816h;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ServiceViewHolder f49817e;

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
                this.f49817e = serviceViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.equals(view.getResources().getString(i1.hot_user_rank), this.f49817e.f49813e.f22384b) || this.f49817e.f49815g == null || this.f49817e.f49815g.getForum() == null || TextUtils.isEmpty(this.f49817e.f49815g.getForum().getId())) {
                        if (this.f49817e.f49813e != null && this.f49817e.f49813e.f22388f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f49817e.f49813e.f22389g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f49817e.f49813e.f22388f.f22397b).param("obj_name", this.f49817e.f49813e.f22388f.f22396a).param("obj_param1", this.f49817e.f49813e.f22388f.f22399d.intValue()));
                        }
                        d.b(view.getContext(), this.f49817e.f49813e);
                        d.c(this.f49817e.f49813e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(b.a.e.f.m.b.g(this.f49817e.f49815g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.f49817e.f49815g.getForum().getId());
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
            this.f49814f = new ArrayList();
            this.f49816h = new a(this);
            Context context = view.getContext();
            this.f49815g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f49809a = linearLayout;
            linearLayout.setGravity(16);
            this.f49809a.setOrientation(0);
            this.f49810b = new FrameLayout(context);
            this.f49811c = new TbClipImageView(context);
            int g2 = l.g(context, d1.tbds57);
            this.f49811c.setDrawerType(1);
            this.f49811c.setIsRound(true);
            this.f49811c.setBorderWidth(d1.L_X01);
            this.f49811c.setBorderColor(c1.CAM_X0401);
            this.f49811c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f49811c.setPlaceHolder(1);
            this.f49810b.addView(this.f49811c, new FrameLayout.LayoutParams(g2, g2));
            this.f49809a.addView(this.f49810b, new LinearLayout.LayoutParams(-2, l.g(this.f49811c.getContext(), d1.tbds62)));
            TextView textView = new TextView(context);
            this.f49812d = textView;
            textView.setTextSize(0, l.g(context, d1.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, d1.tbds10);
            layoutParams.rightMargin = l.g(context, d1.M_W_X008);
            this.f49809a.addView(this.f49812d, layoutParams);
            view.setOnClickListener(this.f49816h);
        }

        public void bindData(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d0Var) == null) || d0Var == null) {
                return;
            }
            this.f49813e = d0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(i1.hot_user_rank), d0Var.f22384b)) {
                this.f49811c.setImageResource(e1.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f49811c.getLayoutParams();
                layoutParams.width = l.g(this.f49811c.getContext(), d1.tbds62);
                layoutParams.height = l.g(this.f49811c.getContext(), d1.tbds62);
            } else {
                this.f49811c.startLoad(d0Var.f22384b, 10, false);
            }
            this.f49812d.setText(StringHelper.cutChineseAndEnglishWithSuffix(d0Var.f22385c, 10, ""));
            SkinManager.setViewTextColor(this.f49812d, c1.CAM_X0105);
            if (this.f49814f.contains(d0Var.f22385c)) {
                return;
            }
            d.d(d0Var);
            this.f49814f.add(d0Var.f22385c);
        }
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiServiceViewController f49818a;

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
            this.f49818a = multiServiceViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, serviceViewHolder, i2) == null) {
                serviceViewHolder.bindData((d0) this.f49818a.f49806c.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.f49818a.f49807d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49818a.f49806c.size() : invokeV.intValue;
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
        this.f49806c = new ArrayList();
        this.f49808e = new a(this);
        this.f49804a = context;
        this.f49805b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f49805b.setLayoutManager(linearLayoutManager);
        this.f49805b.setAdapter(this.f49808e);
    }

    @Override // b.a.r0.x0.s2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f22378b)) {
            return;
        }
        this.f49806c = c0Var.f22378b;
        this.f49807d = frsViewData;
        this.f49808e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f49805b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), d1.M_W_X007), 0, 0, 0);
        this.f49805b.setClipToPadding(false);
    }

    @Override // b.a.r0.x0.s2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49805b : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.s2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f49808e.notifyDataSetChanged();
        }
    }
}
