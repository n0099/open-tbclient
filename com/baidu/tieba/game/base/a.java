package com.baidu.tieba.game.base;

import android.view.View;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ AbsGameClassifyActivity aJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AbsGameClassifyActivity absGameClassifyActivity, int i, int i2) {
        super(i, i2);
        this.aJm = absGameClassifyActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        View abP;
        AbsGameClassifyActivity absGameClassifyActivity = this.aJm;
        abP = this.aJm.abP();
        absGameClassifyActivity.hideLoadingView(abP);
        if (responsedMessage == null) {
            this.aJm.EG();
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            this.aJm.showToast(responsedMessage.getErrorString());
            this.aJm.EG();
        } else {
            Class<? extends SocketResponsedMessage> HX = this.aJm.HX();
            if (HX != null && HX.isInstance(responsedMessage)) {
                this.aJm.e((SocketResponsedMessage) responsedMessage);
            }
            Class<? extends HttpResponsedMessage> HW = this.aJm.HW();
            if (HW != null && HW.isInstance(responsedMessage)) {
                this.aJm.d((HttpResponsedMessage) responsedMessage);
            }
        }
    }
}
