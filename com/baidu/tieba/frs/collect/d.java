package com.baidu.tieba.frs.collect;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.bc;
/* loaded from: classes.dex */
class d implements bc {
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MyCollectFrsActivity myCollectFrsActivity) {
        this.bgk = myCollectFrsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.frs.collect.MyCollectFrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bc
    public void a(int i, int i2, View view, View view2, z zVar) {
        l lVar;
        l lVar2;
        l lVar3;
        String str;
        lVar = this.bgk.bgf;
        if (i != lVar.Ot().Ng()) {
            lVar2 = this.bgk.bgf;
            if (i != lVar2.Ot().Mx()) {
                lVar3 = this.bgk.bgf;
                if (i == lVar3.Ot().Ni()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.bgk.getPageContext().getPageActivity())));
                    return;
                }
                return;
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bgk;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bgk.getPageContext().getPageActivity());
            str = this.bgk.mForumName;
            myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str, null, 18003, true, false, false)));
        } else if (zVar != null && zVar.sQ() != null && zVar.sQ().get(0) != null && !StringUtils.isNull(zVar.sQ().get(0).getUrl())) {
            bf.vD().b(this.bgk.getPageContext(), new String[]{zVar.sQ().get(0).getUrl()});
        }
    }
}
