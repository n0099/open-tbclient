package com.baidu.tieba.homepage.listview.card.i.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.homepage.listview.card.i.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bBV;
    private final /* synthetic */ b.a bBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, b.a aVar2) {
        this.bBV = aVar;
        this.bBW = aVar2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TiebaStatic.log(new av("c10559").ab("tid", String.valueOf(this.bBW.bAE)));
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bBV.mPageContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.bBW.bAE)).toString(), null, null)));
    }
}
