package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ebg = BdUniqueId.gen();
    private Integer ebh;
    private List<g> ebi;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.ebh = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.ebi = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.ebi.add(gVar);
                    }
                }
            }
            aHk();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ao.isEmpty(videoCard.title) || ao.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aHk() {
        if (this.ebi != null) {
            if (this.ebi.size() < 3) {
                this.ebi.clear();
            } else if (this.ebi.size() > 5) {
                for (int i = 5; i < this.ebi.size(); i++) {
                    this.ebi.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ebg;
    }

    public Integer aHl() {
        return this.ebh;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aHm() {
        return this.ebi;
    }
}
