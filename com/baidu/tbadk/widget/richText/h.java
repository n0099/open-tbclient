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
public interface h {
    void aA(Context context, String str);

    void aw(Context context, String str);

    void ax(Context context, String str);

    void ay(Context context, String str);

    void az(Context context, String str);

    int bcO();

    com.baidu.adp.lib.d.b<ImageView> bcP();

    com.baidu.adp.lib.d.b<TextView> bcQ();

    com.baidu.adp.lib.d.b<GifView> bcR();

    com.baidu.adp.lib.d.b<View> bcS();

    com.baidu.adp.lib.d.b<LinearLayout> bcT();

    com.baidu.adp.lib.d.b<RelativeLayout> bcU();

    void e(Context context, String str, boolean z);

    ListView getListView();

    void r(Context context, String str, String str2);
}
