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
    private RequestGetGroupActivityMessage eJF;
    private RequestGetGroupActivityLocalMessage eJG;
    private RequestDelGroupActivityMessage eJH;
    private GroupActivityActivity eJI;
    private GroupActivityData eJJ;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eJI = groupActivityActivity;
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
        this.eJF = pm(i);
        this.eJI.sendMessage(this.eJF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void po(int i) {
        this.eJG = pn(i);
        this.eJI.sendMessage(this.eJG);
    }

    public Message<?> getLocalSendMsg() {
        return this.eJG;
    }

    public Message<?> getSendMsg() {
        return this.eJF;
    }

    public Message<?> aQA() {
        return this.eJH;
    }

    public void m(long j, int i) {
        this.eJH = new RequestDelGroupActivityMessage();
        this.eJH.setActivityId(i);
        this.eJH.setGroupId(j);
        this.eJI.sendMessage(this.eJH);
    }

    public GroupActivityData aQB() {
        return this.eJJ;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eJJ = groupActivityData;
        }
    }
}
