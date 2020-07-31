package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes17.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dEL;
    private RequestGetGroupActivityMessage jcB;
    private RequestGetGroupActivityLocalMessage jcC;
    private RequestDelGroupActivityMessage jcD;
    private GroupActivityActivity jcE;
    private GroupActivityData jcF;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jcE = groupActivityActivity;
    }

    public int cuV() {
        return this.mFrom;
    }

    public void yT(int i) {
        this.mFrom = i;
    }

    public int cuW() {
        return this.dEL;
    }

    public void yU(int i) {
        this.dEL = i;
    }

    public long cuX() {
        return this.mGroupId;
    }

    public void eS(long j) {
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

    private RequestGetGroupActivityMessage yV(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage yW(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.jcB = yV(i);
        this.jcE.sendMessage(this.jcB);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void yX(int i) {
        this.jcC = yW(i);
        this.jcE.sendMessage(this.jcC);
    }

    public Message<?> getLocalSendMsg() {
        return this.jcC;
    }

    public Message<?> getSendMsg() {
        return this.jcB;
    }

    public Message<?> cuY() {
        return this.jcD;
    }

    public void s(long j, int i) {
        this.jcD = new RequestDelGroupActivityMessage();
        this.jcD.setActivityId(i);
        this.jcD.setGroupId(j);
        this.jcE.sendMessage(this.jcD);
    }

    public GroupActivityData cuZ() {
        return this.jcF;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.jcF = groupActivityData;
        }
    }
}
