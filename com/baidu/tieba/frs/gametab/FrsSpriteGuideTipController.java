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
import com.baidu.tieba.fr6;
import com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController;
import com.baidu.tieba.ik5;
import com.baidu.tieba.oq6;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController;", "", "activity", "Landroid/app/Activity;", "forumId", "", "(Landroid/app/Activity;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "getForumId", "()Ljava/lang/String;", "isTipShowing", "", "()Z", "setTipShowing", "(Z)V", "onBtnClickCallback", "Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController$OnBtnClickCallback;", "getOnBtnClickCallback", "()Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController$OnBtnClickCallback;", "setOnBtnClickCallback", "(Lcom/baidu/tieba/frs/gametab/FrsSpriteGuideTipController$OnBtnClickCallback;)V", "onTipDismissCallback", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "getOnTipDismissCallback", "()Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "setOnTipDismissCallback", "(Lcom/baidu/tieba/controller/TipController$OnDismissListener;)V", "spriteAnimationTipManager", "Lcom/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager;", "createAnimationTipViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "createViewByData", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView;", "hideTip", "", "showTip", "OnBtnClickCallback", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsSpriteGuideTipController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final String b;
    public final SpriteAnimationTipManager c;
    public a d;
    public oq6.e e;
    public boolean f;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes6.dex */
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
                this.a.c.i();
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
                this.a.c.i();
            }
        }
    }

    public FrsSpriteGuideTipController(Activity activity, String forumId) {
        boolean z;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, forumId};
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
        Intrinsics.checkNotNullParameter(forumId, "forumId");
        this.a = activity;
        this.b = forumId;
        this.c = new SpriteAnimationTipManager(this.a);
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
        fr6 a2 = ik5.a(FunnySpriteResDownloadUtil.i(str, "see_res", true), false, 2);
        if (z) {
            str2 = "funny_sprite_show_day";
        } else {
            str2 = "funny_sprite_show_dark";
        }
        fr6 a3 = ik5.a(FunnySpriteResDownloadUtil.i(str2, "see_res", true), true, 2);
        if (z) {
            str3 = "funny_sprite_exit_day";
        } else {
            str3 = "funny_sprite_exit_dark";
        }
        this.c.v(a2, a3, ik5.a(FunnySpriteResDownloadUtil.i(str3, "see_res", true), false, 2));
        this.c.z(d(this.a));
        this.c.A(4000L);
        this.c.t(UtilHelper.getDimenPixelSize(R.dimen.tbds120), UtilHelper.getDimenPixelSize(R.dimen.tbds239));
        this.c.u(c());
        this.c.w(new View.OnClickListener() { // from class: com.baidu.tieba.nz7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    FrsSpriteGuideTipController.a(FrsSpriteGuideTipController.this, view2);
                }
            }
        });
        this.c.s(new Function0<Unit>(this) { // from class: com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController.2
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
                    oq6.e f = this.this$0.f();
                    if (f != null) {
                        f.onDismiss();
                    }
                }
            }
        });
    }

    public static final void a(FrsSpriteGuideTipController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String c = ik5.c("", 0, this$0.b);
            if (StringsKt__StringsJVMKt.startsWith$default(c, "tiebaapp://router/portal", false, 2, null)) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{c});
            }
        }
    }

    public final void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public final void j(oq6.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.e = eVar;
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
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
            return this.d;
        }
        return (a) invokeV.objValue;
    }

    public final oq6.e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (oq6.e) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DefaultLog.getInstance().i("FrsGuide", "精灵动画提示控件：隐藏吧引导");
            this.c.q();
            this.f = false;
            oq6.e eVar = this.e;
            if (eVar != null) {
                eVar.onDismiss();
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            DefaultLog.getInstance().i("FrsGuide", "精灵动画提示控件：展示吧引导");
            this.c.B();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921769));
            this.f = true;
        }
    }

    public final SpriteBottomTipView d(Activity activity) {
        InterceptResult invokeL;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            SpriteBottomTipView.a aVar = new SpriteBottomTipView.a(activity);
            aVar.e(activity.getString(R.string.obfuscated_res_0x7f0f084a));
            aVar.t(activity.getString(R.string.obfuscated_res_0x7f0f084b));
            aVar.s(true);
            aVar.x(R.dimen.T_X07);
            aVar.v(R.color.CAM_X0610);
            aVar.y(R.string.F_X01);
            aVar.p(Integer.valueOf((int) R.drawable.funny_sprite_tip_bg_right));
            aVar.r(new b(this));
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
