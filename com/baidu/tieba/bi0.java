package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class bi0 implements ci0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] c;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ci0
    public String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements fi0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ di0 b;

        public a(bi0 bi0Var, boolean[] zArr, di0 di0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi0Var, zArr, di0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zArr;
            this.b = di0Var;
        }

        @Override // com.baidu.tieba.fi0
        public void onResult(boolean z) {
            di0 di0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a[0] = z;
                if (z && (di0Var = this.b) != null) {
                    di0Var.a(z, null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947645792, "Lcom/baidu/tieba/bi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947645792, "Lcom/baidu/tieba/bi0;");
                return;
            }
        }
        c = new String[]{BaiduIdentityManager.VALUE_OSNAME, "com.baidu.nani", "com.baidu.tieba", "bdminivideo", "xifan", "baidumap", "bdnetdisk", "askmybaby", "baiduboxmission", ThirdPartyUtil.TYPE_WEIXIN, "baiduboxlite", "baiduhaokan", "market", "samsungapps", "duxiaomanloan", "bdbook", "baiduime", "bdwenku", "iqiyi", "bdvideo", "zhidao", "mimarket", "appmarket", "oppomarket", "vivomarket", "youa", "com.tencent.mm", "gamenow", "flowlocal", "yykiwi", "baiduboxvision", "lemon", "duxiaoxiaoapp", "youjia", "bdwkst", "alipays", "bddrama", "comjia", "ctrip", "imeituan", "lianjia", "lianjiabeike", "meituanwaimai", "momochat", "openanjuke", "openapp.jdmobile", "openapp.jdpingou", "openjdlite", "pddopen", "pinduoduo", "qunaraphone", "suning", "tbopen", "vipshop", "vmall", "wbmain", "youku", "miyabaobei", "mogujie", "taobao"};
    }

    public bi0() {
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

    @Override // com.baidu.tieba.ci0
    public boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable di0 di0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, map, di0Var)) == null) {
            boolean[] zArr = new boolean[1];
            hi0.a(context, str, null, new a(this, zArr, di0Var), true);
            return zArr[0];
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ci0
    public void b(String str, String str2, fi0 fi0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, fi0Var) == null) && fi0Var != null) {
            fi0Var.onResult(true);
        }
    }

    @Override // com.baidu.tieba.ci0
    public boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : c) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
