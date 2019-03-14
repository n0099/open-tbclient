package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int bqQ;
    private RequestDelGroupActivityMessage glA;
    private GroupActivityActivity glB;
    private GroupActivityData glC;
    private RequestGetGroupActivityMessage gly;
    private RequestGetGroupActivityLocalMessage glz;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.glB = groupActivityActivity;
    }

    public int btE() {
        return this.mFrom;
    }

    public void tV(int i) {
        this.mFrom = i;
    }

    public int btF() {
        return this.bqQ;
    }

    public void tW(int i) {
        this.bqQ = i;
    }

    public long btG() {
        return this.mGroupId;
    }

    public void cZ(long j) {
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

    private RequestGetGroupActivityMessage tX(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage tY(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gly = tX(i);
        this.glB.sendMessage(this.gly);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void tZ(int i) {
        this.glz = tY(i);
        this.glB.sendMessage(this.glz);
    }

    public Message<?> getLocalSendMsg() {
        return this.glz;
    }

    public Message<?> getSendMsg() {
        return this.gly;
    }

    public Message<?> btH() {
        return this.glA;
    }

    public void r(long j, int i) {
        this.glA = new RequestDelGroupActivityMessage();
        this.glA.setActivityId(i);
        this.glA.setGroupId(j);
        this.glB.sendMessage(this.glA);
    }

    public GroupActivityData btI() {
        return this.glC;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.glC = groupActivityData;
        }
    }
}
