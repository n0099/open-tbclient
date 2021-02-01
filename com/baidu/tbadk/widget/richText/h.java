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

    int bIg();

    com.baidu.adp.lib.d.b<ImageView> bIh();

    com.baidu.adp.lib.d.b<TextView> bIi();

    com.baidu.adp.lib.d.b<GifView> bIj();

    com.baidu.adp.lib.d.b<View> bIk();

    com.baidu.adp.lib.d.b<LinearLayout> bIl();

    com.baidu.adp.lib.d.b<RelativeLayout> bIm();

    void g(Context context, String str, boolean z);

    ListView getListView();

    void u(Context context, String str, String str2);
}
