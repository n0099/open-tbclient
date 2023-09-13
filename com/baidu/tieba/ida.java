package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes6.dex */
public class ida implements t65 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947851043, "Lcom/baidu/tieba/ida;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947851043, "Lcom/baidu/tieba/ida;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ida idaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {idaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !ida.a) {
                try {
                    Class.forName("com.baidu.tieba.homepage.framework.RecommendFrsStatic");
                } catch (Exception e) {
                    BdLog.i(e.getMessage());
                }
                DefaultLog.getInstance().i("SpriteTip", "展示动画时首次请求");
                co5.i(1);
                boolean unused = ida.a = true;
            }
        }
    }

    public ida() {
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

    @Override // com.baidu.tieba.t65
    @NonNull
    public Map<String, Object> a(@NonNull DialogStrategiesData dialogStrategiesData, @NonNull Map<String, Object> map, @NonNull Map<String, Object> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogStrategiesData, map, map2)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.putAll(map2);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.t65
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                YunDialogLog.getInstance().e("SpriteStrategy", "未登录状态");
                return false;
            } else if (!FunnySpriteSwitch.isOn()) {
                YunDialogLog.getInstance().e("SpriteStrategy", "精灵开关未打开");
                return false;
            } else {
                Object obj = map.get("use_hot");
                if (obj != null && "1".equals(obj.toString())) {
                    Object obj2 = map.get("dialog_url");
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (!TextUtils.isEmpty(str) && !yy5.b().e(str)) {
                            YunDialogLog.getInstance().e("SpriteStrategy", "H5弹窗未预热完成");
                            return false;
                        }
                    }
                }
                if (!FunnySpriteResDownloadUtil.k().invoke().booleanValue()) {
                    YunDialogLog.getInstance().e("SpriteStrategy", "资源未下载完成");
                    return false;
                }
                Object obj3 = map.get("use_offline");
                if (obj3 != null && "1".equals(obj3.toString())) {
                    Object obj4 = map.get("dialog_url");
                    if (obj4 instanceof String) {
                        String str2 = (String) obj4;
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                Object obj5 = map.get("module");
                                TbLog yunDialogLog = YunDialogLog.getInstance();
                                yunDialogLog.i("SpriteStrategy", "开始手动初始化离线包:" + obj5);
                                if ((obj5 instanceof String) && !TextUtils.isEmpty((String) obj5)) {
                                    HashSet hashSet = new HashSet();
                                    hashSet.add((String) obj5);
                                    jz4.d(hashSet);
                                    TbLog yunDialogLog2 = YunDialogLog.getInstance();
                                    yunDialogLog2.i("SpriteStrategy", "离线包手动初始化完成:" + obj5);
                                }
                            } catch (Exception e) {
                                TbLog yunDialogLog3 = YunDialogLog.getInstance();
                                yunDialogLog3.e("SpriteStrategy", "离线包手动初始化异常:" + e);
                            }
                            boolean c = jz4.c(str2);
                            TbLog yunDialogLog4 = YunDialogLog.getInstance();
                            yunDialogLog4.e("SpriteStrategy", "离线包是否可用:" + c);
                            if (!c) {
                                YunDialogLog.getInstance().e("SpriteStrategy", "离线包未下载完成");
                                return false;
                            }
                        }
                    }
                }
                hu6.b().b(new hca());
                TbSingleton.getInstance().isShowSpriteDialog = true;
                SafeHandler.getInst().post(new a(this));
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
