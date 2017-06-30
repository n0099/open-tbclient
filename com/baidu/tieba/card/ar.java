package com.baidu.tieba.card;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ap bCd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.bCd = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.bm bmVar;
        com.baidu.tbadk.core.data.bm bmVar2;
        com.baidu.tbadk.core.data.bm bmVar3;
        com.baidu.tbadk.core.data.bm bmVar4;
        com.baidu.tbadk.core.data.bm bmVar5;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.bm bmVar6;
        com.baidu.tbadk.core.data.bm bmVar7;
        com.baidu.tbadk.core.data.bm bmVar8;
        com.baidu.tieba.card.data.l lVar;
        bmVar = this.bCd.aiu;
        if (bmVar != null) {
            bmVar2 = this.bCd.aiu;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.bCd.aiu;
                if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                    bmVar4 = this.bCd.aiu;
                    if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                        bmVar5 = this.bCd.aiu;
                        if (bmVar5.rw() != null) {
                            if (this.bCd.Vs() != null) {
                                ci<com.baidu.tieba.card.data.l> Vs = this.bCd.Vs();
                                lVar = this.bCd.bCb;
                                Vs.a(view, lVar);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bCd.ajP;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bmVar6 = this.bCd.aiu;
                            String userId = bmVar6.getAuthor().getUserId();
                            bmVar7 = this.bCd.aiu;
                            String name_show = bmVar7.getAuthor().getName_show();
                            bmVar8 = this.bCd.aiu;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bmVar8.rw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
