package com.baidu.tieba.frs.servicearea;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.if7;
import com.baidu.tieba.jx9;
import com.baidu.tieba.kx9;
import com.baidu.tieba.l95;
import com.baidu.tieba.nn7;
import com.baidu.tieba.pn7;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tg;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MultiServiceViewController implements nn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public RecyclerView b;
    public List<kx9> c;
    public FrsViewData d;
    public RecyclerView.Adapter e;

    /* loaded from: classes5.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public TbClipImageView b;
        public TextView c;
        public MessageRedDotView d;
        public kx9 e;
        public List<String> f;
        public FrsViewData g;
        public View.OnClickListener h;

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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.e != null && "tiebaclient://accelerator".equals(this.a.e.d)) {
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new if7(3));
                        CustomMessage customMessage = new CustomMessage(2921662);
                        customMessage.setTag(this.a.g.getFrsFragmentTag());
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                    if (this.a.d.getVisibility() == 0) {
                        this.a.d.setVisibility(8);
                        l95.m().w("key_is_click_game_season_red_dot", true);
                    }
                    if (TextUtils.equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0a10), this.a.e.b) && this.a.g != null && this.a.g.getForum() != null && !TextUtils.isEmpty(this.a.g.getForum().getId())) {
                        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                        hotUserRankActivityConfig.setForumId(Long.valueOf(tg.g(this.a.g.getForum().getId(), 0L)));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                        StatisticItem statisticItem = new StatisticItem("c13666");
                        statisticItem.param("fid", this.a.g.getForum().getId());
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    if (this.a.e != null && this.a.e.f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.e.g).param("obj_source", "frs_card").param("obj_id", this.a.e.f.b).param("obj_name", this.a.e.f.a).param("obj_param1", this.a.e.f.d.intValue()));
                    }
                    if (this.a.e != null && !"tiebaclient://accelerator".equals(this.a.e.d)) {
                        pn7.b(view2.getContext(), this.a.e);
                    }
                    pn7.c(this.a.e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @SuppressLint({"ResourceType"})
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
            RelativeLayout relativeLayout = (RelativeLayout) view2;
            this.a = relativeLayout;
            relativeLayout.setGravity(16);
            this.b = new TbClipImageView(context);
            this.d = new MessageRedDotView(context);
            int g = vi.g(context, R.dimen.tbds62);
            this.b.setDrawerType(1);
            this.b.setIsRound(true);
            this.b.setId(R.id.obfuscated_res_0x7f0920b9);
            this.b.setBorderWidth(R.dimen.L_X01);
            this.b.setBorderColor(R.color.CAM_X0401);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b.setPlaceHolder(1);
            this.d.setTextSize(R.dimen.T_X10);
            this.d.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds_42);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds25);
            this.a.addView(this.b, new RelativeLayout.LayoutParams(g, g));
            this.a.addView(this.d, layoutParams);
            TextView textView = new TextView(context);
            this.c = textView;
            textView.setTextSize(0, vi.g(context, R.dimen.T_X08));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = vi.g(context, R.dimen.tbds10);
            layoutParams2.rightMargin = vi.g(context, R.dimen.M_W_X008);
            layoutParams2.addRule(15);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f0920b9);
            this.a.addView(this.c, layoutParams2);
            view2.setOnClickListener(this.h);
        }

        public void d(kx9 kx9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, kx9Var) != null) || kx9Var == null) {
                return;
            }
            this.e = kx9Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.obfuscated_res_0x7f0f0a10), kx9Var.b)) {
                this.b.setImageResource(R.drawable.icon_mask_service_celebrity24);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                layoutParams.width = vi.g(this.b.getContext(), R.dimen.tbds62);
                layoutParams.height = vi.g(this.b.getContext(), R.dimen.tbds62);
            } else {
                this.b.N(kx9Var.b, 10, false);
            }
            if (StringUtils.isNotNull(kx9Var.j)) {
                if (!l95.m().i("key_is_click_game_season_red_dot", false)) {
                    this.d.setVisibility(0);
                    this.d.g(kx9Var.j, false);
                } else {
                    this.d.setVisibility(8);
                }
            } else {
                this.d.setVisibility(8);
            }
            this.c.setText(StringHelper.cutChineseAndEnglishWithSuffix(kx9Var.c, 10, ""));
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            if (!this.f.contains(kx9Var.c)) {
                pn7.d(kx9Var);
                this.f.add(kx9Var.c);
            }
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.c.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, serviceViewHolder, i) == null) {
                serviceViewHolder.d((kx9) this.a.c.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                return new ServiceViewHolder(new RelativeLayout(viewGroup.getContext()), this.a.d);
            }
            return (ServiceViewHolder) invokeLI.objValue;
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

    @Override // com.baidu.tieba.nn7
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.nn7
    public void a(jx9 jx9Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jx9Var, frsViewData) == null) && jx9Var != null && !ListUtils.isEmpty(jx9Var.b)) {
            this.c = jx9Var.b;
            this.d = frsViewData;
            this.e.notifyDataSetChanged();
            RecyclerView recyclerView = this.b;
            recyclerView.setPadding(vi.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
            this.b.setClipChildren(false);
            this.b.setClipToPadding(false);
        }
    }

    @Override // com.baidu.tieba.nn7
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}
