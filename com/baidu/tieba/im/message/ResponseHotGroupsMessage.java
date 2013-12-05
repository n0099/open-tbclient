package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupInfoData;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseHotGroupsMessage extends ResponsedMessage {
    private static final long serialVersionUID = -1416957177167093109L;
    private List<GroupInfoData> groups;
    private boolean hasMore;

    public ResponseHotGroupsMessage() {
        super.setCmd(103012);
    }

    public List<GroupInfoData> getGroups() {
        return this.groups;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }
}
