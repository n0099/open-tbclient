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
    int Rt();

    com.baidu.adp.lib.e.b<ImageView> Ru();

    com.baidu.adp.lib.e.b<TextView> Rv();

    com.baidu.adp.lib.e.b<GifView> Rw();

    com.baidu.adp.lib.e.b<View> Rx();

    com.baidu.adp.lib.e.b<LinearLayout> Ry();

    com.baidu.adp.lib.e.b<RelativeLayout> Rz();

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void aa(Context context, String str);

    void ab(Context context, String str);

    void ac(Context context, String str);

    ListView getListView();

    void h(Context context, String str, String str2);
}
