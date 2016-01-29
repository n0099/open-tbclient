package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.download.c {
    final /* synthetic */ u aqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar) {
        this.aqx = uVar;
    }

    @Override // com.baidu.tbadk.download.c
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void d(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        if (downloadData != null) {
            imageUrlData = this.aqx.aqp;
            if (imageUrlData != null) {
                imageUrlData2 = this.aqx.aqp;
                imageUrlData2.originalProcess = downloadData.getProcess();
            }
            this.aqx.aqi.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.aqx.aqi.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean e(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void f(DownloadData downloadData) {
        Runnable runnable;
        boolean ba;
        this.aqx.aqi.setText(this.aqx.getResources().getString(t.j.done));
        this.aqx.aqi.setClickable(false);
        this.aqx.aqi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        runnable = this.aqx.aqv;
        hr.postDelayed(runnable, 1500L);
        this.aqx.aqr = false;
        u uVar = this.aqx;
        ba = this.aqx.ba(false);
        uVar.aqq = ba;
        this.aqx.Bq();
    }

    @Override // com.baidu.tbadk.download.c
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.aqx.aqr = false;
        BdToast.a(this.aqx.mContext, str).uq().us();
        imageUrlData = this.aqx.aqp;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.aqx.aqp;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.aqx.aqi;
            str3 = u.aqg;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.aqx.aqp;
            textView.setText(append.append(aw.F(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.aqx.aqi;
            str2 = u.aqg;
            textView2.setText(str2);
        }
        this.aqx.aqi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
