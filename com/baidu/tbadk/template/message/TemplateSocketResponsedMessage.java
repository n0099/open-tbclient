package com.baidu.tbadk.template.message;

import android.util.Log;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import d.b.h0.x0.c.b;
/* loaded from: classes3.dex */
public class TemplateSocketResponsedMessage extends SocketResponsedMessage {
    public b mIResp;

    public TemplateSocketResponsedMessage(int i) {
        super(i);
    }

    private TemplateNetMessage getTemplateNetMessage() {
        if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof TemplateNetMessage)) {
            return null;
        }
        return (TemplateNetMessage) getOrginalMessage().getExtra();
    }

    public b getIResp() {
        return this.mIResp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        TemplateNetMessage templateNetMessage = getTemplateNetMessage();
        if (templateNetMessage == null || templateNetMessage.getIResp() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        TemplateNetMessage templateNetMessage = getTemplateNetMessage();
        if (templateNetMessage == null || templateNetMessage.getIResp() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Log.i("Template", "TemplateSocketResponsedMessage-->decodeInBackGround");
        TemplateNetMessage templateNetMessage = getTemplateNetMessage();
        if (templateNetMessage == null || templateNetMessage.getIResp() == null) {
            return;
        }
        b iResp = templateNetMessage.getIResp();
        this.mIResp = iResp;
        iResp.a(i, bArr);
        setError(this.mIResp.getErrorCode());
        setErrorString(this.mIResp.b());
    }
}
