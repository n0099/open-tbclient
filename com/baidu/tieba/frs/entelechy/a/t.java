package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface t {
    void a(com.baidu.tieba.frs.b bVar);

    int aka();

    HashMap<Integer, bh> all();

    void alm();

    int aln();

    int alo();

    int alp();

    int alq();

    void alr();

    void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.j jVar);

    void cD(boolean z);

    void eM(boolean z);

    List<com.baidu.adp.widget.ListView.f> getDatas();

    boolean l(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar);
}
