package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g {
    final /* synthetic */ h bbB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bbB = hVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.x) {
            wVar4 = this.bbB.Gg;
            if (wVar4.getErrorCode() == 0) {
                return;
            }
        }
        wVar = this.bbB.Gg;
        if (AntiHelper.rp(wVar.getErrorCode())) {
            Context context = this.bbB.getContext();
            wVar3 = this.bbB.Gg;
            AntiHelper.S(context, wVar3.getErrorString());
            return;
        }
        TbPageContext<?> tbPageContext = this.bbB.getTbPageContext();
        wVar2 = this.bbB.Gg;
        tbPageContext.showToast(wVar2.getErrorString());
    }
}
