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
    int Rj();

    com.baidu.adp.lib.e.b<ImageView> Rk();

    com.baidu.adp.lib.e.b<TextView> Rl();

    com.baidu.adp.lib.e.b<GifView> Rm();

    com.baidu.adp.lib.e.b<View> Rn();

    com.baidu.adp.lib.e.b<LinearLayout> Ro();

    com.baidu.adp.lib.e.b<RelativeLayout> Rp();

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void aa(Context context, String str);

    ListView getListView();

    void h(Context context, String str, String str2);
}
