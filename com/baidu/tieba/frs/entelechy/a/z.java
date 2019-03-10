package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public interface z {
    void a(com.baidu.tieba.frs.d dVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bg> bfB();

    int bfC();

    void bfD();

    int bfE();

    int bfF();

    void bfG();

    List<com.baidu.adp.widget.ListView.m> getDatas();

    void jC(boolean z);

    boolean l(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(s sVar);
}
