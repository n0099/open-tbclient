package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId elU = BdUniqueId.gen();
    private Integer elV;
    private List<g> elW;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.elV = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.elW = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.elW.add(gVar);
                    }
                }
            }
            aJj();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ao.isEmpty(videoCard.title) || ao.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aJj() {
        if (this.elW != null) {
            if (this.elW.size() < 3) {
                this.elW.clear();
            } else if (this.elW.size() > 5) {
                for (int i = 5; i < this.elW.size(); i++) {
                    this.elW.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return elU;
    }

    public Integer aJk() {
        return this.elV;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aJl() {
        return this.elW;
    }
}
