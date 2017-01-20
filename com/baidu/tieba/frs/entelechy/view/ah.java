package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aa bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(aa aaVar) {
        this.bMC = aaVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bh bhVar;
        TbPageContext tbPageContext;
        bhVar = this.bMC.acX;
        com.baidu.tbadk.core.data.o sr = bhVar.sr();
        long cartoonId = sr.getCartoonId();
        int chapterId = sr.getChapterId();
        tbPageContext = this.bMC.FY;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
