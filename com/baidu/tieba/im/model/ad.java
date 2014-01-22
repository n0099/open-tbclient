package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.cr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MsglistModel a;

    private ad(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(MsglistModel msglistModel, o oVar) {
        this(msglistModel);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        MsgPageData msgPageData;
        com.baidu.adp.a.g gVar;
        MsgPageData msgPageData2;
        if (qVar == null) {
            com.baidu.adp.lib.g.e.a("msg == null");
        } else if (qVar.w() == 103112) {
            this.a.b(qVar);
        } else if (qVar.w() == 103102) {
            this.a.d(qVar);
        } else if (qVar.w() == 202003) {
            this.a.c(qVar);
        } else if (qVar.w() == -113) {
            this.a.p();
        } else if (qVar.w() == 205004) {
            this.a.a(qVar);
        } else if (qVar.w() == -126) {
            com.baidu.adp.lib.g.e.e("simon", "onMessage", "msg = " + qVar);
            if (qVar instanceof cr) {
                msgPageData = this.a.j;
                msgPageData.getChatMessages().add((com.baidu.tieba.im.message.b) ((cr) qVar).n());
                gVar = this.a.mLoadDataCallBack;
                msgPageData2 = this.a.j;
                gVar.a(msgPageData2);
            }
        }
    }
}
