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
    int Rh();

    com.baidu.adp.lib.e.b<ImageView> Ri();

    com.baidu.adp.lib.e.b<TextView> Rj();

    com.baidu.adp.lib.e.b<GifView> Rk();

    com.baidu.adp.lib.e.b<View> Rl();

    com.baidu.adp.lib.e.b<LinearLayout> Rm();

    com.baidu.adp.lib.e.b<RelativeLayout> Rn();

    void W(Context context, String str);

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void aa(Context context, String str);

    void ab(Context context, String str);

    ListView getListView();

    void h(Context context, String str, String str2);
}
