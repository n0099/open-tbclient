package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.bTA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        TbPageContext tbPageContext;
        bk bkVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bkVar = this.bTA.ahV;
        if (bkVar != null) {
            bkVar2 = this.bTA.ahV;
            if (!StringUtils.isNull(bkVar2.rD())) {
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = this.bTA.aat;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(tbPageContext.getPageActivity());
                bkVar3 = this.bTA.ahV;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createNormalCfg(bkVar3.rD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bTA.alY;
                if (onClickListener == null) {
                    return;
                }
                onClickListener2 = this.bTA.alY;
                onClickListener2.onClick(view);
            }
        }
    }
}
