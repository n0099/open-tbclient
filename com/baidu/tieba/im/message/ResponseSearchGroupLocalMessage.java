package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.BaseGroupData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseSearchGroupLocalMessage extends CustomResponsedMessage<Object> {
    private long a;
    private List<BaseGroupData> b;
    private List<com.baidu.adp.lib.cache.t<String>> c;

    public ResponseSearchGroupLocalMessage() {
        super(2001202);
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public ResponseSearchGroupLocalMessage(int i) {
        super(i);
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final void a(List<com.baidu.adp.lib.cache.t<String>> list) {
        this.c = list;
    }

    public final void a(long j) {
        this.a = j;
    }
}
