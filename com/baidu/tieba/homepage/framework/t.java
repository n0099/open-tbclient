package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.homepage.framework.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NetModel.b<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> {
    final /* synthetic */ q cvS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.cvS = qVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        long a;
        q.a aVar;
        q.a aVar2;
        q.a aVar3;
        com.baidu.tieba.homepage.recommendfrs.data.d dVar;
        boolean z;
        q.a aVar4;
        q.a aVar5;
        q.a aVar6;
        a = this.cvS.a(mvcNetMessage);
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null || a == -1) {
            aVar = this.cvS.cuE;
            if (aVar != null) {
                aVar2 = this.cvS.cuE;
                aVar2.a(a, "", mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError(), false);
            }
        } else {
            com.baidu.tieba.homepage.recommendfrs.data.c data = mvcHttpResponsedMessage.getData();
            if (data.getThreadList() == null) {
                aVar5 = this.cvS.cuE;
                if (aVar5 != null) {
                    aVar6 = this.cvS.cuE;
                    aVar6.a(a, "", mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError(), false);
                    return;
                }
            }
            aVar3 = this.cvS.cuE;
            if (aVar3 != null) {
                dVar = this.cvS.cvM;
                boolean z2 = dVar.ajX() != 0;
                if (data instanceof com.baidu.tieba.homepage.mygod.data.d) {
                    z = ((com.baidu.tieba.homepage.mygod.data.d) data).getPn() != 1;
                } else {
                    z = z2;
                }
                aVar4 = this.cvS.cuE;
                aVar4.a(true, data, z, a, "", false);
            }
        }
        this.cvS.a(mvcHttpResponsedMessage, mvcNetMessage);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcSocketMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        long a;
        q.a aVar;
        q.a aVar2;
        q.a aVar3;
        com.baidu.tieba.homepage.recommendfrs.data.d dVar;
        boolean z;
        q.a aVar4;
        q.a aVar5;
        q.a aVar6;
        a = this.cvS.a(mvcNetMessage);
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null || a == -1) {
            aVar = this.cvS.cuE;
            if (aVar != null) {
                aVar2 = this.cvS.cuE;
                aVar2.a(a, "", mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError(), false);
            }
        } else {
            com.baidu.tieba.homepage.recommendfrs.data.c data = mvcSocketResponsedMessage.getData();
            if (data.getThreadList() == null) {
                aVar5 = this.cvS.cuE;
                if (aVar5 != null) {
                    aVar6 = this.cvS.cuE;
                    aVar6.a(a, "", mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError(), false);
                    return;
                }
            }
            aVar3 = this.cvS.cuE;
            if (aVar3 != null) {
                dVar = this.cvS.cvM;
                boolean z2 = dVar.ajX() != 0;
                if (data instanceof com.baidu.tieba.homepage.mygod.data.d) {
                    z2 = ((com.baidu.tieba.homepage.mygod.data.d) data).getPn() != 1;
                }
                if (data instanceof com.baidu.tieba.homepage.alalivelist.data.c) {
                    z = ((com.baidu.tieba.homepage.alalivelist.data.c) data).getPn() != 1;
                } else {
                    z = z2;
                }
                aVar4 = this.cvS.cuE;
                aVar4.a(true, data, z, a, "", false);
            }
        }
        this.cvS.a(mvcSocketResponsedMessage, mvcNetMessage);
    }
}
