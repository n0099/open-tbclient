package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class MessageSyncMessage extends Message implements IDuplicateProcess {
    private List<GroupMidData> groupMids;
    private int height;
    private String pushTimes;
    private int smallHeight;
    private int smallWidth;
    private int width;

    public MessageSyncMessage() {
        setCmd(202003);
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

    public List<GroupMidData> getGroupMids() {
        return this.groupMids;
    }

    public void setGroupMids(List<GroupMidData> list) {
        this.groupMids = list;
    }

    @Override // com.baidu.tieba.im.message.Message
    public Map toMap() {
        try {
            Map defaultMap = super.toDefaultMap();
            LinkedList linkedList = new LinkedList();
            if (this.groupMids != null && this.groupMids.size() > 0) {
                for (GroupMidData groupMidData : this.groupMids) {
                    linkedList.add(groupMidData.toMap());
                }
            }
            defaultMap.put("groupMids", linkedList);
            return defaultMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState getDuplicateRemoveType() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean onDuplicateProcess(Message message) {
        return true;
    }
}
