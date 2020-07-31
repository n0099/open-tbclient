package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes16.dex */
public interface al {
    void a(com.baidu.adp.widget.ListView.z zVar);

    void a(com.baidu.tieba.frs.f fVar);

    void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData);

    HashMap<Integer, bv> cfc();

    int cfd();

    void cfe();

    int cff();

    int cfg();

    void cfh();

    List<com.baidu.adp.widget.ListView.q> getDatas();

    void notifyDataSetChanged();

    void oj(boolean z);

    void onDestory();

    boolean s(BdUniqueId bdUniqueId);

    void setForumName(String str);

    void setFromCDN(boolean z);
}
