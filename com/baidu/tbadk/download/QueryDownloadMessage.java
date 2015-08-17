package com.baidu.tbadk.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class QueryDownloadMessage extends CustomResponsedMessage<List<String>> {
    public QueryDownloadMessage(List<String> list) {
        super(CmdConfigCustom.CMD_QEURY_FILE_DOWNLOAD, list);
    }
}
