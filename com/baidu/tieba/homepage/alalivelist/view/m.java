package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout cGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.cGZ = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        Context context;
        bm bmVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bmVar = this.cGZ.bdI;
        if (bmVar != null) {
            bmVar2 = this.cGZ.bdI;
            if (!StringUtils.isNull(bmVar2.rw())) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.cGZ.mContext;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context);
                bmVar3 = this.cGZ.bdI;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createJumpLiveTabCfg(bmVar3.rw(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                onClickListener = this.cGZ.amF;
                if (onClickListener != null) {
                    onClickListener2 = this.cGZ.amF;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
