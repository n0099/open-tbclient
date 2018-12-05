package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int akb;
    private RequestGetGroupActivityMessage eRM;
    private RequestGetGroupActivityLocalMessage eRN;
    private RequestDelGroupActivityMessage eRO;
    private GroupActivityActivity eRP;
    private GroupActivityData eRQ;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eRP = groupActivityActivity;
    }

    public int aRM() {
        return this.mFrom;
    }

    public void pX(int i) {
        this.mFrom = i;
    }

    public int aRN() {
        return this.akb;
    }

    public void pY(int i) {
        this.akb = i;
    }

    public long aRO() {
        return this.mGroupId;
    }

    public void cp(long j) {
        this.mGroupId = j;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private RequestGetGroupActivityMessage pZ(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage qa(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eRM = pZ(i);
        this.eRP.sendMessage(this.eRM);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void qb(int i) {
        this.eRN = qa(i);
        this.eRP.sendMessage(this.eRN);
    }

    public Message<?> getLocalSendMsg() {
        return this.eRN;
    }

    public Message<?> getSendMsg() {
        return this.eRM;
    }

    public Message<?> aRP() {
        return this.eRO;
    }

    public void m(long j, int i) {
        this.eRO = new RequestDelGroupActivityMessage();
        this.eRO.setActivityId(i);
        this.eRO.setGroupId(j);
        this.eRP.sendMessage(this.eRO);
    }

    public GroupActivityData aRQ() {
        return this.eRQ;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eRQ = groupActivityData;
        }
    }
}
