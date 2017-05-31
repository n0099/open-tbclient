package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ t bAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bAB = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.k kVar;
        com.baidu.tieba.card.data.k kVar2;
        com.baidu.tieba.card.data.k kVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        kVar = this.bAB.bAy;
        if (kVar != null) {
            kVar2 = this.bAB.bAy;
            if (!StringUtils.isNull(kVar2.aYA.rz())) {
                kVar3 = this.bAB.bAy;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bAB.getContext()).createNormalCfg(kVar3.aYA.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bAB.alO;
                if (onClickListener != null) {
                    onClickListener2 = this.bAB.alO;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
