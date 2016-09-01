package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.w;
/* loaded from: classes.dex */
public class i {
    private final View.OnTouchListener aKe = new j(this);
    private ForumHeadVideoView cbG;
    private GestureDetector cbH;
    private boolean cbI;
    private w.a cbJ;
    private Context mContext;

    public i(Context context, ForumHeadVideoView forumHeadVideoView, w.a aVar) {
        this.cbI = false;
        this.mContext = context;
        this.cbG = forumHeadVideoView;
        this.cbJ = aVar;
        this.cbI = aep();
        aeo();
    }

    private void aeo() {
        if (this.cbH == null && this.mContext != null && this.cbG != null) {
            this.cbH = new GestureDetector(this.mContext, new k(this));
            this.cbG.setOnTouchListener(this.aKe);
        }
    }

    public boolean aep() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
