package com.baidu.tieba.godSquare.model.req;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GodSquareCacheRequestMsg extends CustomMessage<Object> {
    public String cacheKey;

    public GodSquareCacheRequestMsg() {
        super(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE);
    }
}
