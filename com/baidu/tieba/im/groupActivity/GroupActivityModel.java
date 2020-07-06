package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes10.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int dyP;
    private RequestGetGroupActivityMessage iUr;
    private RequestGetGroupActivityLocalMessage iUs;
    private RequestDelGroupActivityMessage iUt;
    private GroupActivityActivity iUu;
    private GroupActivityData iUv;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.iUu = groupActivityActivity;
    }

    public int cqX() {
        return this.mFrom;
    }

    public void yv(int i) {
        this.mFrom = i;
    }

    public int cqY() {
        return this.dyP;
    }

    public void yw(int i) {
        this.dyP = i;
    }

    public long cqZ() {
        return this.mGroupId;
    }

    public void eE(long j) {
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

    private RequestGetGroupActivityMessage yx(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage yy(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.iUr = yx(i);
        this.iUu.sendMessage(this.iUr);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void yz(int i) {
        this.iUs = yy(i);
        this.iUu.sendMessage(this.iUs);
    }

    public Message<?> getLocalSendMsg() {
        return this.iUs;
    }

    public Message<?> getSendMsg() {
        return this.iUr;
    }

    public Message<?> cra() {
        return this.iUt;
    }

    public void r(long j, int i) {
        this.iUt = new RequestDelGroupActivityMessage();
        this.iUt.setActivityId(i);
        this.iUt.setGroupId(j);
        this.iUu.sendMessage(this.iUt);
    }

    public GroupActivityData crb() {
        return this.iUv;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.iUv = groupActivityData;
        }
    }
}
