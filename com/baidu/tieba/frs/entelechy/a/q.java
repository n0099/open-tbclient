package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface q {
    void a(com.baidu.tieba.frs.b bVar);

    HashMap<Integer, bj> aiZ();

    int aib();

    void aja();

    int ajb();

    int ajc();

    int ajd();

    int aje();

    void ajf();

    void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar);

    void cK(boolean z);

    void eZ(boolean z);

    List<com.baidu.adp.widget.ListView.f> getDatas();

    boolean m(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar);
}
