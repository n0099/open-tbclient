package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.discover.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements NetModel.b<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> {
    final /* synthetic */ u aKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.aKS = uVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.discover.data.a> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        u.a aVar;
        u.a aVar2;
        u.a aVar3;
        com.baidu.tieba.discover.data.b bVar;
        u.a aVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null) {
            aVar = this.aKS.aKR;
            if (aVar != null) {
                aVar2 = this.aKS.aKR;
                aVar2.HA();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcHttpResponsedMessage.getData();
        aVar3 = this.aKS.aKR;
        if (aVar3 != null) {
            aVar4 = this.aKS.aKR;
            long HE = data.HE();
            bVar2 = this.aKS.aKQ;
            aVar4.a(true, data, HE > bVar2.HE());
        }
        bVar = this.aKS.aKQ;
        bVar.ah(data.HE());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.discover.data.a, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        u.a aVar;
        u.a aVar2;
        u.a aVar3;
        com.baidu.tieba.discover.data.b bVar;
        u.a aVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null) {
            aVar = this.aKS.aKR;
            if (aVar != null) {
                aVar2 = this.aKS.aKR;
                aVar2.HA();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcSocketResponsedMessage.getData();
        aVar3 = this.aKS.aKR;
        if (aVar3 != null) {
            aVar4 = this.aKS.aKR;
            long HE = data.HE();
            bVar2 = this.aKS.aKQ;
            aVar4.a(true, data, HE > bVar2.HE());
        }
        bVar = this.aKS.aKQ;
        bVar.ah(data.HE());
    }
}
