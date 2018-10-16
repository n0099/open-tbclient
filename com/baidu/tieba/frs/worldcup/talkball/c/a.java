package com.baidu.tieba.frs.worldcup.talkball.c;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.frs.worldcup.talkball.model.c;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public interface a {
    void a(d.a aVar, ArrayList<h> arrayList, c cVar);

    void aHw();

    void aHx();

    void aHy();

    String getForumId();

    boolean hasMore();

    void onDestroy();

    void onRefresh();
}
