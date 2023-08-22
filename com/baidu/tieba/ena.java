package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.h55;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.us6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ena extends h55 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public static long g;
    public transient /* synthetic */ FieldHolder $fh;
    public final SpriteTipHttpResponseMessage c;
    public final HomePageSpriteBottomTipView d;
    public final us6.e e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947741489, "Lcom/baidu/tieba/ena;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947741489, "Lcom/baidu/tieba/ena;");
                return;
            }
        }
        f = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.longValue;
            }
            return ena.g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ena(Activity activity, SpriteTipHttpResponseMessage data, HomePageSpriteBottomTipView tipView, us6.e eVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, data, tipView, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(tipView, "tipView");
        this.c = data;
        this.d = tipView;
        this.e = eVar;
    }

    public /* synthetic */ ena(Activity activity, SpriteTipHttpResponseMessage spriteTipHttpResponseMessage, HomePageSpriteBottomTipView homePageSpriteBottomTipView, us6.e eVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, spriteTipHttpResponseMessage, homePageSpriteBottomTipView, (i & 8) != 0 ? null : eVar);
    }

    @Override // com.baidu.tieba.h55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            us6.e eVar = this.e;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d.e();
        }
    }

    @Override // com.baidu.tieba.h55
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.f();
            us6.e eVar = this.e;
            if (eVar != null) {
                eVar.onDismiss();
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.isSuccess() && this.c.getScene() != 2 && HomeSpriteEdgeFloatManager.l.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final void i(ena this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            us6.e eVar = this$0.e;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this$0.c();
        }
    }

    @Override // com.baidu.tieba.h55
    public void d(h55.a shouldShowCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shouldShowCallback) == null) {
            Intrinsics.checkNotNullParameter(shouldShowCallback, "shouldShowCallback");
            if (!lla.i.a().f() && !lla.i.a().i()) {
                if (h()) {
                    shouldShowCallback.callback(true);
                    return;
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("SpriteTip", "not show Tip switch:" + FunnySpriteSwitch.Companion.isOn() + " isAllResExist:" + FunnySpriteResDownloadUtil.k().invoke().booleanValue() + " canShowSpriteAndTip:" + HomeSpriteEdgeFloatManager.l.b());
                shouldShowCallback.callback(false);
                return;
            }
            if (h()) {
                tba.b.a().c(this.c);
            }
            DefaultLog.getInstance().e("SpriteTip", "not show Tip because home easter egg is showing");
            shouldShowCallback.callback(false);
        }
    }

    @Override // com.baidu.tieba.h55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (2 == lla.i.a().b().a().c && 1 == lla.i.a().b().b().c && 6 == lla.i.a().b().c().c) {
                DefaultLog.getInstance().i("SpriteTip", "show responseTip：直播tab不展示轻互动");
                c();
                return;
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("SpriteTip", "show responseTip:" + this.c.getText());
            g = System.currentTimeMillis();
            String string = SharedPrefHelper.getInstance().getString("key_sprite_speech_version", "");
            String version = this.c.getVersion();
            if (!TextUtils.isEmpty(version) && !Intrinsics.areEqual(string, version)) {
                SharedPrefHelper.getInstance().putString("key_sprite_speech_version", version);
            }
            this.d.setDataAndShow(this.c, new us6.e() { // from class: com.baidu.tieba.cna
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.us6.e
                public final void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ena.i(ena.this);
                    }
                }
            });
        }
    }
}
