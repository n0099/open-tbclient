package com.baidu.tieba.addresslist.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestRecommendReadMessage extends CustomMessage<Object> {
    public RequestRecommendReadMessage() {
        super(CmdConfigCustom.CMD_REQUEST_RECOMMEND_READ_CACHE);
    }
}
