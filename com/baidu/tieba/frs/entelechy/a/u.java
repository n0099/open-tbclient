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

    int ave();

    HashMap<Integer, bd> awj();

    void awk();

    int awl();

    int awm();

    int awn();

    int awo();

    void awp();

    void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar);

    void fT(boolean z);

    List<com.baidu.adp.widget.ListView.i> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(o oVar);
}
