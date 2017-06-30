package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.awV = uVar;
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
            imageUrlData = this.awV.awN;
            if (imageUrlData != null) {
                imageUrlData4 = this.awV.awN;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.awV.awN;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.awV.awN;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.awV.awN;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.awV.awF.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.awV.awF.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
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
        this.awV.awF.setText(this.awV.getResources().getString(w.l.done));
        this.awV.awF.setClickable(false);
        this.awV.awF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.awV.awT;
        fR.postDelayed(runnable, 1500L);
        this.awV.awP = false;
        u uVar = this.awV;
        br = this.awV.br(false);
        uVar.awO = br;
        this.awV.Br();
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.awV.awP = false;
        BdToast.a(this.awV.mContext, str).tg().ti();
        imageUrlData = this.awV.awN;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.awV.awN;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.awV.awF;
            str3 = u.awD;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.awV.awN;
            textView.setText(append.append(aw.G(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.awV.awF;
            str2 = u.awD;
            textView2.setText(str2);
        }
        this.awV.awF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
