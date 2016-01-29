package com.baidu.tieba.frs.collect;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.frs.bh;
/* loaded from: classes.dex */
class d implements bh {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MyCollectFrsActivity myCollectFrsActivity) {
        this.bmY = myCollectFrsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.frs.collect.MyCollectFrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bh
    public void a(int i, int i2, View view, View view2, ah ahVar) {
        l lVar;
        l lVar2;
        l lVar3;
        String str;
        lVar = this.bmY.bmT;
        if (i != lVar.QO().Pz()) {
            lVar2 = this.bmY.bmT;
            if (i != lVar2.QO().OL()) {
                lVar3 = this.bmY.bmT;
                if (i == lVar3.QO().PB()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.bmY.getPageContext().getPageActivity())));
                    return;
                }
                return;
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bmY;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bmY.getPageContext().getPageActivity());
            str = this.bmY.mForumName;
            myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(ahVar, str, null, 18003, true, false, false)));
        } else if (ahVar != null && ahVar.tt() != null && ahVar.tt().get(0) != null && !StringUtils.isNull(ahVar.tt().get(0).getUrl())) {
            be.wt().c(this.bmY.getPageContext(), new String[]{ahVar.tt().get(0).getUrl()});
        }
    }
}
