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
    private RequestGetGroupActivityMessage gCC;
    private RequestGetGroupActivityLocalMessage gCD;
    private RequestDelGroupActivityMessage gCE;
    private GroupActivityActivity gCF;
    private GroupActivityData gCG;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gCF = groupActivityActivity;
    }

    public int bBr() {
        return this.mFrom;
    }

    public void uY(int i) {
        this.mFrom = i;
    }

    public int bBs() {
        return this.bxk;
    }

    public void uZ(int i) {
        this.bxk = i;
    }

    public long bBt() {
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
        this.gCC = va(i);
        this.gCF.sendMessage(this.gCC);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void vc(int i) {
        this.gCD = vb(i);
        this.gCF.sendMessage(this.gCD);
    }

    public Message<?> getLocalSendMsg() {
        return this.gCD;
    }

    public Message<?> getSendMsg() {
        return this.gCC;
    }

    public Message<?> bBu() {
        return this.gCE;
    }

    public void p(long j, int i) {
        this.gCE = new RequestDelGroupActivityMessage();
        this.gCE.setActivityId(i);
        this.gCE.setGroupId(j);
        this.gCF.sendMessage(this.gCE);
    }

    public GroupActivityData bBv() {
        return this.gCG;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gCG = groupActivityData;
        }
    }
}
