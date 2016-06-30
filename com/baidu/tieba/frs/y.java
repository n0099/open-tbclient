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
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        int i;
        if (!com.baidu.adp.lib.util.i.ff()) {
            this.bDB.showToast(u.j.neterror);
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        bqVar = this.bDB.bCD;
        com.baidu.adp.widget.ListView.v at = bqVar.Ww().at(intValue);
        if (at instanceof b) {
            b bVar = (b) at;
            FrsActivity frsActivity = this.bDB;
            i = this.bDB.mPn;
            frsActivity.a(bVar, false, i);
            DownloadData downloadData = new DownloadData(bVar.MN);
            downloadData.setUrl(bVar.MK);
            downloadData.setName(bVar.MH);
            downloadData.setPosition(intValue);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.MG, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 1:
                case 5:
                    com.baidu.tieba.tbadkCore.al.f(bVar);
                    ((TextView) view).setText(u.j.frs_new_style_download_pause);
                    break;
                case 3:
                    a.G(this.bDB.getPageContext().getPageActivity(), bVar.MN);
                    break;
                case 6:
                case 7:
                    if (com.baidu.adp.lib.util.i.fr() && !com.baidu.adp.lib.util.i.fs()) {
                        this.bDB.a(bVar, intValue, false);
                        break;
                    } else if (this.bDB.d((b) at, intValue)) {
                        if (this.aak != null) {
                            this.aak.setVisibility(0);
                        }
                        ((TextView) view).setText(u.j.downloading2);
                        this.bDB.a(bVar, "btn_download");
                        break;
                    }
                    break;
            }
            TiebaStatic.eventStat(this.bDB.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
