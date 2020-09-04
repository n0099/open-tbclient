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
public interface i {
    void aq(Context context, String str);

    void ar(Context context, String str);

    void as(Context context, String str);

    void at(Context context, String str);

    void au(Context context, String str);

    int byi();

    com.baidu.adp.lib.d.b<ImageView> byj();

    com.baidu.adp.lib.d.b<TextView> byk();

    com.baidu.adp.lib.d.b<GifView> byl();

    com.baidu.adp.lib.d.b<View> bym();

    com.baidu.adp.lib.d.b<LinearLayout> byn();

    com.baidu.adp.lib.d.b<RelativeLayout> byo();

    void f(Context context, String str, boolean z);

    ListView getListView();

    void r(Context context, String str, String str2);
}
