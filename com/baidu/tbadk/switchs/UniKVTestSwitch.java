package com.baidu.tbadk.switchs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.io.FileUtils;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@ModifyClass
/* loaded from: classes4.dex */
public class UniKVTestSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILE_DOUBLE_KV = "swankv_double_kv.txt";
    public static final String FILE_KV = "swankv_kv.txt";
    public static final String FILE_SP = "swankv_sp.txt";
    public static final int TYPE_DOUBLE_KV = 1;
    public static final int TYPE_KV = 2;
    public static final int TYPE_SP = 0;
    public static final String UNI_KV_TEST_ENABLE = "uni_kv_test_switch_12_43";
    public static volatile int type = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2063199955, "Lcom/baidu/tbadk/switchs/UniKVTestSwitch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2063199955, "Lcom/baidu/tbadk/switchs/UniKVTestSwitch;");
        }
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.ef
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? UNI_KV_TEST_ENABLE : (String) invokeV.objValue;
    }

    public UniKVTestSwitch() {
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

    public static boolean isTypeDoubleKv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (getType() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isTypeKv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isTypeSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (getType() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "测试KV的开关", type = 100)
    public static synchronized int getType() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (UniKVTestSwitch.class) {
                if (type > 2) {
                    String str = BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_DOUBLE_KV;
                    String str2 = BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_KV;
                    if (FileUtils.exists(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_SP)) {
                        type = 0;
                    } else if (FileUtils.exists(str)) {
                        type = 1;
                    } else if (FileUtils.exists(str2)) {
                        type = 2;
                    } else {
                        type = 0;
                    }
                }
                i = type;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public static synchronized void saveType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            synchronized (UniKVTestSwitch.class) {
                try {
                    if (i == 0) {
                        FileUtils.createFileSafely(new File(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_SP));
                        FileUtils.deleteFile(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_DOUBLE_KV);
                        FileUtils.deleteFile(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_KV);
                    } else if (i == 1) {
                        FileUtils.createFileSafely(new File(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_DOUBLE_KV));
                        FileUtils.deleteFile(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_SP);
                        FileUtils.deleteFile(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_KV);
                    } else if (i == 2) {
                        FileUtils.createFileSafely(new File(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_KV));
                        FileUtils.deleteFile(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_DOUBLE_KV);
                        FileUtils.deleteFile(BdBaseApplication.getInst().getFilesDir() + File.separator + FILE_SP);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
