package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes5.dex */
public class f98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public String d;
    public u98 e;
    public j98 f;

    public f98() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TopicDetail topicDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, topicDetail) != null) || topicDetail == null) {
            return;
        }
        this.a = topicDetail.topic_id.longValue();
        this.b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.c = topicDetail.topic_image;
        this.d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) && pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            u98 u98Var = new u98();
            this.e = u98Var;
            u98Var.a = this.a;
            u98Var.f = 2;
            u98Var.a(pkModule);
        }
    }

    public void c(TimeLine timeLine) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, timeLine) != null) || timeLine == null) {
            return;
        }
        j98 j98Var = new j98();
        this.f = j98Var;
        j98Var.a(this.a, timeLine);
    }
}
