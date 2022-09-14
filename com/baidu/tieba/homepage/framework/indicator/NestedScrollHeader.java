package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DebugToolActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.floatCardView.AlaLiveTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.c45;
import com.baidu.tieba.ej;
import com.baidu.tieba.kg5;
import com.baidu.tieba.np4;
import com.baidu.tieba.q15;
import com.baidu.tieba.t35;
import com.baidu.tieba.uu4;
import com.baidu.tieba.w9;
import com.baidu.tieba.y27;
import com.baidu.tieba.zk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes4.dex */
public class NestedScrollHeader extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PublishButton a;
    public ImageView b;
    public TextView c;
    public float d;
    public View e;
    public ImageView f;
    public AlaLiveTipView g;
    public Context h;
    public View.OnClickListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg5 a;
        public final /* synthetic */ NestedScrollHeader b;

        public a(NestedScrollHeader nestedScrollHeader, kg5 kg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollHeader, kg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nestedScrollHeader;
            this.a = kg5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n(false);
                this.b.i.onClick(view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
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

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        public c(NestedScrollHeader nestedScrollHeader) {
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
                                if (this.a.b == view2) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DebugToolActivityConfig(this.a.getContext())));
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_GAMECENTER).param("obj_type", "1"));
                            this.a.g();
                            return;
                        } else if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new c45(1)));
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
                            return;
                        }
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(this.a.getContext(), "", false)));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollHeader a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(NestedScrollHeader nestedScrollHeader, int i) {
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
                this.a.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (Build.VERSION.SDK_INT <= 21) {
                ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00ec);
                return;
            }
            try {
                UrlManager.getInstance().dealOneLink((TbPageContext) w9.a(getContext()), new String[]{UrlSchemaHelper.SCHEME_SWAN_GAME_CENTER});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4012);
            this.h = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04c7, (ViewGroup) this, true);
            this.a = (PublishButton) findViewById(R.id.obfuscated_res_0x7f091adb);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091dd8);
            this.e = findViewById(R.id.obfuscated_res_0x7f090c6f);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c62);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090772);
            if (!UbsABTestHelper.isHomeTabModifyABTestA()) {
                AlaLiveTipView alaLiveTipView = (AlaLiveTipView) findViewById(R.id.obfuscated_res_0x7f0913b1);
                this.g = alaLiveTipView;
                alaLiveTipView.setViewLocate(1);
                this.g.setHasBubble(false);
            }
            kg5 c2 = kg5.c(this.h);
            c2.h(BadgeDrawable.TOP_END);
            c2.g(-65536);
            c2.m(R.dimen.tbds15, false);
            c2.k(R.dimen.tbds9, false);
            c2.i(R.dimen.tbds9);
            c2.l("NestedScrollHeader.sendHelp");
            c2.b(this.a);
            this.a.setOnClickListener(new a(this, c2));
            this.c.setOnClickListener(this.i);
            this.f.setOnClickListener(this.i);
            this.b.setOnClickListener(this.i);
            this.b.setVisibility(np4.h() ? 0 : 8);
            if (UbsABTestHelper.isMainTabShowA()) {
                this.a.setVisibility(8);
            }
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            l();
            getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
            k();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4013);
        }
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    public final void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            t35 f3 = y27.f(TbadkApplication.getInst().getHomeBarShowTabName());
            if (f3 != null) {
                setBackgroundColor(zk8.a(zk8.f(y27.d(f3)), 1.0f - f2));
            } else {
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void k() {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                uu4 d2 = uu4.d(this.c);
                d2.v(R.color.CAM_X0619);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0613);
                WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080762, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
                pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a6d, SkinManager.getColor(R.color.CAM_X0619), WebPManager.ResourceStateType.NORMAL);
                j(this.d);
            } else {
                uu4 d3 = uu4.d(this.c);
                d3.v(R.color.CAM_X0109);
                d3.n(R.string.J_X01);
                d3.f(R.color.CAM_X0210);
                WebPManager.setMaskDrawable(this.f, R.drawable.icon_home_new_games, WebPManager.ResourceStateType.NORMAL);
                pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a6d, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - this.d, TbadkCoreApplication.getInst().getSkinType());
            }
            this.a.r();
            SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f0806e8);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
            this.c.setCompoundDrawables(pureDrawable, null, null, null);
        }
    }

    public final void l() {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (alaLiveTipView = this.g) == null) {
            return;
        }
        if (alaLiveTipView.getVisibility() != 0) {
            q15.f();
        }
        this.g.setVisibility(0);
        m(this.g.getVisibility() == 0);
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.c == null) {
            return;
        }
        int f2 = ej.f(getContext(), R.dimen.M_W_X007);
        if (z) {
            f2 = ej.f(getContext(), R.dimen.M_W_X002);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.setMargins(f2, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.d = f2;
        if (TbadkApplication.getInst().isUseLuckyHeader()) {
            j(f2);
        } else {
            SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.b.getVisibility() == 0 && this.b.getAlpha() != f2) {
            this.b.setAlpha(f2);
        }
        if (this.b.getVisibility() == 0 && this.b.getAlpha() != f2) {
            this.b.setAlpha(f2);
        }
        if (this.f.getVisibility() == 0 && this.f.getAlpha() != f2) {
            this.f.setAlpha(f2);
        }
        if (this.c.getAlpha() != f2) {
            this.c.setAlpha(f2);
        }
        if (this.a.getVisibility() == 0 && this.a.getAlpha() != f2) {
            this.a.setAlpha(f2);
            this.a.setScrollAlpha(f2);
        }
        AlaLiveTipView alaLiveTipView = this.g;
        if (alaLiveTipView == null || alaLiveTipView.getVisibility() != 0 || this.g.getAlpha() == f2) {
            return;
        }
        this.g.setAlpha(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5009);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5010);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5001);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5002);
        }
    }

    public void setGameLayoutVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }

    public void setSearchHint(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
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
        this.i = new c(this);
        this.j = new d(this, 2921396);
        this.k = new e(this, 2001371);
        h(context);
    }
}
