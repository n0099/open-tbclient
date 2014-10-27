package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e {
    private int aZb;
    private RequestGetGroupActivityMessage aZc;
    private RequestGetGroupActivityLocalMessage aZd;
    private RequestDelGroupActivityMessage aZe;
    private GroupActivityData aZf;
    private BaseActivity mActivity;
    private int mFrom;
    private long mGroupId;

    public r(BaseActivity baseActivity) {
        super(baseActivity);
        this.mActivity = baseActivity;
    }

    public int Of() {
        return this.mFrom;
    }

    public void fM(int i) {
        this.mFrom = i;
    }

    public int Og() {
        return this.aZb;
    }

    public void fN(int i) {
        this.aZb = i;
    }

    public long Oh() {
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
        this.aZc = fO(i);
        this.mActivity.sendMessage(this.aZc);
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
    }

    public void fQ(int i) {
        this.aZd = fP(i);
        this.mActivity.sendMessage(this.aZd);
    }

    public Message<?> getLocalSendMsg() {
        return this.aZd;
    }

    public Message<?> getSendMsg() {
        return this.aZc;
    }

    public Message<?> Oi() {
        return this.aZe;
    }

    public void a(long j, int i) {
        this.aZe = new RequestDelGroupActivityMessage();
        this.aZe.setActivityId(i);
        this.aZe.setGroupId((int) j);
        this.mActivity.sendMessage(this.aZe);
    }

    public GroupActivityData Oj() {
        return this.aZf;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.aZf = groupActivityData;
        }
    }
}
