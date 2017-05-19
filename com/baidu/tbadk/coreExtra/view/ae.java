package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u awi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.awi = uVar;
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
            imageUrlData = this.awi.awa;
            if (imageUrlData != null) {
                imageUrlData4 = this.awi.awa;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.awi.awa;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.awi.awa;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.awi.awa;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.awi.avS.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.awi.avS.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
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
        this.awi.avS.setText(this.awi.getResources().getString(w.l.done));
        this.awi.avS.setClickable(false);
        this.awi.avS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.awi.awg;
        fS.postDelayed(runnable, 1500L);
        this.awi.awc = false;
        u uVar = this.awi;
        bt = this.awi.bt(false);
        uVar.awb = bt;
        this.awi.Bd();
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.awi.awc = false;
        BdToast.a(this.awi.mContext, str).tj().tl();
        imageUrlData = this.awi.awa;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.awi.awa;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.awi.avS;
            str3 = u.avQ;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.awi.awa;
            textView.setText(append.append(au.F(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.awi.avS;
            str2 = u.avQ;
            textView2.setText(str2);
        }
        this.awi.avS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
