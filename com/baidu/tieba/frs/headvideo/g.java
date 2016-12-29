package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import com.baidu.tieba.frs.headvideo.u;
/* loaded from: classes.dex */
public class g {
    private final View.OnTouchListener aJN = new h(this);
    private ForumHeadVideoView bKN;
    private GestureDetector bKO;
    private boolean bKP;
    private u.a bKQ;
    private Context mContext;

    public g(Context context, ForumHeadVideoView forumHeadVideoView, u.a aVar) {
        this.bKP = false;
        this.mContext = context;
        this.bKN = forumHeadVideoView;
        this.bKQ = aVar;
        this.bKP = aas();
        aar();
    }

    private void aar() {
        if (this.bKO == null && this.mContext != null && this.bKN != null) {
            this.bKO = new GestureDetector(this.mContext, new i(this));
            this.bKN.setOnTouchListener(this.aJN);
        }
    }

    public boolean aas() {
        if (Build.MODEL == null) {
            return false;
        }
        String str = Build.MODEL;
        return "MI 5".equals(str) || "MX4".equals(str);
    }
}
