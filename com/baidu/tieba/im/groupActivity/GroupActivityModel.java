package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes23.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int evJ;
    private RequestGetGroupActivityMessage kvN;
    private RequestGetGroupActivityLocalMessage kvO;
    private RequestDelGroupActivityMessage kvP;
    private GroupActivityActivity kvQ;
    private GroupActivityData kvR;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kvQ = groupActivityActivity;
    }

    public int cXD() {
        return this.mFrom;
    }

    public void Em(int i) {
        this.mFrom = i;
    }

    public int cXE() {
        return this.evJ;
    }

    public void En(int i) {
        this.evJ = i;
    }

    public long cXF() {
        return this.mGroupId;
    }

    public void gP(long j) {
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

    private RequestGetGroupActivityMessage Eo(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage Ep(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.kvN = Eo(i);
        this.kvQ.sendMessage(this.kvN);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void Eq(int i) {
        this.kvO = Ep(i);
        this.kvQ.sendMessage(this.kvO);
    }

    public Message<?> getLocalSendMsg() {
        return this.kvO;
    }

    public Message<?> getSendMsg() {
        return this.kvN;
    }

    public Message<?> cXG() {
        return this.kvP;
    }

    public void F(long j, int i) {
        this.kvP = new RequestDelGroupActivityMessage();
        this.kvP.setActivityId(i);
        this.kvP.setGroupId(j);
        this.kvQ.sendMessage(this.kvP);
    }

    public GroupActivityData cXH() {
        return this.kvR;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.kvR = groupActivityData;
        }
    }
}
