package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.t;
/* loaded from: classes.dex */
public class f {
    private final View.OnTouchListener aNR = new g(this);
    private ForumHeadVideoView bYo;
    private GestureDetector bYp;
    private boolean bYq;
    private t.a bYr;
    private Context mContext;

    public f(Context context, ForumHeadVideoView forumHeadVideoView, t.a aVar) {
        this.bYq = false;
        this.mContext = context;
        this.bYo = forumHeadVideoView;
        this.bYr = aVar;
        this.bYq = acv();
        acu();
    }

    private void acu() {
        if (this.bYp == null && this.mContext != null && this.bYo != null) {
            this.bYp = new GestureDetector(this.mContext, new h(this));
            this.bYo.setOnTouchListener(this.aNR);
        }
    }

    public boolean acv() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
