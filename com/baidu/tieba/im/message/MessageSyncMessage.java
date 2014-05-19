package com.baidu.tieba.im.message;

import android.util.SparseArray;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import java.util.ArrayList;
import protobuf.GetGroupMsg.DataReq;
import protobuf.GetGroupMsg.GetGroupMsgReqIdl;
import protobuf.GroupLastId;
/* loaded from: classes.dex */
public class MessageSyncMessage extends TbSocketMessage {
    private int height;
    private boolean isForTimer;
    private SparseArray<Long> mMids;
    private String pushTimes;
    private int smallHeight;
    private int smallWidth;
    private int width;

    public MessageSyncMessage() {
        super(MessageTypes.CMD_MESSAGE_SYNC);
        this.mMids = null;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getSmallWidth() {
        return this.smallWidth;
    }

    public void setSmallWidth(int i) {
        this.smallWidth = i;
    }

    public int getSmallHeight() {
        return this.smallHeight;
    }

    public void setSmallHeight(int i) {
        this.smallHeight = i;
    }

    public String getPushTimes() {
        return this.pushTimes;
    }

    public void setPushTimes(String str) {
        this.pushTimes = str;
    }

    public void setGroupMids(SparseArray<Long> sparseArray) {
        this.mMids = sparseArray;
    }

    public SparseArray<Long> getGroupMids() {
        return this.mMids;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.height = Integer.valueOf(getHeight());
        builder.width = Integer.valueOf(getWidth());
        builder.smallHeight = Integer.valueOf(getSmallHeight());
        builder.smallWidth = Integer.valueOf(getSmallWidth());
        builder.pushTimes = getPushTimes();
        if (builder.groupMids == null) {
            builder.groupMids = new ArrayList();
        }
        for (int i = 0; i < this.mMids.size(); i++) {
            int keyAt = this.mMids.keyAt(i);
            Long valueAt = this.mMids.valueAt(i);
            if (valueAt != null) {
                GroupLastId.Builder builder2 = new GroupLastId.Builder();
                builder2.groupId = Integer.valueOf(keyAt);
                builder2.lastMsgId = valueAt;
                builder.groupMids.add(builder2.build(false));
            }
        }
        GetGroupMsgReqIdl.Builder builder3 = new GetGroupMsgReqIdl.Builder();
        builder3.cuid = TbadkApplication.getUniqueIdentifier();
        builder3.data = builder.build(false);
        return builder3.build(false);
    }

    public boolean isForTimer() {
        return this.isForTimer;
    }

    public void setForTimer(boolean z) {
        this.isForTimer = z;
    }
}
