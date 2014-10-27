package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.RequestQueryGroupLocMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
/* loaded from: classes.dex */
public class RequestGroupLocModel extends e {
    private int groupId;
    private String lat;
    private String lng;
    private RequestQueryGroupLocMessage sentMsg;

    public RequestGroupLocModel(Context context) {
        super(context);
        this.sentMsg = null;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    private RequestQueryGroupLocMessage createMessage() {
        RequestQueryGroupLocMessage requestQueryGroupLocMessage = new RequestQueryGroupLocMessage();
        requestQueryGroupLocMessage.setLng(this.lng);
        requestQueryGroupLocMessage.setLat(this.lat);
        requestQueryGroupLocMessage.setGroupId(this.groupId);
        return requestQueryGroupLocMessage;
    }

    public void sendMessage() {
        this.sentMsg = createMessage();
        super.sendMessage(this.sentMsg);
    }

    public void sendLocalMessage(ResponseRequestGroupLocMessage responseRequestGroupLocMessage) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(responseRequestGroupLocMessage);
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        this.sentMsg = null;
        super.cancelMessage();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
