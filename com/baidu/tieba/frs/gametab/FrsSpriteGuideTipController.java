package com.baidu.tieba.frs.gametab;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController;
import com.baidu.tieba.jn5;
import com.baidu.tieba.js6;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.tieba.tr6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "isTipShowing", "", "()Z", "setTipShowing", "(Z)V", "onBtnClickCallback", "Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController$OnBtnClickCallback;", "getOnBtnClickCallback", "()Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController$OnBtnClickCallback;", "setOnBtnClickCallback", "(Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController$OnBtnClickCallback;)V", "onTipDismissCallback", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "getOnTipDismissCallback", "()Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "setOnTipDismissCallback", "(Lcom/baidu/tieba/controller/TipController$OnDismissListener;)V", "spriteAnimationTipManager", "Lcom/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager;", "createAnimationTipViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "createViewByData", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView;", "hideTip", "", "showTip", "OnBtnClickCallback", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsSpriteGuideTipController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final SpriteAnimationTipManager b;
    public a c;
    public tr6.e d;
    public boolean e;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public static final class b implements SpriteBottomTipView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSpriteGuideTipController a;

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public b(FrsSpriteGuideTipController frsSpriteGuideTipController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSpriteGuideTipController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSpriteGuideTipController;
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.i();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onBtnClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a e = this.a.e();
                if (e != null) {
                    e.onClick();
                }
                this.a.b.i();
            }
        }
    }

    public FrsSpriteGuideTipController(Activity activity) {
        boolean z;
        String str;
        String str2;
        String str3;
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
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.b = new SpriteAnimationTipManager(this.a);
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
        js6 a2 = jn5.a(FunnySpriteResDownloadUtil.i(str, "see_res", true), false, 2);
        if (z) {
            str2 = "funny_sprite_show_day";
        } else {
            str2 = "funny_sprite_show_dark";
        }
        js6 a3 = jn5.a(FunnySpriteResDownloadUtil.i(str2, "see_res", true), true, 2);
        if (z) {
            str3 = "funny_sprite_exit_day";
        } else {
            str3 = "funny_sprite_exit_dark";
        }
        this.b.u(a2, a3, jn5.a(FunnySpriteResDownloadUtil.i(str3, "see_res", true), false, 2));
        this.b.x(d(this.a));
        this.b.y(4000L);
        this.b.s(UtilHelper.getDimenPixelSize(R.dimen.tbds120), UtilHelper.getDimenPixelSize(R.dimen.tbds239));
        this.b.t(c());
        this.b.v(new View.OnClickListener() { // from class: com.baidu.tieba.ok7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    FrsSpriteGuideTipController.a(view2);
                }
            }
        });
        this.b.r(new Function0<Unit>(this) { // from class: com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsSpriteGuideTipController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.k(false);
                    tr6.e f = this.this$0.f();
                    if (f != null) {
                        f.onDismiss();
                    }
                }
            }
        });
    }

    public static final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view2) == null) {
            String b2 = jn5.b("", 0);
            if (StringsKt__StringsJVMKt.startsWith$default(b2, "tiebaapp://router/portal", false, 2, null)) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{b2});
            }
        }
    }

    public final void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public final void j(tr6.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.d = eVar;
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.e = z;
        }
    }

    public final FrameLayout.LayoutParams c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds90);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (a) invokeV.objValue;
    }

    public final tr6.e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (tr6.e) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DefaultLog.getInstance().c("FrsGuide", "精灵动画提示控件：隐藏吧引导");
            this.b.p();
            this.e = false;
            tr6.e eVar = this.d;
            if (eVar != null) {
                eVar.onDismiss();
            }
        }
    }

    public final Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            DefaultLog.getInstance().c("FrsGuide", "精灵动画提示控件：展示吧引导");
            this.b.z();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921769));
            this.e = true;
        }
    }

    public final SpriteBottomTipView d(Activity activity) {
        InterceptResult invokeL;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            SpriteBottomTipView.a aVar = new SpriteBottomTipView.a(activity);
            aVar.c(activity.getString(R.string.obfuscated_res_0x7f0f081e));
            aVar.j(activity.getString(R.string.obfuscated_res_0x7f0f081f));
            aVar.i(true);
            aVar.l(R.dimen.T_X07);
            aVar.k(R.color.CAM_X0610);
            aVar.m(R.string.F_X01);
            aVar.b(Integer.valueOf((int) R.drawable.funny_sprite_tip_bg_right));
            aVar.h(new b(this));
            SpriteBottomTipView a2 = aVar.a();
            ViewGroup.LayoutParams layoutParams = a2.getTitleView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds75);
                marginLayoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds75);
                a2.getTitleView().setLayoutParams(marginLayoutParams);
            }
            return a2;
        }
        return (SpriteBottomTipView) invokeL.objValue;
    }
}
