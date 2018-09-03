package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dLV = BdUniqueId.gen();
    private Integer dLW;
    private List<g> dLX;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.dLW = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.dLX = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.dLX.add(gVar);
                    }
                }
            }
            aBF();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ap.isEmpty(videoCard.title) || ap.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aBF() {
        if (this.dLX != null) {
            if (this.dLX.size() < 3) {
                this.dLX.clear();
            } else if (this.dLX.size() > 5) {
                for (int i = 5; i < this.dLX.size(); i++) {
                    this.dLX.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dLV;
    }

    public Integer aBG() {
        return this.dLW;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aBH() {
        return this.dLX;
    }
}
