package com.baidu.tieba.emotion.editortool;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(new v(CmdConfigCustom.EMOTION_COLLECT_GROUPS));
    }
}
