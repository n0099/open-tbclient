package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public interface aa {
    void a(com.baidu.adp.widget.ListView.s sVar);

    void a(com.baidu.tieba.frs.d dVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bh> bmY();

    int bmZ();

    void bna();

    int bnb();

    int bnc();

    void bnd();

    List<com.baidu.adp.widget.ListView.m> getDatas();

    void ko(boolean z);

    void notifyDataSetChanged();

    boolean o(BdUniqueId bdUniqueId);

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);
}
