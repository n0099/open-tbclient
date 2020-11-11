package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes22.dex */
public interface al {
    void a(com.baidu.adp.widget.ListView.ab abVar);

    void a(com.baidu.tieba.frs.f fVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bw> cCa();

    int cCb();

    void cCc();

    int cCd();

    int cCe();

    void cCf();

    List<com.baidu.adp.widget.ListView.q> getDatas();

    void notifyDataSetChanged();

    void onDestory();

    void qb(boolean z);

    boolean r(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
