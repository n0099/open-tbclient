package com.baidu.tieba.homepage.listview.card.g;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f bBt;
    private final /* synthetic */ b bBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, b bVar) {
        this.bBt = fVar;
        this.bBu = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tieba.homepage.fragment.data.d.b(this.bBu);
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bBt.pageContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(String.valueOf(this.bBu.bAV), this.bBu.bAW, "homepage")));
    }
}
