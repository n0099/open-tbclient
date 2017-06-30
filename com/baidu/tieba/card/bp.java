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
    final /* synthetic */ bj bCC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bj bjVar) {
        this.bCC = bjVar;
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
        mVar = this.bCC.bCy;
        if (mVar != null) {
            mVar2 = this.bCC.bCy;
            if (!StringUtils.isNull(mVar2.bai.rw())) {
                mVar3 = this.bCC.bCy;
                String rw = mVar3.bai.rw();
                str = this.bCC.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.bCC.amE;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bCC.mContext);
                        str3 = this.bCC.mStType;
                        str4 = this.bCC.amE;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rw, str3, str4)));
                        onClickListener = this.bCC.amF;
                        if (onClickListener == null) {
                            onClickListener2 = this.bCC.amF;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bCC.mContext).createNormalCfg(rw, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.bCC.amF;
                if (onClickListener == null) {
                }
            }
        }
    }
}
