package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.mq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ar5<T extends mq5> extends xq5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar5(int i, String str, Class<T> cls) {
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
                mq5 mq5Var = (mq5) a();
                if (mq5Var != null) {
                    if (mq5Var instanceof lq5) {
                        b55.d();
                        we<byte[]> c = b55.c(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            mq5 mq5Var2 = (mq5) writeCacheMessage.getData();
                            if (mq5Var2 == null) {
                                BdCacheService.n().l(c);
                            } else {
                                c.remove(mq5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            mq5 mq5Var3 = (mq5) writeCacheMessage.getData();
                            if (mq5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            c.g(mq5Var3.getCacheKey(), ((lq5) mq5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (mq5Var instanceof oq5) {
                        b55.d();
                        we<String> f = b55.f(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            mq5 mq5Var4 = (mq5) writeCacheMessage.getData();
                            if (mq5Var4 == null) {
                                BdCacheService.n().l(f);
                            } else {
                                f.remove(mq5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            mq5 mq5Var5 = (mq5) writeCacheMessage.getData();
                            if (mq5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String t = ((oq5) mq5Var5).t();
                            if (t != null) {
                                f.g(mq5Var5.getCacheKey(), t);
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
