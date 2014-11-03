package com.baidu.tieba.game.base;

import android.view.View;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ AbsGameClassifyActivity aJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AbsGameClassifyActivity absGameClassifyActivity, int i, int i2) {
        super(i, i2);
        this.aJz = absGameClassifyActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        View abS;
        AbsGameClassifyActivity absGameClassifyActivity = this.aJz;
        abS = this.aJz.abS();
        absGameClassifyActivity.hideLoadingView(abS);
        if (responsedMessage == null) {
            this.aJz.EI();
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            this.aJz.showToast(responsedMessage.getErrorString());
            this.aJz.EI();
        } else {
            Class<? extends SocketResponsedMessage> Ib = this.aJz.Ib();
            if (Ib != null && Ib.isInstance(responsedMessage)) {
                this.aJz.e((SocketResponsedMessage) responsedMessage);
            }
            Class<? extends HttpResponsedMessage> Ia = this.aJz.Ia();
            if (Ia != null && Ia.isInstance(responsedMessage)) {
                this.aJz.c((HttpResponsedMessage) responsedMessage);
            }
        }
    }
}
