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
    int Ia();

    com.baidu.adp.lib.e.b<ImageView> Ib();

    com.baidu.adp.lib.e.b<TextView> Ic();

    com.baidu.adp.lib.e.b<GifView> Id();

    com.baidu.adp.lib.e.b<View> Ie();

    com.baidu.adp.lib.e.b<LinearLayout> If();

    com.baidu.adp.lib.e.b<View> Ig();

    void Y(Context context, String str);

    void Z(Context context, String str);

    void aa(Context context, String str);

    void ab(Context context, String str);

    void ac(Context context, String str);

    void ad(Context context, String str);

    void f(Context context, String str, String str2);

    ListView getListView();
}
