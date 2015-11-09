package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView azQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbImageView tbImageView) {
        this.azQ = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.azQ.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.azQ.azD;
        if (aVar2 != null) {
            if (aVar != null) {
                this.azQ.azO = aVar.getWidth();
                this.azQ.azP = aVar.getHeight();
            }
            aVar3 = this.azQ.azD;
            aVar3.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Gp != null) {
                this.azQ.azM.Gr = aVar.Gp.Gr;
                this.azQ.azM.isSuccess = aVar.Gp.Gt;
                this.azQ.azM.Gs = aVar.Gp.Gs;
            }
        } else {
            this.azQ.azM.Gr = "net";
            this.azQ.azM.isSuccess = false;
            s sVar = this.azQ.azM;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.azQ.azN;
            sVar.Gs = currentTimeMillis - j;
        }
        this.azQ.vs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void aj(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.aj(str);
        this.azQ.stopLoading();
        aVar = this.azQ.azD;
        if (aVar != null) {
            aVar2 = this.azQ.azD;
            aVar2.onCancel();
        }
    }
}
