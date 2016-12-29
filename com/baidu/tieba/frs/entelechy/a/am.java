package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface am {
    int XS();

    HashMap<Integer, bg> YS();

    void YT();

    int YU();

    int YV();

    int YW();

    int YX();

    int YY();

    void a(com.baidu.adp.widget.ListView.w wVar);

    void a(com.baidu.adp.widget.ListView.x xVar);

    void a(as asVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.o oVar);

    void dO(boolean z);

    List<com.baidu.adp.widget.ListView.v> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);
}
