package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ecB = BdUniqueId.gen();
    private Integer ecC;
    private List<g> ecD;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.ecC = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.ecD = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.ecD.add(gVar);
                    }
                }
            }
            aGI();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ao.isEmpty(videoCard.title) || ao.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aGI() {
        if (this.ecD != null) {
            if (this.ecD.size() < 3) {
                this.ecD.clear();
            } else if (this.ecD.size() > 5) {
                for (int i = 5; i < this.ecD.size(); i++) {
                    this.ecD.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ecB;
    }

    public Integer aGJ() {
        return this.ecC;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aGK() {
        return this.ecD;
    }
}
