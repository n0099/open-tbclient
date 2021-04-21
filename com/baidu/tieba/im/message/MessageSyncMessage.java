package com.baidu.tieba.im.message;

import androidx.collection.LongSparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import d.b.j0.e1.o.c;
import java.util.ArrayList;
import protobuf.GetGroupMsg.DataReq;
import protobuf.GetGroupMsg.GetGroupMsgReqIdl;
import protobuf.GroupLastId;
import protobuf.NewpushRepair;
/* loaded from: classes4.dex */
public class MessageSyncMessage extends TbSocketMessage {
    public int height;
    public boolean isForTimer;
    public LongSparseArray<Long> mMids;
    public NewpushRepair newpushRepire;
    public String notifyMaxTime;
    public String notifyMinTime;
    public String processType;
    public String pushTimes;
    public int smallHeight;
    public int smallWidth;
    public String syncTypeString;
    public int width;

    public MessageSyncMessage() {
        super(202003);
        this.mMids = null;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.height = Integer.valueOf(getHeight());
        builder.width = Integer.valueOf(getWidth());
        builder.smallHeight = Integer.valueOf(getSmallHeight());
        builder.smallWidth = Integer.valueOf(getSmallWidth());
        builder.pushTimes = getPushTimes();
        builder.min_time = getNotifyMinTime();
        builder.max_time = getNotifyMaxTime();
        builder.gettype = getSyncTypeString();
        builder.process_type = getProcessType();
        if (builder.groupMids == null) {
            builder.groupMids = new ArrayList();
        }
        long d2 = c.e().d();
        boolean z = false;
        for (int i = 0; i < this.mMids.size(); i++) {
            long keyAt = this.mMids.keyAt(i);
            Long valueAt = this.mMids.valueAt(i);
            if (valueAt != null) {
                GroupLastId.Builder builder2 = new GroupLastId.Builder();
                builder2.groupId = Long.valueOf(keyAt);
                builder2.lastMsgId = valueAt;
                if (d2 == keyAt) {
                    builder2.excludeMid = c.e().g();
                    z = true;
                }
                builder.groupMids.add(builder2.build(false));
            }
        }
        if (!z && c.e().i()) {
            GroupLastId.Builder builder3 = new GroupLastId.Builder();
            builder3.groupId = Long.valueOf(d2);
            builder3.lastMsgId = c.e().f();
            builder3.excludeMid = c.e().g();
            builder.groupMids.add(builder3.build(false));
        }
        builder.newpushRepire = getNewpushRepire();
        GetGroupMsgReqIdl.Builder builder4 = new GetGroupMsgReqIdl.Builder();
        builder4.cuid = TbadkCoreApplication.getUniqueIdentifier();
        builder4.data = builder.build(false);
        return builder4.build(false);
    }

    public LongSparseArray<Long> getGroupMids() {
        return this.mMids;
    }

    public int getHeight() {
        return this.height;
    }

    public NewpushRepair getNewpushRepire() {
        return this.newpushRepire;
    }

    public String getNotifyMaxTime() {
        return this.notifyMaxTime;
    }

    public String getNotifyMinTime() {
        return this.notifyMinTime;
    }

    public String getProcessType() {
        return this.processType;
    }

    public String getPushTimes() {
        return this.pushTimes;
    }

    public int getSmallHeight() {
        return this.smallHeight;
    }

    public int getSmallWidth() {
        return this.smallWidth;
    }

    public String getSyncTypeString() {
        return this.syncTypeString;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isForTimer() {
        return this.isForTimer;
    }

    public void setForTimer(boolean z) {
        this.isForTimer = z;
    }

    public void setGroupMids(LongSparseArray<Long> longSparseArray) {
        this.mMids = longSparseArray;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setNewpushRepire(NewpushRepair newpushRepair) {
        this.newpushRepire = newpushRepair;
    }

    public void setNotifyMaxTime(String str) {
        this.notifyMaxTime = str;
    }

    public void setNotifyMinTime(String str) {
        this.notifyMinTime = str;
    }

    public void setProcessType(String str) {
        this.processType = str;
    }

    public void setPushTimes(String str) {
        this.pushTimes = str;
    }

    public void setSmallHeight(int i) {
        this.smallHeight = i;
    }

    public void setSmallWidth(int i) {
        this.smallWidth = i;
    }

    public void setSyncTypeString(String str) {
        this.syncTypeString = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
