package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.framework.task.a<com.baidu.tieba.im.message.h> {
    private com.baidu.tieba.im.pushNotify.m a;
    private int b;

    public a(com.baidu.tieba.im.pushNotify.m mVar, int i) {
        this.a = mVar;
        this.b = i;
    }

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tieba.im.message.h> aVar) {
        String str;
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.b);
        if (aVar == null || !(aVar instanceof com.baidu.tieba.im.message.g)) {
            com.baidu.adp.lib.util.f.b("message error");
            return a(this.b);
        }
        com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) aVar;
        if (TbadkApplication.N() == null) {
            str = "";
        } else {
            str = TbadkApplication.N().getID();
        }
        com.baidu.tieba.im.message.h a = gVar.a();
        com.baidu.tieba.im.pushNotify.l b = this.a.b(str, a.a);
        if (b == null) {
            com.baidu.adp.lib.util.f.b("read DB error");
            return a(gVar.e());
        }
        String draft = b.getDraft();
        com.baidu.tieba.im.message.i iVar = new com.baidu.tieba.im.message.i();
        iVar.a = draft;
        iVar.b = a.a;
        try {
            loadDraftResponsedMessage.a(this.b, iVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadDraftResponsedMessage;
    }

    private static LoadDraftResponsedMessage a(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.a(-18);
        return loadDraftResponsedMessage;
    }
}
