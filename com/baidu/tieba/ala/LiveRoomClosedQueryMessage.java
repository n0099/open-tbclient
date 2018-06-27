package com.baidu.tieba.ala;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LiveRoomClosedQueryMessage extends CustomMessage<List<Object>> {
    private List<Long> mIds;
    private List<Object> mOriginData;

    public LiveRoomClosedQueryMessage(List<Long> list, List<Object> list2) {
        super(2921025);
        this.mOriginData = new ArrayList();
        this.mIds = new ArrayList();
        if (!w.A(list2) && !w.A(list)) {
            this.mOriginData.addAll(list2);
            this.mIds.addAll(list);
        }
    }

    public List<Long> getIds() {
        return this.mIds;
    }

    public List<Object> getOriginData() {
        return this.mOriginData;
    }
}
