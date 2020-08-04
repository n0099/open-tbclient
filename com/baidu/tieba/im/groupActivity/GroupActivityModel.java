package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes17.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dEL;
    private RequestGetGroupActivityMessage jcD;
    private RequestGetGroupActivityLocalMessage jcE;
    private RequestDelGroupActivityMessage jcF;
    private GroupActivityActivity jcG;
    private GroupActivityData jcH;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jcG = groupActivityActivity;
    }

    public int cuV() {
        return this.mFrom;
    }

    public void yT(int i) {
        this.mFrom = i;
    }

    public int cuW() {
        return this.dEL;
    }

    public void yU(int i) {
        this.dEL = i;
    }

    public long cuX() {
        return this.mGroupId;
    }

    public void eS(long j) {
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

    private RequestGetGroupActivityMessage yV(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage yW(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.jcD = yV(i);
        this.jcG.sendMessage(this.jcD);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void yX(int i) {
        this.jcE = yW(i);
        this.jcG.sendMessage(this.jcE);
    }

    public Message<?> getLocalSendMsg() {
        return this.jcE;
    }

    public Message<?> getSendMsg() {
        return this.jcD;
    }

    public Message<?> cuY() {
        return this.jcF;
    }

    public void s(long j, int i) {
        this.jcF = new RequestDelGroupActivityMessage();
        this.jcF.setActivityId(i);
        this.jcF.setGroupId(j);
        this.jcG.sendMessage(this.jcF);
    }

    public GroupActivityData cuZ() {
        return this.jcH;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.jcH = groupActivityData;
        }
    }
}
