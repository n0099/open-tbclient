package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes23.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int evJ;
    private RequestGetGroupActivityMessage kvL;
    private RequestGetGroupActivityLocalMessage kvM;
    private RequestDelGroupActivityMessage kvN;
    private GroupActivityActivity kvO;
    private GroupActivityData kvP;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kvO = groupActivityActivity;
    }

    public int cXC() {
        return this.mFrom;
    }

    public void Em(int i) {
        this.mFrom = i;
    }

    public int cXD() {
        return this.evJ;
    }

    public void En(int i) {
        this.evJ = i;
    }

    public long cXE() {
        return this.mGroupId;
    }

    public void gP(long j) {
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

    private RequestGetGroupActivityMessage Eo(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage Ep(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.kvL = Eo(i);
        this.kvO.sendMessage(this.kvL);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void Eq(int i) {
        this.kvM = Ep(i);
        this.kvO.sendMessage(this.kvM);
    }

    public Message<?> getLocalSendMsg() {
        return this.kvM;
    }

    public Message<?> getSendMsg() {
        return this.kvL;
    }

    public Message<?> cXF() {
        return this.kvN;
    }

    public void F(long j, int i) {
        this.kvN = new RequestDelGroupActivityMessage();
        this.kvN.setActivityId(i);
        this.kvN.setGroupId(j);
        this.kvO.sendMessage(this.kvN);
    }

    public GroupActivityData cXG() {
        return this.kvP;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.kvP = groupActivityData;
        }
    }
}
