package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.w;
/* loaded from: classes.dex */
public class i {
    private final View.OnTouchListener aGb = new j(this);
    private ForumHeadVideoView bOM;
    private GestureDetector bON;
    private boolean bOO;
    private w.a bOP;
    private Context mContext;

    public i(Context context, ForumHeadVideoView forumHeadVideoView, w.a aVar) {
        this.bOO = false;
        this.mContext = context;
        this.bOM = forumHeadVideoView;
        this.bOP = aVar;
        this.bOO = Zj();
        Zi();
    }

    private void Zi() {
        if (this.bON == null && this.mContext != null && this.bOM != null) {
            this.bON = new GestureDetector(this.mContext, new k(this));
            this.bOM.setOnTouchListener(this.aGb);
        }
    }

    public boolean Zj() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
