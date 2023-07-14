package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.view.festivalview.FestivalTipView;
/* loaded from: classes6.dex */
public interface i36 {
    int D();

    ng<TiebaPlusRecommendCard> G1();

    void H(Context context, String str);

    void J(Context context, String str);

    ng<RelativeLayout> R();

    ng<FestivalTipView> U();

    ng<ImageView> V();

    ng<View> W();

    void Y(Context context, String str);

    void Z(Context context, String str, boolean z);

    ng<TextView> Z0();

    void e0(Context context, String str, String str2);

    ListView getListView();

    void i0(Context context, String str);

    void i1(Context context, String str);

    ng<ItemCardView> n0();

    ng<GifView> x();

    ng<LinearLayout> z();
}
