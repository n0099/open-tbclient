package com.baidu.tieba.frs.entelechy.b;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.h.m;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public interface b {
    int a(int i, l lVar);

    View a(Context context, BdExpandListView bdExpandListView);

    void a(m mVar, o oVar);

    void a(BdExpandListView bdExpandListView, BannerView bannerView);

    void a(BdExpandListView bdExpandListView, com.baidu.tieba.frs.view.c cVar);

    void a(boolean z, d dVar, m mVar, cn cnVar, o oVar);

    void ad(View view);

    BannerView aq(Context context);

    void b(BdExpandListView bdExpandListView, BannerView bannerView);

    boolean gy(int i);
}
