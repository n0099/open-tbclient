package com.baidu.tieba.ala;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LiveRoomClosedResponsedMessage extends CustomMessage<List<Long>> {
    private List<Long> mIds;
    private List<Object> mOriginData;

    public LiveRoomClosedResponsedMessage(List<Long> list) {
        super(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED);
        this.mIds = new ArrayList();
        this.mOriginData = new ArrayList();
        if (!v.w(list)) {
            this.mIds.addAll(list);
        }
    }

    public List<Long> getIds() {
        return this.mIds;
    }

    public List<Object> getOriginData() {
        return this.mOriginData;
    }

    public void setOriginData(List<Object> list) {
        if (list != null) {
            this.mOriginData.clear();
            this.mOriginData.addAll(list);
        }
    }
}
