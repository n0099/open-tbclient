package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ v bMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.bMb = vVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        be beVar;
        TbPageContext tbPageContext;
        beVar = this.bMb.abb;
        com.baidu.tbadk.core.data.m rr = beVar.rr();
        long cartoonId = rr.getCartoonId();
        int chapterId = rr.getChapterId();
        tbPageContext = this.bMb.EA;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
