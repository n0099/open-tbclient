package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.Cdo;
/* loaded from: classes.dex */
public class FrsHotThreadStatic {
    static {
        Cdo.Ms().fH(2);
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_FRS_ADD_MODEL));
    }
}
