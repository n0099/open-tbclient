package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.frs.utils.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class y extends AppDownloadView.a {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        int i;
        if (!com.baidu.adp.lib.util.i.fe()) {
            this.bEL.showToast(u.j.neterror);
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        bqVar = this.bEL.bDK;
        com.baidu.adp.widget.ListView.v aw = bqVar.WN().aw(intValue);
        if (aw instanceof b) {
            b bVar = (b) aw;
            FrsActivity frsActivity = this.bEL;
            i = this.bEL.mPn;
            frsActivity.a(bVar, false, i);
            DownloadData downloadData = new DownloadData(bVar.MK);
            downloadData.setUrl(bVar.MI);
            downloadData.setName(bVar.MF);
            downloadData.setPosition(intValue);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.ME, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 1:
                case 5:
                    com.baidu.tieba.tbadkCore.al.e(bVar);
                    ((TextView) view).setText(u.j.frs_new_style_download_pause);
                    break;
                case 3:
                    a.G(this.bEL.getPageContext().getPageActivity(), bVar.MK);
                    break;
                case 6:
                case 7:
                    if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                        this.bEL.a(bVar, intValue, false);
                        break;
                    } else if (this.bEL.d((b) aw, intValue)) {
                        if (this.aaT != null) {
                            this.aaT.setVisibility(0);
                        }
                        ((TextView) view).setText(u.j.downloading2);
                        this.bEL.a(bVar, "btn_download");
                        break;
                    }
                    break;
            }
            TiebaStatic.eventStat(this.bEL.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
