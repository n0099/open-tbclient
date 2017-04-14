package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u awc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.awc = uVar;
    }

    @Override // com.baidu.tbadk.download.d
    public boolean onPreDownload(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileUpdateProgress(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        ImageUrlData imageUrlData3;
        ImageUrlData imageUrlData4;
        ImageUrlData imageUrlData5;
        if (downloadData != null) {
            imageUrlData = this.awc.avU;
            if (imageUrlData != null) {
                imageUrlData4 = this.awc.avU;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.awc.avU;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.awc.avU;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.awc.avU;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.awc.avM.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.awc.avM.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean onFileDownloaded(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Runnable runnable;
        boolean bt;
        this.awc.avM.setText(this.awc.getResources().getString(w.l.done));
        this.awc.avM.setClickable(false);
        this.awc.avM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.awc.awa;
        fR.postDelayed(runnable, 1500L);
        this.awc.avW = false;
        u uVar = this.awc;
        bt = this.awc.bt(false);
        uVar.avV = bt;
        this.awc.BS();
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.awc.avW = false;
        BdToast.a(this.awc.mContext, str).tW().tY();
        imageUrlData = this.awc.avU;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.awc.avU;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.awc.avM;
            str3 = u.avK;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.awc.avU;
            textView.setText(append.append(au.E(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.awc.avM;
            str2 = u.avK;
            textView2.setText(str2);
        }
        this.awc.avM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
