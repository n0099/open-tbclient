package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public interface dn7 {
    void a(String str);

    void b();

    int c();

    void d(mn mnVar);

    void e();

    List<cn> f();

    void g(ArrayList<cn> arrayList, FrsViewData frsViewData);

    HashMap<Integer, ThreadData> h();

    int i();

    int j();

    boolean k(BdUniqueId bdUniqueId);

    void l(ai7 ai7Var);

    void m(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    void setFromCDN(boolean z);
}
