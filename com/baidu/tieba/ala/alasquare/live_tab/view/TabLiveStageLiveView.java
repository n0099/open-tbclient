package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.q0.d1.m0;
import c.a.r0.a0.f.c.c;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.ala.utils.AlaUtilHelper;
import com.baidu.ala.view.AlaRoundRelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_ALA_LIVE_OFFICIAL_RECOMMEND = 102;
    public static final int TYPE_ALA_LIVE_STAGE = 101;
    public static final float p;
    public static final float[] q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f42829e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f42830f;

    /* renamed from: g  reason: collision with root package name */
    public View f42831g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42832h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42833i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42834j;

    /* renamed from: k  reason: collision with root package name */
    public View f42835k;
    public TabLiveStageLiveZanLottieView l;
    public int m;
    public SdkLiveInfoData n;
    public int[] o;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabLiveStageLiveView f42836e;

        public a(TabLiveStageLiveView tabLiveStageLiveView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLiveStageLiveView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42836e = tabLiveStageLiveView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!c.d(this.f42836e.n)) {
                    c.h(this.f42836e.getContext(), this.f42836e.n);
                } else if (j.a(this.f42836e.getContext()) instanceof TbPageContext) {
                    int i2 = this.f42836e.m;
                    String str = YYLiveUtil.SOURCE_HOME_LIVE_TAB_STAGE;
                    if (i2 != 101 && this.f42836e.m == 102) {
                        str = YYLiveUtil.SOURCE_HOME_LIVE_TAB_RECOMMEND;
                    }
                    c.j((TbPageContext) j.a(this.f42836e.getContext()), this.f42836e.n, str);
                }
                int i3 = this.f42836e.m;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                if (i3 != 101) {
                    if (this.f42836e.m == 102) {
                        StatisticItem statisticItem = new StatisticItem("c13559");
                        if (this.f42836e.n.liveInfo != null) {
                            int a = c.a(this.f42836e.n.liveInfo);
                            if (this.f42836e.n.liveInfo.yyExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, c.k(this.f42836e.n.liveInfo.yyExt, this.f42836e.n.roomId));
                            } else {
                                str2 = "";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                        }
                        statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                        statisticItem.param("nid", this.f42836e.n.nid);
                        statisticItem.param(TiebaStatic.Params.LOGID, this.f42836e.n.logid);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13556");
                if (this.f42836e.n.liveInfo != null) {
                    int a2 = c.a(this.f42836e.n.liveInfo);
                    if (this.f42836e.n.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem2, c.k(this.f42836e.n.liveInfo.yyExt, this.f42836e.n.roomId));
                    } else {
                        str2 = "";
                    }
                    statisticItem2.param("obj_param1", a2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                }
                statisticItem2.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                statisticItem2.param("nid", this.f42836e.n.nid);
                statisticItem2.param(TiebaStatic.Params.LOGID, this.f42836e.n.logid);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(884666765, "Lcom/baidu/tieba/ala/alasquare/live_tab/view/TabLiveStageLiveView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(884666765, "Lcom/baidu/tieba/ala/alasquare/live_tab/view/TabLiveStageLiveView;");
                return;
            }
        }
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        p = dimension;
        q = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLiveStageLiveView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = 101;
        this.o = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.l.setAnimation("zan_lottie_anim.json");
                this.l.setImageAssetsFolder("images/");
                this.l.loop(true);
                this.l.playAnimation();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
            float f2 = p;
            setRoundLayoutRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
            TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
            this.l = tabLiveStageLiveZanLottieView;
            tabLiveStageLiveZanLottieView.setForbidAutoUpdateState(true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.cover);
            this.f42829e = tbImageView;
            tbImageView.setBackgroundColor(0);
            this.f42829e.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
            this.f42829e.setConrers(15);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.head_img);
            this.f42830f = headImageView;
            headImageView.setAutoChangeStyle(false);
            this.f42830f.setClickable(true);
            this.f42830f.setIsRound(true);
            this.f42830f.setBorderWidth(l.f(getContext(), R.dimen.tbds1));
            this.f42831g = findViewById(R.id.head_mask_view);
            this.f42832h = (TextView) findViewById(R.id.title);
            this.f42833i = (TextView) findViewById(R.id.user_name);
            this.f42834j = (TextView) findViewById(R.id.audience_count);
            this.f42835k = findViewById(R.id.bottom_gradient_bg);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.o);
            gradientDrawable.setCornerRadii(q);
            this.f42835k.setBackgroundDrawable(gradientDrawable);
            setOnClickListener(new a(this));
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = this.l;
            if (tabLiveStageLiveZanLottieView == null || tabLiveStageLiveZanLottieView.isAnimating()) {
                return;
            }
            this.l.playAnimation();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.f42832h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f42833i, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f42834j, R.color.CAM_X0101);
            Drawable drawable = SkinManager.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f42834j.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f42834j.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = this.l;
            if (tabLiveStageLiveZanLottieView != null && tabLiveStageLiveZanLottieView.isAnimating()) {
                this.l.pauseAnimation();
            }
            super.onDetachedFromWindow();
        }
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sdkLiveInfoData, i2) == null) {
            if (sdkLiveInfoData != null && sdkLiveInfoData.liveInfo != null) {
                this.n = sdkLiveInfoData;
                this.m = i2;
                this.f42829e.setPlaceHolder(3);
                this.f42829e.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
                SdkLiveInfoData.LiveAuthor liveAuthor = sdkLiveInfoData.liveAuthor;
                if (liveAuthor != null) {
                    String name_show = liveAuthor.getName_show();
                    if (m0.d(name_show) > 16) {
                        name_show = m0.m(name_show, 16) + "...";
                    }
                    this.f42833i.setText(name_show);
                    AlaUtilHelper.startLoadPortrait(this.f42830f, sdkLiveInfoData.liveAuthor.portrait, false);
                    if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                        this.f42831g.setVisibility(0);
                    } else {
                        this.f42831g.setVisibility(8);
                    }
                }
                this.f42832h.setText(sdkLiveInfoData.title);
                this.f42834j.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtraWithRound(sdkLiveInfoData.liveInfo.audienceCount)));
                return;
            }
            setVisibility(4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 101;
        this.o = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.m = 101;
        this.o = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }
}
