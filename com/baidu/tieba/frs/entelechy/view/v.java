package com.baidu.tieba.frs.entelechy.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bXo = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        TbPageContext tbPageContext;
        bg bgVar6;
        bg bgVar7;
        bg bgVar8;
        bg bgVar9;
        bgVar = this.bXo.adL;
        if (bgVar != null) {
            bgVar2 = this.bXo.adL;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.bXo.adL;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.bXo.adL;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        bgVar5 = this.bXo.adL;
                        if (bgVar5.getForum_name() != null) {
                            if (this.bXo.getOnSubCardOnClickListenner() != null) {
                                cf<bg> onSubCardOnClickListenner = this.bXo.getOnSubCardOnClickListenner();
                                bgVar9 = this.bXo.adL;
                                onSubCardOnClickListenner.a(view, bgVar9);
                            }
                            MessageManager messageManager = MessageManager.getInstance();
                            tbPageContext = this.bXo.GM;
                            Activity pageActivity = tbPageContext.getPageActivity();
                            bgVar6 = this.bXo.adL;
                            String userId = bgVar6.getAuthor().getUserId();
                            bgVar7 = this.bXo.adL;
                            String name_show = bgVar7.getAuthor().getName_show();
                            bgVar8 = this.bXo.adL;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(pageActivity, userId, name_show, bgVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    }
                }
            }
        }
    }
}
