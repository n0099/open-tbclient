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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.a38;
import com.baidu.tieba.lu7;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tva;
import com.baidu.tieba.uva;
import com.baidu.tieba.y28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MultiServiceViewController implements y28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public RecyclerView b;
    public List<uva> c;
    public FrsViewData d;
    public RecyclerView.Adapter e;

    /* loaded from: classes6.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public TbClipImageView b;
        public TextView c;
        public MessageRedDotView d;
        public uva e;
        public List<String> f;
        public FrsViewData g;
        public View.OnClickListener h;

        /* loaded from: classes6.dex */
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
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new lu7(3));
                        CustomMessage customMessage = new CustomMessage(2921662);
                        customMessage.setTag(this.a.g.getFrsFragmentTag());
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                    if (this.a.d.getVisibility() == 0) {
                        this.a.d.setVisibility(8);
                        SharedPrefHelper.getInstance().putBoolean("key_is_click_game_season_red_dot", true);
                    }
                    if (TextUtils.equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0a54), this.a.e.b) && this.a.g != null && this.a.g.getForum() != null && !TextUtils.isEmpty(this.a.g.getForum().getId())) {
                        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                        hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(this.a.g.getForum().getId(), 0L)));
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
                        a38.b(view2.getContext(), this.a.e);
                    }
                    a38.c(this.a.e);
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
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds62);
            this.b.setDrawerType(1);
            this.b.setIsRound(true);
            this.b.setId(R.id.obfuscated_res_0x7f092273);
            this.b.setBorderWidth(R.dimen.L_X01);
            this.b.setBorderColor(R.color.CAM_X0401);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b.setPlaceHolder(1);
            this.d.setTextSize(R.dimen.T_X10);
            this.d.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds_42);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds25);
            this.a.addView(this.b, new RelativeLayout.LayoutParams(dimens, dimens));
            this.a.addView(this.d, layoutParams);
            TextView textView = new TextView(context);
            this.c = textView;
            textView.setTextSize(0, BdUtilHelper.getDimens(context, R.dimen.T_X08));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = BdUtilHelper.getDimens(context, R.dimen.tbds10);
            layoutParams2.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X008);
            layoutParams2.addRule(15);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f092273);
            this.a.addView(this.c, layoutParams2);
            view2.setOnClickListener(this.h);
        }

        public void d(uva uvaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, uvaVar) != null) || uvaVar == null) {
                return;
            }
            this.e = uvaVar;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.obfuscated_res_0x7f0f0a54), uvaVar.b)) {
                this.b.setImageResource(R.drawable.icon_mask_service_celebrity24);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                layoutParams.width = BdUtilHelper.getDimens(this.b.getContext(), R.dimen.tbds62);
                layoutParams.height = BdUtilHelper.getDimens(this.b.getContext(), R.dimen.tbds62);
            } else {
                this.b.startLoad(uvaVar.b, 10, false);
            }
            if (StringUtils.isNotNull(uvaVar.j)) {
                if (!SharedPrefHelper.getInstance().getBoolean("key_is_click_game_season_red_dot", false)) {
                    this.d.setVisibility(0);
                    this.d.refresh(uvaVar.j, false);
                } else {
                    this.d.setVisibility(8);
                }
            } else {
                this.d.setVisibility(8);
            }
            this.c.setText(StringHelper.cutChineseAndEnglishWithSuffix(uvaVar.c, 10, ""));
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            if (!this.f.contains(uvaVar.c)) {
                a38.d(uvaVar);
                this.f.add(uvaVar.c);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        /* renamed from: l */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, serviceViewHolder, i) == null) {
                serviceViewHolder.d((uva) this.a.c.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n */
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

    @Override // com.baidu.tieba.y28
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.y28
    public void a(tva tvaVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, tvaVar, frsViewData) == null) && tvaVar != null && !ListUtils.isEmpty(tvaVar.b)) {
            this.c = tvaVar.b;
            this.d = frsViewData;
            this.e.notifyDataSetChanged();
            RecyclerView recyclerView = this.b;
            recyclerView.setPadding(BdUtilHelper.getDimens(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
            this.b.setClipChildren(false);
            this.b.setClipToPadding(false);
        }
    }

    @Override // com.baidu.tieba.y28
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}
