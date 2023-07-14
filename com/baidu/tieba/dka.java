package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.du6;
import com.baidu.tieba.f65;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
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
public final class dka extends f65 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public static long g;
    public transient /* synthetic */ FieldHolder $fh;
    public final SpriteTipHttpResponseMessage c;
    public final HomePageSpriteBottomTipView d;
    public final du6.e e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947708815, "Lcom/baidu/tieba/dka;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947708815, "Lcom/baidu/tieba/dka;");
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
            return dka.g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dka(Activity activity, SpriteTipHttpResponseMessage data, HomePageSpriteBottomTipView tipView, du6.e eVar) {
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

    public /* synthetic */ dka(Activity activity, SpriteTipHttpResponseMessage spriteTipHttpResponseMessage, HomePageSpriteBottomTipView homePageSpriteBottomTipView, du6.e eVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, spriteTipHttpResponseMessage, homePageSpriteBottomTipView, (i & 8) != 0 ? null : eVar);
    }

    @Override // com.baidu.tieba.f65
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            du6.e eVar = this.e;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this.d.e();
        }
    }

    @Override // com.baidu.tieba.f65
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.f();
            du6.e eVar = this.e;
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

    public static final void i(dka this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            du6.e eVar = this$0.e;
            if (eVar != null) {
                eVar.onDismiss();
            }
            this$0.c();
        }
    }

    @Override // com.baidu.tieba.f65
    public void d(f65.a shouldShowCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shouldShowCallback) == null) {
            Intrinsics.checkNotNullParameter(shouldShowCallback, "shouldShowCallback");
            if (kia.h.a().f()) {
                if (h()) {
                    s8a.b.a().c(this.c);
                }
                DefaultLog.getInstance().b("SpriteTip", "not show Tip because home easter egg is showing");
                shouldShowCallback.callback(false);
            } else if (h()) {
                shouldShowCallback.callback(true);
            } else {
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.b("SpriteTip", "not show Tip switch:" + FunnySpriteSwitch.Companion.isOn() + " isAllResExist:" + FunnySpriteResDownloadUtil.k().invoke().booleanValue() + " canShowSpriteAndTip:" + HomeSpriteEdgeFloatManager.l.b());
                shouldShowCallback.callback(false);
            }
        }
    }

    @Override // com.baidu.tieba.f65
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (2 == kia.h.a().b().a().c && 1 == kia.h.a().b().b().c && 6 == kia.h.a().b().c().c) {
                DefaultLog.getInstance().c("SpriteTip", "show responseTip：直播tab不展示轻互动");
                c();
                return;
            }
            h29 defaultLog = DefaultLog.getInstance();
            defaultLog.c("SpriteTip", "show responseTip:" + this.c.getText());
            g = System.currentTimeMillis();
            String w = da5.p().w("key_sprite_speech_version", "");
            String version = this.c.getVersion();
            if (!TextUtils.isEmpty(version) && !Intrinsics.areEqual(w, version)) {
                da5.p().J("key_sprite_speech_version", version);
            }
            this.d.setDataAndShow(this.c, new du6.e() { // from class: com.baidu.tieba.bka
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.du6.e
                public final void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        dka.i(dka.this);
                    }
                }
            });
        }
    }
}
