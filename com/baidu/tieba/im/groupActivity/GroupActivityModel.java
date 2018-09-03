package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int acZ;
    private RequestGetGroupActivityMessage euC;
    private RequestGetGroupActivityLocalMessage euD;
    private RequestDelGroupActivityMessage euE;
    private GroupActivityActivity euF;
    private GroupActivityData euG;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.euF = groupActivityActivity;
    }

    public int aKT() {
        return this.mFrom;
    }

    public void oi(int i) {
        this.mFrom = i;
    }

    public int aKU() {
        return this.acZ;
    }

    public void oj(int i) {
        this.acZ = i;
    }

    public long aKV() {
        return this.mGroupId;
    }

    public void cc(long j) {
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

    private RequestGetGroupActivityMessage ok(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage ol(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.euC = ok(i);
        this.euF.sendMessage(this.euC);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void om(int i) {
        this.euD = ol(i);
        this.euF.sendMessage(this.euD);
    }

    public Message<?> getLocalSendMsg() {
        return this.euD;
    }

    public Message<?> getSendMsg() {
        return this.euC;
    }

    public Message<?> aKW() {
        return this.euE;
    }

    public void j(long j, int i) {
        this.euE = new RequestDelGroupActivityMessage();
        this.euE.setActivityId(i);
        this.euE.setGroupId(j);
        this.euF.sendMessage(this.euE);
    }

    public GroupActivityData aKX() {
        return this.euG;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.euG = groupActivityData;
        }
    }
}
