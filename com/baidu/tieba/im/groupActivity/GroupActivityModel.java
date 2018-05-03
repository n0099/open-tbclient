package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int Vk;
    private RequestDelGroupActivityMessage eaA;
    private GroupActivityActivity eaB;
    private GroupActivityData eaC;
    private RequestGetGroupActivityMessage eay;
    private RequestGetGroupActivityLocalMessage eaz;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eaB = groupActivityActivity;
    }

    public int aEv() {
        return this.mFrom;
    }

    public void nC(int i) {
        this.mFrom = i;
    }

    public int aEw() {
        return this.Vk;
    }

    public void nD(int i) {
        this.Vk = i;
    }

    public long aEx() {
        return this.mGroupId;
    }

    public void bV(long j) {
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

    private RequestGetGroupActivityMessage nE(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage nF(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eay = nE(i);
        this.eaB.sendMessage(this.eay);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void nG(int i) {
        this.eaz = nF(i);
        this.eaB.sendMessage(this.eaz);
    }

    public Message<?> getLocalSendMsg() {
        return this.eaz;
    }

    public Message<?> getSendMsg() {
        return this.eay;
    }

    public Message<?> aEy() {
        return this.eaA;
    }

    public void k(long j, int i) {
        this.eaA = new RequestDelGroupActivityMessage();
        this.eaA.setActivityId(i);
        this.eaA.setGroupId(j);
        this.eaB.sendMessage(this.eaA);
    }

    public GroupActivityData aEz() {
        return this.eaC;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eaC = groupActivityData;
        }
    }
}
