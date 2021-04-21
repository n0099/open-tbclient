package com.baidu.tieba.homepage.topic;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabHttpResponse;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabSocketResponse;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseHttpGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseSocketGetTopicListMessage;
import d.b.j0.d3.d0.a;
/* loaded from: classes4.dex */
public class TopicStatic {
    static {
        c();
        b();
        d();
        a();
        e();
    }

    public static void a() {
        a.h(309661, HotTopicTabSocketResponse.class, false, false);
        a.c(309661, CmdConfigHttp.CMD_HOT_TOPIC_TAB, TbConfig.URL_GET_HOT_TOPIC_TAB, HotTopicTabHttpResponse.class, false, false, true, false);
    }

    public static void b() {
        a.h(309629, ResponseSocketGetTopicDetailMessage.class, false, false);
        a.c(309629, CmdConfigHttp.CMD_TOPIC_DETAIL, TbConfig.URL_GET_TOPIC_DETAIL, ResponseHttpGetTopicDetailMessage.class, false, false, true, false);
    }

    public static void c() {
        a.h(309628, ResponseSocketGetTopicListMessage.class, false, false);
        a.c(309628, CmdConfigHttp.CMD_TOPIC_LIST, TbConfig.URL_GET_TAB_TOPIC_LIST, ResponseHttpGetTopicListMessage.class, false, false, true, false);
    }

    public static void d() {
        a.h(309631, ResponseSocketGetTopicThreadMessage.class, false, false);
        a.c(309631, CmdConfigHttp.CMD_TOPIC_THREAD, TbConfig.URL_GET_TOPIC_THREAD, ResponseHttpGetTopicThreadMessage.class, false, false, true, false);
    }

    public static void e() {
        a.h(309085, BlessSocketResponseMessage.class, false, false);
        a.c(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
    }
}
