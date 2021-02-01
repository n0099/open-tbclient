package com.baidu.tieba.frs.entelechy.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public interface al {
    void a(com.baidu.adp.widget.ListView.w wVar);

    void a(com.baidu.tieba.frs.f fVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData);

    HashMap<Integer, cb> cGs();

    int cGt();

    void cGu();

    int cGv();

    int cGw();

    void cGx();

    List<com.baidu.adp.widget.ListView.n> getDatas();

    void notifyDataSetChanged();

    void onDestory();

    boolean r(BdUniqueId bdUniqueId);

    void rf(boolean z);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
