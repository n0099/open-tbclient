package com.baidu.tbadk.message.http;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.ac;
/* loaded from: classes.dex */
public class TbHttpResponsedMessage extends HttpResponsedMessage {
    public TbHttpResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String parseToString(byte[] bArr) throws Exception {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, getCharset());
    }

    protected String getCharset() throws Exception {
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
    public void logStatInBackground(int i, f fVar) {
        if (fVar.ep().size() > 0) {
            e eVar = fVar.ep().get(fVar.ep().size() - 1);
            ac.ZU.addAndGet(fVar.ep().size() - 1);
            ac.a aVar = new ac.a();
            aVar.mMode = getMode(i.gq());
            aVar.ZW = eVar.nX;
            aVar.mTime = eVar.ob;
            aVar.ZX = eVar.oa;
            aVar.ZV = fVar.en().getMethod() == HttpMessageTask.HTTP_METHOD.POST ? 1 : 2;
            ac.a(aVar);
        }
    }
}
