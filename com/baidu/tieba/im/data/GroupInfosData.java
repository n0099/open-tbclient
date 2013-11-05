package com.baidu.tieba.im.data;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class GroupInfosData implements Serializable {
    private static final long serialVersionUID = 5261333603710948845L;
    private int cmd;
    private Data data;
    private int isAck;
    private a msgTag;

    public int getIsAck() {
        return this.isAck;
    }

    public void setIsAck(int i) {
        this.isAck = i;
    }

    public int getCmd() {
        return this.cmd;
    }

    public void setCmd(int i) {
        this.cmd = i;
    }

    public a getMsgTag() {
        return this.msgTag;
    }

    public void setMsgTag(a aVar) {
        this.msgTag = aVar;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /* loaded from: classes.dex */
    public class Data implements Serializable {
        private static final long serialVersionUID = 2425469401332004671L;
        private List<GroupInfoData> groups;

        public Data() {
        }

        public List<GroupInfoData> getGroups() {
            return this.groups;
        }

        public void setGroups(List<GroupInfoData> list) {
            this.groups = list;
        }
    }
}
