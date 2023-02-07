package com.baidu.tieba.browser.core.cache.prerender;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sa6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class LRUCache<Key, Value extends sa6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<Key, Value> a;
    public final int b;

    public LRUCache(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = i;
        this.a = (LinkedHashMap<Key, Value>) new LinkedHashMap<Key, Value>(this, ((int) Math.ceil(i / 0.75f)) + 1, 0.75f, true) { // from class: com.baidu.tieba.browser.core.cache.prerender.LRUCache.1
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 1;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LRUCache this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r10), Float.valueOf(r11), Boolean.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr3 = newInitContext2.callArgs;
                        super(((Integer) objArr3[0]).intValue(), ((Float) objArr3[1]).floatValue(), ((Boolean) objArr3[2]).booleanValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Key, Value> entry) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, entry)) == null) {
                    if (size() > this.this$0.b) {
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
    }

    public Value b(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, key)) == null) {
            return this.a.remove(key);
        }
        return (Value) invokeL.objValue;
    }

    public Value c(Key key, Value value) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, key, value)) == null) {
            return this.a.put(key, value);
        }
        return (Value) invokeLL.objValue;
    }
}
