package com.baidu.tieba;
/* loaded from: classes3.dex */
public interface c3a<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
