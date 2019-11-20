package com.baidu.tieba.homepage.topic;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseHttpGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseSocketGetTopicListMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes4.dex */
public class TopicStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(TopicDetailActivityConfig.class, TopicDetailActivity.class);
        bvm();
        bvn();
        bvo();
        bvp();
        bvq();
    }

    private static void bvm() {
        a.a(309628, ResponseSocketGetTopicListMessage.class, false, false);
        a.a(309628, CmdConfigHttp.CMD_TOPIC_LIST, TbConfig.URL_GET_TAB_TOPIC_LIST, ResponseHttpGetTopicListMessage.class, false, false, true, false);
    }

    private static void bvn() {
        a.a(309629, ResponseSocketGetTopicDetailMessage.class, false, false);
        a.a(309629, CmdConfigHttp.CMD_TOPIC_DETAIL, TbConfig.URL_GET_TOPIC_DETAIL, ResponseHttpGetTopicDetailMessage.class, false, false, true, false);
    }

    private static void bvo() {
        a.a(309631, ResponseSocketGetTopicThreadMessage.class, false, false);
        a.a(309631, CmdConfigHttp.CMD_TOPIC_THREAD, TbConfig.URL_GET_TOPIC_THREAD, ResponseHttpGetTopicThreadMessage.class, false, false, true, false);
    }

    private static void bvp() {
        a.a(CmdConfigSocket.CMD_TOPIC_BLESS, BlessSocketResponseMessage.class, false, false);
        a.a(CmdConfigSocket.CMD_TOPIC_BLESS, 1003065, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
    }

    private static void bvq() {
        ba.amO().a(new ba.a() { // from class: com.baidu.tieba.homepage.topic.TopicStatic.1
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || lowerCase.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail")) {
                    String matchStringFromURL = ad.getMatchStringFromURL(lowerCase, "topic_id=");
                    if (StringUtils.isNull(matchStringFromURL)) {
                        return 3;
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(tbPageContext.getPageActivity(), b.toLong(matchStringFromURL, 0L))));
                    return 1;
                } else if (lowerCase.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        Intent parseUri = Intent.parseUri(lowerCase, 1);
                        parseUri.setFlags(268435456);
                        if (tbPageContext.getPageActivity() != null) {
                            tbPageContext.getPageActivity().startActivity(parseUri);
                            return 1;
                        }
                        return 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 1;
                    }
                } else {
                    return 3;
                }
            }
        });
    }
}
