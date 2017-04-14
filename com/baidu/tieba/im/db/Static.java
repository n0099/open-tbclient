package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(new n(CmdConfigCustom.IM_DELETE_IM_DB));
    }
}
