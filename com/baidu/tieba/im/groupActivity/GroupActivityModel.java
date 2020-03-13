package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int cHa;
    private RequestDelGroupActivityMessage hCA;
    private GroupActivityActivity hCB;
    private GroupActivityData hCC;
    private RequestGetGroupActivityMessage hCy;
    private RequestGetGroupActivityLocalMessage hCz;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hCB = groupActivityActivity;
    }

    public int bVJ() {
        return this.mFrom;
    }

    public void wx(int i) {
        this.mFrom = i;
    }

    public int bVK() {
        return this.cHa;
    }

    public void wy(int i) {
        this.cHa = i;
    }

    public long bVL() {
        return this.mGroupId;
    }

    public void dQ(long j) {
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

    private RequestGetGroupActivityMessage wz(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage wA(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.hCy = wz(i);
        this.hCB.sendMessage(this.hCy);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void wB(int i) {
        this.hCz = wA(i);
        this.hCB.sendMessage(this.hCz);
    }

    public Message<?> getLocalSendMsg() {
        return this.hCz;
    }

    public Message<?> getSendMsg() {
        return this.hCy;
    }

    public Message<?> bVM() {
        return this.hCA;
    }

    public void r(long j, int i) {
        this.hCA = new RequestDelGroupActivityMessage();
        this.hCA.setActivityId(i);
        this.hCA.setGroupId(j);
        this.hCB.sendMessage(this.hCA);
    }

    public GroupActivityData bVN() {
        return this.hCC;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.hCC = groupActivityData;
        }
    }
}
