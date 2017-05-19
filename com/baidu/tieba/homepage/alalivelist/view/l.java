package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ThreadLiveAndRecordUserInfoLayout csV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ThreadLiveAndRecordUserInfoLayout threadLiveAndRecordUserInfoLayout) {
        this.csV = threadLiveAndRecordUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bkVar = this.csV.aSs;
        if (bkVar != null) {
            bkVar2 = this.csV.aSs;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.csV.aSs;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.csV.aSs;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.csV.aSs;
                        long c = com.baidu.adp.lib.g.b.c(bkVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.csV.mContext;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.csV.amk;
                        if (onClickListener != null) {
                            onClickListener2 = this.csV.amk;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
