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
public class y implements View.OnClickListener {
    final /* synthetic */ x aPB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.aPB = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.k kVar;
        com.baidu.tieba.card.a.k kVar2;
        com.baidu.tieba.card.a.k kVar3;
        com.baidu.tieba.card.a.k kVar4;
        Context context;
        com.baidu.tieba.card.a.k kVar5;
        com.baidu.tieba.card.a.k kVar6;
        kVar = this.aPB.aPA;
        if (kVar != null) {
            kVar2 = this.aPB.aPA;
            if (kVar2.author != null) {
                kVar3 = this.aPB.aPA;
                if (!StringUtils.isNull(kVar3.author.getName_show())) {
                    kVar4 = this.aPB.aPA;
                    if (!StringUtils.isNull(kVar4.author.getUserId())) {
                        if (this.aPB.ajv != null) {
                            this.aPB.ajv.onClick(view);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aPB.mContext;
                        kVar5 = this.aPB.aPA;
                        String userId = kVar5.author.getUserId();
                        kVar6 = this.aPB.aPA;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, kVar6.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                }
            }
        }
    }
}
