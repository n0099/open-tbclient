package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface ad {
    int WS();

    HashMap<Integer, az> XS();

    void XT();

    int XU();

    int XV();

    int XW();

    int XX();

    int XY();

    void a(com.baidu.adp.widget.ListView.w wVar);

    void a(com.baidu.adp.widget.ListView.x xVar);

    void a(ba baVar);

    void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar);

    com.baidu.adp.widget.ListView.v at(int i);

    void av(String str, String str2);

    void db(boolean z);

    boolean k(BdUniqueId bdUniqueId);

    void m(View.OnClickListener onClickListener);

    void n(View.OnClickListener onClickListener);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);
}
