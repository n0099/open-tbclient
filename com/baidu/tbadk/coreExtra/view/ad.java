package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.download.d {
    final /* synthetic */ u aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar) {
        this.aqO = uVar;
    }

    @Override // com.baidu.tbadk.download.d
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        if (downloadData != null) {
            imageUrlData = this.aqO.aqG;
            if (imageUrlData != null) {
                imageUrlData2 = this.aqO.aqG;
                imageUrlData2.originalProcess = downloadData.getProcess();
            }
            this.aqO.aqz.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.aqO.aqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean e(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void f(DownloadData downloadData) {
        Runnable runnable;
        boolean bg;
        this.aqO.aqz.setText(this.aqO.getResources().getString(t.j.done));
        this.aqO.aqz.setClickable(false);
        this.aqO.aqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        runnable = this.aqO.aqM;
        hx.postDelayed(runnable, 1500L);
        this.aqO.aqI = false;
        u uVar = this.aqO;
        bg = this.aqO.bg(false);
        uVar.aqH = bg;
        this.aqO.BT();
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        String str2;
        String str3;
        ImageUrlData imageUrlData3;
        this.aqO.aqI = false;
        BdToast.a(this.aqO.mContext, str).uv().ux();
        imageUrlData = this.aqO.aqG;
        imageUrlData.originalProcess = -1;
        imageUrlData2 = this.aqO.aqG;
        if (imageUrlData2.originalSize > 0) {
            TextView textView = this.aqO.aqz;
            str3 = u.aqx;
            StringBuilder append = new StringBuilder(String.valueOf(str3)).append("(");
            imageUrlData3 = this.aqO.aqG;
            textView.setText(append.append(ay.H(imageUrlData3.originalSize)).append(")").toString());
        } else {
            TextView textView2 = this.aqO.aqz;
            str2 = u.aqx;
            textView2.setText(str2);
        }
        this.aqO.aqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
