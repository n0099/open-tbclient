package com.baidu.tbadk.task;

import com.baidu.adp.framework.task.SocketMessageTask;
/* loaded from: classes2.dex */
public class b extends SocketMessageTask {
    public b(int i) {
        super(i);
        init();
    }

    private void init() {
        setNeedAck(true);
    }
}
