package com.baidu.tieba;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface fib {

    /* loaded from: classes5.dex */
    public interface a {
        void onCompletion();

        boolean onError(int i, int i2, Object obj);

        boolean onInfo(int i, int i2, Object obj);
    }

    void release();

    void setListener(a aVar);

    void setSource(ArrayList<String> arrayList);

    void start();
}
