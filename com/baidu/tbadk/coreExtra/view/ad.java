package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.download.d {
    final /* synthetic */ u ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar) {
        this.ani = uVar;
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
            imageUrlData = this.ani.ana;
            if (imageUrlData != null) {
                imageUrlData4 = this.ani.ana;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.ani.ana;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.ani.ana;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.ani.ana;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.ani.amT.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.ani.amT.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean e(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void f(DownloadData downloadData) {
        Runnable runnable;
        boolean bk;
        this.ani.amT.setText(this.ani.getResources().getString(u.j.done));
        this.ani.amT.setClickable(false);
        this.ani.amT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
        runnable = this.ani.ang;
        dM.postDelayed(runnable, 1500L);
        this.ani.anc = false;
        u uVar = this.ani;
        bk = this.ani.bk(false);
        uVar.anb = bk;
        this.ani.zT();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.ani.anc = false;
        BdToast.a(this.ani.mContext, str).rZ().sb();
        imageUrlData = this.ani.ana;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.ani.ana;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.ani.amT;
            str3 = u.amR;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.ani.ana;
            textView.setText(append.append(ba.L(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.ani.amT;
            str2 = u.amR;
            textView2.setText(str2);
        }
        this.ani.amT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
