package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.g {
    final /* synthetic */ k bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(k kVar) {
        this.bvO = kVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.y yVar;
        com.baidu.tieba.tbadkCore.y yVar2;
        com.baidu.tieba.tbadkCore.y yVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.y yVar4;
        yVar = this.bvO.DR;
        if (AntiHelper.rg(yVar.getErrorCode())) {
            Activity pageActivity = this.bvO.aNO.getPageContext().getPageActivity();
            yVar4 = this.bvO.DR;
            AntiHelper.O(pageActivity, yVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.bvO.bvw;
            str = this.bvO.bvy;
            cVar.cS(!StringUtils.isNull(str));
        } else {
            yVar2 = this.bvO.DR;
            if (!StringUtils.isNull(yVar2.getErrorString())) {
                TbadkCoreApplication m10getInst = TbadkCoreApplication.m10getInst();
                yVar3 = this.bvO.DR;
                com.baidu.adp.lib.util.k.showToast(m10getInst, yVar3.getErrorString());
            }
        }
    }
}
