package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int adv;
    private RequestGetGroupActivityMessage eqN;
    private RequestGetGroupActivityLocalMessage eqO;
    private RequestDelGroupActivityMessage eqP;
    private GroupActivityActivity eqQ;
    private GroupActivityData eqR;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eqQ = groupActivityActivity;
    }

    public int aJV() {
        return this.mFrom;
    }

    public void nU(int i) {
        this.mFrom = i;
    }

    public int aJW() {
        return this.adv;
    }

    public void nV(int i) {
        this.adv = i;
    }

    public long aJX() {
        return this.mGroupId;
    }

    public void bX(long j) {
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

    private RequestGetGroupActivityMessage nW(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage nX(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eqN = nW(i);
        this.eqQ.sendMessage(this.eqN);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void nY(int i) {
        this.eqO = nX(i);
        this.eqQ.sendMessage(this.eqO);
    }

    public Message<?> getLocalSendMsg() {
        return this.eqO;
    }

    public Message<?> getSendMsg() {
        return this.eqN;
    }

    public Message<?> aJY() {
        return this.eqP;
    }

    public void j(long j, int i) {
        this.eqP = new RequestDelGroupActivityMessage();
        this.eqP.setActivityId(i);
        this.eqP.setGroupId(j);
        this.eqQ.sendMessage(this.eqP);
    }

    public GroupActivityData aJZ() {
        return this.eqR;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eqR = groupActivityData;
        }
    }
}
