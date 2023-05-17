package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface i7b<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
