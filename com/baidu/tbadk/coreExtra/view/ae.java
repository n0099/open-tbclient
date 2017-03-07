package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u avM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.avM = uVar;
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
            imageUrlData = this.avM.avE;
            if (imageUrlData != null) {
                imageUrlData4 = this.avM.avE;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.avM.avE;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.avM.avE;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.avM.avE;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.avM.avw.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.avM.avw.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean onFileDownloaded(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Runnable runnable;
        boolean br;
        this.avM.avw.setText(this.avM.getResources().getString(w.l.done));
        this.avM.avw.setClickable(false);
        this.avM.avw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.avM.avK;
        fM.postDelayed(runnable, 1500L);
        this.avM.avG = false;
        u uVar = this.avM;
        br = this.avM.br(false);
        uVar.avF = br;
        this.avM.Bu();
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.avM.avG = false;
        BdToast.a(this.avM.mContext, str).ty().tA();
        imageUrlData = this.avM.avE;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.avM.avE;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.avM.avw;
            str3 = u.avu;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.avM.avE;
            textView.setText(append.append(au.E(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.avM.avw;
            str2 = u.avu;
            textView2.setText(str2);
        }
        this.avM.avw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
