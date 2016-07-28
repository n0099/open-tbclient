package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aDy = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aDy.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aDy;
            i2 = this.aDy.aDf;
            tbImageView.aDg = i2;
        }
        aVar2 = this.aDy.aDe;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aDy.aDs = aVar.getWidth();
                this.aDy.aDt = aVar.getHeight();
            }
            aVar3 = this.aDy.aDe;
            aVar3.t(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.yk != null) {
                this.aDy.aDp.ym = aVar.yk.ym;
                this.aDy.aDp.isSuccess = aVar.yk.yo;
                this.aDy.aDp.yn = aVar.yk.yn;
            }
        } else {
            this.aDy.aDp.ym = "net";
            this.aDy.aDp.isSuccess = false;
            u uVar = this.aDy.aDp;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aDy.aDr;
            uVar.yn = currentTimeMillis - j;
        }
        this.aDy.uS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ah(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.ah(str);
        this.aDy.stopLoading();
        aVar = this.aDy.aDe;
        if (aVar != null) {
            aVar2 = this.aDy.aDe;
            aVar2.onCancel();
        }
    }
}
