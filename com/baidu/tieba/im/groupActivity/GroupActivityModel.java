package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes3.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int acY;
    private RequestGetGroupActivityMessage euG;
    private RequestGetGroupActivityLocalMessage euH;
    private RequestDelGroupActivityMessage euI;
    private GroupActivityActivity euJ;
    private GroupActivityData euK;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.euJ = groupActivityActivity;
    }

    public int aKW() {
        return this.mFrom;
    }

    public void oi(int i) {
        this.mFrom = i;
    }

    public int aKX() {
        return this.acY;
    }

    public void oj(int i) {
        this.acY = i;
    }

    public long aKY() {
        return this.mGroupId;
    }

    public void cc(long j) {
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

    private RequestGetGroupActivityMessage ok(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage ol(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.euG = ok(i);
        this.euJ.sendMessage(this.euG);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void om(int i) {
        this.euH = ol(i);
        this.euJ.sendMessage(this.euH);
    }

    public Message<?> getLocalSendMsg() {
        return this.euH;
    }

    public Message<?> getSendMsg() {
        return this.euG;
    }

    public Message<?> aKZ() {
        return this.euI;
    }

    public void j(long j, int i) {
        this.euI = new RequestDelGroupActivityMessage();
        this.euI.setActivityId(i);
        this.euI.setGroupId(j);
        this.euJ.sendMessage(this.euI);
    }

    public GroupActivityData aLa() {
        return this.euK;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.euK = groupActivityData;
        }
    }
}
