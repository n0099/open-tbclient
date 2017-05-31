package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout czn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.czn = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        Context context;
        bl blVar6;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        blVar = this.czn.bbF;
        if (blVar != null) {
            blVar2 = this.czn.bbF;
            if (blVar2.getAuthor() != null) {
                blVar3 = this.czn.bbF;
                if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                    blVar4 = this.czn.bbF;
                    if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                        blVar5 = this.czn.bbF;
                        long c = com.baidu.adp.lib.g.b.c(blVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.czn.mContext;
                        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(context);
                        blVar6 = this.czn.bbF;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(c, z, blVar6.getAuthor().isBigV())));
                        onClickListener = this.czn.ama;
                        if (onClickListener != null) {
                            onClickListener2 = this.czn.ama;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
