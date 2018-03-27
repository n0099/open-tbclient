package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public interface s {
    void a(com.baidu.tieba.frs.b bVar);

    int awi();

    HashMap<Integer, bd> axo();

    void axp();

    int axq();

    int axr();

    int axs();

    int axt();

    void axu();

    void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.m mVar);

    void gd(boolean z);

    List<com.baidu.adp.widget.ListView.i> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar);
}
