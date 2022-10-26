package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface ba5 {
    public static final ServiceReference a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b(List list, Map map);
    }

    ba5 a(TbPageContext tbPageContext, long j, String str);

    void b(int i, bt4 bt4Var, long j);

    void c(a aVar);
}
