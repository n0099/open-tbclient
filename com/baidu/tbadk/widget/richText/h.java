package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
public interface h {
    void aE(Context context, String str);

    void aF(Context context, String str);

    void aG(Context context, String str);

    void aH(Context context, String str);

    void aI(Context context, String str);

    int bIk();

    com.baidu.adp.lib.d.b<ImageView> bIl();

    com.baidu.adp.lib.d.b<TextView> bIm();

    com.baidu.adp.lib.d.b<GifView> bIn();

    com.baidu.adp.lib.d.b<View> bIo();

    com.baidu.adp.lib.d.b<LinearLayout> bIp();

    com.baidu.adp.lib.d.b<RelativeLayout> bIq();

    void g(Context context, String str, boolean z);

    ListView getListView();

    void u(Context context, String str, String str2);
}
