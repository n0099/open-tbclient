package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c {
    final /* synthetic */ j aCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aCq = jVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.tbadk.performanceLog.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gl(String str) {
        String[] strArr;
        String[] strArr2;
        int i;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2 = this.aCq.aCl;
            if (str.contains(strArr2[i2])) {
                j jVar = this.aCq;
                i = jVar.aCd;
                jVar.aCd = i + 1;
                return;
            }
        }
    }
}
