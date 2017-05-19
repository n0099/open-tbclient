package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ aq bvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(aq aqVar) {
        this.bvK = aqVar;
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
        lVar = this.bvK.bvE;
        if (lVar != null) {
            lVar2 = this.bvK.bvE;
            if (!StringUtils.isNull(lVar2.threadData.rD())) {
                lVar3 = this.bvK.bvE;
                String rD = lVar3.threadData.rD();
                str = this.bvK.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.bvK.alX;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bvK.mContext);
                        str3 = this.bvK.mStType;
                        str4 = this.bvK.alX;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rD, str3, str4)));
                        onClickListener = this.bvK.alY;
                        if (onClickListener == null) {
                            onClickListener2 = this.bvK.alY;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bvK.mContext).createNormalCfg(rD, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bvK.alY;
                if (onClickListener == null) {
                }
            }
        }
    }
}
