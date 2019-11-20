package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes5.dex */
public class GroupActivityModel extends BdBaseModel<GroupActivityActivity> {
    private int bQo;
    private RequestGetGroupActivityMessage gIE;
    private RequestGetGroupActivityLocalMessage gIF;
    private RequestDelGroupActivityMessage gIG;
    private GroupActivityActivity gIH;
    private GroupActivityData gII;
    private int mFrom;
    private long mGroupId;

    public GroupActivityModel(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gIH = groupActivityActivity;
    }

    public int bBJ() {
        return this.mFrom;
    }

    public void uk(int i) {
        this.mFrom = i;
    }

    public int bBK() {
        return this.bQo;
    }

    public void ul(int i) {
        this.bQo = i;
    }

    public long bBL() {
        return this.mGroupId;
    }

    public void df(long j) {
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

    private RequestGetGroupActivityMessage um(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.mFrom);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage un(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.mFrom);
        return requestGetGroupActivityLocalMessage;
    }

    public void sendMessage(int i) {
        this.gIE = um(i);
        this.gIH.sendMessage(this.gIE);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
    }

    public void uo(int i) {
        this.gIF = un(i);
        this.gIH.sendMessage(this.gIF);
    }

    public Message<?> getLocalSendMsg() {
        return this.gIF;
    }

    public Message<?> getSendMsg() {
        return this.gIE;
    }

    public Message<?> bBM() {
        return this.gIG;
    }

    public void q(long j, int i) {
        this.gIG = new RequestDelGroupActivityMessage();
        this.gIG.setActivityId(i);
        this.gIG.setGroupId(j);
        this.gIH.sendMessage(this.gIG);
    }

    public GroupActivityData bBN() {
        return this.gII;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.gII = groupActivityData;
        }
    }
}
