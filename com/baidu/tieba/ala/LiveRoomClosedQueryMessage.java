package com.baidu.tieba.ala;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveRoomClosedQueryMessage extends CustomMessage<List<Object>> {
    public List<Long> mIds;
    public List<Object> mOriginData;

    public LiveRoomClosedQueryMessage(List<Long> list, List<Object> list2) {
        super(2921025);
        this.mOriginData = new ArrayList();
        this.mIds = new ArrayList();
        if (ListUtils.isEmpty(list2) || ListUtils.isEmpty(list)) {
            return;
        }
        this.mOriginData.addAll(list2);
        this.mIds.addAll(list);
    }

    public List<Long> getIds() {
        return this.mIds;
    }

    public List<Object> getOriginData() {
        return this.mOriginData;
    }
}
