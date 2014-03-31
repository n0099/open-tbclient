package com.baidu.tbadk.message.http;

import com.baidu.adp.lib.network.http.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* loaded from: classes.dex */
public class ImgHttpResponsedMessage extends TbHttpResponsedMessage {
    public ImgHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public final void a(int i, byte[] bArr) {
        if (bArr != null) {
            List<String> d = d("imgsrc");
            if ((d != null && d.size() > 0) && bArr.length > 23 && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                System.arraycopy(bArr, 23, new byte[bArr.length - 23], 0, bArr.length - 23);
            }
            a(bArr);
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public final void a(int i, e eVar) {
        super.a(i, eVar);
        TiebaStatic.a(eVar);
    }
}
