package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int afA;
    private RequestGetGroupActivityMessage eBV;
    private RequestGetGroupActivityLocalMessage eBW;
    private RequestDelGroupActivityMessage eBX;
    private GroupActivityActivity eBY;
    private GroupActivityData eBZ;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eBY = groupActivityActivity;
    }

    public int aNi() {
        return this.mFrom;
    }

    public void oM(int i) {
        this.mFrom = i;
    }

    public int aNj() {
        return this.afA;
    }

    public void oN(int i) {
        this.afA = i;
    }

    public long aNk() {
        return this.mGroupId;
    }

    public void cg(long j) {
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

    private RequestGetGroupActivityMessage oO(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage oP(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.eBV = oO(i);
        this.eBY.sendMessage(this.eBV);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void oQ(int i) {
        this.eBW = oP(i);
        this.eBY.sendMessage(this.eBW);
    }

    public Message<?> getLocalSendMsg() {
        return this.eBW;
    }

    public Message<?> getSendMsg() {
        return this.eBV;
    }

    public Message<?> aNl() {
        return this.eBX;
    }

    public void m(long j, int i) {
        this.eBX = new RequestDelGroupActivityMessage();
        this.eBX.setActivityId(i);
        this.eBX.setGroupId(j);
        this.eBY.sendMessage(this.eBX);
    }

    public GroupActivityData aNm() {
        return this.eBZ;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.eBZ = groupActivityData;
        }
    }
}
