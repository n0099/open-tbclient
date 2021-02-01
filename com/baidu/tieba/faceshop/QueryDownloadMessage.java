package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.List;
/* loaded from: classes9.dex */
public class QueryDownloadMessage extends CustomResponsedMessage<List<String>> {
    public QueryDownloadMessage(List<String> list) {
        super(CmdConfigCustom.CMD_QEURY_FILE_DOWNLOAD, list);
    }
}
