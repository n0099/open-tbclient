package com.baidu.tieba;
/* loaded from: classes4.dex */
public interface g1b<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
