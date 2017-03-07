package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout cvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.cvh = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        Context context;
        bj bjVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bjVar = this.cvh.aRF;
        if (bjVar != null) {
            bjVar2 = this.cvh.aRF;
            if (!StringUtils.isNull(bjVar2.rV())) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.cvh.mContext;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context);
                bjVar3 = this.cvh.aRF;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createJumpLiveTabCfg(bjVar3.rV(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                onClickListener = this.cvh.alM;
                if (onClickListener != null) {
                    onClickListener2 = this.cvh.alM;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
