package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cu cuVar;
        int intValue = ((Integer) view.getTag()).intValue();
        cuVar = this.a.z;
        Object item = cuVar.v().getItem(intValue);
        if (item instanceof com.baidu.tbadk.core.data.a) {
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) item;
            int i = aVar.a;
            if (i == 0) {
                BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
                if (BdNetUtil.NetworkStateInfo.UNAVAIL != statusInfo && BdNetUtil.NetworkStateInfo.WIFI != statusInfo) {
                    this.a.a(aVar, intValue);
                } else {
                    this.a.a(aVar, "btn_download");
                    this.a.b(aVar, "download");
                    this.a.b((com.baidu.tbadk.core.data.a) item, intValue);
                }
            } else if (i == 2) {
                this.a.a(aVar);
            }
            TiebaStatic.eventStat(this.a, "frs_tb_btc", "");
        }
    }
}
