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
    void aC(Context context, String str);

    void aD(Context context, String str);

    void aE(Context context, String str);

    void aF(Context context, String str);

    void aG(Context context, String str);

    int aSg();

    com.baidu.adp.lib.d.b<ImageView> aSh();

    com.baidu.adp.lib.d.b<TextView> aSi();

    com.baidu.adp.lib.d.b<GifView> aSj();

    com.baidu.adp.lib.d.b<View> aSk();

    com.baidu.adp.lib.d.b<LinearLayout> aSl();

    com.baidu.adp.lib.d.b<RelativeLayout> aSm();

    void d(Context context, String str, boolean z);

    ListView getListView();

    void r(Context context, String str, String str2);
}
