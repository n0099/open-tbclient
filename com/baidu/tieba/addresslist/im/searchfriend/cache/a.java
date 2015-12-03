package com.baidu.tieba.addresslist.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.addresslist.relationship.f;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_OFFICIAL_ACCOUNT, f.HK().HM());
    }
}
