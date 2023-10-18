package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.wl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gm5<T extends wl5> extends dm5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm5(int i, String str, Class<T> cls) {
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
                wl5 wl5Var = (wl5) a();
                if (wl5Var != null) {
                    if (wl5Var instanceof vl5) {
                        gz4.k();
                        m9<byte[]> j = gz4.j(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            wl5 wl5Var2 = (wl5) writeCacheMessage.getData();
                            if (wl5Var2 == null) {
                                BdCacheService.o().m(j);
                            } else {
                                j.remove(wl5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            wl5 wl5Var3 = (wl5) writeCacheMessage.getData();
                            if (wl5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            j.g(wl5Var3.getCacheKey(), ((vl5) wl5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (wl5Var instanceof yl5) {
                        gz4.k();
                        m9<String> m = gz4.m(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            wl5 wl5Var4 = (wl5) writeCacheMessage.getData();
                            if (wl5Var4 == null) {
                                BdCacheService.o().m(m);
                            } else {
                                m.remove(wl5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            wl5 wl5Var5 = (wl5) writeCacheMessage.getData();
                            if (wl5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String cacheString = ((yl5) wl5Var5).toCacheString();
                            if (cacheString != null) {
                                m.g(wl5Var5.getCacheKey(), cacheString);
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
