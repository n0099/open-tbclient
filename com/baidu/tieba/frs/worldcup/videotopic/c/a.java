package com.baidu.tieba.frs.worldcup.videotopic.c;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public interface a {
    void a(d.a aVar, ArrayList<h> arrayList);

    void aBl();

    String getForumId();

    boolean hasMore();

    void onDestroy();

    void onRefresh();
}
