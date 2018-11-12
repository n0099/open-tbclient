package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public interface q {
    void a(com.baidu.tieba.frs.d dVar);

    HashMap<Integer, bb> aCa();

    void aCb();

    int aCc();

    int aCd();

    int aCe();

    void aCf();

    void b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar);

    void gY(boolean z);

    List<com.baidu.adp.widget.ListView.h> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar);
}
