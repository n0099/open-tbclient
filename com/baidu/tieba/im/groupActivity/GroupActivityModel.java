package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int cHl;
    private RequestGetGroupActivityMessage hDY;
    private RequestGetGroupActivityLocalMessage hDZ;
    private RequestDelGroupActivityMessage hEa;
    private GroupActivityActivity hEb;
    private GroupActivityData hEc;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hEb = groupActivityActivity;
    }

    public int bWb() {
        return this.mFrom;
    }

    public void wF(int i) {
        this.mFrom = i;
    }

    public int bWc() {
        return this.cHl;
    }

    public void wG(int i) {
        this.cHl = i;
    }

    public long bWd() {
        return this.mGroupId;
    }

    public void dR(long j) {
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

    private RequestGetGroupActivityMessage wH(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage wI(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.hDY = wH(i);
        this.hEb.sendMessage(this.hDY);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void wJ(int i) {
        this.hDZ = wI(i);
        this.hEb.sendMessage(this.hDZ);
    }

    public Message<?> getLocalSendMsg() {
        return this.hDZ;
    }

    public Message<?> getSendMsg() {
        return this.hDY;
    }

    public Message<?> bWe() {
        return this.hEa;
    }

    public void r(long j, int i) {
        this.hEa = new RequestDelGroupActivityMessage();
        this.hEa.setActivityId(i);
        this.hEa.setGroupId(j);
        this.hEb.sendMessage(this.hEa);
    }

    public GroupActivityData bWf() {
        return this.hEc;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.hEc = groupActivityData;
        }
    }
}
