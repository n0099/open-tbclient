package com.baidu.tbadk.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.List;
/* loaded from: classes.dex */
public class DownloadMessage extends CustomResponsedMessage<List<DownloadData>> {
    public DownloadMessage(List<DownloadData> list) {
        super(MessageTypes.CMD_FILE_DOWNLOAD, list);
    }
}
