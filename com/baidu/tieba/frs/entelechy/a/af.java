package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public interface af {
    void a(com.baidu.adp.widget.ListView.s sVar);

    void a(com.baidu.tieba.frs.d dVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bj> bHa();

    int bHb();

    void bHc();

    int bHd();

    int bHe();

    void bHf();

    List<com.baidu.adp.widget.ListView.m> getDatas();

    void lO(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    boolean p(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
