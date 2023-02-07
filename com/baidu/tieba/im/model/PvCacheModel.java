package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.dh;
import com.baidu.tieba.tg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PvCacheModel {
    public static /* synthetic */ Interceptable $ic;
    public static PvCacheModel mCacheModel;
    public transient /* synthetic */ FieldHolder $fh;
    public tg<String, String> mCache;

    public PvCacheModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCache = null;
        this.mCache = new tg<>(256);
    }

    public static synchronized PvCacheModel getInstance() {
        InterceptResult invokeV;
        PvCacheModel pvCacheModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (PvCacheModel.class) {
                if (mCacheModel == null) {
                    mCacheModel = new PvCacheModel();
                }
                pvCacheModel = mCacheModel;
            }
            return pvCacheModel;
        }
        return (PvCacheModel) invokeV.objValue;
    }

    public void addCacheData(String str, Long l) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, l) == null) && str != null && str.length() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            tg<String, String> tgVar = this.mCache;
            tgVar.h(currentAccount + str, String.valueOf(l));
        }
    }

    public boolean isSameDay(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null || str.length() <= 0) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            tg<String, String> tgVar = this.mCache;
            String f = tgVar.f(currentAccount + str);
            if (TextUtils.isEmpty(f)) {
                return false;
            }
            return UtilHelper.isSameDay(dh.g(f, 0L), System.currentTimeMillis());
        }
        return invokeL.booleanValue;
    }

    public void removeCacheData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && str != null && str.length() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            tg<String, String> tgVar = this.mCache;
            tgVar.i(currentAccount + str);
        }
    }
}
