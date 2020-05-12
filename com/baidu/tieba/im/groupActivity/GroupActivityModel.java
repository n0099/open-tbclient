package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dgr;
    private RequestGetGroupActivityMessage inU;
    private RequestGetGroupActivityLocalMessage inV;
    private RequestDelGroupActivityMessage inW;
    private GroupActivityActivity inX;
    private GroupActivityData inY;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.inX = groupActivityActivity;
    }

    public int cgB() {
        return this.mFrom;
    }

    public void xd(int i) {
        this.mFrom = i;
    }

    public int cgC() {
        return this.dgr;
    }

    public void xe(int i) {
        this.dgr = i;
    }

    public long cgD() {
        return this.mGroupId;
    }

    public void eA(long j) {
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

    private RequestGetGroupActivityMessage xf(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage xg(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.inU = xf(i);
        this.inX.sendMessage(this.inU);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void xh(int i) {
        this.inV = xg(i);
        this.inX.sendMessage(this.inV);
    }

    public Message<?> getLocalSendMsg() {
        return this.inV;
    }

    public Message<?> getSendMsg() {
        return this.inU;
    }

    public Message<?> cgE() {
        return this.inW;
    }

    public void r(long j, int i) {
        this.inW = new RequestDelGroupActivityMessage();
        this.inW.setActivityId(i);
        this.inW.setGroupId(j);
        this.inX.sendMessage(this.inW);
    }

    public GroupActivityData cgF() {
        return this.inY;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.inY = groupActivityData;
        }
    }
}
