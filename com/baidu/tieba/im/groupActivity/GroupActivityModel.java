package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int Vg;
    private RequestGetGroupActivityMessage ebF;
    private RequestGetGroupActivityLocalMessage ebG;
    private RequestDelGroupActivityMessage ebH;
    private GroupActivityActivity ebI;
    private GroupActivityData ebJ;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.ebI = groupActivityActivity;
    }

    public int aEt() {
        return this.mFrom;
    }

    public void nB(int i) {
        this.mFrom = i;
    }

    public int aEu() {
        return this.Vg;
    }

    public void nC(int i) {
        this.Vg = i;
    }

    public long aEv() {
        return this.mGroupId;
    }

    public void bV(long j) {
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

    private RequestGetGroupActivityMessage nD(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage nE(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.ebF = nD(i);
        this.ebI.sendMessage(this.ebF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void nF(int i) {
        this.ebG = nE(i);
        this.ebI.sendMessage(this.ebG);
    }

    public Message<?> getLocalSendMsg() {
        return this.ebG;
    }

    public Message<?> getSendMsg() {
        return this.ebF;
    }

    public Message<?> aEw() {
        return this.ebH;
    }

    public void j(long j, int i) {
        this.ebH = new RequestDelGroupActivityMessage();
        this.ebH.setActivityId(i);
        this.ebH.setGroupId(j);
        this.ebI.sendMessage(this.ebH);
    }

    public GroupActivityData aEx() {
        return this.ebJ;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.ebJ = groupActivityData;
        }
    }
}
