package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.mvc.model.q<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> {
    final /* synthetic */ u aEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.aEd = uVar;
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
            xVar = this.aEd.aEc;
            if (xVar != null) {
                xVar2 = this.aEd.aEc;
                xVar2.Hf();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcHttpResponsedMessage.getData();
        xVar3 = this.aEd.aEc;
        if (xVar3 != null) {
            xVar4 = this.aEd.aEc;
            long Hl = data.Hl();
            bVar2 = this.aEd.aEb;
            xVar4.a(true, data, Hl > bVar2.Hl());
        }
        bVar = this.aEd.aEb;
        bVar.N(data.Hl());
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
            xVar = this.aEd.aEc;
            if (xVar != null) {
                xVar2 = this.aEd.aEc;
                xVar2.Hf();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcSocketResponsedMessage.getData();
        xVar3 = this.aEd.aEc;
        if (xVar3 != null) {
            xVar4 = this.aEd.aEc;
            long Hl = data.Hl();
            bVar2 = this.aEd.aEb;
            xVar4.a(true, data, Hl > bVar2.Hl());
        }
        bVar = this.aEd.aEb;
        bVar.N(data.Hl());
    }
}
