package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public interface al {
    void a(com.baidu.adp.widget.ListView.z zVar);

    void a(com.baidu.tieba.frs.f fVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bu> cbE();

    int cbF();

    void cbG();

    int cbH();

    int cbI();

    void cbJ();

    List<com.baidu.adp.widget.ListView.q> getDatas();

    void nE(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    boolean r(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
