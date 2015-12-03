package com.baidu.tieba.homepage.listview.card.e.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.homepage.listview.card.e.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bAA;
    private final /* synthetic */ b.a bAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, b.a aVar2) {
        this.bAA = aVar;
        this.bAB = aVar2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TiebaStatic.log(new av("c10556").ab("uid", String.valueOf(this.bAB.uid)));
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.bAA.mPageContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), new StringBuilder(String.valueOf(this.bAB.uid)).toString(), this.bAB.userName)));
    }
}
