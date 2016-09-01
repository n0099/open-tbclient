package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.download.d {
    final /* synthetic */ u are;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar) {
        this.are = uVar;
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
            imageUrlData = this.are.aqW;
            if (imageUrlData != null) {
                imageUrlData4 = this.are.aqW;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.are.aqW;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.are.aqW;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.are.aqW;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.are.aqP.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.are.aqP.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        Runnable runnable;
        boolean bp;
        this.are.aqP.setText(this.are.getResources().getString(t.j.done));
        this.are.aqP.setClickable(false);
        this.are.aqP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.are.arc;
        eG.postDelayed(runnable, 1500L);
        this.are.aqY = false;
        u uVar = this.are;
        bp = this.are.bp(false);
        uVar.aqX = bp;
        this.are.Bi();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.are.aqY = false;
        BdToast.a(this.are.mContext, str).td().tf();
        imageUrlData = this.are.aqW;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.are.aqW;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.are.aqP;
            str3 = u.aqN;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.are.aqW;
            textView.setText(append.append(ba.H(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.are.aqP;
            str2 = u.aqN;
            textView2.setText(str2);
        }
        this.are.aqP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
