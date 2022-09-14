package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class f85 {
    public static /* synthetic */ Interceptable $ic;
    public static f85 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Class<? extends e85>> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718022, "Lcom/baidu/tieba/f85;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718022, "Lcom/baidu/tieba/f85;");
                return;
            }
        }
        b = new f85();
    }

    public f85() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        f(g85.class);
        f(i85.class);
        f(d85.class);
        f(h85.class);
        f(j85.class);
    }

    public static f85 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (f85) invokeV.objValue;
    }

    public e85 a(ImageOperation imageOperation) {
        InterceptResult invokeL;
        e85 e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageOperation)) == null) {
            Class<? extends e85> cls = this.a.get(imageOperation.actionName);
            if (cls == null || (e = e(cls)) == null) {
                return null;
            }
            e.d(imageOperation.actionParam);
            return e;
        }
        return (e85) invokeL.objValue;
    }

    public Bitmap b(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Boolean.valueOf(z), list, imageFileInfo})) == null) {
            if (bitmap == null || ListUtils.isEmpty(list)) {
                return bitmap;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                e85 a = a(list.get(i));
                if ((a instanceof j85) && imageFileInfo != null) {
                    ((j85) a).e(imageFileInfo.getFilePath());
                    return a.b(bitmap, z);
                }
            }
            g85 g85Var = null;
            int i2 = 0;
            while (i2 < size) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    g85 g85Var2 = (g85) a(imageOperation);
                    if (g85Var == null || g85Var2.f() <= g85Var.f() || g85Var2.e() <= g85Var.e()) {
                        g85Var = g85Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            Bitmap b2 = g85Var != null ? g85Var.b(bitmap, z) : null;
            if (list != null) {
                for (int i3 = 0; i3 < size; i3++) {
                    e85 a2 = a(list.get(i3));
                    if (a2 != null) {
                        if (b2 == null) {
                            return null;
                        }
                        b2 = a2.b(bitmap, z);
                    }
                }
            }
            return b2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public Bitmap c(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, imageFileInfo)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                e85 a = a(list.get(i));
                if ((a instanceof j85) && imageFileInfo != null) {
                    return a.c(imageFileInfo.getFilePath());
                }
            }
            g85 g85Var = null;
            int i2 = 0;
            while (i2 < list.size()) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    g85 g85Var2 = (g85) a(imageOperation);
                    if (g85Var == null || g85Var2.f() <= g85Var.f() || g85Var2.e() <= g85Var.e()) {
                        g85Var = g85Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            Bitmap c = g85Var != null ? g85Var.c(str) : null;
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    e85 a2 = a(list.get(i3));
                    if (a2 != null) {
                        if (c == null) {
                            c = a2.c(str);
                        } else {
                            c = a2.b(c, true);
                        }
                    }
                }
            }
            return c;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public final e85 e(Class<? extends e85> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (e85) invokeL.objValue;
    }

    public final void f(Class<? extends e85> cls) {
        e85 e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cls) == null) || (e = e(cls)) == null) {
            return;
        }
        this.a.put(e.a(), cls);
    }
}
