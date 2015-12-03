package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.address.IAddressListResTool;
/* loaded from: classes.dex */
class n implements CustomMessageTask.CustomRunnable<IAddressListResTool> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<IAddressListResTool> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ADDRESS_LIST_RES_TOOL, new g());
    }
}
