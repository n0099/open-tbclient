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
    final /* synthetic */ au bCn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(au auVar) {
        this.bCn = auVar;
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
        lVar = this.bCn.bAA;
        if (lVar != null) {
            lVar2 = this.bCn.bAA;
            if (!StringUtils.isNull(lVar2.threadData.rw())) {
                lVar3 = this.bCn.bAA;
                String rw = lVar3.threadData.rw();
                str = this.bCn.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.bCn.amE;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bCn.mContext);
                        str3 = this.bCn.mStType;
                        str4 = this.bCn.amE;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rw, str3, str4)));
                        onClickListener = this.bCn.amF;
                        if (onClickListener == null) {
                            onClickListener2 = this.bCn.amF;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bCn.mContext).createNormalCfg(rw, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bCn.amF;
                if (onClickListener == null) {
                }
            }
        }
    }
}
