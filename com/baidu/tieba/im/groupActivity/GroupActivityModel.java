package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int byz;
    private GroupActivityData gLA;
    private RequestGetGroupActivityMessage gLw;
    private RequestGetGroupActivityLocalMessage gLx;
    private RequestDelGroupActivityMessage gLy;
    private GroupActivityActivity gLz;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gLz = groupActivityActivity;
    }

    public int bFa() {
        return this.mFrom;
    }

    public void vF(int i) {
        this.mFrom = i;
    }

    public int bFb() {
        return this.byz;
    }

    public void vG(int i) {
        this.byz = i;
    }

    public long bFc() {
        return this.mGroupId;
    }

    public void dJ(long j) {
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

    private RequestGetGroupActivityMessage vH(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage vI(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gLw = vH(i);
        this.gLz.sendMessage(this.gLw);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void vJ(int i) {
        this.gLx = vI(i);
        this.gLz.sendMessage(this.gLx);
    }

    public Message<?> getLocalSendMsg() {
        return this.gLx;
    }

    public Message<?> getSendMsg() {
        return this.gLw;
    }

    public Message<?> bFd() {
        return this.gLy;
    }

    public void p(long j, int i) {
        this.gLy = new RequestDelGroupActivityMessage();
        this.gLy.setActivityId(i);
        this.gLy.setGroupId(j);
        this.gLz.sendMessage(this.gLy);
    }

    public GroupActivityData bFe() {
        return this.gLA;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gLA = groupActivityData;
        }
    }
}
