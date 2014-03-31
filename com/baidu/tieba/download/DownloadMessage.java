package com.baidu.tieba.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class DownloadMessage extends CustomResponsedMessage<List<a>> {
    public DownloadMessage(List<a> list) {
        super(2001122, list);
    }
}
