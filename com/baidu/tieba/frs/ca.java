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
public class ca extends com.baidu.adp.base.g {
    final /* synthetic */ by biM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(by byVar) {
        this.biM = byVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        List list;
        List list2;
        int i;
        Handler handler;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.biM.Dp;
        if (AntiHelper.pv(xVar.getErrorCode())) {
            Activity pageActivity = this.biM.mTbPageContext.getPageActivity();
            xVar4 = this.biM.Dp;
            AntiHelper.O(pageActivity, xVar4.getErrorString());
        } else if (obj == null) {
            xVar2 = this.biM.Dp;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                xVar3 = this.biM.Dp;
                com.baidu.adp.lib.util.k.showToast(m11getInst, xVar3.getErrorString());
            }
        } else {
            com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
            list = this.biM.biJ;
            if (com.baidu.tbadk.core.util.y.r(list) > 0 && yVar != null) {
                list2 = this.biM.biI;
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ce ceVar = (ce) it.next();
                    FeedForumData feedForumData = (FeedForumData) ceVar.biS.getTag();
                    if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(yVar.getFid())) {
                        feedForumData.setIsLike(1);
                        this.biM.a(ceVar);
                        break;
                    }
                }
                i = this.biM.mType;
                if (i == 1) {
                    handler = this.biM.mHandler;
                    handler.postDelayed(new cb(this, yVar), 1000L);
                }
            }
        }
    }
}
