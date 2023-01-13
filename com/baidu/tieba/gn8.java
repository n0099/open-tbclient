package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import com.baidu.tieba.fo8;
import com.baidu.tieba.video.VideoItemModel;
/* loaded from: classes4.dex */
public interface gn8 {
    void onDestroy();

    void onPause();

    void onPrimary(boolean z);

    void onUserVisibleHint(boolean z);

    void onViewClick();

    void onViewDoubleClick();

    void onViewDragToRight();

    void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6);

    void setPageChangeHandler(fo8.a aVar, int i);

    void updateTiebaData(int i, VideoItemModel videoItemModel);
}
