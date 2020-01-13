package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes8.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int cDa;
    private RequestGetGroupActivityMessage hAl;
    private RequestGetGroupActivityLocalMessage hAm;
    private RequestDelGroupActivityMessage hAn;
    private GroupActivityActivity hAo;
    private GroupActivityData hAp;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hAo = groupActivityActivity;
    }

    public int bUf() {
        return this.mFrom;
    }

    public void wr(int i) {
        this.mFrom = i;
    }

    public int bUg() {
        return this.cDa;
    }

    public void ws(int i) {
        this.cDa = i;
    }

    public long bUh() {
        return this.mGroupId;
    }

    public void dQ(long j) {
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

    private RequestGetGroupActivityMessage wt(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage wu(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.hAl = wt(i);
        this.hAo.sendMessage(this.hAl);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void wv(int i) {
        this.hAm = wu(i);
        this.hAo.sendMessage(this.hAm);
    }

    public Message<?> getLocalSendMsg() {
        return this.hAm;
    }

    public Message<?> getSendMsg() {
        return this.hAl;
    }

    public Message<?> bUi() {
        return this.hAn;
    }

    public void r(long j, int i) {
        this.hAn = new RequestDelGroupActivityMessage();
        this.hAn.setActivityId(i);
        this.hAn.setGroupId(j);
        this.hAo.sendMessage(this.hAn);
    }

    public GroupActivityData bUj() {
        return this.hAp;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.hAp = groupActivityData;
        }
    }
}
