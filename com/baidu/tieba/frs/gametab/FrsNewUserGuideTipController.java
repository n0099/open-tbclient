package com.baidu.tieba.frs.gametab;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.frs.gametab.FrsNewUserGuideTipController;
import com.baidu.tieba.haa;
import com.baidu.tieba.kr6;
import com.baidu.tieba.qm7;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.tieba.t1a;
import com.baidu.tieba.um5;
import com.baidu.tieba.zr6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r*\u0001'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0015\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0002J\u0012\u0010-\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0006\u0010.\u001a\u00020\u001fJ\u0006\u0010/\u001a\u00020\u001fJ\u0012\u00100\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u00101\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u00102\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\u000e\u00104\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\bH\u0002J\b\u00107\u001a\u00020\u001fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/baidu/tieba/frs/gametab/FrsNewUserGuideTipController;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "defaultDismissMills", "", "forumId", "", "getForumId", "()Ljava/lang/String;", "setForumId", "(Ljava/lang/String;)V", "isTipShowing", "", "()Z", "setTipShowing", "(Z)V", "onTipDismissCallback", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "getOnTipDismissCallback", "()Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "setOnTipDismissCallback", "(Lcom/baidu/tieba/controller/TipController$OnDismissListener;)V", "spriteAnimationTipManager", "Lcom/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager;", "tipView", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView;", "applyFrsSpriteData", "", "frsData", "Lcom/baidu/tieba/tbadkCore/FrsResponseData;", "applyTipViewParams", "createAnimationTipViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "createViewByData", "getClickCallback", "com/baidu/tieba/frs/gametab/FrsNewUserGuideTipController$getClickCallback$1", "(Lcom/baidu/tieba/tbadkCore/FrsResponseData;)Lcom/baidu/tieba/frs/gametab/FrsNewUserGuideTipController$getClickCallback$1;", "getReadySendMsg", FileHelper.FILE_CACHE_BUBBLE, "Lcom/baidu/tbadk/core/data/FrsSpriteNewUserGuide$BubbleText;", "getSpriteSchema", "gotoChatPage", "hideTip", "onChangeSkin", "onClickSpriteBody", "onClickSpriteBubble", "onClickSpriteButton", "onClickSpriteClose", "showTip", "staticFrsNewUserGuideClick", "location", "staticFrsNewUserGuideShow", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsNewUserGuideTipController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final int b;
    public final SpriteAnimationTipManager c;
    public SpriteBottomTipView d;
    public kr6.e e;
    public boolean f;
    public String g;

    /* loaded from: classes5.dex */
    public static final class a implements SpriteBottomTipView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewUserGuideTipController a;
        public final /* synthetic */ haa b;

        public a(FrsNewUserGuideTipController frsNewUserGuideTipController, haa haaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewUserGuideTipController, haaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNewUserGuideTipController;
            this.b = haaVar;
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.s();
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onBtnClick() {
            FrsSpriteNewUserGuide.BubbleText bubbleText;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                FrsNewUserGuideTipController frsNewUserGuideTipController = this.a;
                FrsSpriteNewUserGuide frsSpriteNewUserGuide = this.b.frsSpriteNewUserGuide;
                if (frsSpriteNewUserGuide != null) {
                    bubbleText = frsSpriteNewUserGuide.bubbleText;
                } else {
                    bubbleText = null;
                }
                frsNewUserGuideTipController.r(bubbleText);
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onClick() {
            FrsSpriteNewUserGuide.BubbleText bubbleText;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                FrsNewUserGuideTipController frsNewUserGuideTipController = this.a;
                FrsSpriteNewUserGuide frsSpriteNewUserGuide = this.b.frsSpriteNewUserGuide;
                if (frsSpriteNewUserGuide != null) {
                    bubbleText = frsSpriteNewUserGuide.bubbleText;
                } else {
                    bubbleText = null;
                }
                frsNewUserGuideTipController.q(bubbleText);
            }
        }
    }

    public FrsNewUserGuideTipController(Activity activity) {
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
        this.b = 5000;
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
        zr6 a2 = um5.a(FunnySpriteResDownloadUtil.i(str, "new_user_guide_res", true), false, 2);
        if (z) {
            str2 = "funny_sprite_show_day";
        } else {
            str2 = "funny_sprite_show_dark";
        }
        zr6 a3 = um5.a(FunnySpriteResDownloadUtil.i(str2, "new_user_guide_res", true), true, 2);
        if (z) {
            str3 = "funny_sprite_exit_day";
        } else {
            str3 = "funny_sprite_exit_dark";
        }
        this.c.u(a2, a3, um5.a(FunnySpriteResDownloadUtil.i(str3, "new_user_guide_res", true), false, 2));
        this.c.s(UtilHelper.getDimenPixelSize(R.dimen.tbds120), UtilHelper.getDimenPixelSize(R.dimen.tbds239));
        this.c.t(f());
        this.c.r(new Function0<Unit>(this) { // from class: com.baidu.tieba.frs.gametab.FrsNewUserGuideTipController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsNewUserGuideTipController this$0;

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
                    DefaultLog.getInstance().i("FrsGuide", "精灵动画提示控件：隐藏新用户引导动画结束");
                    this.this$0.v(false);
                    kr6.e i3 = this.this$0.i();
                    if (i3 != null) {
                        i3.onDismiss();
                    }
                }
            }
        });
    }

    public final void d(haa haaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, haaVar) == null) {
            SpriteBottomTipView g = g(this.a, haaVar);
            this.d = g;
            this.c.y(g);
        }
    }

    public final a h(haa haaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, haaVar)) == null) {
            return new a(this, haaVar);
        }
        return (a) invokeL.objValue;
    }

    public final void l(FrsSpriteNewUserGuide.BubbleText bubbleText) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, bubbleText) != null) || bubbleText == null) {
            return;
        }
        um5.j(j(bubbleText));
        t1a.a(this.a, new String[]{k(bubbleText)});
    }

    public final void q(FrsSpriteNewUserGuide.BubbleText bubbleText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bubbleText) == null) {
            l(bubbleText);
            y(1);
        }
    }

    public final void r(FrsSpriteNewUserGuide.BubbleText bubbleText) {
        String str;
        FrsSpriteNewUserGuide.ButtonInfo buttonInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bubbleText) == null) {
            if (bubbleText != null && (buttonInfo = bubbleText.buttonInfo) != null) {
                str = buttonInfo.schema;
            } else {
                str = null;
            }
            if (StringUtils.isNotNull(str)) {
                UrlManager.getInstance().dealOneLink(str);
            } else {
                l(bubbleText);
            }
            y(1);
            m();
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.g = str;
        }
    }

    public final void u(kr6.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.e = eVar;
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f = z;
        }
    }

    public static final void x(FrsNewUserGuideTipController this$0, haa frsData, View view2) {
        FrsSpriteNewUserGuide.BubbleText bubbleText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, frsData, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(frsData, "$frsData");
            FrsSpriteNewUserGuide frsSpriteNewUserGuide = frsData.frsSpriteNewUserGuide;
            if (frsSpriteNewUserGuide != null) {
                bubbleText = frsSpriteNewUserGuide.bubbleText;
            } else {
                bubbleText = null;
            }
            this$0.p(bubbleText);
        }
    }

    public final void e(SpriteBottomTipView spriteBottomTipView) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spriteBottomTipView) == null) {
            spriteBottomTipView.getDescView().setLineSpacing(UtilHelper.getDimenPixelSize(R.dimen.tbds20), 1.0f);
            ViewGroup.LayoutParams layoutParams = spriteBottomTipView.getContentView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds192), 0);
            }
        }
    }

    public final String j(FrsSpriteNewUserGuide.BubbleText bubbleText) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bubbleText)) == null) {
            if (StringUtils.isNotNull(bubbleText.spriteText)) {
                str = bubbleText.spriteText;
                Intrinsics.checkNotNull(str);
            } else if (StringUtils.isNotNull(bubbleText.text)) {
                str = bubbleText.text;
                Intrinsics.checkNotNull(str);
            } else {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "when {\n        StringUti…       \"\"\n        }\n    }");
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final String k(FrsSpriteNewUserGuide.BubbleText bubbleText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubbleText)) == null) {
            String str = "";
            if (bubbleText.needSend != 0) {
                String str2 = bubbleText.sendText;
                if (str2 != null) {
                    str = str2;
                }
                return um5.c(str, 1, this.g);
            }
            String str3 = bubbleText.text;
            if (str3 != null) {
                str = str3;
            }
            return um5.c(str, 2, this.g);
        }
        return (String) invokeL.objValue;
    }

    public final void y(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c15371");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_locate", i);
            String str = this.g;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                statisticItem.addParam("fid", this.g);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final FrameLayout.LayoutParams f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds90);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }

    public final kr6.e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (kr6.e) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            DefaultLog.getInstance().i("FrsGuide", "精灵动画提示控件：隐藏新用户引导");
            this.c.p();
            this.f = false;
            kr6.e eVar = this.e;
            if (eVar != null) {
                eVar.onDismiss();
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c.q("new_user_guide_res");
            SpriteBottomTipView spriteBottomTipView = this.d;
            if (spriteBottomTipView != null) {
                spriteBottomTipView.j(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            y(0);
            m();
        }
    }

    public final SpriteBottomTipView g(Activity activity, haa haaVar) {
        InterceptResult invokeLL;
        FrsSpriteNewUserGuide.BubbleText bubbleText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, activity, haaVar)) == null) {
            SpriteBottomTipView.a aVar = new SpriteBottomTipView.a(activity);
            aVar.n(R.layout.funny_sprite_frs_user_guide_layout);
            aVar.r(true);
            Integer valueOf = Integer.valueOf((int) R.drawable.funny_sprite_tip_bg_right);
            aVar.p(valueOf);
            aVar.o(valueOf);
            aVar.q(h(haaVar));
            qm7.c(aVar);
            qm7.d(aVar);
            FrsSpriteNewUserGuide frsSpriteNewUserGuide = haaVar.frsSpriteNewUserGuide;
            if (frsSpriteNewUserGuide != null) {
                bubbleText = frsSpriteNewUserGuide.bubbleText;
            } else {
                bubbleText = null;
            }
            qm7.a(aVar, bubbleText);
            SpriteBottomTipView a2 = aVar.a();
            e(a2);
            return a2;
        }
        return (SpriteBottomTipView) invokeLL.objValue;
    }

    public final void p(FrsSpriteNewUserGuide.BubbleText bubbleText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bubbleText) == null) {
            String c = um5.c("", 0, this.g);
            if (StringsKt__StringsJVMKt.startsWith$default(c, "tiebaapp://router/portal", false, 2, null)) {
                if (bubbleText != null) {
                    um5.j(j(bubbleText));
                }
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{c});
                y(2);
            }
        }
    }

    public final void w(final haa frsData) {
        int i;
        Number valueOf;
        FrsSpriteNewUserGuide.BubbleText bubbleText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, frsData) == null) {
            Intrinsics.checkNotNullParameter(frsData, "frsData");
            DefaultLog.getInstance().i("FrsGuide", "精灵动画提示控件：显示新用户引导");
            d(frsData);
            this.c.x(80);
            FrsSpriteNewUserGuide frsSpriteNewUserGuide = frsData.frsSpriteNewUserGuide;
            if (frsSpriteNewUserGuide != null && (bubbleText = frsSpriteNewUserGuide.bubbleText) != null) {
                i = bubbleText.disappearSeconds;
            } else {
                i = 0;
            }
            if (i > 0) {
                valueOf = Long.valueOf(TimeUnit.SECONDS.toMillis(i));
            } else {
                valueOf = Integer.valueOf(this.b);
            }
            this.c.v(new View.OnClickListener() { // from class: com.baidu.tieba.im7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FrsNewUserGuideTipController.x(FrsNewUserGuideTipController.this, frsData, view2);
                    }
                }
            });
            this.c.z(valueOf.longValue());
            this.c.A();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921769));
            this.f = true;
            z();
        }
    }

    public final void z() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c15370");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            String str = this.g;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                statisticItem.addParam("fid", this.g);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
