package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface al {
    void a(n nVar);

    HashMap<Integer, bl> abF();

    void abG();

    int abH();

    int abI();

    int abJ();

    int abK();

    int abb();

    void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.n nVar);

    void cv(boolean z);

    void em(boolean z);

    List<com.baidu.adp.widget.ListView.v> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(x xVar);
}
