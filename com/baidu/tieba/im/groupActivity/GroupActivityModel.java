package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int akx;
    private RequestGetGroupActivityMessage eJE;
    private RequestGetGroupActivityLocalMessage eJF;
    private RequestDelGroupActivityMessage eJG;
    private GroupActivityActivity eJH;
    private GroupActivityData eJI;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eJH = groupActivityActivity;
    }

    public int aQx() {
        return this.mFrom;
    }

    public void pk(int i) {
        this.mFrom = i;
    }

    public int aQy() {
        return this.akx;
    }

    public void pl(int i) {
        this.akx = i;
    }

    public long aQz() {
        return this.mGroupId;
    }

    public void cn(long j) {
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

    private RequestGetGroupActivityMessage pm(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage pn(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eJE = pm(i);
        this.eJH.sendMessage(this.eJE);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void po(int i) {
        this.eJF = pn(i);
        this.eJH.sendMessage(this.eJF);
    }

    public Message<?> getLocalSendMsg() {
        return this.eJF;
    }

    public Message<?> getSendMsg() {
        return this.eJE;
    }

    public Message<?> aQA() {
        return this.eJG;
    }

    public void m(long j, int i) {
        this.eJG = new RequestDelGroupActivityMessage();
        this.eJG.setActivityId(i);
        this.eJG.setGroupId(j);
        this.eJH.sendMessage(this.eJG);
    }

    public GroupActivityData aQB() {
        return this.eJI;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eJI = groupActivityData;
        }
    }
}
