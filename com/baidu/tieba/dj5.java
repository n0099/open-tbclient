package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.pi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dj5<T extends pi5> extends aj5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj5(int i, String str, Class<T> cls) {
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
                pi5 pi5Var = (pi5) a();
                if (pi5Var != null) {
                    if (pi5Var instanceof oi5) {
                        i05.d();
                        jf<byte[]> c = i05.c(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pi5 pi5Var2 = (pi5) writeCacheMessage.getData();
                            if (pi5Var2 == null) {
                                BdCacheService.n().l(c);
                            } else {
                                c.remove(pi5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pi5 pi5Var3 = (pi5) writeCacheMessage.getData();
                            if (pi5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            c.g(pi5Var3.getCacheKey(), ((oi5) pi5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (pi5Var instanceof ri5) {
                        i05.d();
                        jf<String> f = i05.f(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pi5 pi5Var4 = (pi5) writeCacheMessage.getData();
                            if (pi5Var4 == null) {
                                BdCacheService.n().l(f);
                            } else {
                                f.remove(pi5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pi5 pi5Var5 = (pi5) writeCacheMessage.getData();
                            if (pi5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String l = ((ri5) pi5Var5).l();
                            if (l != null) {
                                f.g(pi5Var5.getCacheKey(), l);
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
