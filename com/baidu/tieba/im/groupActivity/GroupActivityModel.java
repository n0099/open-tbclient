package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dgm;
    private RequestGetGroupActivityMessage inO;
    private RequestGetGroupActivityLocalMessage inP;
    private RequestDelGroupActivityMessage inQ;
    private GroupActivityActivity inR;
    private GroupActivityData inS;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.inR = groupActivityActivity;
    }

    public int cgC() {
        return this.mFrom;
    }

    public void xd(int i) {
        this.mFrom = i;
    }

    public int cgD() {
        return this.dgm;
    }

    public void xe(int i) {
        this.dgm = i;
    }

    public long cgE() {
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
        this.inO = xf(i);
        this.inR.sendMessage(this.inO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void xh(int i) {
        this.inP = xg(i);
        this.inR.sendMessage(this.inP);
    }

    public Message<?> getLocalSendMsg() {
        return this.inP;
    }

    public Message<?> getSendMsg() {
        return this.inO;
    }

    public Message<?> cgF() {
        return this.inQ;
    }

    public void r(long j, int i) {
        this.inQ = new RequestDelGroupActivityMessage();
        this.inQ.setActivityId(i);
        this.inQ.setGroupId(j);
        this.inR.sendMessage(this.inQ);
    }

    public GroupActivityData cgG() {
        return this.inS;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.inS = groupActivityData;
        }
    }
}
