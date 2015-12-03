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
public class bq extends com.baidu.adp.base.g {
    final /* synthetic */ bo bbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bo boVar) {
        this.bbR = boVar;
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
        xVar = this.bbR.Ml;
        if (AntiHelper.mC(xVar.getErrorCode())) {
            Activity pageActivity = this.bbR.mTbPageContext.getPageActivity();
            xVar4 = this.bbR.Ml;
            AntiHelper.Q(pageActivity, xVar4.getErrorString());
        } else if (obj == null) {
            xVar2 = this.bbR.Ml;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                xVar3 = this.bbR.Ml;
                com.baidu.adp.lib.util.k.showToast(m411getInst, xVar3.getErrorString());
            }
        } else {
            com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
            list = this.bbR.bbP;
            if (com.baidu.tbadk.core.util.y.k(list) > 0 && yVar != null) {
                list2 = this.bbR.bbO;
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    bu buVar = (bu) it.next();
                    FeedForumData feedForumData = (FeedForumData) buVar.bbX.getTag();
                    if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(yVar.getFid())) {
                        feedForumData.setIsLike(1);
                        this.bbR.a(buVar);
                        break;
                    }
                }
                i = this.bbR.mType;
                if (i == 1) {
                    handler = this.bbR.mHandler;
                    handler.postDelayed(new br(this, yVar), 1000L);
                }
            }
        }
    }
}
