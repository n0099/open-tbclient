package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes22.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int eoK;
    private RequestGetGroupActivityMessage kip;
    private RequestGetGroupActivityLocalMessage kiq;
    private RequestDelGroupActivityMessage kir;
    private GroupActivityActivity kis;
    private GroupActivityData kit;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kis = groupActivityActivity;
    }

    public int cSq() {
        return this.mFrom;
    }

    public void Dx(int i) {
        this.mFrom = i;
    }

    public int cSr() {
        return this.eoK;
    }

    public void Dy(int i) {
        this.eoK = i;
    }

    public long cSs() {
        return this.mGroupId;
    }

    public void gk(long j) {
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

    private RequestGetGroupActivityMessage Dz(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage DA(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.kip = Dz(i);
        this.kis.sendMessage(this.kip);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void DB(int i) {
        this.kiq = DA(i);
        this.kis.sendMessage(this.kiq);
    }

    public Message<?> getLocalSendMsg() {
        return this.kiq;
    }

    public Message<?> getSendMsg() {
        return this.kip;
    }

    public Message<?> cSt() {
        return this.kir;
    }

    public void D(long j, int i) {
        this.kir = new RequestDelGroupActivityMessage();
        this.kir.setActivityId(i);
        this.kir.setGroupId(j);
        this.kis.sendMessage(this.kir);
    }

    public GroupActivityData cSu() {
        return this.kit;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.kit = groupActivityData;
        }
    }
}
