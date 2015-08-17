package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ReLoginFromKuangMessage extends CustomResponsedMessage<Boolean> {
    public ReLoginFromKuangMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG, bool);
    }
}
