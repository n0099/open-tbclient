package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tbclient.SpritePBGuide;
/* loaded from: classes6.dex */
public class i69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<Activity> a;
    public SpritePBGuide b;
    public String c;
    public String d;
    public int e;
    public SpriteAnimationTipManager f;
    public SpriteBottomTipView g;
    public d h;

    /* loaded from: classes6.dex */
    public interface d {
        void onDismiss();
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(i69 i69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && dn5.d()) {
                String b = dn5.b("", 0);
                if (b.startsWith("tiebaapp://router/portal")) {
                    UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{b});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i69 a;

        public b(i69 i69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.g();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SpriteBottomTipView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ i69 b;

        public c(i69 i69Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i69Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i69Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.f.i();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onBtnClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.g();
                this.b.l(this.a);
                this.b.m();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.g();
                this.b.l(this.a);
                this.b.m();
            }
        }
    }

    public i69(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference<>(activity);
    }

    public final boolean k(@Nullable SpritePBGuide spritePBGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, spritePBGuide)) == null) {
            if (spritePBGuide == null || TextUtils.isEmpty(spritePBGuide.button_text) || TextUtils.isEmpty(spritePBGuide.jump_url)) {
                return false;
            }
            if (spritePBGuide.guide_type.longValue() == 0 && TextUtils.isEmpty(spritePBGuide.guide_text)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void l(Context context) {
        SpritePBGuide spritePBGuide;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, context) == null) && (spritePBGuide = this.b) != null && !TextUtils.isEmpty(spritePBGuide.jump_url)) {
            UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(context), new String[]{this.b.jump_url});
        }
    }

    public void p(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.h = dVar;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.e = i;
        }
    }

    @NonNull
    public static FrameLayout.LayoutParams e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds141);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a.get() == null) {
                return false;
            }
            return k(this.b);
        }
        return invokeV.booleanValue;
    }

    public void g() {
        SpriteAnimationTipManager spriteAnimationTipManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (spriteAnimationTipManager = this.f) != null) {
            spriteAnimationTipManager.p();
            d dVar = this.h;
            if (dVar != null) {
                dVar.onDismiss();
            }
        }
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpritePBGuide spritePBGuide = this.b;
            if (spritePBGuide != null && !TextUtils.isEmpty(spritePBGuide.button_text)) {
                return this.b.button_text;
            }
            return TbadkCoreApplication.getInst().getString(R.string.check_immediately);
        }
        return (String) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SpriteAnimationTipManager spriteAnimationTipManager = this.f;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.q("see_res");
            }
            SpriteBottomTipView spriteBottomTipView = this.g;
            if (spriteBottomTipView != null) {
                spriteBottomTipView.i(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final SpriteBottomTipView f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            SpriteBottomTipView.a aVar = new SpriteBottomTipView.a(activity);
            aVar.g(R.layout.funny_sprite_enter_frs_tip_layout);
            aVar.c(i());
            aVar.j(j());
            aVar.f(this.c);
            aVar.l(R.dimen.T_X07);
            aVar.m(R.string.F_X01);
            aVar.k(R.color.CAM_X0105);
            aVar.e(R.drawable.pic_use_header_28_n);
            aVar.i(true);
            aVar.b(Integer.valueOf((int) R.drawable.funny_sprite_tip_bg_right));
            aVar.h(new c(this, activity));
            SpriteBottomTipView a2 = aVar.a();
            ViewGroup.LayoutParams layoutParams = a2.getTitleView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
                a2.getTitleView().setLayoutParams(marginLayoutParams);
            }
            return a2;
        }
        return (SpriteBottomTipView) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c15293");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                statisticItem.addParam("uid", currentAccount);
            }
            if (!TextUtils.isEmpty(this.d)) {
                statisticItem.addParam("fid", this.d);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c15294");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                statisticItem.addParam("uid", currentAccount);
            }
            if (!TextUtils.isEmpty(this.d)) {
                statisticItem.addParam("fid", this.d);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SpritePBGuide spritePBGuide = this.b;
            if (spritePBGuide != null) {
                if (spritePBGuide.guide_type.longValue() == 1) {
                    return String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f94), StringHelper.numberUniformFormatExtraWithRoundFloat(this.e));
                }
                String str = this.b.guide_text;
                if (str != null) {
                    return str;
                }
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void o(SpritePBGuide spritePBGuide, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, spritePBGuide, str, str2) == null) {
            this.b = spritePBGuide;
            this.c = str;
            this.d = str2;
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Activity activity;
        boolean z;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DefaultLog.getInstance().c("PbTopicTip", "准备展示精灵动画提示控件");
            if (!d() || (activity = this.a.get()) == null || activity.isFinishing()) {
                return false;
            }
            this.f = new SpriteAnimationTipManager(activity);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = "funny_sprite_appear_day";
            } else {
                str = "funny_sprite_appear_dark";
            }
            cs6 a2 = dn5.a(FunnySpriteResDownloadUtil.i(str, "see_res", true), false, 2);
            if (z) {
                str2 = "funny_sprite_show_day";
            } else {
                str2 = "funny_sprite_show_dark";
            }
            cs6 a3 = dn5.a(FunnySpriteResDownloadUtil.i(str2, "see_res", true), true, 2);
            if (z) {
                str3 = "funny_sprite_exit_day";
            } else {
                str3 = "funny_sprite_exit_dark";
            }
            this.f.u(a2, a3, dn5.a(FunnySpriteResDownloadUtil.i(str3, "see_res", true), false, 2));
            this.f.y(12000L);
            SpriteBottomTipView f = f(activity);
            this.g = f;
            this.f.x(f);
            this.f.s(UtilHelper.getDimenPixelSize(R.dimen.tbds120), UtilHelper.getDimenPixelSize(R.dimen.tbds239));
            this.f.t(e());
            this.f.v(new a(this));
            this.f.r(new b(this));
            this.f.z();
            h();
            return true;
        }
        return invokeV.booleanValue;
    }
}
