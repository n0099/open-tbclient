package com.baidu.tieba.im.recommend.detail;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ c bmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, int i2) {
        super(i, i2);
        this.bmr = cVar;
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
        this.bmr.bmo = true;
        tbPageContext = this.bmr.LP;
        if (tbPageContext != null) {
            gVar = this.bmr.bmn;
            if (gVar != null) {
                if (responsedMessage == null) {
                    gVar6 = this.bmr.bmn;
                    tbPageContext3 = this.bmr.LP;
                    gVar6.onFailed(tbPageContext3.getString(y.neterror));
                } else if (responsedMessage.getError() != 0) {
                    if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        gVar5 = this.bmr.bmn;
                        tbPageContext2 = this.bmr.LP;
                        gVar5.onFailed(tbPageContext2.getString(y.neterror));
                        return;
                    }
                    gVar4 = this.bmr.bmn;
                    gVar4.onFailed(responsedMessage.getErrorString());
                } else {
                    if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                        RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                        if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                            this.bmr.aQI = true;
                            gVar3 = this.bmr.bmn;
                            gVar3.a(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                        }
                    }
                    if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                        RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                        if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                            this.bmr.aQI = true;
                            gVar2 = this.bmr.bmn;
                            gVar2.a(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                        }
                    }
                }
            }
        }
    }
}
