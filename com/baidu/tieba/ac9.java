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
public final class ac9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ac9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947610514, "Lcom/baidu/tieba/ac9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947610514, "Lcom/baidu/tieba/ac9;");
                return;
            }
        }
        a = new ac9();
    }

    public ac9() {
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

    public final sb7<?> a(gd9 gd9Var, vb9<?> vb9Var, SpriteMsgProcessor.e eVar, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{gd9Var, vb9Var, eVar, Boolean.valueOf(z)})) == null) {
            Object f = vb9Var.f();
            Class<?> cls = null;
            if (f instanceof wb9) {
                if (vb9Var.e().e()) {
                    str3 = "text_right";
                } else {
                    str3 = "text_left";
                }
                nb9 nb9Var = new nb9(vb9Var, str3);
                if (SpriteTypeWriterSwitch.Companion.isOn() && eVar.a() == 3 && z && !vb9Var.e().e()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                nb9Var.k(z2);
                nb9Var.h(MsgEvents.a.b(gd9Var));
                return nb9Var;
            } else if (f instanceof sb9) {
                return new mb9(vb9Var, "loading_left");
            } else {
                if (f instanceof VoiceMsgContent) {
                    if (vb9Var.e().e()) {
                        str2 = "voice_right";
                    } else {
                        str2 = "voice_left";
                    }
                    ob9 ob9Var = new ob9(vb9Var, str2);
                    ob9Var.g(MsgEvents.a.a());
                    return ob9Var;
                } else if (f instanceof rb9) {
                    if (vb9Var.e().e()) {
                        str = "image_right";
                    } else {
                        str = "image_left";
                    }
                    return new lb9(vb9Var, str);
                } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown msg content ");
                    Object f2 = vb9Var.f();
                    if (f2 != null) {
                        cls = f2.getClass();
                    }
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (sb7) invokeCommon.objValue;
    }

    public final List<sb7<?>> b(gd9 repo, List<? extends qb9> list, SpriteMsgProcessor.e loadType) {
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
                qb9 qb9Var = (qb9) obj;
                if (qb9Var instanceof vb9) {
                    ac9 ac9Var = a;
                    vb9<?> vb9Var = (vb9) qb9Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    sb7<?> a2 = ac9Var.a(repo, vb9Var, loadType, z);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + qb9Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
