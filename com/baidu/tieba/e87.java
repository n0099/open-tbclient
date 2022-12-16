package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class e87 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId g;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public ThreadData b;
    public long c;
    public int d;
    public int e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688293, "Lcom/baidu/tieba/e87;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688293, "Lcom/baidu/tieba/e87;");
                return;
            }
        }
        g = BdUniqueId.gen();
    }

    public e87() {
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

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return g;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void c(TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, topicThread) != null) || topicThread == null) {
            return;
        }
        this.a = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            ThreadData threadData = new ThreadData();
            this.b = threadData;
            threadData.parserProtobuf(topicThread.thread_info);
            this.b.parser_title();
        }
        this.d = topicThread.user_agree.intValue();
        this.e = topicThread.source.intValue();
    }

    public void f(tbclient.NewTopicThread.TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicThread) != null) || topicThread == null) {
            return;
        }
        this.a = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            ThreadData threadData = new ThreadData();
            this.b = threadData;
            threadData.parserProtobuf(topicThread.thread_info);
            this.b.parser_title();
        }
        this.d = Integer.parseInt(topicThread.user_agree);
        this.e = topicThread.source.intValue();
    }
}
