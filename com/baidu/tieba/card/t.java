package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p buU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.buU = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.k kVar;
        com.baidu.tieba.card.data.k kVar2;
        com.baidu.tieba.card.data.k kVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        kVar = this.buU.buM;
        if (kVar != null) {
            kVar2 = this.buU.buM;
            if (!StringUtils.isNull(kVar2.bcB.rD())) {
                kVar3 = this.buU.buM;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.buU.getContext()).createNormalCfg(kVar3.bcB.rD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.buU.alY;
                if (onClickListener != null) {
                    onClickListener2 = this.buU.alY;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
