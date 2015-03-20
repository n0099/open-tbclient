package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.mvc.model.q<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> {
    final /* synthetic */ p aBT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aBT = pVar;
    }

    @Override // com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.discover.data.a> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        s sVar;
        s sVar2;
        s sVar3;
        com.baidu.tieba.discover.data.b bVar;
        s sVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null) {
            sVar = this.aBT.aBS;
            if (sVar != null) {
                sVar2 = this.aBT.aBS;
                sVar2.FV();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcHttpResponsedMessage.getData();
        sVar3 = this.aBT.aBS;
        if (sVar3 != null) {
            sVar4 = this.aBT.aBS;
            long Gb = data.Gb();
            bVar2 = this.aBT.aBR;
            sVar4.a(true, data, Gb > bVar2.Gb());
        }
        bVar = this.aBT.aBR;
        bVar.M(data.Gb());
    }

    @Override // com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.discover.data.a, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        s sVar;
        s sVar2;
        s sVar3;
        com.baidu.tieba.discover.data.b bVar;
        s sVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null) {
            sVar = this.aBT.aBS;
            if (sVar != null) {
                sVar2 = this.aBT.aBS;
                sVar2.FV();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcSocketResponsedMessage.getData();
        sVar3 = this.aBT.aBS;
        if (sVar3 != null) {
            sVar4 = this.aBT.aBS;
            long Gb = data.Gb();
            bVar2 = this.aBT.aBR;
            sVar4.a(true, data, Gb > bVar2.Gb());
        }
        bVar = this.aBT.aBR;
        bVar.M(data.Gb());
    }
}
