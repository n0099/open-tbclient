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
import c.a.d.f.p.l;
import c.a.r0.n1.h.j.j;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes10.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f45315b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f45316c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Long> f45317d;

    /* loaded from: classes10.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f45318b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f45319c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f45320d;

        /* renamed from: e  reason: collision with root package name */
        public TBSpecificationBtn f45321e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f45322f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f45323g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f45324h;
        public ObjectAnimator rotateAnimator;

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
            this.f45324h = alaRecommendListAdapter;
            this.a = view.findViewById(R.id.ala_recommend_container);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ala_animation_background);
            this.f45323g = tbImageView;
            SkinManager.setImageResource(tbImageView, R.drawable.icon_mask_live);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f45323g, "rotation", 0.0f, 359.0f);
            this.rotateAnimator = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.rotateAnimator.setDuration(10000L);
            this.rotateAnimator.setInterpolator(new LinearInterpolator());
            this.f45318b = (ImageView) view.findViewById(R.id.ala_gradient_background);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.f45319c = headImageView;
            headImageView.setRadius(l.f(alaRecommendListAdapter.a, R.dimen.tbds63));
            this.f45320d = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.f45321e = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            c.a.q0.s.g0.n.a aVar = new c.a.q0.s.g0.n.a();
            aVar.p(R.color.CAM_X0310);
            aVar.l(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.j(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds120), l.f(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.f45321e.setTextSize(R.dimen.tbds26);
            this.f45321e.setClickState(false);
            this.f45321e.setConfig(aVar);
            this.f45322f = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void onChangeSkinType(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 == this.f45324h.f45315b) {
                return;
            }
            SkinManager.setViewTextColor(this.f45321e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f45322f, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f45323g, R.drawable.icon_mask_live);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f45318b, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
            this.f45321e.changeSkinType();
            if (i3 == 1) {
                SkinManager.setImageResource(this.f45319c, R.drawable.pic_live_hand_n);
            } else if (i3 == 2) {
                SkinManager.setImageResource(this.f45320d, R.drawable.icon_pure_live_moe22);
                HeadImageView headImageView = this.f45319c;
                int f2 = l.f(TbadkCoreApplication.getInst(), R.dimen.tbds63);
                int i4 = R.color.CAM_X0203;
                SkinManager.setBackgroundShapeDrawable(headImageView, f2, i4, i4);
            }
            SkinManager.setViewTextColor(this.f45322f, R.color.CAM_X0105);
        }
    }

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f45325e;

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
            this.f45325e = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45325e.f();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f45326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f45327f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f45328g;

        public b(AlaRecommendListAdapter alaRecommendListAdapter, j jVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, jVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45328g = alaRecommendListAdapter;
            this.f45326e = jVar;
            this.f45327f = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.f45328g;
                j jVar = this.f45326e;
                alaRecommendListAdapter.jumpToLiveRoom(jVar.f20555i, jVar.a);
                StatisticItem statisticItem = new StatisticItem("c13623");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", this.f45326e.e());
                statisticItem.param("obj_type", this.f45326e.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, this.f45326e.d());
                statisticItem.param("liveid", this.f45327f);
                statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
                YyExtData yyExtData = this.f45326e.f20555i;
                if (yyExtData != null) {
                    statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
                    statisticItem.param(TiebaStatic.YYParams.YYSSID, this.f45326e.f20555i.mSsid);
                    statisticItem.param(TiebaStatic.YYParams.YYUID, this.f45326e.f20555i.mYyUid);
                    statisticItem.param("template_id", this.f45326e.f20555i.mTemplateId);
                    statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
                    i2 = this.f45326e.f20555i.isYyGame ? 3 : 2;
                    str = TiebaStatic.YYValues.YY_LIVE;
                } else {
                    i2 = 5;
                    str = "";
                }
                statisticItem.param("obj_param1", i2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f45329e;

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
            this.f45329e = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45329e.e();
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
        this.f45315b = 3;
        this.a = context;
        this.f45317d = new HashSet<>();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ViewHelper.checkUpIsLogin(this.a)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(this.a)));
            StatisticItem statisticItem = new StatisticItem("c13624");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
            StatisticItem statisticItem = new StatisticItem("c13621");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<j> list = this.f45316c;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            List<j> list = this.f45316c;
            if (list == null || list.get(i2) == null) {
                return 0;
            }
            return this.f45316c.get(i2).getType();
        }
        return invokeI.intValue;
    }

    public void jumpToLiveRoom(YyExtData yyExtData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, yyExtData, str) == null) || yyExtData == null) {
            return;
        }
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) c.a.d.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, YYLiveUtil.SOURCE_HOME_RECOMMEND_SECOND_FLOOR);
    }

    public void setData(List<AlaLiveInfo> list) {
        AlaUserInfo alaUserInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f45316c == null) {
            this.f45316c = new ArrayList();
        }
        this.f45316c.clear();
        j jVar = new j();
        jVar.l(1);
        this.f45316c.add(jVar);
        if (list != null && list.size() > 12) {
            list = ListUtils.subList(list, 0, 12);
        }
        for (AlaLiveInfo alaLiveInfo : list) {
            if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && !StringUtils.isNull(alaUserInfo.user_name) && alaLiveInfo.yy_ext != null) {
                j jVar2 = new j();
                jVar2.l(0);
                jVar2.i(alaLiveInfo.user_info.portrait);
                jVar2.m(alaLiveInfo.user_info.user_name);
                jVar2.g(alaLiveInfo.live_id.longValue());
                jVar2.k(alaLiveInfo.thread_id.longValue());
                jVar2.j(alaLiveInfo.user_info.ala_id.longValue());
                jVar2.h(alaLiveInfo.live_type.intValue());
                YyExtData yyExtData = new YyExtData();
                jVar2.f20555i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.f45316c.add(jVar2);
            }
        }
        if (this.f45316c.size() > 12) {
            j jVar3 = new j();
            jVar3.l(2);
            this.f45316c.add(jVar3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i2) {
        List<j> list;
        j jVar;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, alaUserInfoViewHolder, i2) == null) || alaUserInfoViewHolder == null || (list = this.f45316c) == null || list.size() <= i2 || (jVar = this.f45316c.get(i2)) == null) {
            return;
        }
        if (jVar.getType() == 1) {
            alaUserInfoViewHolder.f45321e.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
            alaUserInfoViewHolder.f45319c.setImageResource(R.drawable.pic_live_hand_n);
            alaUserInfoViewHolder.f45322f.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
            alaUserInfoViewHolder.a.setOnClickListener(new a(this));
        } else {
            if (jVar.getType() == 0) {
                alaUserInfoViewHolder.f45321e.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                alaUserInfoViewHolder.f45319c.setPlaceHolder(1);
                alaUserInfoViewHolder.f45319c.setDefaultResource(R.drawable.transparent_bg);
                if (!StringUtils.isNull(jVar.c())) {
                    alaUserInfoViewHolder.f45319c.startLoad(jVar.c(), 10, false);
                }
                if (StringHelper.getChineseAndEnglishLength(jVar.f()) <= 8) {
                    alaUserInfoViewHolder.f45322f.setText(jVar.f());
                } else {
                    alaUserInfoViewHolder.f45322f.setText(StringHelper.cutChineseAndEnglishWithSuffix(jVar.f(), 6, "..."));
                }
                long a2 = jVar.a();
                alaUserInfoViewHolder.a.setOnClickListener(new b(this, jVar, a2));
                if (!this.f45317d.contains(Long.valueOf(a2))) {
                    StatisticItem statisticItem = new StatisticItem("c13622");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", 0);
                    statisticItem.param("tid", jVar.e());
                    statisticItem.param("obj_type", jVar.b());
                    statisticItem.param(TiebaStatic.Params.STAR_ID, jVar.d());
                    statisticItem.param("liveid", a2);
                    statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
                    int i3 = 5;
                    YyExtData yyExtData = jVar.f20555i;
                    if (yyExtData != null) {
                        statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
                        statisticItem.param(TiebaStatic.YYParams.YYSSID, jVar.f20555i.mSsid);
                        statisticItem.param(TiebaStatic.YYParams.YYUID, jVar.f20555i.mYyUid);
                        statisticItem.param("template_id", jVar.f20555i.mTemplateId);
                        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
                        int i4 = jVar.f20555i.isYyGame ? 3 : 2;
                        str = TiebaStatic.YYValues.YY_LIVE;
                        i3 = i4;
                    } else {
                        str = "";
                    }
                    statisticItem.param("obj_param1", i3);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStatic.log(statisticItem);
                    this.f45317d.add(Long.valueOf(a2));
                }
            } else if (jVar.getType() == 2) {
                alaUserInfoViewHolder.f45321e.setVisibility(8);
                alaUserInfoViewHolder.f45323g.setVisibility(8);
                alaUserInfoViewHolder.f45318b.setVisibility(8);
                alaUserInfoViewHolder.f45322f.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                alaUserInfoViewHolder.f45320d.setVisibility(0);
                alaUserInfoViewHolder.f45320d.setImageResource(R.drawable.icon_pure_live_moe22);
                alaUserInfoViewHolder.a.setOnClickListener(new c(this));
            }
        }
        alaUserInfoViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) ? new AlaUserInfoViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.ala_recommend_item, (ViewGroup) null)) : (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, alaUserInfoViewHolder) == null) {
            super.onViewAttachedToWindow((AlaRecommendListAdapter) alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.rotateAnimator) == null) {
                return;
            }
            objectAnimator.start();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, alaUserInfoViewHolder) == null) {
            super.onViewDetachedFromWindow((AlaRecommendListAdapter) alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.rotateAnimator) == null) {
                return;
            }
            objectAnimator.cancel();
        }
    }
}
