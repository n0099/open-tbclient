package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface af {
    void a(com.baidu.adp.widget.ListView.w wVar);

    void a(com.baidu.adp.widget.ListView.x xVar);

    void a(ba baVar);

    void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar);

    int acu();

    HashMap<Integer, bi> adl();

    void adm();

    int adn();

    int ado();

    int adp();

    int adq();

    int adr();

    void aw(String str, String str2);

    void dU(boolean z);

    List<com.baidu.adp.widget.ListView.v> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);
}
