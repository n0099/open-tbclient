package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.bZs = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        TbPageContext tbPageContext;
        bl blVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        blVar = this.bZs.ahM;
        if (blVar != null) {
            blVar2 = this.bZs.ahM;
            if (!StringUtils.isNull(blVar2.rz())) {
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = this.bZs.aas;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(tbPageContext.getPageActivity());
                blVar3 = this.bZs.ahM;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createNormalCfg(blVar3.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bZs.alO;
                if (onClickListener == null) {
                    return;
                }
                onClickListener2 = this.bZs.alO;
                onClickListener2.onClick(view);
            }
        }
    }
}
