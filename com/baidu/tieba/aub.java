package com.baidu.tieba;

import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface aub {
    public static final ServiceReference a = new ServiceReference("voyager", HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM);

    void a();

    void b();
}
