package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes4.dex */
public interface dw3<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    dw3 c(Context context, DownloadParams downloadParams, yv3 yv3Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}
