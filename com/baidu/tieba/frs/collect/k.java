package com.baidu.tieba.frs.collect;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.util.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ ah bgD;
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MyCollectFrsActivity myCollectFrsActivity, ah ahVar) {
        this.bmY = myCollectFrsActivity;
        this.bgD = ahVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        l lVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bmY.bmR;
                if (str != null) {
                    MyCollectFrsActivity myCollectFrsActivity = this.bmY;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bmY.getPageContext().getPageActivity());
                    ah ahVar = this.bgD;
                    str2 = this.bmY.mForumName;
                    z = this.bmY.bmX;
                    myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(ahVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bmY.d(this.bgD);
                break;
            case 2:
                this.bmY.e(this.bgD);
                break;
        }
        r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bgD != null && !readThreadHistory.mU(this.bgD.getId())) {
            readThreadHistory.mT(this.bgD.getId());
        }
        lVar = this.bmY.bmT;
        lVar.PW();
    }
}
