package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface r {
    void a(com.baidu.tieba.frs.b bVar);

    int ahS();

    HashMap<Integer, bh> aiY();

    void aiZ();

    int aja();

    int ajb();

    int ajc();

    int ajd();

    void aje();

    void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar);

    void cI(boolean z);

    void eR(boolean z);

    List<com.baidu.adp.widget.ListView.f> getDatas();

    boolean l(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar);
}
