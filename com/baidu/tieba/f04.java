package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes5.dex */
public interface f04<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    f04 c(Context context, DownloadParams downloadParams, a04 a04Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}
