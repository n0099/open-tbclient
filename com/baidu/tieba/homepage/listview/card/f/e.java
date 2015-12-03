package com.baidu.tieba.homepage.listview.card.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.homepage.listview.card.f.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bAO;
    private final /* synthetic */ b.a bAP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, b.a aVar) {
        this.bAO = cVar;
        this.bAP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        if (!StringUtils.isNull(this.bAP.forumName)) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.bAO.pageContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(this.bAP.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }
}
