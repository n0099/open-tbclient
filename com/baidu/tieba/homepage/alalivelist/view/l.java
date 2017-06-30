package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout cGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.cGZ = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        Context context;
        bm bmVar6;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bmVar = this.cGZ.bdI;
        if (bmVar != null) {
            bmVar2 = this.cGZ.bdI;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.cGZ.bdI;
                if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                    bmVar4 = this.cGZ.bdI;
                    if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                        bmVar5 = this.cGZ.bdI;
                        long c = com.baidu.adp.lib.g.b.c(bmVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.cGZ.mContext;
                        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(context);
                        bmVar6 = this.cGZ.bdI;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(c, z, bmVar6.getAuthor().isBigV())));
                        onClickListener = this.cGZ.amS;
                        if (onClickListener != null) {
                            onClickListener2 = this.cGZ.amS;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
