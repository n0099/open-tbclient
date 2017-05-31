package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ x bZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.bZy = xVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bl blVar;
        TbPageContext tbPageContext;
        blVar = this.bZy.ahM;
        com.baidu.tbadk.core.data.n sq = blVar.sq();
        long cartoonId = sq.getCartoonId();
        int chapterId = sq.getChapterId();
        tbPageContext = this.bZy.ajh;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
