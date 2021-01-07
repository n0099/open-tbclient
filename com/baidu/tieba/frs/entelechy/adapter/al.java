package com.baidu.tieba.frs.entelechy.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public interface al {
    void a(com.baidu.adp.widget.ListView.w wVar);

    void a(com.baidu.tieba.frs.f fVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bz> cIX();

    int cIY();

    void cIZ();

    int cJa();

    int cJb();

    void cJc();

    List<com.baidu.adp.widget.ListView.n> getDatas();

    void notifyDataSetChanged();

    void onDestory();

    void qZ(boolean z);

    boolean r(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
