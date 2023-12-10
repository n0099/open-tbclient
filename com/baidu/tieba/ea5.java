package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes5.dex */
public interface ea5 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    NewsRemindMessage a();

    void b(boolean z);

    eoc<Boolean> c();

    boolean d();

    void e();

    boolean f();

    eoc<NewsRemindMessage> g();
}
