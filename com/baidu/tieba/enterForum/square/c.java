package com.baidu.tieba.enterForum.square;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b aRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.aRA = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        BaseFragmentActivity baseFragmentActivity;
        a aVar2;
        boolean d;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        aVar = this.aRA.aRw;
        if (aVar != null) {
            baseFragmentActivity = this.aRA.aHN;
            if (baseFragmentActivity != null) {
                this.aRA.aRy = false;
                aVar2 = this.aRA.aRw;
                aVar2.Kr();
                d = this.aRA.d(responsedMessage);
                if (!d) {
                    if (!this.aRA.Eg()) {
                        return;
                    }
                    this.aRA.fB(n.i.no_data_text);
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    String errorString = responsedMessage.getErrorString();
                    baseFragmentActivity2 = this.aRA.aHN;
                    String string = baseFragmentActivity2.getResources().getString(n.i.no_data_text);
                    if (!StringUtils.isNull(errorString)) {
                        string = errorString;
                    }
                    baseFragmentActivity3 = this.aRA.aHN;
                    baseFragmentActivity3.showToast(string);
                    if (k.jg()) {
                        this.aRA.fB(n.i.no_data_text);
                    } else {
                        this.aRA.fB(n.i.neterror);
                    }
                } else if (!(responsedMessage instanceof ForumClassSocketResponseMessage)) {
                    if (!(responsedMessage instanceof ForumClassHttpResponseMessage)) {
                        return;
                    }
                    this.aRA.a(((ForumClassHttpResponseMessage) responsedMessage).getData());
                } else {
                    this.aRA.a(((ForumClassSocketResponseMessage) responsedMessage).getData());
                }
            }
        }
    }
}
