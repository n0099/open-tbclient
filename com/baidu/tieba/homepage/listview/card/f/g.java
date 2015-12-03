package com.baidu.tieba.homepage.listview.card.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f bAR;
    private final /* synthetic */ b bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, b bVar) {
        this.bAR = fVar;
        this.bAS = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tieba.homepage.fragment.data.d.a(this.bAS);
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bAR.pageContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
    }
}
