package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.atomData.DebugToolActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.repackage.cz6;
import com.repackage.em4;
import com.repackage.fr4;
import com.repackage.jz4;
import com.repackage.pi;
import com.repackage.sz4;
import com.repackage.xf8;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class NestedScrollHeader extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PublishButton a;
    public ImageView b;
    public TextView c;
    public float d;
    public View e;
    public ImageView f;
    public FrameLayout g;
    public TBLottieAnimationView h;
    public TBLottieAnimationView i;
    public Context j;
    public View.OnClickListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        public a(NestedScrollHeader nestedScrollHeader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollHeader;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 16)
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
                    AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.a.getLayoutParams();
                    layoutParams.setScrollFlags(5);
                    this.a.setLayoutParams(layoutParams);
                }
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        public b(NestedScrollHeader nestedScrollHeader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollHeader;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    if (this.a.c != view2) {
                        if (this.a.a != view2) {
                            if (this.a.f != view2) {
                                if (this.a.g == view2) {
                                    this.a.k();
                                    new AlaTabFeedActivityConfig(this.a.getContext()).start();
                                } else if (this.a.b == view2) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DebugToolActivityConfig(this.a.getContext())));
                                }
                            } else {
                                HashMap hashMap = new HashMap();
                                hashMap.put("open_flag", "1");
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.j, "GameCenterListPage", hashMap)));
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_GAMECENTER).param("obj_type", "1"));
                            }
                        } else if (WriteActivityConfig.isAsyncWriting()) {
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new sz4(1)));
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(this.a.getContext(), "", false)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(NestedScrollHeader nestedScrollHeader, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollHeader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(NestedScrollHeader nestedScrollHeader, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollHeader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                this.a.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4012);
            this.j = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0499, (ViewGroup) this, true);
            this.a = (PublishButton) findViewById(R.id.obfuscated_res_0x7f091940);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091bf9);
            this.e = findViewById(R.id.obfuscated_res_0x7f090c10);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c03);
            this.g = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091281);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091280);
            this.h = tBLottieAnimationView;
            tBLottieAnimationView.setImageAssetsFolder("lottie_home_live_entrance/");
            this.h.setAnimation(R.raw.obfuscated_res_0x7f11003d);
            this.h.setRepeatMode(1);
            this.h.setRepeatCount(-1);
            this.h.setSpeed(0.67f);
            this.h.playAnimation();
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091282);
            this.i = tBLottieAnimationView2;
            tBLottieAnimationView2.setImageAssetsFolder("lottie_home_live_entrance_lh/");
            this.i.setAnimation(R.raw.obfuscated_res_0x7f11003e);
            this.i.setRepeatMode(1);
            this.i.setRepeatCount(-1);
            this.i.setSpeed(0.67f);
            this.i.playAnimation();
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090732);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090732);
            this.a.setOnClickListener(this.k);
            this.c.setOnClickListener(this.k);
            this.f.setOnClickListener(this.k);
            this.b.setOnClickListener(this.k);
            this.b.setVisibility(em4.h() ? 0 : 8);
            this.g.setOnClickListener(this.k);
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            o();
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
            n();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4013);
        }
    }

    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_LIVE_ICON_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1).eventStat();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_LIVE_ICON_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1).eventStat();
        }
    }

    public final void m(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            jz4 f2 = cz6.f(TbadkApplication.getInst().getHomeBarShowTabName());
            if (f2 != null) {
                setBackgroundColor(xf8.a(xf8.f(cz6.d(f2)), 1.0f - f));
            } else {
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void n() {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                fr4 d2 = fr4.d(this.c);
                d2.v(R.color.CAM_X0619);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0613);
                WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080740, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
                pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a20, SkinManager.getColor(R.color.CAM_X0619), WebPManager.ResourceStateType.NORMAL);
                if (this.g.getVisibility() == 0) {
                    this.h.setVisibility(8);
                    this.i.setVisibility(0);
                }
                m(this.d);
            } else {
                fr4 d3 = fr4.d(this.c);
                d3.v(R.color.CAM_X0109);
                d3.n(R.string.J_X01);
                d3.f(R.color.CAM_X0210);
                WebPManager.setMaskDrawable(this.f, R.drawable.icon_home_new_games, WebPManager.ResourceStateType.NORMAL);
                pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a20, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
                if (this.g.getVisibility() == 0) {
                    this.h.setVisibility(0);
                    this.i.setVisibility(8);
                }
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - this.d, TbadkCoreApplication.getInst().getSkinType());
            }
            this.a.r();
            SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f0806c7);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
            this.c.setCompoundDrawables(pureDrawable, null, null, null);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!UbsABTestHelper.isHomeLiveTestA() && !UbsABTestHelper.isHomeLiveTestB()) {
                this.g.setVisibility(8);
            } else {
                if (this.g.getVisibility() != 0) {
                    l();
                }
                this.g.setVisibility(0);
            }
            p(this.g.getVisibility() == 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5009);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5010);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5001);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5002);
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || this.c == null) {
            return;
        }
        int f = pi.f(getContext(), R.dimen.M_W_X007);
        if (z) {
            f = pi.f(getContext(), R.dimen.M_W_X002);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.setMargins(f, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
    }

    public void q(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f) == null) || f < 0.0f || f > 1.0f) {
            return;
        }
        this.d = f;
        if (TbadkApplication.getInst().isUseLuckyHeader()) {
            m(f);
        } else {
            SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.b.getVisibility() == 0 && this.b.getAlpha() != f) {
            this.b.setAlpha(f);
        }
        if (this.b.getVisibility() == 0 && this.b.getAlpha() != f) {
            this.b.setAlpha(f);
        }
        if (this.f.getVisibility() == 0 && this.f.getAlpha() != f) {
            this.f.setAlpha(f);
        }
        if (this.c.getAlpha() != f) {
            this.c.setAlpha(f);
        }
        if (this.a.getVisibility() == 0 && this.a.getAlpha() != f) {
            this.a.setAlpha(f);
            this.a.setScrollAlpha(f);
        }
        if (this.g.getVisibility() != 0 || this.g.getAlpha() == f) {
            return;
        }
        this.g.setAlpha(f);
    }

    public void setGameLayoutVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }

    public void setSearchHint(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setText(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = 1.0f;
        this.k = new b(this);
        this.l = new c(this, 2921396);
        this.m = new d(this, 2001371);
        i(context);
    }
}
