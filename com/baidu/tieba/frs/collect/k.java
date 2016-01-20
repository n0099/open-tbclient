package com.baidu.tieba.frs.collect;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.util.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ z beh;
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MyCollectFrsActivity myCollectFrsActivity, z zVar) {
        this.bkc = myCollectFrsActivity;
        this.beh = zVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        l lVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bkc.bjV;
                if (str != null) {
                    MyCollectFrsActivity myCollectFrsActivity = this.bkc;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bkc.getPageContext().getPageActivity());
                    z zVar = this.beh;
                    str2 = this.bkc.mForumName;
                    z = this.bkc.bkb;
                    myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bkc.d(this.beh);
                break;
            case 2:
                this.bkc.e(this.beh);
                break;
        }
        q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.beh != null && !readThreadHistory.mD(this.beh.getId())) {
            readThreadHistory.mC(this.beh.getId());
        }
        lVar = this.bkc.bjX;
        lVar.NW();
    }
}
