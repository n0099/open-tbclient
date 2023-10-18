package com.baidu.tbadk.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.pk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CookieHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.tbadk.util.CookieHelper$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 extends HashMap<String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Pair val$pair;

        public AnonymousClass1(Pair pair) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pair};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.val$pair = pair;
            Pair pair2 = this.val$pair;
            put((String) pair2.first, (String) pair2.second);
        }
    }

    @Nullable
    public static Pair<String, String> a() {
        InterceptResult invokeV;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b = currentAccountInfo.getBDUSS();
            } else {
                if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                    b = pk5.b();
                }
                return null;
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b)) {
                AccountData activeAccountData = AccountStorage.getActiveAccountData();
                if (activeAccountData == null) {
                    return null;
                }
                b = activeAccountData.getBDUSS();
            }
            if (!TextUtils.isEmpty(b)) {
                return Pair.create(HttpRequest.BDUSS, b);
            }
            return null;
        }
        return (Pair) invokeV.objValue;
    }

    @NonNull
    public static Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap<String, String> hashMap = new HashMap<String, String>(a()) { // from class: com.baidu.tbadk.util.CookieHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Pair val$pair;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$pair = r6;
                    Pair pair = this.val$pair;
                    if (pair != null) {
                        put((String) pair.first, (String) pair.second);
                    }
                }
            };
            hashMap.put("BAIDUID", TbSingleton.getInstance().getBaiduIdForAnti());
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
