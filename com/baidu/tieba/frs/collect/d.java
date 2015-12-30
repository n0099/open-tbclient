package com.baidu.tieba.frs.collect;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.bf;
/* loaded from: classes.dex */
class d implements bf {
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MyCollectFrsActivity myCollectFrsActivity) {
        this.bkc = myCollectFrsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.frs.collect.MyCollectFrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bf
    public void a(int i, int i2, View view, View view2, z zVar) {
        l lVar;
        l lVar2;
        l lVar3;
        String str;
        lVar = this.bkc.bjX;
        if (i != lVar.OL().Nz()) {
            lVar2 = this.bkc.bjX;
            if (i != lVar2.OL().MQ()) {
                lVar3 = this.bkc.bjX;
                if (i == lVar3.OL().NB()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.bkc.getPageContext().getPageActivity())));
                    return;
                }
                return;
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bkc;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bkc.getPageContext().getPageActivity());
            str = this.bkc.mForumName;
            myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str, null, 18003, true, false, false)));
        } else if (zVar != null && zVar.sA() != null && zVar.sA().get(0) != null && !StringUtils.isNull(zVar.sA().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bf.vn().b(this.bkc.getPageContext(), new String[]{zVar.sA().get(0).getUrl()});
        }
    }
}
