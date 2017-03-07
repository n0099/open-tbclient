package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout cvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.cvh = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bjVar = this.cvh.aRF;
        if (bjVar != null) {
            bjVar2 = this.cvh.aRF;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.cvh.aRF;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.cvh.aRF;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.cvh.aRF;
                        long c = com.baidu.adp.lib.g.b.c(bjVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.cvh.mContext;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.cvh.amj;
                        if (onClickListener != null) {
                            onClickListener2 = this.cvh.amj;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
