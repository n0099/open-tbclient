package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface am {
    void a(at atVar);

    int abx();

    HashMap<Integer, bi> acq();

    void acr();

    int acs();

    int act();

    int acu();

    int acv();

    void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, n nVar);

    void ef(boolean z);

    List<com.baidu.adp.widget.ListView.v> getDatas();

    boolean l(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar);

    void setOnAdapterItemLongClickListener(com.baidu.adp.widget.ListView.x xVar);
}
