package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface ai {
    int Xk();

    HashMap<Integer, be> Yl();

    void Ym();

    int Yn();

    int Yo();

    int Yp();

    int Yq();

    int Yr();

    void a(com.baidu.adp.widget.ListView.w wVar);

    void a(com.baidu.adp.widget.ListView.x xVar);

    void a(ba baVar);

    void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar);

    void av(String str, String str2);

    com.baidu.adp.widget.ListView.v aw(int i);

    void dx(boolean z);

    boolean k(BdUniqueId bdUniqueId);

    void m(View.OnClickListener onClickListener);

    void n(View.OnClickListener onClickListener);

    void notifyDataSetChanged();

    void onDestory();

    void setForumName(String str);

    void setFromCDN(boolean z);
}
