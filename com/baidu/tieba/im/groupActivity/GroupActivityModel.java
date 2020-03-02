package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int cGZ;
    private RequestGetGroupActivityMessage hCm;
    private RequestGetGroupActivityLocalMessage hCn;
    private RequestDelGroupActivityMessage hCo;
    private GroupActivityActivity hCp;
    private GroupActivityData hCq;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hCp = groupActivityActivity;
    }

    public int bVI() {
        return this.mFrom;
    }

    public void wx(int i) {
        this.mFrom = i;
    }

    public int bVJ() {
        return this.cGZ;
    }

    public void wy(int i) {
        this.cGZ = i;
    }

    public long bVK() {
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
        this.hCm = wz(i);
        this.hCp.sendMessage(this.hCm);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void wB(int i) {
        this.hCn = wA(i);
        this.hCp.sendMessage(this.hCn);
    }

    public Message<?> getLocalSendMsg() {
        return this.hCn;
    }

    public Message<?> getSendMsg() {
        return this.hCm;
    }

    public Message<?> bVL() {
        return this.hCo;
    }

    public void r(long j, int i) {
        this.hCo = new RequestDelGroupActivityMessage();
        this.hCo.setActivityId(i);
        this.hCo.setGroupId(j);
        this.hCp.sendMessage(this.hCo);
    }

    public GroupActivityData bVM() {
        return this.hCq;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.hCq = groupActivityData;
        }
    }
}
