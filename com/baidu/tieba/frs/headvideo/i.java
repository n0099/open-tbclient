package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.w;
/* loaded from: classes.dex */
public class i {
    private final View.OnTouchListener aJD = new j(this);
    private ForumHeadVideoView cbI;
    private GestureDetector cbJ;
    private boolean cbK;
    private w.a cbL;
    private Context mContext;

    public i(Context context, ForumHeadVideoView forumHeadVideoView, w.a aVar) {
        this.cbK = false;
        this.mContext = context;
        this.cbI = forumHeadVideoView;
        this.cbL = aVar;
        this.cbK = aeE();
        aeD();
    }

    private void aeD() {
        if (this.cbJ == null && this.mContext != null && this.cbI != null) {
            this.cbJ = new GestureDetector(this.mContext, new k(this));
            this.cbI.setOnTouchListener(this.aJD);
        }
    }

    public boolean aeE() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
