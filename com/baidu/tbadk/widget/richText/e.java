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
    int Km();

    com.baidu.adp.lib.e.b<ImageView> Kn();

    com.baidu.adp.lib.e.b<TextView> Ko();

    com.baidu.adp.lib.e.b<GifView> Kp();

    com.baidu.adp.lib.e.b<View> Kq();

    com.baidu.adp.lib.e.b<LinearLayout> Kr();

    com.baidu.adp.lib.e.b<RelativeLayout> Ks();

    void S(Context context, String str);

    void T(Context context, String str);

    void U(Context context, String str);

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void g(Context context, String str, String str2);

    ListView getListView();
}
