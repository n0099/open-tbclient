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
import c.a.d.f.p.n;
import c.a.p0.q1.i.j.j;
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
/* loaded from: classes5.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f33363b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f33364c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Long> f33365d;

    /* loaded from: classes5.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public ObjectAnimator f33366b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f33367c;

        /* renamed from: d  reason: collision with root package name */
        public HeadImageView f33368d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f33369e;

        /* renamed from: f  reason: collision with root package name */
        public TBSpecificationBtn f33370f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f33371g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f33372h;
        public final /* synthetic */ AlaRecommendListAdapter i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlaUserInfoViewHolder(AlaRecommendListAdapter alaRecommendListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, view};
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
            this.a = view.findViewById(R.id.obfuscated_res_0x7f09021d);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0901c0);
            this.f33372h = tbImageView;
            SkinManager.setImageResource(tbImageView, R.drawable.icon_mask_live);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f33372h, "rotation", 0.0f, 359.0f);
            this.f33366b = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.f33366b.setDuration(10000L);
            this.f33366b.setInterpolator(new LinearInterpolator());
            this.f33367c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0901de);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f09021c);
            this.f33368d = headImageView;
            headImageView.setRadius(n.f(alaRecommendListAdapter.a, R.dimen.tbds63));
            this.f33369e = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090221);
            this.f33370f = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f090226);
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            aVar.p(R.color.CAM_X0310);
            aVar.l(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.j(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds120), n.f(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.f33370f.setTextSize(R.dimen.tbds26);
            this.f33370f.setClickState(false);
            this.f33370f.setConfig(aVar);
            this.f33371g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090222);
        }

        public void h(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i == this.i.f33363b) {
                return;
            }
            SkinManager.setViewTextColor(this.f33370f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f33371g, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.f33372h, R.drawable.icon_mask_live);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f33367c, R.drawable.obfuscated_res_0x7f08060b, SvgManager.SvgResourceStateType.NORMAL);
            this.f33370f.k();
            if (i2 == 1) {
                SkinManager.setImageResource(this.f33368d, R.drawable.pic_live_hand_n);
            } else if (i2 == 2) {
                SkinManager.setImageResource(this.f33369e, R.drawable.icon_pure_live_moe22);
                SkinManager.setBackgroundShapeDrawable(this.f33368d, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.CAM_X0203, R.color.CAM_X0203);
            }
            SkinManager.setViewTextColor(this.f33371g, (int) R.color.CAM_X0105);
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f33373b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AlaRecommendListAdapter f33374c;

        public b(AlaRecommendListAdapter alaRecommendListAdapter, j jVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, jVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33374c = alaRecommendListAdapter;
            this.a = jVar;
            this.f33373b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.f33374c;
                j jVar = this.a;
                alaRecommendListAdapter.i(jVar.i, jVar.a);
                StatisticItem statisticItem = new StatisticItem("c13623");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", 0);
                statisticItem.param("tid", this.a.e());
                statisticItem.param("obj_type", this.a.b());
                statisticItem.param(TiebaStatic.Params.STAR_ID, this.a.d());
                statisticItem.param("liveid", this.f33373b);
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

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
        this.f33363b = 3;
        this.a = context;
        this.f33365d = new HashSet<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<j> list = this.f33364c;
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
            List<j> list = this.f33364c;
            if (list == null || list.get(i) == null) {
                return 0;
            }
            return this.f33364c.get(i).getType();
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
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) c.a.d.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, YYLiveUtil.SOURCE_HOME_RECOMMEND_SECOND_FLOOR);
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
        List<j> list;
        j jVar;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, alaUserInfoViewHolder, i) == null) || alaUserInfoViewHolder == null || (list = this.f33364c) == null || list.size() <= i || (jVar = this.f33364c.get(i)) == null) {
            return;
        }
        if (jVar.getType() == 1) {
            alaUserInfoViewHolder.f33370f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f52));
            alaUserInfoViewHolder.f33368d.setImageResource(R.drawable.pic_live_hand_n);
            alaUserInfoViewHolder.f33371g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f55));
            alaUserInfoViewHolder.a.setOnClickListener(new a(this));
        } else {
            if (jVar.getType() == 0) {
                alaUserInfoViewHolder.f33370f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a06));
                alaUserInfoViewHolder.f33368d.setPlaceHolder(1);
                alaUserInfoViewHolder.f33368d.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
                if (!StringUtils.isNull(jVar.c())) {
                    alaUserInfoViewHolder.f33368d.J(jVar.c(), 10, false);
                }
                if (StringHelper.getChineseAndEnglishLength(jVar.f()) <= 8) {
                    alaUserInfoViewHolder.f33371g.setText(jVar.f());
                } else {
                    alaUserInfoViewHolder.f33371g.setText(StringHelper.cutChineseAndEnglishWithSuffix(jVar.f(), 6, StringHelper.STRING_MORE));
                }
                long a2 = jVar.a();
                alaUserInfoViewHolder.a.setOnClickListener(new b(this, jVar, a2));
                if (!this.f33365d.contains(Long.valueOf(a2))) {
                    StatisticItem statisticItem = new StatisticItem("c13622");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", 0);
                    statisticItem.param("tid", jVar.e());
                    statisticItem.param("obj_type", jVar.b());
                    statisticItem.param(TiebaStatic.Params.STAR_ID, jVar.d());
                    statisticItem.param("liveid", a2);
                    statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
                    int i2 = 5;
                    YyExtData yyExtData = jVar.i;
                    if (yyExtData != null) {
                        statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
                        statisticItem.param(TiebaStatic.YYParams.YYSSID, jVar.i.mSsid);
                        statisticItem.param(TiebaStatic.YYParams.YYUID, jVar.i.mYyUid);
                        statisticItem.param("template_id", jVar.i.mTemplateId);
                        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
                        int i3 = jVar.i.isYyGame ? 3 : 2;
                        str = TiebaStatic.YYValues.YY_LIVE;
                        i2 = i3;
                    } else {
                        str = "";
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStatic.log(statisticItem);
                    this.f33365d.add(Long.valueOf(a2));
                }
            } else if (jVar.getType() == 2) {
                alaUserInfoViewHolder.f33370f.setVisibility(8);
                alaUserInfoViewHolder.f33372h.setVisibility(8);
                alaUserInfoViewHolder.f33367c.setVisibility(8);
                alaUserInfoViewHolder.f33371g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029c));
                alaUserInfoViewHolder.f33369e.setVisibility(0);
                alaUserInfoViewHolder.f33369e.setImageResource(R.drawable.icon_pure_live_moe22);
                alaUserInfoViewHolder.a.setOnClickListener(new c(this));
            }
        }
        alaUserInfoViewHolder.h(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) ? new AlaUserInfoViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d010a, (ViewGroup) null)) : (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, alaUserInfoViewHolder) == null) {
            super.onViewAttachedToWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f33366b) == null) {
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
            if (alaUserInfoViewHolder == null || (objectAnimator = alaUserInfoViewHolder.f33366b) == null) {
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
        if (this.f33364c == null) {
            this.f33364c = new ArrayList();
        }
        this.f33364c.clear();
        j jVar = new j();
        jVar.l(1);
        this.f33364c.add(jVar);
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
                jVar2.i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.f33364c.add(jVar2);
            }
        }
        if (this.f33364c.size() > 12) {
            j jVar3 = new j();
            jVar3.l(2);
            this.f33364c.add(jVar3);
        }
    }
}
