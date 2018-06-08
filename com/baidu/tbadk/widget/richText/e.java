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
    int NL();

    com.baidu.adp.lib.e.b<ImageView> NM();

    com.baidu.adp.lib.e.b<TextView> NN();

    com.baidu.adp.lib.e.b<GifView> NO();

    com.baidu.adp.lib.e.b<View> NP();

    com.baidu.adp.lib.e.b<LinearLayout> NQ();

    com.baidu.adp.lib.e.b<RelativeLayout> NR();

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void f(Context context, String str, boolean z);

    ListView getListView();

    void h(Context context, String str, String str2);
}
