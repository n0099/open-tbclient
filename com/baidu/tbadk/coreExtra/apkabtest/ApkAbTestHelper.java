package com.baidu.tbadk.coreExtra.apkabtest;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes5.dex */
public class ApkAbTestHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APK_AB_TEST_FILE_NAME = "apk_ab_test.txt";
    public static final String APK_AB_TEST_KEY = "pub_env";
    public static final int PUB_ENV_VALUE_PREVIEW = 1;
    public static final int PUB_ENV_VALUE_SMALLFLOW = 2;
    public static volatile ApkAbTestHelper mApkAbTestInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsTarget;
    public int mPubEnvValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071271615, "Lcom/baidu/tbadk/coreExtra/apkabtest/ApkAbTestHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071271615, "Lcom/baidu/tbadk/coreExtra/apkabtest/ApkAbTestHelper;");
        }
    }

    public ApkAbTestHelper() {
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
        this.mIsTarget = false;
        this.mPubEnvValue = 0;
        try {
            y6 y6Var = new y6("", APK_AB_TEST_FILE_NAME, DiskFileOperate.Action.READ);
            y6Var.setSdCard(true);
            y6Var.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (y6Var.call()) {
                String a = y6Var.a();
                if (a != null) {
                    this.mPubEnvValue = Integer.parseInt(a);
                }
                if (this.mPubEnvValue == 1 || this.mPubEnvValue == 2) {
                    this.mIsTarget = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static ApkAbTestHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mApkAbTestInstance == null) {
                synchronized (ApkAbTestHelper.class) {
                    if (mApkAbTestInstance == null) {
                        mApkAbTestInstance = new ApkAbTestHelper();
                    }
                }
            }
            return mApkAbTestInstance;
        }
        return (ApkAbTestHelper) invokeV.objValue;
    }

    public String getCookieStringIfAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "pub_env=" + this.mPubEnvValue + ParamableElem.DIVIDE_PARAM;
            if (!this.mIsTarget) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int getPubEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mPubEnvValue;
        }
        return invokeV.intValue;
    }

    public boolean isTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mIsTarget;
        }
        return invokeV.booleanValue;
    }
}
