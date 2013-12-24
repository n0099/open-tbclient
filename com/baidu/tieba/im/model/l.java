package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.at;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.d {
    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private com.baidu.tieba.im.message.aa b(int i) {
        com.baidu.tieba.im.message.aa aaVar = new com.baidu.tieba.im.message.aa();
        aaVar.a(i);
        return aaVar;
    }

    private at b(int i, boolean z) {
        at atVar = new at();
        atVar.a(z);
        atVar.a(i);
        atVar.a("");
        return atVar;
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
