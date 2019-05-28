package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int bxk;
    private RequestGetGroupActivityMessage gCA;
    private RequestGetGroupActivityLocalMessage gCB;
    private RequestDelGroupActivityMessage gCC;
    private GroupActivityActivity gCD;
    private GroupActivityData gCE;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gCD = groupActivityActivity;
    }

    public int bBq() {
        return this.mFrom;
    }

    public void uY(int i) {
        this.mFrom = i;
    }

    public int bBr() {
        return this.bxk;
    }

    public void uZ(int i) {
        this.bxk = i;
    }

    public long bBs() {
        return this.mGroupId;
    }

    public void dw(long j) {
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

    private RequestGetGroupActivityMessage va(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage vb(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gCA = va(i);
        this.gCD.sendMessage(this.gCA);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void vc(int i) {
        this.gCB = vb(i);
        this.gCD.sendMessage(this.gCB);
    }

    public Message<?> getLocalSendMsg() {
        return this.gCB;
    }

    public Message<?> getSendMsg() {
        return this.gCA;
    }

    public Message<?> bBt() {
        return this.gCC;
    }

    public void p(long j, int i) {
        this.gCC = new RequestDelGroupActivityMessage();
        this.gCC.setActivityId(i);
        this.gCC.setGroupId(j);
        this.gCD.sendMessage(this.gCC);
    }

    public GroupActivityData bBu() {
        return this.gCE;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gCE = groupActivityData;
        }
    }
}
