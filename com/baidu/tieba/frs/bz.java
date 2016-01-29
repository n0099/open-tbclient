package com.baidu.tieba.frs;

import android.app.Activity;
import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends com.baidu.adp.base.g {
    final /* synthetic */ bx biy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bx bxVar) {
        this.biy = bxVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        List list;
        List list2;
        int i;
        Handler handler;
        com.baidu.tieba.tbadkCore.w wVar4;
        wVar = this.biy.MS;
        if (AntiHelper.or(wVar.getErrorCode())) {
            Activity pageActivity = this.biy.mTbPageContext.getPageActivity();
            wVar4 = this.biy.MS;
            AntiHelper.X(pageActivity, wVar4.getErrorString());
        } else if (obj == null) {
            wVar2 = this.biy.MS;
            if (!StringUtils.isNull(wVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                wVar3 = this.biy.MS;
                com.baidu.adp.lib.util.k.showToast(m411getInst, wVar3.getErrorString());
            }
        } else {
            com.baidu.tieba.tbadkCore.x xVar = (com.baidu.tieba.tbadkCore.x) obj;
            list = this.biy.biw;
            if (com.baidu.tbadk.core.util.x.o(list) > 0 && xVar != null) {
                list2 = this.biy.biv;
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cd cdVar = (cd) it.next();
                    FeedForumData feedForumData = (FeedForumData) cdVar.biE.getTag();
                    if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(xVar.getFid())) {
                        feedForumData.setIsLike(1);
                        this.biy.a(cdVar);
                        break;
                    }
                }
                i = this.biy.mType;
                if (i == 1) {
                    handler = this.biy.mHandler;
                    handler.postDelayed(new ca(this, xVar), 1000L);
                }
            }
        }
    }
}
