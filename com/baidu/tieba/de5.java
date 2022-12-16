package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.pd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class de5<T extends pd5> extends ae5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de5(int i, String str, Class<T> cls) {
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
                pd5 pd5Var = (pd5) a();
                if (pd5Var != null) {
                    if (pd5Var instanceof od5) {
                        kv4.f();
                        df<byte[]> e = kv4.e(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pd5 pd5Var2 = (pd5) writeCacheMessage.getData();
                            if (pd5Var2 == null) {
                                BdCacheService.n().l(e);
                            } else {
                                e.remove(pd5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pd5 pd5Var3 = (pd5) writeCacheMessage.getData();
                            if (pd5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            e.g(pd5Var3.getCacheKey(), ((od5) pd5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (pd5Var instanceof rd5) {
                        kv4.f();
                        df<String> h = kv4.h(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pd5 pd5Var4 = (pd5) writeCacheMessage.getData();
                            if (pd5Var4 == null) {
                                BdCacheService.n().l(h);
                            } else {
                                h.remove(pd5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pd5 pd5Var5 = (pd5) writeCacheMessage.getData();
                            if (pd5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String l = ((rd5) pd5Var5).l();
                            if (l != null) {
                                h.g(pd5Var5.getCacheKey(), l);
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
