package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ u bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.bKt = uVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        az azVar;
        TbPageContext tbPageContext;
        azVar = this.bKt.aas;
        com.baidu.tbadk.core.data.l rs = azVar.rs();
        long cartoonId = rs.getCartoonId();
        int chapterId = rs.getChapterId();
        tbPageContext = this.bKt.Ea;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
