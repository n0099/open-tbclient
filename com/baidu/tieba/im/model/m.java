package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bd;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.d {
    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private com.baidu.tieba.im.message.ah b(int i) {
        com.baidu.tieba.im.message.ah ahVar = new com.baidu.tieba.im.message.ah();
        ahVar.a(i);
        return ahVar;
    }

    private bd b(int i, boolean z) {
        bd bdVar = new bd();
        bdVar.a(z);
        bdVar.a(i);
        bdVar.a("");
        return bdVar;
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
