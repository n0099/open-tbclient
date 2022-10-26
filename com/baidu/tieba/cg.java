package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface cg {
    public static final ServiceReference a = new ServiceReference("tbadkcore", "IHttpsExperiment");

    boolean isIpv6();

    boolean isSwitchOn();
}
