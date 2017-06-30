package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.chB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        TbPageContext tbPageContext;
        bm bmVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bmVar = this.chB.aiu;
        if (bmVar != null) {
            bmVar2 = this.chB.aiu;
            if (!StringUtils.isNull(bmVar2.rw())) {
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = this.chB.aat;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(tbPageContext.getPageActivity());
                bmVar3 = this.chB.aiu;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createNormalCfg(bmVar3.rw(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.chB.amF;
                if (onClickListener == null) {
                    return;
                }
                onClickListener2 = this.chB.amF;
                onClickListener2.onClick(view);
            }
        }
    }
}
