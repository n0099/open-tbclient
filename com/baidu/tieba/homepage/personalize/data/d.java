package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.card.data.q;
import java.util.ArrayList;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.TopicInfo;
/* loaded from: classes.dex */
public class d extends q {
    public void a(CardTopic cardTopic) {
        if (cardTopic != null && !StringUtils.isNull(cardTopic.card_title) && x.s(cardTopic.topic_list) >= 4) {
            this.bfC = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.bfD = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    p pVar = new p();
                    pVar.Tn = topicInfo.topic_id.longValue();
                    pVar.To = topicInfo.topic_name;
                    pVar.desc = topicInfo.desc;
                    pVar.bfy = topicInfo.is_hot.intValue() == 1;
                    pVar.tag = topicInfo.tag.intValue();
                    this.bfD.add(pVar);
                }
            }
        }
    }
}
