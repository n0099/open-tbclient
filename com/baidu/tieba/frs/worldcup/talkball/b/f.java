package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.InsertFloor;
import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dLZ = BdUniqueId.gen();
    private Integer dMa;
    private List<g> dMb;
    private String mTopicName;

    public void a(InsertFloor insertFloor) {
        if (insertFloor != null) {
            this.dMa = insertFloor.topic_id;
            this.mTopicName = insertFloor.topic_name;
            this.dMb = new ArrayList();
            List<VideoCard> list = insertFloor.wander_list;
            if (list != null) {
                for (VideoCard videoCard : list) {
                    if (a(videoCard)) {
                        g gVar = new g();
                        gVar.b(videoCard);
                        this.dMb.add(gVar);
                    }
                }
            }
            aBI();
        }
    }

    private boolean a(VideoCard videoCard) {
        return (videoCard == null || ap.isEmpty(videoCard.title) || ap.isEmpty(videoCard.thread_id)) ? false : true;
    }

    private void aBI() {
        if (this.dMb != null) {
            if (this.dMb.size() < 3) {
                this.dMb.clear();
            } else if (this.dMb.size() > 5) {
                for (int i = 5; i < this.dMb.size(); i++) {
                    this.dMb.remove(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dLZ;
    }

    public Integer aBJ() {
        return this.dMa;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public List<g> aBK() {
        return this.dMb;
    }
}
