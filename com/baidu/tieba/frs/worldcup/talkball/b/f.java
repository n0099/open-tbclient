package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eje = BdUniqueId.gen();
    private Integer ejf;
    private List<g> ejg;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.ejf = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.ejg = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.ejg.add(gVar);
                    }
                }
            }
            aIu();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ao.isEmpty(videoCard.title) || ao.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aIu() {
        if (this.ejg != null) {
            if (this.ejg.size() < 3) {
                this.ejg.clear();
            } else if (this.ejg.size() > 5) {
                for (int i = 5; i < this.ejg.size(); i++) {
                    this.ejg.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eje;
    }

    public Integer aIv() {
        return this.ejf;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aIw() {
        return this.ejg;
    }
}
