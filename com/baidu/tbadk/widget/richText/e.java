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
    int RA();

    com.baidu.adp.lib.e.b<ImageView> RB();

    com.baidu.adp.lib.e.b<TextView> RC();

    com.baidu.adp.lib.e.b<GifView> RD();

    com.baidu.adp.lib.e.b<View> RE();

    com.baidu.adp.lib.e.b<LinearLayout> RF();

    com.baidu.adp.lib.e.b<RelativeLayout> RG();

    void ak(Context context, String str);

    void al(Context context, String str);

    void am(Context context, String str);

    void an(Context context, String str);

    void ao(Context context, String str);

    void e(Context context, String str, boolean z);

    ListView getListView();

    void i(Context context, String str, String str2);
}
