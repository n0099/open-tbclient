package com.baidu.tbadk.coreExtra.view;

import android.widget.TextView;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.download.c {
    final /* synthetic */ z amj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.amj = zVar;
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
            imageUrlData = this.amj.amc;
            if (imageUrlData != null) {
                imageUrlData2 = this.amj.amc;
                imageUrlData2.originalProcess = downloadData.getProcess();
            }
            this.amj.alX.setText(String.valueOf(downloadData.getProcess()) + "%");
            this.amj.alX.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
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
        this.amj.alX.setText(this.amj.getResources().getString(i.h.done));
        this.amj.alX.setClickable(false);
        this.amj.alX.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        com.baidu.adp.lib.g.h hg = com.baidu.adp.lib.g.h.hg();
        runnable = this.amj.amh;
        hg.postDelayed(runnable, 1500L);
        this.amj.ame = false;
        z zVar = this.amj;
        aU = this.amj.aU(false);
        zVar.amd = aU;
        this.amj.zj();
    }

    @Override // com.baidu.tbadk.download.c
    public void a(DownloadData downloadData, int i, String str) {
        ImageUrlData imageUrlData;
        String str2;
        ImageUrlData imageUrlData2;
        this.amj.ame = false;
        BdToast.b(this.amj.mContext, str).sU().sW();
        imageUrlData = this.amj.amc;
        imageUrlData.originalProcess = -1;
        TextView textView = this.amj.alX;
        str2 = z.alV;
        StringBuilder append = new StringBuilder(String.valueOf(str2)).append("(");
        imageUrlData2 = this.amj.amc;
        textView.setText(append.append(as.w(imageUrlData2.originalSize)).append(")").toString());
        this.amj.alX.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
