package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface eoc<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
