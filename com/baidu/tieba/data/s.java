package com.baidu.tieba.data;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private int hasMore;
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private List<FriendFeedThreadData> akM = new ArrayList();
    private List<UserData> akN = new ArrayList();

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public List<FriendFeedThreadData> zh() {
        return this.akM;
    }

    public void z(List<FriendFeedThreadData> list) {
        this.akM = list;
    }

    public void setHasMore(int i) {
        this.hasMore = i;
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }
}
