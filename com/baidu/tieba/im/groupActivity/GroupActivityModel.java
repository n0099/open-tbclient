package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int alk;
    private RequestGetGroupActivityMessage eKX;
    private RequestGetGroupActivityLocalMessage eKY;
    private RequestDelGroupActivityMessage eKZ;
    private GroupActivityActivity eLa;
    private GroupActivityData eLb;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eLa = groupActivityActivity;
    }

    public int aPU() {
        return this.mFrom;
    }

    public void pD(int i) {
        this.mFrom = i;
    }

    public int aPV() {
        return this.alk;
    }

    public void pE(int i) {
        this.alk = i;
    }

    public long aPW() {
        return this.mGroupId;
    }

    public void ci(long j) {
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

    private RequestGetGroupActivityMessage pF(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage pG(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eKX = pF(i);
        this.eLa.sendMessage(this.eKX);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void pH(int i) {
        this.eKY = pG(i);
        this.eLa.sendMessage(this.eKY);
    }

    public Message<?> getLocalSendMsg() {
        return this.eKY;
    }

    public Message<?> getSendMsg() {
        return this.eKX;
    }

    public Message<?> aPX() {
        return this.eKZ;
    }

    public void m(long j, int i) {
        this.eKZ = new RequestDelGroupActivityMessage();
        this.eKZ.setActivityId(i);
        this.eKZ.setGroupId(j);
        this.eLa.sendMessage(this.eKZ);
    }

    public GroupActivityData aPY() {
        return this.eLb;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eLb = groupActivityData;
        }
    }
}
