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
public final class gq8 {
    public static /* synthetic */ Interceptable $ic;
    public static final gq8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802683, "Lcom/baidu/tieba/gq8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802683, "Lcom/baidu/tieba/gq8;");
                return;
            }
        }
        a = new gq8();
    }

    public gq8() {
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

    public final t87<?> a(jr8 jr8Var, bq8<?> bq8Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jr8Var, bq8Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = bq8Var.f();
            Class<?> cls = null;
            if (f instanceof cq8) {
                if (bq8Var.e().d()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                tp8 tp8Var = new tp8(bq8Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.getType() == 3 && z && !bq8Var.e().d()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                tp8Var.k(z2);
                tp8Var.h(MsgEvents.a.b(jr8Var));
                return tp8Var;
            } else if (f instanceof yp8) {
                return new sp8(bq8Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (bq8Var.e().d()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    up8 up8Var = new up8(bq8Var, str2);
                    up8Var.g(MsgEvents.a.a());
                    return up8Var;
                } else if (f instanceof xp8) {
                    if (bq8Var.e().d()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new rp8(bq8Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = bq8Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (t87) invokeCommon.objValue;
    }

    public final List<t87<?>> b(jr8 repo, List<? extends wp8> list, SpriteMsgProcessor.e loadType) {
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
                wp8 wp8Var = (wp8) obj;
                if (wp8Var instanceof bq8) {
                    gq8 gq8Var = a;
                    bq8<?> bq8Var = (bq8) wp8Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    t87<?> a2 = gq8Var.a(repo, bq8Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + wp8Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
