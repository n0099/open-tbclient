package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes22.dex */
public interface am {
    void a(com.baidu.adp.widget.ListView.ab abVar);

    void a(com.baidu.tieba.frs.f fVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData);

    HashMap<Integer, by> cFX();

    int cFY();

    void cFZ();

    int cGa();

    int cGb();

    void cGc();

    List<com.baidu.adp.widget.ListView.q> getDatas();

    void notifyDataSetChanged();

    void onDestory();

    void qB(boolean z);

    boolean r(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
