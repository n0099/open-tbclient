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
public interface e {
    int Ko();

    com.baidu.adp.lib.e.b<ImageView> Kp();

    com.baidu.adp.lib.e.b<TextView> Kq();

    com.baidu.adp.lib.e.b<GifView> Kr();

    com.baidu.adp.lib.e.b<View> Ks();

    com.baidu.adp.lib.e.b<LinearLayout> Kt();

    com.baidu.adp.lib.e.b<RelativeLayout> Ku();

    void S(Context context, String str);

    void T(Context context, String str);

    void U(Context context, String str);

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void g(Context context, String str, String str2);

    ListView getListView();
}
