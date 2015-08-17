package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ExitTiebaToKuangMessage extends CustomResponsedMessage<Integer> {
    public ExitTiebaToKuangMessage() {
        super(CmdConfigCustom.CMD_EXIT_TIEBA_TO_KUANG);
    }
}
