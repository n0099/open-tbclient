package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.download.c {
    final /* synthetic */ z ami;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.ami = zVar;
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
            imageUrlData = this.ami.amb;
            if (imageUrlData != null) {
                imageUrlData2 = this.ami.amb;
                imageUrlData2.originalProcess = downloadData.getProcess();
            }
            this.ami.alW.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.ami.alW.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
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
        this.ami.alW.setText(this.ami.getResources().getString(i.h.done));
        this.ami.alW.setClickable(false);
        this.ami.alW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h hg = com.baidu.adp.lib.g.h.hg();
        runnable = this.ami.amg;
        hg.postDelayed(runnable, 1500L);
        this.ami.amd = false;
        z zVar = this.ami;
        aU = this.ami.aU(false);
        zVar.amc = aU;
        this.ami.zm();
    }

    @Override // com.baidu.tbadk.download.c
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        String str2;
        ImageUrlData imageUrlData2;
        this.ami.amd = false;
        BdToast.b(this.ami.mContext, str).sX().sZ();
        imageUrlData = this.ami.amb;
        imageUrlData.originalProcess = -1;
        TextView textView = this.ami.alW;
        str2 = z.alU;
        StringBuilder append = new StringBuilder(String.valueOf(str2)).append("(");
        imageUrlData2 = this.ami.amb;
        textView.setText(append.append(ar.y(imageUrlData2.originalSize)).append(")").toString());
        this.ami.alW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
