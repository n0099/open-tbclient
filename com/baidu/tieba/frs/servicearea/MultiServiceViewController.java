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
import com.repackage.ff6;
import com.repackage.hn6;
import com.repackage.jn6;
import com.repackage.ng;
import com.repackage.pi;
import com.repackage.th8;
import com.repackage.uh8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiServiceViewController implements hn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public RecyclerView b;
    public List<uh8> c;
    public FrsViewData d;
    public RecyclerView.Adapter e;

    /* loaded from: classes3.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public FrameLayout b;
        public TbClipImageView c;
        public TextView d;
        public uh8 e;
        public List<String> f;
        public FrsViewData g;
        public View.OnClickListener h;

        /* loaded from: classes3.dex */
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.e != null && "tiebaclient://accelerator".equals(this.a.e.d)) {
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new ff6(3));
                        CustomMessage customMessage = new CustomMessage(2921662);
                        customMessage.setTag(this.a.g.getFrsFragmentTag());
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                    if (!TextUtils.equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f089c), this.a.e.b) || this.a.g == null || this.a.g.getForum() == null || TextUtils.isEmpty(this.a.g.getForum().getId())) {
                        if (this.a.e != null && this.a.e.f != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.e.g).param("obj_source", "frs_card").param("obj_id", this.a.e.f.b).param("obj_name", this.a.e.f.a).param("obj_param1", this.a.e.f.d.intValue()));
                        }
                        if (this.a.e != null && !"tiebaclient://accelerator".equals(this.a.e.d)) {
                            jn6.b(view2.getContext(), this.a.e);
                        }
                        jn6.c(this.a.e);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(ng.g(this.a.g.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.a.g.getForum().getId());
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServiceViewHolder(View view2, FrsViewData frsViewData) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, frsViewData};
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
            this.f = new ArrayList();
            this.h = new a(this);
            Context context = view2.getContext();
            this.g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view2;
            this.a = linearLayout;
            linearLayout.setGravity(16);
            this.a.setOrientation(0);
            this.b = new FrameLayout(context);
            this.c = new TbClipImageView(context);
            int f = pi.f(context, R.dimen.tbds57);
            this.c.setDrawerType(1);
            this.c.setIsRound(true);
            this.c.setBorderWidth(R.dimen.L_X01);
            this.c.setBorderColor(R.color.CAM_X0401);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setPlaceHolder(1);
            this.b.addView(this.c, new FrameLayout.LayoutParams(f, f));
            this.a.addView(this.b, new LinearLayout.LayoutParams(-2, pi.f(this.c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setTextSize(0, pi.f(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = pi.f(context, R.dimen.tbds10);
            layoutParams.rightMargin = pi.f(context, R.dimen.M_W_X008);
            this.a.addView(this.d, layoutParams);
            view2.setOnClickListener(this.h);
        }

        public void c(uh8 uh8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, uh8Var) == null) || uh8Var == null) {
                return;
            }
            this.e = uh8Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.obfuscated_res_0x7f0f089c), uh8Var.b)) {
                this.c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams.width = pi.f(this.c.getContext(), R.dimen.tbds62);
                layoutParams.height = pi.f(this.c.getContext(), R.dimen.tbds62);
            } else {
                this.c.J(uh8Var.b, 10, false);
            }
            this.d.setText(StringHelper.cutChineseAndEnglishWithSuffix(uh8Var.c, 10, ""));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            if (this.f.contains(uh8Var.c)) {
                return;
            }
            jn6.d(uh8Var);
            this.f.add(uh8Var.c);
        }
    }

    /* loaded from: classes3.dex */
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
                serviceViewHolder.c((uh8) this.a.c.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), this.a.d) : (ServiceViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.c.size() : invokeV.intValue;
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
        this.c = new ArrayList();
        this.e = new a(this);
        this.a = context;
        this.b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.b.setLayoutManager(linearLayoutManager);
        this.b.setAdapter(this.e);
    }

    @Override // com.repackage.hn6
    public void a(th8 th8Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, th8Var, frsViewData) == null) || th8Var == null || ListUtils.isEmpty(th8Var.b)) {
            return;
        }
        this.c = th8Var.b;
        this.d = frsViewData;
        this.e.notifyDataSetChanged();
        RecyclerView recyclerView = this.b;
        recyclerView.setPadding(pi.f(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.b.setClipToPadding(false);
    }

    @Override // com.repackage.hn6
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @Override // com.repackage.hn6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e.notifyDataSetChanged();
        }
    }
}
