package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.card.data.q;
import java.util.ArrayList;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.TopicInfo;
/* loaded from: classes.dex */
public class d extends q {
    public void a(CardTopic cardTopic) {
        if (cardTopic != null && !StringUtils.isNull(cardTopic.card_title) && y.s(cardTopic.topic_list) >= 4) {
            this.bcj = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.bck = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    p pVar = new p();
                    pVar.SL = topicInfo.topic_id.longValue();
                    pVar.SM = topicInfo.topic_name;
                    pVar.desc = topicInfo.desc;
                    pVar.bch = topicInfo.is_hot.intValue() == 1;
                    pVar.tag = topicInfo.tag.intValue();
                    this.bck.add(pVar);
                }
            }
        }
    }
}
