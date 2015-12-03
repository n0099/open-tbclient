package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.download.c {
    final /* synthetic */ z aob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.aob = zVar;
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
            imageUrlData = this.aob.anU;
            if (imageUrlData != null) {
                imageUrlData2 = this.aob.anU;
                imageUrlData2.originalProcess = downloadData.getProcess();
            }
            this.aob.anP.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.aob.anP.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.e.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean e(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void f(DownloadData downloadData) {
        Runnable runnable;
        boolean aZ;
        this.aob.anP.setText(this.aob.getResources().getString(n.i.done));
        this.aob.anP.setClickable(false);
        this.aob.anP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        runnable = this.aob.anZ;
        hj.postDelayed(runnable, 1500L);
        this.aob.anW = false;
        z zVar = this.aob;
        aZ = this.aob.aZ(false);
        zVar.anV = aZ;
        this.aob.Ak();
    }

    @Override // com.baidu.tbadk.download.c
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.aob.anW = false;
        BdToast.b(this.aob.mContext, str).tC().tE();
        imageUrlData = this.aob.anU;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.aob.anU;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.aob.anP;
            str3 = z.anN;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.aob.anU;
            textView.setText(append.append(ax.C(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.aob.anP;
            str2 = z.anN;
            textView2.setText(str2);
        }
        this.aob.anP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
