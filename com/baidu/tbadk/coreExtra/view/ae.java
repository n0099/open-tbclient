package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u aqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.aqr = uVar;
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
            imageUrlData = this.aqr.aqj;
            if (imageUrlData != null) {
                imageUrlData4 = this.aqr.aqj;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.aqr.aqj;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.aqr.aqj;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.aqr.aqj;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.aqr.aqb.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.aqr.aqb.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.g.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean onFileDownloaded(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Runnable runnable;
        boolean bs;
        this.aqr.aqb.setText(this.aqr.getResources().getString(r.l.done));
        this.aqr.aqb.setClickable(false);
        this.aqr.aqb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.aqr.aqp;
        eE.postDelayed(runnable, 1500L);
        this.aqr.aql = false;
        u uVar = this.aqr;
        bs = this.aqr.bs(false);
        uVar.aqk = bs;
        this.aqr.Bb();
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.aqr.aql = false;
        BdToast.a(this.aqr.mContext, str).tb().td();
        imageUrlData = this.aqr.aqj;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.aqr.aqj;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.aqr.aqb;
            str3 = u.apZ;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.aqr.aqj;
            textView.setText(append.append(at.E(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.aqr.aqb;
            str2 = u.apZ;
            textView2.setText(str2);
        }
        this.aqr.aqb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
