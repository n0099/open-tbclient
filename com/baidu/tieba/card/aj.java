package com.baidu.tieba.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ai aTn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.aTn = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.r rVar;
        com.baidu.tieba.card.a.r rVar2;
        com.baidu.tieba.card.a.r rVar3;
        com.baidu.tieba.card.a.r rVar4;
        Context context;
        com.baidu.tieba.card.a.r rVar5;
        com.baidu.tieba.card.a.r rVar6;
        rVar = this.aTn.aTm;
        if (rVar != null) {
            rVar2 = this.aTn.aTm;
            if (rVar2.author != null) {
                rVar3 = this.aTn.aTm;
                if (!StringUtils.isNull(rVar3.author.getName_show())) {
                    rVar4 = this.aTn.aTm;
                    if (!StringUtils.isNull(rVar4.author.getUserId())) {
                        if (this.aTn.anH != null) {
                            this.aTn.anH.onClick(view);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aTn.mContext;
                        rVar5 = this.aTn.aTm;
                        String userId = rVar5.author.getUserId();
                        rVar6 = this.aTn.aTm;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, rVar6.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                }
            }
        }
    }
}
