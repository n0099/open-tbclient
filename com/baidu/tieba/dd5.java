package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.pc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class dd5<T extends pc5> extends ad5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd5(int i, String str, Class<T> cls) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof WriteCacheMessage)) {
                WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.a);
                WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                pc5 pc5Var = (pc5) a();
                if (pc5Var != null) {
                    if (pc5Var instanceof oc5) {
                        hv4.f();
                        cf<byte[]> e = hv4.e(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pc5 pc5Var2 = (pc5) writeCacheMessage.getData();
                            if (pc5Var2 == null) {
                                BdCacheService.k().j(e);
                            } else {
                                e.remove(pc5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pc5 pc5Var3 = (pc5) writeCacheMessage.getData();
                            if (pc5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            e.g(pc5Var3.getCacheKey(), ((oc5) pc5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (pc5Var instanceof rc5) {
                        hv4.f();
                        cf<String> h = hv4.h(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pc5 pc5Var4 = (pc5) writeCacheMessage.getData();
                            if (pc5Var4 == null) {
                                BdCacheService.k().j(h);
                            } else {
                                h.remove(pc5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pc5 pc5Var5 = (pc5) writeCacheMessage.getData();
                            if (pc5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String k = ((rc5) pc5Var5).k();
                            if (k != null) {
                                h.g(pc5Var5.getCacheKey(), k);
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
