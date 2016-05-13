package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.g {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(k kVar) {
        this.aXF = kVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.aXF.Dp;
        if (AntiHelper.pv(xVar.getErrorCode())) {
            Activity pageActivity = this.aXF.aJw.getPageContext().getPageActivity();
            xVar4 = this.aXF.Dp;
            AntiHelper.O(pageActivity, xVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.aXF.aXl;
            str = this.aXF.aXn;
            cVar.cu(!StringUtils.isNull(str));
        } else {
            xVar2 = this.aXF.Dp;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                xVar3 = this.aXF.Dp;
                com.baidu.adp.lib.util.k.showToast(m11getInst, xVar3.getErrorString());
            }
        }
    }
}
