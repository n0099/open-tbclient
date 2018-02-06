package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int aJZ;
    private RequestGetGroupActivityMessage eFS;
    private RequestGetGroupActivityLocalMessage eFT;
    private RequestDelGroupActivityMessage eFU;
    private GroupActivityActivity eFV;
    private GroupActivityData eFW;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eFV = groupActivityActivity;
    }

    public int aJy() {
        return this.mFrom;
    }

    public void qe(int i) {
        this.mFrom = i;
    }

    public int aJz() {
        return this.aJZ;
    }

    public void qf(int i) {
        this.aJZ = i;
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

    private RequestGetGroupActivityMessage qg(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage qh(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eFS = qg(i);
        this.eFV.sendMessage(this.eFS);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void qi(int i) {
        this.eFT = qh(i);
        this.eFV.sendMessage(this.eFT);
    }

    public Message<?> getLocalSendMsg() {
        return this.eFT;
    }

    public Message<?> getSendMsg() {
        return this.eFS;
    }

    public Message<?> aJB() {
        return this.eFU;
    }

    public void j(long j, int i) {
        this.eFU = new RequestDelGroupActivityMessage();
        this.eFU.setActivityId(i);
        this.eFU.setGroupId((int) j);
        this.eFV.sendMessage(this.eFU);
    }

    public GroupActivityData aJC() {
        return this.eFW;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eFW = groupActivityData;
        }
    }
}
