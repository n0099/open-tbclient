package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes7.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int cCP;
    private RequestGetGroupActivityMessage hwI;
    private RequestGetGroupActivityLocalMessage hwJ;
    private RequestDelGroupActivityMessage hwK;
    private GroupActivityActivity hwL;
    private GroupActivityData hwM;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hwL = groupActivityActivity;
    }

    public int bSW() {
        return this.mFrom;
    }

    public void wm(int i) {
        this.mFrom = i;
    }

    public int bSX() {
        return this.cCP;
    }

    public void wn(int i) {
        this.cCP = i;
    }

    public long bSY() {
        return this.mGroupId;
    }

    public void dL(long j) {
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

    private RequestGetGroupActivityMessage wo(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage wp(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.hwI = wo(i);
        this.hwL.sendMessage(this.hwI);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void wq(int i) {
        this.hwJ = wp(i);
        this.hwL.sendMessage(this.hwJ);
    }

    public Message<?> getLocalSendMsg() {
        return this.hwJ;
    }

    public Message<?> getSendMsg() {
        return this.hwI;
    }

    public Message<?> bSZ() {
        return this.hwK;
    }

    public void r(long j, int i) {
        this.hwK = new RequestDelGroupActivityMessage();
        this.hwK.setActivityId(i);
        this.hwK.setGroupId(j);
        this.hwL.sendMessage(this.hwK);
    }

    public GroupActivityData bTa() {
        return this.hwM;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.hwM = groupActivityData;
        }
    }
}
