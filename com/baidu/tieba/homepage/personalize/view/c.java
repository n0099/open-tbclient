package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.h;
/* loaded from: classes22.dex */
public class c extends h {
    private f jAW;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        this.jAW = new f(this.mContext, this.aiw);
        this.jAW.setStageType("2001");
        return this.jAW;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
        if (this.jAW != null) {
            this.jAW.onPause();
        }
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
        if (this.jAW != null) {
            this.jAW.onResume();
        }
    }
}
