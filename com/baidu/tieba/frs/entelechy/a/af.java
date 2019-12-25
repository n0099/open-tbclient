package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public interface af {
    void a(com.baidu.adp.widget.ListView.s sVar);

    void a(com.baidu.tieba.frs.d dVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bj> bEu();

    int bEv();

    void bEw();

    int bEx();

    int bEy();

    void bEz();

    List<com.baidu.adp.widget.ListView.m> getDatas();

    void lA(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    boolean p(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
