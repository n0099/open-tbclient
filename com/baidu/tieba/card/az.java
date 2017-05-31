package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ au bBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(au auVar) {
        this.bBu = auVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        com.baidu.tieba.card.data.l lVar2;
        com.baidu.tieba.card.data.l lVar3;
        String str;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        String str3;
        String str4;
        lVar = this.bBu.bzH;
        if (lVar != null) {
            lVar2 = this.bBu.bzH;
            if (!StringUtils.isNull(lVar2.threadData.rz())) {
                lVar3 = this.bBu.bzH;
                String rz = lVar3.threadData.rz();
                str = this.bBu.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.bBu.alN;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bBu.mContext);
                        str3 = this.bBu.mStType;
                        str4 = this.bBu.alN;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rz, str3, str4)));
                        onClickListener = this.bBu.alO;
                        if (onClickListener == null) {
                            onClickListener2 = this.bBu.alO;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bBu.mContext).createNormalCfg(rz, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bBu.alO;
                if (onClickListener == null) {
                }
            }
        }
    }
}
