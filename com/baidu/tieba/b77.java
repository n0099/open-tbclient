package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes3.dex */
public class b77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<f77> b;
    public e77 c;
    public List<u67> d;
    public List<t67> e;
    public List<TopicList> f;
    public List<NewTopicList> g;

    public b77() {
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

    public List<TopicList> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        List<TopicList> list;
        List<TopicList> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        List<TabList> list3 = dataRes.tab_list;
        if (list3 != null && !ListUtils.isEmpty(list3)) {
            this.b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                f77 f77Var = new f77();
                f77Var.a(tabList);
                this.b.add(f77Var);
            }
        }
        if (dataRes.media_topic != null) {
            e77 e77Var = new e77();
            this.c = e77Var;
            e77Var.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                t67 t67Var = new t67();
                t67Var.b(dataRes.topic_manual);
                t67Var.a(dataRes.topic_manual.topic_list.get(i));
                this.e.add(t67Var);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                u67 u67Var = new u67();
                u67Var.b(dataRes.topic_bang);
                u67Var.a(dataRes.topic_bang.topic_list.get(i2));
                this.d.add(u67Var);
            }
        }
        this.f = dataRes.frs_tab_topic;
        this.g = dataRes.topic_list;
    }
}
