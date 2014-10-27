package com.baidu.tbadk.live.data;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FrsLiveListData {
    private static final int TRUE = 1;
    private int hasMore;
    private List<LiveCardData> groups = new ArrayList();
    private List<LiveCardData> hotGroups = new ArrayList();

    public boolean isHasMore() {
        return this.hasMore == 1;
    }

    public int getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(int i) {
        this.hasMore = i;
    }

    public List<LiveCardData> getGroups() {
        return this.groups;
    }

    public void setGroups(List<LiveCardData> list) {
        this.groups = list;
    }

    public List<LiveCardData> getHotGroups() {
        return this.hotGroups;
    }

    public void setHotGroups(List<LiveCardData> list) {
        this.hotGroups = list;
    }
}
