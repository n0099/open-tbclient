package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes22.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dQa;
    private RequestGetGroupActivityMessage jAl;
    private RequestGetGroupActivityLocalMessage jAm;
    private RequestDelGroupActivityMessage jAn;
    private GroupActivityActivity jAo;
    private GroupActivityData jAp;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jAo = groupActivityActivity;
    }

    public int cJt() {
        return this.mFrom;
    }

    public void BN(int i) {
        this.mFrom = i;
    }

    public int cJu() {
        return this.dQa;
    }

    public void BO(int i) {
        this.dQa = i;
    }

    public long cJv() {
        return this.mGroupId;
    }

    public void fs(long j) {
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

    private RequestGetGroupActivityMessage BP(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage BQ(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.jAl = BP(i);
        this.jAo.sendMessage(this.jAl);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void BR(int i) {
        this.jAm = BQ(i);
        this.jAo.sendMessage(this.jAm);
    }

    public Message<?> getLocalSendMsg() {
        return this.jAm;
    }

    public Message<?> getSendMsg() {
        return this.jAl;
    }

    public Message<?> cJw() {
        return this.jAn;
    }

    public void v(long j, int i) {
        this.jAn = new RequestDelGroupActivityMessage();
        this.jAn.setActivityId(i);
        this.jAn.setGroupId(j);
        this.jAo.sendMessage(this.jAn);
    }

    public GroupActivityData cJx() {
        return this.jAp;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.jAp = groupActivityData;
        }
    }
}
