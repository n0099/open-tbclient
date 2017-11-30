package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface u {
    void a(com.baidu.tieba.frs.b bVar);

    int amk();

    void anA();

    HashMap<Integer, bd> anu();

    void anv();

    int anw();

    int anx();

    int any();

    int anz();

    void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, k kVar);

    void cM(boolean z);

    void fi(boolean z);

    List<com.baidu.adp.widget.ListView.f> getDatas();

    boolean l(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);

    void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar);
}
