package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class QueryDownloadMessage extends CustomResponsedMessage<List<String>> {
    public QueryDownloadMessage(List<String> list) {
        super(2001119, list);
    }
}
