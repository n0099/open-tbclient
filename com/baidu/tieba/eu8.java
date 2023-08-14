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
/* loaded from: classes5.dex */
public final class eu8 {
    public static /* synthetic */ Interceptable $ic;
    public static final eu8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746945, "Lcom/baidu/tieba/eu8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746945, "Lcom/baidu/tieba/eu8;");
                return;
            }
        }
        a = new eu8();
    }

    public eu8() {
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

    public final v97<?> a(iv8 iv8Var, zt8<?> zt8Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{iv8Var, zt8Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = zt8Var.f();
            Class<?> cls = null;
            if (f instanceof au8) {
                if (zt8Var.e().d()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                rt8 rt8Var = new rt8(zt8Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.getType() == 3 && z && !zt8Var.e().d()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                rt8Var.k(z2);
                rt8Var.h(MsgEvents.a.b(iv8Var));
                return rt8Var;
            } else if (f instanceof wt8) {
                return new qt8(zt8Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (zt8Var.e().d()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    st8 st8Var = new st8(zt8Var, str2);
                    st8Var.g(MsgEvents.a.a());
                    return st8Var;
                } else if (f instanceof vt8) {
                    if (zt8Var.e().d()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new pt8(zt8Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = zt8Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (v97) invokeCommon.objValue;
    }

    public final List<v97<?>> b(iv8 repo, List<? extends ut8> list, SpriteMsgProcessor.e loadType) {
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
                ut8 ut8Var = (ut8) obj;
                if (ut8Var instanceof zt8) {
                    eu8 eu8Var = a;
                    zt8<?> zt8Var = (zt8) ut8Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    v97<?> a2 = eu8Var.a(repo, zt8Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + ut8Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
