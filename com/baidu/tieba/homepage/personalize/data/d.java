package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.card.a.q;
import java.util.ArrayList;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.TopicInfo;
/* loaded from: classes.dex */
public class d extends q {
    public void a(CardTopic cardTopic) {
        if (cardTopic != null && !StringUtils.isNull(cardTopic.card_title) && y.s(cardTopic.topic_list) >= 4) {
            this.aVJ = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.aVK = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    p pVar = new p();
                    pVar.PE = topicInfo.topic_id.longValue();
                    pVar.PF = topicInfo.topic_name;
                    pVar.desc = topicInfo.desc;
                    pVar.aVH = topicInfo.is_hot.intValue() == 1;
                    pVar.tag = topicInfo.tag.intValue();
                    this.aVK.add(pVar);
                }
            }
        }
    }
}
