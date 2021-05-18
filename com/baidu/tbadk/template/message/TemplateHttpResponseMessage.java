package com.baidu.tbadk.template.message;

import android.util.Log;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import d.a.j0.x0.c.b;
/* loaded from: classes3.dex */
public class TemplateHttpResponseMessage extends TbHttpResponsedMessage {
    public b mIResp;

    public TemplateHttpResponseMessage(int i2) {
        super(i2);
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
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        TemplateNetMessage templateNetMessage = getTemplateNetMessage();
        if (templateNetMessage == null || templateNetMessage.getIResp() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i2, byte[] bArr) {
        TemplateNetMessage templateNetMessage = getTemplateNetMessage();
        if (templateNetMessage == null || templateNetMessage.getIResp() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Log.i("Template", "TemplateHttpResponseMessage-->decodeInBackGround");
        TemplateNetMessage templateNetMessage = getTemplateNetMessage();
        if (templateNetMessage == null || templateNetMessage.getIResp() == null) {
            return;
        }
        b iResp = templateNetMessage.getIResp();
        this.mIResp = iResp;
        iResp.a(i2, bArr);
        setError(this.mIResp.getErrorCode());
        setErrorString(this.mIResp.b());
    }
}
