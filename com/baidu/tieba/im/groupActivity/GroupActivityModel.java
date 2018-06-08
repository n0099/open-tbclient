package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int adg;
    private RequestGetGroupActivityMessage emS;
    private RequestGetGroupActivityLocalMessage emT;
    private RequestDelGroupActivityMessage emU;
    private GroupActivityActivity emV;
    private GroupActivityData emW;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.emV = groupActivityActivity;
    }

    public int aJo() {
        return this.mFrom;
    }

    public void nN(int i) {
        this.mFrom = i;
    }

    public int aJp() {
        return this.adg;
    }

    public void nO(int i) {
        this.adg = i;
    }

    public long aJq() {
        return this.mGroupId;
    }

    public void cb(long j) {
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

    private RequestGetGroupActivityMessage nP(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage nQ(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.emS = nP(i);
        this.emV.sendMessage(this.emS);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void nR(int i) {
        this.emT = nQ(i);
        this.emV.sendMessage(this.emT);
    }

    public Message<?> getLocalSendMsg() {
        return this.emT;
    }

    public Message<?> getSendMsg() {
        return this.emS;
    }

    public Message<?> aJr() {
        return this.emU;
    }

    public void j(long j, int i) {
        this.emU = new RequestDelGroupActivityMessage();
        this.emU.setActivityId(i);
        this.emU.setGroupId(j);
        this.emV.sendMessage(this.emU);
    }

    public GroupActivityData aJs() {
        return this.emW;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.emW = groupActivityData;
        }
    }
}
