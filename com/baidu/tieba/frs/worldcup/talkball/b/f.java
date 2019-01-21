package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId emB = BdUniqueId.gen();
    private Integer emC;
    private List<g> emD;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.emC = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.emD = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.emD.add(gVar);
                    }
                }
            }
            aJH();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ao.isEmpty(videoCard.title) || ao.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aJH() {
        if (this.emD != null) {
            if (this.emD.size() < 3) {
                this.emD.clear();
            } else if (this.emD.size() > 5) {
                for (int i = 5; i < this.emD.size(); i++) {
                    this.emD.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return emB;
    }

    public Integer aJI() {
        return this.emC;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aJJ() {
        return this.emD;
    }
}
