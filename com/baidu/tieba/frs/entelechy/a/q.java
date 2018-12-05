package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public interface q {
    void a(com.baidu.tieba.frs.d dVar);

    HashMap<Integer, bb> aDM();

    void aDN();

    int aDO();

    int aDP();

    int aDQ();

    void aDR();

    void b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar);

    List<com.baidu.adp.widget.ListView.h> getDatas();

    void ha(boolean z);

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar);
}
