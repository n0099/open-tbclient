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
    int Jc();

    com.baidu.adp.lib.e.b<ImageView> Jd();

    com.baidu.adp.lib.e.b<TextView> Je();

    com.baidu.adp.lib.e.b<GifView> Jf();

    com.baidu.adp.lib.e.b<View> Jg();

    com.baidu.adp.lib.e.b<LinearLayout> Jh();

    com.baidu.adp.lib.e.b<RelativeLayout> Ji();

    void U(Context context, String str);

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void g(Context context, String str, String str2);

    ListView getListView();
}
