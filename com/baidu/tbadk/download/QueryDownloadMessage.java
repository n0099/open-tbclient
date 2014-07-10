package com.baidu.tbadk.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class QueryDownloadMessage extends CustomResponsedMessage<List<String>> {
    public QueryDownloadMessage(List<String> list) {
        super(2001123, list);
    }
}
