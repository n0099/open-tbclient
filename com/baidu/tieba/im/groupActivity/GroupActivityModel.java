package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int akb;
    private RequestGetGroupActivityMessage eUD;
    private RequestGetGroupActivityLocalMessage eUE;
    private RequestDelGroupActivityMessage eUF;
    private GroupActivityActivity eUG;
    private GroupActivityData eUH;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eUG = groupActivityActivity;
    }

    public int aSz() {
        return this.mFrom;
    }

    public void qk(int i) {
        this.mFrom = i;
    }

    public int aSA() {
        return this.akb;
    }

    public void ql(int i) {
        this.akb = i;
    }

    public long aSB() {
        return this.mGroupId;
    }

    public void cu(long j) {
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

    private RequestGetGroupActivityMessage qm(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage qn(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eUD = qm(i);
        this.eUG.sendMessage(this.eUD);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void qo(int i) {
        this.eUE = qn(i);
        this.eUG.sendMessage(this.eUE);
    }

    public Message<?> getLocalSendMsg() {
        return this.eUE;
    }

    public Message<?> getSendMsg() {
        return this.eUD;
    }

    public Message<?> aSC() {
        return this.eUF;
    }

    public void m(long j, int i) {
        this.eUF = new RequestDelGroupActivityMessage();
        this.eUF.setActivityId(i);
        this.eUF.setGroupId(j);
        this.eUG.sendMessage(this.eUF);
    }

    public GroupActivityData aSD() {
        return this.eUH;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eUH = groupActivityData;
        }
    }
}
