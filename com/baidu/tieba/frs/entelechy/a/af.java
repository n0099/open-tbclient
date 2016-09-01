package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface af {
    void a(com.baidu.adp.widget.ListView.w wVar);

    void a(com.baidu.adp.widget.ListView.x xVar);

    void a(ba baVar);

    void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar);

    HashMap<Integer, bg> acX();

    void acY();

    int acZ();

    int ach();

    int ada();

    int adb();

    int adc();

    int add();

    void aw(String str, String str2);

    void dT(boolean z);

    boolean k(BdUniqueId bdUniqueId);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);
}
