package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bj;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.d {
    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private com.baidu.tieba.im.message.an b(int i) {
        com.baidu.tieba.im.message.an anVar = new com.baidu.tieba.im.message.an();
        anVar.a(i);
        return anVar;
    }

    private bj b(int i, boolean z) {
        bj bjVar = new bj();
        bjVar.a(z);
        bjVar.a(i);
        bjVar.a("");
        return bjVar;
    }

    public void a(int i) {
        com.baidu.tieba.im.messageCenter.e.a().a(b(i));
    }

    public void a(int i, boolean z) {
        com.baidu.tieba.im.messageCenter.e.a().a(b(i, z));
    }

    public void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(104103, gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(104102, gVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }
}
