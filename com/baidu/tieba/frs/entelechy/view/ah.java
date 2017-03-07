package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aa bTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(aa aaVar) {
        this.bTK = aaVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bj bjVar;
        TbPageContext tbPageContext;
        bjVar = this.bTK.ain;
        com.baidu.tbadk.core.data.n sM = bjVar.sM();
        long cartoonId = sM.getCartoonId();
        int chapterId = sM.getChapterId();
        tbPageContext = this.bTK.ajF;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
