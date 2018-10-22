package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ebh = BdUniqueId.gen();
    private Integer ebi;
    private List<g> ebj;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.ebi = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.ebj = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.ebj.add(gVar);
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
        if (this.ebj != null) {
            if (this.ebj.size() < 3) {
                this.ebj.clear();
            } else if (this.ebj.size() > 5) {
                for (int i = 5; i < this.ebj.size(); i++) {
                    this.ebj.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ebh;
    }

    public Integer aHl() {
        return this.ebi;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aHm() {
        return this.ebj;
    }
}
