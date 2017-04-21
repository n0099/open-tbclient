package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u awe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.awe = uVar;
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
            imageUrlData = this.awe.avW;
            if (imageUrlData != null) {
                imageUrlData4 = this.awe.avW;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.awe.avW;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.awe.avW;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.awe.avW;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.awe.avO.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.awe.avO.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
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
        this.awe.avO.setText(this.awe.getResources().getString(w.l.done));
        this.awe.avO.setClickable(false);
        this.awe.avO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.awe.awc;
        fS.postDelayed(runnable, 1500L);
        this.awe.avY = false;
        u uVar = this.awe;
        bt = this.awe.bt(false);
        uVar.avX = bt;
        this.awe.BS();
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.awe.avY = false;
        BdToast.a(this.awe.mContext, str).tW().tY();
        imageUrlData = this.awe.avW;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.awe.avW;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.awe.avO;
            str3 = u.avM;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.awe.avW;
            textView.setText(append.append(au.E(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.awe.avO;
            str2 = u.avM;
            textView2.setText(str2);
        }
        this.awe.avO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
