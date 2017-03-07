package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface am {
    int ZY();

    void a(ar arVar);

    HashMap<Integer, bj> aaR();

    void aaS();

    int aaT();

    int aaU();

    int aaV();

    int aaW();

    int aaX();

    void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, n nVar);

    void dT(boolean z);

    List<com.baidu.adp.widget.ListView.v> getDatas();

    boolean l(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar);

    void setOnAdapterItemLongClickListener(com.baidu.adp.widget.ListView.x xVar);
}
