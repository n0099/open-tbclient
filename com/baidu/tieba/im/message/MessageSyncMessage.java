package com.baidu.tieba.im.message;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import java.util.ArrayList;
import protobuf.GetGroupMsg.DataReq;
import protobuf.GetGroupMsg.GetGroupMsgReqIdl;
import protobuf.GroupLastId;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class MessageSyncMessage extends TbSocketMessage {
    private int height;
    private boolean isForTimer;
    private SparseArray<Long> mMids;
    private NewpushRepair newpushRepire;
    private String notifyMaxTime;
    private String notifyMinTime;
    private String processType;
    private String pushTimes;
    private int smallHeight;
    private int smallWidth;
    private String syncTypeString;
    private int width;

    public MessageSyncMessage() {
        super(202003);
        this.mMids = null;
    }

    public String getNotifyMinTime() {
        return this.notifyMinTime;
    }

    public void setNotifyMinTime(String str) {
        this.notifyMinTime = str;
    }

    public String getNotifyMaxTime() {
        return this.notifyMaxTime;
    }

    public void setNotifyMaxTime(String str) {
        this.notifyMaxTime = str;
    }

    public String getSyncTypeString() {
        return this.syncTypeString;
    }

    public void setSyncTypeString(String str) {
        this.syncTypeString = str;
    }

    public NewpushRepair getNewpushRepire() {
        return this.newpushRepire;
    }

    public void setNewpushRepire(NewpushRepair newpushRepair) {
        this.newpushRepire = newpushRepair;
    }

    public String getProcessType() {
        return this.processType;
    }

    public void setProcessType(String str) {
        this.processType = str;
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
        builder.min_time = getNotifyMinTime();
        builder.max_time = getNotifyMaxTime();
        builder.gettype = getSyncTypeString();
        builder.process_type = getProcessType();
        if (builder.groupMids == null) {
            builder.groupMids = new ArrayList();
        }
        int gid = com.baidu.tieba.im.push.f.aev().getGid();
        boolean z = false;
        for (int i = 0; i < this.mMids.size(); i++) {
            int keyAt = this.mMids.keyAt(i);
            Long valueAt = this.mMids.valueAt(i);
            if (valueAt != null) {
                GroupLastId.Builder builder2 = new GroupLastId.Builder();
                builder2.groupId = Integer.valueOf(keyAt);
                builder2.lastMsgId = valueAt;
                if (gid == keyAt) {
                    z = true;
                    builder2.excludeMid = com.baidu.tieba.im.push.f.aev().aex();
                }
                builder.groupMids.add(builder2.build(false));
            }
        }
        if (!z && com.baidu.tieba.im.push.f.aev().aez()) {
            GroupLastId.Builder builder3 = new GroupLastId.Builder();
            builder3.groupId = Integer.valueOf(gid);
            builder3.lastMsgId = com.baidu.tieba.im.push.f.aev().aew();
            builder3.excludeMid = com.baidu.tieba.im.push.f.aev().aex();
            builder.groupMids.add(builder3.build(false));
        }
        builder.newpushRepire = getNewpushRepire();
        GetGroupMsgReqIdl.Builder builder4 = new GetGroupMsgReqIdl.Builder();
        builder4.cuid = TbadkCoreApplication.getUniqueIdentifier();
        builder4.data = builder.build(false);
        return builder4.build(false);
    }

    public boolean isForTimer() {
        return this.isForTimer;
    }

    public void setForTimer(boolean z) {
        this.isForTimer = z;
    }
}
