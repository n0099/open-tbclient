package com.baidu.tieba.card;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.a0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends Handler {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, Looper looper) {
        super(looper);
        this.aTK = alVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case a0.f37long /* 202 */:
                this.aTK.Ln();
                return;
            case a0.f35if /* 203 */:
                this.aTK.Lo();
                return;
            default:
                return;
        }
    }
}
