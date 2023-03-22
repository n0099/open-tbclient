package com.baidu.tieba;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes4.dex */
public interface ewa<T> {
    void a(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(T t);
}
