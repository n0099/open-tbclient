package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface aj {
    void a(w wVar);

    void a(com.baidu.adp.widget.ListView.x xVar);

    void a(ao aoVar);

    int adz();

    int aeA();

    int aeB();

    int aeC();

    int aeD();

    int aeE();

    HashMap<Integer, bk> aey();

    void aez();

    void ax(String str, String str2);

    void b(ArrayList<v> arrayList, p pVar);

    void ee(boolean z);

    List<v> getDatas();

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);
}
