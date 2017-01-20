package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout ctI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.ctI = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        Context context;
        bh bhVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bhVar = this.ctI.aLS;
        if (bhVar != null) {
            bhVar2 = this.ctI.aLS;
            if (!StringUtils.isNull(bhVar2.rB())) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.ctI.mContext;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context);
                bhVar3 = this.ctI.aLS;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createJumpLiveTabCfg(bhVar3.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                onClickListener = this.ctI.agt;
                if (onClickListener != null) {
                    onClickListener2 = this.ctI.agt;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
