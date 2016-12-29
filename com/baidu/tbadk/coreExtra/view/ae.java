package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u arl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.arl = uVar;
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
            imageUrlData = this.arl.ard;
            if (imageUrlData != null) {
                imageUrlData4 = this.arl.ard;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.arl.ard;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.arl.ard;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.arl.ard;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.arl.aqV.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.arl.aqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
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
        this.arl.aqV.setText(this.arl.getResources().getString(r.j.done));
        this.arl.aqV.setClickable(false);
        this.arl.aqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.arl.arj;
        eG.postDelayed(runnable, 1500L);
        this.arl.arf = false;
        u uVar = this.arl;
        bs = this.arl.bs(false);
        uVar.are = bs;
        this.arl.Bg();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.arl.arf = false;
        BdToast.a(this.arl.mContext, str).th().tj();
        imageUrlData = this.arl.ard;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.arl.ard;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.arl.aqV;
            str3 = u.aqT;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.arl.ard;
            textView.setText(append.append(av.G(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.arl.aqV;
            str2 = u.aqT;
            textView2.setText(str2);
        }
        this.arl.aqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
