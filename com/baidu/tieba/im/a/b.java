package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        if (socketResponsedMessage.getError() != 0) {
            eVar5 = this.a.i;
            if (eVar5 != null) {
                eVar6 = this.a.i;
                eVar6.b();
                if (socketResponsedMessage.getError() > 0 && !TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                    eVar7 = this.a.i;
                    eVar7.a(socketResponsedMessage.getErrorString());
                }
            }
        } else if (socketResponsedMessage instanceof ResponseQueryGroupCountMessage) {
            ResponseQueryGroupCountMessage responseQueryGroupCountMessage = (ResponseQueryGroupCountMessage) socketResponsedMessage;
            this.a.d = responseQueryGroupCountMessage.getUserGroupCount();
            this.a.e = responseQueryGroupCountMessage.getLocalGroupCount();
            this.a.f = responseQueryGroupCountMessage.getGeographicLocation();
            this.a.g = responseQueryGroupCountMessage.getPicUrl();
            this.a.h = responseQueryGroupCountMessage.getLink();
            a.a = false;
            eVar = this.a.i;
            if (eVar != null) {
                eVar4 = this.a.i;
                eVar4.b();
            }
            eVar2 = this.a.i;
            if (eVar2 != null) {
                eVar3 = this.a.i;
                i = this.a.d;
                i2 = this.a.e;
                str = this.a.h;
                str2 = this.a.g;
                str3 = this.a.f;
                eVar3.a(i, i2, str, str2, str3);
            }
        }
    }
}
