package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int byb;
    private RequestGetGroupActivityMessage gJE;
    private RequestGetGroupActivityLocalMessage gJF;
    private RequestDelGroupActivityMessage gJG;
    private GroupActivityActivity gJH;
    private GroupActivityData gJI;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gJH = groupActivityActivity;
    }

    public int bEm() {
        return this.mFrom;
    }

    public void vB(int i) {
        this.mFrom = i;
    }

    public int bEn() {
        return this.byb;
    }

    public void vC(int i) {
        this.byb = i;
    }

    public long bEo() {
        return this.mGroupId;
    }

    public void dG(long j) {
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

    private RequestGetGroupActivityMessage vD(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage vE(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gJE = vD(i);
        this.gJH.sendMessage(this.gJE);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void vF(int i) {
        this.gJF = vE(i);
        this.gJH.sendMessage(this.gJF);
    }

    public Message<?> getLocalSendMsg() {
        return this.gJF;
    }

    public Message<?> getSendMsg() {
        return this.gJE;
    }

    public Message<?> bEp() {
        return this.gJG;
    }

    public void p(long j, int i) {
        this.gJG = new RequestDelGroupActivityMessage();
        this.gJG.setActivityId(i);
        this.gJG.setGroupId(j);
        this.gJH.sendMessage(this.gJG);
    }

    public GroupActivityData bEq() {
        return this.gJI;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gJI = groupActivityData;
        }
    }
}
