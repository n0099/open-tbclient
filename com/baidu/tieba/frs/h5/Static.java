package com.baidu.tieba.frs.h5;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.eg;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(new i(CmdConfigCustom.CMD_FRS_ADD_ADAPTER));
        MessageManager.getInstance().registerListener(new j(CmdConfigCustom.CMD_FRS_ADD_MODEL));
        eg.Oy().ge(100);
    }
}
