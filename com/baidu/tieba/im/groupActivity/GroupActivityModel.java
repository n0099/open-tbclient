package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes17.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dNX;
    private RequestGetGroupActivityMessage jrJ;
    private RequestGetGroupActivityLocalMessage jrK;
    private RequestDelGroupActivityMessage jrL;
    private GroupActivityActivity jrM;
    private GroupActivityData jrN;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jrM = groupActivityActivity;
    }

    public int cFN() {
        return this.mFrom;
    }

    public void Bm(int i) {
        this.mFrom = i;
    }

    public int cFO() {
        return this.dNX;
    }

    public void Bn(int i) {
        this.dNX = i;
    }

    public long cFP() {
        return this.mGroupId;
    }

    public void fe(long j) {
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

    private RequestGetGroupActivityMessage Bo(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage Bp(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.jrJ = Bo(i);
        this.jrM.sendMessage(this.jrJ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void Bq(int i) {
        this.jrK = Bp(i);
        this.jrM.sendMessage(this.jrK);
    }

    public Message<?> getLocalSendMsg() {
        return this.jrK;
    }

    public Message<?> getSendMsg() {
        return this.jrJ;
    }

    public Message<?> cFQ() {
        return this.jrL;
    }

    public void s(long j, int i) {
        this.jrL = new RequestDelGroupActivityMessage();
        this.jrL.setActivityId(i);
        this.jrL.setGroupId(j);
        this.jrM.sendMessage(this.jrL);
    }

    public GroupActivityData cFR() {
        return this.jrN;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.jrN = groupActivityData;
        }
    }
}
