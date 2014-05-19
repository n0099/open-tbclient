package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import protobuf.QueryHotGroups.DataReq;
import protobuf.QueryHotGroups.QueryHotGroupsReqIdl;
/* loaded from: classes.dex */
public class RequestHotGroupsByLocalMessage extends CustomMessage<Object> {
    private static final int START_OFFSET = 0;
    private int height;
    private int offset;
    private int rn;
    private int width;

    public RequestHotGroupsByLocalMessage(int i, int i2, int i3, int i4) {
        super(MessageTypes.CMD_HOT_GROUPS_LOCAL);
        this.width = i;
        this.height = i2;
        this.rn = i3;
        this.offset = i4;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public int getmWidth() {
        return this.width;
    }

    public void setmWidth(int i) {
        this.width = i;
    }

    public int getmHeight() {
        return this.height;
    }

    public void setmHeight(int i) {
        this.height = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public boolean isFirstPage() {
        return this.offset == 0;
    }

    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.height = Integer.valueOf(getmHeight());
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        builder.width = Integer.valueOf(getmWidth());
        QueryHotGroupsReqIdl.Builder builder2 = new QueryHotGroupsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
