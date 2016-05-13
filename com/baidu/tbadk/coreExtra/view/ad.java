package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.download.d {
    final /* synthetic */ u amC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar) {
        this.amC = uVar;
    }

    @Override // com.baidu.tbadk.download.d
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        ImageUrlData imageUrlData3;
        ImageUrlData imageUrlData4;
        ImageUrlData imageUrlData5;
        if (downloadData != null) {
            imageUrlData = this.amC.amu;
            if (imageUrlData != null) {
                imageUrlData4 = this.amC.amu;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.amC.amu;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.amC.amu;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.amC.amu;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.amC.amn.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.amC.amn.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean e(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void f(DownloadData downloadData) {
        Runnable runnable;
        boolean bn;
        this.amC.amn.setText(this.amC.getResources().getString(t.j.done));
        this.amC.amn.setClickable(false);
        this.amC.amn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable = this.amC.amA;
        dL.postDelayed(runnable, 1500L);
        this.amC.amw = false;
        u uVar = this.amC;
        bn = this.amC.bn(false);
        uVar.amv = bn;
        this.amC.zO();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.amC.amw = false;
        BdToast.a(this.amC.mContext, str).sb().sd();
        imageUrlData = this.amC.amu;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.amC.amu;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.amC.amn;
            str3 = u.aml;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.amC.amu;
            textView.setText(append.append(ay.I(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.amC.amn;
            str2 = u.aml;
            textView2.setText(str2);
        }
        this.amC.amn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
