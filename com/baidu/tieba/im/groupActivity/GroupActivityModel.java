package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes23.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int ekx;
    private RequestGetGroupActivityMessage kbH;
    private RequestGetGroupActivityLocalMessage kbI;
    private RequestDelGroupActivityMessage kbJ;
    private GroupActivityActivity kbK;
    private GroupActivityData kbL;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kbK = groupActivityActivity;
    }

    public int cQj() {
        return this.mFrom;
    }

    public void CM(int i) {
        this.mFrom = i;
    }

    public int cQk() {
        return this.ekx;
    }

    public void CN(int i) {
        this.ekx = i;
    }

    public long cQl() {
        return this.mGroupId;
    }

    public void fL(long j) {
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

    private RequestGetGroupActivityMessage CO(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage CP(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.kbH = CO(i);
        this.kbK.sendMessage(this.kbH);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void CQ(int i) {
        this.kbI = CP(i);
        this.kbK.sendMessage(this.kbI);
    }

    public Message<?> getLocalSendMsg() {
        return this.kbI;
    }

    public Message<?> getSendMsg() {
        return this.kbH;
    }

    public Message<?> cQm() {
        return this.kbJ;
    }

    public void z(long j, int i) {
        this.kbJ = new RequestDelGroupActivityMessage();
        this.kbJ.setActivityId(i);
        this.kbJ.setGroupId(j);
        this.kbK.sendMessage(this.kbJ);
    }

    public GroupActivityData cQn() {
        return this.kbL;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.kbL = groupActivityData;
        }
    }
}
