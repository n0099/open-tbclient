package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout csV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.csV = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        Context context;
        bk bkVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bkVar = this.csV.aSs;
        if (bkVar != null) {
            bkVar2 = this.csV.aSs;
            if (!StringUtils.isNull(bkVar2.rD())) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.csV.mContext;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context);
                bkVar3 = this.csV.aSs;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createJumpLiveTabCfg(bkVar3.rD(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                onClickListener = this.csV.alY;
                if (onClickListener != null) {
                    onClickListener2 = this.csV.alY;
                    onClickListener2.onClick(view);
                }
            }
        }
    }
}
