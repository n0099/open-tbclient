package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.ob5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cc5<T extends ob5> extends zb5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc5(int i, String str, Class<T> cls) {
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
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
                return null;
            }
            WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.a);
            WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            ob5 ob5Var = (ob5) a();
            if (ob5Var != null) {
                if (ob5Var instanceof nb5) {
                    mu4.f();
                    jf<byte[]> e = mu4.e(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        ob5 ob5Var2 = (ob5) writeCacheMessage.getData();
                        if (ob5Var2 == null) {
                            BdCacheService.k().j(e);
                        } else {
                            e.remove(ob5Var2.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        ob5 ob5Var3 = (ob5) writeCacheMessage.getData();
                        if (ob5Var3 == null) {
                            return writeCacheRespMsg;
                        }
                        e.g(ob5Var3.getCacheKey(), ((nb5) ob5Var3).toCacheByteArray());
                        writeCacheRespMsg.setSuccess(true);
                    }
                } else if (ob5Var instanceof qb5) {
                    mu4.f();
                    jf<String> h = mu4.h(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        ob5 ob5Var4 = (ob5) writeCacheMessage.getData();
                        if (ob5Var4 == null) {
                            BdCacheService.k().j(h);
                        } else {
                            h.remove(ob5Var4.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        ob5 ob5Var5 = (ob5) writeCacheMessage.getData();
                        if (ob5Var5 != null && (k = ((qb5) ob5Var5).k()) != null) {
                            h.g(ob5Var5.getCacheKey(), k);
                            writeCacheRespMsg.setSuccess(true);
                        }
                    }
                }
            }
            return writeCacheRespMsg;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
