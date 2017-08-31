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
    int IZ();

    com.baidu.adp.lib.e.b<ImageView> Ja();

    com.baidu.adp.lib.e.b<TextView> Jb();

    com.baidu.adp.lib.e.b<GifView> Jc();

    com.baidu.adp.lib.e.b<View> Jd();

    com.baidu.adp.lib.e.b<LinearLayout> Je();

    com.baidu.adp.lib.e.b<View> Jf();

    void Z(Context context, String str);

    void aa(Context context, String str);

    void ab(Context context, String str);

    void ac(Context context, String str);

    void ad(Context context, String str);

    void ae(Context context, String str);

    void f(Context context, String str, String str2);

    ListView getListView();
}
