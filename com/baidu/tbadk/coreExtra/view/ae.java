package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.download.d {
    final /* synthetic */ u aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.aqO = uVar;
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
            imageUrlData = this.aqO.aqG;
            if (imageUrlData != null) {
                imageUrlData4 = this.aqO.aqG;
                if (imageUrlData4.originalProcess != -1) {
                    imageUrlData5 = this.aqO.aqG;
                    imageUrlData5.originalProcess = downloadData.getProcess();
                }
            }
            imageUrlData2 = this.aqO.aqG;
            if (imageUrlData2 != null) {
                imageUrlData3 = this.aqO.aqG;
                if (imageUrlData3.originalProcess == -1) {
                    return;
                }
            }
            this.aqO.aqy.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.aqO.aqy.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        Runnable runnable;
        boolean bo;
        this.aqO.aqy.setText(this.aqO.getResources().getString(r.j.done));
        this.aqO.aqy.setClickable(false);
        this.aqO.aqy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.aqO.aqM;
        eG.postDelayed(runnable, 1500L);
        this.aqO.aqI = false;
        u uVar = this.aqO;
        bo = this.aqO.bo(false);
        uVar.aqH = bo;
        this.aqO.Bm();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.aqO.aqI = false;
        BdToast.a(this.aqO.mContext, str).ts().tu();
        imageUrlData = this.aqO.aqG;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.aqO.aqG;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.aqO.aqy;
            str3 = u.aqw;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.aqO.aqG;
            textView.setText(append.append(az.I(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.aqO.aqy;
            str2 = u.aqw;
            textView2.setText(str2);
        }
        this.aqO.aqy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
