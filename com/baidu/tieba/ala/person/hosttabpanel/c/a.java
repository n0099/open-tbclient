package com.baidu.tieba.ala.person.hosttabpanel.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private int FIRST_PN;
    private long fTw;
    private int gxY;
    private long mGroupId;
    private HttpMessageListener mHttpMessageListener;
    private int mPn;
    private long mUserId;

    /* renamed from: com.baidu.tieba.ala.person.hosttabpanel.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0592a {
    }

    public void refreshData() {
        this.mPn = this.FIRST_PN;
        sendMessage(new com.baidu.tieba.ala.person.hosttabpanel.message.a(this.mPn, this.gxY, this.mUserId, this.fTw, this.mGroupId));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
    }
}
