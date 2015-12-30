package com.baidu.tieba.discover;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.discover.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements NetModel.b<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> {
    final /* synthetic */ t aSf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aSf = tVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.discover.data.a> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        t.a aVar;
        t.a aVar2;
        t.a aVar3;
        com.baidu.tieba.discover.data.b bVar;
        t.a aVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null) {
            aVar = this.aSf.aSe;
            if (aVar != null) {
                aVar2 = this.aSf.aSe;
                aVar2.Jh();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcHttpResponsedMessage.getData();
        aVar3 = this.aSf.aSe;
        if (aVar3 != null) {
            aVar4 = this.aSf.aSe;
            long Jl = data.Jl();
            bVar2 = this.aSf.aSd;
            aVar4.a(true, data, Jl > bVar2.Jl());
        }
        bVar = this.aSf.aSd;
        bVar.aq(data.Jl());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.discover.data.a, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a> mvcNetMessage) {
        t.a aVar;
        t.a aVar2;
        t.a aVar3;
        com.baidu.tieba.discover.data.b bVar;
        t.a aVar4;
        com.baidu.tieba.discover.data.b bVar2;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null) {
            aVar = this.aSf.aSe;
            if (aVar != null) {
                aVar2 = this.aSf.aSe;
                aVar2.Jh();
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.a data = mvcSocketResponsedMessage.getData();
        aVar3 = this.aSf.aSe;
        if (aVar3 != null) {
            aVar4 = this.aSf.aSe;
            long Jl = data.Jl();
            bVar2 = this.aSf.aSd;
            aVar4.a(true, data, Jl > bVar2.Jl());
        }
        bVar = this.aSf.aSd;
        bVar.aq(data.Jl());
    }
}
