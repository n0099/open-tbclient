package com.baidu.tbadk.message.http;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.j;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.core.util.ab;
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
            return IoUtils.UTF_8;
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
        if (eVar.hX().size() > 0) {
            d dVar = eVar.hX().get(eVar.hX().size() - 1);
            ab.aqk.addAndGet(eVar.hX().size() - 1);
            ab.a aVar = new ab.a();
            aVar.mMode = getMode(j.jJ());
            aVar.aqm = dVar.zD;
            aVar.mTime = dVar.zG;
            aVar.aqn = dVar.zF;
            aVar.aql = eVar.hV().getMethod() == HttpMessageTask.HTTP_METHOD.POST ? 1 : 2;
            ab.a(aVar);
        }
    }
}
