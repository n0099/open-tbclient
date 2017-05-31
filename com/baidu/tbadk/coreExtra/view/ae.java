package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u avS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.avS = uVar;
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
            imageUrlData = this.avS.avK;
            if (imageUrlData != null) {
                imageUrlData4 = this.avS.avK;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.avS.avK;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.avS.avK;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.avS.avK;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.avS.avC.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.avS.avC.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean onFileDownloaded(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Runnable runnable;
        boolean bq;
        this.avS.avC.setText(this.avS.getResources().getString(w.l.done));
        this.avS.avC.setClickable(false);
        this.avS.avC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.avS.avQ;
        fS.postDelayed(runnable, 1500L);
        this.avS.avM = false;
        u uVar = this.avS;
        bq = this.avS.bq(false);
        uVar.avL = bq;
        this.avS.AW();
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.avS.avM = false;
        BdToast.a(this.avS.mContext, str).ti().tk();
        imageUrlData = this.avS.avK;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.avS.avK;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.avS.avC;
            str3 = u.avA;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.avS.avK;
            textView.setText(append.append(au.F(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.avS.avC;
            str2 = u.avA;
            textView2.setText(str2);
        }
        this.avS.avC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
