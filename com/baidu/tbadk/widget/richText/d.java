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
    int Is();

    com.baidu.adp.lib.e.b<ImageView> It();

    com.baidu.adp.lib.e.b<TextView> Iu();

    com.baidu.adp.lib.e.b<GifView> Iv();

    com.baidu.adp.lib.e.b<View> Iw();

    com.baidu.adp.lib.e.b<LinearLayout> Ix();

    com.baidu.adp.lib.e.b<View> Iy();

    void U(Context context, String str);

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void f(Context context, String str, String str2);

    ListView getListView();
}
