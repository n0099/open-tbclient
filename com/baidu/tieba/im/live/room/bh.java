package com.baidu.tieba.im.live.room;

import com.baidu.tieba.im.message.RequestLiveGroupInfoByGid;
import com.baidu.tieba.im.message.RequestUpdateLiveGroupMessage;
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.base.b {
    private String a;
    private String b;
    private String c;
    private int d;
    private boolean e = false;
    private RequestLiveGroupInfoByGid f;
    private RequestUpdateLiveGroupMessage g;

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public boolean b() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(int i, String str, String str2, String str3) {
        RequestUpdateLiveGroupMessage requestUpdateLiveGroupMessage = new RequestUpdateLiveGroupMessage();
        requestUpdateLiveGroupMessage.setGid(i);
        requestUpdateLiveGroupMessage.setName(str2);
        requestUpdateLiveGroupMessage.setPid(str);
        requestUpdateLiveGroupMessage.setIntro(str3);
        this.g = requestUpdateLiveGroupMessage;
        sendMessage(requestUpdateLiveGroupMessage);
    }

    public void c() {
        a(this.d, this.a, this.b, this.c);
    }

    public void d() {
        RequestLiveGroupInfoByGid requestLiveGroupInfoByGid = new RequestLiveGroupInfoByGid();
        requestLiveGroupInfoByGid.setGroupId(this.d);
        this.f = requestLiveGroupInfoByGid;
        sendMessage(requestLiveGroupInfoByGid);
    }

    public RequestLiveGroupInfoByGid e() {
        return this.f;
    }

    public RequestUpdateLiveGroupMessage f() {
        return this.g;
    }
}
