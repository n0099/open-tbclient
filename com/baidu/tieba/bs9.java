package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import com.baidu.tieba.bt9;
import com.baidu.tieba.video.VideoItemModel;
/* loaded from: classes5.dex */
public interface bs9 {
    void onDestroy();

    void onPause();

    void onPrimary(boolean z);

    void onUserVisibleHint(boolean z);

    void onViewClick();

    void onViewDoubleClick();

    void onViewDragToRight();

    void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6);

    void setPageChangeHandler(bt9.a aVar, int i);

    void updateTiebaData(int i, VideoItemModel videoItemModel);
}
