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
public interface d {
    int Ji();

    com.baidu.adp.lib.e.b<ImageView> Jj();

    com.baidu.adp.lib.e.b<TextView> Jk();

    com.baidu.adp.lib.e.b<GifView> Jl();

    com.baidu.adp.lib.e.b<View> Jm();

    com.baidu.adp.lib.e.b<LinearLayout> Jn();

    com.baidu.adp.lib.e.b<RelativeLayout> Jo();

    void Z(Context context, String str);

    void aa(Context context, String str);

    void ab(Context context, String str);

    void ac(Context context, String str);

    void ad(Context context, String str);

    void ae(Context context, String str);

    void g(Context context, String str, String str2);

    ListView getListView();
}
