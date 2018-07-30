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
    int Oe();

    com.baidu.adp.lib.e.b<ImageView> Of();

    com.baidu.adp.lib.e.b<TextView> Og();

    com.baidu.adp.lib.e.b<GifView> Oh();

    com.baidu.adp.lib.e.b<View> Oi();

    com.baidu.adp.lib.e.b<LinearLayout> Oj();

    com.baidu.adp.lib.e.b<RelativeLayout> Ok();

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void aa(Context context, String str);

    void ab(Context context, String str);

    void f(Context context, String str, boolean z);

    ListView getListView();

    void h(Context context, String str, String str2);
}
