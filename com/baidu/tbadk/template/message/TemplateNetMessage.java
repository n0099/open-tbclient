package com.baidu.tbadk.template.message;

import android.util.Log;
import com.baidu.adp.framework.message.NetMessage;
import d.a.m0.x0.c.a;
import d.a.m0.x0.c.b;
import d.a.m0.x0.c.c;
/* loaded from: classes3.dex */
public class TemplateNetMessage extends NetMessage {
    public boolean isNeedCache;
    public a mIReq;
    public b mIResp;

    public TemplateNetMessage(c cVar, a aVar, b bVar) {
        super(cVar.b(), cVar.a());
        this.isNeedCache = false;
        this.mIReq = aVar;
        this.mIResp = bVar;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        Log.i("Template", "TemplateNetMessage-->isShortConnection=" + z);
        return this.mIReq.a(z);
    }

    public a getIReq() {
        return this.mIReq;
    }

    public b getIResp() {
        return this.mIResp;
    }

    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }
}
