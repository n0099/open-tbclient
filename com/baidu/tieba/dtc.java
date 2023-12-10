package com.baidu.tieba;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes5.dex */
public interface dtc<T> {
    void a(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(T t);
}
