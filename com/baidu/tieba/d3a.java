package com.baidu.tieba;
/* loaded from: classes4.dex */
public interface d3a<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
