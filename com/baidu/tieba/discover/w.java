package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.mvc.model.q<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> {
    final /* synthetic */ u aEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.aEc = uVar;
    }

    @Override // com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.discover.data.a> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        x xVar;
        x xVar2;
        x xVar3;
        com.baidu.tieba.discover.data.b bVar;
        x xVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null) {
            xVar = this.aEc.aEb;
            if (xVar != null) {
                xVar2 = this.aEc.aEb;
                xVar2.He();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcHttpResponsedMessage.getData();
        xVar3 = this.aEc.aEb;
        if (xVar3 != null) {
            xVar4 = this.aEc.aEb;
            long Hk = data.Hk();
            bVar2 = this.aEc.aEa;
            xVar4.a(true, data, Hk > bVar2.Hk());
        }
        bVar = this.aEc.aEa;
        bVar.N(data.Hk());
    }

    @Override // com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.discover.data.a, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        x xVar;
        x xVar2;
        x xVar3;
        com.baidu.tieba.discover.data.b bVar;
        x xVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null) {
            xVar = this.aEc.aEb;
            if (xVar != null) {
                xVar2 = this.aEc.aEb;
                xVar2.He();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcSocketResponsedMessage.getData();
        xVar3 = this.aEc.aEb;
        if (xVar3 != null) {
            xVar4 = this.aEc.aEb;
            long Hk = data.Hk();
            bVar2 = this.aEc.aEa;
            xVar4.a(true, data, Hk > bVar2.Hk());
        }
        bVar = this.aEc.aEa;
        bVar.N(data.Hk());
    }
}
