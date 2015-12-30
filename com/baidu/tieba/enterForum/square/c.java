package com.baidu.tieba.enterForum.square;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b aVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.aVq = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        BaseFragmentActivity baseFragmentActivity;
        a aVar2;
        boolean d;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        aVar = this.aVq.aVm;
        if (aVar != null) {
            baseFragmentActivity = this.aVq.aJl;
            if (baseFragmentActivity != null) {
                this.aVq.aVo = false;
                aVar2 = this.aVq.aVm;
                aVar2.KK();
                d = this.aVq.d(responsedMessage);
                if (!d) {
                    if (!this.aVq.DV()) {
                        return;
                    }
                    this.aVq.fw(n.j.no_data_text);
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    String errorString = responsedMessage.getErrorString();
                    baseFragmentActivity2 = this.aVq.aJl;
                    String string = baseFragmentActivity2.getResources().getString(n.j.no_data_text);
                    if (!StringUtils.isNull(errorString)) {
                        string = errorString;
                    }
                    baseFragmentActivity3 = this.aVq.aJl;
                    baseFragmentActivity3.showToast(string);
                    if (k.jh()) {
                        this.aVq.fw(n.j.no_data_text);
                    } else {
                        this.aVq.fw(n.j.neterror);
                    }
                } else if (!(responsedMessage instanceof ForumClassSocketResponseMessage)) {
                    if (!(responsedMessage instanceof ForumClassHttpResponseMessage)) {
                        return;
                    }
                    this.aVq.a(((ForumClassHttpResponseMessage) responsedMessage).getData());
                } else {
                    this.aVq.a(((ForumClassSocketResponseMessage) responsedMessage).getData());
                }
            }
        }
    }
}
