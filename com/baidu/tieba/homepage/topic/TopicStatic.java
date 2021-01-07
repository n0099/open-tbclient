package com.baidu.tieba.homepage.topic;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
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
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes2.dex */
public class TopicStatic {
    public static String Tag = "tag";

    static {
        cTW();
        cTX();
        cTY();
        cTV();
        cTZ();
    }

    private static void cTV() {
        a.a(309661, HotTopicTabSocketResponse.class, false, false);
        a.a(309661, CmdConfigHttp.CMD_HOT_TOPIC_TAB, TbConfig.URL_GET_HOT_TOPIC_TAB, HotTopicTabHttpResponse.class, false, false, true, false);
    }

    private static void cTW() {
        a.a(309628, ResponseSocketGetTopicListMessage.class, false, false);
        a.a(309628, CmdConfigHttp.CMD_TOPIC_LIST, TbConfig.URL_GET_TAB_TOPIC_LIST, ResponseHttpGetTopicListMessage.class, false, false, true, false);
    }

    private static void cTX() {
        a.a(309629, ResponseSocketGetTopicDetailMessage.class, false, false);
        a.a(309629, CmdConfigHttp.CMD_TOPIC_DETAIL, TbConfig.URL_GET_TOPIC_DETAIL, ResponseHttpGetTopicDetailMessage.class, false, false, true, false);
    }

    private static void cTY() {
        a.a(309631, ResponseSocketGetTopicThreadMessage.class, false, false);
        a.a(309631, CmdConfigHttp.CMD_TOPIC_THREAD, TbConfig.URL_GET_TOPIC_THREAD, ResponseHttpGetTopicThreadMessage.class, false, false, true, false);
    }

    private static void cTZ() {
        a.a(CmdConfigSocket.CMD_TOPIC_BLESS, BlessSocketResponseMessage.class, false, false);
        a.a(CmdConfigSocket.CMD_TOPIC_BLESS, 1003065, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
    }
}
