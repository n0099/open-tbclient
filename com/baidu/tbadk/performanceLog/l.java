package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c {
    final /* synthetic */ j avR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.avR = jVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.tbadk.performanceLog.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fB(String str) {
        String[] strArr;
        String[] strArr2;
        int i;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2 = this.avR.avM;
            if (str.contains(strArr2[i2])) {
                j jVar = this.avR;
                i = jVar.avE;
                jVar.avE = i + 1;
                return;
            }
        }
    }
}
