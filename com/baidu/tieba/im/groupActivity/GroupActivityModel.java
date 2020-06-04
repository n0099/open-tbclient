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
    private RequestGetGroupActivityMessage iDn;
    private RequestGetGroupActivityLocalMessage iDo;
    private RequestDelGroupActivityMessage iDp;
    private GroupActivityActivity iDq;
    private GroupActivityData iDr;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.iDq = groupActivityActivity;
    }

    public int cnh() {
        return this.mFrom;
    }

    public void xL(int i) {
        this.mFrom = i;
    }

    public int cni() {
        return this.dug;
    }

    public void xM(int i) {
        this.dug = i;
    }

    public long cnj() {
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

    private RequestGetGroupActivityMessage xN(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage xO(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.iDn = xN(i);
        this.iDq.sendMessage(this.iDn);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void xP(int i) {
        this.iDo = xO(i);
        this.iDq.sendMessage(this.iDo);
    }

    public Message<?> getLocalSendMsg() {
        return this.iDo;
    }

    public Message<?> getSendMsg() {
        return this.iDn;
    }

    public Message<?> cnk() {
        return this.iDp;
    }

    public void r(long j, int i) {
        this.iDp = new RequestDelGroupActivityMessage();
        this.iDp.setActivityId(i);
        this.iDp.setGroupId(j);
        this.iDq.sendMessage(this.iDp);
    }

    public GroupActivityData cnl() {
        return this.iDr;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.iDr = groupActivityData;
        }
    }
}
