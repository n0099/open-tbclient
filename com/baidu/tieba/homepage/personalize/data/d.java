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
            this.bcD = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.bcE = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    p pVar = new p();
                    pVar.SS = topicInfo.topic_id.longValue();
                    pVar.ST = topicInfo.topic_name;
                    pVar.desc = topicInfo.desc;
                    pVar.bcz = topicInfo.is_hot.intValue() == 1;
                    pVar.tag = topicInfo.tag.intValue();
                    this.bcE.add(pVar);
                }
            }
        }
    }
}
