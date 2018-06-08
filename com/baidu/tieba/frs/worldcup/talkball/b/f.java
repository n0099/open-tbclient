package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dFQ = BdUniqueId.gen();
    private Integer dFR;
    private List<g> dFS;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.dFR = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.dFS = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.dFS.add(gVar);
                    }
                }
            }
            aAs();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ao.isEmpty(videoCard.title) || ao.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aAs() {
        if (this.dFS != null) {
            if (this.dFS.size() < 3) {
                this.dFS.clear();
            } else if (this.dFS.size() > 5) {
                for (int i = 5; i < this.dFS.size(); i++) {
                    this.dFS.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dFQ;
    }

    public Integer aAt() {
        return this.dFR;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aAu() {
        return this.dFS;
    }
}
