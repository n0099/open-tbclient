package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes5.dex */
public interface b95 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    NewsRemindMessage a();

    void b(boolean z);

    h6c<Boolean> c();

    boolean d();

    void e();

    boolean f();

    h6c<NewsRemindMessage> g();
}
