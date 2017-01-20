package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.t;
/* loaded from: classes.dex */
public class f {
    private final View.OnTouchListener aIu = new g(this);
    private ForumHeadVideoView bRg;
    private GestureDetector bRh;
    private boolean bRi;
    private t.a bRj;
    private Context mContext;

    public f(Context context, ForumHeadVideoView forumHeadVideoView, t.a aVar) {
        this.bRi = false;
        this.mContext = context;
        this.bRg = forumHeadVideoView;
        this.bRj = aVar;
        this.bRi = aby();
        abx();
    }

    private void abx() {
        if (this.bRh == null && this.mContext != null && this.bRg != null) {
            this.bRh = new GestureDetector(this.mContext, new h(this));
            this.bRg.setOnTouchListener(this.aIu);
        }
    }

    public boolean aby() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
