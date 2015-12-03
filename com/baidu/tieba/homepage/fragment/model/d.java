package com.baidu.tieba.homepage.fragment.model;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements NetModel.b<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b> {
    final /* synthetic */ b byA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.byA = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.fragment.data.b> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b> mvcNetMessage) {
        this.byA.a(mvcNetMessage, mvcHttpResponsedMessage);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.fragment.data.b, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b> mvcNetMessage) {
        this.byA.a(mvcNetMessage, mvcSocketResponsedMessage);
    }
}
