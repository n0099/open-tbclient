package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.download.d {
    final /* synthetic */ u anX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar) {
        this.anX = uVar;
    }

    @Override // com.baidu.tbadk.download.d
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        ImageUrlData imageUrlData3;
        ImageUrlData imageUrlData4;
        ImageUrlData imageUrlData5;
        if (downloadData != null) {
            imageUrlData = this.anX.anP;
            if (imageUrlData != null) {
                imageUrlData4 = this.anX.anP;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.anX.anP;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.anX.anP;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.anX.anP;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.anX.anI.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.anX.anI.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean e(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void f(DownloadData downloadData) {
        Runnable runnable;
        boolean bn;
        this.anX.anI.setText(this.anX.getResources().getString(u.j.done));
        this.anX.anI.setClickable(false);
        this.anX.anI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable = this.anX.anV;
        dL.postDelayed(runnable, 1500L);
        this.anX.anR = false;
        u uVar = this.anX;
        bn = this.anX.bn(false);
        uVar.anQ = bn;
        this.anX.zT();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.anX.anR = false;
        BdToast.a(this.anX.mContext, str).rY().sa();
        imageUrlData = this.anX.anP;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.anX.anP;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.anX.anI;
            str3 = u.anG;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.anX.anP;
            textView.setText(append.append(ba.G(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.anX.anI;
            str2 = u.anG;
            textView2.setText(str2);
        }
        this.anX.anI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
