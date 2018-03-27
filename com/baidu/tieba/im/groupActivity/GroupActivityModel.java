package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int aJP;
    private RequestGetGroupActivityMessage eFW;
    private RequestGetGroupActivityLocalMessage eFX;
    private RequestDelGroupActivityMessage eFY;
    private GroupActivityActivity eFZ;
    private GroupActivityData eGa;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eFZ = groupActivityActivity;
    }

    public int aJy() {
        return this.mFrom;
    }

    public void qf(int i) {
        this.mFrom = i;
    }

    public int aJz() {
        return this.aJP;
    }

    public void qg(int i) {
        this.aJP = i;
    }

    public long aJA() {
        return this.mGroupId;
    }

    public void bW(long j) {
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

    private RequestGetGroupActivityMessage qh(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage qi(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eFW = qh(i);
        this.eFZ.sendMessage(this.eFW);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void qj(int i) {
        this.eFX = qi(i);
        this.eFZ.sendMessage(this.eFX);
    }

    public Message<?> getLocalSendMsg() {
        return this.eFX;
    }

    public Message<?> getSendMsg() {
        return this.eFW;
    }

    public Message<?> aJB() {
        return this.eFY;
    }

    public void j(long j, int i) {
        this.eFY = new RequestDelGroupActivityMessage();
        this.eFY.setActivityId(i);
        this.eFY.setGroupId((int) j);
        this.eFZ.sendMessage(this.eFY);
    }

    public GroupActivityData aJC() {
        return this.eGa;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eGa = groupActivityData;
        }
    }
}
