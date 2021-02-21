package com.baidu.tieba.homepage.lowFlows;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: com.baidu.tieba.homepage.lowFlows.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0747a {
        boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3);
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean BT(int i);

        boolean a(int i, com.baidu.tieba.homepage.lowFlows.message.a aVar);

        boolean b(BdUniqueId bdUniqueId, String str, String str2, String str3);

        void setData(List<n> list);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void BU(int i);

        void loadData();

        void onChangeSkinType(int i);

        void setData(List<n> list);
    }
}
