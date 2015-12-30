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
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ br bfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar) {
        this.bfQ = brVar;
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
        xVar = this.bfQ.MB;
        if (AntiHelper.ne(xVar.getErrorCode())) {
            Activity pageActivity = this.bfQ.mTbPageContext.getPageActivity();
            xVar4 = this.bfQ.MB;
            AntiHelper.Q(pageActivity, xVar4.getErrorString());
        } else if (obj == null) {
            xVar2 = this.bfQ.MB;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                xVar3 = this.bfQ.MB;
                com.baidu.adp.lib.util.k.showToast(m411getInst, xVar3.getErrorString());
            }
        } else {
            com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
            list = this.bfQ.bfO;
            if (com.baidu.tbadk.core.util.y.l(list) > 0 && yVar != null) {
                list2 = this.bfQ.bfN;
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    bx bxVar = (bx) it.next();
                    FeedForumData feedForumData = (FeedForumData) bxVar.bfW.getTag();
                    if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(yVar.getFid())) {
                        feedForumData.setIsLike(1);
                        this.bfQ.a(bxVar);
                        break;
                    }
                }
                i = this.bfQ.mType;
                if (i == 1) {
                    handler = this.bfQ.mHandler;
                    handler.postDelayed(new bu(this, yVar), 1000L);
                }
            }
        }
    }
}
