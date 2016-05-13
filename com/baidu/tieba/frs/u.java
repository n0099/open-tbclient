package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.h.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.frs.utils.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u extends AppDownloadView.a {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cn cnVar;
        int i;
        if (!com.baidu.adp.lib.util.i.fe()) {
            this.bhl.showToast(t.j.neterror);
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        cnVar = this.bhl.bgo;
        com.baidu.adp.widget.ListView.v as = cnVar.Ra().as(intValue);
        if (as instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) as;
            FrsActivity frsActivity = this.bhl;
            i = this.bhl.mPn;
            frsActivity.a(cVar, false, i);
            DownloadData downloadData = new DownloadData(cVar.MS);
            downloadData.setUrl(cVar.MR);
            downloadData.setName(cVar.MO);
            downloadData.setPosition(intValue);
            downloadData.setNotifyId(b.g(cVar.MN, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 1:
                case 5:
                    com.baidu.tieba.tbadkCore.ah.e(cVar);
                    ((TextView) view).setText(t.j.frs_new_style_download_pause);
                    break;
                case 3:
                    a.F(this.bhl.getPageContext().getPageActivity(), cVar.MS);
                    break;
                case 6:
                case 7:
                    if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                        this.bhl.a(cVar, intValue, false);
                        break;
                    } else if (this.bhl.d((com.baidu.tbadk.core.data.c) as, intValue)) {
                        if (this.ZT != null) {
                            this.ZT.setVisibility(0);
                        }
                        ((TextView) view).setText(t.j.downloading2);
                        this.bhl.a(cVar, "btn_download");
                        break;
                    }
                    break;
            }
            TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
