package com.baidu.tbadk.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class DownloadMessage extends CustomResponsedMessage<List<DownloadData>> {
    public DownloadMessage(List<DownloadData> list) {
        super(2001118, list);
    }
}
