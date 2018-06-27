package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dJj = BdUniqueId.gen();
    private Integer dJk;
    private List<g> dJl;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.dJk = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.dJl = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.dJl.add(gVar);
                    }
                }
            }
            aAZ();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ap.isEmpty(videoCard.title) || ap.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aAZ() {
        if (this.dJl != null) {
            if (this.dJl.size() < 3) {
                this.dJl.clear();
            } else if (this.dJl.size() > 5) {
                for (int i = 5; i < this.dJl.size(); i++) {
                    this.dJl.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dJj;
    }

    public Integer aBa() {
        return this.dJk;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aBb() {
        return this.dJl;
    }
}
