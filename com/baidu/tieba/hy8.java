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
public final class hy8 {
    public static /* synthetic */ Interceptable $ic;
    public static final hy8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947840162, "Lcom/baidu/tieba/hy8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947840162, "Lcom/baidu/tieba/hy8;");
                return;
            }
        }
        a = new hy8();
    }

    public hy8() {
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

    public final jb7<?> a(lz8 lz8Var, cy8<?> cy8Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{lz8Var, cy8Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = cy8Var.f();
            Class<?> cls = null;
            if (f instanceof dy8) {
                if (cy8Var.e().d()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                ux8 ux8Var = new ux8(cy8Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.getType() == 3 && z && !cy8Var.e().d()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ux8Var.k(z2);
                ux8Var.h(MsgEvents.a.b(lz8Var));
                return ux8Var;
            } else if (f instanceof zx8) {
                return new tx8(cy8Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (cy8Var.e().d()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    vx8 vx8Var = new vx8(cy8Var, str2);
                    vx8Var.g(MsgEvents.a.a());
                    return vx8Var;
                } else if (f instanceof yx8) {
                    if (cy8Var.e().d()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new sx8(cy8Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = cy8Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (jb7) invokeCommon.objValue;
    }

    public final List<jb7<?>> b(lz8 repo, List<? extends xx8> list, SpriteMsgProcessor.e loadType) {
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
                xx8 xx8Var = (xx8) obj;
                if (xx8Var instanceof cy8) {
                    hy8 hy8Var = a;
                    cy8<?> cy8Var = (cy8) xx8Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    jb7<?> a2 = hy8Var.a(repo, cy8Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + xx8Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
