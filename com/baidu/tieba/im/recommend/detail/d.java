package com.baidu.tieba.im.recommend.detail;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ c bmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, int i2) {
        super(i, i2);
        this.bmb = cVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        TbPageContext tbPageContext;
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        TbPageContext tbPageContext2;
        g gVar6;
        TbPageContext tbPageContext3;
        this.bmb.blY = true;
        tbPageContext = this.bmb.LN;
        if (tbPageContext != null) {
            gVar = this.bmb.blX;
            if (gVar != null) {
                if (responsedMessage == null) {
                    gVar6 = this.bmb.blX;
                    tbPageContext3 = this.bmb.LN;
                    gVar6.onFailed(tbPageContext3.getString(y.neterror));
                } else if (responsedMessage.getError() != 0) {
                    if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        gVar5 = this.bmb.blX;
                        tbPageContext2 = this.bmb.LN;
                        gVar5.onFailed(tbPageContext2.getString(y.neterror));
                        return;
                    }
                    gVar4 = this.bmb.blX;
                    gVar4.onFailed(responsedMessage.getErrorString());
                } else {
                    if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                        RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                        if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                            this.bmb.aQr = true;
                            gVar3 = this.bmb.blX;
                            gVar3.a(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                        }
                    }
                    if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                        RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                        if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                            this.bmb.aQr = true;
                            gVar2 = this.bmb.blX;
                            gVar2.a(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                        }
                    }
                }
            }
        }
    }
}
