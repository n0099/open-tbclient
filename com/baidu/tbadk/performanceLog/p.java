package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements e {
    final /* synthetic */ n age;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.age = nVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.tbadk.performanceLog.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ez(String str) {
        String[] strArr;
        String[] strArr2;
        int i;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2 = this.age.afZ;
            if (str.contains(strArr2[i2])) {
                n nVar = this.age;
                i = nVar.afS;
                nVar.afS = i + 1;
                return;
            }
        }
    }
}
