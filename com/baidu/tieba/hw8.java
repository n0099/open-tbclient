package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.SpriteTypeWriterSwitch;
import com.baidu.tieba.impersonal.components.uistate.MsgEvents;
import com.baidu.tieba.impersonal.data.VoiceMsgContent;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hw8 {
    public static /* synthetic */ Interceptable $ic;
    public static final hw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947838240, "Lcom/baidu/tieba/hw8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947838240, "Lcom/baidu/tieba/hw8;");
                return;
            }
        }
        a = new hw8();
    }

    public hw8() {
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

    public final mc7<?> a(lx8 lx8Var, cw8<?> cw8Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{lx8Var, cw8Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = cw8Var.f();
            Class<?> cls = null;
            if (f instanceof dw8) {
                if (cw8Var.e().d()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                uv8 uv8Var = new uv8(cw8Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.getType() == 3 && z && !cw8Var.e().d()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                uv8Var.k(z2);
                uv8Var.h(MsgEvents.a.b(lx8Var));
                return uv8Var;
            } else if (f instanceof zv8) {
                return new tv8(cw8Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (cw8Var.e().d()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    vv8 vv8Var = new vv8(cw8Var, str2);
                    vv8Var.g(MsgEvents.a.a());
                    return vv8Var;
                } else if (f instanceof yv8) {
                    if (cw8Var.e().d()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new sv8(cw8Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = cw8Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (mc7) invokeCommon.objValue;
    }

    public final List<mc7<?>> b(lx8 repo, List<? extends xv8> list, SpriteMsgProcessor.e loadType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, repo, list, loadType)) == null) {
            Intrinsics.checkNotNullParameter(repo, "repo");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                xv8 xv8Var = (xv8) obj;
                if (xv8Var instanceof cw8) {
                    hw8 hw8Var = a;
                    cw8<?> cw8Var = (cw8) xv8Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    mc7<?> a2 = hw8Var.a(repo, cw8Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + xv8Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
