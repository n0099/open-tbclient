package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
public interface d {
    void A(Context context, String str);

    void B(Context context, String str);

    void C(Context context, String str);

    void D(Context context, String str);

    void E(Context context, String str);

    void F(Context context, String str);

    int HS();

    com.baidu.adp.lib.e.b<ImageView> HT();

    com.baidu.adp.lib.e.b<TextView> HU();

    com.baidu.adp.lib.e.b<GifView> HV();

    com.baidu.adp.lib.e.b<View> HW();

    com.baidu.adp.lib.e.b<LinearLayout> HX();

    com.baidu.adp.lib.e.b<View> HY();

    void d(Context context, String str, String str2);

    ListView getListView();
}
