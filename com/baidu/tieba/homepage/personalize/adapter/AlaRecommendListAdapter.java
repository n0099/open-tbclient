package com.baidu.tieba.homepage.personalize.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f9;
import com.repackage.ku4;
import com.repackage.oi;
import com.repackage.tz6;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes3.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<tz6> c;
    public HashSet<Long> d;

    /* loaded from: classes3.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ObjectAnimator b;
        public ImageView c;
        public HeadImageView d;
        public TbImageView e;
        public TBSpecificationBtn f;
        public TextView g;
        public TbImageView h;
        public final /* synthetic */ AlaRecommendListAdapter i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlaUserInfoViewHolder(AlaRecommendListAdapter alaRecommendListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, view2};
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
            this.i = alaRecommendListAdapter;
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f090225);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901c8);
            this.h = tbImageView;
            SkinManager.setImageResource(tbImageView, R.drawable.icon_mask_live);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h, "rotation", 0.0f, 359.0f);
            this.b = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.b.setDuration(10000L);
            this.b.setInterpolator(new LinearInterpolator());
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901e6);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090224);
            this.d = headImageView;
            headImageView.setRadius(oi.f(alaRecommendListAdapter.a, R.dimen.tbds63));
            this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090229);
            this.f = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f09022e);
            ku4 ku4Var = new ku4();
            ku4Var.p(R.color.CAM_X0310);
            ku4Var.l(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            ku4Var.j(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120), oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.f.setTextSize(R.dimen.tbds26);
            this.f.setClickState(false);
            this.f.setConfig(ku4Var);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09022a);
        }

        public void h(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i == this.i.b) {
                return;
            }
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.h, R.drawable.icon_mask_live);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f08060a, SvgManager.SvgResourceStateType.NORMAL);
            this.f.k();
            if (i2 == 1) {
                SkinManager.setImageResource(this.d, R.drawable.pic_live_hand_n);
            } else if (i2 == 2) {
                SkinManager.setImageResource(this.e, R.drawable.icon_pure_live_moe22);
                SkinManager.setBackgroundShapeDrawable(this.d, oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.CAM_X0203, R.color.CAM_X0203);
            }
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecommendListAdapter a;

        public a(AlaRecommendListAdapter alaRecommendListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz6 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AlaRecommendListAdapter c;

        public b(AlaRecommendListAdapter alaRecommendListAdapter, tz6 tz6Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, tz6Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = alaRecommendListAdapter;
            this.a = tz6Var;
            this.b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.c;
                tz6 tz6Var = this.a;
                alaRecommendListAdapter.i(tz6Var.i, tz6Var.a);
                StatisticItem statisticItem = new StatisticItem("c13623");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", this.a.e());
                statisticItem.param("obj_type", this.a.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, this.a.d());
                statisticItem.param("liveid", this.b);
                statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
                YyExtData yyExtData = this.a.i;
                if (yyExtData != null) {
                    statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
                    statisticItem.param(TiebaStatic.YYParams.YYSSID, this.a.i.mSsid);
                    statisticItem.param(TiebaStatic.YYParams.YYUID, this.a.i.mYyUid);
                    statisticItem.param("template_id", this.a.i.mTemplateId);
                    statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
                    i = this.a.i.isYyGame ? 3 : 2;
                    str = TiebaStatic.YYValues.YY_LIVE;
                } else {
                    i = 5;
                    str = "";
                }
                statisticItem.param("obj_param1", i);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecommendListAdapter a;

        public c(AlaRecommendListAdapter alaRecommendListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h();
            }
        }
    }

    public AlaRecommendListAdapter(Context context) {
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
        this.b = 3;
        this.a = context;
        this.d = new HashSet<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<tz6> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<tz6> list = this.c;
            if (list == null || list.get(i) == null) {
                return 0;
            }
            return this.c.get(i).getType();
        }
        return invokeI.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ViewHelper.checkUpIsLogin(this.a)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(this.a)));
            StatisticItem statisticItem = new StatisticItem("c13624");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(YyExtData yyExtData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, yyExtData, str) == null) || yyExtData == null) {
            return;
        }
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) f9.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, YYLiveUtil.SOURCE_HOME_RECOMMEND_SECOND_FLOOR);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
            StatisticItem statisticItem = new StatisticItem("c13621");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i) {
        List<tz6> list;
        tz6 tz6Var;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, alaUserInfoViewHolder, i) == null) || alaUserInfoViewHolder == null || (list = this.c) == null || list.size() <= i || (tz6Var = this.c.get(i)) == null) {
            return;
        }
        if (tz6Var.getType() == 1) {
            alaUserInfoViewHolder.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f56));
            alaUserInfoViewHolder.d.setImageResource(R.drawable.pic_live_hand_n);
            alaUserInfoViewHolder.g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f59));
            alaUserInfoViewHolder.a.setOnClickListener(new a(this));
        } else {
            if (tz6Var.getType() == 0) {
                alaUserInfoViewHolder.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a06));
                alaUserInfoViewHolder.d.setPlaceHolder(1);
                alaUserInfoViewHolder.d.setDefaultResource(R.drawable.obfuscated_res_0x7f08120b);
                if (!StringUtils.isNull(tz6Var.c())) {
                    alaUserInfoViewHolder.d.K(tz6Var.c(), 10, false);
                }
                if (StringHelper.getChineseAndEnglishLength(tz6Var.f()) <= 8) {
                    alaUserInfoViewHolder.g.setText(tz6Var.f());
                } else {
                    alaUserInfoViewHolder.g.setText(StringHelper.cutChineseAndEnglishWithSuffix(tz6Var.f(), 6, StringHelper.STRING_MORE));
                }
                long a2 = tz6Var.a();
                alaUserInfoViewHolder.a.setOnClickListener(new b(this, tz6Var, a2));
                if (!this.d.contains(Long.valueOf(a2))) {
                    StatisticItem statisticItem = new StatisticItem("c13622");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", 0);
                    statisticItem.param("tid", tz6Var.e());
                    statisticItem.param("obj_type", tz6Var.b());
                    statisticItem.param(TiebaStatic.Params.STAR_ID, tz6Var.d());
                    statisticItem.param("liveid", a2);
                    statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
                    int i2 = 5;
                    YyExtData yyExtData = tz6Var.i;
                    if (yyExtData != null) {
                        statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
                        statisticItem.param(TiebaStatic.YYParams.YYSSID, tz6Var.i.mSsid);
                        statisticItem.param(TiebaStatic.YYParams.YYUID, tz6Var.i.mYyUid);
                        statisticItem.param("template_id", tz6Var.i.mTemplateId);
                        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
                        int i3 = tz6Var.i.isYyGame ? 3 : 2;
                        str = TiebaStatic.YYValues.YY_LIVE;
                        i2 = i3;
                    } else {
                        str = "";
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStatic.log(statisticItem);
                    this.d.add(Long.valueOf(a2));
                }
            } else if (tz6Var.getType() == 2) {
                alaUserInfoViewHolder.f.setVisibility(8);
                alaUserInfoViewHolder.h.setVisibility(8);
                alaUserInfoViewHolder.c.setVisibility(8);
                alaUserInfoViewHolder.g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029d));
                alaUserInfoViewHolder.e.setVisibility(0);
                alaUserInfoViewHolder.e.setImageResource(R.drawable.icon_pure_live_moe22);
                alaUserInfoViewHolder.a.setOnClickListener(new c(this));
            }
        }
        alaUserInfoViewHolder.h(TbadkCoreApplication.getInst().getSkinType(), tz6Var.getType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) ? new AlaUserInfoViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d010c, (ViewGroup) null)) : (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, alaUserInfoViewHolder) == null) {
            super.onViewAttachedToWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.b) == null) {
                return;
            }
            objectAnimator.start();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaUserInfoViewHolder) == null) {
            super.onViewDetachedFromWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.b) == null) {
                return;
            }
            objectAnimator.cancel();
        }
    }

    public void setData(List<AlaLiveInfo> list) {
        AlaUserInfo alaUserInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.clear();
        tz6 tz6Var = new tz6();
        tz6Var.l(1);
        this.c.add(tz6Var);
        if (list != null && list.size() > 12) {
            list = ListUtils.subList(list, 0, 12);
        }
        for (AlaLiveInfo alaLiveInfo : list) {
            if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && !StringUtils.isNull(alaUserInfo.user_name) && alaLiveInfo.yy_ext != null) {
                tz6 tz6Var2 = new tz6();
                tz6Var2.l(0);
                tz6Var2.i(alaLiveInfo.user_info.portrait);
                tz6Var2.m(alaLiveInfo.user_info.user_name);
                tz6Var2.g(alaLiveInfo.live_id.longValue());
                tz6Var2.k(alaLiveInfo.thread_id.longValue());
                tz6Var2.j(alaLiveInfo.user_info.ala_id.longValue());
                tz6Var2.h(alaLiveInfo.live_type.intValue());
                YyExtData yyExtData = new YyExtData();
                tz6Var2.i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.c.add(tz6Var2);
            }
        }
        if (this.c.size() > 12) {
            tz6 tz6Var3 = new tz6();
            tz6Var3.l(2);
            this.c.add(tz6Var3);
        }
    }
}
