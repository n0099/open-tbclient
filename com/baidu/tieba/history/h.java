package com.baidu.tieba.history;

import android.content.Context;
import com.baidu.adp.base.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mainTab.e {
    final /* synthetic */ g aOa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2, i3, i4);
        this.aOa = gVar;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void onClick() {
        com.baidu.tbadk.mainTab.f fVar;
        fVar = PbHistoryStatic.aNZ;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(((TbPageContext) m.D(fVar.getContext())).getPageActivity())));
    }
}
