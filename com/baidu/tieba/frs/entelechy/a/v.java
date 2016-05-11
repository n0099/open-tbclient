package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.frs.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public interface v {
    int Px();

    int Rt();

    int Ru();

    int Rv();

    int Rw();

    int Ry();

    HashMap<Integer, ax> Sv();

    void Sw();

    int Sx();

    int Sy();

    int Sz();

    void a(w wVar);

    void a(x xVar);

    void a(bi biVar);

    void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.o oVar);

    com.baidu.adp.widget.ListView.v at(int i);

    void av(String str, String str2);

    void cG(boolean z);

    List<com.baidu.adp.widget.ListView.v> getDatas();

    void l(View.OnClickListener onClickListener);

    void m(View.OnClickListener onClickListener);

    void n(View.OnClickListener onClickListener);

    void notifyDataSetChanged();

    void onDestory();

    void setFromCDN(boolean z);
}
