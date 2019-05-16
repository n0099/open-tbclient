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
    private RequestGetGroupActivityLocalMessage gCA;
    private RequestDelGroupActivityMessage gCB;
    private GroupActivityActivity gCC;
    private GroupActivityData gCD;
    private RequestGetGroupActivityMessage gCz;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gCC = groupActivityActivity;
    }

    public int bBn() {
        return this.mFrom;
    }

    public void uY(int i) {
        this.mFrom = i;
    }

    public int bBo() {
        return this.bxk;
    }

    public void uZ(int i) {
        this.bxk = i;
    }

    public long bBp() {
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
        this.gCz = va(i);
        this.gCC.sendMessage(this.gCz);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void vc(int i) {
        this.gCA = vb(i);
        this.gCC.sendMessage(this.gCA);
    }

    public Message<?> getLocalSendMsg() {
        return this.gCA;
    }

    public Message<?> getSendMsg() {
        return this.gCz;
    }

    public Message<?> bBq() {
        return this.gCB;
    }

    public void p(long j, int i) {
        this.gCB = new RequestDelGroupActivityMessage();
        this.gCB.setActivityId(i);
        this.gCB.setGroupId(j);
        this.gCC.sendMessage(this.gCB);
    }

    public GroupActivityData bBr() {
        return this.gCD;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gCD = groupActivityData;
        }
    }
}
