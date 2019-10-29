package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int bRf;
    private RequestGetGroupActivityMessage gJv;
    private RequestGetGroupActivityLocalMessage gJw;
    private RequestDelGroupActivityMessage gJx;
    private GroupActivityActivity gJy;
    private GroupActivityData gJz;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gJy = groupActivityActivity;
    }

    public int bBL() {
        return this.mFrom;
    }

    public void ul(int i) {
        this.mFrom = i;
    }

    public int bBM() {
        return this.bRf;
    }

    public void um(int i) {
        this.bRf = i;
    }

    public long bBN() {
        return this.mGroupId;
    }

    public void dg(long j) {
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

    private RequestGetGroupActivityMessage un(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage uo(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gJv = un(i);
        this.gJy.sendMessage(this.gJv);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void up(int i) {
        this.gJw = uo(i);
        this.gJy.sendMessage(this.gJw);
    }

    public Message<?> getLocalSendMsg() {
        return this.gJw;
    }

    public Message<?> getSendMsg() {
        return this.gJv;
    }

    public Message<?> bBO() {
        return this.gJx;
    }

    public void q(long j, int i) {
        this.gJx = new RequestDelGroupActivityMessage();
        this.gJx.setActivityId(i);
        this.gJx.setGroupId(j);
        this.gJy.sendMessage(this.gJx);
    }

    public GroupActivityData bBP() {
        return this.gJz;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gJz = groupActivityData;
        }
    }
}
