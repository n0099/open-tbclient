package com.baidu.tieba.forum.helper;

import android.app.Activity;
import android.view.View;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.forum.helper.ForumFullPushDialogController;
import com.baidu.tieba.jr6;
import com.baidu.tieba.lk5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.rd;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sq6;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
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
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0002J\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0002¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020 J\u0006\u0010+\u001a\u00020 J\u0012\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\nH\u0002J\u000e\u00101\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/tieba/forum/helper/ForumFullPushDialogController;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getActivity", "()Landroid/app/Activity;", "defaultDismissMills", "", "forumId", "getForumId", "()Ljava/lang/String;", "setForumId", "(Ljava/lang/String;)V", "isTipShowing", "", "()Z", "setTipShowing", "(Z)V", "onTipDismissCallback", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "getOnTipDismissCallback", "()Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "setOnTipDismissCallback", "(Lcom/baidu/tieba/controller/TipController$OnDismissListener;)V", "spriteAnimationTipManager", "Lcom/baidu/tieba/statemachine/animationtip/SpriteAnimationTipManager;", "tipView", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView;", "applyFrsSpriteData", "", "spriteBuddleData", "Lcom/baidu/tbadk/core/data/FrsSpriteNewUserGuide;", "createAnimationTipViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "createViewByData", "getClickCallback", "com/baidu/tieba/forum/helper/ForumFullPushDialogController$getClickCallback$1", "frsSpriteNewUserGuide", "(Lcom/baidu/tbadk/core/data/FrsSpriteNewUserGuide;)Lcom/baidu/tieba/forum/helper/ForumFullPushDialogController$getClickCallback$1;", "hideTip", "onChangeSkin", "onClick", FileHelper.FILE_CACHE_BUBBLE, "Lcom/baidu/tbadk/core/data/FrsSpriteNewUserGuide$BubbleText;", "reportFullPushDialog", "objType", "showTip", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumFullPushDialogController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final String b;
    public final int c;
    public final SpriteAnimationTipManager d;
    public SpriteBottomTipView e;
    public sq6.e f;
    public boolean g;
    public String h;

    /* loaded from: classes6.dex */
    public static final class a implements SpriteBottomTipView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumFullPushDialogController a;
        public final /* synthetic */ FrsSpriteNewUserGuide b;

        public a(ForumFullPushDialogController forumFullPushDialogController, FrsSpriteNewUserGuide frsSpriteNewUserGuide) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumFullPushDialogController, frsSpriteNewUserGuide};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumFullPushDialogController;
            this.b = frsSpriteNewUserGuide;
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onBtnClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l(this.b.bubbleText);
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.l(this.b.bubbleText);
            }
        }
    }

    public ForumFullPushDialogController(Activity activity) {
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
        this.b = "FrsFullPushDialogController";
        this.c = 6000;
        this.d = new SpriteAnimationTipManager(this.a);
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
        jr6 a2 = lk5.a(FunnySpriteResDownloadUtil.i(str, "rush_res", true), false, 2);
        if (z) {
            str2 = "funny_sprite_show_day";
        } else {
            str2 = "funny_sprite_show_dark";
        }
        jr6 a3 = lk5.a(FunnySpriteResDownloadUtil.i(str2, "rush_res", true), true, 2);
        if (z) {
            str3 = "funny_sprite_exit_day";
        } else {
            str3 = "funny_sprite_exit_dark";
        }
        this.d.v(a2, a3, lk5.a(FunnySpriteResDownloadUtil.i(str3, "rush_res", true), false, 2));
        this.d.x(0, UtilHelper.getDimenPixelSize(R.dimen.tbds16), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds16));
        this.d.t(UtilHelper.getDimenPixelSize(R.dimen.tbds146), UtilHelper.getDimenPixelSize(R.dimen.tbds187));
        this.d.u(e());
        this.d.s(new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.helper.ForumFullPushDialogController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ForumFullPushDialogController this$0;

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
                    DefaultLog.getInstance().i(this.this$0.b, "精灵动画提示控件：隐藏全员推送动画结束");
                    this.this$0.p(false);
                    sq6.e h = this.this$0.h();
                    if (h != null) {
                        h.onDismiss();
                    }
                }
            }
        });
        this.d.w(new View.OnClickListener() { // from class: com.baidu.tieba.dk7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ForumFullPushDialogController.a(ForumFullPushDialogController.this, view2);
                }
            }
        });
    }

    public static final void a(ForumFullPushDialogController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            UrlManager.getInstance().dealOneLink(lk5.c("", 0, this$0.h));
        }
    }

    public final void d(FrsSpriteNewUserGuide frsSpriteNewUserGuide) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frsSpriteNewUserGuide) == null) {
            SpriteBottomTipView f = f(this.a, frsSpriteNewUserGuide);
            this.e = f;
            this.d.z(f);
        }
    }

    public final a g(FrsSpriteNewUserGuide frsSpriteNewUserGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, frsSpriteNewUserGuide)) == null) {
            return new a(this, frsSpriteNewUserGuide);
        }
        return (a) invokeL.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.h = str;
        }
    }

    public final void o(sq6.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g = z;
        }
    }

    public final FrameLayout.LayoutParams e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds95);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final sq6.e h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (sq6.e) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DefaultLog.getInstance().i(this.b, "精灵动画提示控件：隐藏全员推送");
            this.d.q();
            this.g = false;
            sq6.e eVar = this.f;
            if (eVar != null) {
                eVar.onDismiss();
            }
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.r("rush_res");
            SpriteBottomTipView spriteBottomTipView = this.e;
            if (spriteBottomTipView != null) {
                spriteBottomTipView.j(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final SpriteBottomTipView f(Activity activity, FrsSpriteNewUserGuide frsSpriteNewUserGuide) {
        InterceptResult invokeLL;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeColorInfo themeColorInfo2;
        ThemeElement themeElement2;
        ThemeColorInfo themeColorInfo3;
        ThemeElement themeElement3;
        ThemeColorInfo themeColorInfo4;
        ThemeElement themeElement4;
        FrsSpriteNewUserGuide.ButtonInfo buttonInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, frsSpriteNewUserGuide)) == null) {
            FrsSpriteNewUserGuide.BubbleText bubbleText = frsSpriteNewUserGuide.bubbleText;
            String str6 = (bubbleText == null || (buttonInfo = bubbleText.buttonInfo) == null || (str6 = buttonInfo.text) == null) ? "" : "";
            if (rd.isEmpty(str6)) {
                str6 = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1857);
                Intrinsics.checkNotNullExpressionValue(str6, "getInst().getString(R.string.view)");
            }
            SpriteBottomTipView.a aVar = new SpriteBottomTipView.a(activity);
            aVar.e(str6);
            FrsSpriteNewUserGuide.BubbleText bubbleText2 = frsSpriteNewUserGuide.bubbleText;
            String str7 = null;
            if (bubbleText2 != null) {
                str = bubbleText2.title;
            } else {
                str = null;
            }
            aVar.t(str);
            FrsSpriteNewUserGuide.BubbleText bubbleText3 = frsSpriteNewUserGuide.bubbleText;
            if (bubbleText3 != null) {
                str2 = bubbleText3.text;
            } else {
                str2 = null;
            }
            aVar.g(str2);
            FrsSpriteNewUserGuide.BubbleText bubbleText4 = frsSpriteNewUserGuide.bubbleText;
            if (bubbleText4 != null && (themeColorInfo4 = bubbleText4.iconTheme) != null && (themeElement4 = themeColorInfo4.day) != null) {
                str3 = themeElement4.pattern_image;
            } else {
                str3 = null;
            }
            aVar.n(str3);
            FrsSpriteNewUserGuide.BubbleText bubbleText5 = frsSpriteNewUserGuide.bubbleText;
            if (bubbleText5 != null && (themeColorInfo3 = bubbleText5.iconTheme) != null && (themeElement3 = themeColorInfo3.dark) != null) {
                str4 = themeElement3.pattern_image;
            } else {
                str4 = null;
            }
            aVar.l(str4);
            FrsSpriteNewUserGuide.BubbleText bubbleText6 = frsSpriteNewUserGuide.bubbleText;
            if (bubbleText6 != null && (themeColorInfo2 = bubbleText6.bgUrlTheme) != null && (themeElement2 = themeColorInfo2.day) != null) {
                str5 = themeElement2.pattern_image;
            } else {
                str5 = null;
            }
            aVar.c(str5);
            FrsSpriteNewUserGuide.BubbleText bubbleText7 = frsSpriteNewUserGuide.bubbleText;
            if (bubbleText7 != null && (themeColorInfo = bubbleText7.bgUrlTheme) != null && (themeElement = themeColorInfo.dark) != null) {
                str7 = themeElement.pattern_image;
            }
            aVar.b(str7);
            aVar.s(true);
            aVar.p(Integer.valueOf((int) R.drawable.funny_sprite_tip_bg_right));
            aVar.q(Integer.valueOf((int) R.drawable.funny_sprite_tip_bg_right));
            aVar.r(g(frsSpriteNewUserGuide));
            return aVar.a();
        }
        return (SpriteBottomTipView) invokeLL.objValue;
    }

    public final void l(FrsSpriteNewUserGuide.BubbleText bubbleText) {
        String str;
        FrsSpriteNewUserGuide.ButtonInfo buttonInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubbleText) == null) {
            if (bubbleText != null && (buttonInfo = bubbleText.buttonInfo) != null) {
                str = buttonInfo.schema;
            } else {
                str = null;
            }
            TbLog defaultLog = DefaultLog.getInstance();
            String str2 = this.b;
            defaultLog.e(str2, "精灵动画提示控件：气泡点击跳转，scheme" + str);
            if (StringUtils.isNotNull(str)) {
                UrlManager.getInstance().dealOneLink(str);
            }
            m(2);
            i();
        }
    }

    public final void m(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_FULL_PUSH_DAILOG_SHOW);
            statisticItem.addParam("obj_type", i);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            String str = this.h;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                statisticItem.addParam("fid", this.h);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void q(FrsSpriteNewUserGuide spriteBuddleData) {
        int i;
        Number valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, spriteBuddleData) == null) {
            Intrinsics.checkNotNullParameter(spriteBuddleData, "spriteBuddleData");
            DefaultLog.getInstance().i(this.b, "精灵动画提示控件：显示全员推送弹窗");
            d(spriteBuddleData);
            this.d.y(80);
            FrsSpriteNewUserGuide.BubbleText bubbleText = spriteBuddleData.bubbleText;
            if (bubbleText != null) {
                i = bubbleText.disappearSeconds;
            } else {
                i = 0;
            }
            if (i > 0) {
                valueOf = Long.valueOf(TimeUnit.SECONDS.toMillis(i));
            } else {
                valueOf = Integer.valueOf(this.c);
            }
            this.d.A(valueOf.longValue());
            this.d.B();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921769));
            this.g = true;
            m(1);
        }
    }
}
