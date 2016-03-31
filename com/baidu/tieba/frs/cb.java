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
public class cb extends com.baidu.adp.base.g {
    final /* synthetic */ bz bnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bz bzVar) {
        this.bnj = bzVar;
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
        wVar = this.bnj.MY;
        if (AntiHelper.pB(wVar.getErrorCode())) {
            Activity pageActivity = this.bnj.mTbPageContext.getPageActivity();
            wVar4 = this.bnj.MY;
            AntiHelper.O(pageActivity, wVar4.getErrorString());
        } else if (obj == null) {
            wVar2 = this.bnj.MY;
            if (!StringUtils.isNull(wVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                wVar3 = this.bnj.MY;
                com.baidu.adp.lib.util.k.showToast(m411getInst, wVar3.getErrorString());
            }
        } else {
            com.baidu.tieba.tbadkCore.x xVar = (com.baidu.tieba.tbadkCore.x) obj;
            list = this.bnj.bnh;
            if (com.baidu.tbadk.core.util.y.p(list) > 0 && xVar != null) {
                list2 = this.bnj.bng;
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cf cfVar = (cf) it.next();
                    FeedForumData feedForumData = (FeedForumData) cfVar.bnp.getTag();
                    if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(xVar.getFid())) {
                        feedForumData.setIsLike(1);
                        this.bnj.a(cfVar);
                        break;
                    }
                }
                i = this.bnj.mType;
                if (i == 1) {
                    handler = this.bnj.mHandler;
                    handler.postDelayed(new cc(this, xVar), 1000L);
                }
            }
        }
    }
}
