package com.baidu.tieba;

import com.baidu.tieba.forum.data.protobuf.FrsHeadlinesExtensionKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ComponentFactory;
import tbclient.FeedToutiao;
/* loaded from: classes6.dex */
public final class hj7 implements w87 {
    public static /* synthetic */ Interceptable $ic;
    public static final hj7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947825716, "Lcom/baidu/tieba/hj7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947825716, "Lcom/baidu/tieba/hj7;");
                return;
            }
        }
        a = new hj7();
    }

    public hj7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.w87
    public void a(ComponentFactory componentFactory, List<sb7<? extends Object>> dataList, r67 feedExtraData, String schema) {
        FeedToutiao feedToutiao;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, componentFactory, dataList, feedExtraData, schema) == null) {
            Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(schema, "schema");
            if (Intrinsics.areEqual(componentFactory.component, "feed_toutiao") && (feedToutiao = componentFactory.feed_toutiao) != null) {
                FrsHeadlinesExtensionKt.a(feedToutiao, dataList, feedExtraData, schema);
            }
        }
    }
}
