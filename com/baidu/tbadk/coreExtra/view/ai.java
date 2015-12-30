package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.download.c {
    final /* synthetic */ z apF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.apF = zVar;
    }

    @Override // com.baidu.tbadk.download.c
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void d(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        if (downloadData != null) {
            imageUrlData = this.apF.apx;
            if (imageUrlData != null) {
                imageUrlData2 = this.apF.apx;
                imageUrlData2.originalProcess = downloadData.getProcess();
            }
            this.apF.apq.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.apF.apq.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean e(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void f(DownloadData downloadData) {
        Runnable runnable;
        boolean aY;
        this.apF.apq.setText(this.apF.getResources().getString(n.j.done));
        this.apF.apq.setClickable(false);
        this.apF.apq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        runnable = this.apF.apD;
        hj.postDelayed(runnable, 1500L);
        this.apF.apz = false;
        z zVar = this.apF;
        aY = this.apF.aY(false);
        zVar.apy = aY;
        this.apF.Aa();
    }

    @Override // com.baidu.tbadk.download.c
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.apF.apz = false;
        BdToast.b(this.apF.mContext, str).tm().to();
        imageUrlData = this.apF.apx;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.apF.apx;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.apF.apq;
            str3 = z.apn;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.apF.apx;
            textView.setText(append.append(ax.D(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.apF.apq;
            str2 = z.apn;
            textView2.setText(str2);
        }
        this.apF.apq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
