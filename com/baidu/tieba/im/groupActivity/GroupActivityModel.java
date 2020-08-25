package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes17.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dNT;
    private RequestGetGroupActivityMessage jrD;
    private RequestGetGroupActivityLocalMessage jrE;
    private RequestDelGroupActivityMessage jrF;
    private GroupActivityActivity jrG;
    private GroupActivityData jrH;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jrG = groupActivityActivity;
    }

    public int cFM() {
        return this.mFrom;
    }

    public void Bm(int i) {
        this.mFrom = i;
    }

    public int cFN() {
        return this.dNT;
    }

    public void Bn(int i) {
        this.dNT = i;
    }

    public long cFO() {
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
        this.jrD = Bo(i);
        this.jrG.sendMessage(this.jrD);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void Bq(int i) {
        this.jrE = Bp(i);
        this.jrG.sendMessage(this.jrE);
    }

    public Message<?> getLocalSendMsg() {
        return this.jrE;
    }

    public Message<?> getSendMsg() {
        return this.jrD;
    }

    public Message<?> cFP() {
        return this.jrF;
    }

    public void s(long j, int i) {
        this.jrF = new RequestDelGroupActivityMessage();
        this.jrF.setActivityId(i);
        this.jrF.setGroupId(j);
        this.jrG.sendMessage(this.jrF);
    }

    public GroupActivityData cFQ() {
        return this.jrH;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.jrH = groupActivityData;
        }
    }
}
