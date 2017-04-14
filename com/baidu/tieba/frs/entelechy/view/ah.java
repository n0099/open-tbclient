package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ aa bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(aa aaVar) {
        this.bTy = aaVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bi biVar;
        TbPageContext tbPageContext;
        biVar = this.bTy.aiB;
        com.baidu.tbadk.core.data.n tk = biVar.tk();
        long cartoonId = tk.getCartoonId();
        int chapterId = tk.getChapterId();
        tbPageContext = this.bTy.ajT;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
