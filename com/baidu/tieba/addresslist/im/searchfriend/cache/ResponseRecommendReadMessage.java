package com.baidu.tieba.addresslist.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseRecommendReadMessage extends CustomResponsedMessage<com.baidu.tieba.addresslist.im.searchfriend.a.a> {
    public ResponseRecommendReadMessage(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        super(CmdConfigCustom.CMD_REQUEST_RECOMMEND_READ_CACHE, aVar);
    }
}
