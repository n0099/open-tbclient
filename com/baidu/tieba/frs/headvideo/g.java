package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.u;
/* loaded from: classes.dex */
public class g {
    private final View.OnTouchListener aKw = new h(this);
    private ForumHeadVideoView cfe;
    private GestureDetector cff;
    private boolean cfg;
    private u.a cfh;
    private Context mContext;

    public g(Context context, ForumHeadVideoView forumHeadVideoView, u.a aVar) {
        this.cfg = false;
        this.mContext = context;
        this.cfe = forumHeadVideoView;
        this.cfh = aVar;
        this.cfg = afW();
        afV();
    }

    private void afV() {
        if (this.cff == null && this.mContext != null && this.cfe != null) {
            this.cff = new GestureDetector(this.mContext, new i(this));
            this.cfe.setOnTouchListener(this.aKw);
        }
    }

    public boolean afW() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
