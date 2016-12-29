package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aa bGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(aa aaVar) {
        this.bGn = aaVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bg bgVar;
        TbPageContext tbPageContext;
        bgVar = this.bGn.adN;
        com.baidu.tbadk.core.data.n sz = bgVar.sz();
        long cartoonId = sz.getCartoonId();
        int chapterId = sz.getChapterId();
        tbPageContext = this.bGn.GO;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
