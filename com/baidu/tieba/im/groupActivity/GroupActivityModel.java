package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int bqT;
    private RequestGetGroupActivityMessage gll;
    private RequestGetGroupActivityLocalMessage glm;
    private RequestDelGroupActivityMessage gln;
    private GroupActivityActivity glo;
    private GroupActivityData glp;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.glo = groupActivityActivity;
    }

    public int btB() {
        return this.mFrom;
    }

    public void tR(int i) {
        this.mFrom = i;
    }

    public int btC() {
        return this.bqT;
    }

    public void tS(int i) {
        this.bqT = i;
    }

    public long btD() {
        return this.mGroupId;
    }

    public void cZ(long j) {
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

    private RequestGetGroupActivityMessage tT(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage tU(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gll = tT(i);
        this.glo.sendMessage(this.gll);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void tV(int i) {
        this.glm = tU(i);
        this.glo.sendMessage(this.glm);
    }

    public Message<?> getLocalSendMsg() {
        return this.glm;
    }

    public Message<?> getSendMsg() {
        return this.gll;
    }

    public Message<?> btE() {
        return this.gln;
    }

    public void r(long j, int i) {
        this.gln = new RequestDelGroupActivityMessage();
        this.gln.setActivityId(i);
        this.gln.setGroupId(j);
        this.glo.sendMessage(this.gln);
    }

    public GroupActivityData btF() {
        return this.glp;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.glp = groupActivityData;
        }
    }
}
