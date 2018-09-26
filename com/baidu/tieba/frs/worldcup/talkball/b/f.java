package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dTn = BdUniqueId.gen();
    private Integer dTo;
    private List<g> dTp;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.dTo = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.dTp = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.dTp.add(gVar);
                    }
                }
            }
            aDS();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ao.isEmpty(videoCard.title) || ao.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aDS() {
        if (this.dTp != null) {
            if (this.dTp.size() < 3) {
                this.dTp.clear();
            } else if (this.dTp.size() > 5) {
                for (int i = 5; i < this.dTp.size(); i++) {
                    this.dTp.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dTn;
    }

    public Integer aDT() {
        return this.dTo;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aDU() {
        return this.dTp;
    }
}
