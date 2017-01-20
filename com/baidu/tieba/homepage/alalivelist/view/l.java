package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout ctI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.ctI = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bhVar = this.ctI.aLS;
        if (bhVar != null) {
            bhVar2 = this.ctI.aLS;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.ctI.aLS;
                if (!StringUtils.isNull(bhVar3.getAuthor().getName_show())) {
                    bhVar4 = this.ctI.aLS;
                    if (!StringUtils.isNull(bhVar4.getAuthor().getUserId())) {
                        bhVar5 = this.ctI.aLS;
                        long c = com.baidu.adp.lib.g.b.c(bhVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.ctI.mContext;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.ctI.agO;
                        if (onClickListener != null) {
                            onClickListener2 = this.ctI.agO;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
