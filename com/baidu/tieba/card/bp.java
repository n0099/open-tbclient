package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ bj bBJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bj bjVar) {
        this.bBJ = bjVar;
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
        mVar = this.bBJ.bBF;
        if (mVar != null) {
            mVar2 = this.bBJ.bBF;
            if (!StringUtils.isNull(mVar2.aYA.rz())) {
                mVar3 = this.bBJ.bBF;
                String rz = mVar3.aYA.rz();
                str = this.bBJ.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.bBJ.alN;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bBJ.mContext);
                        str3 = this.bBJ.mStType;
                        str4 = this.bBJ.alN;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rz, str3, str4)));
                        onClickListener = this.bBJ.alO;
                        if (onClickListener == null) {
                            onClickListener2 = this.bBJ.alO;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bBJ.mContext).createNormalCfg(rz, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bBJ.alO;
                if (onClickListener == null) {
                }
            }
        }
    }
}
