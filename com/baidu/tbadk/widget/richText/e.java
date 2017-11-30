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
    int JV();

    com.baidu.adp.lib.e.b<ImageView> JW();

    com.baidu.adp.lib.e.b<TextView> JX();

    com.baidu.adp.lib.e.b<GifView> JY();

    com.baidu.adp.lib.e.b<View> JZ();

    com.baidu.adp.lib.e.b<LinearLayout> Ka();

    com.baidu.adp.lib.e.b<RelativeLayout> Kb();

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void aa(Context context, String str);

    void g(Context context, String str, String str2);

    ListView getListView();
}
