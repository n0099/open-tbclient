package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public interface gx7 {
    void a(String str);

    void b();

    int c();

    void d(zi ziVar);

    void e();

    List<pi> f();

    void g(ArrayList<pi> arrayList, FrsViewData frsViewData);

    HashMap<Integer, ThreadData> h();

    int i();

    int j();

    boolean k(BdUniqueId bdUniqueId);

    void l(bs7 bs7Var);

    void m(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    void setFromCDN(boolean z);
}
