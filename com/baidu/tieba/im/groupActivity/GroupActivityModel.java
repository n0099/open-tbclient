package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int aJO;
    private RequestGetGroupActivityMessage eFG;
    private RequestGetGroupActivityLocalMessage eFH;
    private RequestDelGroupActivityMessage eFI;
    private GroupActivityActivity eFJ;
    private GroupActivityData eFK;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eFJ = groupActivityActivity;
    }

    public int aJx() {
        return this.mFrom;
    }

    public void qe(int i) {
        this.mFrom = i;
    }

    public int aJy() {
        return this.aJO;
    }

    public void qf(int i) {
        this.aJO = i;
    }

    public long aJz() {
        return this.mGroupId;
    }

    public void bW(long j) {
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

    private RequestGetGroupActivityMessage qg(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage qh(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eFG = qg(i);
        this.eFJ.sendMessage(this.eFG);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void qi(int i) {
        this.eFH = qh(i);
        this.eFJ.sendMessage(this.eFH);
    }

    public Message<?> getLocalSendMsg() {
        return this.eFH;
    }

    public Message<?> getSendMsg() {
        return this.eFG;
    }

    public Message<?> aJA() {
        return this.eFI;
    }

    public void j(long j, int i) {
        this.eFI = new RequestDelGroupActivityMessage();
        this.eFI.setActivityId(i);
        this.eFI.setGroupId((int) j);
        this.eFJ.sendMessage(this.eFI);
    }

    public GroupActivityData aJB() {
        return this.eFK;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eFK = groupActivityData;
        }
    }
}
