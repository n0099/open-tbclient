package com.baidu.tbadk.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.List;
/* loaded from: classes.dex */
public class QueryDownloadMessage extends CustomResponsedMessage<List<String>> {
    public QueryDownloadMessage(List<String> list) {
        super(MessageTypes.CMD_QEURY_FILE_DOWNLOAD, list);
    }
}
