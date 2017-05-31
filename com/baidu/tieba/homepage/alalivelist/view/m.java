package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout czn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.czn = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        Context context;
        bl blVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        blVar = this.czn.bbF;
        if (blVar != null) {
            blVar2 = this.czn.bbF;
            if (!StringUtils.isNull(blVar2.rz())) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.czn.mContext;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context);
                blVar3 = this.czn.bbF;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createJumpLiveTabCfg(blVar3.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                onClickListener = this.czn.alO;
                if (onClickListener != null) {
                    onClickListener2 = this.czn.alO;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
