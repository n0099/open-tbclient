package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.w;
/* loaded from: classes.dex */
public class i {
    private final View.OnTouchListener aGS = new j(this);
    private boolean bQA;
    private w.a bQB;
    private ForumHeadVideoView bQy;
    private GestureDetector bQz;
    private Context mContext;

    public i(Context context, ForumHeadVideoView forumHeadVideoView, w.a aVar) {
        this.bQA = false;
        this.mContext = context;
        this.bQy = forumHeadVideoView;
        this.bQB = aVar;
        this.bQA = ZF();
        ZE();
    }

    private void ZE() {
        if (this.bQz == null && this.mContext != null && this.bQy != null) {
            this.bQz = new GestureDetector(this.mContext, new k(this));
            this.bQy.setOnTouchListener(this.aGS);
        }
    }

    public boolean ZF() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
