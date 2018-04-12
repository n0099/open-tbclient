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
    private RequestGetGroupActivityMessage eaB;
    private RequestGetGroupActivityLocalMessage eaC;
    private RequestDelGroupActivityMessage eaD;
    private GroupActivityActivity eaE;
    private GroupActivityData eaF;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eaE = groupActivityActivity;
    }

    public int aEv() {
        return this.mFrom;
    }

    public void nD(int i) {
        this.mFrom = i;
    }

    public int aEw() {
        return this.Vk;
    }

    public void nE(int i) {
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

    private RequestGetGroupActivityMessage nF(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage nG(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eaB = nF(i);
        this.eaE.sendMessage(this.eaB);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void nH(int i) {
        this.eaC = nG(i);
        this.eaE.sendMessage(this.eaC);
    }

    public Message<?> getLocalSendMsg() {
        return this.eaC;
    }

    public Message<?> getSendMsg() {
        return this.eaB;
    }

    public Message<?> aEy() {
        return this.eaD;
    }

    public void k(long j, int i) {
        this.eaD = new RequestDelGroupActivityMessage();
        this.eaD.setActivityId(i);
        this.eaD.setGroupId(j);
        this.eaE.sendMessage(this.eaD);
    }

    public GroupActivityData aEz() {
        return this.eaF;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eaF = groupActivityData;
        }
    }
}
