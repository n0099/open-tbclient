package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dug;
    private RequestGetGroupActivityMessage iCA;
    private RequestGetGroupActivityLocalMessage iCB;
    private RequestDelGroupActivityMessage iCC;
    private GroupActivityActivity iCD;
    private GroupActivityData iCE;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.iCD = groupActivityActivity;
    }

    public int cmY() {
        return this.mFrom;
    }

    public void xJ(int i) {
        this.mFrom = i;
    }

    public int cmZ() {
        return this.dug;
    }

    public void xK(int i) {
        this.dug = i;
    }

    public long cna() {
        return this.mGroupId;
    }

    public void eB(long j) {
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

    private RequestGetGroupActivityMessage xL(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage xM(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.iCA = xL(i);
        this.iCD.sendMessage(this.iCA);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void xN(int i) {
        this.iCB = xM(i);
        this.iCD.sendMessage(this.iCB);
    }

    public Message<?> getLocalSendMsg() {
        return this.iCB;
    }

    public Message<?> getSendMsg() {
        return this.iCA;
    }

    public Message<?> cnb() {
        return this.iCC;
    }

    public void r(long j, int i) {
        this.iCC = new RequestDelGroupActivityMessage();
        this.iCC.setActivityId(i);
        this.iCC.setGroupId(j);
        this.iCD.sendMessage(this.iCC);
    }

    public GroupActivityData cnc() {
        return this.iCE;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.iCE = groupActivityData;
        }
    }
}
