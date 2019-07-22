package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int byb;
    private RequestGetGroupActivityMessage gIM;
    private RequestGetGroupActivityLocalMessage gIN;
    private RequestDelGroupActivityMessage gIO;
    private GroupActivityActivity gIP;
    private GroupActivityData gIQ;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gIP = groupActivityActivity;
    }

    public int bDY() {
        return this.mFrom;
    }

    public void vz(int i) {
        this.mFrom = i;
    }

    public int bDZ() {
        return this.byb;
    }

    public void vA(int i) {
        this.byb = i;
    }

    public long bEa() {
        return this.mGroupId;
    }

    public void dG(long j) {
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

    private RequestGetGroupActivityMessage vB(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage vC(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gIM = vB(i);
        this.gIP.sendMessage(this.gIM);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void vD(int i) {
        this.gIN = vC(i);
        this.gIP.sendMessage(this.gIN);
    }

    public Message<?> getLocalSendMsg() {
        return this.gIN;
    }

    public Message<?> getSendMsg() {
        return this.gIM;
    }

    public Message<?> bEb() {
        return this.gIO;
    }

    public void p(long j, int i) {
        this.gIO = new RequestDelGroupActivityMessage();
        this.gIO.setActivityId(i);
        this.gIO.setGroupId(j);
        this.gIP.sendMessage(this.gIO);
    }

    public GroupActivityData bEc() {
        return this.gIQ;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gIQ = groupActivityData;
        }
    }
}
