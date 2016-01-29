package com.baidu.tieba.enterForum.square;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b aXD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.aXD = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        BaseFragmentActivity baseFragmentActivity;
        a aVar2;
        boolean d;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        aVar = this.aXD.aXz;
        if (aVar != null) {
            baseFragmentActivity = this.aXD.aKq;
            if (baseFragmentActivity != null) {
                this.aXD.aXB = false;
                aVar2 = this.aXD.aXz;
                aVar2.MB();
                d = this.aXD.d(responsedMessage);
                if (!d) {
                    if (!this.aXD.Fq()) {
                        return;
                    }
                    this.aXD.fV(t.j.no_data_text);
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    String errorString = responsedMessage.getErrorString();
                    baseFragmentActivity2 = this.aXD.aKq;
                    String string = baseFragmentActivity2.getResources().getString(t.j.no_data_text);
                    if (!StringUtils.isNull(errorString)) {
                        string = errorString;
                    }
                    baseFragmentActivity3 = this.aXD.aKq;
                    baseFragmentActivity3.showToast(string);
                    if (k.jq()) {
                        this.aXD.fV(t.j.no_data_text);
                    } else {
                        this.aXD.fV(t.j.neterror);
                    }
                } else if (!(responsedMessage instanceof ForumClassSocketResponseMessage)) {
                    if (!(responsedMessage instanceof ForumClassHttpResponseMessage)) {
                        return;
                    }
                    this.aXD.a(((ForumClassHttpResponseMessage) responsedMessage).getData());
                } else {
                    this.aXD.a(((ForumClassSocketResponseMessage) responsedMessage).getData());
                }
            }
        }
    }
}
