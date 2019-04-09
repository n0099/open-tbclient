package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int bqU;
    private RequestGetGroupActivityMessage glm;
    private RequestGetGroupActivityLocalMessage gln;
    private RequestDelGroupActivityMessage glo;
    private GroupActivityActivity glp;
    private GroupActivityData glq;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.glp = groupActivityActivity;
    }

    public int btB() {
        return this.mFrom;
    }

    public void tR(int i) {
        this.mFrom = i;
    }

    public int btC() {
        return this.bqU;
    }

    public void tS(int i) {
        this.bqU = i;
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
        this.glm = tT(i);
        this.glp.sendMessage(this.glm);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void tV(int i) {
        this.gln = tU(i);
        this.glp.sendMessage(this.gln);
    }

    public Message<?> getLocalSendMsg() {
        return this.gln;
    }

    public Message<?> getSendMsg() {
        return this.glm;
    }

    public Message<?> btE() {
        return this.glo;
    }

    public void r(long j, int i) {
        this.glo = new RequestDelGroupActivityMessage();
        this.glo.setActivityId(i);
        this.glo.setGroupId(j);
        this.glp.sendMessage(this.glo);
    }

    public GroupActivityData btF() {
        return this.glq;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.glq = groupActivityData;
        }
    }
}
