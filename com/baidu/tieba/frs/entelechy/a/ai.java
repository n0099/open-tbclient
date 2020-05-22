package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public interface ai {
    void a(com.baidu.adp.widget.ListView.x xVar);

    void a(com.baidu.tieba.frs.d dVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bk> bYm();

    int bYn();

    void bYo();

    int bYp();

    int bYq();

    void bYr();

    List<com.baidu.adp.widget.ListView.o> getDatas();

    void notifyDataSetChanged();

    void ns(boolean z);

    void onDestory();

    boolean r(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
