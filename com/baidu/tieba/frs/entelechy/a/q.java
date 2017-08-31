package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface q {
    void a(com.baidu.tieba.frs.b bVar);

    int ahQ();

    HashMap<Integer, bj> aiO();

    void aiP();

    int aiQ();

    int aiR();

    int aiS();

    int aiT();

    void aiU();

    void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar);

    void cK(boolean z);

    void eY(boolean z);

    List<com.baidu.adp.widget.ListView.f> getDatas();

    boolean m(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar);
}
