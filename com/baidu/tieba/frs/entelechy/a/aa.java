package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public interface aa {
    void a(com.baidu.tieba.frs.d dVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bg> bmU();

    int bmV();

    void bmW();

    int bmX();

    int bmY();

    void bmZ();

    List<com.baidu.adp.widget.ListView.m> getDatas();

    void ko(boolean z);

    boolean m(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar);
}
