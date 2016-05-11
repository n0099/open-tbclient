package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ w bpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(w wVar) {
        this.bpM = wVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        ax axVar;
        TbPageContext tbPageContext;
        axVar = this.bpM.aab;
        com.baidu.tbadk.core.data.k ru = axVar.ru();
        long cartoonId = ru.getCartoonId();
        int chapterId = ru.getChapterId();
        tbPageContext = this.bpM.DV;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
