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
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
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
import d.a.c.e.p.l;
import d.a.p0.e1.h.j.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes4.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f16738a;

    /* renamed from: b  reason: collision with root package name */
    public int f16739b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f16740c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Long> f16741d;

    /* loaded from: classes4.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f16742a;

        /* renamed from: b  reason: collision with root package name */
        public ObjectAnimator f16743b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16744c;

        /* renamed from: d  reason: collision with root package name */
        public HeadImageView f16745d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16746e;

        /* renamed from: f  reason: collision with root package name */
        public TBSpecificationBtn f16747f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16748g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f16749h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16750i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlaUserInfoViewHolder(AlaRecommendListAdapter alaRecommendListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, view};
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
            this.f16750i = alaRecommendListAdapter;
            this.f16742a = view.findViewById(R.id.ala_recommend_container);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ala_animation_background);
            this.f16749h = tbImageView;
            SkinManager.setImageResource(tbImageView, R.drawable.icon_mask_live);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16749h, "rotation", 0.0f, 359.0f);
            this.f16743b = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.f16743b.setDuration(10000L);
            this.f16743b.setInterpolator(new LinearInterpolator());
            this.f16744c = (ImageView) view.findViewById(R.id.ala_gradient_background);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.f16745d = headImageView;
            headImageView.setRadius(l.g(alaRecommendListAdapter.f16738a, R.dimen.tbds63));
            this.f16746e = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.f16747f = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            d.a.o0.r.f0.n.a aVar = new d.a.o0.r.f0.n.a();
            aVar.o(R.color.CAM_X0310);
            aVar.k(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.j(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120), l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.f16747f.setTextSize(R.dimen.tbds26);
            this.f16747f.setClickState(false);
            this.f16747f.setConfig(aVar);
            this.f16748g = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 == this.f16750i.f16739b) {
                return;
            }
            SkinManager.setViewTextColor(this.f16747f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f16748g, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f16749h, R.drawable.icon_mask_live);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f16744c, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
            this.f16747f.k();
            if (i3 == 1) {
                SkinManager.setImageResource(this.f16745d, R.drawable.pic_live_hand_n);
            } else if (i3 == 2) {
                SkinManager.setImageResource(this.f16746e, R.drawable.icon_pure_live_moe22);
                HeadImageView headImageView = this.f16745d;
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds63);
                int i4 = R.color.CAM_X0203;
                SkinManager.setBackgroundShapeDrawable(headImageView, g2, i4, i4);
            }
            SkinManager.setViewTextColor(this.f16748g, R.color.CAM_X0105);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16751e;

        public a(AlaRecommendListAdapter alaRecommendListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16751e = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16751e.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f16753f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16754g;

        public b(AlaRecommendListAdapter alaRecommendListAdapter, j jVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, jVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16754g = alaRecommendListAdapter;
            this.f16752e = jVar;
            this.f16753f = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.f16754g;
                j jVar = this.f16752e;
                alaRecommendListAdapter.i(jVar.f55644i, jVar.f55636a);
                StatisticItem statisticItem = new StatisticItem("c13623");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", this.f16752e.e());
                statisticItem.param("obj_type", this.f16752e.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, this.f16752e.d());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.f16753f);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16755e;

        public c(AlaRecommendListAdapter alaRecommendListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16755e = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16755e.h();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16739b = 3;
        this.f16738a = context;
        this.f16741d = new HashSet<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<j> list = this.f16740c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            List<j> list = this.f16740c;
            if (list == null || list.get(i2) == null) {
                return 0;
            }
            return this.f16740c.get(i2).f();
        }
        return invokeI.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ViewHelper.checkUpIsLogin(this.f16738a)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(this.f16738a)));
            StatisticItem statisticItem = new StatisticItem("c13624");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(YyExtData yyExtData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, yyExtData, str) == null) || yyExtData == null) {
            return;
        }
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) d.a.c.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, YYLiveUtil.SOURCE_HOME_RECOMMEND_SECOND_FLOOR);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
            StatisticItem statisticItem = new StatisticItem("c13621");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i2) {
        List<j> list;
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, alaUserInfoViewHolder, i2) == null) || alaUserInfoViewHolder == null || (list = this.f16740c) == null || list.size() <= i2 || (jVar = this.f16740c.get(i2)) == null) {
            return;
        }
        if (jVar.f() == 1) {
            alaUserInfoViewHolder.f16747f.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
            alaUserInfoViewHolder.f16745d.setImageResource(R.drawable.pic_live_hand_n);
            alaUserInfoViewHolder.f16748g.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
            alaUserInfoViewHolder.f16742a.setOnClickListener(new a(this));
        } else if (jVar.f() == 0) {
            alaUserInfoViewHolder.f16747f.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
            alaUserInfoViewHolder.f16745d.setPlaceHolder(1);
            alaUserInfoViewHolder.f16745d.setDefaultResource(R.drawable.transparent_bg);
            if (!StringUtils.isNull(jVar.c())) {
                alaUserInfoViewHolder.f16745d.M(jVar.c(), 10, false);
            }
            if (StringHelper.getChineseAndEnglishLength(jVar.g()) <= 8) {
                alaUserInfoViewHolder.f16748g.setText(jVar.g());
            } else {
                alaUserInfoViewHolder.f16748g.setText(StringHelper.cutChineseAndEnglishWithSuffix(jVar.g(), 6, StringHelper.STRING_MORE));
            }
            long a2 = jVar.a();
            alaUserInfoViewHolder.f16742a.setOnClickListener(new b(this, jVar, a2));
            if (!this.f16741d.contains(Long.valueOf(a2))) {
                StatisticItem statisticItem = new StatisticItem("c13622");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", jVar.e());
                statisticItem.param("obj_type", jVar.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, jVar.d());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, a2);
                TiebaStatic.log(statisticItem);
                this.f16741d.add(Long.valueOf(a2));
            }
        } else if (jVar.f() == 2) {
            alaUserInfoViewHolder.f16747f.setVisibility(8);
            alaUserInfoViewHolder.f16749h.setVisibility(8);
            alaUserInfoViewHolder.f16744c.setVisibility(8);
            alaUserInfoViewHolder.f16748g.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
            alaUserInfoViewHolder.f16746e.setVisibility(0);
            alaUserInfoViewHolder.f16746e.setImageResource(R.drawable.icon_pure_live_moe22);
            alaUserInfoViewHolder.f16742a.setOnClickListener(new c(this));
        }
        alaUserInfoViewHolder.h(TbadkCoreApplication.getInst().getSkinType(), jVar.f());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) ? new AlaUserInfoViewHolder(this, LayoutInflater.from(this.f16738a).inflate(R.layout.ala_recommend_item, (ViewGroup) null)) : (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, alaUserInfoViewHolder) == null) {
            super.onViewAttachedToWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f16743b) == null) {
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
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f16743b) == null) {
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
        if (this.f16740c == null) {
            this.f16740c = new ArrayList();
        }
        this.f16740c.clear();
        j jVar = new j();
        jVar.m(1);
        this.f16740c.add(jVar);
        if (list != null && list.size() > 12) {
            list = ListUtils.subList(list, 0, 12);
        }
        for (AlaLiveInfo alaLiveInfo : list) {
            if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && !StringUtils.isNull(alaUserInfo.user_name) && alaLiveInfo.yy_ext != null) {
                j jVar2 = new j();
                jVar2.m(0);
                jVar2.j(alaLiveInfo.user_info.portrait);
                jVar2.n(alaLiveInfo.user_info.user_name);
                jVar2.h(alaLiveInfo.live_id.longValue());
                jVar2.l(alaLiveInfo.thread_id.longValue());
                jVar2.k(alaLiveInfo.user_info.ala_id.longValue());
                jVar2.i(alaLiveInfo.live_type.intValue());
                YyExtData yyExtData = new YyExtData();
                jVar2.f55644i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.f16740c.add(jVar2);
            }
        }
        if (this.f16740c.size() > 12) {
            j jVar3 = new j();
            jVar3.m(2);
            this.f16740c.add(jVar3);
        }
    }
}
