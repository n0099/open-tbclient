package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes6.dex */
public interface ge5 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    NewsRemindMessage a();

    void b(boolean z);

    p7c<Boolean> c();

    boolean d();

    void e();

    boolean f();

    p7c<NewsRemindMessage> g();
}
