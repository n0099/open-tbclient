package com.baidu.tieba;
/* loaded from: classes6.dex */
public interface foc<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
