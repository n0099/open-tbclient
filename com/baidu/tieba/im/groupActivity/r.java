package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e {
    private int aZo;
    private RequestGetGroupActivityMessage aZp;
    private RequestGetGroupActivityLocalMessage aZq;
    private RequestDelGroupActivityMessage aZr;
    private GroupActivityData aZs;
    private BaseActivity mActivity;
    private int mFrom;
    private long mGroupId;

    public r(BaseActivity baseActivity) {
        super(baseActivity);
        this.mActivity = baseActivity;
    }

    public int Oi() {
        return this.mFrom;
    }

    public void fM(int i) {
        this.mFrom = i;
    }

    public int Oj() {
        return this.aZo;
    }

    public void fN(int i) {
        this.aZo = i;
    }

    public long Ok() {
        return this.mGroupId;
    }

    public void S(long j) {
        this.mGroupId = j;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private RequestGetGroupActivityMessage fO(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage fP(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.aZp = fO(i);
        this.mActivity.sendMessage(this.aZp);
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
    }

    public void fQ(int i) {
        this.aZq = fP(i);
        this.mActivity.sendMessage(this.aZq);
    }

    public Message<?> getLocalSendMsg() {
        return this.aZq;
    }

    public Message<?> getSendMsg() {
        return this.aZp;
    }

    public Message<?> Ol() {
        return this.aZr;
    }

    public void a(long j, int i) {
        this.aZr = new RequestDelGroupActivityMessage();
        this.aZr.setActivityId(i);
        this.aZr.setGroupId((int) j);
        this.mActivity.sendMessage(this.aZr);
    }

    public GroupActivityData Om() {
        return this.aZs;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.aZs = groupActivityData;
        }
    }
}
