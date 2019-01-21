package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int akk;
    private RequestGetGroupActivityMessage eVr;
    private RequestGetGroupActivityLocalMessage eVs;
    private RequestDelGroupActivityMessage eVt;
    private GroupActivityActivity eVu;
    private GroupActivityData eVv;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eVu = groupActivityActivity;
    }

    public int aSZ() {
        return this.mFrom;
    }

    public void ql(int i) {
        this.mFrom = i;
    }

    public int aTa() {
        return this.akk;
    }

    public void qm(int i) {
        this.akk = i;
    }

    public long aTb() {
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

    private RequestGetGroupActivityMessage qn(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage qo(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eVr = qn(i);
        this.eVu.sendMessage(this.eVr);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void qp(int i) {
        this.eVs = qo(i);
        this.eVu.sendMessage(this.eVs);
    }

    public Message<?> getLocalSendMsg() {
        return this.eVs;
    }

    public Message<?> getSendMsg() {
        return this.eVr;
    }

    public Message<?> aTc() {
        return this.eVt;
    }

    public void m(long j, int i) {
        this.eVt = new RequestDelGroupActivityMessage();
        this.eVt.setActivityId(i);
        this.eVt.setGroupId(j);
        this.eVu.sendMessage(this.eVt);
    }

    public GroupActivityData aTd() {
        return this.eVv;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eVv = groupActivityData;
        }
    }
}
