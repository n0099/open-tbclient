package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int cGY;
    private RequestGetGroupActivityMessage hCk;
    private RequestGetGroupActivityLocalMessage hCl;
    private RequestDelGroupActivityMessage hCm;
    private GroupActivityActivity hCn;
    private GroupActivityData hCo;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hCn = groupActivityActivity;
    }

    public int bVG() {
        return this.mFrom;
    }

    public void wx(int i) {
        this.mFrom = i;
    }

    public int bVH() {
        return this.cGY;
    }

    public void wy(int i) {
        this.cGY = i;
    }

    public long bVI() {
        return this.mGroupId;
    }

    public void dQ(long j) {
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

    private RequestGetGroupActivityMessage wz(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage wA(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.hCk = wz(i);
        this.hCn.sendMessage(this.hCk);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void wB(int i) {
        this.hCl = wA(i);
        this.hCn.sendMessage(this.hCl);
    }

    public Message<?> getLocalSendMsg() {
        return this.hCl;
    }

    public Message<?> getSendMsg() {
        return this.hCk;
    }

    public Message<?> bVJ() {
        return this.hCm;
    }

    public void r(long j, int i) {
        this.hCm = new RequestDelGroupActivityMessage();
        this.hCm.setActivityId(i);
        this.hCm.setGroupId(j);
        this.hCn.sendMessage(this.hCm);
    }

    public GroupActivityData bVK() {
        return this.hCo;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.hCo = groupActivityData;
        }
    }
}
