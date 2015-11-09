package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.download.c {
    final /* synthetic */ z amo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.amo = zVar;
    }

    @Override // com.baidu.tbadk.download.c
    public boolean a(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void b(DownloadData downloadData) {
        ImageUrlData imageUrlData;
        ImageUrlData imageUrlData2;
        if (downloadData != null) {
            imageUrlData = this.amo.amh;
            if (imageUrlData != null) {
                imageUrlData2 = this.amo.amh;
                imageUrlData2.originalProcess = downloadData.getProcess();
            }
            this.amo.amc.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.amo.amc.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void d(DownloadData downloadData) {
        Runnable runnable;
        boolean aU;
        this.amo.amc.setText(this.amo.getResources().getString(i.h.done));
        this.amo.amc.setClickable(false);
        this.amo.amc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h hh = com.baidu.adp.lib.g.h.hh();
        runnable = this.amo.amm;
        hh.postDelayed(runnable, 1500L);
        this.amo.amj = false;
        z zVar = this.amo;
        aU = this.amo.aU(false);
        zVar.ami = aU;
        this.amo.zo();
    }

    @Override // com.baidu.tbadk.download.c
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        String str2;
        ImageUrlData imageUrlData2;
        this.amo.amj = false;
        BdToast.b(this.amo.mContext, str).sX().sZ();
        imageUrlData = this.amo.amh;
        imageUrlData.originalProcess = -1;
        TextView textView = this.amo.amc;
        str2 = z.ama;
        StringBuilder append = new StringBuilder(String.valueOf(str2)).append("(");
        imageUrlData2 = this.amo.amh;
        textView.setText(append.append(as.w(imageUrlData2.originalSize)).append(")").toString());
        this.amo.amc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
