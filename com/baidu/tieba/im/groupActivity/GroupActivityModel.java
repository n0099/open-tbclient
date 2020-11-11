package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes23.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int eqr;
    private RequestGetGroupActivityMessage khE;
    private RequestGetGroupActivityLocalMessage khF;
    private RequestDelGroupActivityMessage khG;
    private GroupActivityActivity khH;
    private GroupActivityData khI;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.khH = groupActivityActivity;
    }

    public int cSK() {
        return this.mFrom;
    }

    public void CZ(int i) {
        this.mFrom = i;
    }

    public int cSL() {
        return this.eqr;
    }

    public void Da(int i) {
        this.eqr = i;
    }

    public long cSM() {
        return this.mGroupId;
    }

    public void gh(long j) {
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

    private RequestGetGroupActivityMessage Db(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage Dc(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.khE = Db(i);
        this.khH.sendMessage(this.khE);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void Dd(int i) {
        this.khF = Dc(i);
        this.khH.sendMessage(this.khF);
    }

    public Message<?> getLocalSendMsg() {
        return this.khF;
    }

    public Message<?> getSendMsg() {
        return this.khE;
    }

    public Message<?> cSN() {
        return this.khG;
    }

    public void D(long j, int i) {
        this.khG = new RequestDelGroupActivityMessage();
        this.khG.setActivityId(i);
        this.khG.setGroupId(j);
        this.khH.sendMessage(this.khG);
    }

    public GroupActivityData cSO() {
        return this.khI;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.khI = groupActivityData;
        }
    }
}
