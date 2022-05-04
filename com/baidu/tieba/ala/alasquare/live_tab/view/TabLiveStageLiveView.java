package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
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
import com.repackage.f9;
import com.repackage.fd5;
import com.repackage.ho5;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final float l;
    public static final float[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public HeadImageView b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public TabLiveStageLiveZanLottieView h;
    public int i;
    public SdkLiveInfoData j;
    public int[] k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabLiveStageLiveView a;

        public a(TabLiveStageLiveView tabLiveStageLiveView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLiveStageLiveView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tabLiveStageLiveView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!ho5.d(this.a.j)) {
                    ho5.h(this.a.getContext(), this.a.j);
                } else if (f9.a(this.a.getContext()) instanceof TbPageContext) {
                    int i = this.a.i;
                    String str = YYLiveUtil.SOURCE_HOME_LIVE_TAB_STAGE;
                    if (i != 101 && this.a.i == 102) {
                        str = YYLiveUtil.SOURCE_HOME_LIVE_TAB_RECOMMEND;
                    }
                    ho5.j((TbPageContext) f9.a(this.a.getContext()), this.a.j, str);
                }
                int i2 = this.a.i;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                if (i2 != 101) {
                    if (this.a.i == 102) {
                        StatisticItem statisticItem = new StatisticItem("c13559");
                        if (this.a.j.liveInfo != null) {
                            int a = ho5.a(this.a.j.liveInfo);
                            if (this.a.j.liveInfo.yyExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, ho5.k(this.a.j.liveInfo.yyExt, this.a.j.roomId));
                            } else {
                                str2 = "";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                        }
                        statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                        statisticItem.param("nid", this.a.j.nid);
                        statisticItem.param(TiebaStatic.Params.LOGID, this.a.j.logid);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13556");
                if (this.a.j.liveInfo != null) {
                    int a2 = ho5.a(this.a.j.liveInfo);
                    if (this.a.j.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem2, ho5.k(this.a.j.liveInfo.yyExt, this.a.j.roomId));
                    } else {
                        str2 = "";
                    }
                    statisticItem2.param("obj_param1", a2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                }
                statisticItem2.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                statisticItem2.param("nid", this.a.j.nid);
                statisticItem2.param(TiebaStatic.Params.LOGID, this.a.j.logid);
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
        l = dimension;
        m = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = 101;
        this.k = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            Drawable drawable = SkinManager.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.h.setAnimation("zan_lottie_anim.json");
                this.h.setImageAssetsFolder("images/");
                this.h.loop(true);
                this.h.playAnimation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07f3, this);
            float f = l;
            setRoundLayoutRadius(new float[]{f, f, f, f, f, f, f, f});
            TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = (TabLiveStageLiveZanLottieView) findViewById(R.id.obfuscated_res_0x7f0924b9);
            this.h = tabLiveStageLiveZanLottieView;
            tabLiveStageLiveZanLottieView.setForbidAutoUpdateState(true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09070e);
            this.a = tbImageView;
            tbImageView.setBackgroundColor(0);
            this.a.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
            this.a.setConrers(15);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090d2a);
            this.b = headImageView;
            headImageView.setAutoChangeStyle(false);
            this.b.setClickable(true);
            this.b.setIsRound(true);
            this.b.setBorderWidth(oi.f(getContext(), R.dimen.tbds1));
            this.c = findViewById(R.id.obfuscated_res_0x7f090d2c);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092013);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09229d);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0902d4);
            this.g = findViewById(R.id.obfuscated_res_0x7f0903d1);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.k);
            gradientDrawable.setCornerRadii(m);
            this.g.setBackgroundDrawable(gradientDrawable);
            setOnClickListener(new a(this));
            d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = this.h;
            if (tabLiveStageLiveZanLottieView == null || tabLiveStageLiveZanLottieView.isAnimating()) {
                return;
            }
            this.h.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = this.h;
            if (tabLiveStageLiveZanLottieView != null && tabLiveStageLiveZanLottieView.isAnimating()) {
                this.h.pauseAnimation();
            }
            super.onDetachedFromWindow();
        }
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sdkLiveInfoData, i) == null) {
            if (sdkLiveInfoData != null && sdkLiveInfoData.liveInfo != null) {
                this.j = sdkLiveInfoData;
                this.i = i;
                this.a.setPlaceHolder(3);
                this.a.K(sdkLiveInfoData.liveInfo.cover, 10, false);
                SdkLiveInfoData.LiveAuthor liveAuthor = sdkLiveInfoData.liveAuthor;
                if (liveAuthor != null) {
                    String name_show = liveAuthor.getName_show();
                    if (fd5.d(name_show) > 16) {
                        name_show = fd5.n(name_show, 16) + StringHelper.STRING_MORE;
                    }
                    this.e.setText(name_show);
                    AlaUtilHelper.startLoadPortrait(this.b, sdkLiveInfoData.liveAuthor.portrait, false);
                    if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                        this.c.setVisibility(0);
                    } else {
                        this.c.setVisibility(8);
                    }
                }
                this.d.setText(sdkLiveInfoData.title);
                this.f.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f11bb, StringHelper.numberUniformFormatExtraWithRound(sdkLiveInfoData.liveInfo.audienceCount)));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = 101;
        this.k = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = 101;
        this.k = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }
}
