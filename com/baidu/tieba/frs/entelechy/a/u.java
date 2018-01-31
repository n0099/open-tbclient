package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public interface u {
    void a(com.baidu.tieba.frs.b bVar);

    int avj();

    HashMap<Integer, bd> awo();

    void awp();

    int awq();

    int awr();

    int aws();

    int awt();

    void awu();

    void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar);

    void fV(boolean z);

    List<com.baidu.adp.widget.ListView.i> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(o oVar);
}
