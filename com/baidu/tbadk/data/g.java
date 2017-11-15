package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import tbclient.UserStory;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId azN = BdUniqueId.gen();
    public int azK;
    public com.baidu.tieba.story.process.b azL;
    public String azM;
    public int has_read;
    private boolean isStop;
    public String portrait;
    public long user_id;
    public String user_name;
    public int azJ = -1;
    public int mStatus = 0;

    public void bp(boolean z) {
        this.isStop = z;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azN;
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
