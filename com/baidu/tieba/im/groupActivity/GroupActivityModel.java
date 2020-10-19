package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes23.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int ecb;
    private RequestGetGroupActivityMessage jPi;
    private RequestGetGroupActivityLocalMessage jPj;
    private RequestDelGroupActivityMessage jPk;
    private GroupActivityActivity jPl;
    private GroupActivityData jPm;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jPl = groupActivityActivity;
    }

    public int cNc() {
        return this.mFrom;
    }

    public void Ct(int i) {
        this.mFrom = i;
    }

    public int cNd() {
        return this.ecb;
    }

    public void Cu(int i) {
        this.ecb = i;
    }

    public long cNe() {
        return this.mGroupId;
    }

    public void fK(long j) {
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

    private RequestGetGroupActivityMessage Cv(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage Cw(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.jPi = Cv(i);
        this.jPl.sendMessage(this.jPi);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void Cx(int i) {
        this.jPj = Cw(i);
        this.jPl.sendMessage(this.jPj);
    }

    public Message<?> getLocalSendMsg() {
        return this.jPj;
    }

    public Message<?> getSendMsg() {
        return this.jPi;
    }

    public Message<?> cNf() {
        return this.jPk;
    }

    public void z(long j, int i) {
        this.jPk = new RequestDelGroupActivityMessage();
        this.jPk.setActivityId(i);
        this.jPk.setGroupId(j);
        this.jPl.sendMessage(this.jPk);
    }

    public GroupActivityData cNg() {
        return this.jPm;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.jPm = groupActivityData;
        }
    }
}
