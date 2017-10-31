package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import tbclient.UserStory;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId azF = BdUniqueId.gen();
    public int azC;
    public com.baidu.tieba.story.process.b azD;
    public String azE;
    public int has_read;
    private boolean isStop;
    public String portrait;
    public long user_id;
    public String user_name;
    public int azB = -1;
    public int mStatus = 0;

    public void bo(boolean z) {
        this.isStop = z;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azF;
    }

    public void a(UserStory userStory) {
        if (userStory != null) {
            this.user_id = userStory.user_id.longValue();
            this.user_name = userStory.user_name;
            this.has_read = userStory.has_read.intValue();
            this.portrait = userStory.portrait;
        }
    }
}
