package com.baidu.tieba;

import android.app.ActivityManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
/* loaded from: classes6.dex */
public class hd7 extends DefaultBitmapMemoryCacheParamsSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActivityManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd7(ActivityManager activityManager) {
        super(activityManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ActivityManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activityManager;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int min = Math.min(this.a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
            if (min < 33554432) {
                return 4194304;
            }
            if (min < 67108864) {
                return TbConfig.THREAD_GIF_MIN_USE_MEMORY;
            }
            return min / 8;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MemoryCacheParams memoryCacheParams = super.get();
            return new MemoryCacheParams(a(), memoryCacheParams.maxCacheEntries, memoryCacheParams.maxEvictionQueueSize, memoryCacheParams.maxEvictionQueueEntries, memoryCacheParams.maxCacheEntrySize, memoryCacheParams.paramsCheckIntervalMs);
        }
        return (MemoryCacheParams) invokeV.objValue;
    }
}
