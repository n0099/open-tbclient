package com.baidu.tbadk.live.data;

import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LiveBlackMembersListData {
    private int hasMore;
    private int totalMembers;
    private List<UserData> userDatas = new ArrayList();

    public int getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(int i) {
        this.hasMore = i;
    }

    public int getTotalMembers() {
        return this.totalMembers;
    }

    public void setTotalMembers(int i) {
        this.totalMembers = i;
    }

    public List<UserData> getUserDatas() {
        return this.userDatas;
    }

    public void setUserDatas(List<UserData> list) {
        this.userDatas = list;
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }
}
