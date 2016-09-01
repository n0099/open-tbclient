package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c {
    final /* synthetic */ j aBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aBW = jVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.tbadk.performanceLog.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ge(String str) {
        String[] strArr;
        String[] strArr2;
        int i;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2 = this.aBW.aBR;
            if (str.contains(strArr2[i2])) {
                j jVar = this.aBW;
                i = jVar.aBJ;
                jVar.aBJ = i + 1;
                return;
            }
        }
    }
}
