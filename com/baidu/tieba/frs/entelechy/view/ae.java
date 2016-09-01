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
public class ae implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ x bXt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(x xVar) {
        this.bXt = xVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bg bgVar;
        TbPageContext tbPageContext;
        bgVar = this.bXt.adL;
        com.baidu.tbadk.core.data.m sw = bgVar.sw();
        long cartoonId = sw.getCartoonId();
        int chapterId = sw.getChapterId();
        tbPageContext = this.bXt.GM;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
