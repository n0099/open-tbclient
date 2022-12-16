package com.baidu.tieba.danmu.cache;

import android.os.Looper;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/danmu/cache/CacheManager$CacheHandler;", "Lcom/baidu/tieba/danmu/cache/CacheManager;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CacheManager$cacheHandler$2 extends Lambda implements Function0<CacheManager.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ CacheManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheManager$cacheHandler$2(CacheManager cacheManager) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cacheManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = cacheManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CacheManager.a invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CacheManager cacheManager = this.this$0;
            Looper looper = cacheManager.k().getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "cacheThread.looper");
            return new CacheManager.a(cacheManager, looper);
        }
        return (CacheManager.a) invokeV.objValue;
    }
}
