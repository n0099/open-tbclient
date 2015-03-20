package com.baidu.tieba.friendFeed.data;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int hasMore;
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private List<FriendFeedThreadData> aIC = new ArrayList();
    private List<UserData> aID = new ArrayList();

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public List<FriendFeedThreadData> Ji() {
        return this.aIC;
    }

    public void R(List<FriendFeedThreadData> list) {
        this.aIC = list;
    }

    public void setHasMore(int i) {
        this.hasMore = i;
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }
}
