package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aCI = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aCI.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aCI;
            i2 = this.aCI.aCp;
            tbImageView.aCq = i2;
        }
        aVar2 = this.aCI.aCo;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aCI.aCC = aVar.getWidth();
                this.aCI.aCD = aVar.getHeight();
            }
            aVar3 = this.aCI.aCo;
            aVar3.t(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.xJ != null) {
                this.aCI.aCz.xL = aVar.xJ.xL;
                this.aCI.aCz.isSuccess = aVar.xJ.xN;
                this.aCI.aCz.xM = aVar.xJ.xM;
            }
        } else {
            this.aCI.aCz.xL = "net";
            this.aCI.aCz.isSuccess = false;
            u uVar = this.aCI.aCz;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aCI.aCB;
            uVar.xM = currentTimeMillis - j;
        }
        this.aCI.uS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void af(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.af(str);
        this.aCI.stopLoading();
        aVar = this.aCI.aCo;
        if (aVar != null) {
            aVar2 = this.aCI.aCo;
            aVar2.onCancel();
        }
    }
}
