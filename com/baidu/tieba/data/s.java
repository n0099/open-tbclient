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
    private List<FriendFeedThreadData> akD = new ArrayList();
    private List<UserData> akE = new ArrayList();

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public List<FriendFeedThreadData> zf() {
        return this.akD;
    }

    public void z(List<FriendFeedThreadData> list) {
        this.akD = list;
    }

    public void setHasMore(int i) {
        this.hasMore = i;
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }
}
