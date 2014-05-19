package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e eVar;
        e eVar2;
        int i;
        int i2;
        String str;
        String str2;
        e eVar3;
        e eVar4;
        e eVar5;
        if (customResponsedMessage.getError() != 0) {
            eVar3 = this.a.h;
            if (eVar3 != null) {
                eVar4 = this.a.h;
                eVar4.f();
                if (customResponsedMessage.getError() > 0 && !TextUtils.isEmpty(customResponsedMessage.getErrorString())) {
                    eVar5 = this.a.h;
                    eVar5.c(customResponsedMessage.getErrorString());
                }
            }
        } else if (customResponsedMessage instanceof ResponseQueryGroupCountLocalMessage) {
            ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = (ResponseQueryGroupCountLocalMessage) customResponsedMessage;
            this.a.d = responseQueryGroupCountLocalMessage.getUserGroupCount();
            this.a.e = responseQueryGroupCountLocalMessage.getLocalGroupCount();
            this.a.f = responseQueryGroupCountLocalMessage.getPicUrl();
            this.a.g = responseQueryGroupCountLocalMessage.getLink();
            this.a.a();
            eVar = this.a.h;
            if (eVar != null) {
                eVar2 = this.a.h;
                i = this.a.d;
                i2 = this.a.e;
                str = this.a.g;
                str2 = this.a.f;
                eVar2.a(i, i2, str, str2);
            }
        }
    }
}
