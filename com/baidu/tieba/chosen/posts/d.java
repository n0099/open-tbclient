package com.baidu.tieba.chosen.posts;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.chosen.unlike.UnlikeHttpResponse;
import com.baidu.tieba.chosen.unlike.UnlikeSocketReponse;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b aJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i, int i2) {
        super(i, i2);
        this.aJB = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        ChosenPostActivity chosenPostActivity;
        if (responsedMessage != null) {
            if (responsedMessage.getError() != 0) {
                chosenPostActivity = this.aJB.aJu;
                BdToast.a(chosenPostActivity.getActivity(), responsedMessage.getErrorString(), 0).sX().sZ();
            } else if (!(responsedMessage instanceof UnlikeHttpResponse)) {
                if (!(responsedMessage instanceof UnlikeSocketReponse)) {
                    return;
                }
                this.aJB.Y(((UnlikeSocketReponse) responsedMessage).getThreadId());
            } else {
                this.aJB.Y(((UnlikeHttpResponse) responsedMessage).getThreadId());
            }
        }
    }
}
