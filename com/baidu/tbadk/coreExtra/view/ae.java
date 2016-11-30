package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u arI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.arI = uVar;
    }

    @Override // com.baidu.tbadk.download.d
    public boolean a(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void b(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        ImageUrlData imageUrlData3;
        ImageUrlData imageUrlData4;
        ImageUrlData imageUrlData5;
        if (downloadData != null) {
            imageUrlData = this.arI.arA;
            if (imageUrlData != null) {
                imageUrlData4 = this.arI.arA;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.arI.arA;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.arI.arA;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.arI.arA;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.arI.ars.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.arI.ars.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        Runnable runnable;
        boolean bs;
        this.arI.ars.setText(this.arI.getResources().getString(r.j.done));
        this.arI.ars.setClickable(false);
        this.arI.ars.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.arI.arG;
        eG.postDelayed(runnable, 1500L);
        this.arI.arC = false;
        u uVar = this.arI;
        bs = this.arI.bs(false);
        uVar.arB = bs;
        this.arI.Bt();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.arI.arC = false;
        BdToast.a(this.arI.mContext, str).tw().ty();
        imageUrlData = this.arI.arA;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.arI.arA;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.arI.ars;
            str3 = u.arq;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.arI.arA;
            textView.setText(append.append(ax.H(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.arI.ars;
            str2 = u.arq;
            textView2.setText(str2);
        }
        this.arI.ars.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
