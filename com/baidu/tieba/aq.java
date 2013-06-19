package com.baidu.tieba;
/* loaded from: classes.dex */
class aq extends com.baidu.adp.lib.a.a {
    private aq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(aq aqVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.aA;
        synchronized (bArr) {
            TiebaApplication.aB = Boolean.valueOf(com.baidu.tieba.d.ag.a());
            bArr2 = TiebaApplication.aA;
            bArr2.notifyAll();
        }
        return null;
    }
}
