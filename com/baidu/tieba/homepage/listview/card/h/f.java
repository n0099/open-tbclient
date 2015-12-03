package com.baidu.tieba.homepage.listview.card.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bBL;
    private final /* synthetic */ b bBM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, b bVar) {
        this.bBL = eVar;
        this.bBM = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        String valueOf = String.valueOf(this.bBM.bBw.bAE);
        TiebaStatic.log(new av("c10547").ab("tid", valueOf));
        tbPageContext = this.bBL.pageContext;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PHOTOLIVE_ACTIVITY, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), valueOf).rw()));
    }
}
