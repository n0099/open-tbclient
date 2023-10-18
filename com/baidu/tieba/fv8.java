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
public final class fv8 {
    public static /* synthetic */ Interceptable $ic;
    public static final fv8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777697, "Lcom/baidu/tieba/fv8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777697, "Lcom/baidu/tieba/fv8;");
                return;
            }
        }
        a = new fv8();
    }

    public fv8() {
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

    public final h77<?> a(jw8 jw8Var, av8<?> av8Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jw8Var, av8Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = av8Var.f();
            Class<?> cls = null;
            if (f instanceof bv8) {
                if (av8Var.e().e()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                su8 su8Var = new su8(av8Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.a() == 3 && z && !av8Var.e().e()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                su8Var.k(z2);
                su8Var.h(MsgEvents.a.b(jw8Var));
                return su8Var;
            } else if (f instanceof xu8) {
                return new ru8(av8Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (av8Var.e().e()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    tu8 tu8Var = new tu8(av8Var, str2);
                    tu8Var.g(MsgEvents.a.a());
                    return tu8Var;
                } else if (f instanceof wu8) {
                    if (av8Var.e().e()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new qu8(av8Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = av8Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (h77) invokeCommon.objValue;
    }

    public final List<h77<?>> b(jw8 repo, List<? extends vu8> list, SpriteMsgProcessor.e loadType) {
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
                vu8 vu8Var = (vu8) obj;
                if (vu8Var instanceof av8) {
                    fv8 fv8Var = a;
                    av8<?> av8Var = (av8) vu8Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    h77<?> a2 = fv8Var.a(repo, av8Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + vu8Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
