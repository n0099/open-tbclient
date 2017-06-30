package com.baidu.tbadk.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c {
    final /* synthetic */ j aHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aHr = jVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.tbadk.j.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gp(String str) {
        String[] strArr;
        String[] strArr2;
        int i;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2 = this.aHr.aHm;
            if (str.contains(strArr2[i2])) {
                j jVar = this.aHr;
                i = jVar.aHe;
                jVar.aHe = i + 1;
                return;
            }
        }
    }
}
