package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hc5 extends ec5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc5(int i, String str, Class cls) {
        super(i, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage run(CustomMessage customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof WriteCacheMessage)) {
                WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.a);
                WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                tb5 tb5Var = (tb5) a();
                if (tb5Var != null) {
                    if (tb5Var instanceof sb5) {
                        ou4.f();
                        kf e = ou4.e(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            tb5 tb5Var2 = (tb5) writeCacheMessage.getData();
                            if (tb5Var2 == null) {
                                BdCacheService.k().j(e);
                            } else {
                                e.remove(tb5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            tb5 tb5Var3 = (tb5) writeCacheMessage.getData();
                            if (tb5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            e.g(tb5Var3.getCacheKey(), ((sb5) tb5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (tb5Var instanceof vb5) {
                        ou4.f();
                        kf h = ou4.h(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            tb5 tb5Var4 = (tb5) writeCacheMessage.getData();
                            if (tb5Var4 == null) {
                                BdCacheService.k().j(h);
                            } else {
                                h.remove(tb5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            tb5 tb5Var5 = (tb5) writeCacheMessage.getData();
                            if (tb5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String k = ((vb5) tb5Var5).k();
                            if (k != null) {
                                h.g(tb5Var5.getCacheKey(), k);
                                writeCacheRespMsg.setSuccess(true);
                            }
                        }
                    }
                }
                return writeCacheRespMsg;
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
