package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    final /* synthetic */ bf bvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bf bfVar) {
        this.bvZ = bfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        com.baidu.tieba.card.data.m mVar2;
        com.baidu.tieba.card.data.m mVar3;
        String str;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        String str3;
        String str4;
        mVar = this.bvZ.bvV;
        if (mVar != null) {
            mVar2 = this.bvZ.bvV;
            if (!StringUtils.isNull(mVar2.bcB.rD())) {
                mVar3 = this.bvZ.bvV;
                String rD = mVar3.bcB.rD();
                str = this.bvZ.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.bvZ.alX;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bvZ.mContext);
                        str3 = this.bvZ.mStType;
                        str4 = this.bvZ.alX;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rD, str3, str4)));
                        onClickListener = this.bvZ.alY;
                        if (onClickListener == null) {
                            onClickListener2 = this.bvZ.alY;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bvZ.mContext).createNormalCfg(rD, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bvZ.alY;
                if (onClickListener == null) {
                }
            }
        }
    }
}
