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
    void at(Context context, String str);

    void au(Context context, String str);

    void av(Context context, String str);

    void aw(Context context, String str);

    void ax(Context context, String str);

    int bzr();

    com.baidu.adp.lib.d.b<ImageView> bzs();

    com.baidu.adp.lib.d.b<TextView> bzt();

    com.baidu.adp.lib.d.b<GifView> bzu();

    com.baidu.adp.lib.d.b<View> bzv();

    com.baidu.adp.lib.d.b<LinearLayout> bzw();

    com.baidu.adp.lib.d.b<RelativeLayout> bzx();

    void f(Context context, String str, boolean z);

    ListView getListView();

    void r(Context context, String str, String str2);
}
