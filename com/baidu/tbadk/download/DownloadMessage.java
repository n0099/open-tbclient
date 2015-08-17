package com.baidu.tbadk.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class DownloadMessage extends CustomResponsedMessage<List<DownloadData>> {
    public DownloadMessage(List<DownloadData> list) {
        super(CmdConfigCustom.CMD_FILE_DOWNLOAD, list);
    }
}
