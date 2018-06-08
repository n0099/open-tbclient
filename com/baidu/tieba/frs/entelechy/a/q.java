package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public interface q {
    void a(com.baidu.tieba.frs.b bVar);

    HashMap<Integer, bd> avQ();

    void avR();

    int avS();

    int avT();

    int avU();

    void avV();

    void b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar);

    void fP(boolean z);

    List<com.baidu.adp.widget.ListView.h> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar);
}
