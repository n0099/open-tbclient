package com.baidu.tieba.homepage.listview.card.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.homepage.listview.card.h.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bBG;
    private final /* synthetic */ b.C0065b bBH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, b.C0065b c0065b) {
        this.bBG = cVar;
        this.bBH = c0065b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        String valueOf = String.valueOf(this.bBH.bAE);
        TiebaStatic.log(new av("c10547").ab("tid", valueOf));
        tbPageContext = this.bBG.pageContext;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PHOTOLIVE_ACTIVITY, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), valueOf).rw()));
    }
}
