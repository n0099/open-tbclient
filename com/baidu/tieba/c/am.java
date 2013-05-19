package com.baidu.tieba.c;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.adp.lib.a.a {
    final /* synthetic */ al a;

    private am(al alVar) {
        this.a = alVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(al alVar, am amVar) {
        this(alVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.a.e = null;
        eVar = this.a.b;
        if (eVar != null) {
            eVar2 = this.a.b;
            eVar2.a(an.DO_CLEAR);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        com.baidu.tieba.d.k.w();
        try {
            File[] listFiles = new File(com.baidu.tieba.d.o.a + "/tieba/image/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] listFiles2 = new File(com.baidu.tieba.d.o.a + "/tieba/hotspot/").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (!file2.delete()) {
                        com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
