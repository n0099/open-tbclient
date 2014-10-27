package com.baidu.tbadk.message.http;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class TbHttpResponsedMessage extends HttpResponsedMessage {
    public TbHttpResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String parseToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, getCharset());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getCharset() {
        int indexOf;
        String contentType = getContentType();
        if (contentType == null || (indexOf = contentType.indexOf("charset")) == -1) {
            return "utf-8";
        }
        int indexOf2 = contentType.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return contentType.substring(indexOf + 8);
        }
        return contentType.substring(indexOf + 8, indexOf2);
    }

    private int getMode(int i) {
        switch (i) {
            case 1:
            default:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    @Override // com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, e eVar) {
        if (eVar.dS().size() > 0) {
            d dVar = eVar.dS().get(eVar.dS().size() - 1);
            an.EH.addAndGet(eVar.dS().size() - 1);
            ao aoVar = new ao();
            aoVar.mMode = getMode(j.fm());
            aoVar.mSize = dVar.kl;
            aoVar.mTime = dVar.kp;
            aoVar.EJ = dVar.retry;
            aoVar.EI = eVar.dQ().getMethod() == HttpMessageTask.HTTP_METHOD.POST ? 1 : 2;
            an.a(aoVar);
        }
    }
}
