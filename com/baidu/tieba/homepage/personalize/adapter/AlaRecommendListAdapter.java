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
import d.a.d.e.p.l;
import d.a.q0.e1.h.j.j;
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
    public Context f16794a;

    /* renamed from: b  reason: collision with root package name */
    public int f16795b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f16796c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Long> f16797d;

    /* loaded from: classes4.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f16798a;

        /* renamed from: b  reason: collision with root package name */
        public ObjectAnimator f16799b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16800c;

        /* renamed from: d  reason: collision with root package name */
        public HeadImageView f16801d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16802e;

        /* renamed from: f  reason: collision with root package name */
        public TBSpecificationBtn f16803f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16804g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f16805h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16806i;

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
            this.f16806i = alaRecommendListAdapter;
            this.f16798a = view.findViewById(R.id.ala_recommend_container);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ala_animation_background);
            this.f16805h = tbImageView;
            SkinManager.setImageResource(tbImageView, R.drawable.icon_mask_live);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16805h, "rotation", 0.0f, 359.0f);
            this.f16799b = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.f16799b.setDuration(10000L);
            this.f16799b.setInterpolator(new LinearInterpolator());
            this.f16800c = (ImageView) view.findViewById(R.id.ala_gradient_background);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.f16801d = headImageView;
            headImageView.setRadius(l.g(alaRecommendListAdapter.f16794a, R.dimen.tbds63));
            this.f16802e = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.f16803f = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            d.a.p0.s.f0.n.a aVar = new d.a.p0.s.f0.n.a();
            aVar.o(R.color.CAM_X0310);
            aVar.k(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.j(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120), l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.f16803f.setTextSize(R.dimen.tbds26);
            this.f16803f.setClickState(false);
            this.f16803f.setConfig(aVar);
            this.f16804g = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 == this.f16806i.f16795b) {
                return;
            }
            SkinManager.setViewTextColor(this.f16803f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f16804g, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f16805h, R.drawable.icon_mask_live);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f16800c, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
            this.f16803f.k();
            if (i3 == 1) {
                SkinManager.setImageResource(this.f16801d, R.drawable.pic_live_hand_n);
            } else if (i3 == 2) {
                SkinManager.setImageResource(this.f16802e, R.drawable.icon_pure_live_moe22);
                HeadImageView headImageView = this.f16801d;
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds63);
                int i4 = R.color.CAM_X0203;
                SkinManager.setBackgroundShapeDrawable(headImageView, g2, i4, i4);
            }
            SkinManager.setViewTextColor(this.f16804g, R.color.CAM_X0105);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16807e;

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
            this.f16807e = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16807e.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f16809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16810g;

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
            this.f16810g = alaRecommendListAdapter;
            this.f16808e = jVar;
            this.f16809f = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.f16810g;
                j jVar = this.f16808e;
                alaRecommendListAdapter.i(jVar.f56188i, jVar.f56180a);
                StatisticItem statisticItem = new StatisticItem("c13623");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", this.f16808e.e());
                statisticItem.param("obj_type", this.f16808e.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, this.f16808e.d());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.f16809f);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f16811e;

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
            this.f16811e = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16811e.h();
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
        this.f16795b = 3;
        this.f16794a = context;
        this.f16797d = new HashSet<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<j> list = this.f16796c;
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
            List<j> list = this.f16796c;
            if (list == null || list.get(i2) == null) {
                return 0;
            }
            return this.f16796c.get(i2).f();
        }
        return invokeI.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ViewHelper.checkUpIsLogin(this.f16794a)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(this.f16794a)));
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
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) d.a.d.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, YYLiveUtil.SOURCE_HOME_RECOMMEND_SECOND_FLOOR);
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
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, alaUserInfoViewHolder, i2) == null) || alaUserInfoViewHolder == null || (list = this.f16796c) == null || list.size() <= i2 || (jVar = this.f16796c.get(i2)) == null) {
            return;
        }
        if (jVar.f() == 1) {
            alaUserInfoViewHolder.f16803f.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
            alaUserInfoViewHolder.f16801d.setImageResource(R.drawable.pic_live_hand_n);
            alaUserInfoViewHolder.f16804g.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
            alaUserInfoViewHolder.f16798a.setOnClickListener(new a(this));
        } else if (jVar.f() == 0) {
            alaUserInfoViewHolder.f16803f.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
            alaUserInfoViewHolder.f16801d.setPlaceHolder(1);
            alaUserInfoViewHolder.f16801d.setDefaultResource(R.drawable.transparent_bg);
            if (!StringUtils.isNull(jVar.c())) {
                alaUserInfoViewHolder.f16801d.M(jVar.c(), 10, false);
            }
            if (StringHelper.getChineseAndEnglishLength(jVar.g()) <= 8) {
                alaUserInfoViewHolder.f16804g.setText(jVar.g());
            } else {
                alaUserInfoViewHolder.f16804g.setText(StringHelper.cutChineseAndEnglishWithSuffix(jVar.g(), 6, StringHelper.STRING_MORE));
            }
            long a2 = jVar.a();
            alaUserInfoViewHolder.f16798a.setOnClickListener(new b(this, jVar, a2));
            if (!this.f16797d.contains(Long.valueOf(a2))) {
                StatisticItem statisticItem = new StatisticItem("c13622");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", jVar.e());
                statisticItem.param("obj_type", jVar.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, jVar.d());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, a2);
                TiebaStatic.log(statisticItem);
                this.f16797d.add(Long.valueOf(a2));
            }
        } else if (jVar.f() == 2) {
            alaUserInfoViewHolder.f16803f.setVisibility(8);
            alaUserInfoViewHolder.f16805h.setVisibility(8);
            alaUserInfoViewHolder.f16800c.setVisibility(8);
            alaUserInfoViewHolder.f16804g.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
            alaUserInfoViewHolder.f16802e.setVisibility(0);
            alaUserInfoViewHolder.f16802e.setImageResource(R.drawable.icon_pure_live_moe22);
            alaUserInfoViewHolder.f16798a.setOnClickListener(new c(this));
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
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) ? new AlaUserInfoViewHolder(this, LayoutInflater.from(this.f16794a).inflate(R.layout.ala_recommend_item, (ViewGroup) null)) : (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, alaUserInfoViewHolder) == null) {
            super.onViewAttachedToWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f16799b) == null) {
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
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f16799b) == null) {
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
        if (this.f16796c == null) {
            this.f16796c = new ArrayList();
        }
        this.f16796c.clear();
        j jVar = new j();
        jVar.m(1);
        this.f16796c.add(jVar);
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
                jVar2.f56188i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.f16796c.add(jVar2);
            }
        }
        if (this.f16796c.size() > 12) {
            j jVar3 = new j();
            jVar3.m(2);
            this.f16796c.add(jVar3);
        }
    }
}
