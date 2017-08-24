package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface q {
    void a(com.baidu.tieba.frs.b bVar);

    int ags();

    HashMap<Integer, bl> ahc();

    void ahd();

    int ahe();

    int ahf();

    int ahg();

    int ahh();

    void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar);

    void cH(boolean z);

    void eR(boolean z);

    List<com.baidu.adp.widget.ListView.f> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void reInit();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar);
}
