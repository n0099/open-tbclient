package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tbadk.dispatcher.OpenWebViewDispatcher;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.push.PushSceneItem;
import com.baidu.tieba.push.guide.DialogParamProvider;
import com.baidu.tieba.push.guide.Scene;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class cga implements DialogParamProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final Map<String, Method> c;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;

    public abstract boolean c();

    public abstract String h();

    @JvmOverloads
    public final boolean j(TbPageContext<?> pageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pageContext)) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            return l(this, pageContext, null, 2, null);
        }
        return invokeL.booleanValue;
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

        public final Map<String, Object> a(DialogParamProvider provider, List<String> paramKeyList) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, provider, paramKeyList)) == null) {
                Intrinsics.checkNotNullParameter(provider, "provider");
                Intrinsics.checkNotNullParameter(paramKeyList, "paramKeyList");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : paramKeyList) {
                    Method method = (Method) cga.c.get(str);
                    if (method != null) {
                        try {
                            Object invoke = method.invoke(provider, new Object[0]);
                            if (invoke != null) {
                                linkedHashMap.put(str, invoke);
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return linkedHashMap;
            }
            return (Map) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements wu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TbPageContext<?> a;
        public final cga b;

        @Override // com.baidu.tieba.wu4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(TbPageContext<?> pageContext, cga pushGuide) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pageContext, pushGuide};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(pushGuide, "pushGuide");
            this.a = pageContext;
            this.b = pushGuide;
        }

        @Override // com.baidu.tieba.wu4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.a.getPageActivity();
                String h = this.b.h();
                int a = Scene.c.a(h);
                if (!this.b.c() && a >= 0) {
                    new MsgRemindModel(this.a).T(a, Scene.c.b(h), null);
                }
                if (!this.b.b()) {
                    DialogUtil.jumpSystemNotificationSetting(pageActivity);
                } else {
                    PushOpenUtil.showPushPermissionSucToast(pageActivity);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947675180, "Lcom/baidu/tieba/cga;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947675180, "Lcom/baidu/tieba/cga;");
                return;
            }
        }
        b = new a(null);
        c = new LinkedHashMap();
        Method[] declaredMethods = DialogParamProvider.class.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "DialogParamProvider::class.java.declaredMethods");
        for (Method it : declaredMethods) {
            ega egaVar = (ega) it.getAnnotation(ega.class);
            if (egaVar != null) {
                Map<String, Method> map = c;
                String paramKey = egaVar.paramKey();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                map.put(paramKey, it);
            }
        }
    }

    public cga() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return PushGuideManager.d();
        }
        return invokeV.booleanValue;
    }

    public final Object d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PushSceneItem l = PushGuideManager.l(h());
            if (l != null) {
                return l.isHitNewStyle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PushGuideManager.m(h());
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (c() && b()) {
                z = false;
            } else {
                z = true;
            }
            if (!z || !PushGuideManager.e(h())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    @ega(paramKey = "forum_icon")
    public String provideForumIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return DialogParamProvider.a.a(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    @ega(paramKey = "forum_id")
    public String provideForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return DialogParamProvider.a.b(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    @ega(paramKey = "forum_name")
    public String provideForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return DialogParamProvider.a.c(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    @ega(paramKey = "forum_slogan")
    public String provideForumSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return DialogParamProvider.a.d(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    public String provideNickname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String m = sv4.t().m();
            if (m == null) {
                return "";
            }
            return m;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    public String providePortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String r = sv4.t().r();
            if (r == null) {
                return "";
            }
            return r;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    @ega(paramKey = "thread_abstract")
    public String provideThreadAbstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return DialogParamProvider.a.e(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    @ega(paramKey = "thread_id")
    public String provideThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return DialogParamProvider.a.f(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    @ega(paramKey = MissonDetailsActivityConfig.THREAD_TITLE)
    public String provideThreadTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return DialogParamProvider.a.g(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.push.guide.DialogParamProvider
    public String provideUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String h = sv4.t().h();
            if (h == null) {
                return "";
            }
            return h;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.cga */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean l(cga cgaVar, TbPageContext tbPageContext, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return cgaVar.k(tbPageContext, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryShow");
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.a = obj;
        }
    }

    @JvmOverloads
    public boolean k(TbPageContext<?> pageContext, Function0<Unit> function0) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, pageContext, function0)) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            if (!i() || pageContext.getPageActivity() == null) {
                return false;
            }
            if (!m()) {
                if (function0 != null) {
                    function0.invoke();
                    return true;
                }
                PushOpenUtil.showPushPermissionDialogV2(pageContext, h(), new b(pageContext, this));
                g();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String h = h();
            String i = PushGuideManager.a.i(h);
            if (i == null) {
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && !YunDialogManager.isShowingDialog()) {
                PushSceneItem l = PushGuideManager.l(h);
                if (l != null) {
                    String appendParam = UrlUtils.appendParam(i, "params", dx.a(DataExt.toJson(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("title", l.getTitle()), TuplesKt.to("text", l.getText()), TuplesKt.to("scene_name", h), TuplesKt.to(WebChromeClient.KEY_ARG_ARRAY, b.a(this, l.getDialogParams()))))));
                    Intrinsics.checkNotNullExpressionValue(appendParam, "appendParam(\n           …s.toJson())\n            )");
                    String assembleH5DialogSchemaUrl = OpenWebViewDispatcher.assembleH5DialogSchemaUrl(appendParam, "push_guide_h5_dialog");
                    Intrinsics.checkNotNullExpressionValue(assembleH5DialogSchemaUrl, "assembleH5DialogSchemaUr…_h5_dialog\"\n            )");
                    UrlManager.getInstance().dealOneLink(assembleH5DialogSchemaUrl);
                    g();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
