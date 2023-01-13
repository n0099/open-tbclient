package com.baidu.tieba.browser.core.cache.offline;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class OfflineLRUCache<K, V> extends LinkedHashMap<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CAPACITY = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public final int cacheSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineLRUCache(int i) {
        super(16, 0.75f, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cacheSize = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) {
            if (size() > this.cacheSize) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
