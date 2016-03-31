package com.baidu.tieba.enterForum.square;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b bcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.bcm = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        BaseFragmentActivity baseFragmentActivity;
        a aVar2;
        boolean d;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        aVar = this.bcm.bci;
        if (aVar != null) {
            baseFragmentActivity = this.bcm.aNm;
            if (baseFragmentActivity != null) {
                this.bcm.bck = false;
                aVar2 = this.bcm.bci;
                aVar2.Op();
                d = this.bcm.d(responsedMessage);
                if (!d) {
                    if (!this.bcm.Gd()) {
                        return;
                    }
                    this.bcm.gl(t.j.no_data_text);
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    String errorString = responsedMessage.getErrorString();
                    baseFragmentActivity2 = this.bcm.aNm;
                    String string = baseFragmentActivity2.getResources().getString(t.j.no_data_text);
                    if (!StringUtils.isNull(errorString)) {
                        string = errorString;
                    }
                    baseFragmentActivity3 = this.bcm.aNm;
                    baseFragmentActivity3.showToast(string);
                    if (k.jw()) {
                        this.bcm.gl(t.j.no_data_text);
                    } else {
                        this.bcm.gl(t.j.neterror);
                    }
                } else if (!(responsedMessage instanceof ForumClassSocketResponseMessage)) {
                    if (!(responsedMessage instanceof ForumClassHttpResponseMessage)) {
                        return;
                    }
                    this.bcm.a(((ForumClassHttpResponseMessage) responsedMessage).getData());
                } else {
                    this.bcm.a(((ForumClassSocketResponseMessage) responsedMessage).getData());
                }
            }
        }
    }
}
