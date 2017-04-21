package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout cvY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.cvY = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        Context context;
        bi biVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        biVar = this.cvY.aRX;
        if (biVar != null) {
            biVar2 = this.cvY.aRX;
            if (!StringUtils.isNull(biVar2.st())) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.cvY.mContext;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context);
                biVar3 = this.cvY.aRX;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createJumpLiveTabCfg(biVar3.st(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                onClickListener = this.cvY.ama;
                if (onClickListener != null) {
                    onClickListener2 = this.cvY.ama;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
