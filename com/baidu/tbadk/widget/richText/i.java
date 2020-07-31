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
    void am(Context context, String str);

    void an(Context context, String str);

    void ao(Context context, String str);

    void ap(Context context, String str);

    void aq(Context context, String str);

    int bpt();

    com.baidu.adp.lib.d.b<ImageView> bpu();

    com.baidu.adp.lib.d.b<TextView> bpv();

    com.baidu.adp.lib.d.b<GifView> bpw();

    com.baidu.adp.lib.d.b<View> bpx();

    com.baidu.adp.lib.d.b<LinearLayout> bpy();

    com.baidu.adp.lib.d.b<RelativeLayout> bpz();

    void f(Context context, String str, boolean z);

    ListView getListView();

    void r(Context context, String str, String str2);
}
