package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.lib.debug.b {
    final /* synthetic */ g YP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.YP = gVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.adp.lib.debug.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K(String str) {
        String[] strArr;
        String[] strArr2;
        int i;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2 = this.YP.gu;
            if (str.contains(strArr2[i2])) {
                g gVar = this.YP;
                i = gVar.YF;
                gVar.YF = i + 1;
                return;
            }
        }
    }
}
